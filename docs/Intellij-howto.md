## IntelliJ Settings

When you start IntelliJ with no projects open, IntelliJ displays a Welcome Screen.  On the bottom of the screen is a "Configure" menu with drop-down menu.  This menu has many useful settings.

### File -> Settings

* **Build, Execution, Deployment** - **Compiler** - **Java Compiler**.  You can choose Javac (JDK javac command) or the Eclipse compiler!  Eclipse has a very good incremental Java compiler.  You can also set the Project bytecode version. (Better to set this in a specific project.)
* **Languages & Frameworks** - can set path to SceneBuilder for JavaFX.

### Other Settings -> Project Defaults -> Project Structure

* Compiler Output: you can change "out" (default) to some other dir, but IntelliJ always creates subdirs named Production/module-name and Test/module-name (module-name means the project name).


### Use Tabs, Not Space

1. Open Settings (Welcome Dialog or File -> Settings)
2. Select Editor -> Code Style -> Java
```
   [x] Use tab character
       [?] Smart tabs - try it. Automatically adds correct number of tabs
   Tab size:  4
   Continuation indent: 8
   [ ] Keep indent on empty lines (DON'T select this)
```

### More Code Formatting

Also in `Editor -> Code Style -> Java`, look at the **Spaces**, **Wrapping**, **Javadoc**, and **Imports** tabs.  Many useful settings to know.  Many ways to customize code formatting.

Be careful of `import package.*` setting.  In IntelliJ the default is:
```
  Class count to use import with "*":  5
```

this means if you import 5 or more classes from one package, IntelliJ will replace individual imports with `import packagename.*`.  In Eclipse the default is 99.  I use a default of 10.

For example:
```java
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;
```
IntelliJ would rewrite the imports as:
```java
impport java.util.*;
```


