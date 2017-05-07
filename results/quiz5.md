# Feedback on Quiz5

## sumArray(double[] array)

To use recursion, you need to make the problem smaller at each step.
In this case we can make the problem smaller by adding a parameter
to indicate the last (or first) index of array to sum.
I chose the last index since it is fast to check `lastIndex < 0`
in termination test.

Define a helper method:  `sumArray(double[] array, int lastIndex)`
that computes `a[0]+a[1]+...+a[lastIndex]` using recursion.

Then the solution is:
```java
double sumArray(double[] array) {
    return sumArray(array, array.length-1);
}
```

**Base case:** should be `lastIndex < 0` and not `lastIndex == 0`.
What if the original array is empty?  If you test using `lastIndex==0`
your code will try to access a[0] and throw IndexOutOfBoundsException.

**Don't Use == in Termination Checks** its a general rule for defensive
programming to use `<`, `<=`, etc. instead of `==` for most cases.

**Recursion step:** to see the recursion step it might help to solve
a small problem on paper.  For example: `sumArray(a,4)` on paper:
```
sumArray(a,4)
need:  
    (a[0]+a[1]+a[2]) + a[3]
the ( ) part needs:
    (a[0]+a[1]) + a[2]
the ( ) part needs:
    (a[0]) + a[1]

as method calls:
    sumArray(a,2) + a[3]
which performs:
    sumArray(a,1) + a[2]
which performs:
    sumArray(a,0) + a[1]
which performs:
    sumArray(a,-1) + a[0]
which returns:
    0              + a[0]
```


## isPalindrome(String phrase)

Try to write simple code so that you can clearly see the logic.
Here is an example of poorly written code, with instructions how to simplify.
As we simplify, the logic errors become easy to spot.
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

5. Now a logic error is easy to see.  Forgot to convert `last` to lowercase before comparing it to `first`.
```
	if (Character.toLowerCase(first) == Character.toLowerCase(last)) {
		return isPalindrome(phrase.substring(1, length - 1));
	}
    return false;
```

There is a mistake in the problem statement on quiz.  A phrase of length 1 
is a palindrome *if it is a letter*.  For example, "?" is not a palindrome.
Fixing that mistake, the final code is:
```java
public static boolean isPalindrome(String phrase) {
    int length = phrase.length();
	if (length < 1) return true;
	char first = phrase.charAt(0);
    if (length == 1) return isLetter(first);

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

The above code has 3 recursive calls to `isPalindrome` and they are
almost the same.  We could reduce them to just 1 recursive call:

```java
public static boolean isPalindrome(String phrase) {
    int length = phrase.length();
	if (length < 1) return true;
	char first = phrase.charAt(0);
    if (length == 1) return isLetter(first);
	
	char last  = phrase.charAt(length-1);
	if (!Character.isLetter(first)) { // skip non-letter
		phrase = phrase.substring(1, length);
	}
    else if (!Character.isLetter(last)) { // skip non-letter
		phrase = phrase.substring(0, length-1);
	}
    else {
        // both first and last are letters, so compare them
		if (Character.toLowerCase(first) != Character.toLowerCase(last))
            return false;
		phrase = phrase.substring(1, length-1);
	}
	return isPalindrome(phrase);
}
```
which one is easier to understand?

The textbook (chapter 13) solves isPalindrome by defining a helper method
with first and last indices, so we don't need to use substring.

