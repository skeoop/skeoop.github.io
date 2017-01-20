## Lab1: Java Fundamentals Practice (fixcode)

|   |   |
|---------|--------------------------------------------------|
|Objective: |Practice writing common Java methods and good Javadoc.|


|What to Submit: |Create a Git repository named **fixcode**. Submit your Java code to this repo. Include a README.md and .gitignore.            |

In this lab you will do these things:

1. Fix some bad code in the "fixcode" project.
2. Write good Javadoc for classes and methods.
3. Write an "equals" method, and discover why it should always be declared as `equals(Object other)`.
4. Commit your code to git and upload (push).
5. Draw a UML class diagram of Person and Student.

## Files for this lab.

1. In your workspace directory create a project named `fixcode` (you already did this).
2. Go to https://bitbucket.org/skeoop/oop/src.  In the **week1** directory download lab1-fixcode.zip.
3. Unzip the file into your project. It will create a subfolder named `src` with files for this assignment.

## Exploring Equals

1. Run the Main class in the fixcode project.
2. equals does not behave the way it should. Can you explain why it fails in some cases?
3. Look at the "fundamental methods" document (online) and correct the equals method.
4. Write an equals method for the `Student` class that also uses the standard template. Two `Student` are equal if both the name and id are the same.

## Writing Javadoc

Write good Javadoc in the Person and Student classes.  There are several Javadoc errors and omissions.
Put in your name as author in every class.




Git is a version control system that we'll use throughout this course for
submitting work.  Git is widely used for managing project documents,
especially source code.  Every developer needs to be able to use Git.

In this course you'll use Bitbucket.org for your git repositories.

There are 3 ways to use Git:

1. Type commands on the command line. Its good to do this first so you clearly understand the git workflow and what it does.
2. Use a GUI Git tool such as SmartGit or SourceTree.
3. Use Git tool that is including in Eclipse, BlueJ, and other IDEs.

If you use Eclipse, using Eclipse's Git client is convenient, but it can be confusing (and error-prone) at first.  So, use the git command line interface first! Once you understand it well, try Eclipse egit on a test project (something you can safely delete).

## Learning Git

1. https://try.github.io - interactive tutorial.
2. https://www.atlassian.com/git/tutorials - many tutorials, including advanced topics. Uses Bitbucket in some examples (Bitbucket is owned by Atlassian).
3. Section 4 of the video course "Software Engineering", on se.cpe.ku.ac.th. Has a nice graphical explanation of how working copy, local repo, and remote interact.
