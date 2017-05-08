## Object-Oriented Programming II 

This course covers object-oriented programming and design, including 3 subject areas:

1. Java programming language and its features
2. Object-oriented concepts, design, and programming, including some design patterns
3. Modeling using UML

For a detailed list of topics, see the [weekly schedule](https://skeoop.github.io/Home)

### Course Material

The [Source Repository](https://github.com/skeoop/skeoop.github.io) contains weekly material for the course as a Git repository, with subdirectories for each week and special topics.

| Schedule and Links | https://skeoop.github.io/Home |
| Material for week1 | https://skeoop.github.io/week1 |
| Material for week2 | https://skeoop.github.io/week2 |
| General Documents  | https://skeoop.github.io/docs  |
| Design Patterns    | https://skeoop.github.io/patterns  |
| Java Basics(1)     | https://skeoop.github.io/java-basics  |
| Resources          | https://skeoop.github.io/Resources |
| To view/copy anything | https://github.com/skeoop/skeoop.github.io/ |

Note: when a file is updated on [github.com/skeoop/skeoop.github.io](https://github.com/skeoop/skeoop.github.io) it may take *many minutes* before the change appears on [skeoop.github.io](https://skeoop.github.io/). 

(1) the [java-basics](https://skeoop.github.io/java-basics) is material you should already know from OOP1. We won't cover it in this course.

### Instructor and TAs

The instructor is James Brucker.
TAs are Taweerat C., Chinthiti W., and Kamontat C. (Net).  

To contact them, evaluate this Java expression:
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

The main sources for this course are:

* Horstmann, *Big Java*, 5E or 4E.  The 4th and 5th editions are almost identical. The 4th edition is more concise and some chapters are better organized. 5E has better page layout. Both editions cover Java 7, but not the new features in Java 8.
* *The Java JDK Documentation*. You are required to install this on your computer and **bookmark** the API index in your web browser. This is a great source of knowledge about the Java platform.
* *The Java Tutorial* from Oracle (Recommended).  I recommend you install this on your computer.  The "Really Big Index" page is the most efficient way to find things in the material, so bookmark it.
* Fowler, *UML Distilled*, 3E. (Optional)  Excellent, concise book about UML.  We will cover the Class, Sequence, and State Machine diagrams. You can find info on UML diagrams online, so this book is not required.

### Other Useful Resources

Listed in the file https://bitbucket.org/skeoop/oop/wiki/Resources.md

### Programming Tools You Will Need

1. **Java 8 JDK** and JRE.  The JDK includes a JRE.  Older versions do not have some features we will use.
2. **Java IDE**  Good ones are: Eclipse, Netbeans, and IntelliJ IDEA.  BlueJ is good for beginners and for trying out code.  In BlueJ, you can visualize code, interactively run code (without compiling), and inspect objects.  I use BlueJ in class.
3. **Git command line tool.**  IDEs include a git tool but you still need the command line git program.  Download from: http://git-scm.org/download/.
4. **UML editor is helpful.** Eclipse, Netbeans, and IDEA have UML extensions that can generate class diagram from Java code. [Violet](https://sourceforge.net/projects/violet/files/violetumleditor/) is a simple, easy-to-use UML editor written in Java. I use version 2.0.1 (not the newest) because it inserts less space.

Windows Users:
* Please do **not** install IDE, JDK docs, etc. on the desktop! (the actual path will be long have have space)
* Please use a **short path** without a **space** in the name.
```
Good path: C:\java\jdk8u20 and C:\java\jdk8\docs
Bad path:  C:\Program Files\Java\JavaSDK 8u20
```

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

### Join the OOP2017 Organization on Github

Students in this course please join the OOP2017 organization on Github.  We sent you invitiation by e-mail.

You need to join and complete your profile with your **real name** spelled correctly in English and a **photo** that clearly shows your face.  
You must join the organization in order to submit assignments or take quizzes using Github Classroom.

### Assignments using Github Classroom 

Some assignments use Github Classroom to distribute and submit work. You will be given (or emailed) a URL (link) that contains an "invitation" to do the assignment.  Visit the URL and "accept" the invitation.

Github Classroom then creates a repository for you, which may contain starter code and instructions.  For example, if the assignment is named "quiz9" you would get a repo with URL:
```
https://classroom.github.com/OOP2017/quiz9-yourname
```
where ```yourname``` is your Github login name.  `clone` this repository to your computer, complete the assignment, and then `push` your updated repo back to github.

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


### Cloning the Course Repository

All the course material is stored in a Git repository on Github and Bitbucket.

The source material has been updated many times, with a lot of revisions and deletions. To clone the entire history will waste time (to download) and disk space (for the history).  Clone only the current version by using ``git clone --depth 1`` as follows:

    # Change to the directory where you want to copy course material to.
    # Git will create a subdirectory named "oop".
    cmd> cd someplace
    cmd> git clone --depth 1 git@bitbucket.org:skeoop/oop.git

after that, you can update your clone anytime using ``git pull``.
The course material is currently in 2 repositories:
* https://github.com/skeoop/skeoop.github.io
* https://bitbucket.org/skeoop/oop/src (course location up to 5 May 2017)


### Old Course on Bitbucket
Before 5 May 2017 the course material was on Bitbucket.  Its still there but may not be updated.

Course Schedule: https://bitbucket/org/skeoop/oop (goes to https://bitbucket/org/skeoop/oop/wiki/Home)  
Course Description: https://bitbucket/org/skeoop/oop/wiki/About   
Course Repository: https://bitbucket/org/skeoop/oop/src has a folder for each week.
