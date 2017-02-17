import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a method to read all the words from an input stream
 * and count how many words begin with 'a', 'b', 'c', etc.
 * 
 * @author jim
 *
 */
public class Dictcount {
	static final String FILEURL = "https://bitbucket.org/skeoop/oop/raw/master/dictionary";
//	static final String FILEURL = "file:/tmp/dictionary";
	
	/**
	 * Get an input stream for reading the dictionary.
	 * You should close the inputstream when done reading.
	 * If using Scanner its sufficient to close the Scanner object.
	 * @return an InputStream object or null if no file at the URL.
	 */
	public static InputStream getDictionary() {
		try {
			URL url = new URL(FILEURL);
			InputStream in = url.openStream();
			return in;
		} catch (IOException e) {
			System.err.println("Exception in getDictionary: " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * Read all the words from an input stream and count how many words
	 * start with 'a', 'b', etc.  There is one word per line.
	 * Return the count as a map, with one key for each letter ('a', 'b', ...) 
	 * that actually occurs at the start of one or more words. 
	 * 
	 * @param input an input stream for reading a file containing words, one per line
	 * 
	 * @return a Map containing letter counts. The keys are the letters 'a', 'b',
	 * etc.  The values are the count of words for that letter.
	 * If there are no words for a letter you don't have to put any key in 
	 * the map. Only add keys for letter you actually see.
	 */
	public static Map<Character,Integer> frequencyCount(InputStream input) {
		//TODO write this method
		
		return null;
	}
	
	/**
	 * Print all the key-values in the map. Keys are strings (one-letter)
	 * and values are Integers.
	 * @param map a map of String to Integer
	 */
	public static void printFrequencyCount(Map<Character,Integer> map) {
		// to get all the keys use map.keySet.
		// Since it is a Set and Set in a Collection, you can use a for-each loop.
		for(Character key : map.keySet()) {
			// print the key (string) and value (integer)
		}
	}
	
	/** Main invokes the methods to read dictionary and perform frequency count. */
	public static void main(String[] args) throws IOException {
		InputStream input = getDictionary();
		if (input == null) {
			System.out.println("Couldn't read the file: "+FILEURL);
			System.out.println("Do you have internet access?");
			System.exit(1);
		}
		Map<Character,Integer> count = frequencyCount(input);
		printFrequencyCount(count);
	}
}
