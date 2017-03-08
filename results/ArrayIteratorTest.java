package ku.util;
import java.util.*;
import org.junit.*;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

/**
 *  JUnit 4 tests for ArrayIterator assignment.
 *
 *  You can use BlueJ, Eclipse, or Netbeans to run these
 *  tests in your project.  In Eclipse or Netbeans you 
 *  need to add the junit4-x.jar to the project (but not
 *  in BlueJ, JUnit is included automatically).
 *
 *  To run tests at the command line, compile this file
 *  and your ArrayIterator.java file:
 *  javac -cp /path/to/junit4.jar;. *.java 
 *
 *  Then run using java command:
 *  java -cp /path/to/junit4.jar;. ArrayIteratorTest
 */
@SuppressWarnings("unchecked")
public class ArrayIteratorTest {
	// array of mixed type data
	private Object [] array;
	
	private ArrayIterator iter;
	
	/**
	 * Create an array for tests.
	 */
	@Before
	public void setUp() {
		// an array without nulls
		array = new Object [] {
				"Hello.",
				"",
				new Date(),
				new Integer(999),
				new Double(1.23),
				new Character('x')
		};
		// create the iterator
		iter = new ArrayIterator<Object>( array );
	}

	/**
	 *  Test that ArrayIterator implements java.util.Iterator.
	 */
	@Test
	public void testImplementsIterator() {
		assertTrue( iter instanceof java.util.Iterator );
	}

	/** Test using array with just one element. */
	@Test(timeout=100)
	public void testSingletonArray() {
		String [] array = { "numero uno" };
		ArrayIterator it = new ArrayIterator(array);
		assertTrue( it.hasNext() );
		assertSame( array[0], it.next() );
		assertFalse( it.hasNext() );
	}
	
	/** basic test: call hasNext and next in the typical order. */
	@Test(timeout=100)
	public void basicIteratorTest() {
		Object [] array = new Object[] {"one", new Date(), new Integer(2) };
		// copy array to verify it d
		Object [] copy= new Object[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);
		iter = new ArrayIterator(array);
		for(int k=0; k<array.length; k++) {
			assertTrue( iter.hasNext() );
			assertSame( array[k], iter.next() );
		}
		assertFalse( iter.hasNext() );
		// hasNext should continue to return false
		assertFalse( iter.hasNext() );
		assertFalse( iter.hasNext() );
		// should not change the array
		assertTrue( java.util.Arrays.equals( array, copy ) );
	}
	
	/**
	 * Test that we can call next() without first calling hasNext
	 */
	@Test(timeout=100)
	public void testNextWithoutHasNext() {
		// read all the elements without calling hasNext
		for( int k=0; k<array.length; k++ ) 
			assertSame( array[k], iter.next() );
		assertFalse(  iter.hasNext() );
	}
			
	/**
	 * test an array of size zero.
	 */
	@Test
	public void testArraySizeZero() {
		array = new Object[0];
		iter = new ArrayIterator(array);
		assertFalse( iter.hasNext() );
	}
	
	/**
	 * Test using array of null.
	 */
	@Test(timeout=100)
	public void testArrayOfNulls() {
		array = new Object[] { null, null };
		iter = new ArrayIterator(array);
		assertFalse( iter.hasNext() );
		assertFalse( iter.hasNext() );
		// same test using next() only
		array = new Object[] { null, null };
		iter = new ArrayIterator(array);
		boolean gotException = false;
		try {
			iter.next();
		} catch(NoSuchElementException nse) {
			gotException = true;
		}
		if (!gotException) fail("next didn't detect no more elements.");
	}
	
	/**
	 * Test array with null at end only.
	 */
	@Test(timeout=100)
	public void testArrayNullAtEnd() {
		Double element = new Double(0);
		Double [] array = new Double[] { element, null, null, null };
		Iterator<Double> iter = new ArrayIterator<Double>(array);
		assertTrue( iter.hasNext() );
		assertEquals( element, iter.next() );
		assertFalse( iter.hasNext() );
	}

	/**
	 * Test skipping over null elements in middle of array.
	 */
	@Test(timeout=100)
	public void testSkipNulls() {
		array = new Object[] { null, "first", null, null, null, "second" };
		iter = new ArrayIterator(array);
		assertTrue( iter.hasNext() );
		assertEquals( "first", iter.next() );
		assertTrue( iter.hasNext() );
		assertEquals( "second", iter.next() );
		assertFalse( iter.hasNext() );
		// same test without using hasNext
		array = new Object[] { null, "first", null, null, null, "second" };
		iter = new ArrayIterator(array);
		assertEquals( "first", iter.next() );
		assertEquals( "second", iter.next() );
		assertFalse( iter.hasNext() );
	}
	
	/**
	 * Calling next after end of data should throw exception.
	 */
	@Test(timeout=100, expected=java.util.NoSuchElementException.class)
	public void testNextThrowsException() {
		// read all the elements. Protect against bad code using a counter.
		int count = array.length + 1;
		while( iter.hasNext() && count-- > 0 ) iter.next(); // consume it

		assertFalse("after returning entire array, hasNext should be false", iter.hasNext() );
		if (count <= 0) fail("ArrayIterator returned too many elements.");
		
		// this should throw NoSuchElementException
		iter.next();
	}
	
	/**
	 * Test of typed (parameterized) iterator
	 */
	@Test
	public void testNumberIterator() {
		final Number [] numbers = 
				new Number[] {  new Integer(0), 
								new Double(1), new Float(2F),
								new Long(Long.MAX_VALUE) };
		// for testing typed ArrayIterator
		ArrayIterator<Number> iter = new ArrayIterator<Number>(numbers);
		
		for(int k=0; k<numbers.length; k++) {
			assertTrue( iter.hasNext() );
			Number n = iter.next(); // should return Number not Object
			assertSame( numbers[k], n );
		}
	}
	
	/**
	 * Test remove() removes the element most recently
	 * returned by next().  Not the "next" element the 
	 * cursor points to.
	 */
	@Test
	public void testRemove() {
		array = new Object[] {"first", new Date(), new Double(4), null, "last"};
		iter = new ArrayIterator(array);
		Object a0 = array[0];
		Object a1 = array[1];
		Object a2 = array[2];
		assertSame( a0, iter.next() );
		assertSame( a1, iter.next() );
		iter.remove();
		// only array[1] should be null
		assertSame( a0, array[0] );
		assertNull( array[1] );
		assertSame( a2, array[2] );
		// remove another one
		// this time, call hasNext() before remove.
		// It should remove the last element returned by next() (a2).
		assertTrue( iter.hasNext());
		assertSame( a2, iter.next() );
		assertTrue( iter.hasNext() ); // advance past null
		iter.remove();
		assertNull( array[2] );
	}

	/** run a test suite and describe the results */
	public static void main(String[] args) {
		Result result = org.junit.runner.JUnitCore.runClasses( ku.util.ArrayIteratorTest.class );
		int count = result.getRunCount();
		int failed = result.getFailureCount();
		System.out.printf("Unit Tests.  Success: %d  Failure: %d\n",
				count-failed, failed);
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
