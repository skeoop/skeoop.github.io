## Object-Oriented Programming 2 

This course covers object-oriented programming and design, including 3 subject areas:

1. Java programming language and its features
2. Object-oriented concepts, principles, and design, including some design patterns
3. Modeling using UML

For a detailed list of topics, see the [weekly schedule](https://skeoop.github.io/index)

### Course Material

The [Source Repository](https://github.com/skeoop/skeoop.github.io) contains weekly material for the course as a Git repository, with subdirectories for each week and special topics.

| Schedule and Links | https://skeoop.github.io/index |
| Material for week1 | https://skeoop.github.io/week1 |
| Material for week2 | https://skeoop.github.io/week2 |
| General Documents  | https://skeoop.github.io/docs  |
| Design Patterns    | https://skeoop.github.io/patterns  |
| Java Basics(1)     | https://skeoop.github.io/java-basics  |
| Resources          | https://skeoop.github.io/Resources |
| All files in repo  | https://github.com/skeoop/skeoop.github.io/ |

Note: when a file is updated on [github.com/skeoop/skeoop.github.io](https://github.com/skeoop/skeoop.github.io) it may take *many minutes* before the change appears on [skeoop.github.io](https://skeoop.github.io/). 

(1) the [java-basics](https://skeoop.github.io/java-basics) is material you should already know. We won't cover it in this course.

### Required Material

See [Requirements](Requirements) for software and other items you need for this course.

### Instructor and TAs

The instructor is James Brucker.
TAs are Taweerat Chaiman, Chinthiti Wisetsombat, and Kongpon Charanwattanakit.

To contact them, use this Java method:
```java
/**
 * Get someone's KU Email address.
 * @param p a Person with firstName and lastName in English
 * @return the person's email
 */
public String getEmail(Person p) {
  final String DOMAIN = "ku.th";
  StringBuilder sb = new StringBuilder();
  if (p.isThaiName())
    // for Thai names
    sb.append(p.firstName).append('.').append(p.lastName.charAt(0)).append('@').append(DOMAIN);
  else
    // for foreign names
   sb.append(p.firstName.charAt(0)).append('.').append(p.lastName).append('@').append(DOMAIN);
  return sb.toString();
}
```
Do you see any **duplicate code** that you could move out of the "if" statement?

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

1. How to write and compile Java, including creating and using objects.
  * Everything that was covered in Programming 1, including methods, loops, conditional expressions, arrays and ArrayList, defining classes, and creating objects. 
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
