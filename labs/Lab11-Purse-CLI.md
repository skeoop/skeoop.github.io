## Lab 11, part 2: Purse Command Line

How can we change which withdraw strategy the Purse uses? Set the capacity?

## Assignment: Add Command Line Options

Add two command lines to the `Main.main` method for the Purse application class:

```
coinpurse.Main -strategy greedy|recursive -capacity n
```

The command line options (`-strategy` and `-capacity`) are optional.

`-strategy` has a value of **greedy** or **recursive**. If `-strategy` is not specified the default is "greedy".

`-capacity` is the capacity of the purse. It must be a non-negative integer. If not specified, the default capacity is 10.

### Command Line Processing

1. If an invalid option is used, print an error message including the actual option, such as: "invalid option -size".
2. If a valid is used but the value for it is omitted, then print "missing value for -strategy" (or -capacity) and exit.
3. If an invalid value is given for an option, print an error message and exit. Don't throw exception.

### Example

```
> coinpurse.Main -strategy recursive
creates a Purse with capacity 10 that uses RecursiveWithdraw.

> coinpurse.Main -capacity 1
creates a Purse with capacity 1 that uses GreedyWithdraw.

> coinpurse.Main -strategy
Error: missing value for -strategy

> coinpurse.Main -size 1
Error: invalid option -size
```

### Optional:  Dynamically Load New Strategies?

Is there any way we can add a new strategy at runtime, without modifying the Purse?

For example:
```java
package coinpurse.strategy;
import coinpurse.Valuable;
import java.util.List;

public class NoWithdraw implements WithdrawStrategy {
    @Override
    public List<Valuable> withdraw(double amount, String currency, List<Valuable> list)
    {
         // never withdraw anything
         return null;
    }
}
```

and then be able to write:
```
java coinpurse.Main -strategy coinpurse.strategy.NoWithdraw
```

and the Purse would automatically discover, load, and use `NoWithdraw`.

Its called "*dynamic class loading*" and is used by many Java frameworks.  The Java JDBC (database) software uses it, too.
