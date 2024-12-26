package intermediate2._01_exceptions;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedAndUnchecked {

	public static void main(String[] args) throws Exception {

		//
		// 2 types of exception Unchecked (inherit from Error and RuntimeExceptio) and
		// Checked, all the others

		// Checked exception handling
		try {
			connectToDatabase("jdbc:mysql://localhost:3306/mydb", "root", "password");
		} catch (SQLException e) {
			System.out.println("Error al intentar conectarse a la base de datos: " + e.getMessage());
		}

		// Unchecked Exception handling
		try {
			int result = divide(10, 0); // this throw an ArithmeticException
			System.out.println("Result: " + result);
		} catch (ArithmeticException e) {
			System.out.println("Error: You can't divide by 0.");
		}

		//
		// Throwing and exception
		try {
			// you can put an error message in the params
			throw new EOFException("You have thrown an EOFException");
		} catch (EOFException e) {
			System.out.println("You have thrown an Exception");
		}

		//
		// Try-catch block
		String filename = "nombre_fichero";
		try {
			FileInputStream in = new FileInputStream(filename);
			int b;
			while ((b = in.read()) != -1) {
			}
			// catch always from specific to general
		} catch (IOException exception) {
			exception.printStackTrace(); // Mostrar información del error
		} catch (Exception exception) {
			exception.printStackTrace(); // Mostrar información del error
		}

		//
		// you can write multiple catch with | from java 7
		filename = "file_name";
		try {
			FileInputStream in = new FileInputStream(filename);

			if (filename.equals("file_name")) {
				throw new UnknownHostException("Host not found.");
			}

			// catch always from specific to general
		} catch (FileNotFoundException | UnknownHostException e) {
			e.printStackTrace(); // show error info
		}

		//
		// Throwing an exception with a high level
		try {
			// Code that can throw an SQLException
			connectToDatabase("jdbc:mysql://localhost:3306/mydb", "root", "password");
		} catch (SQLException e) {
			// Rethrow as Exception
			throw new Exception("Error en la base de datos: " + e.getMessage());
		}

		//
		// Exception chaining
		try {
			connectToDatabase("jdbc:mysql://localhost:3306/mydb", "root", "password");
		} catch (SQLException original) {

			// Create a superior exception and chaining to the original as it cause
			var e = new Exception("Error en la base de datos");
			e.initCause(original); // Chaining to the original
			throw e;
		}

		//
		// Recover an original exception (getCause method)
		try {
			connectToDatabase("jdbc:mysql://localhost:3306/mydb", "root", "password");
		} catch (SQLException e) {
			Throwable original = e.getCause();
			System.out.println("Original cause: " + original);
		}

		//
		// Finally block
		InputStream in = new FileInputStream("archivo.txt");

		try {
			// Code that could throw an exception
			int data = in.read();
		} catch (IOException e) {
			// Exception handling
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} finally {
			// Close the resource
			in.close();
		}

		//
		// finally without catch
		try {
			int data = in.read();
		} finally {
			// Close the resource
			in.close();
		}

		//
		// Stack trace
		Throwable t = new Throwable();
		t.printStackTrace();

		// If you need to process it
		Throwable t2 = new Throwable();
		StringWriter out = new StringWriter(); // Catch the text
		t.printStackTrace(new PrintWriter(out));
		String description = out.toString(); // Stack trace as text
	}

	// Checked exception example
	public static void connectToDatabase(String dbUrl, String username, String password) throws SQLException {
		// try to connect to a database. This could throw a checked SQLException
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		System.out.println("Conexión exitosa a la base de datos.");
		connection.close();
	}

	// Unchecked Exception example (inherit from Error or RuntimeException)
	public static int divide(int a, int b) {
		// could throw ArithmeticException (Unchecked Exception) if b = 0
		return a / b;
	}

}
