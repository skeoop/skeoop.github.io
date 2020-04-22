## JavaFX

JavaFX is a framework for creating graphical applications in Java.
JavaFX was a part of the JDK until Java 11, when Oracle split it off.

### Install JavaFX or Not?

If you are using Java 8, 9, or 10 then JavaFX is included in the JDK.

If you are using Java 11 you need to download JavaFX from:

[https://gluonhq.com/products/javafx]() - download JavaFX 11 (LTS version) and the **documentation**.

### Define a Library for your IDE (Java 11+)

For Java 8-10, JavaFX is part of the JDK so you don't need to do anything.

These instructions are good. They show you how to define a "library" in the IDE, which is something you should know how to do.

[JavaFX and Eclipse](https://openjfx.io/openjfx-docs/#IDE-Eclipse) use the instructions for Non-modular projects.  Use JavaFX 11, not JavaFX 14.

[JavaFX and IntelliJ](https://openjfx.io/openjfx-docs/#IDE-Intellij) use the
instructions for Non-modular projects.  Use JavaFX 11. 

[JavaFX and Netbeans](https://openjfx.io/openjfx-docs/#IDE-Netbeans) use the instructions for Non-modular projects.
Some very good tutorials on the web:

## Learning JavaFX

[Getting Started](https://openjfx.io/openjfx-docs/) on [openjfx.io](https://openjfx.io/).

[JavaFX Tutorial at code.makery](https://code.makery.ch/library/javafx-tutorial/), 7-part series

[JavaFX and SceneBuilder Tutorial](https://www.vojtechruzicka.com/javafx-getting-started/) by Vojtech Ruzicka.

[openjfx.io](https://openjfx.io) the home for JavaFX information.  There are many impressive examples of what is possible.

[gluonhq.com](https://gluonhq.com) provides the reference implementation for JavaFX.


## Official JavaFX Tutorial (old but still accurate)

The [Online Tutorial][JavaFX Tutorial] by Oracle.

* JavaFX programming model: how a UI is constructed from objects
* UI Components, esp. [Controls](http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXUI336)
* [Layout](http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXLY) which are how you position components in a window
* [Handling Events](http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXED117)


## JavaFX and Modules

Java 9 added [modules][modules] to Java and divided the entire JDK into [modules][modules].  Modules help professional developers create smaller, more modular apps, but for learners that add some complexity. Modules are different from "packages".   You can see all the modules in the JDK by typing `java --list-modules`.

In your applications, don't use modules.  In Eclipse or IntelliJ, when you create a new project simply do not create the module info file.  Then Java will not crequire you to declare modules.

When compiling and running a JavaFX application, you may need to [add JavaFX modules][https://openjfx.io/openjfx-docs/#install-javafx] to the "Module Path".  This can be done inside your IDE (Eclipse, IntelliJ, ...) or on the command line.  

MacOS/Linux:
```
export JAVAFX_HOME=/path/to/javafx/lib
javac --module-path $JAVAFX_HOME --add-modules javafx.controls,javafx.fxml HelloWorld.java
# Run the application
java --module-path $JAVAFX_HOME --add-modules javafx.controls,javafx.fxml HelloWorld
```

Windows:
```
set JAVAFX_HOME="\path\to\javafx\lib"
javac --module-path %JAVAFX_HOME --add-modules javafx.controls,javafx.fxml HelloWorld.java
# Run the application
java --module-path %JAVAFX_HOME --add-modules javafx.controls,javafx.fxml HelloWorld
```

### Shortcut for Command Line Options

Save typing by putting command line options in a file.  Here is how.

1. In your project root directory create a file. I used the name `jvmopts` but any name will work.  Put the `java` command line args in it:
   ```
   --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml 
   ```
2. When you invoke Java use the `@filename` notation to refer to the file:
   ```
   java @jvmopts HelloWorld
   ```


## Using FXML

Instead of writing Java code to create a UI, you can define the layout
(declaratively) in a file. In JavaFX, this is an FXML file -- a kind of XML.
Android and Windows .Net Framework also use XML files for UI layout.

You don't need to know the syntax of FXML!  
Use **SceneBuilder** graphical UI edtor to create FXML and set component properties.

### Connecting FXML components to Code: the Controller Class

JavaFX will create the UI from an FXML file, including all the components (Buttons, Panes, TextField, etc).  But your code needs to **reference** those objects so you can get values and handle events.

There are 3 parts to doing this:
* create a **Controller** class. In this class you define variables for the components from FXML that you want to access.
* annotate those variables with `@FXML`.  But do not create objects!
* using SceneBuilder, specify the Controller class and add an **id** to each component that relates to a variable in the Controller

Then JavaFX will take care of making your Controller variables refer to the components created from the FXML file.

Follow these steps.

1. For each UI component (created from FXML) you want to reference in the controller, define an attribute with an `@FXML` annotation:
   ```java
   public class GreeterController {
        @FXML
        Button submitButton;
        @FXML
        TextField inputField;
   ```
2. In the FXML file (using SceneBuilder) set the `fx:id` of the component to the field name in your Controller class (`submitButton` or `inputField`).  
   * Be careful that the names match exactly!
   * If names don't match, you won't get an error from compiler, but may get a run-time error.

### Defining Event Handlers

to be added.

## Example Application Launcher -- for UI defined in code

Your "main" or "application" class should extend `javafx.application.Application`.
```java
public class Demo extends Application {
	// Declare components that your app needs a reference to
	// Not necessary to declare every component as an attribute! 

	/**
	 * @param stage is the primary stage (a Window)
	 */
	public void start(Stage stage) {
		
		// 1. create components and layouts (Panes) for the application
		Label Label = new Label("Hello, Nerd");
		inputField = new TextField( );
		FlowPane pane = new FlowPane(label, nameField);

        // add components to the root node (container)
        pane.getChildren.addAll( label, inputField );

		// 2. create a Scene to show your pane and components
		//    The top level (root) element should be a subclass of Parent
		Scene scene = new Scene(pane);
		
		// 3. add the scene to the stage (Window)
		stage.setScene(scene);

		// 4. set properties of the window
		stage.setTitle("Components Demo");

		// 5. show the window
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
```

## Example Application Launcher -- for UI defined in FXML

In this case, you create the "Scene" by loading the FXML file.
Here's an example for a scene defined in file `GreeterUI.fxml`.

```java
public class MyApp extends Application {
    // Name of the FXML file containing scene.
    // Include the package as the path! (example: org.ske.greeter)
    String FXML_FILE = "org/ske/greeter/GreeterUI.fxml";

	/**
	 * @param stage the primary "stage" for showing the scene.
	 */
	@Override
	public void start(Stage stage) {
        // 1. Create a Scene from FXML
		Parent parent;
        try {
            parent = FXMLLoader.load(
                    this.getClass().getClassLoader().getResource(FXML_FILE) );
        } catch (IOException ex) {
            // Log the error and quit
            Logger.getLogger("MyApp").log(Level.SEVERE, null, ex);
            return;
        }
        Scene scene = new Scene(parent);

        // 2. Load the scene into stage (window)
        stage.setScene(scene);
        stage.setTitle("Greeter");
        // Resize the stage so the size matches the scene
        stage.sizeToScene();
        // 3. show the window
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
```

## Be Careful of Imports!

JavaFX classes are in packages beginning with `javafx.`, such as `javafx.scene.control`.  Many JavaFX classes have the **same name** as a class in `java.awt` or `javax.swing`.  If you import the wrong class, your application won't work! If you are *lucky*, it won't compile, too.

| Package          | Meaning                           |
|:-----------------|-----------------------------------|
| javafx           | Top package for JavaFX framework  |
| javafx.event     | JavaFX event classes              |
| javafx.scene.control | JavaFX controls, e.g. Button  |
| javafx.scene.layout  | FlowPane, GridPane, other layouts |
| javafx.application   | The Application class         |

### Beware of Imports from AWT and Swing Toolkits

Usually you **do not want** classes from these packages, so if you see them imported into your JavaFX application, check to see if you are using the correct class or component.

For example, if your app has:
```java
import java.awt.Button;
import java.awt.Label;
```

then you **should** use:
```java
import javafx.scene.control.Button;
import javafx.scene.control.Label;
```

| Package          | Meaning                           |
|:-----------------|-----------------------------------|
| java.awt         | Top package for AWT classes       |
| java.awt.event   | AWT event classes                 |
| javax.swing      | Top package for Swing classes     |
| javax.swing.event | Swing event classes              |

## Creating a UI with SceneBuilder

SceneBuilder is a stand-alone app, but it integrates with Java projects in Eclipse, Netbeans, and IntelliJ. You can use SceneBuilder to create a graphical interface for desktop and mobile applications.

## Getting SceneBuilder

### SceneBuilder

[https://gluonhq.com/products/scene-builder]() - download SceneBuilder for your version of Java (Java 11 or Java 8).

* The SceneBuilder 8.4.1 JAR download is 9.8MB, but contains only the Java program (as a JAR). 
* The Windows 64-bit installer is 51MB and the Debian/Ubuntu package is 57MB. They are big because they include the Java Runtime (JRE).

### IDE Integration for SceneBuilder

To create a JavaFX user interface with your IDE, the only tool you need is SceneBuilder -- you don't need to install IDE plugins in Eclipse or Netbeans.  The plugins provide extra functionality, but not required.

* Eclipse: Select Window -> Preferences -> JavaFX and specify the location of the SceneBuilder JAR.
* Netbeans: Select Tools -> Options -> Java (from top) -> JavaFX tab and choose the SceneBuilder directory.  If you downloaded only the SceneBuilder JAR, Netbeans will complain that location is invalid.  (So use a package.)
* IntelliJ:

### Eclipse Plugins (Two Choices)

* [E(fx)clipse](http://projects.eclipse.org/projects/technology.efxclipse) is an Eclipse project.  This plugin is **huge**, requiring many packages.  Use a good Internet connection.
    * **Install** within Eclipse using Help->Install New Software. Select the Eclipse update site or use the E(fx)clipse update site for latest version.
* [Gluon Plugin](https://marketplace.eclipse.org/content/gluon-plugin) for Oxygen, Neon, and Mars Eclipse releases. Gluon is the developer of SceneBuilder. 
    * **Install** Gluon plugin within Eclipse using Help->Marketplace and search for Gluon.

Gluon.com [IDE Plugins](http://gluonhq.com/get-started/ide-plugins/) page describes the SceneBuilder integrations (extensions) for Eclipse, Netbeans, and IntelliJ.

* Netbeans plugin is called "Gluon Plugin". Install it using Netbeans: Tools -> Plugins, select "Available Plugins" tab and search for Gluon Plugin.  This plugin also install Gradle and Groovy plugins.  Gradle is a dependency management system and tends to download lots of libraries to a local cache.
* IntelliJ install plugin from within IntelliJ. Use File -> Settings -> PLugins and search for "Gluon Plugin". Gluon.com has [step-by-step instructions](http://docs.gluonhq.com/mobile/latest/#intellij-plugin).


## How to Access a Controller class?

The FXMLLoader has access:

```java
    FXMLLoader fxmlLoader = new FXMLLoader();
    Pane p = fxmlLoader.load(getClass().getResource("foo.fxml").openStream());
    FooController fooController = (FooController) fxmlLoader.getController();
```

another solution:

//Static global variable for the controller (where MyController is the name of your controller class
static MyController myControllerHandle;

In the Main class for your application, change the static FXMLLoader.load
to the instance version (as shown below).  Then use the loader to access
the controller.

```java
@Override
public void start(Stage stage) throws Exception {
    //Set up instance instead of using static load() method
    FXMLLoader loader = new FXMLLoader(getClass().getResource("foo.fxml"));
    Parent root = loader.load();

    //Now we have access to getController() through the instance...
    myControllerHandle = (MyController)loader.getController();

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
}
```



## How to Resize Container to Fit Components

In Swing, you can use `pack()` to resize a container to fit its components.  You use this on the top-level container (e.g. JFrame):
```
class MyUI extends JFrame {
    
    private void initComponents() {
        JButton button = new JButton("Press me");
        JLabel label = new JLabel("Just do it");
        this.add(button);
        this.add(label);
        // resize everything to fit contents
        this.pack();
    }
}
```
To do this in JavaFX, call `stage.sizeToScene()`. 
But not clear if it will recursively resize contents the way Swing does.



## References

[Gluon]: http://gluonhq.com    
[SceneBuilder Download]: http://gluonhq.com/products/scene-builder/
[JavaFX Tutorial]: https://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[modules]: https://www.oracle.com/corporate/features/understanding-java-9-modules.html


