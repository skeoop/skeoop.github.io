## Method References

A method reference is like a lambda that references an existing method.
The syntax for a method reference is:

| Syntax  | Meaning           | Example         |
|:--------|:------------------|:----------------|
|Classname::methodName | refers to a static methods | Math::sqrt |
|objectref::methodName | refers to an intance method of an object | this::toString |
|Classname::new        | refers to a constructor | Person::new |

### Example: Event Handlers

Its often convenient to write event handler methods for JavaFX applications in the controller class for a JavaFX scene.  Its convenient because the controller has a reference to other controls and nodes in the scene.

```java
public class LoginController {
    @FXML
    TextField loginField;
    @FXML
    PasswordField passwdField;
    @FXML
    Button loginButton;

    /** Handler for login event. */
    public handleLogin(ActionEvent event) {
        String username = loginField.getText();
        String password = passwdField.getText();
        if ( authenticate(username,password) ) ...

    }
```
To add `handleLogin` as Action Event handler for the loginButton, we can use a method reference:
```java
     @FXML
     public void initialize() {
         loginButton.setOnClick( this::handleLogin );
     }
```
The `setOnClick` method accepts a method reference `this::handleLogin` because the method signature matches the method in the *EventHandler&lt;ActionEvent&gt;* interface (it has a single parameter of type ActionEvent).

### Example: Consumer

Suppose we want a `Consumer` object that prints an object on System.out.
We can write:
```java
Consumer<Object> print = (x) -> System.out.println(x);
```

or use a method reference to do the same thing:
```java
Consumer<Object> print = System.out::println;
```

Whenever you see a Lambda that just calls another method and passes its parameter, you can usually rewrite it as a method reference:
```java
// compare strings ignoring case of letters
Comparator<String> comp = (a,b) -> a.compareToIgnoreCase(b);
```
is same as:
```java
// compare strings ignoring case of letters
Comparator<String> comp =  String::compareToIgnoreCase;
```
Because `compareToIgnoreCase` is an instance method, Java uses the first parameter (`a`) as the "this" String object.

