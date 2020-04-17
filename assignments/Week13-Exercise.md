Q1. This code encrypts a String:

```java
public char[] encrypt(String plaintext) {
    char[] ciphertext = new char[plaintext.length()];
    for(int k=0; k<plaintext.length(); k++) {
        char c = plaintext.charAt(k);
        ciphertext[k] = (char)mod(c+key, 65536);
    }
    return ciphertext;
}
```
we would like to be able to call this method using a parameter of type `String`, `StringBuilder`, or `StringBuffer`, using the same method.  What **type** can we use for the `encrypt` parameter (instead of String) so that it accepts `String`, `StringBuilder`, or `StringBuffer`?  

Look at the Java API for these 3 classes for either a superclass or interface that they have in common -- and it must be something that has the methods that the `encrypt` method is using.

Q2. Explain why the modified `encrypt` method can accept String, StringBuilder, and StringBuffer, and it still works.


```java
// add a Listener that is invoked whenever the
// value of the speedControl changes
speedControl.valueProperty().addListener( ? );
```
