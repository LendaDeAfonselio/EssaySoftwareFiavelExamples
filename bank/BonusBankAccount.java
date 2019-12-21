package bank;

public class BonusBankAccount extends BankAccount {

	private final int bonus;

	public BonusBankAccount(int initialBalance, int bonus) {
		super(initialBalance);

		if (bonus < 0)
			throw new IllegalArgumentException("bonus must be >= 0");

		this.bonus = bonus;
	}

	public void applyBonus() {
		adjustBalance(bonus);
	}
}