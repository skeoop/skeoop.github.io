## Lab 10, part 1: Recursion

This week there are 2 parts to the lab:

* Recursion - study recursion and do some practice problems

* Strategy Pattern - refactor Coin Purse to use the strategy pattern.  This is mostly just a refactoring of your existing code, which you will use next week.

### Share Account On CodingBat.com

In Lab 4 you created an account on codingbat.com, added your *real name*, and in "Teacher Share" you shared scores with j.brucker@ku.th.

If anyone didn't do this, please see instructions in [Lab 4](Lab4-coding).

### Deadline

Deadline posted on Google Classroom.

### Problem 1: Solve Recursion Problems on CodingBat

In the **Recursion-1** group, solve (at least) these problems:
```
factorial
fibonacci
triangle
sumDigits
changeXY
stringClean
```

In the **Recursion-2** group, solve these problems:

```
groupSum  - this is similar to what you will use in the Coin Purse!
groupSum6
groupNoAdj
splitArray
```

The Recursion-2 problems use backtracking, which is important.

Solution Help: [codingbat][codingbat] has explanations of Java, solution logic, and code examples to help solve the problems.  

### Problem 2: List Utilities using Recursion

Assignment and Starter Code on Github: https://classroom.github.com/a/IRWJHnWt

Complete the `ListUtil` class.  There are 2 static methods to write:

### unique(List<T> list)

It returns a new list containing the *first* unique occurrence of each element in `list` (the parameter).

1. Use recursion.  Do not use a loop.
2. `unique` should not modify the `list` parameter!  Don't sort it, either.
3. The type **T** is a static type parameter, so that `unique` can be called with any list of objects (String, Number, etc).
3. Don't make any *copies* of the list.  For the recursive call, use `list.subList()` which returns a *view* of part of the original list (not a copy of the list).  Or, write a *helper method*.
4. You only need to create a new List (for the return value) **once**, and it is created at the point where recursion stops.  Each time recursion *returns*, the caller just adds something to the list that was returned -- don't create a new list at each step.

Examples
```java
List<String> list = new ArrayList<>();
// add some elements
list.addAll( Arrays.asList("a","b","c","d") );
// make a view containing "b","c","d"
List<String> sub = list.subList(1, list.size());
sub
["b","c","d"]
sub.remove(0);  // removes element 1 from original list !
list
["a","c","d"]

List<String> list = new ArrayList<>();
// add some elements
list.addAll( Arrays.asList("a","b","a","a","z","b","z") );
ListUtil.unique(list)
["a", "b", "z"]

List<Number> list = new ArrayList<>();
ListUtil.unique(list)
[]               // list is empty
list2.add(new Double(2));
list2.add(new Double(2));  // two identical elements
ListUtil.unique(list2)
[2.0]
```

### flatten(List<?> list)

"Flatten" a list that contains nested lists and return a single list containing all elements from all nested lists.  If there are no nested lists, it returns a list identical to the parameter.

The type parameter `List<?>` means "a list of anything".  You could omit it, but the Java compiler will give warnings about missing type parameter.

Example using Jshell:
```java
> List<String> list1 = Arrays.asList("a", "b");
> List<?> list2 = Arrays.asList(list1, "c", "d");
> List<?> list3 - Arrays.asList("x", "y", list2, "z");
> list3
[x, y, [[a, b], c, d], z]
> ListUtil.flatten(list3)
[x, y, a, b, c, d, z]
> ListUtil.flatten(list1)     // no embedded lists
[a, b]
```

