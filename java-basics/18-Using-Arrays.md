---
layout: page
title: Using Arrays
description: Idioms and methods for array
---
## Loops for Processing Array Elements

You often want to process every element in an array.
The typical logic is:
```
initialize variables and values

foreach element in array
{
    process this element
}

process the result
```
Here are 3 kinds of loops for arrays.

### 1. "for" loop with index

This loop is useful if you need to know the index of the array element,
or you don't want to process every element.  The syntax is:
```
for(int index=start; test_condition; increment_operation) {
   statements for loop
}
```

**Example**: print each array value with its index. 
```java
double[] array = new double[] { 10.0, 20.0, 5.0 };
for(int k=0; k<array.length; k++) {
    System.out.printf("[%d] = %f\n", k, array[k]);
}
```

**Example**: Find the index of the largest value in array.

```java
double[] x = new double[] { 10.0, 20.0, 99.0, 5.0 };
// initialization:
double max = x[0];
int maxIndex = 0;
// loop (skip first element since we already processed it)
for(int k=1; k<x.length; k++) {
    if (x[k] > max) {
       max = x[k];
       maxIndex = k;
    }
}
return maxIndex;
```


### 2. for-each loop

If you want to process all the elements in an array and do not need
to know the *index* of each element, use a for-each loop.
The syntax is:
```
for( Datatype x : array )  { ... }
```
The `Datatype` should be the type of elements in the array, and `x` is the name of the loop variable (anything you like).

**Example:** sum squares of array elements using a for-each loop
```java
double[] array = { 10.0, 20.0, 5.0, 99.0 };
double sumSquares = 0;
// "foreach x in array"
for( double x: array ) {
    sumSquares += x*x;
}
```
A for-each loop is much cleaner and easier to read than indexed for-loop.

**Example:** print each element in an array of names.

```java
String[] animals = {"Cat", "Bird", "Horse" };
// "for-each who in names"
for( String who: animals ) {
    System.out.println( who );
}
```

### 3. while loop or do-while loop

These can also be used with arrays, of course.

**Example:** sum elements of array elements using a while loop
```java
double[] array = { 10.0, 20.0, 5.0, 99.0 };
double sum = 0;
int k = 0;
while( k < array.length ) {
    sum = sum + array[k];
    k++;                   // Don't forget this!
}
```
---

### Skipping Some Elements

Use `continue` to skip some iteration of a loop. `continue` immediately goes to the bottom of the loop block and tests for next iteration. You can use `continue` in any `for` or `while` loop.

**Example:** Print the **positive** values in an array.
```java
double[] x = { 10.0, 0, 3.0, -2, -5, 7.0};
for( double value: x ) {
    if (value <= 0) continue; // skip it!
    System.out.println( value );
}
```

`continue` is useful when there is some complex work or testing in a loop. Its much cleaner than a big `if (...){...}` block inside the loop.

### Exiting a Loop Early

You can "break out" (exit) a loop at any point using a `break` statement.

**Example**: Add elements of an array until you see a negative value in the array (called a *sentinal*).

```java
double[] x = { 10.0, 0, 3.0, -2, 12, -7.0};
double sum = 0.0;
for( double value: x ) {
    if (value <= 0) break; // stop processing!
    sum = sum + value;
}
```

---
### Useful Methods for Arrays

The [Arrays](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html) class in package `java.util` contains static methods for array operations.  You should use this class instead of writing the methods yourself!

#### Arrays.copyOf: copy an array to a new array

```java
import java.util.Arrays;
  .
  .
  .
String[] fruit = {"apple","banana","grape"};
// make a copy
String[] copy = Arrays.copyOf(fruit, fruit.length);
// make a copy of just 2 elements
String[] copy2 = Arrays.copyOf(fruit, 2);
```

#### System.arraycopy: copy array to an existing array

[System.arraycopy()](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#method_summary) lets you copy
any part of one array into any part of another array.
```java
// copy source[] array to dest[] array.
// You must make sure dest[] has enough space for copy.
System.arraycopy(source[], int start, dest[], int destStart, int length)
```
**Example**: copy each element of `a` to `b` starting at index 0:
```java
double[] a = {2, 4, 6, 8, 10};
double[] b = new double[5];    // same size as a
System.arraycopy(a, 0, b, 0, a.length);
```

#### Sort an Array

Useful method can sort any array of any type that is *Comparable*, 
which includes all numeric types, Strings, Dates, and many more.
It sorts the array in place.
```java
String[] words = {"cat", "ZEBRA", "frog", "bird"};
Arrays.sort(words);
System.out.println( Arrays.toString(words) );
```
prints:
```
["ZEBRA", "bird", "cat", "frog"]
```
ZEBRA is first because UPPERCASE come before lowercase letters!

#### Print an Array as a String

Useful for testing:
```
double[] a = {5,10,3.0E8};
System.out.println("a=" + Arrays.toString(a));
```
prints
```
a=[5, 10, 3.0E8]
```

#### Arrays.fill: set all array values at once

To fill all elements on an array with a constant, use:
```java
double[] x = new double[10];
Arrays.fill(x, 1.0); 
// sets x[0] = x[1] = x[2] = ... = 1.0
```
You can fill just part of the array by specifying extra parameters.


### More Useful Methods in Arrays class

The **java.util.Arrays** class has many useful methods.  See the [Javadoc](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html).
