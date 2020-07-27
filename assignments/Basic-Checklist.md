## Checklist for Projects

If your project has incorrect name, uses incorrect package, or doesn't have Javadoc, it will not be graded.  You'll be told to resubmit, and incur a late penalty.

- [  ] Commit to repository name exactly as in assignment.
- [  ] Share project with TAs and instructor.
- [  ] Code is in the correct packages as stated on assignment, e.g. `ku.util` for Stack.
- [  ] Classes use the names stated on the assignment, with correct case of letters (Stack.java not stack.java).
- [  ] Classes compile without error using Java 7 compiler.
- [  ] Classes have _useful_ Javadoc comments for class and public methods.  Include `@author` and your name.

## Checklist for better score

- [  ] Test your own code.  Make sure it passes example cases or JUnit tests.
- [  ] Review your own code. Read it line by line.
- [  ] Run Checkstyle using ku-checkstyle rules.
 
## Other Good Practices

- [  ] Before committing project, create a `.gitignore` file to exclude .class and .jar files, except JARs in `dist` directory.
```
# a .gitignore for Java projects. You may have lots more stuff.
*.class
bin
build/classes
!dist
*.jar

# Ignore Eclipse files
.settings
.project
.classpath
```
