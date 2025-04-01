package _05_advanced._02_inputoutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class _05_FileOperations {

	public static void main(String[] args) {
		try {
			// Define paths
			Path baseDir = Paths.get("testDir");
			Path filePath = baseDir.resolve("example.txt");
			Path copyPath = baseDir.resolve("copy_example.txt");
			Path movePath = baseDir.resolve("moved_example.txt");
			Path tempFile = Files.createTempFile(baseDir, "temp", ".txt");

			// Create directory
			createDirectory(baseDir);

			// File operations
			createAndWriteFile(filePath, "Hello, world!\nThis is a test file.");
			readFile(filePath);
			copyFile(filePath, copyPath);
			moveFile(copyPath, movePath);

			// Path operations
			demonstratePathOperations(filePath, baseDir);

			// Traverse directory
			traverseDirectory(baseDir);

			// Delete files and directory
			deleteFile(movePath);
			deleteFile(filePath);
			deleteFile(tempFile);
			deleteDirectory(baseDir);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Create a directory
	private static void createDirectory(Path path) throws IOException {
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			System.out.println("Directory created: " + path.toAbsolutePath());
		} else {
			System.out.println("Directory already exists: " + path);
		}
	}

	// Create and write to a file
	private static void createAndWriteFile(Path path, String content) throws IOException {
		Files.write(path, content.getBytes(StandardCharsets.UTF_8));
		System.out.println("File created and written: " + path);
	}

	// Read file content
	private static void readFile(Path path) throws IOException {
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		System.out.println("File content:");
		lines.forEach(System.out::println);
	}

	// Copy a file
	private static void copyFile(Path source, Path destination) throws IOException {
		Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("File copied to: " + destination);
	}

	// Move a file
	private static void moveFile(Path source, Path destination) throws IOException {
		Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("File moved to: " + destination);
	}

	// Demonstrate path operations
	private static void demonstratePathOperations(Path filePath, Path baseDir) {
		System.out.println("\nPath Operations:");
		System.out.println("Absolute Path: " + filePath.toAbsolutePath());
		System.out.println("Parent Directory: " + filePath.getParent());
		System.out.println("File Name: " + filePath.getFileName());
		Path relativePath = Paths.get("subdir", "file.txt");
		Path resolvedPath = baseDir.resolve(relativePath);
		System.out.println("Resolved Path: " + resolvedPath);
		System.out.println("Normalized Path: " + resolvedPath.normalize());
	}

	// Traverse a directory
	private static void traverseDirectory(Path dirPath) throws IOException {
		System.out.println("\nTraversing directory: " + dirPath);
		try (Stream<Path> stream = Files.list(dirPath)) {
			stream.forEach(System.out::println);
		}
	}

	// Delete a file
	private static void deleteFile(Path path) throws IOException {
		if (Files.exists(path)) {
			Files.delete(path);
			System.out.println("File deleted: " + path);
		} else {
			System.out.println("File not found: " + path);
		}
	}

	// Delete a directory
	private static void deleteDirectory(Path path) throws IOException {
		if (Files.exists(path)) {
			Files.delete(path);
			System.out.println("Directory deleted: " + path);
		}
	}
}
