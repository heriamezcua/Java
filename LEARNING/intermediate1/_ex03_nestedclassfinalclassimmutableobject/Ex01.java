package intermediate1._ex03_nestedclassfinalclassimmutableobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a BankAccount class with a nested class Transaction. The Transaction
 * class should store transaction details (amount and type: "deposit" or
 * "withdrawal"). The BankAccount should maintain a list of transactions.
 */
public class Ex01 {

	/**
	 * Represents a bank account that allows deposits and withdrawals. It maintains
	 * a list of transactions performed on the account.
	 */
	public static class BankAccount {
		private double balance;
		private List<Transaction> transactionsList = new ArrayList<>();

		/**
		 * Creates a new bank account with an initial balance of zero.
		 */
		public BankAccount() {
			this.balance = 0;
		}

		/**
		 * Gets the current balance of the bank account.
		 *
		 * @return the current balance
		 */
		public double getBalance() {
			return balance;
		}

		/**
		 * Gets the list of all transactions performed on this bank account.
		 *
		 * @return the list of transactions
		 */
		public List<Transaction> getTransactionsList() {
			return transactionsList;
		}

		/**
		 * Sets a new list of transactions for the bank account.
		 *
		 * @param transactionsList the new list of transactions
		 */
		public void setTransactionsList(List<Transaction> transactionsList) {
			this.transactionsList = transactionsList;
		}

		/**
		 * Performs a transaction on the bank account, either a deposit or a withdrawal.
		 *
		 * @param amount the amount to be deposited or withdrawn
		 * @param type   the type of transaction ("deposit" or "withdrawal")
		 * @return the created transaction
		 * @throws IllegalArgumentException if the transaction type is invalid or if
		 *                                  there are insufficient funds
		 */
		public Transaction performTransaction(double amount, String type) {
			if (!type.equalsIgnoreCase("deposit") && !type.equalsIgnoreCase("withdrawal")) {
				throw new IllegalArgumentException("Invalid transaction type. Use 'deposit' or 'withdrawal'.");
			}

			if (type.equalsIgnoreCase("withdrawal") && amount > balance) {
				throw new IllegalArgumentException("Insufficient funds for withdrawal.");
			}

			// Update balance
			if (type.equalsIgnoreCase("deposit")) {
				balance += amount;
			} else {
				balance -= amount;
			}

			// Create and store transaction
			Transaction transaction = new Transaction(amount, type);
			transactionsList.add(transaction);

			System.out.println("Transaction successful: " + type + " of $" + amount);
			return transaction;
		}

		/**
		 * Returns a string representation of the bank account, including the balance
		 * and transactions.
		 *
		 * @return a string representation of the bank account
		 */
		@Override
		public String toString() {
			return "BankAccount[Balance:" + balance + ", Transactions:" + transactionsList + "]";
		}

		/**
		 * Represents a transaction in a bank account, which can be either a deposit or
		 * a withdrawal.
		 */
		class Transaction {
			private double amount;
			private String type;

			/**
			 * Gets the amount of the transaction.
			 *
			 * @return the transaction amount
			 */
			public double getAmount() {
				return amount;
			}

			/**
			 * Gets the type of the transaction ("deposit" or "withdrawal").
			 *
			 * @return the transaction type
			 */
			public String getType() {
				return type;
			}

			/**
			 * Creates a new transaction with the specified amount and type.
			 *
			 * @param amount the amount of the transaction
			 * @param type   the type of transaction ("deposit" or "withdrawal")
			 */
			public Transaction(double amount, String type) {
				this.amount = amount;
				this.type = new String(type);
			}
		}
	}

	public static void main(String[] args) {
		// Create a BankAccount instance
		BankAccount account = new BankAccount();

		// Perform transactions
		account.performTransaction(200, "deposit"); // Balance should be $700
		account.performTransaction(100, "withdrawal"); // Balance should be $600
		account.performTransaction(50, "deposit"); // Balance should be $650

		// Print transactions and final balance
		System.out.println("\nTransaction History:");
		for (BankAccount.Transaction t : account.getTransactionsList()) {
			System.out.println("Type: " + t.getType() + ", Amount: $" + t.getAmount());
		}

		System.out.println("\nFinal Balance: $" + account.getBalance());
	}

}
