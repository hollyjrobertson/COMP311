# Course Work ( COMP311 )

### [Lab 2](https://github.com/hollyjrobertson/COMP311/tree/master/Lab2 "Lab 2")
  #### Purpose:   
  Focus on the tree structures, recursion, and the [Visitor](https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm "Visitor"), [Strategy](https://www.tutorialspoint.com/design_pattern/strategy_pattern.html "Strategy") and   
   [Composite design patterns.](https://www.tutorialspoint.com/design_pattern/composite_pattern.htm "Composite")
   #### Assignment:  
   Using the Visitor and Composite patterns to perform  
   specific operations on the data stored in a git repository.
   #### Details:  
   Utilized the Visitor to maintain the [SOLID](https://stackify.com/solid-design-open-closed-principle/ "Solid") principles - specifically the Open-Closed Principle.  
   <b><i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;“Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.”  - Bertrand Meyer 1988</i></b>  
   This allows the application to create as many "visitors" / components that's needed without first refactoring entire code base. 
   The Visitor pattern also allowed easier data retrieval and added a way of simulating double dispatch in Java (where it isn't supported by default).  
   A [quick read on Medium.com](https://medium.com/@darrenwedgwood/visitor-pattern-and-double-dispatch-part-1-e8d83426a0e7 "quick read on Medium.com") 
   helps explains how the Visitor pattern grants the ability to use Double Dispatch.  
     
   The Strategy pattern was used when creating the GrepLogVisitor to search for various object types (GitCommit, GitFileEntry, and GitBlob)  
   ```java 
   public interface GrepLogFilter {  
    public boolean matchesCommit(GitCommit commit); 
    public boolean matchesFileEntry(GitFileEntry entry);
   }
   
   : commit 277b404b0fa457559b8a851d7c8214987a18b065
   Author: tim
   Note: Fixed DST bug
   
   : commit_entry 3ed1c0b5aa9989451b1c5167ce02d34629e3d0f5
   Author: corey
   Note: Added unit tests

   ```
   
   ### [HW1](https://github.com/hollyjrobertson/COMP311/tree/master/hw1 HW1")
  #### Problem:  
  Write a simple adapter class to translate between these two interfaces:
  
  ```java 
  public interface Student {
    int getId();
    void setId(int id);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
  }

  public interface LegacyStudent {
    String getId();
    void setId(String id);
    String getFullName();
    void setFullName(String name);
  }
  ```
 ### [HW2](https://github.com/hollyjrobertson/COMP311/tree/master/hw2 "HW2")
  #### Problem:  
  Write a recursive method that determines whether its argument string is a palindrome. Any non-letter character (e.g. spaces, punctuation, or numbers) should not be       considered as part of the string. Upper and lower case should be considered equal for comparison.:
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
   

   
