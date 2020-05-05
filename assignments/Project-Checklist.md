## Checklist for Project

### Coding

- [ ] Uses Java naming convention?
- [ ] Every class has descriptive class Javadoc comment?
- [ ] Uses meaningful variable names?
    * Use correct plurality: `int totalWords` not `totalWord`, `List students` not `List student`.
- [ ] Meaningful method names?  
    * No abbreviations: `int countSyllables()` not `int countSyl()`.
- [ ] Code is correctly formatted?
    * Correct indentation and blank line between methods. 
- [ ] Exceptions handled and reported?
    * Take some action after an exception. 
    * No empty catch blocks: `catch (Exception e) { }`.
    * No printStackTrace() that then continues to execute the same method!
    * For GUI app, report errors in GUI.
- [ ] Use a Properties file for configuration data instead of embedded String constants.
    * No: `final String url = "https://someplace/covid19.csv"`
    * No: `final String password = "DontDoThis";`
    * See online write-up on how to use Properties.
- [ ] Run Checkstyle using `ku-checkstyle` rules to find code style problems.
- [ ] Have you reviewed all your code, line by line?

### Design and Implementation

- [ ] One class one responsibility?
- [ ] Each method does one thing?  Methods are not very long?
- [ ] OO design instead of static methods, where it is reasonable.
- [ ] Use polymorphism instead of if ... else if ... ?
    * You can use same code to read from a file or URL. The only part that differs is how you get an InputStream. OK to use if ... else for that small part.

### Documentation

- [ ] Has README file with Markdown formatted text?
- [ ] README includes high-level instructions how to compile and run? 
    * "High level" means you don't need to tell reader what commands to type. 
- [ ] README states external dependencies (extra libraries) that are required and where to get them (the original source).

### Repository

- [ ] Correct structure?  Source in `src/` directory, external jars in `lib/`.
- [ ] Has .gitignore?  
- [ ] **No** compiler output in repo?
- [ ] **No** huge files, such as MP3 or video. 
    * "Huge" means multi-megabytes. This makes it hard for others to clone.
- [ ] Has external Jars (other than JavaFX) needed by your project in top-level `lib/` directory. (**Not** `src/lib`)
    * The Jars should not be too large (many megabytes). Usually JARs are small.
    * If Jars are too large, instruct user to download them from external site.

### Correctness

- [ ] Project *runs* on someone else's computer?
- [ ] README file displays correctly when viewed on Github?
- [ ] Can Compile and run your code using instructions in your README file?
