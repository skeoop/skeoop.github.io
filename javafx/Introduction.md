## Learn JavaFX

Read the [Online Tutorial][JavaFX Tutorial].

To get started, the important parts to understand are:

* JavaFX programming model: how a UI is constructed from objects
* UI Components, esp. [Controls](http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXUI336)
* [Layout](http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXLY) which are how you position components in a window
* [Handling Events](http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXED117)
* Know how to launch an application. Example given below.


## Using FXML

Instead of writing code to create a UI, you can often define the layout
(declaratively) in a file. In JavaFX, this is an FXML file -- a kind of XML.
Android and Windows .Net Framework also use XML files for layout.

You don't need to know the syntax of FXML!  Use **SceneBuilder** graphical UI edtor to create FXML and set component properties.

### Connecting FXML components to Code: the Controller Class

To access components and get events, you need to connect your visual UI (in FXML) with Java code.  You do this by defining a *Controller* class for each FXML file.  
You can specify the controller class in SceneBuilder.

Then follow these steps.

1. For each component you need to reference in the controller, define an attribute with an `@FXML` annotation:
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
    Strint FXML_FILE = "org/ske/greeter/GreeterUI.fxml";

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
| java.awt         | Top package for AWT classes       |
| java.awt.event   | AWT event classes                 |
| javax.swing      | Top package for Swing classes     |
| javax.swing.event | Swing event classes              |
| javafx           | Top package for JavaFX framework  |
| javafx.event     | JavaFX event classes              |
| javafx.scene.control | JavaFX controls, e.g. Button  |



## Creating a UI with SceneBuilder

SceneBuilder is a stand-alone app, but it integrates with Java projects in Eclipse, Netbeans, and IntelliJ. You can use SceneBuilder to create a graphical interface for desktop and mobile applications.

## Getting SceneBuilder

The current version of SceneBuilder is distributed by [Gluon][Gluon].  The Download URL is [SceneBuilder Download].  You should use this instead of Oracle's *old* SceneBuilder 2. 

* The SceneBuilder 8.4.1 JAR download is 9.8MB, but contains only the Java program (as a JAR). 
* The Windows 64-bit installer is 51MB and the Debian/Ubuntu package is 57MB. They are big because they include the Java Runtime (JRE).

### IDE Integration for SceneBuilder

To create a JavaFX user interface with your IDE, the only tool you need is SceneBuilder -- you don't need to install IDE plugins in Eclipse or Netbeans.  The plugins provide extra functionality, but not required.

* Eclipse: Select Window -> Preferences -> JavaFX and specify the location of the SceneBuilder JAR.
* Netbeans: Select Tools -> Options -> Java (from top) -> JavaFX tab and choose the SceneBuilder directory.  If you downloaded only the SceneBuilder JAR, Netbeans will complain that location is invalid.  (So use a package.)

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

# How to Access a Controller class?

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
To do this in JavaFX, call `stage.sizeToScene()`.  But not clear if it will recursively resize contents the way Swing does.



## References

* [Gluon]: http://gluonhq.com    
* [SceneBuilder Download]: http://gluonhq.com/products/scene-builder/
* [JavaFX Tutorial]: https://docs.oracle.com/javase/8/javase-clienttechnologies.htm

