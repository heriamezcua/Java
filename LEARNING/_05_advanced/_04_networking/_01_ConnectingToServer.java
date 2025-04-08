package _05_advanced._04_networking;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class _01_ConnectingToServer {

	public static void main(String[] args) {
		try {
			// 1. Display local and remote IP addresses using InetAddress
			System.out.println("=== InetAddress Demo ===");
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println("Local host: " + localHost.getHostAddress());

			InetAddress[] addresses = InetAddress.getAllByName("time-a.nist.gov");
			for (InetAddress address : addresses) {
				System.out.println("NIST Server IP: " + address.getHostAddress());
			}

			// 2. Connect to the "Daytime Protocol" server (port 13) using a socket
			System.out.println("\n=== Socket to time-a.nist.gov:13 ===");
			try (Socket socket = new Socket("time-a.nist.gov", 13)) {
				Scanner in = new Scanner(socket.getInputStream());
				while (in.hasNextLine()) {
					System.out.println("NIST Time: " + in.nextLine());
				}
			}

			// 3. Set a socket timeout to avoid indefinite blocking
			System.out.println("\n=== Socket with Timeout ===");
			Socket timeoutSocket = new Socket();
			try {
				SocketAddress address = new InetSocketAddress("time-a.nist.gov", 13);
				timeoutSocket.connect(address, 2000); // 2 seconds timeout
				timeoutSocket.setSoTimeout(2000); // Also set read timeout

				Scanner in = new Scanner(timeoutSocket.getInputStream());
				if (in.hasNextLine()) {
					System.out.println("NIST Time with timeout: " + in.nextLine());
				}
			} catch (SocketTimeoutException e) {
				System.out.println("Connection timed out!");
			} finally {
				timeoutSocket.close();
			}

			// 4. Simulate an HTTP request using a raw socket (as with Telnet)
			System.out.println("\n=== HTTP GET with Raw Socket ===");
			try (Socket httpSocket = new Socket("horstmann.com", 80)) {
				PrintWriter out = new PrintWriter(httpSocket.getOutputStream(), true);
				Scanner in = new Scanner(httpSocket.getInputStream());

				// HERE YOU DONT WRITE SYSTEM BECAUSE YOU ARE NOT WRITING IN THE CONSOLE BUT
				// IN THE SOCKET
				
				// Send HTTP GET request (must include Host header for HTTP/1.1)
				out.println("GET / HTTP/1.1");
				out.println("Host: horstmann.com");
				out.println(); // blank line to end the request

				// Read the HTML response
				int lines = 0;
				while (in.hasNextLine() && lines++ < 15) { // print only first 15 lines
					System.out.println(in.nextLine());
				}
			}

		} catch (UnknownHostException e) {
			System.err.println("Unknown host: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("I/O error: " + e.getMessage());
		}
	}
}