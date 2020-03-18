## Programming Assignment 2

Due: **Saturday, 28 Mar, midnight**

Write a program that performs encryption and decryption as described below.

The main class should be named Crypt.

This assignment is based on the Encryption-Decryption problem at
[Hyperskill.org](https://hyperskill.org).  Hyperskill has step-by-step
explanation (and practice) of all the concepts and programming syntax used
in the application.  In Stage 6 they explain some useful design
patterns for this application.

At each "stage" there is an interview that lists
topics used and asks you which ones you already know.
By checking the topics you already know you can skip over topics
and save time, but you can still go back and study them any time.

The URL is: https://hyperskill.org/projects/46?goal=7

### Problem Description

Write an application that encrypts or decrypts a file or input String
using command line arguments.  All the arguments are optional.
The syntax is:

```
java Crypt -mode (enc|dec) -key n -data "string data" -in filename -out outputfilename
```

The command line options (-alg, -mode, -key, -data, -in, -out) may be specified in any order.

The meanings of the options are:

**-alg shift|unicode** is the algorithm to use for encryption/decryption. "shift" means to shift the English and Thai letters using a shift cipher, with wrap-around.  Other characters are not modified. "unicode" means to shift all characters using the Unicode character sequence.  If not specified, the default algorithm is "shift".  See below (or hyperskill.org) for more explanation.

**-mode enc|dec** program should perform encryption ("enc") or decryption ("dec").  If -mode is not specified the default mode is "enc".

**-key n** n is a number used as encryption key in the algorithm. If not specified, the default key is 0.

**-data "string"** specify a string to encrypt or decrypt.  See `-in`, too.

**-in filename** name of input file containing text to encrypt or decrypt.  If both `-data` and `-in` are given, then `-data` has precedence.  If *neither* of these is given then assume that data is an empty string (as if `-data ""`). 

**-out outputfile** write the output to `outputfile`. If this option is not given then output to System.out.

* Note: It would be more typical (and consistent) if the default input were to read from standard input (System.in) when neither `-data` or `-in` are given.

### Algorithm

**shift** algorithm shifts letters by the amount of the key, and wraps around.
For English, lowercase always shifts to another lowercase letter, and uppercase to another uppercase.  For Thai letters, shift and wrap-around using the Unicode sequence for Thai letters.

If key=2 then "Zat" would become "Bcv" ('Z' wraps around to 'A').
If key=-4 then "Car" would become "Ywn".

**unicode** means to shift all characters using the Unicode values of characters.  This is easy in Java, because (int)'c' returns the unicode sequence value for any char.  Restrict the values to 2-byte unicode (1 - 65,535) and wrap around when needed.  The minimum unicode value should be 1 since 0 means a null character.  Be careful when performing wrap-around (modulo): 65535+2 should wrap around to 2. The encoded file may contain unprintable characters.

The full [Unicode](https://en.wikipedia.org/wiki/Unicode) standard uses 4-byte and currently includes 143,924 characters.  However, 2-bytes is enough for all current languages, including Chinese characters. The 2-byte unicode ranges from 0 (hex 0000) to 65,535 (hex FFFF). 

### Examples

```
java Crypt -mode enc -key 5 -data "Welcome to hyperskill!"
```
Output:
```
Bjqhtrj yt mdujwxpnqq!
```

```
java Crypt -mode dec -key 5 -data "Bjqhtrj yt mdujwxpnqq!"
```
Output:
```
Welcome to hyperskill!
```

```
java Crypt -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
```
Output:
```
\jqhtrj%yt%m~ujwxpnqq&


```
java Crypt -mode enc -key 12 -in secret.txt -out secret.enc
```

Encrypts file secret.txt and writes the output to secret.enc.

### Differences between PA2 and Hyperskill's Project

1. When `-alg shift` you must shift-rotate the Thai alphabet, too. Hyperskill only shifts English letters.

2. When `-alg unicode` the min and max char values are 1 to 65,535. Wrap around if those limits are exceeded. The Hyperskill project doesn't exclude 0 or specify the upper limit (from what I've seen).

### Assignment URL

To be added.

### Individual Work

This is an individual assignment. Do not ask other students for help or share code.  Please ask TAs or instructor if you need help.
