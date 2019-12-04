---
layout: page
title: About
description: About the Course
---

## Object-Oriented Programming 2 

This course covers object-oriented programming and design, including 3 subject areas:

1. Object-oriented concepts, principles, and design, including some design patterns
2. Java programming language and its features
3. Modeling using UML

For a detailed list of topics, see the [weekly schedule](https://skeoop.github.io/index)

### Course Objectives (What You Will Hopefully Learn)

You will learn how to design and implement applications that involve many classes and source code divided among many files, and how to use libraries or frameworks in your application so you can build on existing code.  You should be able to manage your code and project documents using a version control system; in particular, be able to use git and Github for version control.

You should gain a good understanding of essential programming elements such as data types, interfaces, variables and their scope, fundamental characteristics of OOP, classes, object creation and structure, exception handling, and event handling.  You will also learn how to design and write unit-tests for your own code.  You should become familiar with threads and multi-tasking, and the basics of graphical user interfaces.

You will learn to apply basic object-oriented design principles and design patterns to your own application, and recognize them in code you use.  You should be able to perform basic *refactoring* operations to improve the design of existing code, too.

You should be able to understand API documents from libraries and frameworks and find information in them, and not rely on searching for solutions on StackOverflow.  You should also be able to write good documentation for your own code, using a standard format that enables tools to generate documentation from your code.  

### Requirements for Students 

The above is essential knowledge for any software developer.  It requires individual study and much practice in designing, writing, and testing code.  Everyone in the course will need to commit several hours per week to read, study, and do assignments on their own.

Everyone is required to do the assigned work themselves.  Please do not ask other students to "teach" you or attempt to copy any work from anyone else.

### Topics

The course will try to cover these topics; depending on time some topics may be left for individual study.

* Object basics - what are objects, how they defined, what do they contain?
* Object references
* Fundamental characteristics of OOP: Encapsulation, Polymorphism, and Inheritance
* Java Coding Standard. Using a style checker.
* How to use Javadoc
* How to use Git and Github
* UML Class Diagram for showing structure and relationships
* UML Sequence Diagram for showing behavior
* UML State Chart Diagram for state-dependent behavior
* Inheritance and how to use it
* Abstract classes - base classes for inheritance
* Polymorphism and how to use it
* Interfaces - separate specification from implementation; an enabler for polymorphism
* Interface "new" features in Java 8 and beyond
* Collections types and classes
* Sorting and Comparators (an example of the Strategy Pattern)
* Iterators and the Iterator design pattern
* Mutable and immutable objects
* Unit testing and unit testing frameworks
* Input-Output classes and their hierarchy
* Graphical UI using JavaFX
* Events and Event Handling
* Anonymous classes - a shortcut for classes used only once
* Threads for multi-tasking
* Worker threads for background processing
* Using Frameworks - networking framework as example
* Intro to Databases and Object-Relational Mapping (ORM)
* Generics and Generic Types (already used in Collections and Interfaces) 
* Lambda Expressions and Method References 
* Streams and stream programming
* Design Patterns concept and how to read a design pattern.  Patterns are covered as part of other topics.  Patterns often seen are:
    * Command
    * Decorator
    * Factory Method 
    * Iterator
    * Obverser
    * Singleton 
    * State 
    * Strategy


### Online Course Material and Resources

The [Source Repository](https://github.com/skeoop/skeoop.github.io) contains weekly material for the course as a Git repository, with subdirectories for each week and special topics.

| [skeoop.github.io][skeoop.github.io] | course material, slides, handouts |
| [Resources][resources]               | places to learn more              |
| [Google Classroom][google-classroom] | assignments and online exercises  |
| [OOP2018 Github Org][github-oop2018] | where to submit work, programming quizzes|
| All files in repo          | https://github.com/skeoop/skeoop.github.io/ |

Note: when a file is updated on [github.com/skeoop/skeoop.github.io](https://github.com/skeoop/skeoop.github.io) it may take *many minutes* before the change appears on [skeoop.github.io](https://skeoop.github.io/). 


### Required Material

See [Requirements](Requirements) for software and other items you need for this course.

### Instructor and TAs

**Instructor**:  James Brucker    
**TAs**: Taweerat Chaiman, Chinthiti Wisetsombat, Kongpon Charanwattanakit, Thongrapee Panyapatiphan 

To get their email address, use this Java method:
```java
/**
 * Compute someone's KU Email address based on real name.
 *
 * @return the person's email
 */
public String getEmail(String firstName, String lastName, boolean isThaiName) {
    final String DOMAIN = "ku.th";
    StringBuilder sb = new StringBuilder();
    if (isThaiName) 
       // for Thai names, but not reliable due to name collisions
       sb.append(firstName).append('.').append(lastName.charAt(0)); 
    else 
       // foreign names
       sb.append(firstName.charAt(0)).append('.').append(lastName); 
    return sb.append('@').append(DOMAIN).toString();
}
```
[StringBuilder](https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html) is a mutable object for building and editing strings. Its much more efficient than concatenating Strings.

### Course work

This course has lectures, labs, and individual assignments.  

In lecture we discuss material, do exercises, and quizzes. The lecture does **not**  teach you all the material!  You have to *read* and *practice* on your own for a complete understanding. 

In labs we do hands-on programming and learn new skills, such as using git and refactoring code in an IDE.

Individual homework and programming assignments are to improve your understanding and programming skill.

### Programming Assignments

There are programming assignments (PA) for you to do on your own, about one every 2 weeks.  These assignments are longer than the labs and may require some design effort. The purpose is to help you improve your design and coding skill in depth, and let you practice writing **good quality code**.

*Design Your Own Project*: In the second half of the course, you will choose your own topic for one PA. Some student projects from past years are: network-based games, a chat application, a guitar tuner, and an image processor.

### Requirement for Individual Work

All assignments *must* be done **individually**, unless group work is explicitly alowed.  No copying is accepted, even on a small part.

It is OK to discuss design and problems you have, but not to share code.  If you need help, please ask the TAs or instructor rather than the other students (who may not give you the correct answer).

### Copying == Fail

Anyone who submits copied work will receive grade "F" and be reported to Faculty of Engineering for disciplinary action.

### Grading

Your grade is based on:

* written exams (2)
* lab exams (2-3)
* programming assignments
* quizzes
* homework
* class participation
* lab participation and lab work

**Minimum Exam Scores:** To pass the course you must have: (a) average written exam score at least 50%, **and** (b) average lab exam score at least 50%.  

If you achieve the minimum exam scores, then the following grading scale is used (approximately):

| Overall | Grade |
|---------|-------|
|  > 85%  |   A   |
| 75-85   |   B   |
| 65-75   |   C   |
| 55-65   |   D   |
|  < 55%  |   F   |

### Assignments using Github Classroom 

Assignments and quizzes use Github Classroom to distribute and submit work. You will be given the URL of the "invitation" to do the assignment.  Visit the URL and "accept" the invitation.

Github Classroom then creates a repository for you. The repository may contain starter code and instructions.  For example, if the assignment is named "quiz9" you would get a repo with URL:
```
https://classroom.github.com/OOP2018/quiz9-yourname
```
where ```yourname``` is your Github login name.  `clone` this repository to your computer, complete the assignment, and then `push` your updated repo back to github.  Typically something like this:
```shell
cmd> cd /somepath/workspace
# Clone the repository to a new directory named quiz9
cmd> git clone https://classroom.github.com/OOP2018/quiz9-yourname.git quiz9

# Use your favorite IDE to complete the quiz.
# then do...

cmd> cd quiz9
cmd> git status
    Untracked files:
       src/Problem1.java
       src/Problem2.java
       etc.
cmd> git add src/*
cmd> git commit -m "write your own commit message"
cmd> git push
```

Ref: [Github Classroom videos](https://classroom.github.com/videos)

### Assignments using Your Own Account 

Lab work and some other assignments don't use Github Classroom.  In this case, create a repository in your Github account (the one you used to join our class) and push your work to it. Each assignment specifies the *exact repo name* to use to Github.  Please be careful to use name *exactly* as on the assignment (including upper/lowercase of letters). If you use the wrong name, we might not download your work (and as a result, you get no score).

On your local computer, you can use any repo name you like. The local repo name does not have to be the same as the repo name on Github.
A remote using the command:
```
cmd>  cd /path/to/local_repo
cmd>  git remote add origin git@github.com:yourname/repo_name.git
```
where `repo_name` is the remote repository (which you must create on github.com).  So, it can be any name -- not necessarily your local project.


## Prerequisite Knowledge

You need to know:

1. Everything that was covered in Programming 1, including methods, loops, conditional expressions, arrays and ArrayList, defining classes, and creating objects. 
  * How to write and compile Java, including creating and using objects.
2. How to use the command line on your computer, including these commands:
  * How to display name of the current directory.
  * How to change directory.
  * How to list all the files in a directory.
  * How to copy, move, or rename a file.
  * How to delete a file.
3. Where (what directory) is the Java SDK installed on your computer?
4. How to use an IDE such as Eclipse, IntelliJ, or Netbeans.
5. How to use Git and Github.
  * Create a new local repository
  * Add files to the repository
  * Remove (delete) files in the repository
  * Check status of your repository
  * Add Github as a "remote" repository
  * Copy your local repository to Github ("push")
  * Create a local repository as a "clone" of a Github repository

---
[skeoop.github.io]: https://skeoop.github.io
[google-classroom]: https://classroom.google.com
[resources]: https://skeoop.github.io/Resources
[github-oop2018]: https://github.com/OOP2018
[github-classroom]: https://classroom.github.com/classrooms/32051939-ske-programming-2
