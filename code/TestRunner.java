import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * Run JUnit test suites and print results on the console.
 * TestRunner prints the total number of tests passed and failed,
 * and messages for failed tests.
 * 
 * The main method of this class invokes a JUnit
 * test case (class) and run all its test methods.
 * Write the fully qualified name of the test class to run
 * as argument to runTestSuite( class ).
 * Invoke the method multiple times if you have multiple test classes.
 *
 * Run this as an ordinary Java application (using main method).
 * You will need the JUnit 4 JAR(s) on your classpath.
 * 
 * @author James Brucker
 *
 */
public class TestRunner {

	/**
	 * Run the JUnit tests and display results.
	 * @param args not used
	 */
	public static void main(String[] args) {

		int failures = runTestSuite( stopwatch.StopwatchTest.class );
		
		// exit code indicates success or failure.
		// by convention, a value of 0 means success.
		System.exit(failures);
	}
	
	/**
	 * Run a JUnit test suite and print summary of results.
	 * @param clazz a class object for the JUnit test suite.
	 * @return number of failed tests
	 */
	public static int runTestSuite( Class<?> clazz ) {
		// Print class name first in case it crashes
		String name = clazz.getSimpleName();
		System.out.println("Running "+name);
		Result result = org.junit.runner.JUnitCore.runClasses( clazz );
		int count = result.getRunCount();
		int failed = result.getFailureCount();
		int success = count - failed;
		System.out.printf("%-20.20s   Success: %d  Failures: %d\n",
				clazz.getSimpleName(), success, failed);
		
		// describe the failures
		List<Failure> failures = result.getFailures();
		for(Failure f: failures) {
			Description d = f.getDescription();			
			System.out.println( f.getTestHeader() +": "+ f.getMessage() );
			System.out.println( d.getDisplayName() );
		}
		return failed;
	}
}
