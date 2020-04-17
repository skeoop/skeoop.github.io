## Method References

A method reference is a syntax for defining a reference to a single method.

Method references can be used in place of a class implementing an interface,
if the interface has only one abstract method (called a *functional interface*).

The syntax for a method reference is:

| Syntax  | What it refers to | Example         |
|:--------|:------------------|:----------------|
|Classname::methodName | a static methods | Math::sqrt |
|objectref::methodName | an instance method of an object | this::toString |
|Classname::new        | a constructor | Person::new |

### Example: Method Reference for Event Handlers

It is often convenient to write event handler methods for JavaFX applications as methods in the Controller class for a JavaFX scene.  
This is convenient because the controller has a reference to the components in the scene, and the event handler usually needs to refer to those components.

```java
public class LoginController {
    @FXML
    TextField loginField;
    @FXML
    PasswordField passwdField;
    @FXML
    Button loginButton;

    /** Handler for login event. */
    public void handleLogin(ActionEvent event) {
        String username = loginField.getText();
        String password = passwdField.getText();
        if ( authenticate(username,password) ) ...
    }

    loginButton.setOnAction( this::handleLogin );

```
The method `handleLogin` *looks* like an event handler -- it has the correct parameter and returns void, but it is not part of a class that "*implements EventHander*".

A **method reference** defines a reference to a method.  You can use it in places that expect a reference to something providing the interface.
For example, we can write:
```java
    EventHandler<ActionEvent> handler = this::handleLogin;
    loginButton.setOnAction( handler );
```

since it pretty clear what the intention is, you can just use the method reference directly to set the event handler:
```java
    loginButton.setOnAction( this::handleLogin );
```

The `setOnAction` method accepts a method reference `this::handleLogin` because the method signature matches the method signature in the *EventHandler&lt;ActionEvent&gt;* interface.

### Weird Use of Method Reference

`void System.out.println(Object)` has a compatible signature with `EventHandler.handle(Event)`, because System.out.println can accept any `Event` object. So we could print all the events on System.out by writing:
```java
    loginButton.setOnAction( System.out::println );
```


### Example: Write a Consumer

`java.util.function.Consumer` is an interface with one method:

```java
// T is a type parameter of Consumer
public void accept(T obj);
```
Consumer is used by many Streams methods when they want a method to "consume" an object.
Every `Collection` and `Iterable` has a **forEach(Consumer)** method which works like this:
```java
collection<T>.forEach( Consumer<T> consumer )
```

This is a short-cut for a "for-each" loop over elements in the Collection!    
Its the same as writing:
```java
for(T item: collection) {
    consumer.accept( item );
}
```

### forEach Example: print elements of a List

The old way of printing element in a list is using a loop:

```java
List<String> fruit = List.of("Apple", "Orange", "Grape",...);
for(String s: fruit) {
    System.out.println( s );
}
```
Let's change that to a `fruit.forEach()` statement.

`Consumer` has **one method** that accepts a type (T).  The signature is:
```java
void accept(T s);
```

Since `fruit` is a list of String, this will be `void accept(String s)`.

Notice that System.out.println (which is overloaded) also has this signature:
```java
// In System.out:
void println(String s);
```

So we can use a **method reference** to refer to System.out.println as a Consumer:

```java
Consumer<String> print = System.out::println;
fruit.forEach( print );
```

The method reference is short and clear, so let's simplify without lose of clarity:

```java
fruit.forEach( System.out::println );
```

### When To Use a Method Reference

Whenever you see a Lambda or Anonymous Class that just calls another method and passes its own parameter to that method, you can usually rewrite it as a method reference:
```java
// compare strings ignoring case of letters
Comparator<String> comp = (a,b) -> a.compareToIgnoreCase(b);
```

is same as:

```java
// compare strings ignoring case of letters
Comparator<String> comp =  String::compareToIgnoreCase;
```

Because `compareToIgnoreCase` is an instance method, Java uses the first parameter (`a`) as the "this" object when it invokes `compareToIgnoreCase`.


