## Feedback on Lab 9

## CopyFile (Problem 2)

**How to test**

1. Copy some files and compare copy to original.
2. Try different cases: a short file, an empty file, a long binary file.
3. Try error cases: target already exists (should not overright), source file doesn't exist or not a file.

Problem 2 requires only 3-4 lines of code.   
And its easy to check if your code works correctly.
Just run it and verify the copy is same as the original file.

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

```
**BUG**. `hello2` is 1024 bytes long.

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
```
One file is shorter than the other!

## Compare

I tested using the following comparisons:

* Two identical 1 byte files
* Two 1 byte files that differ ("a" and "b")
* A 1 byte and 2 byte file where first byte is same
* Two identical long files (approx 12,000 bytes)
* Two long files where last byte is different
* Two long files that are almost same but one has 3 extra bytes
* Compare a file to a non-existing file
* Only one command line argument (should print usage message)
* No command line arguments (should print usage message)

To check your code, compare your program output to the `cmp` command
(Linux, MacOS, and GNU/Bash shell) or `fc /b` (Windows).

## Compare Using BufferedInputStream

Many students wrote compare that reads an array of bytes from each file 
and compares the arrays byte-by-byte.  That's good!  Its much faster
than reading 1 byte.  But the logic of `compare` is more complex.

Another way to get faster input is using a `BufferedInputStream`.
Then you can read 1 byte at a time and let BufferedInputStream
take care of "buffering" the input for you.

BufferedInputStream "wraps" another InputStream and does buffered reads.
Since its a subclass of InputStream, you can use it the same as InputStream.
There is a constructor with default buffer size or you can specify a
buffer size:
```java
InputStream in = new BufferedInputStream( new FileInputStream(file) );
```

See the [Javadoc for BufferedInputStream](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedInputStream.html).

```java
private static void compare(String filename1, String filename2) {
    final int BUFFSIZE = 4096;
    File file1 = openFile( filename1 ); // checks file existence, etc.
    File file2 = openFile( filename2 ); // checks file existence, etc.

    try (
        // Buffered input streams add buffering to InputStream
        InputStream in1 = 
                new BufferedInputStream(new FileInputStream(file1), BUFFSIZE);
        InputStream in2 = 
                new BufferedInputStream(new FileInputStream(file2), BUFFSIZE)
        ) 
    {
        int count = 0;
        while (true) {
            int a = in1.read();
            int b = in2.read();

            // compare a and b, check for EOF
        }
     }
     catch( IOException ex ) ...
```

**How Fast is BufferedInputStream?**

Its not as fast as read to an array of bytes. In my test BufferedInputStream and 1-byte reads was 2X - 4X slower than InputStream with byte array reads.  
But that's acceptable here.  Reading byte-by-byte simplifies the logic of compare.

## WordCount

I used 5 test files and one non-existent filename.

See [lab9-test](https://github.com/OOP2020/lab9-test) repository.

Here are the files and correct outputs.
When I run the tests the files are in the `/tmp` directory.
On your computer the files may be in a different directory.

| Filename    | Content    |  Expected Output                      |
|:------------|:-----------|:--------------------------------------|
| emptyfile   | empty file | 0 0 0 /tmp/emptyfile                  |
| blankfile   | space and newline | 3 0 6 /tmp/blankfile           |
| oneline     | text on one line  | 1 4 22 /tmp/oneline            |
| Quotes.txt  | programming wisdom | 21 80 521 /tmp/Quotes.txt     |
| Alice.txt   | Alice in Wonderland | 1207 9660 52540 /tmp/Alice.txt |
| nonexistent | non-existent file  |/tmp/nonexistent does not exist. |

Final test is to enter four files on one command line:
```
java WordCount emptyfile blankfile oneline Quotes.txt
```
Expected output:
```
0 0 0  /tmp/emptyfile
3 0 6  /tmp/blankfile
1 4 22  /tmp/oneline
21 80 521  /tmp/Quotes.txt
```

## Can You Write Correct Code?

*If the only way you can write correct code is for someone else
to give you an oracle, then you can't write correct code.*

That's why Lab 9 did not include test files.

## Developers Must Review and Test Their Code

* **Review Code** - take a break after coding, then carefully read the code line by line.
* **Test Code** - run the application, test for "edge" cases, etc. Compare results to the specification.


## Review Your Documents, Too!

A few students submitted a README.md that looks like this on Github:

![Misformatted readme](Lab9-misformatted-readme.png)

You should check your Github repo after pushing work.
Fix the markdown.

## Check Your Repository

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
