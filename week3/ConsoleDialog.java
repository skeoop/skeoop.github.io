package coinpurse;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.*;

/** 
 * User Interface for a Coin Purse that accepts
 * Coin, Coupon, and BankNote objects. 
 * To compile this, you need
 * Coin with a Coin(double value) constructor
 * BankNote with a BankNote(int value) constructor
 * Coupon with a Coupon(String color) constructor
 */
public class ConsoleDialog {

    // create a java.util.Scanner object for use in all methods
    private static Scanner console = new Scanner( System.in );
    private static String currency = "Baht";
    // list of known colors, to prevent errors
    private static Set<String> colors;
    
    private Purse purse;

    /** initialize list of colors */
    static {
        //TODO it would be better to get the known colors from
        // the coupon class.
        colors = new HashSet<String>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
    }
    
    /** 
     * Initialize a new user interface.
     * @param purse is the Purse to communicate with.
     */
    public ConsoleDialog(Purse purse) {
        this.purse = purse;
    }
    
    /** run the user interface */
    public void run() {

        while( true ) {
            System.out.println("Purse contains "+purse.getBalance()+" "+currency);
            if ( purse.isFull() ) System.out.println("Purse is FULL.");

            // print a list of choices
            System.out.print( 
              "\nPlease enter d (deposit), w (withdraw), p (print), or q (quit): ");
            String choice = console.next();
            String args = console.nextLine().trim();
 //TODO what if user inputs uppercase "D" or "W"?  Fix this.
            if ( choice.equalsIgnoreCase("d") ) 
                    depositDialog(args);
            else if ( choice.equalsIgnoreCase("w") ) 
                    withdrawDialog(args);
            else if ( choice.equalsIgnoreCase("p") )
                    printDialog();
            else if ( choice.equalsIgnoreCase("q") ) 
                    break; // leave the loop
            else 
                    System.out.println( "\""+choice+"\" is not a valid choice.");
        }
        // confirm that we are quitting
        System.out.printf("Goodbye. The bank keeps %d %s\n", purse.getBalance(),currency);
    }

    /** 
     *  Ask the user what money to deposit, then deposit them.
     *  Show result of success or failure.
     */
    public void depositDialog(String args) {
        if (args.length() == 0) {
            System.out.print("Enter the values to deposit [eg: 5 blue 100]: ");
            args = console.nextLine();
        }
        // parse the input line into numbers
        Scanner scanline = new Scanner(args);
        Valuable money = null;
        while( scanline.hasNext() ) {
           
            //TODO this code is messy and depends on what kind
            // of Coins, BankNotes, Coupons we should create.
            // Move this code to MoneyFactory and call
            // MoneyFactory.getInstance().makeMoney(String)
            // to create a Valuable.
            
           
            if (scanline.hasNextDouble() ) {
                // create a coin or banknote
                double value = scanline.nextDouble();
                if (value < 20) money = new Coin(value);
                else money = new BankNote((int)value);
            }
            else {
                // treat it as color of coupon
                String name = scanline.next().toLowerCase();
                if (colors.contains(name)) money = new Coupon(name);
                else {
                    System.out.println("unrecognized currency: "+name);
                    continue;
                }
            }
            System.out.printf("Deposit %s... ", money.toString() );
            boolean ok = purse.insert(money);
            System.out.println( (ok? "ok" : "FAILED") );
        }
    }
    
    /** 
     *  Ask how much money to withdraw and then do it.
     *  After withdraw, show the values of the coins we withdrew.
     */
    public void withdrawDialog(String args) {
        if (args.length() == 0) {
            System.out.print("How much to withdraw? ");
            args = console.nextLine();
        }
        Scanner scanline = new Scanner(args);
        if ( scanline.hasNextInt() ) {
             double amount = scanline.nextInt( );
             Object [] array = purse.withdraw(amount);
             if ( array == null ) 
                System.out.printf("Sorry, couldn't withdraw %f Baht\n", amount);
             else {
                System.out.print("You withdrew:");
                String space = " ";
                for(int k=0; k<array.length; k++) {
                    System.out.print(space + array[k].toString());
                }
                System.out.println();
            }
        }
        else System.out.printf("Invalid amount." );
    }

    /**
     * print contents of purse.
     */
    public void printDialog() {
        System.out.println( purse.toString() );
    }

    /**
     * Save purse state to a file using serialization.
     * @param purse is  the Purse to save
     * @param filename is the output file. Contents will be overwritten.
     */
    public static void savePurse(Purse purse, String filename) {
        FileOutputStream out = null;
        try { 
            out = new FileOutputStream(filename);
            ObjectOutputStream xout = new ObjectOutputStream(out);
            xout.writeObject(purse);
            xout.flush();
            System.out.println("Purse saved to "+filename);
        } catch (IOException ioe) {
            System.out.println( "Error saving purse: "+ ioe.getMessage() );
        } finally {
            if (out != null) try { out.close(); } catch(IOException ex) { /* ignore */ }
        }
    }
    
    
    public static Purse loadPurse(String filename) {
        Purse purse = null;
        InputStream in = null;
        try { 
            File file = new File(filename);
            if (! file.exists() ) return null;
            in = new FileInputStream(file);
            ObjectInputStream xin = new ObjectInputStream(in);
            Object obj = xin.readObject();
            if (obj instanceof Purse) purse =  (Purse)obj;
            else System.out.println(filename+" contains a "+obj.getClass().getName());
        } catch (IOException ioe) {
            System.out.println( "Error loading purse: "+ ioe.getMessage() );
        } catch (ClassNotFoundException cne) {
            System.out.println( filename+" contains unrecognized object data. ClassNotFoundException.");
        } finally {
            if (in != null) try { in.close(); } catch(IOException ex) { /* ignore */ }
        }
        return purse;
    }
    
    
    public static void main(String [] args) {
        System.out.println("Purse by Ralph Lauren.");
        Purse purse = loadPurse("purse.dat");
        if (purse == null) purse = new Purse(20);
        ConsoleDialog console = new ConsoleDialog(purse);
        console.run();
        savePurse(purse, "purse.dat");
    }
}

/**
 * Encapsulate operation of creating money objects.
 */
class MoneyFactory {
    private static MoneyFactory instance = new MoneyFactory();
    
    private MoneyFactory() {
    }
    
    /** Get the money factory instance. */
    public static MoneyFactory getInstance() { return instance; }

    /**
     * Return a money object that represents the value
     * of the String parameter.
     * @param amount is amount of money or some description, e.g. "red" for coupon
     * @return Valuable object for the amount.
     * What should you return if the parameter isn't valid?
     * For example, "purple" or "17"?
     */
    public Valuable makeMoney(String amount) {
        
        // not implemented yet
        return null;
        
    }
}
