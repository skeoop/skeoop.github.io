## Project Reviews for 2018 OOP Projects

Project scores are in the "Scores" tab of the Google Docs spreadsheet for projects.   [Google Projects Spreadsheet](https://docs.google.com/spreadsheets/d/11-joJYZuYxOrpMTxqrV3P-CTy2bUFd_qV4MTmMRj4Mc/edit#gid=1983300632)

Below is feedback and suggestions from instructor and TAs.

The projects that used JDBC directly mostly used
some really bad coding for JDBC.
Looks like students all copied the same bad ideas, instead of using ORM,
Properties, and the things you learned in the course.

## 2048 Game

Application is well done, but some deficiencies in code.

Package names: AI, LIB, MODEL, Main, SERVER, UI, application are inconsistent naming.

**Libraries are misplaced:** there is a top-level `libs` directory but some required
library is in `src/LIB`.  The standard location is a top-level `lib/` directory (no "s").

Documentation is good but very little explanation of *how* you
used design patterns or *how* the AI part works.  No installation or build
instructions.



## Air Hockey

Interesting game using C# and Unity. Created separate executable for Windows,
Linux, and Mac: very nice.  App creates an online list of high scores using DreamLo service.

Online doc needs improvement.  Doesn't explain about design
or how you used OO and technology.  The brief bullet items are insufficient.
No build instructions or list of dependencies.


## Call Me Bus

Application idea and implementation are OK, but some parts are unrealistic.
User can't see ticket price until clicks "Book ticket", and in my test it
adds a huge 800 Bt "Additional Cost" on to a 200 Bt ticket.  This would
never be acceptable.

It does have "Cancel" button and navigation buttons (Home, Exit).

All classes are in the default package (discouraged).  
Lots of coupling between classes and JDBC, and using raw SQL with user-input values, which is vulnerable to SQL injection.  Better to use ORM with ORMlite or JPA.

JDBC username, password, URL, and driver class (specifying the driver class is not necessary) are
hardcoded into Jdbc_Manage class.  The code related to JDBC needs improvement.

Online docs need improvement. Its mostly a bunch of screen shots of the game.
Doesn't explain about design, interesting technology, or *how* you applied OO.
Since you are using database with MySQL 
your documentation should say what is required and how to create the schema.

The code requires MySQL JDBC driver and iText JAR but these are not included
in repository and no mention of these requirements in the documentation.
You should document external dependencies and where someone can get them.

Passwords are stored in **plain text** in file passwords.properties, but no
associated username.  All passwords are stored in a list (but no usernames),
so any user can login with any password.

## Candy game

App cannot be run unless database and tables already exist, and the application silently
discards exceptions thrown from ORMLite about this. 
It hangs indefinitely when I try to create a user.
The app hardcodes MySQL URL in code, so no way a user can run it by creating his own database.

I changed database to h2 and added h2.jar to classpath, and eliminated hardcoded user/password, but project still doesn't work because it doesn't initialize tables. ORMLite can do this for you!

MySQL driver JAR is in src/sql.  It should be in top level `lib/` directory and add lib to classpath.
Typing error in style "teansparent" should be "transparent". 
This prints many messages on the console, so why didn't you fix it?
This shows the team didn't test their code much.

Good points are the use of ORM and ORMLite.  Design needs improvement `DataTable` is actually user data, and it looks like it stores passwords in plain text. Should **always** encrypt passwords before storig them (see jBCrypt on class homepage) -- never store passwords in plain text.

Online docs list dependencies but no explanation of design or *how* you used 
design patterns or technology.  Just listing pattern names is not helpful.

Reference to MySQL connector should refer to MySQL download site, not someone else's Github repo.

## Checker Game

Game doesn't implement all the rules of checkers. a) can't jump multiple pieces, b) no sacrifice (lose a
piece because you didn't jump an opponent piece when it was possible).  
Since the app is not that complex, 
I think you should implement all the rules of the game.

Documentation is OK but no explanation of technology or how you did it.

## Clicker Game

Game source is hard to clone due to many large MP3 files.
The runnable JAR file is 92.5MB.  Better to remove or compress some music.  Or store music files outside the repo and download them on first use.

Inconsistent package naming: Alert, Register, application, monsterANDmoney, picture, uiANDcontroller, unitANDhero.  Inconsistent class naming: `htwUIcontroller.java`. Use the Java naming convention.

Database name, URL, and location hardcoded in Java code.  Schema creation "CREATE TABLE ..." also
hardcoded in Java.  getMember() has a lot of unused assignments.

SQLite.jar is buried down in src/Register/.  Should be in a `lib/ directory, as done in examples.

Nice features: saves game on exit, has Javadoc in code.

Register class silently ignores SQLExceptions.  Many empty catch blocks like:
```
try {
    // do something
} catch (SQLException e) {

}
```
and doesn't bother to close statements at end of methods, so may have resource leaks.


README is OK but would be better if you explained more about *how* you used technology.
App requires SQLite, but you don't document it or list as dependency.

## Deadshot

Project gets a low score due to (a) lots of code copied from RealTutsGML or the web site https://codingmakesimple.com, and (b) poor code that isn't OO style programming.  Low score for Executable because JAR throws exception due to image files not found, even though I notified the team about wrong case for image names.

Not much work by Napasai.  Most of his 22 commits were updates to README.md,
and all of them between May 8-14.  2,773 lines written by Dechabol, 347 by Napasai
and a large part of Napasai contribs are to README.md.

Several parts of the code are very similar to the game created in RealTutGML Youtube tutorial videos.  See:

* https://www.youtube.com/user/RealTutsGML/featured
* https://github.com/danielmacho72/spacegame based on RealTutGML
* https://github.com/MHase/Game based on RealTutGML

Classes in common:

* GameObject- renamed `tick` method to `update` but many other methods identical
* Game
* Handler - many identical methods, even variable names are same
* ObjectId (same as ID enum) - weird enum syntax (enum members `Player()`, `Block()` instead of `Player`, `Block`) shows its a copy.
* Player1 and Player2 are similar to Player class on RealTutGML.  See below, also.

Design Issues:

1. `Player1` and `Player2` contain nearly identical code. Only difference is (a) they uselessly rename some variables, (b) some arrays have subscript [0] in Player1 and subscript [1] in Player2.   These should just have been 2 instances of the same `Player` class. (Not OO-style and redundant code.)

2. Lots of static code that should in instance code.

3. Directly assessing public variables from other objects or classes (as in example below) instead of correctly encapsulating responsibilities.

4. Not using OO or polymorphism.  For example, in Player1.render() they have
(I corrected the bad indentation in their code for readability):
```java
if (LevelController.player1Character.equals("hunter")) {
	if (KeyInput.checkFacing1 == -1) {
		g.drawImage(texture.bowMaster[0], (int) x, (int) y, 50, 90, null);

		} else {
			g.drawImage(texture.bowMaster[1], (int) x, (int) y, 50, 90, null);
		}
	}
		
	if (LevelController.player1Character.equals("wizard")) {
		if (KeyInput.checkFacing1 == -1) {
			g.drawImage(texture.wizard[0], (int) x, (int) y, 50, 90, null);
		} else {
			g.drawImage(texture.wizard[1], (int) x, (int) y, 50, 90, null);
		}
	}
	if (LevelController.player1Character.equals("assassin")) {
		if (KeyInput.checkFacing1 == -1) {
			g.drawImage(texture.assassin[0], (int) x, (int) y, 60, 90, null);
		} else  {
			g.drawImage(texture.assassin[1], (int) x, (int) y, 60, 90, null);
		}
	}
```
All the "if" statements are unnecessary. If a Player itself knew whether it
was a a hunter, wizard, or assassin then this cluggy code isn't necessary.
Plus using public static attributes from LevelController and Strings for values (we covered in class many times not to use Strings for this sort of thing), then all those magic numbers in `g.drawImage`.  In good OO design, there would be anobject for Hunter, Assassin, Wizard that can draw itself -- just pass coordinates.


I reported problem about image loading and inconsistent image spelling to team,
but after deadline (Sunday, May 20) it still has errors.  When I run the JAR File
it throws NullPointerException:
```
Couldn't find image
Exception in thread "Thread-3" java.lang.NullPointerException
	at swing.Texture.grabImage(Texture.java:70)
	at swing.Texture.getTextures(Texture.java:52)
	at swing.Texture.<init>(Texture.java:40)
	at swing.Game.init(Game.java:46)
	at swing.Game.run(Game.java:72)
	at java.lang.Thread.run(Thread.java:748)
```

Some image names misspelled in `Texture.java` are:
```
Name in Java        Actual File name
Assassin.png        assassin.png
Bow_Master.png      Bow_master.png
```

Did you test the JAR file?  It throws exceptions about image files not found.
Looks like you didn't test code.

Some versions of Windows are *case agnostic* for filenames
that fit into the old-style 8.3 size limit, but not for Bow_Master.png.
To **avoid** this sort of problem use **consistent naming**, such as always
name images in lowercase.  Your code has some names in lowercase, some with first letter in caps.  Even better: test your code on a different machine.


## It Came From Outer Space

Game has some bugs, but scope of project is good. Has separate executables for
Windows, Linux, and Mac.  ZIP file of executable is rather large (33MB on Linux).

Online Documentation is informative, including github.io site that looks like a duplicate
of repo README.md content.  

## Lion Villain

Animated arithmetic game. Uses threads and a thread pool, ResourceBundle (undocumented) for
configuration information. Shows good effort to make use of other frameworks: uses Kryonet library for communication and ORMLite for persistence.

The Documentation lacks detail of how you used the technologies, and total lack of info
of how to configure it.  The ServerLauncher.jar just prints "Server Start" with no info about
the IP address or port it is listening on.  Would be helpful to display IP address and port.

In One Player mode, the Game freezes forever after showing "Insert your name" screen
if I type in my name.  Works if I click "Skip".  2-player mode works OK.

## Market Log

Project idea is useful, and uses some new knowledge and technology, such as ORMlite, JavaFX Tables, jfoenix for charts, and iText for PDF.  

Required dependency JARs should all be in one directory (usually named `lib`) instead of 3 directories as in your code.

The documentation needs improvement.  No explanation of technology used, how to configure or initialize the database, or how to get initial data into the database.  The app uses a properties file for database configuration values (good), but documentation doesn't mention it or how to customize it.

The JAR file won't run on anyone else's machine because of the URL, user, and password in configuration file. Its good that you have extenalized these (not hardcoded in Java), but should have installation instructions that tell user to edit the configuration file.
Would be better to use H2 so it can auto-create the database and table schema.  If you *really* want to use MySQL then use the Localhost address (127.0.0.1) and tell users how to create database and edit configuration file.  ORMLite has utility classes that can create entity tables.

Error messages in DatabaseManager are misleading:

```java
} catch(SQLException e) {
    System.out.println("Cannot connect to OrderDao");
}
```
the code doesn't "connect" to a DAO, it creates it.  The real source of the
error is either a) connection is null, b) database doesn't have
an Order table or schema is wrong, c) connection refused.

You should write code for ORMLite to create tables, so a new installation doesn't have to.  The `TableUtils` class has many useful methods for database management, including `TableUtils.createTableIfNotExists()`.

## The Maze

Project shows a lot of work to learn about 3D image rendering and 3D modelling.  The JAR runs on Windows and Linux.  Project docs don't contain any explanation of the technology used or list of dependencies (requires jMonkey and appears to require some DLL on Windows), but the presentation does contain a good intro to what they did.

Project has an `nbproject` directory (Netbeans build info) but no explanation of why its there or how to use it.

## Math Master

Uses Kryonet for network and "matheclipse" to evaluate math expressions, but the project design and code are poor.  Jar runs but didn't work correctly on my computer.  After annoying registration process, it throws exception when choose "Calculadola" game:
```
Server Start
java.lang.IllegalStateException: Location is not set.
	at javafx.fxml.FXMLLoader.loadImpl(FXMLLoader.java:2434)
	at javafx.fxml.FXMLLoader.load(FXMLLoader.java:2409)
	at onlineMode.GameClient.<init>(GameClient.java:53)
```

looks like an error in specifying location of FXML file, or FXML filename misspelled, or not in JAR file.

This stack trace shows that your app is not catching exceptions and printing helpful error messages.

Design Issues: 

* requires users to "register" before using game (should have a "guest" user)
* requires username at least 8 chars (annoying)
* requires password at least 8 chars (annoying)
* requires supplementary question and answer (annoying)
* uses MySQL database -- your JAR doesn't work if database doesn't exist
* uses JDBC instead of ORMLite
* projet structure doesn't use polymorphism much. Would be better to have a main Controller that treats all other game controllers the same, so you can add more games.
* `Controller` superclass is not useful. Only contains a String `name` attribute.

Coding Issues:

* Poor use of JDBC. Creates a new database connection every time a new object is created in any of these classes and **never closes the connection**. That's a lot of database connections.  Found in these classes:
   * Login
   * ScoreBoard
   * ForgetPassword
   * Register
* Hardcoding JDBC url, username, password into code in **many classes** (Login, Scoreboard, Register, ForgetPassword).  What did we study about *duplicate code*?
* You **should** have a singleton class that manages a single connection to the database, and uses Properties or ResourceBundle for database configuration.
* Stores passwords in plain-text in the database.  I warned class about this.  Other projects used jBCrypt; there is a jBCrypt example on course web page. 
* The game consumes a lot of CPU while running, even when the user isn't doing anything.  I think the game is endlessly retrying some failed connection or failed request.
* No obvious "Main" or "Application" class and no explanation of how to build the source code.  The `LoginUI` class is the main class!
* Many messages printed on console

## My Wallet

The idea is interesting but the design and implementation are not too good.

"Outcome" should be "Expense".

Design and coding issues:

* Project uses JDBC instead of ORM, and  does not define any DAO to encapsulate database part.
* Hardcode database URL, user, and password into code (`jdbc.java`)
* Uses "root" user and empty password to connect to MySQL database on Google Cloud! This is really insecure -- anyone can login and do whatever they want.
* Since all users are sharing same database on Google Cloud SQL, all their data is mixed together.  So the app is not useful as a personal inceome/expense tracker.
* Since this app is designed for an individual user, in would be better to use an embedded database like H2, HSQLDB, Derby, or Sqlite and a local database.  Then each user would have his own, local database and you wouldn't expose your Google SQL credentials. They would not need to install a database server, either.
* Code that can't possibly work:
```java
public static void readFile() {
    try {
       file = new File("src/Wallet/UserId");
    }
    catch (Exception e) {
       System.out.println("Could not access file " + "src/Wallet/UserId.txt");
       return;
    }
```
  this references your "src/" directory that user won't have on his computer! On top of that, a) hardcode the filename, b) the println message prints a **different** filename, b) the path is relative but doesn't use classpath or installed path.
* Lots of `static` methods in `jdbc` class that other classes are calling. This is not OO style design.
* Lots of coupling between `jdbc` class and other classes.  The other classes must all know the table and field names to persist or retrieve data.
* Not consistently using Java naming convention: package `Wallet`, class `jdbc`.
* UI not too helpful: default date is "1 Jan 2017" instead of today's date.
* In the "Status" screen it shows values like Income 3080200.0, Outcome 242790.0.  The numbers aren't formatted as money (3,080,200.00) and no currency.
* Lots of MySQL messages printed on console.  Define a Logger to redirect those to a file.  Even better: fix the cause of the messages! (But still use a logger anyway.)

Project documentation lacks explanation of technology used, dependencies, how to build and run application.  Looks nice, but mostly advertising.

If you make these modifications and make it easier to configure, it could be a useful app.  Also suggest you add (customizable) "categories" for income and expense. The Daily Expense 2 app on Google Play store is good example.

## Press Arrow Game

Scope of project is too simple.  App is printing lots of text on console.
In the Score window, you just use a label with multiline text.  Better to use a table or at least Vbox of labels with formatted text. 

"Hint" dialog text scrolls off end of box and cannot be read.  Several English grammar errors in text.



## Rabby Hap Bananas Hamp

Good implementation and documentation.  Very entertaining demo.

`GameSceneTeam` code looks very similar to `GameScene`.  Could it be a subclass and just override the parts that differ?

Then you could apply polymorphism in `GameWindow` so it could treat all game modes the same.

## Randomize


Has JUnit test class, but the tests are poor.  Does not seriously test the code.

The "core" class of this app appears to be `RandomNumber`, but that class is poorly written.

1. It `getRandomed()` it creates a new Random number generator each time.  Why?  A single random number generator should produce a random sequence and creating a new requires some overhead.
```java
public int getRandomed() {
		Random rand = new Random();
		int range = max - min + 1;
		int randomed = rand.nextInt(range) + min;

		if (rands != null) {
			if (!rands.contains(randomed)) {
				rands.add(randomed);
			} else if (rands.size() < range) {
				do {
					randomed = rand.nextInt(range) + min;
				} while (rands.contains(randomed));

				rands.add(randomed);
			} else {
				randomed = Integer.MIN_VALUE;
			}
		}
		return randomed;
	}
```
2. The `if` block with `while` statement is unnecessarily complex.
```java
public int getRandomed() {
		// new Random() moved to constructor
		int range = max - min + 1;
		int randomed = rand.nextInt(range) + min;

		if (rands != null) {
			if (rands.size() >= range) return Integer.MIN_VALUE;
			// this is inefficient if range is large and almost all used up
			while (rands.contains(randomed)) {
				randomed = rand.nextInt(range) + min;
			}
			rands.add(randomed);
		}
		return randomed;
	}
```

## Reserving Room

A room reservation application, uses a database on Google cloud to store reservation data.

The app is too simple to be realistic.  Even the basic feature of making reservations is not complete, in that there's no way to move back and forth between screens. Confirmation screen throws exceptions (with stack trace printed on console), and not well formatted.  

Has a "Manager" interface that can view reservations but not much else.

Lacks explanation of technology used. Just poorly formatted list of design patterns (but doesn't explain how or why they are used).

No explanation how to build source code, and doesn't mention a dependency in iText library (not included with source).
DatabaseManager hardcodes the jdbc username and password into code, even though there is a Properties file!
```
    private ConfigFileManager cf = ConfigFileManager.getInstance();
    private final String DATABASE = cf.getProperty("database.url");
    private final String USERNAME = "jamp";
    private final String PASSWORD = "jamp";
```
and more hardcoded dependencies (bad coding and *unnecessary*):
```
public void connect() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
```

Uses raw SQL for queries instead of PreparedStatement. Building SQL statements from string is vulnerable to SQL injection, which your code doesn't check for.

1. After searching for a room there is no way to cancel and go back to search page.  
2. When click Search button the app opens 2 windows, one is blank.
3. No exit button or back button.
4. Manager can view reservations but not see who is currently in which room, or edit the room prices.
5. While using Customer Information screen the app printed stack trace for NumberFormatException error on console. You should catch and handle this.
6. Display of reservation price is not formatted or aligned and has wording errors ("Add breakfast 0 bed").  Doesn't look convincing.

## Restaurant POS

A restaurant POS for placing orders at tables. The documentation has some info about how to build, but could use more explanation about design and technology used. 

I think the feature set is insufficient for use in a restaurant, and UI has usability problems.

For features:

* can't see status of each order.  Only way to see what is ordered it to click on a table and look at Ordered Items.  Has order been submitted to chef? Has it been paid?
* A restaurant would want to see a queue of pending orders. What's been sent to the chef, what orders the chef has finished. 
* The food items are shown in boxes (without price).  This doesn't scale well.
* When ordering, no way to remove an item from an order.
* The "Current Items" and "Ordered Items" seems confusing. Customer or order taker needs to press some key to move Current Items to Ordered Items, and there is no way to remove an Ordered Item or decrease quantity.

The JAR file only shows Waiter/Manager interface, not customer interface.

Coding Weaknesses:

1. Uses MySQL, which requires database server and URL.
2. Has a properties file but the driver class name is **hardcoded** into DBManager:
```java
private DBManager() {
   try {
     Class.forName("com.mysql.jdbc.Driver");
     ...
   }
   catch(ClassNotFoundException e) {
     System.out.println("Could not find the class");
   }
```
3. The error message in above code is **not useful**. At least specify *what* class was not found.
4. Class.forName("com.mysql.jdbc.Driver") is not necessary. There is a message printed on the console telling you it is not necessary, so why do it?
5. Text in ALL the windows is clipped and windows are not resizable.  In Login window text fields and buttons are clipped ("Rest...", "Usern...", "Passw...").
6. Evidentally using fixed size fields (text clipped) and absolute layout.  Should try to do better than that.
7. If invalid Login is shows an EMPTY Error dialog box. No words at all.

## Serviced Apartment

Nice documentation including explanation of technology used.

After starting a room reservation, app got stuck on Room and Payment screen. Would not accept payment if payment date is not today.  Too many fields. Why require "Amount Paid"?  It should be the total.

On Checkout, why does clerk have to enter Customer Name?  If he enters room number then it identifies who is checking out.  If he misspells customer name, it won't accept it -- this is stupid.

Should not put spaces in filenames in Downloads directory.

## Snake And Ladder

Player can't do much. Just rolling dice.  Game could have beeen written in JavaFX but you used Swing anyway.

Docs don't explain about technology used, just listing of pattern names.

Replay is interesting feature.

UI Defects:

1. If you close the "roll dice" window there is no way to open it again.
2. Menu doesn't have an Exit or Quit item.
3. When click "Save" it doesn't ask for a filename, so there is only one saved game but user doesn't know where it is (unless he hunts for file).
4. Menu doesn't have an "exit" button!
5. Part of the board is clipped on startup.  Have to resize window to see all.  In Swing it is **easy** to resize window to fit components. See below.

In the GameUI class you build up the JFrame in constructor (bad program structure: should use separate method).  Then you call

```java
frame.pack();              // 1
frame.setvisible(true);
frame.setLayout( ... );
frame.add(renderer, BorderLayout.CENTER);

for(String x: item )
   // add a bunch of menu items
   // add a menu
}
bar.add(menu);
frame.setSize(750, 810);   // 2
```

You call `pack()` and `setVisible(true)` before completing the frame.
Then you call `setSize()` -- bad programming -- which completely overrides the effect of pack().  Not good use of Swing.  Better to use Renderer (your subclass of JPanel) to set the `preferredSize` of the JPanel containing game board by querying the image size.  Then Swing could pack() the JFrame to correct size.

## Sudoku

Nice game with lots of options, including custom Sudoku generator.

Good documentation in README, including discussion of implementation. 

Game has long delay at start, with no visual feedback as to what is happening. Not good UI design to freeze UI without showing some progress.

The code was written mostly by Kornphon (56 commits, 6,000 lines).  
He also did all the work on README.md.

Vichakorn has 11 commits, 3 of them just for a UML diagram, and others mostly FXML files (created with Scenebuilder).  One commit just to reformat code (something Eclipse does for you).


## Uno

Partially uses OCSF but doesn't understand how to use the framework and instead wrote own code that duplicates (incorrectly) services provided by the framework.

Invalid import `com.sun.xml.internal...` in StartMenuController, also many unused imports and syntax error from extra `;`.  Static import of `host` and `portNum` from anothe class is bad programming.

DEFAULT_PORT is not shown on UI at startup, and it should be greater than 1024 (code has 400). Ports 1-1023 are privileged ports.  If app not run by an administrative user, the server will **not** be able to listen on port 400. (The OCSF documentation mentions this.)

Bad code in network.Client:
```java
static String host;
static int port;
private static boolean isConnected;
```
should not be static (you access them in "instance" context) and you can get the values from the AbstractClient superclass, so don't shadow superclass attributes!  OCSF AbstactClient has:
```java
getPort() 
getHost()
isConnected()
```

Same errors in `Server` class. You have static attributes:
```java
private static boolean isConnected = false;
public static int ID = 1;
public static ArrayList<Room> rooms = ...
public static ArrayList<Player> players = new ArrayList<>();
private static int DEFAULT_PORT = 1000;
private ServerSocket serverSocket = null;
private Socket socket = null;
```
All this a) either duplicates or overrides what the framework provides, b) not OO style programming.

In `Client.sendObjectToServer` you aren't using the framework! Trying to create your own socket to server to send object.  Totally unnecessary -- OCSF can do this.

More bad code:
```java
// in Client
private static void sendObjectToServer(Object obj){
```
a) should not be static, b) you should let the framework send the object (`sendTooServer()`) instead of creating your own socket (which fails).

In the network.Client class you wrote a method `handleMessageFromClient` that calls `sendToServer`.  In OCSF, `handleMessageFromClient` is the callback method in the **Server**.  Its confusing to name a same method with the *exact opposite* funcationality on client side.  Better to call it "send()" or something.

## Weather App

Shows effort to learn Android, use some libraries, and weather API.
Not many features in app and not much code, though.

## Sushi Container System

Code pulled on 22 May (4 days after deadline). No work has been added to repo in last 10 days.

Code is very incomplete, no docs at all, and no JAR.

Code doesn't compile due to a) folder name "Application" but declared package is "application", b) invalid imports in other classes.

Even after I fix these errors the app doesn't do anything. Just displays one poorly laid out window with no event handlers.

Class `DatabaseConnector` hardcodes the database URL and uses user "root" with password "root":

```java
public class DatabaseConnector {

   private DatabaseConnector() {
        try {
            connection = new JdbcConnectionSource("jdbc:mysql://localhost:8889/sushi_container_systems","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
```

Problems with this code:

1. hardcoding database URL into Java code. Should use properties file.
2. using database "root" user. Should **never** use database root user in app.
3. not producing (and looging) useful error messages -- just auto-generated printStackTrace.

