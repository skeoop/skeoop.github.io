## Lab 7

Today's lab is due at **noon today**.  Its short, so everyone should finish.
Ask TA to check problem 1.

1. Modify GameConsole.java in Lab1 so that the program never crashes or throws exception.
   * If user inputs an invalid guess, print "Please input an integer", discard the current input line, and wait for new input.
   * If there is no more input (user press CTRL-D or CTRL-Z on Windows) then just exit -- no exception thrown.
   * Whenever the user inputs a guess, after you read the number discard the rest of the input line.  This avoids synchronization problems.

2. Ask someone else to test your GameConsole after you modify it.   The tester should try to make it crash and print an exception.

3. Modify the money classes in CoinPurse so that they throw IllegalArgumentException, with a helpful message in the exception, if a parameter value is invalid.  
   * Coin and Banknote must have a positive value.
   * Currency may not be null or an empty string or white-space only.
   * In the constructor Javadoc you should document that value must be positive and add a `@throws IllegalArgumentException`.


### Documenting Requirements and Exceptions

Example of how to document requirements for parameters and exceptions.

```java
public class Person {

    /**
     * Initialize a new Person object.
     * @param name is the person's name. It must be a non-null, non-empty String.
     * @throws IllegalArgumentException if name is null or empty.
     */
    public Person(String name) {
        if (name==null || name.trim().isEmpty())
          throw new IllegalArgumentException("name must be a non-empty string");
        this.name = name;
    }
```

