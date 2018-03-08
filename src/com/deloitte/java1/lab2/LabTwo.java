package com.deloitte.java1.lab2;
/**
 * 
 * @author matthanderson
 * Java Level 1 Lab 2
 * Print welcome message to console, set parameters to pass to main method
 * 2/2/17
 */
public class LabTwo 
{

public static void main (String args[])
	{
		System.out.println("Welcome Matt"); //Prints welcome message to console
		printArguments(args); //	
	}

//Method to loop through array and print values to console
public static void printArguments (String args[])
	{
	/*
	 * For Each loop to display all values
	 * Declare String myArgs to access array of String values
	 * args is the array of String values to be looped through
	 */
	for (String myArgs : args)
		{
		System.out.println("The Value is: " + myArgs);	
		}
	}
}