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
		String card = "4847352989263094";

		// When you are finished writing the methods below,
		// uncomment the three lines below to test.
		//Scanner input = new Scanner(System.in);
		//System.out.print("Enter a Credit Card Number: ");
		//String cardNumber = input.nextLine();

		// Should say "Visa"
		System.out.print("getCompany: " + getCompany(card));
		// Should say "5"
		getDigit(5); // will print 5
		// Should say "7"
		getDigit(55); //will print 10
		// Should say "52"
		//System.out.print("sumOfDoubleEvenPlace: " + sumOfDoubleEvenPlace(card)); 
		// Should say "48"
		//System.out.print("sumOfOddPlace: " + sumOfOddPlace(card)); 
		// Should say "true"
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
		//int card = number.length();
		//int a = card - number.length();
		String cardNum = number.substring(0, 0);
		char cardValue = number.charAt(0);
		int cardVal = (int) cardValue;
		String company;
		//int num = Character.getNumericValue(cardNum);
		//int b = a + 1;
		//String company = "";
		
		if (cardNum.equalsIgnoreCase("4")) {
			company = "Visa";
		} else if (cardNum.equalsIgnoreCase("5")) {
			company = "Master Card";
		} else if (cardNum.equalsIgnoreCase("6")) {
			company = "Discover Card";
		} else if (cardNum.equalsIgnoreCase("3") && cardVal + 1 == 7);
			company = "American Express";
		return company;
	}
	
	// Problem 2 ==================================================================
	/** 
		Return this number if it is a single digit, otherwise, return the sum 
		of the two digits. For example, 18 will return 9 (because 1 + 8).

		@param number: a digit that will be between 0 and 18

		@returns an integer
	*/
	public static void getDigit(int number){
		//int digit = 0;
		//represents a single digit
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
		//System.out.println(sumOfDigits);
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
	/*public static int sumOfDoubleEvenPlace(String number){
		int oddEven = 0;
		int even = number.length() - 1;
		for (int i = 0; i >= 0; i -= 2) {
			char z = number.charAt(i);
			int num = Character.getNumericValue(z) * 2;
			oddEven += getDigit(num);
		}
		return oddEven; 
	}*/
	
	// Problem 4 ==================================================================
	/** 
		Return sum of odd-place digits in number

		Use a *loop* to cycle through all the numbers of the String.
		Note: You will need to *convert a char to an int*

		@param number: A 13 to 16 digit String of numbers

		@returns an integer
	*/
	/*public static int sumOfOddPlace(String number){
		//creates variable oddSum and sets the value to 0
		int oddSum = 0;
		int begin = number.length();
		for (int i = begin; i >= 0; i -=2) {
			char a = number.charAt(i);
			int val = Character.getNumericValue(a) * 2;
			
			oddSum += getDigit(val);
		}
		return oddSum;
	}/*
	
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




