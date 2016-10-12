# Object-Oriented Programming

This repository contains course materials for Object-Oriented Programming 2 at [Kasetsart University](http://www.ku.th), taught by James Brucker.

Information about the topics covered and requirements are in the [course description](https://bitbucket.org/skeoop/oop/wiki/About) in the [Wiki](https://bitbucket.org/skeoop/oop/wiki).

[Wiki](https://bitbucket.org/skeoop/oop/wiki) contains the [course description](https://bitbucket.org/skeoop/oop/wiki/About) and a [weekly schedule](https://bitbucket.org/skeoop/oop/wiki/Home) including topics, homework, and links to the lab and programming assignments.

[Source](https://bitbucket.org/skeoop/oop/src/master) repository has lecture slides, assignments, and related material.     
    [week1](https://bitbucket.org/skeoop/oop/src/master/week1) for week 1 material,
    [week2](https://bitbucket.org/skeoop/oop/src/master/week2) for week 2 material,
    and so on

[Results & Feedback]( https://bitbucket.org/skeoop/oop/src/master/results): the [results](https://bitbucket.org/skeoop/oop/src/master/results) folder in the source repository contains results and feedback on programming assignments and labs.

**Individual Feedback** via Google Docs and "issues". TAs and instructor will give feedback and corrections to your lab work. You must implement corrections within one week of the time that we post them.


### Individual Feedback

The TAs and instructor will review your lab work every week and provide feedback and instructions for what you need to fix or improve.  We will try to meet with you 1-on-1 to review your work -- so be prepared to explain it!  Feedback is provided by:
* a Google Docs file to summarize feedback and work to be done
* Bitbucket issues for your assignment.  You should fix and then **close** each issue, and write a brief explanation about what you did when you close the issue.
* Comments in your code. Bitbucket lets you comment in source code. We may use that for extra clarity.

You must correct all problems or defects in lab work **within one week**.  Its not practical to repeatedly review and correct your work, so you have just one chance to fix it.  After that, the TA's evaluation is final.

Check your Google Doc file regularly, because you are responsible for implementing any corrections or rework that the TAs/instructor write in that doc. It counts toward your grade.

### Cloning the Course Repository

All the course material is stored on Bitbucket as a Git repository.  You can make a personal copy by cloning it onto your computer.

The Source repository and wiki have been updated many times, with a lot of material revised and deleted. Clone the whole thing will waste lots of disk space and bandwidth (for downloading), because it copies the entire history of the repository.   T clone the course repo, just clone the most recent update by using the ``git clone --depth 1`` as follows:

    # Change to the directory where you want to copy course material to.
    # Git will create a subdirectory named "oop".
    cmd> cd someplace
    cmd> git clone --depth 1 git@bitbucket.org:skeoop/oop.git
after that, you can update your clone anytime using ``git pull``.