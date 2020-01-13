## Why Branches and How to Use in Your Project

Branches let you create separate versions of a repository that can be merged and compared.  Common uses are:

1. Use a branch to develop new features, so new work doesn't mess up the tested and runnable verion on the "master" branch.  Errors on the branch don't affect other branches.
2. Enable several people to work on different features or parts of program -- each uses his own branch.  Your changes won't conflict with someone else's changes.
3. Use a branch to work on bug fixes.  Once the fix is tested and verified it can be "merged" into production code.
4. You can release code (from master) while work is going on (in branches).

## Understanding Branches

A git repositry is a **graph**.  

* Commits are nodes on the graphs. 
* Git branches are branches on the graph.
* Branch names like "master", and tags like HEAD are just **labels** that point to nodes.

Try the online [Git Visualizer](http://git-school.github.io/visualizing-git) - type git commands like "git commit", "git branch", "git checkout", "git reset" and see results on the graph.  *This really helps understand git*. 

## Merging

* Merging is combining files from different branches.  
* Merging may also involve same branch from different repositories.
    - `git pull` first fetches changes from a remote (`git fetch`) and then merges them.

What can happen?

* Best case: no conflicts or overlaps.
* Conflicting changes to a file.
* Non-conflicting changes in a file (successful merge) but result is incorrect!
    - example: two people add the **same** method to a class.
    - one person adds method at **top** of file, the other adds in at **bottom**.
    - first person "pushes" his changes to Github.  No problem since he's ahead of the branch on Github.
    - second person must "pull" or "fetch" and "merge" from Github to update his version.
    - `git merge` sees that person 1 added something at top, but line range doesn't conflict with person 2's changes, so it copies in the lines.   Merge succeeds.
    - Now the file has 2 copies of the same method!

## Branches and Tracking Branches

A "tracking branch" is a local branch with a corresponding remote.
When you clone a remote repository, your local "master" branch is
set to track "origin/master" (master branch on the remote repo named "origin").

To create a local "tracking branch" for some branch that already
exists on a remote, use:
```
git checkout  -b branch_name  origin/branch_name
# another command that does the same thing:
git checkout --track origin/branch_name
```

### Creating a New Remote Branch

You have a branch in your local repo named `dev-food`,
but there isn't any remote branch (on origin) for it.

What is the command to push your work to a *new* remote
branch with the same name (`dev-food`)?
```
git checkout dev-food
# in this command, "dev-food" is the name of the REMOTE branch
# usually you want it to be same as your branch name.
git push -u origin dev-food
```

The flag `-u` is short for `--set-upstream`.


### Fetch a Remote Branch and Track It

You are working on a project and a teammate asks you to review his
work on the branch `dev-auth` (an important feature!).  You don't
have that branch in your local repo yet.

What is the command to fetch `dev-auth` from origin and create 
a tracking branch for it?
```
cmd>  git checkout --track origin/dev-auth
```

### Good Collection of "How To" for Git Branching

This page has some useful Git commands for working with branches and remotes:

https://www.freecodecamp.org/forum/t/push-a-new-local-branch-to-a-remote-git-repository-and-track-it-too/13222

* Rename a branch: `git branch -m old_name new_name`  (or use `--move`)
* Delete a branch: `git branch -d branch_name  (or use `--delete`)
* Force delete a branch with unmerged commits: `git branch -d --force branch-name` (`-D` is same as `-d --force`)


## Reading: Basics of Branch and Merge

* [Branching and Merging](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging) from the online [Git Book](https://git-scm.com/book/) (download available).
* [Git Branch Command Examples](ttps://www.thegeekstuff.com/2017/06/git-branch/) shows commands for 15 common tasks
* [Git Visualizer](http://git-school.github.io/visualizing-git) type git commands and see a graph of the result! *This really helps understand git*. 

Optional:

* [Understanding Git Branches](https://www.sbf5.com/~cduan/technical/git/git-2.shtml) short article with pictures of what branch commands do.
* [Git-tips](https://github.com/git-tips/tips) how to perform common tasks in Git. 
* [How to Clone all Branches?](https://stackoverflow.com/questions/67699/how-to-clone-all-remote-branches-in-git) Stackover question with extensive explanation. Cloning and tracking remotes branches is a common problem.

## How To Use Branches in a Project?

In project work, your team should agree to and use a convention for branches and merging. For this course, use Github Flow.

* [Github Flow](https://guides.github.com/introduction/flow/)
* [Github Branching Convention](https://gist.github.com/digitaljhelms/4287848) has nice graph of using branches as in Github flow.

Please be consistent about...
* names you use for release tags.  
* names for bugfix branches.


## Questions on Branches

You should be able to answer these.  They will be on a quiz.

1. Why uses branches? (There are several uses.)

2. What is the git command to create a local branch?

3. What is the command to list the local branches?

4. What is the command to list **all** branches, including remote branches?

5. What is the command to switch to a branch named "dev"?

6. Suppose you have 2 branches: master and dev.  What is the command to show differences between files on those branches (diffs)?

7. What are the commands to merge "dev" into "master" (need at least 2)?

8. Does a branch create a copy of the original branch's files?

9. What is a command to show a graphical view of the branches and commits? More than one answer to this.


## Branches and Remotes

1. If you clone a remote repository, does it clone all branches?

2. After you clone a remote, `git branch -a` shows all the branches. What happens if you try to checkout one of the branches?

3. What is the command to clone a remote branch? (Clone it *and* track the remote so you can push your work back.)


### Remote Branch Examples

* To switch between branches, use `git checkout branch_name`.  It changes the current branch and also changes your working copy to match the HEAD of the new branch.  

* "CallMeBus" from Programming 2: https://github.com/thanakritfluk/callmebus

The repository has 3 branches on Github.

If we clone it:
```
git clone https://github.com/thanakritfluk/callmebus.git
```
and type:
```
cmd> git branch
* master
```
Only shows "master".  Add "--all" or "-a".
```
cmd> git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/add-correct
  remotes/origin/add_to_table
  remotes/origin/master
```
This means we have references ("refs") to remote branches on "origin", but no local branch that tracks them.

Suppose we want to look at the branch code.  There are 2 cases:

1. We just want to look at the branch code:
```
git checkout origin/add_to_table
```
this creates a detached branch.  

2. We want to commit changes to the branch:
```
git checkout -b add_to_table origin/add_to_table
```
creates a local "tracking branch".  It tracks changes to the remote branch, and can push changes to the remote branch.

3. Somehow you screw up and you have a local copy of existing branch,
but its not tracking a remote.  You can specify the remote tracking branch:
```
git checkout some_branch
git branch --set-upstream-to  origin/some_branch
```
This doesn't seem to be needed in practice.

## References

* [Push a new local branch to a remote](https://www.freecodecamp.org/forum/t/push-a-new-local-branch-to-a-remote-git-repository-and-track-it-too/13222) on freecodecamp.org

* [Bitbucket Interactive Branch & Merge Tutorial][bitbucket-learn-branching] uses Bitbucket cloud. You "fork" a public repo, make changes, and merge.  30-35 minutes.  

[bitbucket-learn-branching]: https://www.atlassian.com/git/tutorials/learn-branching-with-bitbucket-cloud
