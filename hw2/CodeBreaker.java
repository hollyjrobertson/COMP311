package hw2;

public class CodeBreaker {

	/**
	 * Method that returns the string for the code breaker
	 * @param code to break
	 * @param target of the code
	 * @return the broken code
	 */
	public String breakCode(String code, int target) {
		return breakCodeHelper(code, "", target);
	}
	
	/**
	 * The helper method to breakCode
	 * @param code to break
	 * @param currentSum sum of the code
	 * @param target of the code
	 * @return the string of the correct code
	 */
	public String breakCodeHelper(String code, String currentSum, int target) {
		//If the current sum matches target - code broken
		//Throws to testCode(String value) to help abstract code || improve
		//readability
		//Returns the sum
		if (testCode(currentSum) == target) {
			return currentSum;
		}
		
		//If code length is 0 - throw error that value is null or there is no
		//answer for this problem
		if (code.length() == 0) {
			throw new ArithmeticException("Value is null or code cannot be broken");
		}
		
		//Splits the code at the first (
		//the Substring - Start at 0 and then go to the index
		//of where the ) is + 1 to split at the next index
		//For index goes through the code and splits at the ,
		if (code.charAt(0) == '(') {
			String codeSplit = code.substring(0, code.indexOf(")", 0) + 1);
			//codeSplit now equals the (xx)
			for (String str : codeSplit.split(",")) {
				//Replaces parenthesis with empty spaces
				str = str.replace("(", "");
				str = str.replace(")", "");
				String currentChar = breakCodeHelper(
						code.replace(codeSplit, ""), currentSum + str, target);
				
				//Tests to see if the current char (breakCodeHelper split on "") is 
				//the target. If yes - returns the currentChar, if not - keep going
				if (testCode(currentChar) == target) {
					return currentChar;
				}
			}
		}
		//Sends [index 1 to code length], [adds current ("") + index 0 (1)], [target]
			return breakCodeHelper(
					code.substring(1, code.length()), currentSum + code.charAt(0), target);
	}
	
	/**
	 * Method to add sum of possible broken code
	 * @param currentSum of the code
	 * @return the value of the received string values
	 */
	public int testCode(String currentSum) {
		//If value is null, returns 0 
		if (currentSum == null) {
			return 0;
		}
		
		//Sets sum to the value at index i + previous sum by -'0'
		int sum = 0;
		for (int i = 0; i < currentSum.length(); i++) {
			sum = sum + currentSum.charAt(i) - '0';
		}
		return sum;
	}
}
