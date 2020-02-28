## The Problem

Chanathip, Nutta, Pittayut, and Theetouth are using an old URL
for ArrayIterator assignment (PA2) from 2018.  
The **old** url is https://github.com/OOP2018/pa2-something

The current url is: https://github.com/OOP2020/pa1-{githubid}

Chanathip, Nutta, and Pittayut already accepted the correct PA1 assignment and have an OOP2020 URL for PA1, but they aren't using it:

* Nutta     https://github.com/OOP2020/pa1-GifperTC 
* Pittayut  https://github.com/OOP2020/pa1-RitoruX
* Chanathip https://github.com/OOP2020/pa1-kaesrel

Theetouth has not accepted the OOP2020 PA1 assignment yet, so he does not have the current url.

Below are the steps to take to fix the problem.

## How to Check your Github "remote" URL?

In your local project directory for PA1, type:

>  git remote -v

It should print:
```
  origin   https://github.com/OOP2020/pa1-{yourgithubid}.git (fetch)
  origin   https://github.com/OOP2020/pa1-{yourgithubid}.git (push)
```
(if you use SSH the URL is different but contains "/OOP2020/pa1-something")

If your remote url is like this, then you are done.
You can push your work here.

If it prints "https://github.com/OOP2018/pa2-something"
then follow the steps below.


## Theetouch (theetouch.k@ku.th lisbono2001)

1. Accept the PA1 assignment at https://classroom.github.com/a/B0fIuHE6

   This will create https://github.com/OOP2020/pa1-lisbono2001


## Everyone using old assignment at URL /OOP2018/pa2-arrayiterator-userid

In your local "pa1" directory check the URL of your remote clone:

> git remote -v

It should print: 

> origin   https://github.com/OOP2020/pa1-{yourgithubid}.git (fetch)    
> origin   https://github.com/OOP2020/pa1-{yourgithubid}.git (push)

If this is what you see, then you are done. If it prints ".../OOP2018/pa2-something" then follow these steps to change it.

### Use the old URL as a backup

Before changing the "remote", push your work to the old remote as a backup:

> git push

### Change the Remote URL

1. Get the URL of your correct Github repo (go to github and check it):
   https://github.com/OOP2020/pa1-{yourgithubid}

2. In your project repository for PA1, change the remote URL using this command:

   git remote set-url origin https://github.com/OOP2020/pa1-{yourgithubid}

3. Verify it is correct:

   git remote -v

4. Now push all your work to the new origin.

   git push 

5. If "git push" fails (because git history doesn't match), then use this:

   git push --force

    > Only this time! using `--force` is dangerous

6. Use a browser to view https://github.com/OOP2020/pa1-{yourgithubid}    
   and verify your new work is there.


If you **cannot** push to the new remote repository, there is
another solution that should always work:

a. create a new local clone of https://github.com/OOP2020/pa1-{yourgithubid} to a different directory   
b. copy your work (*.java files) from your old project directory to the new clone directory.
    Be sure to put them in the correct subdir (`ku/util/`).    
c. Use "git status", "git add", and "git commit" to commit the files    
d. Enter "git status" again to make sure you committed everything   
e. Use "git push" to push to Github.    
f. Now use the new project directory for future work.    
> Rename your old project directory so you don't accidentally use it.

---
[pa1-url]: https://classroom.github.com/a/B0fIuHE6
