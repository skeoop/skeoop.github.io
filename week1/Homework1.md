# Homework 1

Please submit this is writing, in lecture next week (Jan 26).
Please write the Java statements that you used to get the answers to problems 1 and 2.

1. The *Year 2000 Bug* referred to a bug in computer code that used a 2-digit number to store the year.  On 1 Jan 2000 those programs miscomputed the year (e.g. 1 Jan 1900).  The Java `Date` class uses a single `long` attribute to store the Date value.  The attribute is the number of milliseconds since midnight on 1 Jan 1970.  
 Using the `Long` class (to get the maximum value of a `long` primitive value) and the Date class, write 2 or 3 Java statements that will print the date and time when the "Java Date Bug" will occur (when the `long` attribute can no longer hold the correct time).

2. The static method `System.nanoTime()` returns a `long` value that is elapsed time in nanoseconds, but it is not based on any fixed start date.
Should we be worried about `System.nanoTime()` overflowing the maximum `long` (or resetting to 0)?    
  * Use the `java.time.Duration` class (in Java 8) to find out how many days **from now** until `System.nanoTime()` exceeds the maximum value of a `long`.  Use just 2 or 3 java statements to compute and print the value.
  * Approximately how many years is that? (1 year = 365.242 days)
  * **Hint**: To create a `Duration` object, use a static method of the `Duration` class, esp. the `ofXxx()` methods.

3. `StringBuilder` is an important class for working with Strings. It lets you "build" and modify a String without creating lots of intermediate objects, which is what happens if you write "I"+" like "+" Java." (this creates 5 strings).
To answer this question, either use BlueJ's interactive window and object workbench (to inspect the object), or use the debugger of an IDE such as Eclipse.
    * a) What are the attributes of a `StringBuilder` object?
    * b) Create a table showing the values of the StringBuilder's attributes after each of these statements is executed. For the array attribute, show the size of array and its values, such as 'h','e','l','l','o', but don't show nulls.

    ```java
    StringBuilder sb = new StringBuilder("I");  // 1

    sb.append("Str").append("ings!"); // 2

    sb.insert(1," hate "); // 3

    sb.replace(2,6,"love"); // 4
    ```
    * c) What happens if you try to add more than 18 characters (the initial capacity of StringBuilder) to a StringBuilder?

**About StringBuilder**
The StringBuilder methods that "build" the string (like append, insert, replace) return a reference to the StringBuilder object itself. Using this, we can chain multiple method calls together, such as:
```
sb.append("cat").append("bird").insert(3," ")
```  
When you are done "building" the String, you can create a String from StringBuilder by calling `sb.toString()`.

For complex string manipulation, StringBuilder will be much faster than using Strings, and save memory, too.
