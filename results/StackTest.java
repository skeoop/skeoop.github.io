package ku.util;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Test of Stack and its behavior.
 * @author jim
 */
@SuppressWarnings( {"rawtypes", "unchecked"} ) // no warnings about type safety
public class StackTest {
	private Stack stack;
	
	/** Test the constructor and basic stack query methods. */
	@Test(timeout=500)
	public void testCapacity() {
		final int capacity = 2;
		stack = new Stack(capacity);
		assertEquals( capacity, stack.capacity() );
		testStackState(stack, 0, capacity);
		stack = new Stack(100);
		assertEquals( 100, stack.capacity() );
		// capacity doesn't change
		stack.push("push");
		assertEquals( 100, stack.capacity() );
	}
	
	/** Test stack supports type parameter. */
	@Test(timeout=500)
	public void testStackWithTypeParam() {
		stack = new Stack<String>(1);
	}
	
	/** Test size method is always correct. */
	@Test(timeout=500)
	public void testStackSize() {
		int cap = 90;
		stack = new Stack(cap);
		for(int k=1; k<=10; k++) {
			final Integer obj = new Integer(k);
			stack.push(obj);
			assertEquals( k, stack.size());
			stack.pop();
			assertEquals( k-1, stack.size());
			stack.push(obj);
		}
		int size = stack.size();
		for(int k=size; k>0; k--) {
			stack.pop();
			assertEquals( k-1, stack.size());
		}
	}
	
	
	/** Edge case: a stack of capacity 1. 
	 *  A better case would be stack of capacity 0,
	 *  but this was not clearly stated in assignment.
	 */
	@Test(timeout=500)
	public void testStackSizeOne() {
		String ITEM = "foo";
		final int capacity = 1;
		Stack<String> stack = new Stack<String>(capacity);
		testStackState( stack, 0, 2 );
		stack.push( ITEM );
		testStackState( stack, 1, capacity );
		assertSame( ITEM, stack.pop() );
		testStackState( stack, 0, capacity );
	}
	
	/** Test peek. It doesn't throw exception. */
	@Test(timeout=500)
	public void testPeek() {
		String ITEM1 = "foo";
		Double ITEM2 = new Double( Math.random() );
		final int capacity = 3;
		stack = new Stack(capacity);
		stack.push(ITEM1);
		assertSame( ITEM1, stack.peek() );
		assertSame( ITEM1, stack.peek() ); // peek doesn't change stack
		stack.push(ITEM2);
		assertSame( ITEM2, stack.peek() );
		assertSame( ITEM2, stack.peek() );
		stack.pop();
		// back to first element
		assertSame( ITEM1, stack.peek() );
		assertSame( ITEM1, stack.peek() ); // peek doesn't change stack
	}
	
	/** Test peek doesn't throw exception. */
	@Test(timeout=500)
	public void testPeekEmptyStack() {
		stack = new Stack(2);
		assertNull( stack.peek() );
	}
	
	@Test(timeout=500)
	public void testPushAndPop() {
		Object [] ITEMS = {
				"foo",
				new Double( Math.random() ),
				new Character('z'),
				System.out };
		
		stack = new Stack( ITEMS.length );
		for(Object item: ITEMS) {
			stack.push(item);
			assertSame( item, stack.peek() );
		}
		for(int k=ITEMS.length-1; k >= 0; k--) {
			assertSame( ITEMS[k], stack.pop() );
		}
		testStackState( stack, 0, ITEMS.length);
	}
	
	/** According to problem spec, if you "push" onto a full stack
	 *  it simply ignores the excess items (kind of makes sense).
	 *  This tests how carefully students adhere to problem specification.
	 */
	@Test(timeout=500)
	public void testPushTooMany() {
		Object [] ITEMS = {
				"foo",
				new Double( Math.random() ),
				new Character('z'),
				new Integer( Integer.MAX_VALUE ),
				new Character('x')
				};
		final int capacity = ITEMS.length - 2;
		
		stack = new Stack( capacity );
		// push everything! Excess should be ignored
		for (int i = 0; i < ITEMS.length; i++) {
			stack.push( ITEMS[i] );
			Object top = (i < capacity)? ITEMS[i] : ITEMS[capacity-1];
			assertSame( top, stack.peek() );
		}
		testStackState( stack, capacity, capacity);
	}
	
	/** Popping an empty stack should throw EmptyStackException. */
	@Test(timeout=500, expected=java.util.EmptyStackException.class)
	public void testPopEmptyStack() {
		stack = new Stack(2);
		stack.push("hello");
		stack.pop();
		stack.pop();
	}

	/** Perform common asserts based on known size and capacity. */
	private void testStackState(Stack<?> stack, int size, int capacity) {
		assertEquals( "size should return "+size, size, stack.size() );
		boolean empty = (size==0);
		assertTrue( "isEmpty should return "+empty, empty == stack.isEmpty() );
		boolean full = (size>=capacity);
		assertTrue( "isFUll should return "+full, full == stack.isFull() );
	}
	
	/**
	 * Run JUnit tests as a stand-alone test suite,
	 * and describe the results.
	 */
	public static void main(String[] args) {
		Class<?> testclass = StackTest.class;
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
