This file describes how to automate unit tests using parameters for data values.

## Why AuctionTest Needs a Parameter

You must run your unit tests using the 7 different variations of Auction code,
so you need to call `setAuctionType(n)` before testing the Auction.

The most convenient place to do this is in a `setUp` method, like this:

```java
public class AuctionTest {
	// an Auction attribute for tests to use (test fixture)
	private Auction auction;

	// initialize the Auction before each test
	@Before
	public void setUp() {
		auction = new Auction("Core Java");
		auction.setAuctionType(1);
	}
```

After running all tests you need to change auctionType to 2 and run again,
then change auctionType to 3 and run again, etc.

If you *change* any of your tests, you need to repeat the whole process!

You can automate this work using *Parameterized Tests*.


## How to Create Parameterized Tests

JUnit can run the same set of test methods multiple times using different
values of some variables.  This is called *parameterized unit tests*.

You need to do 3 things in your test class.

### 1. Add @RunWith(Parameterized.class) to Class

```java
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AuctionTest {
	// your unit tests
}
```

### 2. Define a `public static` Method that Returns Values for Parameter(s)

This method returns a Collection, where each element in the collection 
contains one set of values to use in tests.
You can have more than one parameter, so the values are stored
in an array of Object.

In our tests, we only need one parameter (the auctionType), 
so the arrays just contain a single element:

```java
@Parameterized.Parameters(name="Tests for auctionType={0}")
public static Collection<Object[]> getParameters() {
	// a 2-dimensional array
	// each ROW in the array is one set of parameter values
	Object[][] data = {
		{1},  // first value of parameter
		{2},  // second value of parameter
		{3},  // third value of parameter
		{4}   // etc.
	};
	return java.util.Arrays.asList(data);
}
```

You can name this method anything you like.  The import thing is
that it is **public static Colection<Object[]>**.

### 3. Receive Parameter Values to Attributes Used in Your Tests

The last (and most important) step is to assign the parameter values
to some attributes in your code, then use those attributes in `setUp`.

**3.1 Assign Values Using a Constructor**

You can write a constructor with parameters, and JUnit will call the constructor with your parameterized data.

```java
/**
 * Assign parameter values using constructor.
 */
@RunWith(Paramaterized.class)
public class AuctionTest {
	// an Auction used in the tests
	private Auction auction;
	// the auctionType, which is used in setUp
	public int auctionType;

	// initialize Auction before each test
	@Before
	public void setUp() {
		auction = new Auction("Core Java");
		auction.setAuctionType(this.auctionType);
		//TODO temporarly add a print statement to verify its working?
	}

	// Constructor to receive parameter values
	public AuctionTest(int auctiontype) {
		this.auctionType = auctiontype;
	}
```

**3.2 Assign Parameter Values Directly to Attributes**

Junit can *directly* set the values of **public** attributes (must be public)
so you don't need a constuctor.  
Annotate attributes you want to set using `Parameterized.Parameter(n)`. The attribute must be `public`.

```java
/**
 * Assign parameter values directly to public attributes (no constructor)
 */
@RunWith(Paramaterized.class)
public class AuctionTest {
	// an Auction used in the tests
	private Auction auction;
	// the auctionType, which is used in setUp
	@Parameterized.Parameter(0)
	public int auctionType;

	// initialize Auction before each test
	@Before
	public void setUp() {
		auction = new Auction("Core Java");
		auction.setAuctionType(this.auctionType);
	}
```

## Running the Tests

JUnit will run **all** your tests for each row of data in the collection returned by the `@Parameterized.Parameters` method.  It prints a message using the name you specify in the annotation.  For example:

```
[Tests for auctionType=1]
  testNewAuctionState
  testCanBid
  testWinnerAndBestBid
[Tests for auctionType=2]
  testNewAuctionState
  testCanBid
  testWinnerAndBestBid
[Tests for auctionType=3]
  testNewAuctionState
  testCanBid
  testWinnerAndBestBid
 ...
```

## More Than One Parameter?

You can have more than one parameter for parameterized tests.

The Auction has a minimum bidding increment.
Suppose you want to test the Auction using a bidding increment of 1 and 20.  You can make this be another parameter for the tests:

```java
/**
 * Inject parameter values directly to public attributes (no constructor)
 */
@RunWith(Paramaterized.class)
public class AuctionTest {
	private Auction auction;
	// the auctionType, which is used in setUp
	@Parameterized.Parameter(0)
	public int auctionType;
	// the minimum bidding increment
	@Parameterized.Parameter(1)
	public int minIncrement;

	// initial Auction before each test
	@Before
	public void setUp() {
		auction = new Auction("Core Java", minIncrement);
		auction.setAuctionType(this.auctionType);
	}

	@Parameterized.Parameters(name="Tests for auctionType={0} minIncrement={1}")
	public static Collection<Object[]> getParameters() {
		// each ROW in the array is one set of parameter values
		Object[][] data = {
			//{auction type, min increment}
			{1, 1},
			{1, 20},
			{2, 1},
			{2, 20},
			{3, 1},
			{3, 20},
            // etc.
     	};
		return java.util.Arrays.asList(data);
	}
```


## Resources

* [DZone Article](https://dzone.com/articles/junit-parameterized-test) shows how to assign values of parameters directly to attributes in your test class. 

* [TutorialsPoint](https://www.tutorialspoint.com/junit/junit_parameterized_test.htm) has example where parameter values are passed to a constructor in your test class.  Normally, test classes don't need a constructor but here its useful.
