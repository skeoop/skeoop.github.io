---
layout: page
title: Lab1
description: 
---

## Instructions for Lab1

1. Go to this URL to accept assignment: [https://goo.gl/iXjYm7](https://goo.gl/iXjYm7).

2. Github will create a repository for you. Click on the link to go do your new repository.  Copy the URL on the repository page.

3. Clone the repo into your IDE "workspace". For Eclipse, its usually a directory name "workspace".  Regardless of which IDE you use, you should have a common location for your projects, with one (sub)directory for each project.
    ```shell
    cmd> cd someplace/workspace
    cmd> git clone https://github.com/OOP2018/guessing-game-yourname.git guessing-game
    ```
4. Complete assignment according to these instructions: [Guessing Game](Lab1-Guessing-Game.pdf). 

## Check Your Code

1. Do classes have good Javadoc with `\@author` tag and your real name?
2. Is your guessing game named "*YournameGame*.java", **not** "GuessingGame.java"?
3. Can your `GameConsole` play someone else's game?
4. Can other students else play *YourGuessingGame* in **their** GameConsole?
5. Can your `GameSolver` solve someone else's game?

## Hint for GameSolver using Bisection

The common way to solve a problem like the guessing game is the **Bisection Algorithm**, also called Binary Search.  At each step you divide the search interval in half, so that the solution is always somewhere in the search interval.

Suppose `min` in the lower end of the interval and `max` is the upper end of the interval where the solution is.  Using Bisection we would guess:
```java
guess = min + (max - min)/2;
```

There are **two tricky points** to be careful of.

1. The interval **must get smaller** at each step.    
For example, `min=1`, `max=100`, and `guess=50`.  If guess is "too large", what should the new `max` be?    
It should be `max=49` (max=guess-1). **Not** max=50.  This guarantees that the interval is getting smaller at each step.    
If you don't do this you might end up with `min=2`, `max=3`, but your program keeps guessing 2 forever!

2. Avoid **integer overflow**.   What is the difference between these two formulas:
```java
guess = min + (max - min)/2
```
and
```java
guess = (min + max)/2
```
Algebraically they are the same.  But on a computer (with finite precision arithmetic), if:
```java
min = 1_000_000_000;   // 1 billion
max = 2_000_000_000;   // 2 billion
guess = (min + max)/2;
```
then `guess=-647483648`!    
This is because `(min+max)` exceeds the largest "int" and returns -1,294,967,296, 
If you write:
```java
guess = min + (max-min)/2;
```
then it will never overflow when min and max are non-negative values. (*Why?*)


## Test Several Cases, Including Edge Cases

For testing software, always test a variety of cases, including "edge cases". Test:

* Game with upperBound 1.
* Game with upperBound 2.
* Game with upperBound 101.
* Game with upperBound 100
* Game with upperbound Integer.MAX_Value-1 or Integer.MAX_VALUE

## Push and Verify

1. Push to Github.
2. Verify that all the classes are there (view on Github).

## Look on Github for "Issues" and Fix Them (Sunday or Monday)

TAs and instructor will check your project.

If anything needs to be fixed, we post an **issue** in your Github repository.

You should fix all issues and **close** each issue.


