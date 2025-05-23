package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Data loader class responsible for reading account data from a text file.
 * Each line in the file should contain: ID, Date, TransactionType, Category, Amount
 */
public class getDataFromTxt {
	private static final Logger LOGGER = Logger.getLogger(getDataFromTxt.class.getName());
	private static final String DEFAULT_FILE_PATH = "MyData.txt";

	public getDataFromTxt() {
		// Default constructor
	}

	/**
	 * Loads account data from the text file into the provided list.
	 * Each line in the file is expected to be in the format: ID,Date,Type,Category,Amount
	 *
	 * @param accountList The list to which account data will be added
	 */
	public void getData(ArrayList<oneAccount> accountList) {
		try (BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				oneAccount record = parseRecord(line);
				if (record != null) {
					accountList.add(record);
				}
			}
			LOGGER.info("Data loaded successfully. Total records: " + accountList.size());
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to read data file: " + DEFAULT_FILE_PATH, e);
			showErrorDialog("File Error", "Unable to read data file. Please check the file path.");
		}
	}

	/**
	 * Parses a single line of text into an oneAccount object.
	 *
	 * @param line The input line to parse
	 * @return An oneAccount object if parsing is successful, null otherwise
	 */
	private oneAccount parseRecord(String line) {
		String[] fields = line.split(",");

		// Validate field count
		if (fields.length != 5) {
			LOGGER.warning("Invalid data format: " + line);
			return null;
		}

		try {
			int id = Integer.parseInt(fields[0].trim());
			int date = Integer.parseInt(fields[1].trim());
			String transactionType = fields[2].trim();
			String category = fields[3].trim();
			double amount = Double.parseDouble(fields[4].trim());

			return new oneAccount(id, date, transactionType, category, amount);
		} catch (NumberFormatException e) {
			LOGGER.log(Level.WARNING, "Failed to parse numeric values in line: " + line, e);
			return null;
		} catch (IllegalArgumentException e) {
			LOGGER.log(Level.WARNING, "Invalid data value: " + line, e);
			return null;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Unexpected error parsing line: " + line, e);
			return null;
		}
	}

	/**
	 * Displays an error dialog to the user.
	 *
	 * @param title The title of the dialog
	 * @param message The error message to display
	 */
	private void showErrorDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
}
