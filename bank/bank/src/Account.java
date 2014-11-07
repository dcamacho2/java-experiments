package bank;

public class Account {

	public static int NextAcctNo = 1000;
	private int accountNo;
	private double balance;

	public Account() { // constructor
		balance = 0.0;
		accountNo = ++NextAcctNo;
	}

	public void Deposit(double amount) { // method
		balance += amount;
	}

	public void Withdraw(double amount) { // method
		balance -= amount;
	}

	public double getBalance() { // method
		return balance;
	}

	public int getAccountNo() { // method
		return accountNo;
	}

}
