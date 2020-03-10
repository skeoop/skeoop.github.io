## Java Practice

We have some Lists containing Strings.

We want to write a method to remove strings with less than 3 characters 
from the list.

If you write this method is in a Java class, it needs to be static.
If you type it in jshell, it does not need to be static.

```java
/**
 * A method to remove short words using a for-each loop.
 * @param list is a list of strings to process. Short strings are removed.
 */
void removeShortStrings(List<String> list) {
    for(String word: list) {
        if (word.length() < 3) {
            System.out.println("Removing "+word);
            list.remove(word);
        }
    }
}

// In a class, you need to import java.util.Arrays. 
// In jshell its already imported.
List<String> words = Arrays.asList("apple","be","cat","it","to","bird","dog");
removeShortStrings(words);
System.out.println("List contains "+words);
```

**Problem 1** When you run this code, what happens?

**Problem 2** Look at the Java API for `asList` in `java.util.Arrays`.  (Really do it!) Explain *why* an exception was thrown.

**Problem 3** Since that didn't work, let's try putting the words in an ArrayList first.

```java
List<String> wordlist = new ArrayList<>( );
wordlist.addAll( words );  // copy from the 'words' list into ArrayList
// now process the list
removeShortStrings( wordlist );
System.out.println("List contains "+wordlist);
```

What happens this time?

**Problem 4** Explain *why* an exception was thrown in Problem 3.

**Problem 5** Write another method that uses an indexed "for" loop to scan the list.
```java
void removeShortWords(List<String> list) {
    for(int k=0; k<list.size(); k++) {
        if (list.get(k).length() < 3) {
            System.out.println("Removing "+list.get(k));
            list.remove(k);
        }
    }
}

removeShortWords(wordlist);  // same ArrayList as before
System.out.println("List contains "+wordlist);
```
Does it work?  Explain why?

**Problem 6** Make the simplest possible modification to `removeShortwords` so that it works correctly.

**Problem 7** 

7.1 In Problem 1 we used `Arrays.asList(e1, e2, ...)` to create a list from the arguments.  The `java.util.List` interface has what method to do the same thing?


7.2 Name 2 things about this method that a programmer should remember (otherwise, he may get unexpected results).


