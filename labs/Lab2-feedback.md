## Feedback on Lab 2

### Not Reviewing Their Work

* 12 students submitted README.md with "by Bill Gates" in it

### Missing Package or Incorrect Package

Package name **must match** directory relative to the project source tree.

If you don't do this, your code will not compile.
```
lab2/
    stopwatch/           <-- package is "stopatch"
        Task1.java
    util/                <-- package is "util"
        ArrayMath.java
    Main.java            <-- no package (default package)
```

You must write:
```java
package stopatch;

public class Task1 {

```
and
```java
package util;

public class ArrayMath {
```

Problem: some students are using VS Code to edit but compile and run
in a terminal window. Code in same directory will compile without "package", 
but it won't work as part of larger project and will fail unit tests.

Solution: Compile in the IDE.  Use a better Java IDE than VS Code.

### Common Errors (1st Review)

* No `@author` tag in class.
* Method Javadoc comment does not have a description of what the method does.
* Parameter Javadoc does not describe the parameter. Example:
    ```java
    /**
     * @param x
     * @param y
     * @return the dot product of x and y
     */
   ```
* Not using Java Coding Standard, in particular:
    - missing a blank line between methods
    - method code or blocks not correctly indented
* `polyval` **inefficient code**.  You should **not** use `Math.pow(x,n)`.
    - Read the problem instructions
* No `package` statement.  If you don't use correct package, **the code will not compile**.
    - Package names must match directory names in source tree.
    - `ArrayMath` is in a subdir named `util`, therefore package must be `package util;`
    

* Duplicate Code - see below.


### Duplicate Code

Try to avoid duplicate code!

```java
public static double dotProduct(double[] x, double[] y) {
    double sumproduct = 0.0;
    if (x.length <= y.length) {
        for(int k=0; k<x.length; k++) sumproduct += (something);
    }
    else {
        for(int k=0; k<y.length; k++) sumproduct += (something);
    }
    return sumproduct;
}
```
There is a duplicate `for` loop.    
You could easily combine both cases:
```java
    double sumproduct = 0.0;
    int size = Math.min(x.length, y.length);

    for(int k=0; k<size; k++) sumproduct += (something);
```

