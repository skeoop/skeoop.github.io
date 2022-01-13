---
layout: page
title: Required Material and Resources
---

## 1. Github Account with Profile

1. Create a Github account, if you don't already have one.  
  * Suggest you choose a Github ID that is *not too long*. Many people use their name or some abbreviation of their name, in lowercase or TitleCase.
      - Example [contributors to Visual Studio Code](https://github.com/microsoft/vscode/graphs/contributors) on Github 
2. Complete your Github account **profile**.  You should include *at least*:
  * Your **real name in English** with correct capitalization. OK to use just first name, or first and last name.
  * A **photo** that clearly shows your face. Face should be at least 40% of vertical size.
3. Enter your Github ID in this form: 
[https://goo.gl/forms/uJU4wOJl0CJsJYhf1](https://goo.gl/forms/uJU4wOJl0CJsJYhf1).    
4. Check your e-mail for an invitation to join "OOP2020" on Github, and accept the invitation.
5. After you join "OOP2020" on Github, you are also added to the Github classroom for the course.
    * This is different from "Google Classroom"

## 2. Join Google Classroom

We will use Google Classroom for some assignments. 

Goto [Google Classroom](https://classroom.google.com) and use class code **umaxt4s** to join.

## 3. Install Git Command Line Client

We will use Git for assignments.  The git command line tool is best for
learning git.
You can also use Git tools integrated into an IDE, but the command line is still needed when something goes wrong. 

Download from [https://git-scm.com](https://git-scm.com)

## 4. Java Development Kit (JDK)

You need the Java Development Kit, which includes the Java compiler, 
Java runtime, and libraries.  You can install either of these:

* JDK from Oracle
* OpenJDK from https://AdoptOpenJDK.net

the two are compatible.  

There are frequent new versions of Java.
Stick with the "Long Term Support (LTS)" version.
In this course you can use Java 11 or Java 15 (LTS).

* Java 11 & 15 use the Java module system. Does not include JavaFX (install separately), but includes jshell.

> Where to install the JDK?    
> I suggest you **do not** use the default location in Windows.    
> Please use a directory with **no space in the path** and a **short path** is better.     
> Don't install on the Desktop (only dummies do that).

## 5. Java Documentation

The Java API documentation should be installed on your computer and *bookmarked* in your web browser. This is a great source of knowledge.  

* The [Java 8 Docs][] are *easier to read and browse*. I find them very useful for learning new classes.
* The [Java 11 Docs][] or Java 15 Docs include new classes, so install one of those.

> If you don't install it, you will not be able to look-up the Java API during a quiz or exam.

For Online Reference: 
* [Java 8 Online Docs][]
* [Java 11 Online Docs][]


[Java Development Kits]: https://www.oracle.com/technetwork/java/javase/downloads/index.html
[Java Development Kit 8]: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[Java Development Kit 11]:https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
[Java 8 Docs]: https://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html
[Java 11 Docs]: https://www.oracle.com/technetwork/java/javase/documentation/jdk11-doc-downloads-5097203.html
[Java 8 Online Docs]: http://docs.oracle.com/javase/8/docs/
[Java 11 Online Docs]: http://docs.oracle.com/javase/11/docs/

## 6. Integrated Development Environment (IDE) for Java

You can use any IDE you like for coding.  
The best IDE for serious Java programming are:

* [Eclipse][] a versatile, free IDE.
* [IntelliJ IDEA][] is the same IDE as PyCharm, but with configuration for Java.
  - [IntelliJ Edu for Java][] includes a plugin for interactive courses in the IDE.
* [Netbeans][] is easiest to learn of these 3 IDE and has good, curated plugin system.

VS Code is good, but less powerful than the above for project management, code completion, and refactoring. 
On the plus side, VS Code starts quickly and imposes minimum project structure.

To use VS Code for Java you need the "Java Extension Pack" by Microsoft which includes "Language Support for Java" by Redhat. "Visual Studio IntelliCode" is also needed for practical use.  Avoid Java extensions not by Microsoft or Redhat, unless you study them carefully first. 

[Eclipse]: https://eclipse.org
[IntelliJ IDEA]: 
[IntelliJ Edu for Java]: https://www.jetbrains.com/education/learning/java/ 
[Netbeans]: https://netbeans.org

### BlueJ IDE

In the past, I recommended BlueJ for beginners. 
Its easy to use, gives you a graphical view of the project,
and has a built-in interactive Java interpretter (called the Codepad),
and ability to inspect objects interactively. 
This is great for exploring Java and trying new things.

However, Java now comes with Jshell which is also an interactive
Java interpretter (more powerful than BlueJ's Codepad).
And, BlueJ does not recognize the usual Java project structure (src and bin directories), and creates a lot of junk files for BlueJ artifacts.
So, I don't particularly recommend it.

[Download BlueJ](https://bluej.org) from https://bluej.org.

## 7. Required Book

Horstmann, *Big Java*, 5E or newer.  

We'll describe how to get this book in class.

For the new features in Java 8 you need the 6th edition, but for everything else the 5th edition is OK.

## Learning Java

See [resources](../resources)


### Windows Users: Where to Install Java?

* Install Java using a short directory path **without any spaces** in the path.
* Don't install Java or JDK docs on the desktop.
* Use a **short path** without any **space** in the name.
```
Good path: C:\java\jdk8u151 
Bad path:  C:\Program Files\Java\JavaSDK 8u151
Also bad:  C:\Users\admin\Local Files\Desktop\Eclipse
```

If you install Java software in a long path with spaces it is difficult to correctly add it to the PATH variable that is used in command windows.  It also makes it harder for you to find!
