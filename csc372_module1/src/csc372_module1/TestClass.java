package csc372_module1;

public class TestClass {
	public static void main (String[] args) {
		//Testing method call section
		System.out.println("This is the main method testing");
		BankAccount.printTest();
		CheckingAccount.printTest();
		System.out.println("");
		
		//Testing on a new bank account bankAccount1
		//This is purely for testing, there should be no BankAccount objects, only CheckingAccount
		BankAccount bankAccount1 = new BankAccount();	//Initialize a "blank" account
		bankAccount1.getAccountSummary();				//Print summary of blank account
		System.out.println("");
		
		bankAccount1.setFirstName("Firs1");				//Set first name to "First1"
		bankAccount1.setLastName("Last1");				//Set last name to "Last1"
		bankAccount1.setAccountID(10001);				//Set account number to 10001
		bankAccount1.deposit(100.5);					//Deposit $100.50 into account
		bankAccount1.deposit(50.5);						//Deposit $50.50 into account, balance should be $151.00
		bankAccount1.withdrawal(50);					//Withdrawal $50, balance should be $101.00
		bankAccount1.getAccountSummary();				//Print summary of bank account
		System.out.println("");
		
		//Testing on a new checking account checkingAccount1
		CheckingAccount checkingAccount1 = new CheckingAccount();	//Initialize a new "blank" Checking Account
		checkingAccount1.displayAccount();				//Display summary of new blank account
		System.out.println("");
		
		checkingAccount1.setFirstName("First2");		//Set first name to "First2"
		checkingAccount1.setLastName("Last2");			//Set last name to "Last2"
		checkingAccount1.setAccountID(12345);			//Set account number to 12345
		checkingAccount1.deposit(1000);					//Deposit $1000 into checking
		checkingAccount1.withdrawal(100);				//Withdrawal $100, new balance should be $900.00
		checkingAccount1.setInterestRate(.015);			//Set interest rate to 1.50%
		checkingAccount1.displayAccount();
		System.out.println("");
		
		//Testing what if bank account balance is too low for withdrawal
		checkingAccount1.withdrawal(1000);					//Should print low account balance and update balance to negative
		System.out.println("");

		//Checking to ensure multiple "first" names is okay
		checkingAccount1.setFirstName("This name has multiple First Names");
		System.out.println(checkingAccount1.getFirstName());
		System.out.println("");
		
		//Checking to ensure multiple "first" names is okay
		checkingAccount1.setLastName("Multiple Last Names");
		System.out.println(checkingAccount1.getLastName());
		System.out.println("");
		
		CheckingAccount checkingAccount2 = new CheckingAccount();
		
		//Testing extremely large unrealistic deposit/withdrawal amount
		checkingAccount2.deposit(9007199254740992.0);		//Approximate max value before rounding errors 9,007,199,254,740,992
		System.out.println(checkingAccount2.getAccountBalance());
		checkingAccount2.withdrawal(9000000000000000.0);
		System.out.println(checkingAccount2.getAccountBalance());
		checkingAccount2.withdrawal(7199254740990.0);		//This should leave a balance of $2 remaining
		System.out.println(checkingAccount2.getAccountBalance());
		System.out.println("");
		checkingAccount2.displayAccount();
		
	}
}
