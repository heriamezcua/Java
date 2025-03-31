package _05_advanced._02_inputoutput;

import java.io.*;

public class _01_WritingReading {

	    public static void main(String[] args) {
	        String fileName = "example.txt";
	        String data = "Hello, this is an example of Input/Output Streams in Java!";

	        // Writing data to a file using FileOutputStream and BufferedOutputStream
	        writeToFile(fileName, data);

	        // Reading data from the file using FileInputStream and BufferedInputStream
	        readFromFile(fileName);
	    }

	    /**
	     * Writes data to a file using FileOutputStream and BufferedOutputStream.
	     *
	     * @param fileName The name of the file.
	     * @param data     The data to write.
	     */
	    private static void writeToFile(String fileName, String data) {
	        try (FileOutputStream fos = new FileOutputStream(fileName);
	             BufferedOutputStream bos = new BufferedOutputStream(fos);
	             DataOutputStream dos = new DataOutputStream(bos)) {

	            // Writing string as bytes
	            dos.writeUTF(data);
	            System.out.println("Data successfully written to " + fileName);

	        } catch (IOException e) {
	            System.err.println("Error writing to file: " + e.getMessage());
	        }
	    }

	    /**
	     * Reads data from a file using FileInputStream and BufferedInputStream.
	     *
	     * @param fileName The name of the file to read from.
	     */
	    private static void readFromFile(String fileName) {
	        try (FileInputStream fis = new FileInputStream(fileName);
	             BufferedInputStream bis = new BufferedInputStream(fis);
	             DataInputStream dis = new DataInputStream(bis)) {

	            // Reading UTF string from file
	            String content = dis.readUTF();
	            System.out.println("Read from file: " + content);

	        } catch (IOException e) {
	            System.err.println("Error reading from file: " + e.getMessage());
	        }
	    }
	}
