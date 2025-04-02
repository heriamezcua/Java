package _05_advanced._02_inputoutput;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.zip.CRC32;

public class _06_MemoryMappedFile {

	private static final String FILE_PATH = "testfile.dat";
	private static final int FILE_SIZE = 10 * 1024 * 1024; // 10MB file

	public static void main(String[] args) throws IOException {
		createTestFile(FILE_PATH, FILE_SIZE);

		// Test different file access methods
		System.out.println("Checksum using InputStream: " + checksumInputStream(FILE_PATH));
		System.out.println("Checksum using BufferedInputStream: " + checksumBufferedStream(FILE_PATH));
		System.out.println("Checksum using RandomAccessFile: " + checksumRandomAccessFile(FILE_PATH));
		System.out.println("Checksum using Memory-Mapped File: " + checksumMappedFile(FILE_PATH));
	}

	// Creates a test file filled with random bytes
	private static void createTestFile(String filePath, int size) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(filePath); FileChannel channel = fos.getChannel()) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			for (int i = 0; i < size / 1024; i++) {
				buffer.clear();
				for (int j = 0; j < 1024; j++) {
					buffer.put((byte) (Math.random() * 256));
				}
				buffer.flip();
				channel.write(buffer);
			}
		}
	}

	// Computes checksum using a simple InputStream
	private static long checksumInputStream(String filePath) throws IOException {
		try (InputStream in = new FileInputStream(filePath)) {
			CRC32 crc = new CRC32();
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}

	// Computes checksum using a BufferedInputStream for better performance
	private static long checksumBufferedStream(String filePath) throws IOException {
		try (InputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
			CRC32 crc = new CRC32();
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}

	// Computes checksum using RandomAccessFile (slower than Memory-Mapped File)
	private static long checksumRandomAccessFile(String filePath) throws IOException {
		try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
			CRC32 crc = new CRC32();
			int c;
			while ((c = file.read()) != -1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}

	// Computes checksum using a Memory-Mapped File
	private static long checksumMappedFile(String filePath) throws IOException {
		try (FileChannel channel = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ)) {
			CRC32 crc = new CRC32();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			while (buffer.hasRemaining()) {
				crc.update(buffer.get());
			}
			return crc.getValue();
		}
	}
}
