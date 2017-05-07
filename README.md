# Object-Oriented Programming

This repository contains course material for Object-Oriented Programming 2 at [Kasetsart University](http://www.ku.th), taught by James Brucker.

[Course description](https://skeoop.github.io/About) has requirements, reading material, and grading scale.

[Schedule](Home) has weekly topics, assignments, and results.

The [Source Repository](https://www.github.com/skeoop/skeoop.github.io) contains all the material for the course as a Git repository, with weekly material in subdirectories.  There are 2 places to download it:
* https://www.github.com/skeoop/skeoop/github.io 
* https://bitbucket.org/skeoop/oop/src (old course location)
* If you clone it using git, please *clone only the current version* using:  `git clone --depth 1 git_url`.  Avoid wasting bandwidth and disk space downloading lots of old, obsolete, and erroneous material.

[Results & Feedback]( https://bitbucket.org/skeoop/oop/src/master/results): the [results](https://bitbucket.org/skeoop/oop/src/master/results) folder in the source repository contains results and feedback on programming assignments and labs.

### Cloning the Course Repository

All the course material is stored in a Git repository on Bitbucket.  You can make a personal copy by cloning it to your computer.  **Please read below** for the correct way to clone.

The source repository and wiki have been updated many times, with a lot of revisions and deletions. Cloning the entire history will waste time (for download) and disk space.  Clone only the current version by using ``git clone --depth 1`` as follows:

    # Change to the directory where you want to copy course material to.
    # Git will create a subdirectory named "oop".
    cmd> cd someplace
    cmd> git clone --depth 1 git@bitbucket.org:skeoop/oop.git

after that, you can update your clone anytime using ``git pull``.

### Old Course on Bitbucket
Before 5 May 2017 the course material was on Bitbucket.  Its still there but may not be updated.

Course Schedule: https://bitbucket/org/skeoop/oop (goes to https://bitbucket/org/skeoop/oop/wiki/Home)  
Course Description: https://bitbucket/org/skeoop/oop/wiki/About   
Course Repository: https://bitbucket/org/skeoop/oop/src has a folder for each week.


### OOP Organization

Students in the class please join the OOP2017 organization on Github.  We sent you invitiation by e-mail.

You need to join and complete your profile with **at least** real name written correctly in English, and a photo that clearly shows your face.  You must join the organization in order to submit assignments or take programming quizzes using Github Classroom.

### Assignments using Github Classroom 

Some assignments, quizzes, etc., use Github Classroom for distribution and submission.  In this you will receive a URL (link) to Github Classroom, which contains an "invitation" to do the assignment.  Visit the URL and "accept" the invitation.

This creates a repository for you, which may contain starter code and instructions.  For example, if the assignment is named "quiz123" you would have a repo with URL:
```
https://classroom.github.com/OOP2017/quiz123-yourname
```
where ```yourname``` is your Github login name.  You should `clone` this repository to your computer, complete the assignment, and then `push` your updated repo back to github.


Ref:
* [Github Classroom videos](https://classroom.github.com/videos)

### Assignments using Your Own Account 

Some assignments, such as labs, don't use Github Classroom.  In this case, create a remote repository in your Github account (the one you used to join our class) and push your work to there.  Please be careful to use the *exact name* specified on the assignment for the remote repo, including upper/lowercase of letters.  If you use the wrong name, we might not download your work (and as a result, you get no score).

The remote repo name does not have to match the local project name on your computer.  You add a remote using the command:
```
cmd>  git remote add origin git@github.com:yourname/repo_name.git
```
where `repo_name` is the remote repository (which you must create on github.com).  So, it can be any name -- not necessarily your local project name.
