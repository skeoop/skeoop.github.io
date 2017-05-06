package io;

import java.io.*;

public class FileUtil {

	public static File copy(File source, File destination) throws IOException {
		if (source == null || destination == null) throw new IllegalArgumentException("Files may not be null");
		if (! source.exists() ) throw new IllegalArgumentException( "Source file doesn't exist.");
		if (! source.isFile() ) throw new IllegalArgumentException( "source must be a regular file" );
		
		InputStream in = new FileInputStream(source);
		OutputStream out = new FileOutputStream(destination);
		int c;
		while ((c=in.read()) >= 0) out.write(c);
		out.close();
		in.close();
		return destination;
	}
	

	public static File bulkcopy(File source, File destination) throws IOException {
		if (source == null || destination == null) throw new IllegalArgumentException("Files may not be null");
		if (! source.exists() ) throw new IllegalArgumentException( "Source file doesn't exist.");
		if (! source.isFile() ) throw new IllegalArgumentException( "source must be a regular file" );
		
		InputStream in = new FileInputStream(source);
		OutputStream out = new FileOutputStream(destination);
		byte[] buf = new byte[1024*1024];
		int size = 0;
		while ( (size = in.read(buf)) > 0 ) out.write(buf, 0, size);
		out.close();
		in.close();
		return destination;
	}
	
	public static File copy(String source, String destination) throws IOException {
		return bulkcopy(new File(source), new File(destination));
	}
	
	public static void main(String[] args) throws IOException {
		long start = time();
		
		File dest = copy( "/home/jim/Pictures/Plants/Ratchapruek3.jpg", "/tmp/Ratchapruek.jpg" );
		long stop = time();
		System.out.printf("Copied %,d bytes in %.6f sec\n", dest.length(), elapsed(start,stop));
	}
	
	public static long time() {
		return System.nanoTime();
	}
	
	public static double elapsed(long start, long stop) {
		return 1.0E-9*Math.abs(stop - start);
	}
}
