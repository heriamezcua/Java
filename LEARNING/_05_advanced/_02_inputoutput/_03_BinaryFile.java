package _05_advanced._02_inputoutput;

import java.io.*;
import java.util.zip.*;

public class _03_BinaryFile {

	    public static void main(String[] args) {
	        String binaryFile = "data.bin";
	        String zipFile = "data.zip";

	        // Writing binary data
	        writeBinaryData(binaryFile);

	        // Reading binary data
	        readBinaryData(binaryFile);

	        // Working with RandomAccessFile
	        randomAccessFileDemo(binaryFile);

	        // Creating and extracting a ZIP file
	        createZipFile(binaryFile, zipFile);
	        extractZipFile(zipFile);
	    }

	    /**
	     * Writes different data types to a binary file using DataOutputStream.
	     */
	    public static void writeBinaryData(String filename) {
	        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
	            dos.writeInt(42);
	            dos.writeDouble(3.14159);
	            dos.writeBoolean(true);
	            dos.writeUTF("Hello, binary world!");

	            System.out.println("Binary data written successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Reads the binary data from the file using DataInputStream.
	     */
	    public static void readBinaryData(String filename) {
	        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
	            int intValue = dis.readInt();
	            double doubleValue = dis.readDouble();
	            boolean boolValue = dis.readBoolean();
	            String stringValue = dis.readUTF();

	            System.out.println("Read from binary file:");
	            System.out.println("Integer: " + intValue);
	            System.out.println("Double: " + doubleValue);
	            System.out.println("Boolean: " + boolValue);
	            System.out.println("String: " + stringValue);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Demonstrates RandomAccessFile by seeking and modifying data at specific positions.
	     */
	    public static void randomAccessFileDemo(String filename) {
	        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
	            System.out.println("Initial File Length: " + raf.length());

	            // Seek to the position of the double (4 bytes after the integer)
	            raf.seek(4);
	            double modifiedValue = 2.71828;
	            raf.writeDouble(modifiedValue);

	            // Verify modification
	            raf.seek(4);
	            double newValue = raf.readDouble();
	            System.out.println("Modified Double Value: " + newValue);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Creates a ZIP file containing the specified file.
	     */
	    public static void createZipFile(String sourceFile, String zipFile) {
	        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
	             FileInputStream fis = new FileInputStream(sourceFile)) {
	            
	            ZipEntry zipEntry = new ZipEntry(sourceFile);
	            zos.putNextEntry(zipEntry);

	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) > 0) {
	                zos.write(buffer, 0, bytesRead);
	            }

	            zos.closeEntry();
	            System.out.println("ZIP file created successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Extracts a ZIP file and reads its contents.
	     */
	    public static void extractZipFile(String zipFile) {
	        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
	            ZipEntry entry;
	            while ((entry = zis.getNextEntry()) != null) {
	                System.out.println("Extracting: " + entry.getName());

	                // Reading content (not saving to disk in this demo)
	                byte[] buffer = new byte[1024];
	                int bytesRead;
	                while ((bytesRead = zis.read(buffer)) > 0) {
	                    System.out.write(buffer, 0, bytesRead);
	                }

	                zis.closeEntry();
	                System.out.println("\nExtraction completed.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
