## Lab 13 Solution and Scoring

*TAs please decide how to score.  Tell me and I'll revise this table.*

| Item   | Score |
|:-------|:-----------|
| max    | 3 pt if correct, 1 - 2.5 if nearly correct. |
| sortMoney | 3 pt if correct, 1 - 2.5 pt if nearly correct. |
| filterByCurrency | 3 pt if correct, 1 - 2.5 pt if nearly correct. |
| code quality, javadoc | 1 pt       | 
| printValuables | -1 pt if doesn't print each item in list  | 
  
## 1 and 2. max 

The type parameter (E) must be "a type Comparable with some superclass of E".

```java
public static <E extends Comparable<? super E>> E max(E ... args) {
    if (args.length == 0) throw new IllegalArgumentException(
                          "At least one argument must be given.");
    E max = args[0];
    for(E arg: args) if (arg.compareTo(max)>0) max = arg;
    return max;
}
```
Or, using a Stream:
```java
public static <E extends Comparable<? super E>> E max(E ... args) {
    if (args.length == 0) throw new IllegalArgumentException(
                          "At least one argument must be given.");
    Comparator<E> compare = (a,b) -> a.compareTo(b);
    // max() returns an Optional<E>, but it always has a value
    // because the Stream is not empty. So .get() returns the value.
    return Stream.of(args).max( compare ).get();
}
```

## 3. sortMoney

This should not be a *generic method* but should have a wildcard ("?"):
```java
public static void sortMoney( List<? extends Valuable> valuables) {
    Comparator<Valuable> byValue = 
          (a,b) -> Double.compare(a.getValue(), b.getValue());
    Collections.sort(valuables, byValue);
    // or use the List own sort method:
    valuables.sort( byValue );
}
```

## 4. filterByCurrency

This method needs a type parameter so it can filter `List<Coin>`,
`List<Banknote>`, as well as `List<Valuable>`.

```java
/**
 * Return a list of the items from the money List where the objects
 * have the same currency as the currency parameter.
 */
public static <E extends Valuable> List<E> filterByCurrency(
       List<E> money, final String currency ) {
    // Solution using a loop.
    List<E> result = new ArrayList<E>();
    for(E m: money) if (currency.equals(m.getCurrency()) result.add(m);
    return result;

    // Solution using a Stream and filter:
    return money.stream()
                .filter( m -> currency.equals(m.getCurrency()) )
                .collect( Collectors.toList() );
}
```

## 5. Did students review their code?

Some students have a method like this.  It shows they didn't
to test their own code.  Deduct some credit for this:

```java
/**
 * Print all the items in the list.
 */
public static void printValuable(List<Valuable> valuables) {
    System.out.println( valuables );   // wrong
}
```

Not required, but method is more flexible if it has a wildcard (?) like this:

```java
public static void printValuable(List<? extends Valuable> valuables) {
    // old way, using a loop
    for(Valuable v: valuables) System.out.println( v );
    // or, using Java 8 features
    valuables.forEach( System.out::println );
}
```

**Example of Poor Coding**: In the Javadoc, (a) "list of Coins to sort" is misleading, (b) `@param list` doesn't match actual parameter name `money`, (c) no `@return` tag.
```java
/**
 *  Filter money by a currency.
 *  @param list is the list of Coins to sort
 *  @param currency is name of currency to look for
 */
public static <E extends Valuable> List<E> filterByCurrency(
       List<E> money, final String currency ) {
```

## 6. Did student clean up his/her code?

A few students have large blocks of commented-out code in MoneyUtil.
The lab sheet instructs to delete it.  In *Clean Code* Robert Martin
recommends this. Dead code makes another programmer wonder why its
their and what you were intending to do. 

When you have a block of test code that you want to keep,
put the code in a private method (with a descriptive name or comment) 
instead of commenting it out.

Don't deduct points for this, but put a comment in online spreadsheet.

