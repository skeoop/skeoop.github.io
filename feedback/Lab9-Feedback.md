## Lesson from Lab 9 (CopyFile)

Problem 2 requires only 3-4 lines of code.   
And its easy to check if your code works correctly or not.

Yet, **60%** of the submitted codes are wrong!

Here is an example of testing a student code (with comments):

```
// change directory to where the code is
> cd workspace/Student/lab9

// compile the code
> javac CopyFile.java

// create a test file in another directory
> echo "hi" > /tmp/hello
// check the file. "3" mean the size is 3 bytes
> ls -l /tmp/hello
-rw-r--r-- 1 jim jim    3 Mar 20 12:46 /tmp/hello
// copy the file
> java CopyFile /tmp/hello /tmp/hello2
// check the result
> ls -l /tmp/hello*
-rw-r--r-- 1 jim jim    3 Mar 20 12:46 /tmp/hello
-rw-r--r-- 1 jim jim 1024 Mar 20 12:47 /tmp/hello2

BUG. hello2 is 1024 bytes long.
```

Another test: copy a PNG file and examime the copy.

```
> java CopyFile /tmp/dilbert.png /tmp/dilbert2.png

> ls -l /tmp/dilbert*
-rw-r--r-- 1 jim jim 64369 Mar 20 12:51 /tmp/dilbert.png
-rw-r--r-- 1 jim jim 64512 Mar 20 12:52 /tmp/dilbert2.png

> gimp /tmp/dilbert2.png
(it works! Image looks ok, but...)

> cmp /tmp/dilbert.png /tmp/dilbert2.png
EOF on /tmp/dilbert.png after byte 64369
(one file is shorter than the other)
```

## Developers Must Review and Test Their Code

* **Review Code** - take a break after coding, then carefully read the code line by line
* **Test Code** - run the application, test for "edge" cases, etc. Compare to the specification.

Lab 9 shows that many people are not reviewing or testing their own code.

Only 3-4 lines to review.  If you find a bug in testing you know exactly where to look.

## Review Your Documents, Too!

A few students submitted a README.md that looks like this on Github:

![Misformatted readme](Lab9-misformatted-readme.png)

You should check your Github repo after pushing work.
Fix the markdown.

## Check Your Files

A few students committed a lot of test files (junk) to Github, like this:

![Junk in Github Repo](Lab9-excess-files.png)

You should commit only files related to your application.
To remove excess files use:

```
git rm filename 
git commit -m ...
```

you can specify many files in one `git rm` command.


## TAs are Not Testers

Its your job to test your own code.  TAs are not here to test for you.
