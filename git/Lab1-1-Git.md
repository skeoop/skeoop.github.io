---
layout: page
title: Git Practice
description: 
---

# Lab 1: Git Practice

| Objective  | Practice the common git commands and workflow.  |
| --- | --- |
| What to Submit | A Git repository named **gitdemo** with README.md and .gitignore submitted to github.  |

For this lab use the Git command line tool.

## Organize Your Work

You should have a directory which is the "base directory" for programming projecs.  Each project will be in a separate subdirectory.

For example, suppose `/home/hacker` is your home directory (on Windows, `C:\Users\hacker`), then you might have a layout like this:

```
/home/hacker                  your home directory
/home/hacker/workspace        base directory for projects
/home/hacker/workspace/lab1   a project named lab1
                      /guessing-game a project named guessing name
```

## Create a Local Git Project

1. Create a directory named `gitdemo` inside the diretory where you your Eclipse workspace. You will use this repository for Java practice later.
2. Initialize a git repository inside the `gitdemo` directory:

```
> cd /somepath/workspace/gitdemo
> git init
```
3. Create a README.md file. This file can contain Markdown formatting. An example README is:
```
# OOP Lab1: Git practice
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

## Exercise 1: Add your git knowledge to README.md

1. Edit README.md and add some more text, including your name!  Include a description of all the "git" commands you have learned.  For example (including Markdown formatting):   
```
 Git Commands
 ------------
 * `git init` - create a new repository in current directory
 * `git food` - this is not a git command. Fix it.
```
2. Commit the changes to your repository.


## Exercise 2: Create .gitignore

For programming projects, you should **not** commit compiler output files to git!  For Java, that means don't commit .class files.  Git has a special file named `.gitignore` that is used to list all the files that you *don't wnat* git to put in the repo.  You can use \* as a wildcard character (match anything) and directory names to exclude an entire directory.  Likes beginning with # are comments.

1. Create a `.gitignore` file containing these lines:
```
# Files to ignore
bin/
build/
*.class
```
2. Add `.gitignore` to the repository and commit it.
3. Add some lines to `.gitignore` to ignore any file ending with ".tmp" or ".swp" (editor temp files). Commit the changes.

## Adding a Remote Repository

So far, you've been using Git locally on your computer. In this step you will connect your repository to a "remote" repository on Github.

1. Go to github.com and create an **empty** project for your project, named "gitdemo".
It is important that this repo be totally empty because you want to upload files from your local repository.
    * Make the repository be "public" (the default on Github)
2. Copy the repository URL to your clipboard (or just remember it).
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
2. https://www.atlassian.com/git/tutorials - many tutorials, including advanced topics. Uses Bitbucket in some examples (Bitbucket is owned by Atlassian).
3. There are lots of good videos on Youtube.  Also a mini-course on Git on Coursera.
4. The Johns Hopkins course on Ruby on Rails has some videos and lecture notes on git: https://github.com/jhu-ep-coursera/fullstack-course1-module1
