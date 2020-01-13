## Git Questions

## Part 1. Background and Basic Information

Chapter 1 of [Pro Git][ProGit] covers these questions.
In particular, you should know what's is section _1.3 Git Basics_.

1. What is Git?

2. What is the main difference between Git and Subversion (another VCS)?  

3. When working with Git locally, what are these?  Describe each one.
   * Staging area
   * Working copy
   * master
   * HEAD

4. When you modify a file and commit it to a repository, what is stored in the repository? (_1.3 Git Basics_)
   [ ] Differences between this version and previous version.
   [ ] A snapshot of the file.  The complete file, possibly compressed.

### Part 2. How To Use Git

1. What command(s) create a new local repository for a project named `Tetris`?

2. There are 2 ways to get a local Git repo.  What are they?
    a.
    b.

3. How can you see what files are in the local repository?

4. What are 2 commands to add files in your working copy *to* the git repository?

5. How do you compare status of your working copy to the local repo?


6. The output of `git status` is verbose (but helpful!). How to get a short view of the status?

7. Suppose A.txt is in the git repository (a "tracked file") and you want to delte it (from the repo **and** your working copy).  What is the command?


   * Someone could just delete the file in their working copy (using command line or File Explorer) and then "commit" changes to git.  Explain why this won't delete the file from repo.

## The Repository

1. Where on your computer's filesystem is the git repository for a project?


2. In your project directory, what kind(s) of files should you *not* commit to a Git repo?

3. How can you avoid accidentally committing unwanted files to a git repo?


4. Many Git tutorials instruct people to add their project to a git repo like this:
    ```
    cd /somepath/myproject
    git init
    git add .
    ```
    This is a bad idea. Why?



## Viewing Changes and Commits

1. What are some commands to show a history of commits?
    * brief format: one line per commit
    * longer format
    * how to show all branches?
    * a GUI tool to show history
    

## Undoing Changes

1. Suppose you add a file to the staging area and decide you don't want to commit it.  What is command to remove a file from staging area?  (undo "git add filename")
```
# to remove file "foo" from staging are:
git _______________
# to remove everything from staging area:
git _______________
```
> Note: if you have not yet committed anything to the repo, then `reset` won't work.  In that case use `git rm --cached filename` which removes the file from the "index" (list of tracked files).

2. Suppose you commit files and want to "undo" the commit? What is the command to "undo" a commit?  (It resets location of HEAD but does not change your working copy.)

3. You accidentially mess up the file "foo.py" in your working copy.  What is the command to replace this file (in your working copy) with the last version you committed to git? (That is, checkout the most up-to-date revision of this file)

```shell
cmd> 
```

3. You accidentally DELETE the (tracked) file A.txt from your working copy.  How can you recover the file from the repository?

4. You make changes to many files in your working copy, and the application is totally screwed up.  What is the git command to completely replace your working copy with the last commit to git (discards all changes to the working copy)?

```shell
# replace working copy with latest git command. This cannot be undone.
cmd> git reset --hard
```
  
    * Suppose your working copy contains some new, untracked file.  When you perform the above command, does git alter or remove this untracked file?

5. Even Worse! You accidentally delete some files and commit the changes! Now the files are deleted in the current Git HEAD.   How can you get back the the most up-to-date revision from git?

```
// Find the most recent commit containing the file:
git rev-list -n 1 HEAD -- filename
e4a6b2961974958a84c94ae36cde489d201b2d45
// For last 3 commits of a file use "-n 3"
// To see more detail about the commit, use "-v"
git rev-list -v -n 2 HEAD -- filename
e4a6b2961974958a84c94ae36cde489d201b2d45
tree d20c971afa4c4a2b83c6c15e00dd9c870e70813a
parent 8d3a2862282090ee50f4a11f26b333391ebb8be6
author fatalaijon <fatalaijon@gmail.com> 1534318476 +0700

    Fix #42, also add JUnit test and better Javadoc
// Now that you found the file, how to check it out? 
____________________________________
```
> Note: Git almost never really deletes anything.  There are special commands to delete branches and squash a range of commits; these commands do delete old stuff.


## View the Commit History

1. What commands show the commit history? (many answers)
   * 
   * 
   * 

2. What command shows you the files changed for each commit?


3. The history may be long.  How can you limit how much is shown?


## Viewing Changes in Your Work

1. How can you see the differences between your working copy and most recent commit?
>```git diff```

2. How do you view what **files** are staged for commit?
>```git status```

3. How do you view differences between staged files and last commit (HEAD)? Two solutions.
  * one
  * two

4. The output of `git diff` is too hard to read. Can "git" show it graphically?
> Yes. There are 3 better ways:
> * GUI tool or Eclipse EGit.
> * `git difftool`
> * `gitk`

5. How do you use `git difftool` instead of `git diff`?
   1. Type `git difftool --tool-help``` for a list of tools git can use.
   2. Choose one you like and install it. I use meld or diffuse.
   3. `git config diff.tool meld` to specify "meld" as diff tool.
   4. Use `git difftool` instead of `git diff`


## Viewing Changes in the Repository

These commands are useful for seeing what has changed.
Its much easier to do on Github or using a GUI tool like gitk, SmartGit, or EGit (Eclipse).

1. What git command shows Difference between last 2 commits.


2. How to view Difference between 2 commits, where you specify the commit ids.
   First, view the history
   ```
   # git history, git log, git log1, or gitk
   git history
   git history
   * 8d3a286 - (22 hours ago) Add some MOOCs to References - jbrucker (HEAD -> master)
   * 051c9d4 - (4 days ago) change classroom code - jbrucker (origin/master)
   * e15706f - (5 days ago) remove bad git links - jbrucker
   * e771d36 - (5 days ago) fix typo in link reference - jbrucker
   * 76105d1 - (5 days ago) intro slides - jbrucker
   ```
   Specify 2 commits to compare, separated by "..." (3 periods).
   ```
   git diff 051c9d4...e771d36
   ```


## References

The Git [References](references) file has great docs about Git.

[ProGit]: https://www.git-scm.com/book/en/v2 "Pro Git online book on Git-scm.com"

[ProGitPdf]: https://progit2.s3.amazonaws.com/en/2016-03-22-f3531/progit-en.1084.pdf "Pro Git v.2 PDF on AWS. Longer, book format."


[Think Like a Git]: http://think-like-a-git.net/ "Understand visually how git works"

[Visualize Git]: http://git-school.github.io/visualizing-git/ "Online tools draws a graph of commits in a repo, as you type"
