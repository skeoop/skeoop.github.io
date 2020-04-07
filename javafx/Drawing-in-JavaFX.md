
## Drawing Text on a Canvas

The a `Text` object, if you want to modify the text.
```java
Text text = new Text();
// can't directly add to canvas, so add to a Pane
// Suggestion: create a Pane that is same size as
// the canvas and put Canvas in that Pane.
rootPane.getChildren().add(text);
text.setX(10);
text.setY(20);
text.setText("Hello");
```

## Drawing Images

You can draw an image on any component using its
GraphicsContext.  This example is for a Canvas.
```
// The filename is relative to the CLASSPATH
Image image = new Image("images/fish.png");
GraphicsContext gc = canvas.getGraphicsContext2D();
double x = canvas.getWidth()/2.0:
double y = canvas.getHeight()/2.0;
gc.drawImage( image, x, y);
```

## Drawing Shapes

* [JavaFX Shapes](https://www.tutorialspoint.com/javafx/javafx_2d_shapes.htm) on TutorialsPoint.
