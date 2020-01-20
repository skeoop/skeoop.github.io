## Java Basic Questions

Q1. Which of the following are True statements about the Java Virtual Machine?
* [ ] Compiles Java source code into byte code.
* [ ] Loads Java byte code into memory.
* [ ] Runs Java byte code.
* [ ] Verifies Java byte code.
* [ ] Is hardware and operating system independent (same JVM runs on any hardware).

Q2. Which of the following are `static` methods? Check all static methods:
* [ ] Math.sqrt(5)
* [ ] "Hello Hacker".length()
* [ ] java.time.LocalDate.now( ) // java.time is a *package*, Localtime is a class
* [ ] System.out.println("Hi")   // println() is the method
* [ ] System.currentTimeMillis() // time in millisec since midnight 1 Jan 1970


## Numeric Types and Operations

Q3. What are the values of x and y?  Explain why.
```java
double x = 5/2;   // x = _______________
double y = 5/2.0; // y = _______________
```

Q4. What is the value of n?  Why is it *not* 4 billion?
```java
int m = 2000000000; // 2 billion
int n = m * 2;
// n = ______________
```

Q5. Here are two fixes to the above problem, but one of them doesn't do what you would expect.  Explain **why** the results are different in one sentence.

```java
long m1 = 2000000000 * 2;
long m2 = 2000000000;
m2 = m2 * 2;
```

Q6. If you perform `1/0` or `0/0` using integers or long, an exception is thrown; but it is legal for floating point.  What are x, y, and z?

```java
double zero = 0.0;
double x = 1.0/zero;  // x = ______________
double y = x/x;       // y = ______________
double z = -x;        // z = ______________
```

Q7. Which of these assignments are allowed in Java? Check those that are legal.

* [ ] `float  f1 = 10;`
* [ ] `float  f2 = 10.0;`
* [ ] `double d1 = 10;`
* [ ] `double d2 = 10.0E+100;`
* [ ] `int    n1 = 10;`
* [ ] `int    n2 = 10.0;`
* [ ] `long   m1 = 10;`
* [ ] `int    n3 = m1;`

Q8. What is the *rule* that explains which conversions are allowed?

* [ ] Integer to floating point conversion is allowed.
* [ ] Floating point to integer type is allowed.
* [ ] Conversions to a type with more bytes is allowed.
* [ ] Conversions that don't incur information loss ("type widening") are allowed.

Q9. If a conversion is not allowed by Java, you can *force* Java to do the conversion using code like this:
```java
int code = 65;
char c = (char) code;  // character with value 65 is letter 'A'
```
What is the name for the code constructor on the right side?
* [ ] A cast.
* [ ] Forced conversion.
* [ ] Type converter.
* [ ] Type redefinition.

Q10. To store the population of the Earth (approx. 7.53 billion) as an integer value (not floating point), what datatype should we use?
```java
// You can put _ in numbers to make them more readable, e.g. 1_000 is 1000.
__________ population = 7_530_000_000;
```
but the above code will cause an error **even** when you use the correct datatype for `population`!  How to fix the error?

Q11. The Python `float` type is most similar to which of these Java types? (Can you explain why?)

* [ ] `float`
* [ ] `Float`
* [ ] `double`
* [ ] `Double`
* [ ] `BigDecimal`

## Arrays

Q12. Which of these statements creates an array of 8 string variables?
* [ ] `String[8] s = new String[]`
* [ ] `String s = new String[8]`
* [ ] `String[] s = new String(8)`
* [ ] `String[] s = new String[8]()`
* [ ] `String[] s = new String[8]`

Q13. After running this code, what is the value of `names[0]`?
```java
String[] names = new String[10];
```
* [ ] empty string ("")
* [ ] `None`
* [ ] `null`
* [ ] 0
* [ ] undefined (could be any value)

Q14. How do you make a complete copy of an array `a[]` of `String` objects?

* [ ] `String[] b = a;`
* [ ] `String[] b = java.util.Arrays.copyOf(a, a.length);`
* [ ] `String[] b = new String[a];`
* [ ] `String[] b = { a[*] };`

Q15. Java has both arrays and Lists for storing an indexed sequence of values.
Which of the following are true:

* [ ] List has a fixed size specified when list is created.
* [ ] Array has a fixed size specified when array is created.
* [ ] List elements can be accessed in any order.
* [ ] Array elements can be accessed in any order.
* [ ] You can modify any element of a list (except immutable lists).
* [ ] You can modify any element of an array.
* [ ] You can add elements to a list, but only by appending to the end.
* [ ] You can add elements to a list, at any location in the list.
