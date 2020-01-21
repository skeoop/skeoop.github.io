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


## Organize Your Projects

You should have a directory which is the "base directory" for programming projecs.  Each project will be in a separate subdirectory.

For example, suppose `/home/hacker` is your home directory (on Windows, `C:\Users\hacker`), then you might have a layout like this:

```
/home/hacker                  your home directory
/home/hacker/workspace        base directory for projects
/home/hacker/workspace/lab1   a project named lab1
                      /guessing-game a project named guessing name
```

## 1. Create a Local Git Project

1. Create a directory named `demo` inside your projects directory. 
2. Initialize a git repository inside the `demo` directory:

```
> cd /somepath/workspace/demo
> git init
```
3. Create a README.md file. This file can contain Markdown formatting. An example README is:
```
# OOP Git Practice
```
4. Enter the command `git status` to check the status of your repository.  Git will print a message like this:
```
> git status
Untracked files:
     README.md
```
This means that this file isn't included in your repository yet. Git keeps an "index" of all the files that you have added to the repo.
5. Add the README.md file to the repo. This command also "stages" it for commital:
```
> git add README.md
```
then check the status again using `git status`. This time you should see:
```
Changes to be committed:
    new file: README.md
```
6. Copy README.md into the repository. This is called a "commit".  Git requires you supply a text message explaining each commit.  Type:
```
git commit -m "Initial checkin of README"
```
7. Now type `git status` again and see that your working copy contains no changes (it matches what is in the repo).
```
> git status
On branch master
Nothing to commit, working directory clean
```

## 2. Add your git knowledge to README.md

1. Edit README.md and add some more text, including your name!  Include a description of all the "git" commands you have learned.  For example (including Markdown formatting):   
```
 Git Commands
 ------------
 * `git init` - create a new repository in current directory
 * `git food` - this is not a git command. Fix it.
```
2. Commit the changes to your repository.


## 3. Create .gitignore

For programming projects, you should **not** commit compiler output files to git!  For Java, that means don't commit .class files. For Python, don't commit `__pycache__` directories. Also, don't commit IDE files such as .vscode, .settings, .classpath.

Git has a special file named `.gitignore` that is used to list all the files that git should *ignore* (not check in to the repo). You can use \* as a wildcard character (match anything) and directory names to exclude an entire directory.  Likes beginning with # are comments.

1. Create a `.gitignore` file containing these lines:
```
# Java files to ignore
bin/
build/
*.class
# Python file
__pycache__
*.pyc
# IDE Files
*.ctxt
.iml
.classpath
.settings
.project
```
2. Add `.gitignore` to the repository and commit it.
3. Add some lines to `.gitignore` to ignore any file ending with ".tmp" or ".swp" (editor temporary files). Commit the changes.

## Adding a Remote Repository

So far, you've been using Git locally on your computer. In this step you will connect your repository to a "remote" repository on Github.

1. Go to github.com and create an **empty** project for your project, named "gitdemo".
It is important that this repo be totally empty because you want to upload files from your local repository.
    * Make the repository be "public" (the default on Github)
2. Copy the Github repository URL to your clipboard (or just remember it).
3. In the command window on your local computer (in the `gitdemo` directory), add a "remote" repo to your project.
```
> git remote add origin https://github.com/your_github_id/gitdemo.git
```
"origin" is the standard name for the default remote.
4. "Push" (copy) your local repository to the remote repository, and also set it as the default "upstream" (-u) repository:
```
> git push -u origin master
```
5. Next time you want to "push" files from your local repo to the remote you can simply type:
```
> git push
```
Git will remember the default (upstream) remote to use.

## Learning Git

1. https://try.github.io - interactive tutorial.
2. [Using Git on Github](https://guides.github.com/activities/hello-world/).
3. There are lots of good videos on Youtube.  Coursera.org has a mini-course on Git.
4. The Johns Hopkins course on Ruby on Rails has some videos and lecture notes on git: https://github.com/jhu-ep-coursera/fullstack-course1-module1

## Homework

Please complete a Git tutorial. There will be a **Git Quiz** which may include anything from these tutorials.

1. Learn more about git: [https://try.github.io](https://try.github.io)
2. [Using Git on Github](https://guides.github.com/activities/hello-world/).

---
[git-scm]: https://git-scm.com/downloads 
