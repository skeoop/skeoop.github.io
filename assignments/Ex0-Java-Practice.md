---
layout: page
title: Assignment
description: 
---

Complete and correct this code. Correct syntax, bad coding style, omissions, and Javadoc comment errors.
```java
/*
 * money with a value and currency
 * @Bill Gates
 */
public Class Money {
    private int value;
    private String currency;

    public Money(double value, String currency) {
        ____________________
        ____________________
    }

    /**
     * Get the value of this money, ignoring currency.
     * @return value of this money
     */
    public int getValue(int value) {
         return value;
    }

    public String toString() {
        System.out.print(value+"-Baht");
    }

    /**
     * Two money objects are equal if they have the same
     * value and same currency.
     * @param other is another Money object to compare to this
     * @return true if they have same value and currency
     */
    public boolean equals(Object other) {

       //TODO Write an `equals` method, using the template
       //     in the *Java Fundamental Methods* doc.
       // These comments outline what you need to do.

       // 1. test if parameter is null
    
       // 2. test if param belongs to same class as "this"
       //    use this.getClass() and other.getClass()

       // 3. **cast** the param to a Money object reference
       Money m = (Money)___________ 
       // 4. compare the values and currencies of the two things.
       //  Return true or false.

}
```

Write 2 different ways to get an `int` value from a `String`.
Look at the Java API of the Integer class.
```java
String s = "1234";
// write 2 ways to get an int from String s.
int n1 = __________________________;
int n2 = __________________________;
```
Another way is to use `Scanner`.  We usually use Scanner to read
from an InputStream or File, but it can also parse a String.
See the API for Scanner: is there a **constructor** that has a
String parameter?

Write code to use a Scanner to parse an `int` value from a String.
(Even though the above solutions would be faster.)
```java
String s = "1234";
__________________________________; 
int n = __________________________;  // get the value 1234
```

