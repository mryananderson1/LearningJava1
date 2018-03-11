/**
	Credit Card Validator
	Utilizes the 'Luhn Check' to Determine if a Credit Card is a valid
	credit card number. The 'Luhn Check' looks to see if the sum of the odd
	numbers plus the sum of the even numbers (doubled) is divisible by 10.

	@author  Michael Anderson
	@date    3/5/2018
	@class   CSC 120 
	@Desc	 CreditCardValidator
*/
import java.util.Scanner;
public class CreditCardValidatorAndersonMichael {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String card = "4847352989263094"; Was used as test value, before implementing user input

		// When you are finished writing the methods below,
		// uncomment the three lines below to test.
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Credit Card Number: ");
		String cardNumber = input.nextLine();
		input.close(); //Practice closing scanner

		// Should say "Visa"
		System.out.println("This card was issued by: " + getCompany(cardNumber));
		// Should say "5"
		getDigit(5); // will print 5
		// Should say "7"
		getDigit(55); //will print 10
		sumOfDoubleEvenPlace(cardNumber);
		sumOfOddPlace(cardNumber); 
		int oddNum = 1;
		int evenNum = 2;
		String cardNum = null;
		System.out.print("Is the card valid: " + isValid(oddNum, evenNum, cardNum)); 

		
		if ( isValid(oddNum, evenNum, cardNum) ) {
			// If True, display the company and state it is valid
		} else {
			// If False, state the card number is invalid
		}
	}

	// Problem 1 ==================================================================
	/** 
		Return the company of the card by looking at the character
		at the zero (0) index of number.

		@param number: A 13 to 16 digit String of numbers

		@returns a String that is either 
		"Visa", "Master Card", "American Express", or "Discover Card"
	*/
	public static String getCompany(String number){
		String cardNum = number.substring(0, 1);
		int cardValue = Integer.parseInt(cardNum);
		String company;
		
		if (cardValue == 4)
		{
			company = "Visa";
			return company;
		} 
		else if (cardValue == 5) 
		{
			company = "Master Card";
			return company;
		} 
		else if (cardValue == 6) 
		{
			company = "Discover Card";
			return company;
		} 
		else if (cardValue == 3 && cardValue + 1 == 7);
		{
			company = "American Express";
			return company;
		}
}
	
	// Problem 2 ==================================================================
	/** 
		Return this number if it is a single digit, otherwise, return the sum 
		of the two digits. For example, 18 will return 9 (because 1 + 8).

		@param number: a digit that will be between 0 and 18

		@returns an integer
	*/
	public static void getDigit(int number){

		if (number < 10 ) 
		{
			System.out.println(number);
		} else 
		{
		String digitString = Integer.toString(number);
		String digitOne = digitString.substring(0,1);
		String digitTwo = digitString.substring(1,2);
		int sum = 0;
		sum = Integer.parseInt(digitOne) + Integer.parseInt(digitTwo);
		System.out.println(sum);
		}
	}
	
	// Problem 3 ==================================================================
	/** 
		Double every second digit from *right to left*. 

		If doubling of a digit results in a two-digit number, add the two digits
		together to get a single digit number using the getDigit(...) method.

		Use a *loop* to cycle through all the numbers of the String.
		Note: You will need to *convert a char to an int*

		@param number: A 13 to 16 digit String of numbers

		@returns an integer
	*/
	public static void sumOfDoubleEvenPlace(String number){
		//int oddEven = 0;
		//long fullNumber = Long.parseLong(number);
		//int even = number.length() - 1;
		String cardID = number;
		for (int i = 0; i < cardID.length() ; i++) {
			String z = number.substring(i, i + 1);
			int valueZ = Integer.parseInt(z);
			int doubleValueZ = valueZ * 2;
			if (doubleValueZ < 10 ) 
			{
				System.out.println("The result was a single digit, its value was: " + doubleValueZ);
			} else 
			{
			String doubleString = Integer.toString(doubleValueZ);
			String doubleValDigitOne = doubleString.substring(0,1);
			String doubleValDigitTwo = doubleString.substring(1,2);
			int sum = 0;
			sum = Integer.parseInt(doubleValDigitOne) + Integer.parseInt(doubleValDigitTwo);
			System.out.println("The result was two digits, the sum of those digits was: " + sum);
			}
			i++;
		}
	}
	
	// Problem 4 ==================================================================
	/** 
		Return sum of odd-place digits in number

		Use a *loop* to cycle through all the numbers of the String.
		Note: You will need to *convert a char to an int*

		@param number: A 13 to 16 digit String of numbers

		@returns an integer
	*/
	public static void sumOfOddPlace(String number){
		String cardID = number;
		int updatedSum = 0;
		for (int i = 0; i < cardID.length() ; i += 2) {
			String z = number.substring(i, i + 1);
			int valueZ = Integer.parseInt(z);
			updatedSum += valueZ; 
		}
		System.out.println("The sum of odd numbers is: " + updatedSum);
	}
	
	// Problem 5 ==================================================================
	/** 
		Returns true if the card number is valid 

		To determine if a card is valid, the sum of the Double Even Place
		Numbers and the Sum of the Odd Place Numbers must be divisible by
		ten (10) (use modulus to determine if the number is divisible), 
		the String must be 13 to 16 digits, *and* the String must start
		with "4", "5", "37", or "6".

		@param number: A 13 to 16 digit String of numbers

		@returns true if the String is a valid card, False otherwise
	*/
	public static boolean isValid(int odd, int even, String cardCompany) 
	{
		boolean testBool = false;
		if (((even + odd) % 10 == 0) && cardCompany.equals("Visa")) {
			testBool = true;
		} else if (((even + odd) % 10 == 0) && cardCompany.equals("Master Card")) {
				testBool = true;
			} else if (((even + odd) % 10 == 0) && cardCompany.equals("American Express")) 
				{
					testBool = true;
				}
				else if (((even + odd) % 10 == 0) && cardCompany.equals("Discover Card")) {
					testBool = true;
				} else {
					testBool = false;
				}
		return testBool;
			}	
}




