---
layout: page
title: Inheritance Practice
description: 
---

## Practice Problems for Design with Inheritance

## Guessing Game

In the Guessing Game, we have superclass named `NumberGame` that defines methods for games to override.
```java
public class NumberGame {
    private String message;

    public String getMessage() { return message; }
    public void setMessage(String msg) { this.message = msg; }

    // OVERRIDE these methods
    public boolean guess(int number) { return false; }
    public int getCount() { return 0; }
    public int getUpperBound() { return 0; }
}
```

Improve this code, using:

1. `abstract` methods for methods the subclass **must** override.
2. `final` methods for methods the subclass **should not** override.
3. Every class has to define its own counter and increment the counter.  Could you eliminate duplicate code by delegating it to the superclass (NumberGame)?

## JMan

A game named J\*Man has 4 kinds of pieces:

* `Walker` - moves randomly at each turn. Walkers have a fixed color, either RED, YELLOW, and GREEN.
* `Pillar` - don't move but change color randomly (RED, YELLOW, or GREEN).
* `Block` - block are white and do nothing but occupy a square so other pieces can't enter
* `JMan` - the main piece, who tries to capture all the Walkers and Pillars. (Like Pacman) 

JMan can only capture pieces of a certain color, according to these rules:
* when JMan is RED he can capture a YELLOW piece
* when JMan is YELLOW he can capture a GREEN piece
* when JMan is GREEN he can capture a RED piece
* when JMan captures a piece, he becomes the color of that piece.


There is a separate class for Walker, Pillar, Block, and JMan.

![JMan Class Diagram](JMan-class-diagram.png "JMan class diagram")

The main class (named `Map`) runs a loop that controls all the pieces:

```java
private List<Object> pieces;  // the game pieces, except JMan
private JMan jman;            // our hero
private Random rand;          // random number generator

public void act() {
    for(Object obj: pieces) {
        if (obj instanceof Walker) {
             Walker w = (Walker) obj;
             w.move();
        }
        else if (obj instanceof Pillar) {
             Pillar p = (Pillar) obj;
             int k = rand.nextInt(3); // there are 3 colors
             p.setColor( colors[k] ); // colors are
        }
        else if (obj instanceof Block) {
             // blocks don't do anything
        }
    }
}
```
JMan moves when the arrow keys are pressed, so the `act()` method doesn't need to move JMan.

There are several blocks like this in the code.


How would you use inheritance and polymorphism to simplify this code.


## Full-time and Part-time Students

There are 2 kinds of Students:

* **FullTime** student must enroll in 6-21 credits each semester. He pays a fixed tuition of 12,000 Bt each semester.
* **PartTime** student can enroll in 0-6 credits each semester. He pays 1,000 Bt per credit + 1,000 university fee each semester.

In all other ways, Full-time and part-time students behave the same. They each hve these behavior:

* enroll in course
* drop a course
* get course list
* compute GPA
* get name
* get student ID

A Full-time student can switch to part-time, and a part-time student can switch to full-time.

How you you model this in Java so we can use polymorphism?  

Would you use inheritance? 

Draw a UML diagram.

