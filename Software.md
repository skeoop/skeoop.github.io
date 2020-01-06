---
layout: page
title: Requirements and Recommendations
description: Required software for the course
---

# Required Software for OOP

## Github Account with Profile

1. Create a Github account.  Suggest you use *only lowercase* for your Github ID.  
  * Recommended: use your KU e-mail address so all course-related email goes to one place.
2. Complete your Github account profile.  You should provide *at least*:
  * Your real name in English. OK to use just first name, or first and last name. Use correct case of letters! 
  * A photo that clearly shows your face. Face should be at least 40% of vertical size.
3. Enter your Github ID in this form: 
[https://goo.gl/forms/uJU4wOJl0CJsJYhf1](https://goo.gl/forms/uJU4wOJl0CJsJYhf1).    
4. Check your e-mail for an invitation to join "OOP2020" on Github, and accept the invitation.


## Java Software and Documentation

1. [Java Development Kit 11][] (LTS).  We will use Java version 11 because it is the current "long term support" release.  Java version 8 is also fine, but it does not have the `jshell` interactive Java interpretter -- not a big deal since you can do the same thing in BlueJ.
    * [Download Java 11][Java Development Kit 11]
    * Where to install? (a) a directory with **no space in the path**, (b) **short path** is better, (c) not on the Desktop.
2. The Java Documentation should be installed on your computer and *bookmarked* in your web browser. This is a great source of knowledge.  
    * If you don't install it, you will not be able to look-up the Java API during a quiz or exam.
    * The [Java 8 Docs][] are *easier to read and browse*, so install them.
    * The [Java 11 Docs][] include some new classes, so install them, too.
3. Java Documentation Online (for reference):
    * [Java 8 Online Docs][]
    * [Java 11 Online Docs][]
4. Java Tutorial
    * Download from Oracle or read online.

[Java Development Kits]: https://www.oracle.com/technetwork/java/javase/downloads/index.html
[Java Development Kit 8]: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[Java Development Kit 11]:https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
[Java 8 Docs]: https://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html
[Java 11 Docs]: https://www.oracle.com/technetwork/java/javase/documentation/jdk11-doc-downloads-5097203.html
[Java 8 Online Docs]: http://docs.oracle.com/javase/8/docs/
[Java 11 Online Docs]: http://docs.oracle.com/javase/11/docs/

## Git Command Line Client

We will use Git for assignments.  Most IDE's include a built-in Git feature
but you should also have the command-line git.  Its easier to learn and use.

Download from [https://git-scm.com](https://git-scm.com)

## Integrated Development Environment (IDE) for Java

For beginners [BlueJ][] is great.  Simple interface and interactive "codepad" where you can use Java interactively.

Eclipse, Netbeans, or IntelliJ are preferred for serious development.  All these IDE support Java and many other languages (including Python and Kotlin).  

* [Eclipse][] versatile free IDE.  Configuring it is a bit complex.
* [IntelliJ IDEA][] has free community and "edu" editions.  This is same IDE as PyCharm with different configuration.  Configuring IDEA is also a bit complex.
    * The Edu edition includes EduTools plugin.  You can add this plugin to any version of IDEA, including PyCharm.
    * [IntelliJ Edu for Java][] includes a plugin for interactive courses in the IDE.
* [Netbeans][] is easiest to learn of these 3 IDE and has excellent curated plugin system.  Refactoring is somewhat less powerful than Eclipse or IDEA.

You can also write Java using VS Code, but the tools are much less powerful than the above 3.

[BlueJ]: https://bluej.org
[Eclipse]: https://eclipse.org
[IntelliJ IDEA]: 
[IntelliJ Edu for Java]: https://www.jetbrains.com/education/learning/java/ 

## Required Book

Horstmann, *Big Java*, 5E.  Covers Java 7. The 4th edition can also be used; its almost identical and more concise but some section numbers differ.

We'll describe you how to get the book in class.

### Windows Users: Where to Install Java

* Install Java using a short directory path **without any spaces** in the path.
* Don't install Java or JDK docs on the desktop.
* Use a **short path** without any **space** in the name.
```
Good path: C:\java\jdk8u151 
Bad path:  C:\Program Files\Java\JavaSDK 8u151
Also bad:  C:\Users\admin\Local Files\Desktop\Eclipse
```

If you install Java software in a long path with spaces it is difficult to correctly add it to the PATH variable that is used in command windows.  It also makes it harder for you to find!

## Recommended

1. BlueJ IDE from [https://bluej.org](https://bluej.org) . In BlueJ you can visualize code, interactively type and run code (without compiling), and inspect objects.
2. [The Java Tutorial](https://docs.oracle.com/javase/tutorial/) from Oracle is great help learning how to do things in Java. There is a [download link](http://www.oracle.com/technetwork/java/javase/java-tutorial-downloads-2005894.html) on the page to download it.  The "Really Big Index" page is the most efficient way to find things in the material, so bookmark it.
3. UML editor for drawing Class and Sequence diagrams.  There are UML extensions for Eclipse, Netbeans, and IntelliJ.  [Violet](https://sourceforge.net/projects/violet/files/violetumleditor/) is a simple, easy-to-use UML editor I use in class. It doesn't draw Sequence Diagrams well, though.

## Suggested Books

* *Head First Java*, 2E. Entertaining, visual, and very memorable, but long.
* Wampler, *The Essence of Object-Oriented Programming with Java* (2001). Old, but really good explanation of O-O concepts.
* *Starting Out with Java*, 5E by Tony Gaddis.  Covers the same material as *Big Java* but more focused presentation. Also covers JavaFX.
* David Eck, *Introduction to Programming in Java* free online and downloadable PDF at [http://math.hws.edu/javanotes/](http://math.hws.edu/javanotes/).  Good but too long.  Prof. Eck has other free books you may like.
* Horstmann, *Object-Oriented Design and Patterns*, 2E (2006). Condensed from "Big Java" with more emphasis on OO concepts and design.  Many SKE graduates say this is the **best book**.  OOP students can borrow my copy.
* Horstmann, *Core Java for the Impatient*. Same material as the famous *Core Java* series, but more concise and more example code.
