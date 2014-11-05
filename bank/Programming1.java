package hw1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Programming1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out
				.println("Guide of supported actions: Open (O), Quit (Q), Login(L), Deposit $$$ (D), Withdraw $$$ (W), Balance (B), Terminate (T).");
		System.out.println("When finished enter 'T' to terminate!");
		String userAction = null;
		Account account = null; // current account

		Map<Integer, Account> accounts = new HashMap<Integer, Account>(); // all
																			// created
																			// accounts

		while (true) { // run infinite loop unless terminated
			System.out.print("What would you like to do? ");

			userAction = input.nextLine();

			switch (userAction.toLowerCase()) {
			case "o":
			case "open":
				account = new Account();
				accounts.put(account.getAccountNo(), account);
				System.out.println(account.getAccountNo());
				break;
			case "q":
			case "quit":
				if (account != null) {
					account = null;
					System.out.println("Goodbye");
				} else {
					System.out.println("Hello");
				}
				break;
			case "l":
			case "login":
				System.out.print("Enter account number: ");
				int num = input.nextInt();
				input.nextLine(); // clear the input buffer
				if (accounts.containsKey(num)) {
					account = accounts.get(num); // if num is in database
					System.out.println("Hello");
					// (hashmap), then the
					// object is read
				} else {
					System.out.println("Account does not exist");
				}
				break;
			case "d":
			case "deposit":
				if (account != null) {
					System.out.print("How much would like to deposit? ");
					double depositedAmount = input.nextDouble();
					input.nextLine(); // clear the input buffer
					account.Deposit(depositedAmount);
					System.out
							.println("You have deposited $" + depositedAmount);
				} else {
					System.out.println("You are not logged in!");
				}
				break;
			case "w":
			case "withdraw":
				if (account != null) {
					System.out.print("How much would like to withdraw? ");
					double withdrawnAmount = input.nextDouble();
					input.nextLine(); // clear the input buffer
					account.Withdraw(withdrawnAmount);
					System.out
							.println("You have withdrawn $" + withdrawnAmount);
				} else {
					System.out.println("You are not logged in!");
				}
				break;
			case "b":
			case "balance":
				if (account != null) {
					System.out.println(account.getBalance());
				} else {
					System.out.println("You are not logged in!");
				}
				break;
			case "t":
			case "terminated":
				System.out.println("Terminated");
				System.exit(0); 
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			userAction = null;
		}
	}
}
