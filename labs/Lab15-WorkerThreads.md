## Using Worker Threads in JavaFX

This code displays a counter with progress bar.
The starter code does not use threads.

Starter code contains these files

| File      | Purpose                      |
|:----------|:-----------------------------|
| Main.java | Run the app using JavaFX     |
| TimerController.java | Controller class, includes Counter inner class. |
| TimerViw.fxml        | FXML for the user interface. |
| CounterTask.java     | A JavaFX worker "Task", you will use this. |

The `TimerView.fmxl` contains a few components for the UI:

* startButton - button with text "Start"
* stopButton  - button with text "Stop"
* inputField  - TextField for user to enter a time in seconds (integer)
* progressBar - ProgressBar to show progress of counter task

The `TimerController` class contains an inner class named `Counter`.
Look at the `run()` method of `Counter`.  
What does it do?

```java
public void run() {
	running = true;
	while(count < totalcount && running) {
		count += 1;
		// update the user interface
		displayCount(count); 
		updateProgress(count, totalcount);
		// wait for 1 millisecond (this is not very accurate)
		try { Thread.sleep(1); } 
		catch (InterruptedException ex) { running = false; }
	}
	running = false;
}
```

As you can see, it just counts in a loop count=1, ..., totalcount.
Each time through the loop it calls methods to update the displayed count
and update a progress bar.

It sleeps one millisecond.

The `stop` method in `Counter` stops the app by setting running to false:
```java
public void stop() {
    running = false;
}
```

If you look at `displayCount` in the TimerController class,
it *should* update the Label to show the current count.
It also prints on the console so you can see it is being invoked.

### Run It

Enter a small number like 10 (seconds) and click "Start".
Does it work?  

Can you stop the application?


### Explanation

The UI becomes unresponsive (you cannot click the Stop button)
and the fields are not updated because the `Counter.run()` method
is tying up the Application thread.

The Application thread never has a chance to update the UI
or handle button click events.

## Use a JavaFx Task for Counter

For long running tasks, you should write a class that **extends**
`javafx.concurrent.Task`.

![class diagram of Task](Task-uml.png)

Your task class should override the abstract `call()` method of `Task`.

When your task wants to update the UI, you can call any of these methods:

* `updateProgress( long workDone, long totalWork)` work done so far
* `updateMessage(String message)` a string message (anything)
* `updateValue(T value)` a partial result 

Calls to these methods will be handled on the Application thread.
In this way, other objects that **listen** to the `message`, `progress`,
or `value` properties of the task will also be updated 
on the Application thread.

### Receiving Updates

The application can receive notifications when a task updates any
of its properties.  The `progress`, `message`, and `value` attributes
of a Task are all JavaFX **Properties**.

Properties in JavaFX are Observable, and one of JavaFX's most powerful
features.

There are 2 ways to receive updates from a Property:

1. Write a `ChangeListener` - a class that implements the `ChangeListener` interface, similar to an event handler for a button.
2. Bind properties together - you can **bind** a property in the UI to another property, so when the other property changes the UI property is automatically updated.

## CounterTask - a Worker Task

To fix the unresponsive UI, we will use a `CounterTask` class
that extends `Task`, and use it in place of the `Counter` class.

You will add **change listeners** (observers) to the `progress`
and `message` properties of the CounterTask.  So, when the
CounterTask calls `updateProgress` or `updateMessage`, 
the listeners can upate the UI on the Application thread.

```java
class CounterTask extends Task<Integer> {
    private int totalcount;
    private int count;

    public CounterTask(int totalcount) {
        this.totalcount = totalcount;
        this.count = 0;
    }

    public Integer call() {
         // write a while loop to count 1, 2, ... totalcount
         // each time:
         // 1. call updateProgress
         // 2. call updateMessage with current count as seconds
         // 3. sleep for 1 millisecond.
         // 4. check if Task has been cancelled
    }
}
```

the code for this is included in the starter code.

## Modify `TimerController` 

Modify `TimerController` to create and use a `CounterTask` object
instead of the inner `Counter` object.

You need to implement 4 things:

1. add an attribute of type `CounterTask` (name the variable `worker`)
2. define a new method named `startWorker` - this will create a CounterTask, add change listeners to update the UI, and start the task
3. define a new method naemd `stopWorker` - stp the CounterTask.
4. change the **event handlers** on startButton and stopButton to call the new methods (startWorker and stopWorker) instead of the stupid start() and stop().


### The `startWorker` Method

Add this method to `TimerController`.
```java
public void startWorker(ActionEvent event) {
    // get the value from the input field
    String text = inputField.getText().trim();
    if (text.isEmpty()) return; // nothing to do
    int totalcount = Integer.parseInt(text)*MILLIS; // convert value to millisec

    // Create the worker task -- the CounterTask
    // this must be an attribute so the stopWorker method can access it
    worker = new CounterTask(totalcount);

    // Add Observer: whenever the worker updates his message (String)
    // update the displayField label.
    // There are 3 ways to write this (just like Handler for events)
    ChangeListener<String> messageListener = 
        new ChangeListener<String>() {
          public void changed(ObservableValue<? extends String> subject,
                              String oldValue, String newValue) {
              displayField.setText( newValue );
          }
       };

    worker.messageProperty().addListener(messageListener);
```

we also want to update the progress bar when the worker updates
his progress.

To simplify the code, we can **bind** the worker's progress property
directly to the progress bar.  Whenever the worker's **progress** property
changes, the ProgressBar's **progress** property is changed automatically!

```java
    // bind progress bar to worker task progress property
    progressBar.progressProperty().bind(worker.progressProperty());
```
Finally, start the worker in a separate thread:
```java
    new Thread(worker).start();
} // end of the startWorker method
```

### The StopWorker Method

The `stopWorker` method just cancels the task.
```java
public void stopWorker(ActionEvent event) {
	worker.cancel();
}
```

### Change Button Event Handlers to Use Your Code

Finally, change the event handlers on the `startButton` and `stopButton`
to use your `startWorker` and `stopWorker` methods instead of `start`
and `stop`.

```java
    //TODO change the event handlers
    startButton.setOnAction( this::startWorker );
    stopButton.setOnAction( this::stopWorker );
```

### Learn More - Try These

1. Instead of writing the `ChangeListener` as anonymous class, write a method named `messageChanged` that does with anonymous class does. Use a **method reference** as argument to `messageProperty().addListener(...)` instead of anonymous class.

2. Directly **bind** the `textProperty` of the Label (`displayField`) to the `messageProerty` of the worker task.  Then you don't need a change listener! 

3. Instead of listening to the `messageProperty` of the worker, listen to the `valueProperty` of the worker (the Integer value of the counter), and use it to update the UI.

### Challenge - Pause a Task

JavaFX Tasks don't have a method to pause a task.  You can do this in your own code.  One way is like this:

* Add a boolean `paused` variable to CounterTask
* Add a pause() method that toggles the boolean `paused` variable.
* In the while loop inside the `call()` method, after the 1 millisecond sleep write another `while` loop:
```java
while(paused) {
    try {
      Thread.sleep(5); // 5 milliseconds
    } 
    catch(InterruptedException ex) {/* back to work */}
```

* Finally, add a "Pause" button to the UI and Event Handler that calls `worker.apuse()`.


---

### Learn More

* The Oracle JavaFX Tutorial has a section on Tasks.
* [javafx/WorkerThreads](https://skeoop.github.io/javafx/WorkerThreads) on [OOP course site](https://skeoop.github.io/).
