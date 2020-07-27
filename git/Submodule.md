---
title: Git Submodules
---

Git **submodules** let you incorporate code from a separate git repository 
(the submodule) inside another git project.

This let's you: (a) update the repositories separately, (b) use the submodule code in many different projects. 

See [Submodules][git-submodules] in the Pro Git book,
and [Working with Submodules][working-with-submodules] example in Github blog.

[git-submodules]: https://git-scm.com/book/en/v2/Git-Tools-Submodules
[working-with-submodules]: https://blog.github.com/2016-02-01-working-with-submodules/

## Adding a Submodule for TicTacToe Unit Tests

There is a Git repository containing unit tests for TicTacToe.  The repository contains *only* the `test/` directory.  
You can add it as `test/` folder inside your tic-tac-toe project,
as a submodule.

You *could* add the code anywhere, but `test/` is the standard location for
test code.

```
TicTacToe/
   src/             your source code
      tictactoe/   Java package for code
         TicTacToe.java
   test/            submodule for "test/" folder ("git submodule" creates this)
   build.xml        Ant build file for project
```

The submodule does not have the usual Java project layout.  It contains only files you want to "copy" into the `test` directory without the top-level `test` dir in the submodule.   In this example the submodule is `tictactoe-test` and contains:
```
tictactoe/              Java package for test code
   TicTacToeTest.java   Junit test
```

To add the submodule to your TicTacToe project use:
```shell
# change directory to your project code 
cmd> cd workspace/TicTacToe
cmd> git submodule add  https://github.com/ISP2018/tictactoe-test  test
```

In this command, the first argument after "add"
is the Github URL of a submodule to add, and the second argument (`test`)
is the directory (relative to your current directory) where the submodule will be cloned to.  It should be a new directory (not exist yet, just like using "git clone").

Now type `git status`.  You'll see there are 2 files added:
```shell
cmd> git status
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

	new file:   .gitmodules
	new file:   test
```
The files in the `test/` directory will **not** be commited to your repo. Only the directory name itself is added.

In old versions of `git`, after adding a submodule you must run the `git submodule update` to clone its contents. In the current Git, this isn't necessary. In older git, type:
```shell
cmd> git submodule update --init
```

### What Happened?

Git updated your project configuration with .gitsubmodules, and created a clone of the `tictactoe-test` repo in your `test/` directory.

In effect you have a separate Git repository inside your project repository.

### Running the Tests in an IDE

To run the tests in an IDE (Eclipse, IntelliJ, etc.) you probably need to add `test` to the build path, and maybe add the JUnit library to the project build path.

### Automate Unit Tests

A more efficient way to run tests is:

* use [Ant](https://ant.apache.org) 
* use Continuous Integration to automatically checkout code and run tests. For this, your project needs a build configuration using Ant, Gradle, or Maven.

### Updating the Submodule Files

The files in the `tictactoe-test` project may be updated on Github.
To update your clone,
just change directory to the submodule directory (`test`) and use `git pull`:
```shell
cmd> cd test
cmd> git pull
```
There is also `git submodule` command for this, which is useful if you have
many submodules to update.


