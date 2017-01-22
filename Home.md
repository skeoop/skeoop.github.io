Other pages: [About the Course](About). [Results and Feedback](Results) on assignments. [Course Material](https://bitbucket.org/skeoop/oop/src/master) organized by week.

---
## [Week 1](https://bitbucket.org/skeoop/oop/src/master/week1)

0. Preliminaries.
	* Introduction to course.   
	* Requirements. Also on [About the course](About) page.
1. Review of Java basics  
    * Ex - Java exercise
    * Ex - Java naming convention. *Identify types of names.*
2. Java coding standard and Javadoc.
    * How to use the Java API docs (Javadoc).
    * Ex - fix the code (in lab)
3. Introduction to object and classes. A conceptual interpretation of objects.
    * Three characteristics of objects.
    * Example and exercise
    * Why program with objects?
    * The problems of software design and development.
    * O-O fundamentals and the "3 pillars" of O-O paradigm.
    * Polymorphism: Why can we "print" any object? How does Java handle this?
    * Encapsulation and access control: public, protected, private.
    * Inheritance.
    * Ex - use encapsulation to change implementation of Matrix or Classroom (OOP1).
4. Object References.  
    * A reference is *not* an object.
    * A useful analogy: reference is like a "remote control" for an object.  The buttons are the object's methods.  This helps explain how polymorphism works.


### Assignment, Part 1. Do this before lab tomorrow.

1. Install the command line `git` on your computer, from https://git-scm.com/download/. (Windows, MacOS X, or Linux)
2. After you install `git`, you should set your name and email. Execute these commands (with your name and email):

 ```
 cmd> git config --global user.name "Fatalai Jon"
 cmd> git config --global user.email fatalai.j@ku.th
 ```
3. Create an account on Github.
4. Include in your account profile:
    a. your *real name*, in English with correct capitalization.
    b. a photo that clearly shows your face.
5. (Helpful) Read a Git tutorial of your own choice.  [Try Git](https://try.github.io/) lets you try git in your browser and contains more than you need to know.


### Lab 1

There are 3 parts to the lab. The files are in the week1 folder.

1. [Lab1-1-Git.md](https://bitbucket.org/skeoop/oop/src/master/week1/Lab1-1-Git.md) practice using git.
2. [Lab1-2-fix-code.md](https://bitbucket.org/skeoop/oop/src/master/week1/Lab1-2-fix-code.md) practice writing good code and equals. (Skip this.)
3. Lab1-3-Guessing-Game write a Guessing Game in Java.  See the PDF for instructions. 
    * In Lab: commit source code for a game that works, and README.me
    * "push" a copy of your repo to your Gtihub account as `GuessingGame` repo
    * Due Tomorrow:
         * write good Java for classes and methods. Use @param, @return, @author tags.
         * fix any problems with your code.
         * format code to be easy to read.

*Please tell us your Github account*. Complete this form: [https://goo.gl/Y6EMeq](https://goo.gl/Y6EMeq).


### Assignment
**Read**: (1) Java Coding Standard, (2) Java Fundamental Methods  
**Learn**: UML class diagram for a single class. Use the Internet or read UMLD Chapter 3 (Class Diagram).   

**Homework**: [Homework 1](week1/Homework1.md)

----
##  [Week 2](https://bitbucket.org/skeoop/oop/src/master/week2)

Didn't cover in week1:
    * How Java and the JVM work.
    * Object references.
    * Coding standard and Javadoc.
    * How to read the Java API (you should already know).
    * Fundamentals: correct way to write `equals`.

1. Introduction to Polymorphism.
    * A key to the power of the O-O paradigm.
    * There are two ways to use polymorphism in Java: inheritance and interfaces.
    * Both ways are useful, but interfaces are more flexible.
2. Interfaces in Java. One of key ways to enable polymorphism.
3. Designing with Interfaces.  Factoring out common behavior.
4. UML Class Diagram.
    * How to show attributes, methods, visibility, static, and constants.
    * How to show interfaces and "implements".
    * How to show relationships: *dependency*, *association*, *inheritance*.
5. Lists and ArrayList (if we have time).
   * A very useful collection type. We will cover collections in week 3.


### Lab 2
Coin Purse in [Week 2](https://bitbucket.org/skeoop/oop/src/master/week2) folder

Code Review: TAs will do 1-on-1 code review of Lab 1.

### Exercises
1. Name 2 classes in Java API that you cannot create an instance. How do you know its impossible (e.g. no Factory method)?
2. Name 2 classes in Java API that you cannnot use "new XXX()" but you can create objects using a static method.
3. Name a class in Java API that you cannot use "new XXX()" but you can create objects using *another* class (either static or instance method).
4. The `System` class has many useful methods for getting "system" information.  `System.timeInMillis()` returns the current time in milliseconds (a long value).
  * What date (day, month, year) and time (hh:mm:sec) is time 0?
  * Java has a "millisecond date bug" similar to the "year 2000 bug", which would have caused programs to fail and required millions of dollars of old code to be modified or rewritten.  
  Eventually `System.timeInMillis()` will be too large to fit in a `long`, and the value will "wrap around" -- the Java "millisecond date bug".
     (a) what is the largest value that a `long` can hold? Use the Java API to get the value.
     (b) write Java statements to find the exact date of the "millisecond bug".  Submit your code. Hint: use `java.util.Date` or the more modern `java.time.*` classes.
     (c) What is the day, month, and year when `timeInMillis()` will fail?

### Assignment
**Read**: Polymorphism and Interfaces is covered in BIGJ 9.6 and 10.1-10.4.
**Programming Assignment**: [PA1-StopWatch](https://bitbucket.org/skeoop/oop/src/master/week2/PA1-StopWatch.pdf) is due on Bitbucket by **Monday, 2 Feb**.  
**Quiz Next Week**: Quiz on UML, Java Fundamental Methods, and Polymorphism next week


----
##  [Week 3](https://bitbucket.org/skeoop/oop/src/master/week3)
More on Polymorphism.  
The Java Collections classes: the Interfaces and concrete classes for List, Set, Map, and more.  
*Collections will be discussed several times during the course.*  
Iterators - how to visit every element of a collection.  
**Quiz** this week on Java fundamental methods, UML class diagram, and polymorphism.

**Lab**:

* [Feedback on Lab2](https://bitbucket.org/lostseaway/oop2_addition/src/master/week1/coinpure_feedback.md)
* How to Use Checkstyle: http://goo.gl/Jxw5x1
Checkstyle rules file: [docs/ku-checkstyle.xml](https://bitbucket.org/skeoop/oop/src/master/docs/ku-checkstyle.xml)
* [Lab3-Polymorphic Coin Purse](https://bitbucket.org/skeoop/oop/src/master/week3/Lab3-PolymorphicPurse.pdf). There is a new [ConsoleDialog.java](https://bitbucket.org/skeoop/oop/raw/master/week3/ConsoleDialog.java) for this purse in  [week3](https://bitbucket.org/skeoop/oop/src/master/week3) folder.
* How to use Git **tags** - described in Lab3 and [TA write-up](https://bitbucket.org/skeoop/oop/wiki/Git-tag).

### Assignment
**Read:** Collections in BIGJ chapter 15. Iterators in OODP section 5.1.  "for-each" loop is covered in BIGJ section 7.2. Also review week2 reading on Interfaces.

----
##  [Week 4](https://bitbucket.org/skeoop/oop/src/master/week4)
Inheritance - why use it?  
Abstract Classes for common code in a class hierarchy.  
More Collections: Map and Abstract collection classes.    
Design using Interface and Abstract Superclass  
Using the Java API Docs  

### Assignment
**Read:** Maps in BIGJ section 15.4.  Abstract classes in OODP section 6.3.   Intro to Design Patterns in OODP section 5.2.  
Study (review) my Inheritance-1-Basics slides. Be sure you can apply this material; tell me next week if it contains anything you didn't learn in OOP1.  
**Homework** HW1 due in lecture next week.  
[Lab4: Inheritance](https://bitbucket.org/skeoop/oop/src/master/week4/Lab4-CoinPurse-Inheritance.pdf)  
**Programming Assignment** PA2 has two problems: [1-ArrayIterator](https://bitbucket.org/skeoop/oop/src/master/week4/PA2-1-ArrayIterator.pdf), [2-Stack](https://bitbucket.org/skeoop/oop/src/master/week4/PA2-2-Stack.pdf). Due: 23 February.

----
## [Week 5](https://bitbucket.org/skeoop/oop/src/master/week5)
1. Introduction to Design Patterns  
2. Introduction to Recursion    
3. Exercise on recursion  
**Quiz** on collections, Java collections hierarchy, and inheritance.  

### Assignment
**Read:** OODP Section 5.1-5.2 on design patterns, and 5.4 Strategy Pattern.  
BIGJ Chapter 13 on Recursion.  Don't have to read it all, but study section on Helper Methods.   
[Lab5: Purse with Strategy Pattern](https://bitbucket.org/skeoop/oop/src/master/week5/Lab5-Purse-with-Strategy-Pattern.pdf)  plus recursion practice.

* [Recursion Practice](https://bitbucket.org/skeoop/oop/wiki/Recursion%20Practice)
----
##  [Week 6](https://bitbucket.org/skeoop/oop/src/master/week6)
Introduction to Graphical UI.  
Design Patterns in the Java GUI framework.  The _Observer Pattern_ in Java.    
Introduction to Unit Testing with JUnit (if time)  

**PA2 is due Monday, 23 Feb. 12:00 Noon**  See this [Project Checklist](Project-Checklist) to avoid reject.   
There a test (ArrayIteratorTest.java) for problem 1 in week4 folder.

### Assignment
**Read**: _BIGJ_ Chapter 19 on Graphical UI, _OODP_ Chapter 4 on design patterns in Swing.  

---
##  [Week 7](https://bitbucket.org/skeoop/oop/src/master/week7)
Event listeners, Actions (commands), and Model-View in graphics.  
Exceptions and exception handling  
Enum type  

### Assignment
**Read**: _BIGJ_ Section 11.4-11.5 on Exceptions.  Exceptions also covered in _Java Tutorial_ (JTUT).  Graphics is covered in week6 reading assignment.  
**Homework**: [Homework 2](https://bitbucket.org/skeoop/oop/src/master/week7/HW2.pdf) due next Tuesday, in lecture.  
**Lab:** [Lab7-LengthConverter](https://bitbucket.org/skeoop/oop/src/master/week7/Lab7-LengthConverter.pdf)  
[PA3-UnitConverter](https://bitbucket.org/skeoop/oop/src/master/week7/PA3-UnitConverter.pdf)  due next week (10 Mar) on Bitbucket. Submit UML in class.  
[Graphics Component Practice](https://bitbucket.org/skeoop/oop/src/master/week7/Graphics-Components-Practice.pdf) for practice using various GUI components.  Not required.  

---
## [Week 8](https://bitbucket.org/skeoop/oop/src/master/week8)
UML Sequence Diagram  
[Practice Problems](https://bitbucket.org/skeoop/oop/src/master/week8/Practice%20Problems.pdf)  

#### Assignment
**Read:**  UMLD Chapter 4 on Sequence Diagram, Chapter 5 on Class Diagram "advanced" concepts.  
Lab:  
1. [Practice Problem Solutions](Practice-Solutions)  - create wiki pages  
2. Implement the improved code for Pizzashop (see Practice Problems).
There is [starter code](https://bitbucket.org/skeoop/oop/src/master/week8/pizzashop.zip) you can download.  Sorry, no GUI, but you can help write one.

---
## Midterm
Written exam is 18 Mar 8:00-11:00.  Closed book.  
Lab exam is 18 Mar 12:00 - 15:00.  Closed internet, closed notes, closed slides, etc.  Only an IDE, JDK, and Java API docs allowed.  
NO dress code (_dress like a programmer_).

---
## [Week 9](https://bitbucket.org/skeoop/oop/src/master/week9)
State machines - modeling components whose behavior depends on state.   
_State machine_ are widely used in computer science, software design, and logic design.  You should know how to create state machine models and how to implement them in software.  
UML State Machine Diagram   
Programming a state machine   
State Design Pattern (programming without "if")   

#### Assignment
**Read:** UMLD Chapter 10. _UML for Java Programmers_ Chapter 10, by Robert Martin, is also good and easy to read.  
On the web: [UML State Machine](http://www.uml-diagrams.org/state-machine-diagrams.html); Wikipedia has pages about State Machine and [UML State Machine](https://en.wikipedia.org/wiki/UML_state_machine).  
**Lab:** State machine for counting syllables, plus TBA.  
[PA4-Readibility](https://bitbucket.org/skeoop/oop/src/master/week9/PA4-Readability.pdf)  an app that tells you how readable a file or URL is.  Due **April 7.**  
[PA5-DigitalClock](https://bitbucket.org/skeoop/oop/src/master/week9/PA5-DigitalClock.pdf)  - a graphical _cheap_ digital alarm clock, using state pattern.  Due **April 10.**

---
## [Week 10](https://bitbucket.org/skeoop/oop/src/master/week10)
Unit testing with JUnit (a  _framework_).  
Assertions.  
Introduction to threads.  
Quiz on State Machine.   
Midterm review.  Lab exam results posted on [Results and Feedback](Results) page.

#### Assignment
**Read:**   [Multithreading](
http://higheredbcs.wiley.com/legacy/college/horstmann/1118318773/webch/ch20.pdf)  online chapter from BIGJ. (also copied into week10 folder)  
[Frameworks and OCSF](https://bitbucket.org/skeoop/oop/src/master/week10/OCSF-Framework.pdf) in week10 folder. This is an introduction to frameworks.  We will use OCSF in lab.  

**Lab:** [Lab10 StackTest](https://bitbucket.org/skeoop/oop/src/master/week10/Lab10-StackTest.pdf) write JUnit tests for a Stack.  See lab sheet for stack specification.   
Download Stack.java (interface) and StackFactory.jar from [Week 10](https://bitbucket.org/skeoop/oop/src/master/week10) folder.  
**Homework:**  [Homework 3](https://bitbucket.org/skeoop/oop/src/master/week10/HW3.pdf) due next Tuesday, in lecture.

---
## [Week 11](https://bitbucket.org/skeoop/oop/src/master/week11)
Introduction to frameworks.  
More on threads and multi-threading.

#### Assignment
Lab 11: [OCSF Framework](https://bitbucket.org/skeoop/oop/src/master/week11/Lab11-OCSF-Framework.pdf)   
PA6: [Custom Project](https://bitbucket.org/skeoop/oop/src/master/week11/PA6-Custom-Project.pdf)

---
## [Week 12](https://bitbucket.org/skeoop/oop/src/master/week12)
* Using threads in Swing
* Class Design

#### Assignment
[Design Patterns](Design Patterns) - see this link for description and sign-up. **Due:** 28 April, 9:00am.  
[PA6](PA6) - create a description of your PA6 project.  **Due:** Proposal due 25 April. Demo in last lab, submit final code by 7 May.  
**Read:** - OODP Chapter 7.   Concurrency and Swing Concurrency sections of Java Tutorial.  
**Lab12:**  
1. Fork (not clone) this repository: https://bitbucket.org/skeoop/downloader  
2. Run it.  If you download a large file, the user interface freezes.  
3. Modify the `DownloadApp` class to run the UI in the Swing Event Dispatcher thread.  
4. Rewrite the `URLReader` class to be a subclass of `SwingWorker` so you can `execute()` it from the DownloaderUI without hanging.  **Hint:** the `readUrl()` method should become (or be called from) the SwingWorker's `doInBackground()` method.
5. Modify `DownloaderUI` class. In the DownloadAction, use your `SwingWorker` to download the file so the UI does not hang or freeze.  
6. Add `publish` commands to the `doInBackground` method so that it "publishes" each time 1024 bytes is read.  Add code to the DownloaderUI to show progress of how many bytes have been downloaded. You can use a field, a JProgressBar (maybe the easiest), or other solution.
7. Demonstrate that you can now download a large file without the UI freezing.
8. Save your work on Bitbucket as `Lab12`.

---
## [Week 13](https://bitbucket.org/skeoop/oop/src/master/week13)

Generic types - rules for parameterized classes and interfaces.  
Lambda Expressions - Java 8 syntax for anonymous methods,  
Functional Interfaces - new interfaces that support use of Lambda expressions.  

#### Assignment
**Lab:** [Lab13-1 Generics](https://bitbucket.org/skeoop/oop/src/master/week13/Lab13-1-Generics.pdf)  
[Lab13-2 Factory and Singleton Patterns](https://bitbucket.org/skeoop/oop/src/master/week13/Lab13-2-Factory-and-Singleton.pdf)   
**Read:** Lambda Expressions in Java 8 tutorial (new feature in Java 8).  Interfaces in Java 8 tutorial.


---
## [Week 14](https://bitbucket.org/skeoop/oop/src/master/week14)
Make-up Class - Sunday, 10 May Time **13:00-16:00**

1. Discuss Homework 4.
2. Presentation of student projects.
3. [Input/Output exercise](https://bytebucket.org/skeoop/oop/raw/master/week15/Input-Output-Practice.pdf)
4. [Design Patterns Practice](https://bytebucket.org/skeoop/oop/raw/master/patterns/Patterns-Exercises.pdf) in "patterns" folder
5. Design and implement a calculator.  Repository: https://bitbucket.org/skeoop/calculator
     * This uses several design patterns.
     * Slightly hackneyed, but very educational app.

[Feedback on Design Patterns](Results) and [individual feedback](https://bitbucket.org/skeoop/oop/src/master/results/design-patterns.md). **Please correct your report.**

**Homework**:  [HW4](https://bitbucket.org/skeoop/oop/src/master/week14/HW4.pdf)  
Source for homework: https://bitbucket.org/skeoop/hw4  (Git: git@bitbucket.org:skeoop/hw4.git)

---
## Review ([Week 15](https://bitbucket.org/skeoop/oop/src/master/week15))
The week15 folder contains some material for:

* Input and Output in Java
* LabExam sample problems



**Feedback**:

* [PA1 Common Errors](https://bitbucket.org/skeoop/oop/wiki/PA1-Common-Errors)
* PA1 Feedback (TBA)

----
## References

[BIGJ] Cay Horstmann, *Big Java*, 4E or 5E.  
[JTUT] Oracle, *Java Tutorial*.
[UMLD] Martin Fowler, *UML Distilled*, 3E.
[OODP] Cay Horstmann, *Object-oriented Design and Patterns*, 2E.
