package _03_intermediate_II._09_concurrence;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class _15_GUIThreads {
	private JFrame frame;
	private JTextArea textArea;
	private JLabel statusLabel;
	private JButton openButton;

	public _15_GUIThreads() {
		// Create the main frame
		frame = new JFrame("File Reader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		// Create UI components
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		statusLabel = new JLabel("Status: Waiting");
		openButton = new JButton("Open File");

		// Layout
		frame.setLayout(new BorderLayout());
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(statusLabel, BorderLayout.SOUTH);
		frame.add(openButton, BorderLayout.NORTH);

		// Add event listener to open file button
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					readFileInBackground(file);
				}
			}
		});

		frame.setVisible(true);
	}

	private void readFileInBackground(File file) {
		// Disable the button while reading
		openButton.setEnabled(false);
		statusLabel.setText("Reading...");

		// Create and execute a SwingWorker task
		SwingWorker<StringBuilder, String> worker = new SwingWorker<>() {
			private StringBuilder text = new StringBuilder();

			@Override
			protected StringBuilder doInBackground() throws Exception {
				try (Scanner scanner = new Scanner(new FileInputStream(file), StandardCharsets.UTF_8)) {
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						text.append(line).append("\n");
						publish(line); // Send progress to UI thread
					}
				}
				return text;
			}

			@Override
			protected void process(List<String> chunks) {
				// Update UI with the latest lines read
				for (String line : chunks) {
					textArea.append(line + "\n");
				}
			}

			@Override
			protected void done() {
				try {
					// Get final result and update UI
					textArea.setText(get().toString());
					statusLabel.setText("Done");
				} catch (InterruptedException | ExecutionException ex) {
					statusLabel.setText("Error: " + ex.getCause());
				}
				openButton.setEnabled(true);
			}
		};

		worker.execute(); // Start background task
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(_15_GUIThreads::new);
	}
}
