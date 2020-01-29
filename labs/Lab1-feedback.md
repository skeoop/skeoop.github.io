## Lab1 Feedback

All the student codes I reviewed contain too many **defects** to grade.  The main categories of defects are:

1. Javadoc Errors
2. Coding Errors
3. Algorithm and Logic Errors

Many common problems were described in class.  Here are some.

## Javadoc Errors

Class Javadoc must begin with a sentence, followed by `@author` tag on separate line.
You do not need to use the 'version' tag (`@version`).

See [Java Coding Standard](https://skeoop.github.io/docs/Java-Coding-Standard.pdf).


## Coding Errors

**GameSolver** should **not print** anything.  This was specified in lab sheet.
The only allowed exception is if the game cannot be solved.  In that case, a better solution is to return -1 to indicate no solution (instead of printing).

**GuessingGame** does **not have** a `setCount()` method.  Its not in the API,
and only `GuessingGame` inself should update the guess counter.

```java
// In GameSolver class:

public static int play(GuessingGame game){
    System.out.println("Guess a secret number. ");
    System.out.println("I'm thinking of a number between 1 and 100");
    int count = 0;
    int min = 1;
    /** the upperbound of the range */
    int max = 100;
    int your_number = min + (max - min)/2;
```
1. Method is not `static`.
2. Its not supposed to **print anything**.
3. The upper bound might not be 100!  you should ask the game for the upper bound.
4. The `GuessingGame` is supposed to count the guesses. **Don't** count guesses in GameSolver.

```java
// in GameSolver play() method:
    game.guess( number );
	game.setCount();
	if (game.guess(number)) return number;
	// else compute a new number to guess
```
1. A method named `setSomething` is expected to be a "setter" or "mutator" method.  It **always** has a parameter.
2. The GuessingGame should count the guesses itself! Don't couple the behavior with the GameSolver.
3. This code calls `game.guess(number)` and ignores the result!  Then it calls it a second time to test the return value.

```java

public class GameSolver{

    private int min;
    private int max;
	private int answer;
    public boolean result;
    public String message;

    public int play(GuessingGame game){
		min = 1;
		max = game.getUpperBound();
		answer = min + (max-min)/2;
		...
```
**Attributes** are for things an object needs to remember, **local variables** are for
values used inside a method.  In this code, all the variables should be *local variables*.

You don't need any attributes.  In fact, using attributes (instead of local vars) can lead
to many errors if you call `play()` again with another game.




## Algorithm and Logic Errors

Actual examples from student GameSolver classes.

```java
// default value of input value to 0 
status = game.guess(game.getUpperBound());
// check the status of the game
status = game.guess(1);

while(status != true) {
	 // main loop of guessing algorithm
}
```
Before the loop this code calls `guess` twice, without checking the results of the first call!  If the first call is correct, you won't know.
Plus, he does not record what the guess way (1 or upperBound), so how if `status=true` and the loop is not executed, you won't know what the correct value was!

```java
// 1
status = game.guess(num);
if (game.getMessage() == "WAY too small, dude." || game.getMessage() == "Too small.")
{
    // 2
    min = num;
}
// 3
else if (game.getMessage() == "WAY too large" || game.getMessage() == "Too large.")
{
	// 4
    max = num;
}
```
1 and 3: Never compare string values using `==`.

1 and 3: Logic Error: the guessing game promises only that the message will contain "too large" or "too small", not the exact text. Don't **assume** the exact text.

2 and 4: Algorithm Error: the interval must get smaller with each guess.  I described this problem before in [Lab1-checklist](Lab1-checklist).

2 and 4: Redundant Method Call: `game.getMessage()` is called 4 times when the result will be the same.  You should assign result to a local variable and use local variable instead of repeated method calls.

1: It is more efficient to check immediately if `status` is true and break from the loop.

