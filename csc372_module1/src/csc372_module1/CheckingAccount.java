/*
Part 2: Implement a CheckingAccount class that inherits from the BankAccount class, that: 
	Has an interest rate attribute
	Allows overdraft withdrawals and charges a $30 fee
	
Methods:
	processWithdrawal() - will display a negative balance that includes a $30 overdraft fee and
		denotes that a fee has been assessed
	displayAccount() - should display all superclass attributes and provide an additional interest rate
*/

package csc372_module1;

public class CheckingAccount extends BankAccount {
	private double interestRate;
	private int overdraftFee = 30;
	
	//Test if method is called properly
	public static void printTest() {
		System.out.println("This should print when CheckingAccount is called");
	}
	
	//Constructor with no arguments
	public CheckingAccount() {
		interestRate = 0.0;
	}
	
	public void setInterestRate(double interestRateAmount) {
		this.interestRate = interestRateAmount;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	@Override
	public void withdrawal(double withdrawalAmount){
		if (this.balance >= withdrawalAmount) {
			this.balance = this.balance - withdrawalAmount;
		} else {
			processWithdrawal(withdrawalAmount);
		}
	}
	
	public void processWithdrawal(double withdrawalAmount) {
		System.out.println("Overdraft fee of $" + overdraftFee + " applied.");
		this.balance = this.balance - withdrawalAmount;
		System.out.printf("Account Balance: $%.2f\n", balance);
	}
	
	public void displayAccount() {
		getAccountSummary();
		System.out.print("Interest Rate: ");
		System.out.printf("%.3f", interestRate*100);
		System.out.println("%");
	}
}
