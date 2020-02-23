---
layout: page
title: Intro to Map
description: 
---

## Introduction to Map

A Map is a collection of key-value pairs.  The keys must be distinct.
In Java, Map is an interface with 2 type parameters: one for the Key (K) and one for the Value (K).  In the Java API this is shown as `Map<K,V>`.

If we wanted a Map where the keys are Strings and the values are doubles, we'd use: `Map<String,Double>`.  You must use `Double` instead of `double` because (unfortunately) Java doesn't allow primitive types as type parameters.

## The Map Classes

There are several classes that implement the Map interface.  The most common ones are:

* `HashMap<K,V>` - uses the hashcode of keys to order items in the map.
* `TreeMap<K,V>` - uses the natural sort order of keys or a Comparator to put items in the map.
* `Properties` - the Properties class also implements the Map interface. Properties extends the `Hashtable` class (an order version of `HashMap`).

## Map Methods with Examples

Some important methods of Map are:

<table border="1">
<tr valign="top">
<td>
put(key, value)
</td>
<td> add a key-value pair to map, or replace existing value.
</tr>
<tr valign="top">
<td>
get(key)
</td><td>
 return the value for a given key. null if key is not in map.
 </td>
 </tr>
 <tr valign="top">
 <td>  
 getOrDefault(key,default)
 </td>
 <td>
 return the value of a key. If key is not in map return a default value.
 </td>
 </tr>
<tr valign="top">
<td>size()</td>
<td>
 number of key-value pairs in map.
 </td>
 </tr>
<tr valign="top">
<td> keySet()</td>
<td>
return a Set<V> of all the keys in the map.
</td>
</tr>
</table>

You can use any class for keys and values.  To create a map from colors (strings) to BankNotes in the coin purse,
we could write:
```java
Map<String,BankNote> map = new HashMap<String,BankNote>();
// "red" banknotes are 100 Baht
map.put("red", new BankNote(100,"THB"));
// "purple" banknotes are 500 Baht
map.put("purple", new BankNote(500,"THB"));
```
If someone asks for a purple banknote, we would write:
```java
BankNote note = map.get("purple");
```

## Example: Counting Votes

We have an input file containing "votes" for people's favorite food.
The file contains names of favorite food, one per line, like this:
```
chocolate
ice cream
pizza
coffee
CHOCOLATE
banana
ice cream
Pizza
Ice Cream
```
we want to count how many votes for each food.

Let's separate the tasks of reading word from the task
of counting votes.  
* `readVotes(InputStream in)` - read the votes
* `countVote(String vote)` - count one vote
* `printVotes()` - print the votes

The map: the **keys** are are the names of food that people have voted for.  The **values** are the number of votes for that food.  Declare a Map like this:
```java
    Map<String,Integer> votes = new HashMap<String,Integer>();
```
to count 1 vote for "chocolate" we would write:
```java
votes.put("chocolate", 1);
```
to get the number of votes for "chocolate", use:
```java
int count = votes.get("chocolate");
```
`votes.get()` may return null if the key is not in the map, which will cause an exception in this code.
A safer alternative is:
```java
int count = votes.getOrDefault("chocolate", 0);
```

The basic favorite-food vote counting code is:

```java
public class VoteCounter {
    // Map of votes
    Map<String,Integer> votecount;

    public VoteCounter() {
        votecount = new HashMap<String,Integer>();
    }

    /** Parameter is name of the food a person votes for. */
    public void countVote(String vote) {
        // get count for this vote and add 1
        int count = 0;
        if (votecount.containsKey(vote))
            count = votes.get(vote);
        count = count + 1;  // count this vote
        votecount.put(vote, count);
    }
}
```
The reason for the `if` statement is to avoid getting
a `null` value for a key (vote) that isn't in the map.
We can avoid the `if` statement by using `getOrDefault` instead:
```java
    public void countVote(String vote) {
        // get count for this vote, or 0 if no match in map
        int count = votecount.getOrDefault(vote, 0);
        count = count + 1;  // count this vote
        votecount.put(vote, count);
   }
```

Now how do we print the votes?
Use the `map.keySet()` method to get all the keys,
and then use the keySet in a for loop.  For example:
```java
    /** Print all the vote counts. */
    public void printVotes() {
        Set<String> keyset = votecount.keySet();
        for(String vote: keyset) {
            System.out.printf("%-20.20s  %3d\n",
               vote, votecount.get(vote));
        }
    }
```
This prints:
```
chocolate    1
ice cream    2
Ice Cream    1
pizza        1
CHOCOLATE    1
banana       1
coffee       1
Pizza        1
```
We see two problems: 1) food names should ignore case, 2) the HashMap keys (food names) are not in alphabetical order.

We can fix the first problem by converting votes to lowercase:
```java
    public void countVote(String vote) {
        vote = vote.toLowerCase();
```
To get a sorted list of keys there are 2 solutions.
First, we could sort the keys in the HashMap keySet.  Since we cannot sort a Set,
copy the keys to an array first.
```java
    /** Print all the vote counts. */
    public void printVotes() {
        Set<String> keyset = votecount.keySet();
        // copy the keys to an array (keys) and sort them
        String[] keys = new String[ keyset.size() ];
        keyset.toArray(keys);
        java.util.Arrays.sort(keys);
        for(String vote: keys) {
            System.out.printf("%-20.20s  %3d\n",
               vote, votecount.get(vote));
        }
    }
```
However, there is a simpler way.  The `TreeMap` class provides a Map where the keys are always sorted, either by natural sort order (defined by `compareTo`) or using a `Comparator`.  This is similar to `TreeSet` for a set.  If we use `TreeMap` instead of `HashMap` then we don't need to sort the keys!

```java
public class VoteCounter {
    // Map of votes
    Map<String,Integer> votecount;

    public VoteCounter() {
        votecount = new TreeMap<String,Integer>();
    }

    public void countVote(String vote) {
        vote = vote.toLowerCase();
        // get count for this vote, or 0 if no match in map
        int count = votecount.getOrDefault(vote, 0);
        count = count + 1;  // count this vote
        votecount.put(vote, count);
    }

    public void printVotes() {
        Set<String> keyset = votecount.keySet();
        // keyset is already sorted!
        for(String vote: keyset) {
            System.out.printf("%-20.20s  %3d\n",
               vote, votecount.get(vote));
        }
    }
}
```
Now we get a shorter list of votes:
```
banana       1
chocolate    2
coffee       1
ice cream    3
pizza        2
```

## Ignoring Case with a Comparator for Food names

`TreeSet` lets you specify a `Comparator` to use insteadof the
Key class's natural sort order.  We could define a Comparator
for case-insensitive String comparison.  Then we would not need
to convert the votes to lowercase.

## Challenge: Print Favorite Foods First

Instead of printing the votes by order of food name,
can you print them with the most popular foods first?
```
ice cream    3
chocolate    2
pizza        2
banana       1
coffee       1
```
You can do this by getting all the key-value pairs and
sorting them by value, using a Comparator class for key-value pairs.
`Map` has a `entrySet` method that returns the key-value
pairs as a set of `Entry<K,V>` objects.  In this example,
it would be `Entry<String,Integer>`.
The `Entry` class has a method `Entry.comparingByValue()`
that may help with sorting.



### Avoid Redundant Autoboxing

In the code for countVote, we used:
```java
   int count = votecount.getOrDefault(vote, 0);
```
the primitive `0` will be autoboxed to Integer(0) to match the type of values in the map.  To avoid redundantly creating
"new Integer(0)" objects, we could define
a static class constant ZERO for this object and use the constant
instead of primitive 0.
