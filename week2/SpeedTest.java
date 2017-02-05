package stopwatch;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Task file for Stopwatch.
 *
 * The methods perform some common tasks involving strings and doubles,
 * to compare speed of using different data types.
 *
 * This class has a lot of duplicate code!
 * Each task method contains the same code for starting the stopwatch,
 * stopping the stopwatch, printing elapsed time, and describing the task
 * (even though the description of each task is different).
 * 
 * Your job is to separate the code that is the same in each method
 * from the code that is different, and restructure it so that 
 * you can re-use the task-timer code that is the same.
 * 
 * When you get done you should have 7 classes:
 * A TaskTimer class (the reusable code) that can time any task
 * 5 task classes that implement Runnable. Each task has a toString that describes the task.
 * A Main class (application) to run the tasks using TaskTimer.
 * 
 * You can define the 5 task classes in the same source file as
 * the Main class or put them in separate files.
 * To define multiple classes in one source file, only one class
 * is declared "public" and the other classes omit the "public".
 */
public class SpeedTest {
	// size of the array used in floating point tasks.
	// Don't make this too big to avoid slowing down test with paging
	// or possible out-of-memory error.
	static final int ARRAY_SIZE = 500000;
	
	/**
	 * task 1: append chars to a string.
	 */
	public static void testAppendToString(int count) {
		final char CHAR = 'a';
		System.out.printf("Append %,d chars to String\n", count);
		Stopwatch timer = new Stopwatch();
		timer.start();

		String result = ""; 
		int k = 0;
		while(k++ < count) {
			result = result + CHAR;
		}
		System.out.println("final string length = " + result.length());
		
		timer.stop();
		System.out.printf("Elapsed time %.6f sec\n\n", timer.getElapsed());
	}
	
	/**
	 * task 2: append chars to a StringBuilder
	 */
	public static void testAppendToStringBuilder(int count ) {
		final char CHAR = 'a';
		System.out.printf("Append %,d chars to StringBuilder\n", count);
		Stopwatch timer = new Stopwatch();

		timer.start();
		StringBuilder builder = new StringBuilder(); 
		int k = 0;
		while(k++ < count) {
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
	public static void testSumDoublePrimitive(int counter) {
		System.out.printf("Sum array of double primitives with count=%,d\n", counter);
		
		// create array of values to add before we start the timer
		double[] values = new double[ARRAY_SIZE];
		for(int k=0; k<ARRAY_SIZE; k++) values[k] = k+1;
		
        Stopwatch timer = new Stopwatch();
		timer.start();
		double sum = 0.0;
		// count = loop counter, i = array index value
		for(int count=0, i=0; count<counter; count++, i++) {
			if (i >= values.length) i = 0;  // reuse the array when get to last value
			sum = sum + values[i];
		}
		System.out.println("sum = " + sum);
		
		timer.stop();
		System.out.printf("Elapsed time %.8f sec\n\n", timer.getElapsed());
	}
	
	
	/**
	 * task 4: add Double objects from an array.
	 * You need a large counter value to get a measurable time.
	 */
	public static void testSumDouble(int counter) {
		System.out.printf("Sum array of Double objects with count=%,d\n", counter);

		// create array of values to add, before we start the timer
		Double[] values = new Double[ARRAY_SIZE];
		for(int i=0; i<ARRAY_SIZE; i++) values[i] = new Double(i+1);
		Stopwatch timer = new Stopwatch();		
		timer.start();
		Double sum = new Double(0.0);
		// count = loop counter, i = array index
		for(int count=0, i=0; count<counter; count++, i++) {
			if (i >= values.length) i = 0;
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
	public static void testSumBigDecimal(int counter) {
		System.out.printf("Sum array of BigDecimal with count=%,d\n", counter);
		Stopwatch timer = new Stopwatch();
		// create array of values to add, before we start the timer
		BigDecimal[] values = new BigDecimal[ARRAY_SIZE];
		for(int i=0; i<ARRAY_SIZE; i++) values[i] = new BigDecimal(i+1);
		
		timer.start();
		BigDecimal sum = new BigDecimal(0.0);
		for(int count=0, i=0; count<counter; count++, i++) {
			if (i >= values.length) i = 0;
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

		SpeedTest.testAppendToString(50000);
		// same task but with a larger string size (append more chars)
		SpeedTest.testAppendToString(100000);
		// do the same thing using StringBuilder.
		SpeedTest.testAppendToStringBuilder(100000);
		
		// Use a large loop count for floating point tests in order to get accurate times
		int counter = 1000000000; 
		
		SpeedTest.testSumDoublePrimitive(counter);
		SpeedTest.testSumDouble(counter);
		SpeedTest.testSumBigDecimal(counter);
	}
}
