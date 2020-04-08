/**
 * Example of creating a JavaFX application in code.
 */
public class HelloFX extends javafx.application.Application {
    private TextField nameField;


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello Coder");
		// Create a container as root node in the Scene
		FlowPane root = new FlowPane();
		// Set appearance of container (spacing, alignment)
		root.setAlignment(Pos.CENTER);
		root.setHgap(10.0);
		root.setPadding(new Insets(10.0));
		root.setAlignment(Pos.CENTER);
		// Add components to the container
		Label prompt = new Label("Who are you?");
		nameField = new TextField();
		Button button = new Button("Greet Me");
		button.setOnAction( new ClickHandler() );

		root.getChildren().add(prompt);
		root.getChildren().add(nameField);
		root.getChildren().add(button);

		// Show the scene graph on the Stage
		primaryStage.setScene(new Scene(root));
		//primaryStage.sizeToScene();  // resize window to match Scene content
		primaryStage.show();
	}


	/** Show a dialog box with a message. */
	public void showDialog(String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Greetings");
		alert.setHeaderText( message );
		// wait for user to dismiss dialog
		alert.showAndWait();
	}

	/** Inner class to handle events. */
	class ClickHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String name = nameField.getText().trim();
			if (name.isEmpty()) {
				nameField.setPromptText("Please enter a name");
			}
			else showDialog("Hello, "+name);
		}
	}

}
