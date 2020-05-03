
public class SavingsAccount extends BankAccount {

	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * @return the savingsNumber
	 */
	public int getSavingsNumber() {
		return savingsNumber;
	}

	/**
	 * @param savingsNumber the savingsNumber to set
	 */
	public void setSavingsNumber(int savingsNumber) {
		this.savingsNumber = savingsNumber;
	}

	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	public SavingsAccount(SavingsAccount original, double amount) {
		super(original, amount);
		savingsNumber = original.getSavingsNumber() + 1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	public void postInterest() {
		deposit((getBalance() * rate) / 12);
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

}
