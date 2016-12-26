Exercises on object references

## Background: Date class

The original Java class for dates is `java.util.Date`.  To create a date, use:
```
import java.util.Date;

Date birthday = new Date( 95, 5, 21); // 21 June 1995. Year is always +1900. Jan=0, Feb=1, March=2, ...
// a better way to set the month is use Calendar class.
Date birthday = new Date( 95, Calendar.JUNE, 21); 
```
You can **change** a Date using `setDate`, `setMonth`, and `setYear`.
```java
// Change the date to 25 December 2001
birthday.setDate(25);
birthday.setMonth(Calendar.DECEMBER);  // or setMonth(11)
birthday.setYear(101);   // actual year - 1900.
```

## Question 1: Copying Dates?

What date is printed when we execute this code:
```
import java.util.Date;
Date a = new Date( 100, 0, 15 ); // 15 january 2000
Date b = a;
b.setMonth(11);    // change month to December
System.out.println( a.toString() );
```
Answers:
1. 15 January 2000
2. 15 December 2000

Give a reason for your answer.

## Question 2: 





## Better Date classes.

Java 8 has a new package `java.time` containing more convenient classes for dates, times,
and intervals of time.  For example, to create a date for 25 December 2001 use:
```
import java.time.LocalDate;
import java.time.Month;
LocalDate xmas = LocalDate.of(2001, 12, 25); // 12 = December!
// or use a named constant for month (for clarity)
LocalDate xmas = LocalDate.of(2001, Month.DECEMBER, 25);
```



## 2. What are the classes and attributes in this problem?

A board game is played by 2 players on an 8x8 board.  Each player has a number of pieces on the board. Each player's pieces have different color (can be any color but not the same color). The players take turns moving a piece, like in chess.  There are three types of pieces: A, B, and C.  Each piece moves differently.  A pieces can capture any piece (A, B, C), B and C can capture each other.

* What classes would you use to write code for this game?
* What are some attributes of the classes?
* What are some methods of the classes?

