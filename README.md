# Object-Oriented Programming

This repository contains course material for Object-Oriented Programming 2 at [Kasetsart University](http://www.ku.th), taught by James Brucker.

[Course description](https://skeoop.github.io/About) has requirements, reading material, and grading scale.

[Schedule](Home) has weekly topics, assignments, and results.

The [Source Repository](https://www.github.com/skeoop/skeoop.github.io) contains weekly material for the course as a Git repository, with subdirectories for each week and special topics. To view online go to:
* https://skeoop.github.io/
To see and copy any folders or files go to:
* https://www.github.com/skeoop/skeoop.github.io/


### Join the OOP Organization

Students in this course please join the OOP2017 organization on Github.  We sent you invitiation by e-mail.

You need to join and complete your profile with **at least** your real name spelled correctly in English, and a photo that clearly shows your face.  
You must join the organization in order to submit assignments or take quizzes using Github Classroom.

### Assignments using Github Classroom 

Some assignments use Github Classroom to distribute and submit work. You will be given (or emailed) a URL (link) that contains an "invitation" to do the assignment.  Visit the URL and "accept" the invitation.

Github Classroom then creates a repository for you, which may contain starter code and instructions.  For example, if the assignment is named "quiz9" you would have a repo with URL:
```
https://classroom.github.com/OOP2017/quiz9-yourname
```
where ```yourname``` is your Github login name.  You should `clone` this repository to your computer, complete the assignment, and then `push` your updated repo back to github.

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
* https://www.github.com/skeoop/skeoop.github.io
* https://bitbucket.org/skeoop/oop/src (course location up to 5 May 2017)


### Old Course on Bitbucket
Before 5 May 2017 the course material was on Bitbucket.  Its still there but may not be updated.

Course Schedule: https://bitbucket/org/skeoop/oop (goes to https://bitbucket/org/skeoop/oop/wiki/Home)  
Course Description: https://bitbucket/org/skeoop/oop/wiki/About   
Course Repository: https://bitbucket/org/skeoop/oop/src has a folder for each week.
