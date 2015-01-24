package stopwatch;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Task file for PA1-StopWatch.  Run this to try out your stopwatch,
 * then divide and rewrite it (Problem 2) to eliminate duplicate code.
 * 
 * This is a collection of common tasks involving strings and doubles,
 * to compare speed of using different data types.
 * 
 * This class has a lot of duplicate code.
 * Your job is to separate the code that is the same in each method
 * from the code that is different, and restructure it so that 
 * you can re-use the task-timer code that is the same.
 * 
 * When you get done you should have 7 classes:
 * A TaskTimer class (the reusable code) that can time any task
 * 5 task classes that implement Runnable
 * A Main class (application) to run the 5 tasks.
 * 
 * You can define the 5 task classes in the same source file as
 * the Main class or put them in separate files.
 * To define multiple classes in one source file, only one class
 * is declared "public" and the other classes omit the "public".
 */
public class SpeedTest {
	// the loop counter used in the tasks (can be changed)
	private int counter = 100000;
	// size of the array used in floating point tasks.
	// Don't make this too big to avoid slowing down test with paging
	// or possible out-of-memory error.
	static final int ARRAY_SIZE = 500000;
	
	/**
	 * Set the loop count used in tests.
	 * @param count is number of loop iterations
	 */
	public void setCounter(int count) { this.counter = count; }
	
	/**
	 * task 1: append chars to a string.
	 */
	public void testAppendToString( ) {
		final char CHAR = 'a';
		System.out.printf("Append to String with count=%,d\n", counter);
		StopWatch timer = new StopWatch();
		timer.start();
		String sum = ""; 
		int k = 0;
		while(k++ < counter) {
			sum = sum + CHAR;
		}
		System.out.println("final string length = " + sum.length());
		
		timer.stop();
		System.out.printf("Elapsed time %.6f sec\n\n", timer.getElapsed());
	}
	
	/**
	 * task 2: append chars to a StringBuilder
	 */
	public void testAppendToStringBuilder( ) {
		final char CHAR = 'a';
		System.out.printf("Append to StringBuilder with count=%,d\n", counter);
		StopWatch timer = new StopWatch();

		timer.start();
		StringBuilder builder = new StringBuilder(); 
		int k = 0;
		while(k++ < counter) {
			builder = builder.append(CHAR);
		}
		// now create a String from the result, to be compatible with task 1.
		String result = builder.toString();
		System.out.println("final string length = " + result.length());
		
		timer.stop();
		System.out.printf("Elapsed time %.6f sec\n\n", timer.getElapsed());
	}
	
	/**
	 * task 3: add double primitives from an array.
	 * You need a large counter value to get a measurable time.
	 */
	public void testSumDoublePrimitive() {
		System.out.printf("Sum array of double primitives with count=%,d\n", counter);
		StopWatch timer = new StopWatch();
		// create array of values to add, before we start the timer
		double[] values = new double[ARRAY_SIZE];
		for(int k=0; k<ARRAY_SIZE; k++) values[k] = k+1;
		
		timer.start();
		double sum = 0.0;
		// count = loop counter, i = array index value
		for(int count=0, i=0; count<counter; count++, i++) {
			if (i >= ARRAY_SIZE) i = 0;
			sum = sum + values[i];
		}
		System.out.println("sum = " + sum);
		
		timer.stop();
		System.out.printf("Elapsed time %.6f sec\n\n", timer.getElapsed());
	}
	
	
	/**
	 * task 4: add Double objects from an array.
	 * You need a large counter value to get a measurable time.
	 */
	public void testSumDouble() {
		System.out.printf("Sum array of Double objects with count=%,d\n", counter);
		StopWatch timer = new StopWatch();
		// create array of values to add, before we start the timer
		Double[] values = new Double[ARRAY_SIZE];
		for(int i=0; i<ARRAY_SIZE; i++) values[i] = new Double(i+1);
		
		timer.start();
		Double sum = new Double(0.0);
		// count = loop counter, i = array index
		for(int count=0, i=0; count<counter; count++, i++) {
			if (i >= ARRAY_SIZE) i = 0;
			sum = sum + values[i];
		}
		System.out.println("sum = " + sum);

		timer.stop();
		System.out.printf("Elapsed time %.6f sec\n\n", timer.getElapsed());
	}
	
	
	/**
	 * task 5: add BigDecimal objects from an array.
	 * You need a large counter value to get a measurable time.
	 */
	public void testSumBigDecimal() {
		System.out.printf("Sum array of BigDecimal with count=%,d\n", counter);
		StopWatch timer = new StopWatch();
		// create array of values to add, before we start the timer
		BigDecimal[] values = new BigDecimal[ARRAY_SIZE];
		for(int i=0; i<ARRAY_SIZE; i++) values[i] = new BigDecimal(i+1);
		
		timer.start();
		BigDecimal sum = new BigDecimal(0.0);
		for(int count=0, i=0; count<counter; count++, i++) {
			if (i >= ARRAY_SIZE) i = 0;
			sum = sum.add( values[i] );
		}
		System.out.println("sum = " + sum);
		
		timer.stop();
		System.out.printf("Elapsed time %.6f sec\n\n", timer.getElapsed());
	}
	
	/**
	 * Run the tasks.
	 */
	public static void main(String[] args) throws IOException {

		SpeedTest tester = new SpeedTest();
		tester.setCounter(100000);
		
		tester.testAppendToString();
		tester.testAppendToStringBuilder();
		
		// Use a bigger loop count for floating point tests in order to get accurate times
		tester.setCounter(100000000); // 100 million
		
		tester.testSumDoublePrimitive();
		tester.testSumDouble();
		tester.testSumBigDecimal();
	}
}
