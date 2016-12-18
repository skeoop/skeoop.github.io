Complete and correct this code. Circle the errors and write corrections.
There are also omissions. Correct syntax, bad code style, and
and Javadoc comment errors.
```java
/*
 * a coin
 * @Bill Gates
 */
public __________ Coin {
    private int value;

    public Coin(int value) {
        ______________
    }

    /**
     * Get the value of this coin.
     * @return value of this coin
     */
    public int getValue(int value) {
         return value;
    }

    public String toString() {
        System.out.print(value+"-Baht coin");
    }
}
```

Write an `equals` method for the `Coin` class that compares coin values.
Use the standard template, as in the *Java Fundamental Methods* document:
1. test if param is null
2. test if param belongs to same class as "this", using the `.getClass()` method.
3. **cast** the param to a Coin object reference, and define a variable for it.
4. finally compare the values of "this" and the cast parameter. Return true if both coins have the same value.

```java
/**
 * Two coins are equal if they have the same value.
 * @param obj reference to compare to this coin.
 * @return true if obj is a Coin with same value as this coin.
 */
public boolean equals(Object obj) {






}
```

Using Java, how can you get an 'int' value from a string? That is, convert a `String` to an `int`?
Try to write at least 3 ways (to demonstrate your Java skill).
```java
String s = "1234";
// write 3 ways to get an int from String s.
int n1 = __________________________;
int n2 = __________________________;

int n3 = __________________________;
```
