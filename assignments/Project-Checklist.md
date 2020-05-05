## Checklist for Project

Coding

- [ ] Uses Java naming convention?
- [ ] Every class has explanatory Javadoc?
- [ ] Uses meaningful variable names?
    * Use correct plurality: `int totalWords` not `totalWord`, `List students` not `List student`.
- [ ] Meaningful method names?  No abbreviations?
- [ ] Code is correctly formatted?
- [ ] Exceptions handled and reported?
    * Should take reasonable action after exception. 
    * No printStackTrace() that then continues to execute more code!
    * For GUI app, report error in GUI. Don't just exit to console!
    * No empty catch blocks:  `catch (Exception e) {}`.
- [ ] No embedded String constants for configuration values.
    * No: `final String url = https://someplace/covid19.csv`
    * No: `final String password = "dontdothis";`
    * Use a Properties file for configuration data

Design

- [ ] One class one responsibility?
- [ ] OO design instead of static methods, where it is reasonable.

Documentation

- [ ] Has README file with well-formatted text?
- [ ] README includes high-level instructions how to compile and run? 
    * "High level" means you don't need to tell reader what commands to type. 
    * Should state dependencies (extra libraries) that are required and where someone can get them.
    * If dependency JARs not too large, include them in a directory named `lib/`

Repository

- [ ] Correct structure?  Source in `src/` directory, external jars in `lib/`.
- [ ] Has .gitignore?  **No** compiler output?
- [ ] **No** huge files, such as MP3 or video. "Huge" means multi-megabytes. This makes it hard for others to clone.


## Checklist for better score

- [ ] Project *runs* on someone else's computer?
- [ ] Compile and Test your code using instructions from your README file.
- [ ] Review all your code.  Read it line by line.
- [ ] Run Checkstyle using ku-checkstyle rules to find poor code.
 
