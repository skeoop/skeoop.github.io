# Collections Practice

These exercises demonstrate properties of some common collections.

1. Clone the starter code from Github Classroom.
2. Do the exercises.
3. Write your findings in README.md
4. Push the completed code to Github.

## Set and Implementations

A Set is collection with:
* no duplicates
* order of items is determined by the Set, not by the programmer

In Java, `Set` is an interface that extends the `Collection` interface.  Set doesn't add any new methods, but changes the *semantics* of some methods defined in `Collection`.

The Java SE defines 2 concrete classes that implement `Set`:
* `HashSet` puts objects in "buckets" using the object's `hashCode`.
* `TreeSet` maintains an ordered collection of Objects.  The ordering can be either:
    (a) the natural order, for objects that implement *Comparable*
    (b) order specified by a *Comparator* that is given as a parameter to the TreeSet constructor.  You used a Comparator in Lab 3.
      
## Set Practice

Code: `SetExercise.java`

Complete the setExplorer method:

1. Create a HashSet<String> object and add these strings: "dog", "ant", "bird", "elephant", "cat".  `Set` and `Collection` interfaces defines an `add` method for this:
   ```java
   set.add("dog");
   set.add("ant");
   set.add("bird");
   etc.
   ```
   To eliminate redundant code, you may write a method that let's you add all the elements at once:
   ```java
   private static void addAll(Set<String> set, String ... args) {
       for(String arg: args) {
          System.out.print(" "+arg):
          set.add(arg);
       }
       System.out.println();
   }
   // then use:
   addAll(set, "dog", "ant", "bird", etc.);
   ```
2. Print the items in the set, using an Iterator. Every collection has an `iterator()` method that creates a new Iterator for the contents of the collection.  So you write:
   ```java
   Iterator<String> iter = set.iterator();
   while( iter.hasNext() ) {
      // get the next element from iterator and print it
   ```
   * You'll need to print the set again, so consider writing a method `print(set)` to do this.
   * `Collection` defines an `iterator()` method that returns a **new** Iterator over the collection.  For example:
3. **Question**: are the items in Set in the same order that you added them?  What does this tell you about Sets that is different from a List?
4. Remove all items from the Set. 
    * Set (and every Collection) has a method to do this.  What is it?
5. Add the same elements as item 1, but in a different order such as:  "cat", "elephant", "ant", "dog", "bird".
6. Use an Iterator to print the items in the set (again).    
**Question**: Are the items in the same order as before?
7. Add duplicate items.  Add another "cat" and "dog" to the set.  To ensure that these are *distinct* objects use 'new String("cat")' and 'new String("dog")'.    
Print the set again.
8. **Question**: Are there 2 cats and 2 dogs?  What property of Set does this demonstate?
9. Repeat 1-8 using a TreeSet instead of HashSet.   
   Hint: Use Polymorphism.  Modify `setExplorer` so that the Set object is a *parameter* to the method (instead of creating set in the method), so you can easily call the method with a different Set (TreeSet) as parameter.  In main, create a TreeSet<String> as parameter.

**Question:** What is different when you use TreeSet?
		
10. Look at the code for these methods:
    ```
    private static void addAll(Set<String> set, String ... args)
    private static void print(Set<String> set)
    ```
    what Set behavior do they use?  Could you change the parameter to `Collection` instead? 
    * *Collection* is a parent of *Set*, *List*, and some other collections.  So a method that accepts any *Collection* is more reusable.
    



