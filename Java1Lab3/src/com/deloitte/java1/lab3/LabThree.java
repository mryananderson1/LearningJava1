package com.deloitte.java1.lab3;
/**
 * 
 * @author matthanderson
 * Java Level 1 Lab 3
 * Allow user to update Savings or Checking Account and display balances
 * 2/10/17
 */
import java.util.Scanner;

public class LabThree 
{
	//Declaring the following Strings as class variables as they are used repeatedly by updateSavings and updateChecking methods
	static String userBalance = "Your Balance is: ";
	static String promptAction = "0: Withdraw, 1: Deposit, 2: Exit";
	static String promptAmount = "Enter a Dollar Amount";
	static String insufficientFunds = "Unable to complete action: Insufficient funds";
	static String promptNonZero = "Unable to complete action: Enter non-negative amount";
	static String invalidEntry = "Invalid Entry - Please Select 0: Withdraw, 1: Deposit, 2: Exit ";
	static String exitMessage = "Goodbye";

	static Scanner scanner = new Scanner(System.in); //allow user to input values to console
	
	public static void main (String args[])
	{
		accountSelection();//call method for user to select their checking or savings account
	}	

	/*
	 * accountSelection prompts user to chose either their checking or savings account
	 * uses if statements to call updateSavings or updateChecking based on user selection
	 * uses try/catch block to throw exception if user enters non-numerical value
	 */
	public static void accountSelection ()
	{
		int accountSelection; //integer for user to select either checking or savings account
		
		//Call printText method and pass strings to print to console
		printText("Welcome to Your Bank!");
		printText("Please Select Your Acccount (0 for Savings, 1 for Checking)");

		try //surrounding block of code with try/catch, display message if non-numerical entry is made
		{
			accountSelection = scanner.nextInt();//sets account selection to user entry in console
			
			//if statement to confirm user is making valid account selection
			if (accountSelection != 0 && accountSelection !=1) //Throw error and prompt user for account selection
			{
				printText("Invalid Selection: Enter 1 for Savings or 0 for Checking");
				accountSelection = scanner.nextInt();
			}
			else if (accountSelection == 1)//Call updatechecking if user enters 1
			{
				updateChecking();//if user has made valid selection, call update checking account method
			}
			else if (accountSelection == 0)//Call updateSavings if user enters 0
			{
				updateSavings();//look at case/switch for this and default
			}
		} 
		catch (Exception e) 
		{
			printText ("User Entered Non-Numerical Value: Program Ended");//Text to display if user enters non-numerical value
			System.exit(0);//closes program
		}
	}

	//method to update checking account user can provide inputs to either deposit or withdraw funds (enter 0 to withdraw, 1 to deposit, 2 to exit)
	public static void updateChecking ()
	{
		double checkingBalance = 10000; //beginning balance of checking account
		double checkingDollarAmt; //will be set to dollar amount entered by user to deposit or withdraw
		int checkingAction; //allow user to chose to either deposit or withdraw
		printText("Welcome to your Checking Account");
		printText(userBalance + checkingBalance);
		printText(promptAction);
		checkingAction = scanner.nextInt();//user enters 0 for withdraw or 1 for deposit
		
		try {
			do
				if (checkingAction == 0)//execute this logic if user enters 0 to withdraw funds
				{
					printText(promptAmount);//prompt user for an amount to withdraw
					checkingDollarAmt = scanner.nextDouble();//set amount to be withdrawn to user input

					if(checkingDollarAmt <= checkingBalance && checkingDollarAmt >= 0)//check that user is not withdrawing more than balance or a negative number
					{
						checkingBalance -= checkingDollarAmt;//reduce checking balance by amount user chose to withdraw
						printText(userBalance + checkingBalance);//display new checking balance
					}
					else if (checkingDollarAmt > checkingBalance)//execute this logic if user tries to withdraw an amount greater than their balance
					{
						printText(insufficientFunds);
					}
					else if (checkingDollarAmt < 0)//do not allow user to withdraw a negative amount, this would be a deposit
					{
						printText(promptNonZero);
					}
					printText(promptAction);
					checkingAction = scanner.nextInt();
				}
				else if (checkingAction == 1)//execute this block of code of user selects 1 to deposit funds
				{
					printText(promptAmount);
					checkingDollarAmt = scanner.nextDouble();

					if(checkingDollarAmt >= 0)//if value is greater than or equal to 0 the amount is added to the existing balance
					{
						checkingBalance += checkingDollarAmt;
						printText(userBalance + checkingBalance);
					}
					else if (checkingDollarAmt < 0)//do not allow negative deposits that would result in user 'withdrawing' money
					{
						printText(promptNonZero);
					}
					printText(promptAction);
					checkingAction = scanner.nextInt();
					
				}
				else if (checkingAction == 2)//end do/while loop if user entered 2 to exit
				{
					break;
				}

				else if (checkingAction != 1 || checkingAction != 2 || checkingAction != 0)//check that number is either 0, 1, or 2
				{
					printText(invalidEntry);
					checkingAction = scanner.nextInt();
				}
			while (checkingAction == 0 || checkingAction == 1 && checkingAction != 2); //do loop is executed as long as user hasn't select 2 to exit
		} 
		catch (Exception e) // catch exceptions and display error message
		{
			printText("You can't do that!");
		}
		printText(exitMessage);
		scanner.close();//close scanner
	}
	
	//method to update saving account user can provide inputs to either deposit or withdraw funds
	public static void updateSavings ()
	{
		double savingsBalance = 1000;//initial savings balance
		int savingsAction;
		printText("Welcome to your Savings Account");
		printText(userBalance + savingsBalance);
		printText(promptAction);
		savingsAction = scanner.nextInt();
		double savingsDollarAmt;
		
		try {
			do //do while loop to allow user to deposit, withdraw, or exit
				if (savingsAction == 0) //code block executed if user select 0 for withdraw
				{
				printText(promptAmount);
				savingsDollarAmt = scanner.nextDouble();

					if(savingsDollarAmt <= savingsBalance && savingsDollarAmt >= 0)//check that user isn't attempting to overdraw or withdraw a negative
					{
						savingsBalance -= savingsDollarAmt;
						printText(userBalance + savingsBalance);
					}
					else if (savingsDollarAmt > savingsBalance)//warn user if they attempt withdraw of greater than balance
					{
						printText(insufficientFunds);
					}
					else if (savingsDollarAmt < 0)//warn user if a negative number is entered
					{
						printText(promptNonZero);
					}
						printText(promptAction);
						savingsAction = scanner.nextInt();
				}
				else if (savingsAction == 1)//what program should do if user selected to deposit to savings
				{
					printText(promptAmount);
					savingsDollarAmt = scanner.nextDouble();

					if(savingsDollarAmt >= 0)//if user entered a positive value add to current balance
					{
						savingsBalance += savingsDollarAmt;
						printText(userBalance + savingsBalance);
					}
					else if (savingsDollarAmt < 0)//do not allow user to deposit negative value
					{
						printText(promptNonZero);
					}
					printText(promptAction);
					savingsAction = scanner.nextInt();
					
				}
				else if (savingsAction == 2)//code if user selects 2 to exit
				{
					break;
				}

				else if (savingsAction != 1 || savingsAction != 2 || savingsAction != 0)//check that user entered valid selection of 0,1, or 2
				{
					printText(invalidEntry);
					savingsAction = scanner.nextInt();
				}
			while (savingsAction == 0 || savingsAction == 1 && savingsAction != 2); //do loop executed as long as user hasn't chosen 2 to exit
		} 
		catch (Exception e) 
		{
			printText("You can't do that!");
		}
		printText(exitMessage);
		scanner.close();//close scanner
	}
	
	//pritText receives string arguments and prints them to the console
	public static void printText (String string)
	{
		System.out.println(string);
	}	
}