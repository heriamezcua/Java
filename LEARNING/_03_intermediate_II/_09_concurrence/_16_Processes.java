package _03_intermediate_II._09_concurrence;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class _16_Processes {
	public static void main(String[] args) {
		try {
			// 1. Creating a Process
//			ProcessBuilder builder = new ProcessBuilder("ls", "-l"); // For Unix/Linux
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "\\Users\\amezc", "dir"); // For
			// Windows
			builder.directory(new File("\\Users\\amezc"));

			// 2. Redirecting Input, Output, and Error
			builder.redirectOutput(new File("output.txt"));
			builder.redirectError(new File("error.txt"));

			// 3. Modifying Environment Variables
			Map<String, String> env = builder.environment();
			env.put("LANG", "es_ES"); // Set language
			env.remove("JAVA_HOME"); // Remove JAVA_HOME

			// 4. Starting the Process and Reading Output
			Process process = builder.start();

			// 5. Waiting for the Process to Finish
			if (process.waitFor(10, TimeUnit.SECONDS)) {
				System.out.println("Process finished with exit code: " + process.exitValue());
			} else {
				System.out.println("Process timeout, forcibly terminating.");
				process.destroyForcibly();
			}

			// 6. Checking Process Status
			if (process.isAlive()) {
				System.out.println("Process is still running.");
			} else {
				System.out.println("Process has completed.");
			}

			// 7. Handling Process Information
			ProcessHandle handle = process.toHandle();
			System.out.println("Process ID: " + handle.pid());
			handle.info().startInstant().ifPresent(start -> System.out.println("Started at: " + start));
			handle.info().command().ifPresent(cmd -> System.out.println("Command: " + cmd));
			handle.info().user().ifPresent(user -> System.out.println("User: " + user));

			// 8. Listing All System Processes
			System.out.println("Listing all system processes:");
			Stream<ProcessHandle> processes = ProcessHandle.allProcesses();
			processes.forEach(p -> p.info().command().ifPresent(System.out::println));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
