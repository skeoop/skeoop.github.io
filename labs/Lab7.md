## Lab 7

There are 4 problems for this lab.

1. Modify GameConsole.java in Lab1 so that the program never crashes or throws exception.
   * If user inputs an invalid guess, print "Please input an integer", discard the current input line, and wait for new input.
   * Whenever the user inputs a guess, after you read the number discard the rest of the input line.  This avoids synchronization problems.
   * If there is no more input (user press CTRL-D or CTRL-Z on Windows) then just exit -- no exception thrown.

2. Test someone else's GameConsole after they have modified it.  Try to make it crash or throw exception.
   * If you make it crash or throw exception, then open an issue in their Github repo describing how to reproduce the problem.

3. Modify the money classes in CoinPurse so that they throw IllegalArgumentException, with a helpful message in the exception, if a parameter vallue is invalid.  
   * Coin and Banknote must have a positive value.
   * Currency may not be null or empty string or white-space only.
   * In the constructor Javadoc you should document that value must be positive and add a `@throws IllegalArgumentException`.

4. Stack?

 

### Documenting Requirements and Exceptions

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
