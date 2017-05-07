Other pages: [About the Course](About). [Course Material](https://www.github.com/skeoop/). [Results and Feedback](http://www.github.com/skeoop/results/) on assignments.

---
## [Results](http://www.github.com/skeoop/results)
[PA1](https://skeoop.github.io/results/PA1-Results.pdf)  were very good; some codes look too similar.
PA1 JUnit tests: [ArrayIteratorTest.java](https://skeoop.github.io/results/ArrayIteratorTest.java).    
[PA2](https://skeoop.github.io/results/PA2-Results.pdf),
[LabExam 1](https://skeoop.github.io/results/Labexam1-Results.pdf),
[Quiz2 Feedback](https://skeoop.github.io/results/quiz2),
[Quiz3](https://skeoop.github.io/results/quiz3-scores.pdf),
[Quiz4](https://skeoop.github.io/results/quiz4-scores.pdf),
[Quiz5](https://skeoop.github.io/results/quiz5-scores.pdf) and
[Feedback](https://skeoop.github.io/results/quiz5)


## Final Exam
**Lab Exam:** Thursday, 18 May 13:00-18:00 Room 201.   
**Project Presentations**: TBA.   Presentation of PA6. Explain the interesting technology you used so everyone can learn!  
**Written Exam** Friday, 26 May 9:00-12:00 Room 204. Closed book.   
Dress Code: "*dress like a programmer*" (wear anything you like).  

---
## [Week 9](http://www.github.com/skeoop.github.io/week9)

State machines - modeling components whose behavior depends on state.   
UML State Machine Diagram   
Programming a state machine   
State Design Pattern (programming without "if")   
Recursion   

#### Lab
* [Syllable counter using a state machine](https://skeoop.github.io/week9/Lab9-SyllableCounter.pdf) the lab problems.
* [WordCounterTest](https://skeoop.github.io/week9/WordCounterTest.java) tests for syllable counter.
* Dictionaries to count: http://se.cpe.ku.ac.th/dictionary and `scrable.txt` (week9 folder)
* [Programming a State Machine](https://skeoop.github.io/week9/Programming%20a%20State%20Machine.pdf) write up explaining technique for implementating state machine behavior in Java.


#### Assignment
**Homework:** [Homework 3](https://skeoop.github.io/week9/Homework3.pdf) in week9 folder. Due next Friday (7 April).  
**Read:** UMLD Chapter 10 (State Machine). _UML for Java Programmers_ Chapter 10, by Robert Martin, is also good and easy to read.  
State Machine the web: [UML State Machine](http://www.uml-diagrams.org/state-machine-diagrams.html); Wikipedia has pages about State Machine and [UML State Machine](https://en.wikipedia.org/wiki/UML_state_machine).   

---
## [Week 10](http://www.github.com/skeoop.github.io/week10)
No class this week due to holiday.   Lab cancelled, too.  
Please start work on PA4.

#### Assignment

[PA4-Readability](https://skeoop.github.io/week10/PA4-Readability.pdf)  an app that measures the reading difficulty of text.  This is a useful application.  Due: April 30.  
Test file: [Alice in Wonderland](http://www.github.com/skeoop/week10/Alice-in-Wonderland.txt) with simplified punctuation.  

---
## [Week 11](http://www.github.com/skeoop.github.io/week11)

Testing with JUnit.  
Observer Pattern, Observers in Java, Observers in Swing components.  
Using observers to notify UI of changes in app model.  
Self-study:  Assertions and "programming by contract".  (see slides in week11 folder)

#### Lab
* **Quiz** on Git: add file, remove file, move file, clone, push to remote
* Two programs in the lab this week.
* [Lab11 StackTest](https://skeoop.github.io/week11/Lab11-StackTest.pdf) write JUnit tests for a Stack.  See lab sheet for stack specification.   
Download Stack.java (interface) and StackFactory.jar for testing.  
* [Observable Coin Purse with GUI](https://skeoop.github.io/week11/Lab11-Purse-with-Observers.pdf)  add a graphical user interface and observers to the coin purse.


#### Assignment

[PA6 Custom Project](https://skeoop.github.io/week12/PA6-Custom-Project.pdf)  Design your own programming project and submit a proposal. **Due:** one page proposal due in 2 weeks.

---
## [Week 12](http://www.github.com/skeoop.github.io/week12)
Announcements:   
* Only 2 lab exams. 2nd lab exam during finals week.
* Written Final Exam: 26 May, 9:00-12:00 in room 204. Any conflict?

Review Sequence Diagram from Last Week  
Recursion and back-tracking  
Coin Purse withdraw using recursion (and why)  
Strategy Pattern  
Threads   
Threads in Swing  
(maybe) Intro to Lambda expression for anonymous objects  

#### Lab
* Quiz on using List (computer required)
* [Lab12 Purse with Withdraw Strategy](https://skeoop.github.io/week12/Lab12-Purse-with-Strategy-Pattern.pdf) using strategies for withdraw, including recursive withdraw.

#### Assignment
**Read:** 1) BIGJ Chapter 20 (Threads).   
**Read:** 2) [Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html) and Swing Concurrency in the [Java Tutorial](https://docs.oracle.com/javase/tutorial/reallybigindex.html).  You are responsible for this material, including **synchronization**.  
[PA6 Custom Project](https://skeoop.github.io/week12/PA6-Custom-Project.pdf)  Design your own programming project and submit a proposal. **Due:**  May 5 (Friday)
**Homework**: [Homework 4](https://skeoop.github.io/week12/Homework4.pdf) due next week in lecture.  


---
## [Week 13](http://www.github.com/skeoop.github.io/week13)
Review of Threads homework.   
Threads in Swing (from last week) with demo. Slides in week12 folder.   
New Features in Java 8: Lambdas, Interface changes, Streams, immutable Date & Time classes.  

#### Lab
* Quiz on Recursion  
* Discussion of JUnit tests for Withdraw Strategy - create a Purse (attribute) in setUp method and write methods to simplify coding of tests.
* Methods with variable length args  
* [Lab13 OCSF Framework](https://skeoop.github.io/week13/Lab13-OCSF-Framework.pdf). This is an introduction to frameworks.  Files for this lab:
    * [ocsf-231.zip](http://www.github.com/skeoop/week13/ocsf-231.zip) contains ocsf-2.31.jar, source code, and Javadoc.
    * [demoserver.jar](http://www.github.com/skeoop/week13/demoserver.jar) question server you can use to test your client.  Run it from command line using `java -jar demoserver.jar`.
    * [Object-Client-Server-Framework.pdf](https://skeoop.github.io/week13/demoserver.jar) chapter about frameworks and OCSF from the book *Object-oriented Analysis & Design* by Lethbridge.  Chapter describes basics of creating a network connection in Java and how to use OCSF.

#### Assignment
[PA5 Multi-threaded Downloader](https://skeoop.github.io/week13/PA5-Threaded-Downloader.pdf) using threads for faster file downloads, as done in FlashGet and Filezilla. **Optional** this isn't required, but you can use this project is place of some other PA you missed, or as your PA6 project.  
**Read:** Lambda Expressions in Java 8 tutorial (new feature in Java 8).  Interfaces in Java 8 tutorial.  
**Homework**: [Homework 4](https://skeoop.github.io/week12/Homework4.pdf) due next week in lecture. (from last week)

---
## [Week 14](https://www.github.com/skeoop.github.io/week14)

Review bit operators: and, or, xor  
Common Design Patterns: Observer, Factory Method, State, Strategy, Adapter, Singleton
(maybe) Generic types: Rules for parameterized classes and interfaces.  Generic methods (static methods with their own type parameter)

[Design Patterns Practice](https://bytebucket.org/skeoop/oop/raw/master/patterns/Patterns-Exercises.pdf) in "patterns" folder

#### Lab

#### Assignment

---
### Optional Topic
Please tell me if you are interested in studying these topics.
We can cover one topic (presentation and programming practice) on a Saturday:

* Using a database in Java with JDBC.
    * JDBC is the standard interface for using an SQL database in Java.  Its not very hard and uses several design patterns. Works with almost any database.
    * Programming practice using a database of world country facts.
* Object persistence using JPA.
    * Java Persistence API (JPA) is a standard for saving, searching, and retrieving objects using a database.  JPA handles the low-level reading and writing of data for you.
    * JPA is used in MVC frameworks, and much easier to use than JDBC.
    * Not necessary to study JDBC before JPA, but both are useful to know.


---
# First Half of the Course

---
## [Week 1](https://www.github.com/skeoop.github.io/week1)

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


### Assignment 1. Do this before lab tomorrow.

1. Install the command line `git` on your computer, from https://git-scm.com/download/. (Windows, MacOS X, or Linux)
2. After you install `git`, you should set your name and email. Execute these commands (with your name and email):
     ```
     cmd> git config --global user.name "Fatalai Jon"
     cmd> git config --global user.email fatalai.j@ku.th
     ```  
3. Create an account on Github.
4. Edit your Github profile and include:
    * your *real name*, in English with correct capitalization.
    * a photo that clearly shows your face.  
5. (Helpful) Read a Git tutorial of your own choice.  [Try Git](https://try.github.io/) lets you try git in your browser and contains more than you need to know.
6. [Git Cheat Sheet (PDF)](https://education.github.com/git-cheat-sheet-education.pdf) has summary of useful commands.


#### Lab 1

There are 2 parts to the lab. The files are in the week1 folder.

1. [Lab1-1-Git.md](https://skeoop.github.io/week1/Lab1-1-Git.md) practice using git.
2. [Lab1-3-Guessing-Game](https://skeoop.github.io/week1/Lab1-3-Guessing-Game.pdf) write a Guessing Game in Java.  See the PDF for instructions.
    * In Lab: commit source code for a game that works, and README.md file.
    * "push" a copy of your repo to your Gtihub account as `GuessingGame` repo
3. Due Tomorrow (Saturday):
    * write good Javadoc for classes and methods. Use `@param`, `@return`, `@author` tags.
    * fix any problems with your code.
    * format code to be easy to read.
4. Tell us your Github account. Complete this form: [https://goo.gl/Y6EMeq](https://goo.gl/Y6EMeq).


#### Assignment
**Read**: (1) Java Coding Standard, (2) Java Fundamental Methods  
**Learn**: UML class diagram for a single class. Use the Internet or read UMLD Chapter 3 (Class Diagram).   
**Homework**: [Homework 1](https://skeoop.github.io/week1/Homework1.md) due next week

----
##  [Week 2](https://www.github.com/skeoop.github.io/week2)

Topics left from week1:

* How Java and the JVM work.
* Object references.
* Coding standard and Javadoc.
* How to read the Java API (you should already know).
* Fundamentals: correct way to write `equals`.

This week's topics:

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

#### Lab 2 DUE TO HOLIDAY, LAB ATTENDANCE IS *OPTIONAL*. YOU CAN DO THIS LAB AT HOME.

The Lab will be open (13:00-16:00) and you can get help/feedback from TAs.
Alternatively, you can do this lab at home and submit to Github.

* Lab2: Stopwatch in [Week 2](https://www.github.com/skeoop.github.io/week2) folder.  
* Submit your Stopwatch and refactored tasks to Github as a project named ```stopwatch```.
* Deadline: **2 Feb 2017 (Thursday)**, midnight
* Code Review: TAs will review week1 lab for some students

#### Exercises

1. Name 2 classes in Java API that you cannot create an instance. How do you know its impossible (e.g. no Factory method)?
2. Name 2 classes in Java API that you cannot use "new XXX()" but you can create objects using a static method in that class.
3. Name a class in Java API that you cannot use "new XXX()" but you can create objects using *another* class (either static or instance method).


#### Assignment

**Read**: [Let's Eliminate Duplicate Code](http://goo.gl/TGiUqC) (http://goo.gl/TGiUqC) by Thai, explains how to use interface to remove duplicate code.  Improves your code.  
**Read**: Polymorphism and Interfaces in BIGJ 9.6 and 10.1-10.6.  
**Programming Assignment**: [PA1-ArrayIterator](https://skeoop.github.io/week2/PA1-ArrayIterator.pdf) available now.  **Due: 5 Feb 2017 (Sunday), midnight.**  
**Quiz After KU Fair**: Quiz on UML Class diagram, writing the Fundamental Methods, and Polymorphism


----
##  [Week 3](https://www.github.com/skeoop.github.io/week3)

Collections, Lists, and ArrayList  
Interfaces used to Sort Arrays and Lists   
Why Iterators?  
Java for-each loop for arrays and collections  
Using the Java API Docs   
UML class diagram, details. (By now you should have read the basics of class diagram on your own.)   
**Quiz** high probability of a quiz on Java fundamental methods, UML class diagram, and polymorphism.

#### Lab

* Resolving conflicts in git. This happens when you edit a file on Github via web browser, then try to `push` code from your local repo.  Solution is to `pull` changes from Github before commiting your own changes.
* Practice using List and ArrayList
* Practice writing a Comparable and Comparator.
* [Lab3-Coin Purse using List](https://skeoop.github.io/week3/Lab3-CoinPurseWithList.pdf). There is sample code (purse-sample.zip) to get started, in  [week3](https://www.github.com/skeoop.github.io/week3) folder.  

#### Assignment
**Read:** 1) BIGJ chapter 15 on Collections. 2) "for-each" loop is covered in BIGJ section 7.2. 3) Review week2 reading on Interfaces.

----
##  [Week 4](https://www.github.com/skeoop.github.io/week4)
Inheritance - why use it?  
Abstract Classes for common code in a class hierarchy.  
More Collections: Map and Abstract collection classes.    
Design using Interface and Abstract Superclass  
Using the Java API Docs  

#### Lab

* Map Practice. Complete the code for [Dictcount.java](https://skeoop.github.io/week4/Dictcount.java) in week4 folder.
* Polymorphic Coin Purse, labsheet is in [week4](https://www.github.com/skeoop.github.io/week4/) folder. Commit your work to same github project (coinpurse).
* How to use Git **tags** [write-up by TA](docs/git-tags)

#### Assignment
**Read:** Inheritance and Abstract classes in BIGJ chapter 9. Abstract classes also in OODP section 6.3.    
Study (know how to apply) my Inheritance-1-Basics slides. Tell me next week if it contains anything you did not learn in OOP1.  
**Homework** tba  
**Quiz** next week on interface, inheritance, collections.


----
## [Week 5](https://www.github.com/skeoop.github.io/week5)

Design using Interface and Abstract Superclass (from last week)  
Java "final" modifier   
Principles (guides) for Better Code   
Creating objects using Factory Methods and Singleton (instead of "new ...")  
**Quiz** on collections, Java collections hierarchy, interface, and inheritance.  
#### Lab

* Lab5-1 Coin purse with abstract class for money
* Lab5-2 Coin Purse with Money Factory and Singleton

#### Assignment
**Read:** BIGJ Chapter 9 (Inheritance) covers abstract class and "final". Factory methods are covered in OODP section 10.3, or search the web.   
**Homework**: [Homework 2](https://skeoop.github.io/week5/Homework2.pdf) Problems 1-4 due in class on Thursday, 2 March. Problem 5 due in Github, Friday, 3 March.  Any copying results in grade "F" for the course.


----
##  [Week 6](https://www.github.com/skeoop.github.io/week6)
Exceptions and Exception Handling   
The Java IO Hierarchy   
Inner classes   
Anonymous classes  
Writing DRY Javadoc using `@see` tags. You can also use HTML in Javadoc  
Design Issues in Coin Purse

#### Lab

* I/O and Exceptions lab
* Clean up and review previous labs

#### Assignment

**Read**: _BIGJ_ Chapter 11 on Input/Output and Exception Handling. Exceptions also covered in the _Java Tutorial_ (JTUT).   
**Programming Assignment 2**: [PA2-CSVReader](https://skeoop.github.io/week6/PA2-CSVReader.pdf) assignment in week6 folder.  **Due:** Monday, 13 March, midnight.
* Please use the Github Classroom link (sent to you via email) to create a repository for this assignment.  You don't need to request your own private repos.
* After you visit the link and "accept" the assignment, clone the repo to your computer and put your work in there.

---
## [Week 7](https://www.github.com/skeoop.github.io/week7)
Graphical User Interfaces (GUI) in Swing  
Swing Components   
Event listeners and the Observer Pattern  
How to write a simple GUI  

#### Lab
* [Graphics Component Practice](https://skeoop.github.io/week7/Graphics-Components-Practice.pdf) complete the practice exercises for various GUI components.
* Write a GUI interface for Guessing Game.
* How to Use Checkstyle: http://goo.gl/Jxw5x1  
* Checkstyle rules file: [docs/ku-checkstyle.xml](https://skeoop.github.io/docs/ku-checkstyle.xml)  
* Postponed: [LengthConverter](https://skeoop.github.io/week7/Lab7-LengthConverter.pdf)  


#### Assignment

**Read**: _BIGJ_ Chapter 19 on Graphical UI; _OODP_ Chapter 4 on design patterns in Swing (recommended).  
**Programming Assignment**
[PA3-UnitConverter](https://skeoop.github.io/week7/PA3-UnitConverter.pdf)  due 3 April.  Use the Github Classroom repository (invitation sent by email) and use git to commit -- don't use file upload.  Assignment URL is: https://goo.gl/XCp7NJ

---
## [Week 8](https://www.github.com/skeoop.github.io/week8)

Enum type   
Actions - commands that encapsulate EventListeners  
Model-View in Swing components  
UML Sequence Diagram (if we have time)   
Review   
[Practice Problems](https://skeoop.github.io/week8/Practice-Problems.pdf)  

#### Lab

[PracticeExam](https://skeoop.github.io/week8/PracticeExam.pdf), the project code is available as a Github classroom project. Check your email for invitation.

The invitation link is:

https://classroom.github.com/assignment-invitations/d7061f4cba270d7925e0a714d4e081b4

#### Assignment
**Read:**  UMLD Chapter 4 on Sequence Diagram, Chapter 5 on Class Diagram "advanced" concepts.  

---
## Midterm

**Written exam** 24 Mar, 12:00-15:00 in room 204. Closed book.  
Any material from lectures and reading assignments may be included on exam. Reading material may be included even if never discussed in class.  
**Programming exam** 24 Mar 16:00-19:00 in room 201.  No internet, notes, slides, or code allowed.  Only an IDE, JDK, and Java API docs.   
Dress code: _dress like a programmer_ (wear anything comfortable).

---

----
## References

[BIGJ] Cay Horstmann, *Big Java*, 4E or 5E.  
[JTUT] Oracle, *Java Tutorial*.   
[UMLD] Martin Fowler, *UML Distilled*, 3E.   
[OODP] Cay Horstmann, *Object-oriented Design and Patterns*, 2E.   
