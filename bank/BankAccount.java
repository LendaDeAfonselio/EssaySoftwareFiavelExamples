package bank;


public class BankAccount {

	protected final Object lock = new Object();

	private int balance;

	public BankAccount(int initialBalance) {
		if (initialBalance < 0)
			throw new IllegalArgumentException("initial balance must be >= 0");

		balance = initialBalance;
	}

	protected int readBalance() {
		return balance;
	}

	protected void adjustBalance(int adjustment) {
		balance = balance + adjustment;
	}

	public void credit(int amount) {
		if (amount < 0)
			throw new IllegalArgumentException("credit amount must be >= 0");

		synchronized (lock) {
			adjustBalance(amount);
		}
	}

	public void debit(int amount) throws Exception {
		if (amount < 0)
			throw new IllegalArgumentException("debit amount must be >= 0");

		synchronized (lock) {
			if (readBalance() - amount < 0)
				throw new Exception("insufficient funds");
			adjustBalance(-amount);
		}
	}

	public void tax(double taxRate) throws Exception {
		if (taxRate < 0.0 || taxRate > 1.0)
			throw new IllegalArgumentException("tax amount must be >= 0.0 and <= 1.0");

		synchronized (lock) {
			int tax = (int) (taxRate * (double) readBalance());
			adjustBalance(-tax);
		}
	}

	public int getCurrentBalance() {
		synchronized (lock) {
			return readBalance();
		}
	}
}
