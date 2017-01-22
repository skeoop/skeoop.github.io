# Object-Oriented Programming

This repository contains course materials for Object-Oriented Programming 2 at [Kasetsart University](http://www.ku.th), taught by James Brucker.

[Wiki](https://bitbucket.org/skeoop/oop/wiki) contains the [course description](https://bitbucket.org/skeoop/oop/wiki/About) and [weekly schedule](https://bitbucket.org/skeoop/oop/wiki/Home) with topics, homework, and links to the lab and programming assignments.

This [Source Repository](https://bitbucket.org/skeoop/oop/src/master) has lecture slides, assignments, and related material in subdirectories.
    [week1](https://bitbucket.org/skeoop/oop/src/master/week1) for week 1 material,
    [week2](https://bitbucket.org/skeoop/oop/src/master/week2) for week 2 material,
    and so on.

[Results & Feedback]( https://bitbucket.org/skeoop/oop/src/master/results): the [results](https://bitbucket.org/skeoop/oop/src/master/results) folder in the source repository contains results and feedback on programming assignments and labs.

### Cloning the Course Repository

All the course material is stored in a Git repository on Bitbucket.  You can make a personal copy by cloning it onto your computer.  **Please read below** for the correct way to clone.

The source repository and wiki have been updated many times, with a lot of revisions and deletions. Cloning the entire history will waste time (for download) and disk space.  Just clone the current version by using the ``git clone --depth 1`` as follows:

    # Change to the directory where you want to copy course material to.
    # Git will create a subdirectory named "oop".
    cmd> cd someplace
    cmd> git clone --depth 1 git@bitbucket.org:skeoop/oop.git
after that, you can update your clone anytime using ``git pull``.
