## Code Problems in PA2

### 1. Reading and Writing Strings

The application encrypts **characters**.

Which of these two alogithms looks more efficient?

<table>
<tr><th>Algorithm 1</th> <th>Algorithm 2</th>
</tr>
<tr>
<td markdown="span">
```
while moredata:
   read array of char
   encrypt each char
   write array of char
```
</td>
<td markdown="span">
```
while moredata:
   read line as String s
   convert to chars = s.toCharArray()
   encrypt each char
   put the chars into a new String
   append a newline to String
   write string, which requires the
   IO class to extract chars from string
```
</td>
</tr>
</table>

Strings are not only efficient for this problem, they consume lots of memory.

You should not use `StringBuilder` either.  Use char array.

### 2. Even WORSE, Using String concatenation

*Too many* students wrote code like this:

```java
String result = "";
for(int k=0; k<text.length(); k++) {
    char c = text.charAt(k);
    c = // encrypt the character
    result += c;
}
return result;
```
If the file is 1MB, this code will create over 1 million strings.

If each line is 100 chars long, the above code will use memory:
```
2 bytes/char x 10,000 lines x (1 + 2 + 3 + 4 + ... + 100) string copy in loop
    = 50,500,000 bytes of Strings
```

The inefficiency of string catenation was covered in the Stopwatch lab.

There is no excuse for writing bad code like this.  Please pay attention (or maybe consider a different career).

### 3. Still WORSE -- read the entire file into a String

The assignment sheet specifically said not to do this.  Its ridiculous.

```java
// read entire file and return it as a String
String readFile() {
    String line;
    try ( BufferedReader br = new BufferedReader( inputReader ) )
    {
        while( (line = br.readLine()) != null) {
            sb.append(line).append("\n"); // Wrong, too
        }
    }
    return sb.toString();
}
```

If the file is 10MB in UTF-8 encoding and each line is 50 chars,
this will create at least 10MB/50 = 200,000 string, which are unnecessary.
The StringBuilder will have to expand and copy its char array many
times before the loop finishes.

In the encryption method, you will need to create a char array with 10 million elements to extract the chars for encryption.

### 4. Command Line Processing Errors

Many errors.  Most common are:

1. Not checking if enough arguments are present (ArrayIndexOutOfBounds).
2. Not advancing args index variable correctly, so same argument is processed twice.
3. Not checking for invalid arguments.
4. Assuming key is always non-negative.  key can be negative -- `key < 0` **does not** imply mode = "dec".
5. Assuming the key is a small number.  `key` can have any integer value.

Too many students wrote incorrect code like this:
```java
for(int k=0; k<args.length; k++) {
    if (args[k].equals("-alg") {
       algorithm = args[k+1];
   ...

    else if (args[k].equals("-key") {
       key = Integer.parseInt(args[k+1]);
    endif
    // no "else" clause
}
```
This code contains **3 errors**:

1. `args[k+1]` may throw ArrayIndexOutOfBoundsException
2. After using `args[k+1]` as value of an option, it does not increment k, so the next iteration the argument will be used again.  This error is not detected because there is no "else" clause.
3. Does not detect incorrect command line arguments. If user type `-algo` instead of `-alg` it is ignored.

### OK to Throw NumberFormatException

If you wrote this:
```java
int key = Integer.parseInt( keyOption );
```
it will throw exception if keyOption (String) does not contain an int. That's OK.

### X. Long Methods

Long methods are a sign that a method is doing more than one thing.
*Clean Code* and other books recommend writing short methods.

Except for main, your code should not have any method longer than 20 statements.
It only takes about 7 statements for encrypt method and 7 for the decrypt method of each cipher.


### X. Each Class Should Have One Responsibility (No Monolithic Apps)

In good OO design, each class has a single responsibility and methods closely related to that responsbility.  Its called the *Single Responsbility Principle*.

Since Lab 1, all the labs have used 1 class for each distinct unit of work in the application.  

Many students wrote the entire app in a single class named `Crypt`, or misaligned the responsbilities.

It it better to have a class named `UnicodeCipher` that performs both encrypt and decrypt, than to have a class named `Encrypt` that tries to perform encryption for all algorithms, and another class named `Decrypt` to perform decryption for all algorithms.

In the former case, its much easer it add a new algorithm or modify the way you implement an algorithm.

### Better Design

* `Cipher` interface defines methods for each cipher, so we can use polymorphism.
* `AlphabetShiftCipher` performs the "shift" cipher on letter.
* `UnicodeCipher` implements the Unicode shift ciper.
* `CipherFactory` creates a Cipher object for a given cipher name (string).
* `Main` parses the input in a separate method. 

#### Use a Method to Parse Arguments

Its obvious that processing the argument is using a lot of code in main.
So, it should be a separate method.  

Here's one idea:

```java
/** Process command line args and return key-value pairs as a map. */
static Map<String,String> parseArgs(String[] args) {
    Map<String,String> map = new HashMap<>();
    for(int k = 0; k<args.length; k++) {
        String option = args[k];
        switch(option) {
        case "-mode":
        case "-alg":
            // add key - value for one option
            k++;
            if (k >= args.length) error("Missing value after "+option);
            // remove the "-" from option name
            map.put(option.substring(1), args[k]);
            break;
        default:
            error("Unrecognized argument "+option);
        }
     }
     return map;
}
```

## Reduce the code and "if - else" logic in main()

Then in `main()` you can write:

```java
options = parseArgs(args);

if (options.containsKey("alg")) 
    algorithm = options.get("alg");
else
    algorithm = "shift"; // default
```
or more concisely using the `getOrDefault(key,defaultvalue)` method:

```java
options = parseArgs(args);

String algorithm = options.getOrDefault("alg", "shift");

// Now use the factory
Cipher cipher = CipherFactory.createCipher( algorithm );
```

