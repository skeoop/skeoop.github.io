---
layout: page
title: Lambda Expressions
description: Lambda Expressions
---

## Lambda Expressions

A *lambda expression* is an unnamed function.  A lambda includes references to its surrounding scope (closure).  Lambda expressions were introduced in Java 8.

The syntax of a lambda expression is:
```java
    (Datatype variable, ...) -> { statement block; }
```
For example, a lambda that prints its argument to System.out is:
```java
    (Object x) -> { System.out.println(x); }
```
Usually the datatype of parameters can be *inferred* from context, so you can omit them:
```java
    (x) -> { System.out.println(x); }
```
If there is only one parameter, you can also omit the parenthesis:
```java
    x -> { System.out.println( x ); }
```

If the lambda *definition* is only a single statement you can omit the brackets {...} and semi-colon, too. So the above becomes:
```java
    x -> System.out.println( x )
```

## Using Lambda Expressions

Lambdas can be used anyplace where you can use an object that implements an interface.  You can assign it to a variable so you can invoke it later (perhaps many times).

Everything in Java has to have a *type*. 
Since a lambda defines a single method, the *type* of a lambda is an *interface* with a single abstract method.

For example: `Comparator` (abstract compare method), `Runnable` (run method), or `Callable` (call method).

**Example using Anonymous class**:  Define a `Comparator` for Strings the compares strings ignoring case.
```java
// define a Comparator for case-insensitive sorting of Strings
Comparator<String> ignoreCase = new Comparator<String>( ) {
    public int compare(String a, String b) {
        return a.compareToIgnoreCase(b);
    }
};
// sort an array of strings, ignoring case
Arrays.sort( array_of_string, ignoreCase );
```
A **lot of code** for a method containing one **one** statement.
 
**Example 1 (Define a Lambda)**: define a Comparator as lambda expression instead of Anonymous Class.
```java
// define a Comparator for case-insensitive sorting of Strings
Comparator<String> ignoreCase = (a,b) -> a.compareToIgnoreCase(b);

// sort an array of strings
Arrays.sort( array_of_string, ignoreCase );
```

**Example 2 (Define Lambda at Point of Use)**: same as above, but define and use in one statement.
```java
// sort an array of strings ignoring case
Arrays.sort( array_of_string, (a,b) -> a.compareToIgnoreCase(b) ); 
```

In both examples, the compiler can **infer** that a and b must by type String.  The compiler can also *infer* that the expression should return an `int` because the `compare` method in the Comparator interface returns `int`. 

#### Recommendation

If a lambda expression is *more than one statement* or you want use *use it more than one place* then define the lambda first (Example 1) and then use it. Don't write long inline lambda expressions (like the event handler below).

**Inline Lambda Definition is Hard to Understand:**
```java
// JavaFX event handler for a Button -- don't do this
button.setOnAction( (event) -> {
       String text = inputfield.getText().trim();
       if (text.isEmpty()) return;
       processInput(text);
       text.clear();
       } );
```

## Functional Interfaces

A **functional interface** is an interface with only one abstract method, such as *Runnable* and *Comparator*.  Java 8 adds many new functional interfaces in the package `java.util.function`.
Here are a few:

| Interface  | Abstract Method  |  Use      |
|:-----------|:-----------------|:----------|
| Consumer&lt;T&gt; | void accept(T t) | Do something with the parameter, return nothing. |
| Function&lt;T,R&gt; | R apply(T t) | Unary function or mapping of T -&gt; R. |
| Predicate&lt;T&gt; | boolean test(T t) | boolean condition |
| BinaryOperator&lt;T&gt; | T apply(T a, Tb) | binary operator |
| UnaryOperator&lt;T&gt; | T apply(T a) | unary operator,  T -&gt; T |

**Functional Interfaces for Primitives**     
There are many variants of the above interfaces for the case where a parameter or return value is a **primitive** 
(since primitives cannot be used as type parameter).  For example:

| Interface  | Abstract Method  |  Use      |
|:-----------|:-----------------|:----------|
| IntFunction&lt;R&gt; | R apply(int arg) | Unary function from `int` to R. |
| ToIntFunction&lt;T&gt; | int applyAsInt(T arg) | Unary function from T to `int` |
| DoubleConsumer | void accept(double arg) | Perform operation on a double value. |
| DoubleUnaryOperator | double applyAsDouble(double x) | Function of double returing double. |

**Example:**     
We often need to test if a String is null *or* empty.  Define a predicate named `empty` for this:
```java
Predicate<String> empty = (String s) -> s == null || s.trim().isEmpty();
// Using the predicate:
String foo = "";
if (empty.test(foo)) System.out.println("Foo is empty string");
```

### Exercise 1: Lambda Greeter

Write a Lambda expression for a `Consumer` to greet a person by name.
It should print "Hello, *name*".
```java
Consumer<String> greeter = ____________________________________________;
// This should print "Hello, Paruj"
greeter.accept("Paruj");
```

### Exercise 2: Compute Age in Years

In Java, to compute the age of a Person, using a `LocalDate` for birthday,
we can use a `java.time.Period` like this:
```java
LocalDate birthday = LocalDate.of(1999, 1/*Jan*/, 15);
LocalDate now = LocalDate.now();
// compute difference from birthday to now
Period age = Period.between(birthday, now);
System.out.println("age: " + age.getYears() );
```

Write a Lambda Expression named `age` that has a `LocalDate` parameter (a date) and returns the parameter's age in years as an `Integer`.
You need more than one statement for this, so write a block surrounded by {...}.
```java
Function<LocalDate,Integer> age = (date) ->
                ____________________________________________
                ____________________________________________
                ____________________________________________
                ____________________________________________
// In 2018, this should by age 20
LocalDate bday = LocalDate.of( 1998, 1, 5);
System.out.printf("Birthdate %tF is age %d years\n", bday, age.apply(bday) );

// this should be age 19
LocalDate bday2 = LocalDate.of( 1998, 12, 31);
System.out.printf("Birthdate %tF is age %d years\n", bday2, age.apply(bday2) );
```

Rewrite the `age` lambda as a `ToIntFuction` so it returns an `int`.
```java
ToIntFunction<LocalDate> age = date ->
                ____________________________________________
                ____________________________________________
                ____________________________________________
                ____________________________________________
// For 2018, this should print "age 20"
LocalDate bday = LocalDate.of( 1998, 1, 5);
System.out.printf("Birthdate %tF is age %d years\n", bday, age.applyAsInt(bday) );
```

### What Were the Java Designers Thinking? 

A good software API should be *consistent*.
The method in the `Function` and `IntFunction` interfaces is `apply()`, 
but in `ToIntFunction` the method name is `applyAsInt()`.
Many of the special-case interfaces for primitives are like this, but it is *inconsistent*. 

## Reference

[Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) in the Oracle Java Tutorial, part of [https://docs.oracle.com/javase/tutorial/java/javaOO/](https://docs.oracle.com/javase/tutorial/java/javaOO/).
