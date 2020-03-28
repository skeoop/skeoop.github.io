## Programming Assignment 2 - Encryption

Due: **Sunday, 29 Mar, midnight**

Write a program that performs encryption and decryption as described below.

This assignment is based on the Encryption-Decryption problem at
[Hyperskill.org](https://hyperskill.org).  Hyperskill has step-by-step
explanations and exercises for all the concepts and programming 
syntax used in the application.  You can also **test your code online** while doing the assignment.

The Hyperskill Project URL is: https://hyperskill.org/projects/46?goal=7

At each "stage" there is an interview that lists
topics used and asks you which ones you already know.
By checking the topics you already know you can skip over them and save time,
but you can still go back and study them at any time.

In Stage 6, they explain some useful design patterns for this application.

The main class should be named `Crypt` in the default package,
but other code should be in package `encryptdecrypt` as in the Hyperskill
project.
For consistency with the Hyperskill project, the `Crypt` main method
can simply call `encryptdecrypt.Main.main(args)`.


### Problem Description

Write an application that encrypts or decrypts a file or String
using command line arguments. 

The syntax is:

```
java Crypt -alg {shift|unicode} -mode {enc|dec} -key n -data "string data" -in filename -out outputfile
```

All the arguments are optional.
The command line options -alg, -mode, -key, -data, -in, -out may be specified in any order.  The notation `-mode {enc|dec}` means that after the `-mode` option the next argument must be either `enc` or `dec`, *without* the braces {}.

The program should be able to encrypt or decrypt a text file of *any size*;
therefore, do not try to read the whole file into a String or char array!
(No credit if you do that.)

The meanings of the options are:

**-alg shift|unicode** is the algorithm to use for encryption and decryption. 
  - "shift" means to shift the English letters using a rotational cipher.  Other characters (not letters) are not modified. 
  - "unicode" means to shift all characters using the Unicode character sequence.  See below (or hyperskill.org) for more explanation.
  - If `-alg` is not specified, the default algorithm is "shift".
 
**-mode enc/dec** program should perform encryption ("enc") or decryption ("dec").  If -mode is not specified the default mode is "enc".

**-key n** n is a number used as encryption key in the algorithm. If not specified, the default key is 0.

**-data "string"** specify a string to encrypt or decrypt.  See `-in`, too.

**-in filename** name of input file containing text to encrypt or decrypt.  If both `-data` and `-in` are given, then `-data` has precedence.  If *neither* of these is given then assume that data is an empty string (as if `-data ""`). 

**-out outputfile** write the output to `outputfile`. If this option is not given then output to System.out.

### Algorithms

**shift** algorithm shifts letters by the amount of the key, and wraps around the alphabet as needed.
For English letters, lowercase always shifts to another lowercase letter, and uppercase shifts to another uppercase.

If key=2 then 'A' shifts to 'C', 'B' shifts to 'D', 'Y' shifts to 'A', and 'Z' shifts to 'B'.    
Similarly for key=2, 'a' shifts to 'c', 'b' to 'd', and 'z' to 'b'.

If key=2 then "Zat" would become "Bcv".

If key=-4 then "Car" would become "Ywn".

**unicode** means to shift *all* characters using the Unicode values of characters.  This is easy in Java, because (int)'c' returns the Unicode value (int) for any character.  

Restrict the values to 2-byte Unicode (1 - 65,535) and wrap around when needed.  The minimum character code should be 1 since 0 means a null character.  So, if key=-65 and char = 'A' (65), then it would be encoded as (char)65535, not 0.  Be careful when performing wrap-around: 65535+2 should wrap around to 2.  If you naively use "modulo", you might get 1 (incorrect).

If the data to encode is "A" (unicode 65) and key=-80 then the encoded char is (char)(65535-15). On your terminal this may *look* like a space, but it is not the same char. 

The encoded file may contain unprintable characters. That's OK.

### Examples

Command: `java Crypt -mode enc -key 5 -data "Welcome to hyperskill!"`

Output:
```
Bjqhtrj yt mdujwxpnqq!
```

Command: `java Crypt -mode dec -key 5 -data "Bjqhtrj yt mdujwxpnqq!"`

Output:
```
Welcome to hyperskill!
```

Command: `java Crypt -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode`

Output:
```
\jqhtrj%yt%m~ujwxpnqq&
```

Command: `java Crypt -mode enc -key 12 -in secret.txt -out secret.enc`

Encrypts file secret.txt and writes the output to secret.enc.

### Differences between PA2 and Hyperskill's Project

1. In the Hyperskill project the main class is named Main.  Here it is `Crypt`.  You can easily make the `main` method of Crypt.java call the `main` method of Main.java using one line of code, so you can have both.

2. When `-alg unicode` the min and max char values are 1 to 65,535. Wrap around if those limits are exceeded. The Hyperskill project doesn't exclude 0 or specify the upper limit (from what I've read).

### Shift Thai Letters?

When `-alg shift`, the Hyperskill assignment does a rotating cipher of the Englih letters A-Z and a-z.   Can you shift Thai letters, too?  Look at the Unicode table for [Thai](https://en.wikipedia.org/wiki/Thai_(Unicode_block)).  There are two "holes" of unused codes that may make this complex.  Invent your own solution, such as only shifting the consonants \u0E01 - \u0E2E.

### Optional: Encrypt System.in?

In the Hyperskill project, if either `-in` or `-data` are specified, the default is to encrypt an empty string.

A more typical (and useful) default would be to read from System.in and encrypt it.  You can add this if you want.  Be use to document it in the README.md file for your project.

If you do this, I suggest you add a boolean constant to your code to enable the feature, so you can *disable* it when testing your code on Hyperskill's site.

### Unicode

The full [Unicode](https://en.wikipedia.org/wiki/Unicode) standard uses 4-byte and currently includes 143,924 characters.  However, 2-bytes is enough for all current languages, including Chinese characters. The 2-byte unicode range is 0 (hex 0000) to 65,535 (hex FFFF). Unicode 0 is NULL and chars 1 - 31 (0x0 - 0x1F) are control characters, such as newline (10) and bell (7).

The official site [unicode.org](https://unicode.org) has all the character codes for different alphabets. 

The [Thai Unicode Block](https://unicode.org/charts/PDF/U0E00.pdf) is 0x0E00 - 0x0E7F.  The first code point is unused and there are 4 unused chars in the middle.  Those chars were removed from an earlier version.

## What to Submit

1. Accept the assignment on Google Classroom: http://bit.ly/OOP2020-pa2

2. This will create **an empty repository**.
   * Originally it contained a README and .gitignore, but I removed those so that you can easily create a repo in your existing project dir.

3. Submit your project source code, a README.md, and .gitignore file to Github. 

4. README.md should contain a description of what the program does and how to run it, so that anyone will know how to use the program.

5. `.gitignore` should contain a list of files for Git to ignore.  Use the .gitignore from PA1 as example. Mac users should add `.DS_Store` to .gitignore.

6. If you use Hyperskill to complete this project, only submit the `tasks` directory containing your project source code -- not the other files in the project.

7. **Points Deducted for Committing Junk** Only upload project source code, including directories for source and packages. Do not upload Java output dirs (build, out, bin), Hyperskill lesson files, and other unnecessary files.

### Creating a Local Repository

Where you put your Git repository depends on whether you write the code without using Hyperskill, or you integrate Hyperskill with IntelliJ to create the project.

If you use Hyperskill integrated with IntelliJ (requires EduTools plugin) then IntelliJ will create a layout like this:
```
Encryption-Descryption       - the Hyperskill Project
    Encryption-Descryption/  - code for this project
        task/                - YOUR IntelliJ PROJECT (and your Git repo)
            src/             - source code directory
            build/           - compiler output (don't commit)
            test/            - test code (don't commit)
    gradle/                  - files used by grade build management system
    Problems/                - tutorial exercises on Hyperskill
```

For students who start the project after 22 March, your Github Repository is empty, so there is nothing to "clone".  Instead create a local repository first, then add Github as "remote".

1. Create a local repository inside your project directory.  
   * Usually this is the project directory created by your IDE.  In this case, you create a git repository inside your project directory:
     ```
     cd workspace/Encryption
     git init
     (create a README.md and .gitignore)
     git add README.md .gitignore
     git commit -m "Add initial files"
     ```
   * If you are using Hyperskill integrated with IntelliJ then create a repo inside the `task` directory:
     ```
     cd Encryption-Descryption/Encryption-Decryption/task
     git init
     (create README.md and .gitignore)
     git add README.md .gitignore
     git add src
     git commit -m "add initial code"
     ```

2. Add Github as "remote" repository.  The command for this is shown on Github when create the assignment repo.
    ```
    git remote add origin https://github.com/OOP2020/pa2-your_githib_id  
    git push -u origin master
    ```

3. If you accepted the assignment before 22 March, then your Github repo already has a README and .gitignore.  In this case, you should "clone" the github repo before you can "push" to it.  
   * If you are not using IntelliJ integrated with Hyperskill, then you don't need to do anything.  Just use the cloned directory as your project directory.
   * If you use IntelliJ integrated with Hyperskill (which creates its own project directory), then first clone your Github repo to some empty directory.  Then **move** all the files (including the `.git` subdir) into the Hyperskill project `tasks` directory. 


### Individual Work

This is an individual assignment. Do not ask other students for help or share code.  Please ask TAs or instructor if you need help.
