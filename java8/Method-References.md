## Method References

A method reference is a syntax for defining a reference to a single method.

Method references can be used in place of a class implementing an interface,
if the interface has only one abstract method (called a *functional interface*).

The syntax for a method reference is:

| Syntax  | What it refers to | Example         |
|:--------|:------------------|:----------------|
|Classname::methodName | a static method | Math::sqrt |
|objectref::methodName | an instance method of an object | this::toString |
|Classname::new        | a constructor | Person::new |

### Motivation

Many Java interfaces have only one method:

| Interface | Method with Signature     | What Uses It?    |
|:----------|:--------------------------|:-----------------|
| Runnable  | void run( )               | Thread.start(Runnable) |
| Comparator&lt;T&gt; | int compare(T a, T b) | Collections.sort(List,Comparator) |
| EventHandler&lt;E&gt; | void handle(E event) | Button.setOnAction(EventHandler) |
| Consumer&lt;T&gt;  | void accept(T arg) | collection.forEach(Consumer) |

In older versions of Java, the only way to use interfaces was to
write a class that implements the interface.

It would be nice if we could just pass a method to the code that requires
the interface, for example:
```java
// add event handler to a button
Button button = new Button("Press me");
button.setOnAction( handlePress );

public void handlePress(ActionEvent event) {...}
```
The button would simply call the handlePress method -- without the complexity
of writing a class just so we can define one method!

Java Method References lets us do something like this:
```java
Button button = new Button("Press me");
button.setOnAction( this::handlePress );
```

Any place that requires an interface, where the interface has **only one** 
abstract method (such as Runnable, EventHandler, Comparator) you can pass 
a method reference instead!

The only requirement is that the Method Reference should have a signature that is the same as or compatible with the method in the interface.

For example, `Consumer&lt;String&gt;` has a method `void accept(String s)`.
Instead of writing a class for a Consumer, we can use any of these methods:
```java
void save(String s) { writer.write(s); }  // writer is a Writer object

void print(Object o) { System.out.println(o); }

void showDialog(String msg) { 
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setHeaderText( msg );
     alert.showAndWait();
}
```
Even though the method names are not the same as in the interface (`accept`), the method signature matches, so they can be used as method reference in place of a Consumer.

The `print(Object o)` method works because it accepts any kind of Object, including String. 
```java
List words = Arrays.asList("method","reference","is","easy"};
// Use a method reference as Consumer:
list.forEach( this::save );
list.forEach( this::print );
list.forEach( this::showDialog );
```

### Example: Method Reference for Event Handlers

It is often convenient to write event handler methods for JavaFX applications as methods in the Controller class for a JavaFX scene.  
This is convenient because the controller has a reference to the components in the scene, and the event handler usually needs to refer to those components.

```java
public class LoginController {
    @FXML
    TextField loginField;
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

A **method reference** defines a reference to a method.  You can use it any place that expects a reference to something implementing the interface.
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


