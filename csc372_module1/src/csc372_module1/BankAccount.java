/*
Part 1: Implement a superclass BankAccount that has the following fields and methods.

Fields:
	string firstName
	string lastName
	int accountID
	double balance

Methods:  
	constructor() - initialize balance to zero
	deposit() - will accept a single value double parameter;
		the parameter value is added to the existing balance
	withdrawal() - accepts a single value double dollar amount;
		the parameter value is subtracted from the existing balance
	Setters and getters for firstName, lastName, and accountID
	getBalance() - getter to return the balance
	accountSummary() - prints all account information
*/

/*
Assumptions for program:

Bank Account is a superclass that can be used to setup future account types.

There should be no BankAccount objects, only CheckingAccount objects, apart from testing.

Extremely large account balances will cause rounding errors
*/

package csc372_module1;

public class BankAccount {
	protected String firstName;
	protected String lastName;
	protected int accountID;
	protected double balance;
	
	//Test if method is called properly
	public static void printTest() {
		System.out.println("This should print when BankAccount is called");
	}
	
	//Constructor with no arguments
	public BankAccount() {
		firstName = "firstName";
		lastName = "lastName";
		accountID = 99999;
		balance = 0.0;
	}
	
	public void deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
	}
	
	public void withdrawal(double withdrawalAmount) {
		if (this.balance >= withdrawalAmount) {
			this.balance = this.balance - withdrawalAmount;
		} else {
			System.out.println("Account balance too low. Withdrawal denied");
		}
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public double getAccountBalance() {
		return balance;
	}
	
	public void getAccountSummary() {
		System.out.println("Account Summary");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Account ID: " + accountID);
		System.out.printf("Account Balance: $%.2f\n", balance);
	}
	
}
