## Questions about Input/Output in Java

Write the full name of these classes, including package. For example, java.io.Reader.

1. What kind of object is System.out? 

2. What class reads bytes from a file?

3. What class reads characters from a file?

4. What I/O class reads characters from a String?

5. What class should we use to check if a file exists, file is readable, or size of the file?

6. We want to read 4 bytes of data starting at a location 100,000 bytes in a file.  What would be the most efficient way?
   * [ ] Use InputStream read() in a loop 100,000 times, then read the 4 bytes.
   * [ ] Use InputStream and read data into an array of byte[100004], use the last 4 bytes.
   * [ ] Use FileReader and read 50,002 characters into an array (each char is 2 bytes).  Extract bytes from the last 2 chars.
   * [ ] Use RandomAccessFile and seek(100000), then read 4 bytes.
   * [ ] Use DataInputStream and seek to byte 100000; then use readByte() to read the bytes.

7. What will be printed if the file "secret.txt" cannot be opened?
   ```java
   try {
       InputStream in = new FileInputStream("secret.txt");
       byte[] data = new byte[16];
       in.read(data);
       return new String(data);
   }
   catch(FileNotFoundException fne) {
       System.out.println("FileNotFoundException occurred");
   }
   catch(IOException ex) {
       System.out.println("IOException occurred");
   }
   ```
   * [ ] "FileNotFoundException occurred"
   * [ ] "IOException occurred"
   * [ ] both of the above
   * [ ] depends on the JVM since both exceptions are possible
   * [ ] code doesn't compile

8. In the above code, what happens if "secret.txt" contains only 6 bytes?
   * [ ] reads 6 bytes and code returns a String of length 6
   * [ ] reads 6 bytes and code returns a String containing nulls at the end
   * [ ] prints "IOException occurred" because not enough bytes to fill array
   * [ ] some other exception

9. We rewrite the code as follows, with a `finally` block to close the input file. 
   ```java
   try {
       FileInputStream in = new FileInputStream("secret.txt");
       byte[] data = new byte[16];
       in.read(data);
       return new String(data);
   }
   catch(IOException ex) {
       System.out.println("IOException occurred");
   }
   finally {
       try { 
           in.close();
       } catch(IOException ioe) { /* ignore it */ }
   }
   ```
   What is the problem with this code?

   * [ ] cannot use try - catch inside a "finally" block.
   * [ ] it won't catch FileNotFoundException.
   * [ ] the reference `in` is not in known inside the "finally" block (scope error).
   * [ ] you cannot have both a "catch" block and "finally" block after "try".


10. Using `System.out.printf("...")` what should you use in the format string to output a platform-specific line-end character?



