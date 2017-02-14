package ku.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * JUnit 4 tests for the ArrayIterator problem in PA2.
 * 
 * To run these tests in Eclipse: 
 * first add JUnit 4 library to your project,
 * then right click on this file in Package Explorer pane
 * and choose Run as -> JUnit Test.
 * 
 * To run these tests in BlueJ, just add this file to
 * the project. Right click on it and choose Run Unit Tests.
 * 
 *  To compile and run tests at the command line:
 *  
 *  CLASSPATH=$CLASSPATH:/path/to/junit4.jar (Bash shell)
 *  set CLASSPATH=%CLASSPATH%;D:/path/to/junit4.jar
 *  javac *.java 
 *  java  ArrayIteratorTest
 * 
 * @author jim
 */
public class ArrayIteratorTest {
	ArrayIterator<String> iter;
	
	
	/**
	 * Must pass this test before you can run the other tests.
	 * If you don't see what is wrong, read the assignment more carefully.
	 * Its supposed to be an Iterator.
	 */
	@Test
	public void testImplementsIteratorInterface() {
		ArrayIterator<String > iter = 
				new ArrayIterator<String>( new String[] {"I'm","an","Iterator"} );
		assertTrue( iter instanceof java.util.Iterator );
	}
	
	@Test(timeout=100)
	public void testEmptyArrayIterator() {
		ArrayIterator<Object> iter = makeArrayIterator( );
		assertFalse(iter.hasNext());
		assertFalse(iter.hasNext());
	}
	
	@Test(timeout=100)
	public void testArrayWithOneItem() {
		String item = "one";
		iter = makeArrayIterator( item );
		assertTrue(iter.hasNext());
		assertTrue(iter.hasNext());
		assertSame(item, iter.next());
		assertFalse(iter.hasNext());
	}
	
	/** basic test: call hasNext and next in the typical order. No nulls. */
	@Test(timeout=100)
	public void basicIteratorTest() {
		Object [] array = new Object[] {"one", new Date(), new Integer(2) };
		// copy array to verify it doesn't change
		Object [] copy = java.util.Arrays.copyOf(array, array.length);
		ArrayIterator iter = new ArrayIterator(array);
		for(int k=0; k<array.length; k++) {
			assertTrue( iter.hasNext() );
			assertSame( array[k], iter.next() );
		}
		assertFalse( iter.hasNext() );
		// hasNext should continue to return false
		assertFalse( iter.hasNext() );
		// iterator should not change the array
		assertTrue( java.util.Arrays.equals( array, copy ) );
	}

	/** Test that we can call next() without first calling hasNext(). */
	@Test(timeout=100)
	public void testArrayOfMany() {
		iter = makeArrayIterator( "one", "two", "three", "four" );
		assertSame("one", iter.next());
		assertSame("two", iter.next());
		assertSame("three", iter.next());
		assertTrue(iter.hasNext());
		assertTrue(iter.hasNext()); // deliberate duplicate call
		assertSame("four", iter.next());
		assertFalse(iter.hasNext());
	}

	/** An Iterator for an array of nulls, to test handling of nulls. */
	@Test(timeout=100)
	public void testArrayWithOnlyNull() {
		iter = makeArrayIterator( null, null );
		assertFalse(iter.hasNext());
	}
	
	/** Test with some null and non-null elements. */
	@Test(timeout=100)
	public void testArrayWithSomeNull() {
		iter = makeArrayIterator( "one", null, null, "two", null, "three");
		assertEquals("one", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("two", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("three", iter.next());
		assertFalse(iter.hasNext());
	}
	
	/** Test the case where nulls come at the end of array. */
	@Test(timeout=100)
	public void testArrayWithTrailingNull() {
		iter = makeArrayIterator( "one", null, null, null );
		assertTrue(iter.hasNext());
		assertEquals("one", iter.next());
		assertFalse(iter.hasNext());
	}
	
	/**
	 * This test *should* throw NoSuchElementException
	 * next() is called after all elements have been read.
	 */
	@Test(timeout=100, expected=java.util.NoSuchElementException.class)
	public void testNoSuchElement() {
		iter = makeArrayIterator("one", "two");
		assertEquals("one", iter.next());
		assertEquals("two", iter.next());
		// should throw NoSuchElementException
		assertEquals("", iter.next()); 
	}
	
	/**
	 * Test remove() removes the element most recently
	 * returned by next(). 
	 */
	@Test(timeout=100)
	public void testRemove() {
		Object[] array = new Object[] {"first", new Double(4), "last"};
		ArrayIterator iter = new ArrayIterator(array);
		Object a0 = array[0];
		Object a1 = array[1];
		Object a2 = array[2];
		assertSame( a0, iter.next() );
		assertSame( a1, iter.next() );
		iter.remove();
		assertSame( a2, iter.next() );
		// only array[1] should be null
		assertSame( a0, array[0] );
		assertNull( array[1] );
		assertSame( a2, array[2] );
		// remove another element
		iter.remove();
		assertNull( array[2] );
	}
	
	/**
	 * Create an array iterator from arguments provided
	 * to this method.
	 * @param args the arguments to put in the array iterator
	 * @return Iterator for the arguments.
	 * 
	 * The return type should be Iterator<T>, but I made
	 * it ArrayIterator<T> so the code will compile for
	 * students who didn't declare that they implement Iterator.
	 */
	private static <T> ArrayIterator<T> makeArrayIterator(T ... args) {
		T a[] = java.util.Arrays.copyOf(args, args.length); // make an array
		return new ArrayIterator<T>( a );
	}
	
	/**
	 * Try the makeArrayIterator method. Not a JUnit test.
	 */
	public static void tryMakeArrayIterator( ) {
		System.out.println("An iterator of String:");
		Iterator<String> iter = makeArrayIterator("hi", "bye");
		while(iter.hasNext()) System.out.print(iter.next() + " ");
		System.out.println("\nAn iterator of Number:");
		Iterator<? extends Number> nums = makeArrayIterator(new Double(1.5), new java.math.BigDecimal("0.1"), new Integer(10));
		while(nums.hasNext()) System.out.print(nums.next() + " ");
		System.out.println();
	}
	
	/**
	 * Run JUnit tests as a stand-alone test suite,
	 * and describe the results.
	 */
	public static void main(String[] args) {
		Class<?> testclass = ArrayIteratorTest.class;
		Result result = org.junit.runner.JUnitCore.runClasses( testclass );
		int count = result.getRunCount();
		int failed = result.getFailureCount();
		System.out.printf( "%s Result.  Success: %d  Failure: %d\n",
				testclass.getSimpleName(), count-failed, failed);
		List<Failure> failures = result.getFailures();
		// this doesn't seem to return all the failures
		for(Failure f: failures) {
			Description d = f.getDescription();
			System.out.println( f.getTestHeader() +": "+ f.getMessage() );
			System.out.println( d.getDisplayName() );
		}
		// return the number of failures
		System.exit(failed);
	}
}
