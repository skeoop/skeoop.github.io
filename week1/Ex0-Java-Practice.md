---
layout: page
title: Assignment
description: 
---

Complete and correct this code. Correct syntax, bad code style, omissions, and Javadoc comment errors.
```java
/*
 * a coin
 * @Bill Gates
 */
public     Coin {
    private int value;

    public Coin(int value) {
        ______________
    }

    /**
     * Get the value of this coin.
     * @return value of this coin
     */
    public int getValue(int value) {
         return value;
    }

    public String toString() {
        System.out.print(value+"-Baht coin");
    }

//TODO Write an `equals` method for `Coin` class.
//Use the standard template in the *Java Fundamental Methods* doc.
//Comments tell you what to do.

/** Two coins are equal if they have the same value.
 * @param obj reference to compare to this Coin.
 * @return true if obj is a Coin with same value as this coin.
 */
public boolean equals(Object obj) {
    // 1. test if parameter is null
    
    // 2. test if param belongs to same class as "this", using `.getClass()`

    // 3. **cast** the param to a Coin object reference
    Coin other = 
    // 4. compare the values of "this" and the cast. Return true/false


}
```

Write 3 different ways to get an `int` value from a `String`.
```java
String s = "1234";
// write 3 ways to get an int from String s.
int n1 = __________________________;
int n2 = __________________________;
__________________________________; // create an object to parse s
int n3 = __________________________;
```

## Exercises on classes and objects. 

### 1. Three fundamentals of OOP (fill in the blanks)

__________________ means that an object contains both data (state) and methods that operate on the data.

__________________ conceptually means that one type of object can be substituted for another type as long
as both types of object provide the same behavior.

__________________ allows one class to reuse all the behavior from another class. In can optionally redefine (override) some methods and add new methods.

__________________ in code, this means we can invoke a method of an object reference without knowing (or caring) the actual class of the object that performs it.  `System.out.println(object)` is an example.  `println` invokes `object.toString()` for any object.


### 2. Data Hiding

OO programs usually *hide* the attributes of an object by declaring them to be **private**.
We provide `get` and `set` methods to access the values.
This is called **data hiding**.

Advantages of data hiding include: (a) protect integrity of an object's own data, 
(b) we can change how an objects stores its state (change its attributes) without affecting the rest of the program.

1. Data Hiding uses which one of the 3 fundamentals of OOP?

2. Give an example of a class you wrote in OOP1 where you can use data hiding to change
the way the class is implemented without changing the external interface.


### 3. Which fundamental characteristic of OOP is used in each of these situations?

1. A BankAccount class knows its balance and has methods for deposit, withdraw, and get the balance.

2. A bank application has a SavingAccount and CheckingAccount class.  Most of the code is exactly the same for both SavingAccount and CheckingAccount; for example, deposit, withdraw, getBalance, getOwner, and many other methods.  How can we avoid making 2 copies of the same methods?

3. Give your own example of an application you wrote that uses encapsulation, polymorphism, or inheritance.
