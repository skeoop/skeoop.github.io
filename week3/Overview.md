---
layout: page
title: Java Syntax
description: 
---

## Don't Use == To Check for End of a Range

In the `Purse` class some people wrote code like this:

```java
public boolean isFull( ) {
    if ( money.size() == capacity ) return true;
    return false;
}
```
This is an example of a **bounds check**.  You want to check if the items
in the purse is within the allowed size.

However, there is a better way.  What the programmer means is:

|  Purse Not Full  |   Purse is Full   |
|------------------|-------------------|
| `money.size() < capacity` | `money.size() == capacity` |

* Are these two conditions **really** opposites?  (Answer: no)
* What is the programmer *assuming* to be true here?


A **safer test** is:
```java
public boolean isFull( ) {
    if ( money.size() >= capacity ) return true;
    return false;
}
```
and, for more concise (and still readable) code consider:
```java
public boolean isFull() {
    return money.size() >= capacity;
}
```

## Important: Don't use == for Bounds Check With Floating Point Values

What will be the output of this method:
```java
/** 
 * Print some values until the sum is 1.0.
 */
public static void sumToOne( ) throws InterruptedException {
     double sum = 0.0;
     while(sum != 1.0) {
         sum = sum + 0.1;
         System.out.printf("sum = %f\n", sum);
         Thread.sleep(200); // 200 millisec, to slow the output
    }
    System.out.printf("Final sum = %f\n", sum);
}
```

Try it! It loops forever:
```
sum = 0.100000
sum = 0.200000
...
sum = 1.000000
sum = 1.100000
sum = 1.200000
...
sum = 10.000000
sum = 10.100000
and so on
```

Can you explain why?

If you don't see the reason, change the `printf` format to print 16 digits:
```java
         System.out.printf("sum = %.16f\n", sum);
```

Now can you explain it?   

The answer is related to how computers store floating point values.  They are stored as a base-2 mantissa and base-2 exponental.  The decimal value 0.1 does not have an exact base-2 representation.
```shell
(decimal) 0.1 = (binary) 0.000110011001100110011 ...
```
so there is some error in storing 0.1.  

## Computed Properties

When we see a method like:
```java
coin.getValue()
```
it is often an **accessor method** for an attribute. In this case the `value` attribute.

Sometimes, however, a "get" method returns a computed value.  In design these are sometimes call "computed properties" or "computed attributes".  In the Purse class we have:
```java
purse.getBalance()
```
but there is not (should not be) a `balance` attribute!  The balance is computed when you need it.

Another example is dates.  Suppose a Person class has:
```
int person.getAge()
```
Should Person have an "age" attribute?  No way!  His age changes with time. Better to have a `birthdate` attribute (LocalDate) and *compute* his age each time `getAge()` is called.  Age is a *computed property* not an actual attribute.

## Query Methods Should Be Harmless (No Unexpected Side Effects)

A couple of students wrote a `getCount()` method like this:

```java
public class MyGuessingGame extends NumberGame {
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

The user of this code won't know that getCount increments the counter, so he might call it at different points in his code.

A general rule is that "get" methods should not change the attributes of a class, or change its state.

This is part of the **Command - Query Separation Principle** which states that you should have separate methods for "queries" and "commands". Commands tell an object to do something, queries just ask an object a question.

   
