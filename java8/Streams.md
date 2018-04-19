---
layout: page
title: Streams
description: Streams and Aggregate operations for Collections
---

## Streams

A **Stream** or **Aggregate Operation** lets you operate on a collection of things using a pipeline of operations.  To effectively use streams, you need to be familiar with the new **functional interfaces** in `java.util.function`.  These are introduced in the lesson on [Lambda Expressions](Lambda-Expressions).

Suppose we want to print the student id and name of a list of Students.
```java
for(Student s: classlist) {
    System.out.printf("%s  %s\n", s.getId(), s.getName() );
}
```

Using a stream we can write:
```java
classlist.stream()
         .forEach( s -> System.out.printf("%s %s\n", s.getId(), s.getName()) );
```

The `stream()` command creates a stream for the list and "pipes" each list element into the stream.  `forEach()` applies a `Consumer` object to each element of the stream.  In effect, it *consumes* the Stream.

The Iterable interface (every Collection is Iterable) also defines a `forEach()` method.  So, we could write:
```java
Consumer<Student> printStudent = s -> System.out.printf("%s %s\n",s.getId(), s.getName());
classlist.forEach( printStudent );
```

## Stream as a Pipeline

A Stream is a pipeline of operations.
The end of the pipeline is usually one of sum

* Something that **consumes** the stream
* Something that **collects** the elements. This may including **grouping**.
* Something that **summarizes** the elements

### Consume the Stream

A Stream that ends with a `forEach(Consumer)`, such as:

```java
collection.stream()
          .filter(/*some filter operation*/)
          .forEach( x -> System.out.println(x) );
```

### Collect the Stream

A Stream that ends with `collect(Collector)` will return whatever the `Collector` parameter returns.
The `java.util.stream.Collectors` class contains static methods for creating useful collectors.  The type parameter of these methods is *inferred* from the Stream.

Example: collect all the students whose student ID begins with "60" into a new list:

```java
List<Student> freshmen = 
    classlist.stream()
             .filter( s -> s.getId().startsWith("60") )
             .collect( Collectors.toList() );
```

### Summarize the Result

Some Collectors create a summary of the stream as a single value.
There are static methods in the `Collectors` class to compute sums and averages.

There are also some special cases: DoubleStream, IntStream, and LongStream have a `.sum()` and `.average()` method.

```java
// compute the sum of ages of students in the class 
int sum = classlist
             .stream()
             .mapToInt( student -> student.getAge() )
             .sum();
```

### Application to Money and Purse

The Purse contains Money (`Valuable`) objects. Suppose we want to know how many "Baht" are in the purse. Using a loop, we could write:

```java
double sum = 0.0;
for( Valuable x: purse.getItems() ) {
    if (x.getCurrency().equals("Baht")) sum += x.getValue();
}
System.out.printf("Purse contains %.2f %s\n", sum, "Baht");
```

To do this using stream, first filter by currency, then map to double, and sum.

Since the value is "double" (primitive) use `stream.mapToDouble(ToDoubleFunction)`.

```java
double sum = purse.getItems().stream()
                .filter( m -> m.getCurrency().equals("Baht") )
                .mapToDouble( m->m.getValue() )
                .sum();
```

## Parallel Streams

You can also operate on a stream in parallel.

## References

* [Streams Tutorial](https://docs.oracle.com/javase/tutorial/collections/streams/) in Oracle Java Tutorial.
* Winterbe's [Streams Tutorial Examples](http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/)
