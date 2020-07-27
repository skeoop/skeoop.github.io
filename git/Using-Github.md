### Why Use Github?

Using Git on your local computer is a good habit, but...

* What if your hard disk fails?
* How can your share a project with someone else?

You also need a **remote** copy of your project that you can easily update.

Git supports **remote** repositories.
[Github](https://github.com) and [Bitbucket](https://bitbucket.org) are 2 well known project hosting sites for git.  Both places let you store projects for free.

Using a **remote** git hosting site (such as Github) you can:

* synchronize your local repository with the remote. Only the changes are updated, so its efficient and fast.
* create a new local copy from the remote
* view project activity, updates, and compare changes to files
* give read-only or read-write access to other people 
* create a professional looking web site for your project (*Github pages*, which are shown on github.io)

### Two Ways to Use Github

There are 2 ways to start a project with Github.
The choice depends on these cases: 

**Case 1**: You already have code on your computer; you want to copy it to Github.   
**Case 2**: A project already exists on Github; you want to copy it to your computer.

The only thing that differs is how you create your local project repository and connect it with Github.  After that, the normal workflow is the same in both cases.

### Case 1: You already have code on your computer. Copy it to Github.

In this case, there are 3 steps

1. Create a local repository for your project.  Then commit code to it.
    ```shell
    cmd> cd workspace/myproject
    cmd> git init
    cmd> git add README.md .gitignore  (create these files yourself)
    cmd> git add src                   (add your source code)
    cmd> git commit -m "initial code checkin"
    ```
2. On Github, create an **empty** repository for the project.
    a. on [github.com](https://github.com) click on the "+" icon at upper-right of your home page and choose "create a new repository".
    b. give the repository a name. It does **not** need to be the same as your local project name.  For Programming 1, use the name the instructor specifies.
    c. don't put any files in the new repo -- not even a README.md
    d. copy the URL that Github shows you, for example `https://github.com/billgates/assignment1.git`.  (this is the URL for the "https" protocol)
3. On your local computer, add Github as "remote" repository.  Suppose the repo you created in Step 2 has URL "https://github.com/billgates/assignment1.gif". Then you'd do:
   ```shell
   cmd> git remote add origin https://github.com/billgates/assignment1.git
   cmd> git push -u origin master
   ```
   This adds the Github repo (assignment1) as a remote repository named "origin".  "origin" is the standard name for the default remote, but there is nothing special about the name "origin".  `git push` means to copy your local repository to the remote (github), `-u origin master` means to make "origin" the default target and "master" the default branch for a "push" command.

You only need to type `git push -u origin master` the **first time** you connect to Github.  After that, when you want to update Github you just type:
```shell
    cmd> git push
```

### Case 2: A project already exists on Github, but not on your computer.

If the project already exists on Github then do:

1. Using a web browser, go to the project page on github so you can get the URL
2. Click the "Clone or Download" button. This will show the URL of the project. It also gives instructions.
    * There is a button to copy this URL directly to your clipboard 
3. In the **parent directory** of where you want to clone the project, enter the `git clone` command:
    ```shell
    cmd> git clone https://github.com/billgates/someproject.git
    ```
    This creates a local directory having the same name as remote repository ("someproject" in this example) and copies the Github repo into it.
4. If you want to use a **different name** for your copy of the repository, then type:
    ```shell
    cmd> git clone https://github.com/billgates/someproject.git  myproject
    ```
    in this case, git will create a directory named `myproject` and copy the project there.

When you clone a project, git remembers the "upstream" location. So you can push (copy) your
local changes using `git push`.

### Case 3: You don't have ANYTHING yet

In this case you can start from either side (local or Github).  But Case 2 (clone from Github) requires less typing. Just create a new repo on Github, let Github add a README.md and .gitignore file for you, and then clone it.

### Pushing Local Changes to a Remote (Github)

Once you have connected a local repository with a Github repository using either Case 1 or Case 2, the information
is saved in the local git configuration.  You can "upload" your changes to Github using:
```
cmd> git push
```

### Normal Workflow Using Git and Github

When using git with Github, after you have created both a local repository and Github remote repository, you need to follow a pattern to ensure that everything is kept up-to-date.

If you are working alone (single person project) its pretty easy. If you work on a team, with everyone pushing work to Github, then you need to be more careful.

Here are the usual steps for an individual project (you are the only one committing to Github):

* Check status of your working copy: `git status`.  If you need to commit some work, then do so.  If the local repository is *newer* than your working copy, use `git checkout` to refresh your working copy.
* Do some work (programming).
* Test your work.  Fix any errors.
* Check status (again): `git status`
* Add and commit any changed files:
    ```shell
    cmd> git add src/file1.java src/file2.java
    # if you renamed a file in the IDE then you must tell git:
    cmd> git mv src/oldfilename src/newfilename
    # commit everything
    cmd> git commit -m  "describe what you did"
    ```
* **Shortcut:** after checking the status, if you want to commit **all** changed files then you skip "git add" and use the "-a" (all) flag:
    ```shell
    cmd> git commit -am "describe what you did"
    ```
* Push your work to Github:
    ```
   cmd> git push
   ```


### Learn Github

* [Using Git on Github](https://guides.github.com/activities/hello-world/), a tutorial on using git with gitub, including use of branches.  The example is a text file with variation in branches.


### Student Developer Pack on Github

A free [student developer pack](https://education.github.com/pack) gives you free private repositories, free builds on Travis CI, and other resources.  Some of the offers are limited to 1 year (starts the first time you use them), so you should read the details before activating a special offer.


### Use SSH Keys instead of your Github password

Every time you `push` an update to Github or Bitbucket, it prompts you for your username and password.  You can eliminate this by setting up a public/private key pair for Github.

The steps are described in [Connecting to Github with ssh](https://help.github.com/articles/connecting-to-github-with-ssh/).


