---
layout: page
title: Git Assignment
---

## Preparation: Install Git, Create Github Account

1. **Install git** on your computer.
    * Windows and MacOS: download from [https://git-scm.com/downloads][git-scm]
    * Ubuntu: run `sudo apt-get install git`
    * Other Linux: see instructions at [https://git-scm.com/download/linux](https://git-scm.com/download/linux)
2. **Run** these **git** commands in a command window (*aka* a terminal or shell) to verify git is working on your computer:
```shell
cmd>  git --version
git version 2.14.x (your version may be different)
cmd>  git help config
(prints a help message for how to use "git config")
```
3. **Add your name and email:** Before you can use Git with Github or Bitbucket you must tell git **who you are**. This info is included in commit messages.  
Enter these commands (just one time) on your local computer:
```shell
cmd>  git config --global user.name "Your Name"
cmd>  git config --global user.email "youremail@ku.th"
cmd>  git config --list
(shows the config values)
```
You can change this info anytime by running `git config` again.    
**Points Deducted:** If I find commits by you on Github with missing/bogus info, points will be deducted from the assignment.
4. Create an account on [Github](https://github.com). **Complete your Github profile**:
    * Your **full name in English**, with proper case of letters, e.g. Bill Gates (not "bill gates").
    * A **photograph** *clearly* showing your *face*.
    * Your **KU-Gmail** address.
    * (Optional) Write a **profile** about yourself.
    * Example last year OOP students: [Jirayu](https://github.com/JirayuL) and [Kongpon](https://github.com/kykungz) (they both got "A" in OOP2)
    * **Employers** look at your Github account, so do a good job! For example: [https://kykungz.github.io](https://kykungz.github.io)

## Problem 1: Complete this Sign-up Form

Answer these questions: [Git Sign-up](https://goo.gl/cwrBbW) (https://goo.gl/cwrBbW).    
Your score is based on completeness information in your Github account.

## Problem 2: Create a Git Repo for Homework 1 and Push it to Github

Use Git to submit your SKE Restaurant code to Github.
On Github, the repository must be named **ske-restaurant**.

1. Find your project for Homework 1 ("SKE Restaurant", elab 10).
2. Create a git repository in that directory by running `git init`.
3. Create a `README.md` file describing the project. It must contain at least this info:
    ```
    # SKE Restaurant
    by Your Name

    A command line interface for a simple food ordering application.
    (Add more info about your project.)
    ```
4. Add to the repository: a) `README.md`, b) `.gitignore`, c) your **source code** (`src`) directory:
    ```shell
    cmd> git add README.md .gitignore src
    ```
5. Commit the files to the repository using `git commit -m "initial code checkin"`.
6. On **Github** create an **empty** repository named **ske-restaurant**. (Must be empty.)    
7. Back in your local project, add the Github **ske-restaurant** repo as a "remote" repository and "push" your repository to Github:
    ```shell
    cmd> git remote add origin https://github.com/your_github_name/ske-restaurant.git
    cmd> git push -u origin master
    ```
8. In a web browser, view your project on Github.
    * Is the Github repository named **ske-restaurant**?
    * Are all the source files there (in a **src/** dir)?
    * Does it have a **README.md**?
    * Is the formatting of README.md correct?


**Note:** your local project name **can be different** from the Github repository name.  Git doesn't care.
But the Github repository **must** be named **ske-restaurant**.


## Homework

Please complete a Git tutorial. There will be a **Git Quiz** which may include anything from these tutorials.

1. Learn more about git: [https://try.github.io](https://try.github.io)
2. [Using Git on Github](https://guides.github.com/activities/hello-world/).

---
[git-scm]: https://git-scm.com/downloads 
