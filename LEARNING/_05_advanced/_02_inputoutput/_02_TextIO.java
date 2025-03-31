package _05_advanced._02_inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class _02_TextIO {

	public static void main(String[] args) {
		String textFile = "text_data.txt";

		// Writing text to a file
		writeTextData(textFile);

		// Reading text from a file using Scanner
		readTextWithScanner(textFile);

		// Reading text using BufferedReader
		readTextWithBufferedReader(textFile);

		// Demonstrating different character encodings
		writeAndReadWithEncoding("utf8_text.txt");
	}

	/**
	 * Writes text data using PrintWriter with UTF-8 encoding.
	 */
	public static void writeTextData(String filename) {
		try (PrintWriter out = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
			out.println("Name|Salary|HireDate");
			out.println("Alice|55000|2022-05-14");
			out.println("Bob|62000|2021-08-21");
			out.println("Charlie|48000|2023-01-10");
			System.out.println("Text data written successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads text data using Scanner and splits records using a delimiter.
	 */
	public static void readTextWithScanner(String filename) {
		try (Scanner scanner = new Scanner(new FileInputStream(filename), StandardCharsets.UTF_8)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split("\\|"); // Splitting using '|'
				System.out.println("Record: " + String.join(", ", tokens));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads text data using BufferedReader.
	 */
	public static void readTextWithBufferedReader(String filename) {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("BufferedReader Read: " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Demonstrates writing and reading text using different encodings.
	 */
	public static void writeAndReadWithEncoding(String filename) {
		// Writing a UTF-8 encoded file
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
			writer.write("José\n");
			writer.write("こんにちは\n"); // Japanese: "Hello"
			writer.write("Привет\n"); // Russian: "Hello"
			writer.write("😊 Unicode Emoji\n");
			System.out.println("UTF-8 text file written successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading the UTF-8 encoded file
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
			String line;
			System.out.println("Reading UTF-8 encoded file:");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
