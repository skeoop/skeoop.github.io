## Visualize Recursion

Sometimes you would like to see what recursion is doing.

This document shows you how to use polymorphism to add
"print" statements without changing your recursion code!

This way, you don't complicate your code with a lot of 
`System.out.println` stuff.

As a bonus, most of the code is reusable.

## Example Problem

Let's do the [fibonacci][] problem on [codingbat.com][].

> `fibonacci(int n)` - return the n-th Fibonacci number.
>
> fibonacci(0) = 0, fibonacci(1) = 1, and fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)

This is a hard problem for recursion because the complexty increases geometrically.

### Think in Code

Before writing the code, write comments for what you want to do.

```java
public int fibonacci(int n) {
    // 1. base case: check stopping criteria (success or failure)
    //    Two base cases: n <= 0 and n == 1.
    //    You should check n <= 0 and NOT n == 0 to guarantee
    //    recursion always stops.

    // 2. recursive case.  Apply the Fibonacci formula.

    // 3. guaranteed to stop?
}
```

Add the code:

```java
public int fibonacci(int n) {
    // 1. base case: check stopping criteria (success or failure)
    //    Two base cases: n <= 0 and n == 1.
    if (n <= 0) return 0;
    //    Another base case: 
    if (n == 1) return 1;

    // 2. recursive case
    return fibonacci(n-1) + fibonacci(n-2); 

    // 3. guaranteed to stop?
    // Yes because each time we call fibonacci(n) the value of n
    // is decreasing, so it will eventually become <= 0, the base case.
}
```

The code works, but we can't see what's happening.
Let's add print statements -- without changing the code.

### 1. Copy the code into a class named Recursion

```java
public class Recursion {
    // comments omitted to save space

    public int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2); 
    }
}
```

When `fibonacci` calls itself, what it is **really** calling is:
```java
        return this.fibonacci(n-1) + this.fibonacci(n-2);
```
You don't write `this.` because its automatic in Java.

Here's the trick: write a subclass that overrides `fibonacci` and
adds print statements.  Then the invisible `this` will be the subclass.

### 3. Subclass Overrides Fibonacci

```java
public class RecursionWithPrint extends Recursion {

    @Override
    public int fibonacci(int n) {
        System.out.printf("call fibonacci(%d)\n", n);
        int result = super.fibonacci(n);
        System.out.printf("return %d\n", result);
        return result;
    }

    public static void main(String[] args) {
        RecursionWithPrint rwp = new RecursionWithPrint();
        // Compute a fibonacci number
        int n = 4;
        System.out.printf("fibonacci(%d)\n", n);
        System.out.println( rwp.fibonacci(n) );
    }
}
```

The output is:
```
fibonacci(4)
call fibonacci(4)
call fibonacci(3)
call fibonacci(2)
call fibonacci(1)
return 1
call fibonacci(0)
return 0
return 1
call fibonacci(1)
return 1
return 2
call fibonacci(2)
call fibonacci(1)
return 1
call fibonacci(0)
return 0
return 1
return 3
3
```

Output would be easier to understand if recursive calls where **indented**.

Let's add indentation and also make the code reusable, 
so we can apply it to other recursion problems:

```java
public class RecursionWithPrint extends Recursion {
    // chars to print for indentation.
    static final String INDENT = "    "; // 4 spaces
    // recursion level
    private int level = 0;
    
    public void enter(String format, Object ... args) {
        for(int k=0; k<level; k++) System.out.print(INDENT); // indent the message
        level++;
        System.out.printf(format, args);
        System.out.println();
    }
    
    public void leave(Object value) {
        level--;
        for(int k=0; k<level; k++) System.out.print(INDENT); // indent the message
        System.out.println("return "+value);
    }
    
    @Override
    public int fibonacci(int n) {
        enter("call fibonacci(%d)", n);
        int result = super.fibonacci(n);
        leave(result);
        return result;
    }

    public static void main(String[] args) {
        RecursionWithPrint rwp = new RecursionWithPrint();
        int n = 4;
        System.out.printf("fibonacci(%d)\n", n);
        System.out.println( rwp.fibonacci(n) );
    }
}
```
Output:
```
Compute fibonacci(4)
call fibonacci(4)
    call fibonacci(3)
        call fibonacci(2)
            call fibonacci(1)
            return 1
            call fibonacci(0)
            return 0
        return 1
        call fibonacci(1)
        return 1
    return 2
    call fibonacci(2)
        call fibonacci(1)
        return 1
        call fibonacci(0)
        return 0
    return 1
return 3
3
```

### Does This Help?
---

[codingbat.com]: https://codingbat.com.
[fibonacci]: https://codingbat.com/prob/p120015
[groupSum5]: https://codingbat.com/prob/p138907
