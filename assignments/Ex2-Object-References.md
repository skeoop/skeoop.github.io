---
layout: page
title: Java Reference Exercise
description: Questions about Java References
---

Exercises on object references

### Example: Person class

We will use this class in these exercises:
```java
/**
 * A person with a name.
 * @author KU Registrar
 */
public class Person {
    private String name;

    /** Initialize a new person with a name. */
    public Person(String name) {
        this.name = name;
    }

    /** Set the person's name. */
    public void setName(String newname) {
        this.newname = name;
    }

    /** return the name of this person. */
    public String toString() {
        return "Person "+name;
    }
}
```

### Question 1: Copying Person?

What is printed when we execute this code:
```java
Person a = new Person("Bill");
Person b = new Person("Sally");
b = a;
b.setName("Hacker");
System.out.println( a ); // what is printed?
System.out.println( b ); // what is printed?
```

What happened to Sally?

### Question 2: An equals( ) method

You should **not** write an equals method like this.
You'll see why.
```
// In the Person class:
    /**
     * Two Persons are equal if they have the same name.
     */
    public boolean equals(Person other) {
        if (other == null) return false;
        return this.name.equals( other.name );
    }
```

Explain the output of equals() using the "reference as remote control" analogy.
```
Person a = new Person( "Bill" );
Object b = new Person( "Bill" );
System.out.println( a.equals(b) ); // surely this is true, right?
System.out.println( b.equals(a) ); 

// cast b as a Person reference
System.out.println( a.equals( (Person)b ) );

// create a new reference to the same person:
Person c = (Object) b;
c == b;       // is true.  This means b & c refer to the SAME object
a.equals(c)   // true or false?
c.equals(a)   // true of false?
```

### Question 3: What are the classes and attributes in this problem?

A board game is played by 2 players on an 8x8 board.  Each player has a number of pieces on the board. Each player's pieces have different color (can be any color but not the same color). The players take turns moving a piece, like in chess.  There are three types of pieces: A, B, and C.  Each piece moves differently.  A pieces can capture any piece (A, B, C), B and C can capture each other.

* What classes would you use to write code for this game?

* What are some attributes of the classes?

* What are some methods of the classes?

