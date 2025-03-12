package _03_intermediate_II._03_logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {

	// New logger (by class name)
	private static final Logger myLogger = Logger.getLogger(Logging.class.getName());

	// New logger (by hierarchical)
	private static final Logger myLogger2 = Logger.getLogger("com.mycompany.myapp");

	public static void main(String[] args) {

		// global log
		Logger.getGlobal().info("some info you want to log");

		// basic log
		myLogger.info("my logger info message");

		// logging levels
		myLogger.setLevel(Level.SEVERE);
		myLogger.setLevel(Level.WARNING);
		myLogger.setLevel(Level.INFO);
		myLogger.setLevel(Level.CONFIG);
		myLogger.setLevel(Level.FINE);
		myLogger.setLevel(Level.FINER);

		// special levels
		myLogger.setLevel(Level.ALL);
		myLogger.setLevel(Level.OFF);

		// methods associated to levels
		myLogger2.warning("This is a level warning message");
		myLogger2.fine("This is a level fine message");

		// or you can use the global
		myLogger2.log(Level.FINE, "This is a level fine message");

		//
		// advanced methods for logging

		myLogger.logp(Level.FINE, "ClassName", "methodName", "Message");

		// when enter a method
		myLogger.entering("ClassName", "methodName", new Object[] { param1, param2 });

		// when exits a method
		myLogger.exiting("ClassName", "methodName", result);

		// register unexpected exceptions
		myLogger.throwing("ClassName", "methodName", exception);

		// register an exception
		myLogger2.log(Level.FINE, "This is a level fine message", new Exception());

		//
		// code to redirect the logs to a file without manual config
		if (System.getProperty("java.util.logging.config.class") == null
				&& System.getProperty("java.util.logging.config.file") == null) {
			try {
				Logger.getLogger("").setLevel(Level.ALL);
				final int LOG_ROTATION_COUNT = 10;
				var handler = new FileHandler("%h/myapp.log", 0, LOG_ROTATION_COUNT);
				Logger.getLogger("").addHandler(handler);
			} catch (IOException e) {
				myLogger.log(Level.SEVERE, "Can't create log file handler", e);
			}
		}

	}

}
