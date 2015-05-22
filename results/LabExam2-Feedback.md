## Problem 1 (Enumeration Adapter)

Many students wrote very good code for this problem.
```
#!java
import java.util.Enumeration;
import java.util.Iterator;
/**
 * Adapt an Enumeration to provide Iterator interface.
 * @param T is the type of element in the enumeration
 */
public class EnumerationAdapter<T> implements Iterator<T>{
	private Enumeration<T> enumeration;
	/**
	 * Constructor
	 * @param e an enumeration to adapt
	 * */
	public EnumerationAdapter(Enumeration<T> e) {
		this.enumeration = e;
	}

	/**
	 * Test if the next method can return another element
	 * @return true if next can return another element
	 * */
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	/**
	 * Get the next element from iterator
	 * @return the next element, if any
     * @throws NoSuchElementException if no more elements
	 * */
	@Override
	public T next() {
		return enumeration.nextElement();
	}

}
```

### Mistakes in Problem 1
**1. Unnecessary "if"**
```
#!java
public void hasNext() {
    if ( e.hasMoreElements() ) return true;
    else return false;
}
```

**2. Unnecessary Cast**
```
#!java
Enumeration<T> e;

public T next() {
    return (T) e.nextElement();
}
```

**3. Extra check (this is an error)**
```
#!java
public T next() {
    if (hasNext()) retun (T) e.nextElement();
    return null;
}
```
This is an error because Iterator.next() should
throw `NoSuchElementException` if you invoke next() when hasNext if false.
This check changes that behavior.

## Problem 2. StopWatch using States
I checked for the following:

1. States have methods for all state-dependent behavior: start(), stop(),
reset(), and getElapsed(). isRunning() can be handled (without "if") either
in states or in StopWatch.
2. I ran 6 JUnit tests on StopWatch to verify states work correctly.
3. StopWatch only creates states once -- don't create a new state object
each time a state is entered. JUnit tests are in the "results" folder in class repository.
4. If the StopWatch code does **not** use states (essentially just using
my starter code) then the code does not get any score for JUnit tests.

#### What is "State Dependent" Behavior?
Any behavior (methods) where the object responds differently depending
on its state.  For the StopWatch, any method that has something like:
```
#!java
    if (running) do this;
    else do that;
```
depends on state!

The best solutions for this problem are by Thongrapee and Benjapol.    
Here's a solution with the method Javadoc omitted; your code
**should** have Javadoc for interface methods.
```
#!java
package stopwatch;
/**
 * The behavior of {@link Stopwatch} that it delegates to states.
 */
public abstract class StopWatchState {
    /** reference to our StopWatch */
    protected StopWatch stopwatch;
    public StopWatchState(StopWatch sw) { stopwatch = sw; }
	abstract void start();
	abstract void stop();
	abstract void reset();
	abstract long getElapsed();
    abstract boolean isRunning();
}
```
It is OK to use different names for the methods, but you should have handlers
for (at least) these 4 methods.

The StopWatch only has 2 states: RUNNING or STOPPED.
Here's an example from Benjapol's `RunningState`. He wrote excellent Javadoc,
which is not shown here for brevity:
```
#!java
package stopwatch;
/**
 * A {@link StopWatchState} for behavior of a running StopWatch.
 */
public class RunningState extends StopWatchState {
	public RunningState(StopWatch stopwatch) {
		super(stopwatch);
	}

	public void start() {
		// Do nothing -- already started.
	}

	public void stop() {
		stopwatch.elapsed += System.currentTimeMillis() - stopwatch.startTime;
		stopwatch.setState( StopWatch.STOPPED );
	}

	public void reset() {
		// Cannot reset while stopwatch is running
	}

	public boolean isRunning() { return true; }

	public long getElapsed() {
		return stopwatch.elapsed + System.currentTimeMillis() - stopwatch.startTime;
	}
}
```

Finally, to use the **State Pattern** the StopWatch needs to do 3 things:

1. Define a `State` attribute and a way for states to change the current state, such as  `setState()`.
2. Delegate behavior that depends on state to the current `state`. *This is the key to the pattern!*
3. Create a concrete State object for each state (only once), and make these State objects accessible to the states -- e.g. package scope or inner classes.

I deducted points for:

* not having enough methods in states
* using "if" in StopWatch instead of states
* creating a new concrete state object each time a state is entered
* using `static` behavior -- that is not the state pattern and changes the API of StopWatch.
* StopWatch has a reference to the UI and/or tries to update the UI itself. The StopWatch should work without any UI. It should not be *coupled* to the UI.

```
#!java
package stopwatch;

/** A StopWatch with millisecond precision, using States. */
public class StopWatch {
    // (1) attribute for current state
	private StopWatchState state;

    // (1) A method for states to change state of the StopWatch
    public void setState(StopWatchState newstate) { this.state = newstate; }

	// (3) instances of the actual states (create them only once)
	protected final StopWatchState STOPPED = new StoppedState(this);
	protected final StopWatchState RUNNING = new RunningState(this);

	protected long elapsed;
	protected long startTime;

	/** initialize the stopwatch to Stopped state */
	public StopWatch() {
		setState( STOPPED );
        elapsed = 0;
	}

	// (2) delegate state-dependent behavior to the current state
	public void start() { state.start(); }
	public void stop()  { state.stop(); }
	public long getElapsed() { return state.getElapsed(); }
	public boolean isRunning() { return state.isRunning(); }
	public void reset() { state.reset(); }
}
```
It is OK to handle `isRunning()` in the StopWatch, since the StopWatch knows its own state:
```
#!java
    public boolean isRunning() {
        return state == RUNNING;
    }
```

## Problem 3: Graphical UI Using Commands
I graded 3 aspects:

1. The UI uses command objects to change behavior of the Start/Stop button.
2. The UI is well designed. In particular, the constructor does not call "setVisible(true)".
3. The UI works correctly.  It displays current elapsed time of stopwatch and the buttons work correctly.

#### Using Command Objects for Start/Stop
The Start/Stop button needs 2 commands: one for "start" and one for "stop".
Using Swing `Action` objects is the simplest, most convenient solution:
```
#!java
    // JButton can be a local variable in initComponents().
    // After you "program" it, you never need to refer to it again!
    final JButton startStopButton = new JButton();
    Action startAction = new AbstractAction("Start") {
        @Override
        public void actionPerformed(ActionEvent e) {
            stopwatch.start();
            timer.start();
            startStopButton.setAction(stopAction);
        }
    };
    Action stopAction = new AbstractAction("Stop") {
        @Override
        public void actionPerformed(ActionEvent e) {
            stopwatch.stop();
            timer.stop();
            startStopButton.setAction(startAction);
        }
    };
    // assume the StopWatch is initially stopped
    startStopButton.setAction( startAction );
```
Notice that the commands (Actions) change the command of the JButton. That's the command pattern.

The `timer` refers to a `javax.swing.Timer` that merely calls a method
to update the display time:
```
#!java
    ActionListener updateTask = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            updateDisplayTime();
        }
    }
    Timer timer = new Timer( INTERVAL, updateTask );
```
Some students used a *Lambda Expression* for this, which is much more compact:
```
#!java
    Timer timer = new Timer( INTERVAL, (evt) -> updateDisplayTime() );
```

## Problem 4: Main
The Main class's `main` method should do 2 things.

1. Create objects and perform dependency injection. (2 pts)
2. Create and launch Swing objects on the event dispatcher thread. (3 pts)

```
#!java
public static void main(String[] args) {
	final StopWatch stopwatch = new StopWatch();
    SwingUtilities.invokeLater(
        new Runnable() { 
            public void run() {
                StopWatchUI ui = new StopWatchUI(stopwatch);
                ui.run();
            }
        }
    };
}

```
It is tempting to make the following short-cut (assuming your StopWatchUI is Runnable and the `run` method shows the UI):
```
#!java
public static void main(String[] args) {
    StopWatch stopwatch = new StopWatch();
    StopWatchUI stopwatchUI = new StopWatchUI(stopwatch);
    SwingUtilities.invokeLater(stopwatchUI);
}
```
but this violates Java's guidelines about running Swing on the EventDispatcher thread.
By creating Swing components on the non-UI thread you are effectively "running" them, so you need to create the UI objects on the EventDispatcher thread, too.

For complete explanation, see "Concurrency in Swing" in the Java Tutorial.

