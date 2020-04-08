## Configure JavaFX and SceneBuilder in IntelliJ


https://www.jetbrains.com/help/idea/opening-fxml-files-in-javafx-scene-builder.html

## Adding JavaFX Modules to Runtime Options

Java 9 added the concept of "modules".  

JavaFX 11 uses modules, and you have to tell the JavaVM that it
should allow your application access to some "modules" in JavaFX.

In IntelliJ do:

1. From the **Run** menu select **Edit Configuration...**.

2. For your application, edit the **VM Options** field and set:
```
--module-path /path/to/javafx/lib/ --add-modules javafx.controls,javafx.fxml
```

It is really ridiculous that we have to do this for every application!

Oracle is killing off Java as a platform by increasing the complexity.
