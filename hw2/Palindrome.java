package hw2;

public class Palindrome
{
	/**
	 * Method that tests to see if string is palindrome or not
	 * @param theString to be tests
	 * @return true or false if string is a palindrome
	 */
	public boolean isPalindrome(String theString) {
    	//Converts the string to lowercase and replaces all spaces with empty string
    	String lowered = theString.toLowerCase().replaceAll("\\s", "")
    			.replaceAll("[-+.!?^:;,]", "");
    	//Get the length of the string
    	int size = lowered.length();
    	
    	//Base case to see if the string is 1 character (or less)
    	//If true - string is a palindrome
    	//Also if we got here, each letter matches the corresponding letter
    	//in the next if statement
    	if (size <= 1) {
    		return true;
    	}
    	
    	//Compares the first character of the string to the last character
    	//size - 1 gets the last index, since index's start at 0
    	//If they are not equal, returns false
    	if(lowered.charAt(0) != lowered.charAt((size - 1))) {
        	return false;
    	}
    	
    	//Recursive call to test next two chars
    	return isPalindrome(lowered.substring(1, size - 1));
	}
}
