## Can Two Windows Share the Same Controller?

Asked on StackExchange: https://stackoverflow.com/questions/30464857/one-controller-to-2-fxmls-javafx/30468662#30468662

The general answer is "*its a bad idea*" and can cause lots of problems.

However, this answer is interesting:

  Use the fx:root construct instead of fx:controller. It is explained in the Custom Components section of the FXML docs. I have used it in this example for my students if you want a bigger code example.
  
  Using this approach, creating views and controllers will be a lot easier and flexible. You will be able to share data between and connect controllers like you would any other objects in your application (for example: by passing data via the constructor or setter methods).
  
  If you're using SceneBuilder you'll simply need to remove the controller reference and check the box "Use fx:root". Then rework your code as shown in the examples.

Links he provides are:

* [JavaFX FXML Docs](https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/doc-files/introduction_to_fxml.html)
* [His Example](http://svanimpe.be/blog/ogly)

## Adding Controller and Model via Code

```
public class MyPane extends BorderPane {

    /*
     * Nodes that have an fx:id in the FXML document can be accessed from code. The name of the
     * attribute has to match the fx:id. The types have to match as well ofcourse. The @FXML
     * annotation gives the FXMLLoader access to an otherwise private attribute.
     */
    
    @FXML
    private AnchorPane oglyPane;
    @FXML
    private Slider headRadiusSlider;
    @FXML
    private Slider eyeRadiusSlider;
    @FXML
    private Slider pupilRadiusSlider;
    @FXML
    private Slider eyeSpacingSlider;
    @FXML
    private Slider eyeHeightSlider;
    
    /*
     * Keep a reference to the model, for easy access.
     */
    private final MyModel model;
    
    
    public MyPane(OglyModel m) {
        
        this.model = m;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ogly.fxml"));
        
        // Tell the loader that this object is the BorderPane we've designed in FXML.
        loader.setRoot(this);
        
        // Tell the loader that this is the object whose attributes 
		// and methods are referenced in FXML.
        loader.setController(this);
        
        // Load the FXML document. When this succeeds, 
		// the @FXML attributes will be ready to use.
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(
            MyPane.class.getName()).log(Level.SEVERE, "Unable to load xxxx.fxml", ex);
        }
        
        // Initialize other parts of application
        
        buildUI();
    }
```
