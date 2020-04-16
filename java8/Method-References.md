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
```
The method `handleLogin` *looks* like an event handler: it has the correct parameter and returns void, but it is not part of a class that "*implements EventHander*".

We can use `handleLogin` as an event handler by refering to it in a *method reference*:
```java
   loginButton.setOnAction( this::handleLogin );
```
The `setOnAction` method accepts a method reference `this::handleLogin` because the method signature matches the method in the *EventHandler&lt;ActionEvent&gt;* interface.

### Example: Write a Consumer

`Consumer` is an interface with one method:
```java
// T is a type parameter of Consumer
public void accept(T obj);
```
Consumer is used by many Streams methods.  Every `Collection` and `Iterable` has a **forEach(Consumer)** method which works like this:
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

Write a `Consumer` that prints one object on System.out.
We could do this using an *anonymous class* that implements Consumer:
```java
public void 
Consumer<String> print = new Consumer<String>() {
    public void accept(String x) {
        System.out.println( x ); 
    }
}

// print the fruit using forEach( Consumer )
fruit.forEach( print );
```

`Consumer` has **one method** that accepts a String.  The signature is:
```java
void xxxxxxxxxx(String s);
```

Notice that System.out.println has this signature:
```java
// In System.out:
void println(String s);
```

So we can use a **method reference** to refer to System.out.println as a Consumer:

```java
Consumer<String> print = System.out::println;
fruit.forEach( print );
```

The method reference is so short and clear, we can just do it in one statement
without loss of clarity:

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


