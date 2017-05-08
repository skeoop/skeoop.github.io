# Feedback on Quiz5

## sumArray(double[] array)

To use recursion, you need to make the problem smaller at each step.
In this problem, make the problem smaller by shrinking the array to sum.
To do that (since you can't resize an array), we need to add a parameter
for the last index (or first index) of the elements to sum.
I chose the last index since it is simpler to check `lastIndex < 0`
in the termination test.

Define a helper method:  `sumArray(double[] array, int lastIndex)`
that computes `a[0]+a[1]+...+a[lastIndex]` using recursion, like this:
```
sumArray(a, lastIndex) = a[lastIndex] + sumArray(a, lastIndex-1)
                       = a[lastIndex] + a[lastIndex-1] + sumArray(a,lastIndex-2)
                       = . . .
```

Then call the helper method like this:
```java
double sumArray(double[] array) {
    return sumArray(array, array.length-1);
}
```

**Base case:** termination test should be `lastIndex < 0` and not `lastIndex == 0`.
What if the original array is empty?  Then lastIndex=-1.

**Don't Use == in Bounds Tests** its a general rule for defensive
programming to use `<=` or `>=` instead of `==` for bounds checks.

**Recursion step:** to see the recursion step it might help to solve
a small problem on paper.  For example: `sumArray(a,4)` on paper:
```
sumArray(a,3)
to compute:  
    (a[0]+a[1]+a[2]) + a[3]
the (..............) part is:
    (a[0]+a[1]) + a[2]
the (.........) part is:
    (a[0]) + a[1]

as method calls:
sumArray(a,3) =
    sumArray(a,2) + a[3]
sumArray(a,2) = 
    sumArray(a,1) + a[2]
sumArray(a,1) =
    sumArray(a,0) + a[1]
sumArray(a,0) = 
    sumArray(a,-1) +a[0]
sumArray(a,-1) =
    return 0
```


## isPalindrome(String phrase)

Try to write simple code so that you can clearly see the logic.
Some students wrote complex code that contains errors.
Here is an example.
As we simplify the code, the logic errors become easy to spot.
```java
public static boolean isPalindrome(String phrase) {
    char first = phrase.charAt(0);
    if (phrase.length() == 1) {
        return true;
    }
    if (!Character.isLetter(phrase.charAt(phrase.length() - 1))) {
        return isPalindrome(phrase.substring(0, phrase.length() - 1));
    }
    if (!Character.isLetter(first)) {
        return isPalindrome(phrase.substring(1, phrase.length()));
    }
    if (Character.toLowerCase(first) == phrase.charAt(phrase.length() - 1)) {
        return isPalindrome(phrase.substring(1, phrase.length() - 1));
    }
    return false;
}
```

1a. Logic Error: should check that `phrase` has length > 0 **before** calling `charAt(0)`.

1b. Good Programming: Use ">=" or "<=" instead of "==" in range checking.
```java
public static boolean isPalindrome(String phrase) {
    if (phrase.length() <= 1) return true;
```

2. Define local variable for repeated expression `phrase.length()`.  Eclipse has a refactoring that will do this for you. 
```java
public static boolean isPalindrome(String phrase) {
    int length = phrase.length();  // ADD VARIABLE FOR REPEATED EXPRESSION
    if (length <= 1) return true;
    
    char first = phrase.charAt(0);
    if (!Character.isLetter(phrase.charAt(length - 1))) {
        return isPalindrome(phrase.substring(0, length - 1));
    }
    if (!Character.isLetter(first)) {
        return isPalindrome(phrase.substring(1, length));
    }
    if (Character.toLowerCase(first) == phrase.charAt(length - 1)) {
        return isPalindrome(phrase.substring(1, length - 1));
    }
    return false;
}
```

3. Define local vars at the point they are needed.  After defining `first`, the code should test it.  So swap the two `if` statements:
```java
public static boolean isPalindrome(String phrase) {
    int length = phrase.length();  
    if (length <= 1) return true;
    
    char first = phrase.charAt(0);
    if (!Character.isLetter(first)) { // SKIP NON-LETTER AT START
    	return isPalindrome(phrase.substring(1, length));
    }
    if (!Character.isLetter(phrase.charAt(length - 1))) {
    	return isPalindrome(phrase.substring(0, length - 1));
    }
    if (Character.toLowerCase(first) == phrase.charAt(length - 1)) {
    	return isPalindrome(phrase.substring(1, length - 1));
    }
    return false;
}
```

4. Add **explanatory variable** for complex expression `phrase.charAt(length-1)`.
```java
public static boolean isPalindrome(String phrase) {
    int length = phrase.length();
    if (length <= 1);
    
    char first = phrase.charAt(0);
    if (!Character.isLetter(first)) {
    	return isPalindrome(phrase.substring(1, length));
    }
    char last  = phrase.charAt(length-1); // ADD EXPLANATORY VARIABLE
    if (!Character.isLetter(last))  {
    	return isPalindrome(phrase.substring(0, length - 1));
    }
    if (Character.toLowerCase(first) == last) {
    	return isPalindrome(phrase.substring(1, length - 1));
    }
    return false;
}
```

5. Now a logic error is clear.  Forgot to convert `last` to lowercase before comparing it to `first`.
```java
    if (Character.toLowerCase(first) == Character.toLowerCase(last)) {
    	return isPalindrome(phrase.substring(1, length - 1));
    }
    return false;
```

The final code is:
```java
public static boolean isPalindrome(String phrase) {
    int length = phrase.length();
    if (length <= 1) return true;

    char first = phrase.charAt(0);
    if (!Character.isLetter(first)) { // skip non-letter
    	return isPalindrome(phrase.substring(1, length));
    }
    char last  = phrase.charAt(length-1);
    if (!Character.isLetter(last)) { // skip non-letter
    	return isPalindrome(phrase.substring(0, length - 1));
    }
    if (Character.toLowerCase(first) == Character.toLowerCase(last)) {
    	return isPalindrome(phrase.substring(1, length - 1));
    }
    return false;
}
```

The textbook (chapter 13) solves isPalindrome by defining a helper method
with first and last indices, so you don't need to use substring.

