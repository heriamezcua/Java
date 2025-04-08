package _05_advanced._04_networking;

import java.io.*;
import java.net.*;
import java.util.*;

public class _02_FullEchoServer {

	// This class starts the server and listens for multiple clients using threads
	public static void main(String[] args) {
		final int PORT = 8189;

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server is listening on port " + PORT);

			int clientId = 1;

			// Infinite loop to accept multiple clients
			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Spawning client handler " + clientId);
				Runnable handler = new EchoClientHandler(clientSocket, clientId);
				new Thread(handler).start();
				clientId++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// Handles each client in a separate thread
class EchoClientHandler implements Runnable {
	private final Socket clientSocket;
	private final int clientId;

	public EchoClientHandler(Socket socket, int clientId) {
		this.clientSocket = socket;
		this.clientId = clientId;
	}

	@Override
	public void run() {
		try (InputStream inStream = clientSocket.getInputStream();
				OutputStream outStream = clientSocket.getOutputStream();
				Scanner in = new Scanner(inStream, "UTF-8");
				PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true)) {
			out.println("Hello Client #" + clientId + "! Enter BYE to exit.");

			boolean done = false;
			while (!done && in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println("Client #" + clientId + " says: " + line);
				out.println("Echo: " + line);

				if (line.trim().equalsIgnoreCase("BYE")) {
					done = true;
				}
			}

		} catch (IOException e) {
			System.err.println("Error handling client #" + clientId);
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close(); // Always close socket when done
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}