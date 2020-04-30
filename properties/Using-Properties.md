## Using Properties for Configuration Data

Many applications require settings or data values, such as:

* name and/or URL of a database
* URLs where to download Covid data
* URL and authorization key for a web service for currency exchange rates
* name of a Strategy to use in the Coin Purse
* logging level (how much detail to log)

An example is BlueJ.  Bluej stores user-specific settings 
in a **properties file** named `bluej.properties`.  
It is a plain text file containing data like this:

```
bluej.editor.tabsize=4
bluej.editor.fontsize=14
# Name of user for version control system like Git
bluej.teamsettings.user=fatalaijon
```

The format of this file is `key=value`. Lines beginning with `#` sign are comments which are ignored.  Many developers use "." in the property names to create a hierarchy of name and avoid name collisions.

Java has support for reading and writing Properties from a text file,
which is described here.

## Why Use Properties?

It is good programming practice to separate configuration data from code.
It makes the code easier to maintain (what if a URL changes?) and
more secure (usernames and passwords are not stored in code).

It also avoids inconsistencies in using string values in code.

## Java Properties

The java.util.Properties` class reads and writes properties using a text file containing key=value (like `bluej.properties`) or in XML format.

A Properties file can be located anywhere.  If you supply the properties file as part of your application then it should be located on your *application classpath*.  That means, inside your source code folder. 

If a properties file stores user-specific data (like `bluej.properties`) then it should be at a predictable place inside the user's name directory.  See the section on [System Properties](#system-properties) for how you can get the user's name from a System property.

To use Properties, you **load** them from an InputStream or Reader object:
```
Properties props = new Properties();
InputStream instream = new FileInputStream("myapp.properties");
props.load(instream);
```

## Java Properties Example

For the Purse we can use:
```
coinpurse/
    src/
        purse.properites
        coinpurse/
```
You can use any name for the file. By convention the extention should be either **.properties** or **.config**.

Inside the properties file, use lowercase names for properties.
We will define two properties:
```
# the capacity of purse
purse.capacity = 20
# the default withdraw strategy. Fully qualified class name.
purse.strategy = coinpurse.strategy.GreedyWithdraw
```

Somewhere in the Purse code, we open this file as a *classpath resource*
and use it create a Properties object:

```java
// this needs try - catch
InputStream input = this.getClass().getResourceAsStream("purse.properties");
Properties props = new Properties();
properties.load( input );

// get value of a property
String capacity = props.getProperty("purse.capacity");
// get value of a property or return a default value
String capacity = props.getProperty("purse.currency", "Baht");
```


## Property Manager

Handling properties is a **responsibility**.  Keeping the goal of "one class one responsiblity" (OCOR, kind of like OTOP), let's define a new class named `PropertyManager`:

```java
package coinpurse;
import java.io.*;
import java.util.Properties;

/**
 * Provide access to application properties.
 */
public class PropertyManager {
    private static final String PROPERTIES_FILE = "purse.properties";
    private Properties props = null;

	//TODO make this a Singleton
    public PropertyManager() {
		loadProperties(PROPERTIES_FILE);
    }

    /** load properties from file */
    private void loadProperties(String filename) {
        props = new Properties();
        InputStream instream = null;
        // find the file as application resource, using classpath
        ClassLoader loader = this.getClass().getClassLoader();
        instream = loader.getResourceAsStream(filename);
        if (instream == null) {
            System.err.println("Unable to open properties file "+filename);
            return;
        }

		// Load all the properties
        try {
            props.load(instream);
        } catch (IOException e) {
            System.err.println("Error reading properties file "+filename);
            System.err.println(e.getMessage());
        }

        // close input stream to free resources
        try {
            instream.close();
        } catch (IOException ioe) { /* should not happen */ }
    }

    /**
     * Get the value of a property.
     * @param name is the name of the property.
     * @return the property value or null if not found.
     */
    public String getProperty(String name) { 
		return props.getProperty(name);
	}

    /** Get a property, return a default value if the property is not defined */
	public String getOrDefault(String name, String defaultValue) {
		return props.getProperty(name, defaultValue);
	}
}
```

Test is using a method like this:
```
PropertyManager config = new PropertyManager();
System.out.println("capacity = " + config.getProperty("purse.capacity");
System.out.println("strategy = " + config.getProperty("purse.strategy"));
```

If your `purse.properties` is in the correct place (`src/` and copied by the IDE into `bin` or `out/production`) you should see the values printed.

### Improving the PropertyManager

There are two improvements we can make.  

First, we want **only one instance** of PropertyManager and many objects in our code need to access it.  Apply the [Singleton Pattern](#singleton-pattern):

```java
public class PropertyManager {
    private static PropertyManager instance;
    
    private PropertyManager() {
        loadProperties(PROPERTIES_FILE);
    }

    // TODO this code is not thread-safe. Use synchronous block for thread-safety
    public static PropertyManager getInstance() {
        if (instance == null) {
             instance = new PropertyManager();
        }
        return instance;
    }
}
```
Now, anyplace in the code where you need to get a property you can write:
```
String value = PropertyManager.getInstance().getProperty("purse.capacity");
```

A second improvement is to check for *two property files*. The first one
is the Purse app's own properties file, as in the code above.
Next, if the user has a `purse.properties` file in his home directory then
read that, too.  This way the user can override default properties values
with his own values.


## System Properties

The `System` class gives you access to system-level properties, such as the name of the logged in user, the user's home directory, the operating system, and version of Java!

The methods are:

| Method           | Description                  |
|:-----------------|:-----------------------------|
| Properties getProperties()  | Get all properties as a `Properties` object |
| String getProperty("key")   | Get one property. null if it doesn't exist |
| String getProperty("key","default") | Get a property, return a default if doesn't exist |

System also has a method to get *environment variables*:

| Method           | Description                  |
|:-----------------|:-----------------------------|
| getenv("variable")  | Get an environment variableoperties` object |

For example, to print some specific properties using Jshell:
```
> System.getProperty("user.home")
/home/fatalaijon
> System.getProperty("user.name")
fatalaijon
> System.getProperty("os.name")
Linux
```

To print all the properties on the console:
```
> Properties props = System.getProperties();
> props.list(System.out);
```

## ResourceBundle 

If your properties file is always a classpath resource, then a ResourceBundle requires less code than using Properties.  Simply supply the properties filename (without the `.properties` extension) to load values from a file:

```java
ResourceBundle rb = ResourceBundle.getBundle("purse");

// rb is a key-value Map, just like a Properties object
Set<String> keys = rb.keySet();
for(String key: keys) {
    System.out.println(key + " = " + rb.getString(key))
```

ResourceBundle is really intended for handling locale-specific values such as the Strings used in a user interface.  There are several subclasses including PropertyResourceBundle.

## Singleton Pattern

The Singleton Design Pattern is used when you want to ensure that there
is at most one instance of a class.  A Singleton provides a static accessor 
method to get the singleton instance, so the singleton can be easily shared 
by different parts of the application.

[Singleton Pattern on DZone](https://dzone.com/articles/singleton-in-java) shows how to write a thread-safe singleton using "double locking" and other ways to create a Singleton.

[OOP Slides on Singleton Pattern](https://skeoop.github.io/patterns/Singleton-Pattern.pdf)

