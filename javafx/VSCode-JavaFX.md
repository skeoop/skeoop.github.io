## Using JavaFX in VS Code

To create a JavaFX project in VS Code, you need to add the JavaFX JAR files to the project.

This is an issue for any Java project that uses libraries, not just JavaFX.

You need to add the JavaFX JAR files to each project where you use JavaFX.
In Eclipse and IntelliJ you can define a Library once and then just refer to in your projects -- seems that VS Code does not have this.

### Adding Dependencies (JAR files)

1. Use Java Dependency Viewer (VS Code extension) - at the bottom of the project pane is a section named "JAVA DEPENDENCIES".  Open this and you should see an item labeled "Referenced Libraries".  Expand that item and look for the JavaFX jar files.  It should look like:

```
JAVA DEPENDENCIES
  v Referenced Libraries
    javafx.base.jar
    javafx.controls.jar
    javafx.fxml.jar
    javafx.graphics.jar
    javafx.media.jar
    javafx.swing.jar   (you probably don't need this)
    javafx-swt.jar     (you probably don't need this)
    javafx.web.jar
```

2. If you don't see these dependencies, click the "+" sign on the "Referenced Libraries" line.  Then select the "lib" directory where you installed JavaFX, such as `/Library/javafx11/lib`.   Then refresh the dependencies list (you may need to close and re-expand the item).  It should show the javafx jar files.

3. Edit the project `settings.json` file in the `.vscode` directory.  This is an alternative way to add dependencies.  You can directly edit it like this:
```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar",
        "/path/to/javafx11/lib/**/*.jar"
    ]
}
```

## Running a JavaFX Application

After you compile a JavaFX application in VS Code, you still have more pain to run it.

If you enter (on Windows use ";" instead of ":" in classpath):
```
# assumes you application main class is named Main

java -cp /path/to/javafx11/lib/*:. Main
```
Java prints:
```
Error: JavaFX runtime components are missing, and are required to run this application
```

the message isn't very helpful.  JavaFX 11 uses "modules" to define access to packages and classes.  You need to add options to the `java` command like this:
```
java --module-path /opt/java/javafx11/lib --add-modules javafx.base,javafx.controls  HelloFX
```
It appears that when you use modules you don't need to add them as the classpath elements.



