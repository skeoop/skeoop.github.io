---
layout: page
title: Lab1 Checklist for Correct Submission
description: Lab1 Checklist for Correct Submission
---

## Review Your Code

1. Do classes have good Javadoc with `\@author` tag and your real name?
2. Does the class Javadoc describe the purpose of the class, as whole sentences?
3. Can your `GameConsole` play someone else's Guessing Game?
4. Can other students' code play *Your* `GuessingGame` in **their** GameConsole?
5. Can your `GameSolver` solve someone else's GuessingGame?


## Test Your GameSolver - Be Careful of Edge Cases

For testing software, always test a variety of cases, including "edge cases". Test these cases:

* Game with upperBound 1.
* Game with upperBound 2. Need to play several times.
* Game with upperbound 4. Need to play several times.
* Game with upperBound 101.
* Game with upperBound 2,000,000,000 or Integer.MAX_VALUE (see below for why this is tricky)

## Push and Verify

1. Verify that you have committed your code locally:
    ```shell
    cmd>  git status
    ```
   Only commit your `*.java` files, not `*.class` or `*.ctxt`.  You should also have a `.gitignore` file (provided in starter code).
2. If some Java source files have not been committed or need to update, do:
    ```shell
    cmd>  git add GameSolver.java  (etc.)
    cmd>  git commit -m "add guessing game solver"
    cmd>  git status
    ```
3. Push your work to Github.  If you cloned your local repository from Github, then git remembers the "remote" URL named `origin`. ("origin" is just the conventional name for the primary remote).    
    Use the command:
    ```shell
    cmd>  git push
    ```

4. Use a web browser to view your repo on Github. Verify the files are there.


## Hint for GameSolver using Bisection

The common way to solve a problem like the guessing game is the **Bisection Algorithm**, also called Binary Search.  At each step you divide the search interval in half, so that the solution is always somewhere in the search interval.

Suppose `min` in the lower end of the interval and `max` is the upper end of the interval where the solution is.  Using Bisection we would guess:
```java
guess = min + (max - min)/2;
```

There are **two tricky points** to be careful of.

1. The interval **must get smaller at each step**.    
For example, `min=1`, `max=100`, and `guess=50`.  If guess is "too large", what should the new `max` be?    
   * It should be `max=49` (max=guess-1). **Not** max=50.  This guarantees that the interval is getting smaller at each step.    
   * If you don't do this you might end up with `min=2`, `max=3`, but your program keeps guessing 2 forever!

2. Avoid **integer overflow**.   What is the difference between these two formulas:
    ```java
    // Formula 1 for midpoint
    guess = min + (max - min)/2
    ```
    and
    ```java
    // Formula 2 for midpoint
    guess = (min + max)/2
    ```
    Algebraically they are the same.  But on a computer with finite precision arithmetic, if:
    ```java
    min = 1_000_000_000;   // 1 billion
    max = 2_000_000_000;   // 2 billion
    guess = (min + max)/2;
    ```
    then `guess=-647483648`!    
    * This is because `(min+max)` exceeds the largest "int" and returns -1,294,967,296, 
    * If you write:
    ```java
    guess = min + (max-min)/2;
    ```
    then it will never overflow when min and max are non-negative. (*Why?*)


## Query Methods Should Be Harmless - No Unexpected Side Effects

A couple of students wrote a `getCount()` method like this:

```java
public class GuessingGame {
    private int count = 0;

    public int getCount() {
        return count++;
    }

    public void guess(int number) {
        getCount();  // count this guess
        // evaluate the guess
        if (guess == secret) {
            setMessage("Right!");
            return true;
        ...
    }
```

What is the problem with `getCount()`?

The user of this code **won't know** that `getCount` increments the counter, 
so he might call it at many places in his code.

A general rule is that "get" methods should **not change** the attributes 
of an object or its state.

This is part of the **Command - Query Separation Principle** which states that you should have separate methods for "queries" and "commands". Commands tell an object to do something, queries just ask an object a question.


## Look on Github for "Issues" and Fix Them

TAs and instructor will check your project.

If anything needs to be fixed, we post an **issue** in your Github repository.

You should **fix** all issues **quickly**, then **test** and **close** each issue.

