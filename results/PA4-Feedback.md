## How I Graded PA4 (Readability)

I based the grade on these factors:

* How accurate the program evaluated 3 text files of varying difficulty.
* Where it accepts filename in command line mode.
* How it handles errors, such as file or URL not found.  App should catch and handle all errors. No stacktraces printed on console.
* The program should process the file line by line, or sentence by sentence. It must not try to read the entire file into a buffer (a String) and then process it.
* Checked code quality, but not in detail this time.  If there is no class Javadoc, then no score is awarded.

## The test files

All three files are in the class [docs](https://skeoop.github.io/docs/) folder.

EasyTest.txt - file containing only one sentence and simple punctuation.  But it has blank lines, which confused some apps.  
Alice-short.txt - short excerpt from Alice in Wonderland, with some punctuation simplified.  
Descartes.txt - excerpt from "Discourse" by philosopher Rene Descartes.   

The correct scores are shown at the bottom of the [PA4-Results](PA4-Results.pdf) file.
