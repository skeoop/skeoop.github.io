## Using VS Code for Java

You should read these two articles

[Visual Studio Code for Java: The Ultimate Guide](https://blog.usejournal.com/visual-studio-code-for-java-the-ultimate-guide-2019-8de7d2b59902)

[Java in Visual Studio Code](https://code.visualstudio.com/docs/languages/java?WT.mc_id=medium-blog-brborges) by VS Code team.  The official documentation.


## Extensions

1. Java Extension Pack by Microsoft.  Contains these extensions:
   * Language Support for Java, by Redhat - the most important one
   * Debugger for Java, by Microsoft
   * Java Dependency Viewer, by Microsoft lets you add dependencies (JAR files) and view them in your project
   * Maven for Java, by Microsoft - support for Maven project management tool
2. Java Test Runner, by Microsoft. For easily running JUnit tests in VS Code.
3. Visual Studio IntelliCode. Allows smart editing and completion assistance.

Maybe: 
* GitLens improves interface to Git, such as seeing differences between versions of a file.  VS Code includes Git support even without this extension.
* Checkstyle integrates the well-kwown Java style checking program checkstyle into VS Code.

## The Right Way to Create a Project?  Who Knows?

If you start a Java project just by creating a folder or opening some existing code in VS Code, it may not provide a good project structure.  Most IDE (such as Eclipse) will structure your project like this:
```
myproject/
   src/
      Main.java  (a class in default package)
      logo.png
      util/
          ArrayUtil.java  (a class in util package)

   bin/                   (project output goes in bin)
      Main.class
      logo.png            (non-Java source resources are copied, too)
      util/
          ArrayUtil.class 
```

To get VS Code to create a project with this structure use **Shift-Ctrl-P**
or **Shift-Cmd-P** and enter: **Java: Create Java Project**.

It will ask you to choose a folder for the project, which can be an existing folder (e.g. if you have starter code from Git).

It also creates the standard Eclipse project files `.settings/`, `.classpath`, and `.project`.  However, in this case it does not put the usual project info in `.vscode/setting.json`.

