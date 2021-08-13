 ### [HW2](https://github.com/hollyjrobertson/COMP311/tree/master/hw2 "HW2")
  #### Problem 1: 
  Write a recursive method that generates a list of all possible character strings of a given length for a given numeric base. 
  ```java
  package hw1;

import java.util.*;

public class GenerateAllStrings{
	
	/**
	 * Main method to generate strings of certain length & base
	 * @param length of string 
	 * @param base of string
	 * @return the list of the generated strings
	 */
	public List<String >generateAllStrings(int length, int base) {
		//Test to see if base is less than 2
		//Throws exception if base < 2
		if (base < 2)
		{
			throw new ArithmeticException("Base is less than 2");
		}
		
		//Test to see if length is 0
		//Throws exception if length 1 or less
		if (length < 1)
		{
			throw new ArithmeticException("Length is less than 1");
		}
		
		//Initiates an empty string
		String firstSpot = "";
		//Create new LinkedList of generated strings
		List<String> theList = new LinkedList<>();
		//Call GenerateAllStringsHelper method to generate strings
		generateAllStringsHelper(theList, firstSpot, length, base);
		//Return the list
		return theList;
		
	}
	

	/**
	 * Helper recursive method that generates the actual string
	 * @param list that was created in calling method
	 * @param spot of the string we're changing
	 * @param length of the string
	 * @param base base of the string
	 * @return the list of generated strings
	 */
	public List<String> generateAllStringsHelper(List<String> list, 
			String spot, int length, int base) {
		//Base case, when length is less than 1, return list
		if (length < 1)
		{
			return list;
		}
		
		//While i is less than base run through each 'index' 
		//(spot of length) and increment to base - 1
		//Calls generateAllStringsHelper recursively by decrementing length
		//The nextSpot takes the current spot and adds i (the next # up to base)
		//Being able to use a string value as a number here
		//The length outside of this loop keeps the same, so that's how it changes
		//spots/positions in the string
		for(int i = 0; i < base; i++)
		{
			String nextSpot = spot + i; 
			
			//When length is one, it's at the "beginning" of the string
			//so it adds this string to the LinkedList
			//Again, length changes inside loop but resets when
			//base i is equal to base
			if (length == 1)
			{
				list.add(nextSpot);
			}
			generateAllStringsHelper(list, nextSpot, length-1, base);
		}
		return list;
	}
}

```
  #### Problem 2:  
  Write a recursive method that determines whether its argument string is a palindrome. Any non-letter character (e.g. spaces, punctuation, or numbers) should not be       considered as part of the string. Upper and lower case should be considered equal for comparison.
  ```java
  public class Problem2
{
	public static void main(String[] args)
	{
    	String isPalindrome = "A Santa at Nasa";
    	String isNotPalindrome = "I have got to improve my grades";
    	
    	//Prints out the Palindrome
    	if (isPalindrome(isPalindrome))
    	{
        		System.out.println("'" + isPalindrome + "' is a Palindrome.");
    	}
    	
    	//Print out the !Palindrome
    	if (!(isPalindrome(isNotPalindrome)))
    	{
        		System.out.println("'" + isNotPalindrome + "' is not a Palindrome. ");
    	}
	}
	
	public static boolean isPalindrome(String str)
	{
    	//Converts the string to lowercase and replaces all spaces with no space
    	//This operation is not necessary after the initial call though
    	String toLower = str.toLowerCase().replaceAll("\\s+", "");
    	//Get the value of the string
    	int size = toLower.length();
    	
    	//Base case to see if the string is 1 character (or less)
    	if (size < 2)
    	{
        		return true;
    	}
    	//Compares the first character of the string to the last character
    	//size - 1 gets the last index, since index's start at 0
    	//If they are not equal, returns false
    	//If so, calls isPalindrome to test the next two characters
    	if(toLower.charAt(0) != toLower.charAt((size - 1)))
    	{
        		return false;
    	}
    	//Calls itself with the next character from the beginning & end
    	return isPalindrome(toLower.substring(1, size - 1));
	}
}
```
