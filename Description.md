### Object-Oriented Programming 2 Course Description

This course covers object-oriented programming and design, including  3 subject areas:

1. Java programming language and its features
2. Object-oriented concepts and design, including some design patterns
3. Modeling using UML

For a detailed list of topics, see the [weekly schedule](https://bitbucket.org/skeoop/wiki/Home) at https://bitbucket.org/skeoop/oop/.

### Course Material

* Course material is online at: https://bitbucket.org/skeoop/oop/src.
* [Weekly Schedule](https://bitbucket.org/skeoop/oop/wiki/Home) of topics and assignments is at https://bitbucket.org/skeoop/oop/wiki/Home. This page contains links to assignments and other material.
* [Class Materials](https://bitbucket.org/skeoop/oop/src/master) organized by week are in the [source repository](https://bitbucket.org/skeoop/oop/src/master) at https://bitbucket.org/skeoop/oop/src/master.

### Instructor and TAs

The instructor is James Brucker.
TAs are Taweerat C., Chinthiti W., and Kamontat C. (Net).  

Emails are not posted to avoid spam, but this Java expression might help:
```java
final String DOMAIN = "ku.th";
new StringBuilder(firstName).append('.').append(lastName.charAt(0)).append('@').append(DOMAIN).toString();
// for foreign names use
new StringBuilder(firstName.charAt(0)).append('.').append(lastName).append('@').append(DOMAIN).toString();
```


### Course work

This course has lectures, labs, and individual assignments.  In lecture we discuss material, do exercises, and quizzes. The lecture does **not**  teach you all the material!  You have to *read* and *practice* on your own for a complete understanding. In labs you will do hands-on programming and learn new skills, such as using git and refactoring code in an IDE.

Individual homework and programming assignments are to improve your understanding.

### Programming Assignments

There are programming assignments (PA) for you to do on your own, about one every 2 weeks.  These assignments are longer than the labs and require more design effort. The purpose is to help you improve your design and coding skill in depth, and let you practice writing **good quality code**.

*Design Your Own Project*: In the second half of the course, you will choose your own topic for one PA. Some student projects from past years are: network-based games, a chat application, a guitar tuner, and an image processor.

### Requirement for Individual Work

All assignments *must* be done individually, unless group work is explicitly alowed.  No copying is accepted, even a small part.

It is OK to discuss design and problems you have, but not to share code.  If you need help, please ask the TAs or instructor rather than the other students (who may not give you the correct answer).

**Copying == Fail**  Anyone who submits copied work will receive grade "F" and be reported to Faculty of Engineering for disciplinary action.

### Textbook and Readings

Readings are assigned from several sources. The main ones are:

* Horstmann, *Big Java*, 5E or 4E.  The 4th and 5th editions are almost identical. The 4th edition is more concise and some chapters are better organized. 5E has better page layout. Both editions cover Java 7, but not the new features in Java 8.
* Fowler, *UML Distilled*, 3E. (Optional)  Excellent, concise book about UML.  We will cover the Class, Sequence, and State Machine diagrams. You can find info on UML diagrams online, so this book is not required.
* *The Java JDK Documentation*. You are required to install this on your computer and **bookmark** the API index in your web browser. This is a great source of knowledge about the Java platform.
* *The Java Tutorial* from Oracle (Recommended).  I recommend you install this on your computer.  The "Really Big Index" page is the most efficient way to find things in the material, so bookmark it.

Windows Users:
* Please do **not** install IDE, JDK docs, etc. on the desktop! (the actual path will be long have have space)
* Please use a **short path** without a **space** in the name.
```
Good path: C:\java\jdk8u20 and C:\java\jdk8\docs
Bad path:  C:\Program Files\Java\JavaSDK 8u20
```

### Other Useful Resources

Listed in the file https://bitbucket.org/skeoop/oop/wiki/Resources.md

### Programming Tools You Will Need

1. **Java 8 JDK** and JRE.  The JDK includes a JRE.  Older versions do not have some features we will use.
2. **Java IDE**  Good ones are: Eclipse, Netbeans, and IntelliJ IDEA.  BlueJ is good for beginners and for trying out code.  In BlueJ, you can visualize code, interactively run code (without compiling), and inspect objects.  I use BlueJ in class.
3. **Git command line tool.**  IDEs include a git tool but you still need the command line git program.  Download from: http://git-scm.org/download/.
4. **UML editor is helpful.** Eclipse, Netbeans, and IDEA have UML extensions that can generate class diagram from Java code. [Violet](https://sourceforge.net/projects/violet/files/violetumleditor/) is a simple, easy-to-use UML editor written in Java. I use version 2.0.1 (not the newest) because it inserts less space.

### Individual Feedback

The TAs or instructor will review your lab work every week and provide feedback and instructions for what you need to fix or improve.  You may get feedback by 3 ways:
* **1-on-1 meeting** with TA to review your work. Be prepared to explain it! If you cannot explain what you did, it suggests you didn't do the work yourself.
* Post **issues** on your git repository. You should check the issues, fix them, and then **close** the issue with an explanation of what you did.
* Send you email.

You must correct all problems or defects in lab work **within one week**.  Its not practical to repeatedly review and correct your work, so you have just one chance to fix it.  After that, the TA's evaluation is final.

Check your Google Doc file regularly, because you are responsible for implementing any corrections or rework that the TAs/instructor write in that doc. It counts toward your grade.

### Grading

Your grade is based on:

* written exams (2)
* lab exams (2-3)
* programming assignments
* quizzes
* homework
* class participation
* lab participation and lab work

**Minimum Exam Scores to Pass:** To pass the course you must have: (a) average written exam score at least 50%, **and** (b) average lab exam score at least 50%.  

If you achieve the minimum exam scores, then the following grading scale is used based on all your work (as listed above):

| Overall | Grade |
|---------|-------|
|  > 85%  |   A   |
| 75-85   |   B   |
| 65-75   |   C   |
| 55-65   |   D   |
|  < 55%  |   F   |

### How to Clone the Course Repository

You can (optionally) clone the online course material as described in [README.md](https://bitbucket.org/skeoop/oop/src/master/README.md). Please follow the instructions and clone only the current version, by using `git clone --depth 1`.