## Worker Threads in Graphical Applications

A task that may run for a "long" time, even a few seconds,
should normally be run on a separate thread to avoid freezing the UI.

## Example: A Counter Without threads

This example shows what happens if you start a long-running
task on the UI thread.

Clone this code:
[https://github.com/jbrucker/worker-threads](https://github.com/jbrucker/worker-threads)

The program counts from 0 to some limit, in milliseconds.


![Countup Iimer](count-up-timer.png)


**Exercise:** Run the application. Type a number (like 2000) and press "Start". Does the UI behave well?  Can you stop the counter?

You can see the count printed on console, but it is not updated in the window until the counter loop finishes.

**Examine the Code:** There is an inner class named *CountUp* that does the work.

**run()** counts from 0 to totalCount. It updates the UI and the ProgressBar.

**stop()** stops the run() method by setting `cancelled=true`.

Components in the UI are:

| field name    | Usage                       |
|---------------|-----------------------------|
| displayField  | Label at top displays count |
| inputField    | TextField for inputting a number |
| startButton   | Button with label "start" |
| stopButton    | Button with label "stop"  |
| progressBar   | ProgressBar at bottom     |

## Worker Threads and Services

To avoid an unresponsive UI, you should run long-running tasks
in separate *threads*.
These threads are called **worker threads** and appear to run in the background.  

Example of worker threads:
* An app that downloads files. Each download is one or more worker threads.
* A notification service.  It uses a worker thread to periodically check for notifications.  The worker notifies the UI thread when a notification is received.

There are some special problems with using *worker* threads:

* How can you monitor the worker's progress?
* How do you get and display the result?
* How can the worker notify the UI thread of events?
* How can the application cancel the worker thread?

GUI frameworks provide classes for worker threads.
These classes manage communication between background threads and the UI or "Application" thread.

* Android has `AsyncTask` class
* Swing has `SwingWorker` class
* JavaFX has a `Worker` interface with `Task` and `Service` classes


## Using a JavaFX Task

The JavaFX `Task` class is for a one-time job that you want to run in a worker thread.  The `Task` class handles communication between the JavaFX Application Thread (the UI thread) and the worker thread.

The Worker interface and Task class have many methods,
but they are easy to understand if you group them by
what they do.

The main methods of **Task** are:

<table border="1">
<tr>
<td markdown="span" align="center">
**Task&lt;V&gt;**
</td>
<td markdown="span" align="center">
Meaning
</td>
</tr>
<tr align="left" valign="top">
<td markdown="span" align="left">
message: String       
progress: double        
running: boolean    
state: Worker.State    
totalWork: double    
value: V    
</td>
<td markdown="span">
**Properties** 
that are observable. When their value changes the
observers are notified.
For each property xxx there is a method named `xxxProperty()`
to get a reference to it, for example, `task.valueProperty()`

Don't confuse the methods that return the property (`valueProperty()`)
with the method that just returns the current value of the
property, like `getValue()`.
</td>
</tr>
<tr align="left" valign="top">
<td markdown="span" align="left">
 V call()     
</td>
<td markdown="span">
**Required Method:** 
Your Task subclass must override this method.   
In the `call()` method your task does the actual work.

While doing work your task can update `value`
and `progress` so the UI is notified.  
</td>
</tr>
<tr valign="top">
<td markdown="span">
cancel()      
</td>
<td markdown="span">
A **control method**  to cancel the task.
</td>
</tr>
<tr valign="top">
<td markdown="span">
updateMessage(String message)     
updateProgress(workdone, totalwork)    
updateValue(V value)      
</td>
<td markdown="span">
**Services:** 
Call these methods from within your task's `call()` method to
update the message, progress, and value properties.
Listeners will be notified on the UI thread whenever a value changes.
You can also directly **bind** a UI control to a property to
automatically update the control, as shown in the code below. 
</td>
</tr>
<tr valign="top">
<td markdown="span">
getMessage()        
getProgress()    
getState()     
getValue()  
isCancelled()    
isRunning()     
</td>
<td markdown="span">
**Query Methods:**    
Get the value of a property or test if the task is running or cancelled.

`getValue()` returns the current "value" the the result.  If the task
is still running, the "value" has the value set by `updateValue()`.
If the task is finished, this is the value returned by `call()`.
</td>
</tr>
<tr valign="top">
<td markdown="span">
messageProperty()    
progressProperty()    
valueProperty()     
</td>
<td markdown="span">
Get a reference to a property. Use these methods to either add a 
Listener or to bind the property to another property.
</td>
</tr>
</table>

The way to use worker threads is to define a
subclass of **Task** and implement the **call()** method.
The **call()** method can notify the UI of its progress
by calling the *Service* methods `updateValue()`, `updateProgress()`, and `updateMessage()`.

### Do It

Write a **CountUpTask** class to count from 0 to a limit using a worker thread.
This can be an inner class, or top-level class (separate .java file).
The value returned by the call() method will be the total count, which is an int value. So the type parameter is `Integer`.

```java
/** A worker that counts slowly from 0 to a total count. */
public class CountUpTask extends Task<Integer> {
    private int totalcount;
    private int count;

    public CountUpTask(int maxcount) {
        this.totalcount = maxcount;
        this.count = 0;
    }

    @Override
    public Integer call() {
        updateMessage("Starting");
        updateProgress(0, totalcount);
       
        while(count < totalcount) {
            count += 1;
            System.out.println(count); // for testing
            // Notification services from the superclass
            updateValue(count);  
            updateMessage(Integer.toString(count));
            updateProgress(count, totalcount);
            // wait for 1 millisecond (but not very accurate)
            try { Thread.sleep(1); }
            catch (InterruptedException ex) { break; }
        }
        updateProgress(count,totalcount);
        // Return the result of the task
        return count;
    }  
}
```

The work is done in the `call()` method. This method
periodically notifies the UI thread of its progress by calling `updateValue(count)` ,`updateProgress`, and `updateMessage`.

### Running a Worker Thread

In JavaFX, you create a Thread containing your backgound Task 
and start it using `Thread.start()`, or a Java Executor or ExecutorService.
In the controller class add this code:
```java
public class TimerController {

    private CountUpTask worker;

    /** Call this method to start the task. */
    public void startWorker(ActionEvent event) {
        int count = Integer.parseInt(inputField.getText());
        worker = new CountUpTask(count);
        // automatically update the progressBar using worker's progress Property
        progressBar.progressProperty().bind( worker.progressProperty() );
        // update the displayField whenever the value of worker changes:
        ChangeListener<Integer> listener = new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable,
                    Integer oldValue,
                    Integer newValue) {
                displayField.setText(newValue.toString());
            }
        };
        // add the observer (ChangeListener)
        worker.valueProperty().addListener( listener );
        new Thread(worker).start();
    }
}
```

In this method we **bind** the CountUpTask's `progress` property
to the `progress` property of a ProgressBar control. When the worker
task calls updateProgress(), it will cause the ProgressBar to be updated.

To show the count in a TextField we add a `ChangeListener` as observer
of the `value` property.  Whenever the CountUpTask called `updateValue()`
it will notify the ChangeListener (on the UI thread), and give it both
the old and new values as parameters.

We also need a way to stop the task.  Define a stopWorker method to cancel the CountUpTask:
```java
    /** Call this method when Stop button is pressed. */
    public void stopWorker(ActionEvent event) {
        worker.cancel();
    }
```

Finally, add `startWorker` and `stopWorker` as Event Handler methods for the start and stop buttons in the UI.
In the `initialize()` method change the code to:
```java
    @FXML
    public void initialize() {
        startButton.setOnAction( this::startWorker );
        stopButton.setOnAction( this::stopWorker );
    }
```

Run the application.  Is it more responsive?


## Properties

JavaFX uses observable **properties** for values.
The Worker Task class `progress` attribute is an observable Integer Property, and the `value` is also an observable Property.
JavaFX gives you 2 ways to access these fields:

| Method               | What is does |
|----------------------|--------------|
| double getProgress() | get the current value of progress |
| progressProperty()   | get observable Property for progress |
| Integer getValue()   | get current value of worker |
| valueProperty()      | get observable Property for value |


To update the `displayField` whenever the worker updates the value property,
we add an "observer" which in this case is a `ChangeListener`:

```java
ChangeListener<Integer> listener = new ChangeListener<Integer>() {
    @Override
    public void changed(ObservableValue<? extends Integer> observable,
            Integer oldValue, Integer newValue) {
        displayField.setText( newValue.toString() );
    }
};
// add observer to the value Property
worker.valueProperty().addListener( listener );
```

 Many JavaFX controls (and other classes) let you directly "bind" one of their properties to a property on another object.
 Some bindings are one-way and some are bidirectional (either side of the "binding" can update the other).
 So, we "bind" the value of the ProgressBar (a double value) directly to the Worker's progress property (also a double):
```java
progressBar.progressProperty().bind( worker.progressProperty() );
```

This is like adding a ChangeListener to update the progressbar, but a lot less code.

Instead of writing a ChangeListener for the `value` property, we could bind the `displayField` String `text` property directly to the Worker's `message` property (also a String):
```java
displayField.textProperty().bind( worker.messageProperty() );
```

**Note** that this means the Controller *assumes* that the Worker always updates the `message` property with the current value of the counter.  An additional bit of coupling between the two objects.


## Using Hook Methods for Extra Functionality

A **hook** method is an optional method you can override to add additional
functionality to existing code.  They are often used in frameworks.

A Worker task is always in one of these states:

* State.READY - ready to be executed, but not yet run
* State.SCHEDULED - scheduled for execution but not yet running
* State.RUNNING - worker is running
* State.CANCELLED - worker was cancelled
* State.SUCCEEDED - call() method completed successfully, result is ready to be read from the *value* property
* State.FAILED - worker failed, e.g. unexpected problem occured

The Task class has "hook" methods that are called when the worker enters each of these states. When the Worker enters the RUN state, the `running()` is called.  You can override any of these methods to perform extra work when a state is entered.

For example:
```java
@Override
protected void running() {
    System.out.println("Worker is starting!");
    // This method is called on the application thread,
    // so it is safe to update UI components.
}
```

You can also add an EventHandler to be notified when the worker task enters a state.  To be notified when the task finishes successfully, write:
```java
worker.setOnSucceeded( new EventHandler<WorkerStateEvent>() {
         public void handle(WorkerStateEvent event) {
             // do something when worker finishes
         }
     } );

```

## Reference

* JavaFX Tutorial has a section on Task and Service.
