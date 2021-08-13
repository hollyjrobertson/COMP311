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
   
   ### [HW1](https://github.com/hollyjrobertson/COMP311/tree/master/hw1 "HW1")
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
  ### [HW3](https://github.com/hollyjrobertson/COMP311/tree/master/hw3 "HW3")
  #### Problem 1:
  Write a O(n) method printLevelOrder() that prints the nodes of a binary tree in level-order. That is, the method should print the root, then   
  the nodes at depth 1, followed by the nodes at depth 2, and so on.  Your algorithm should begin by putting the tree root on an initially   
  empty queue. Then dequeue a node, print its value, and enqueue its left and right children (if they exist). Repeat until the queue is empty.
  ```java
  public void printLevelOrder(Node<T> root) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		
		if (root == null) {
			System.out.println("Tree is empty");
		}
		
		//initialize the height and set first value
		queue.add(root);
		
		//Breaks at base case when count(level of tree) is 0
		while(true) {
			//Sets count equal to the height
			int count = queue.size();
			
			//Base case
			if (count == 0) {
				break;
			}
			
			//While count is > 0 a new instance of Node is set
			//to the value of the first element in queue
			//Printed then removed
			while (count > 0) {
				Node<T> node = queue.peek();
				System.out.println(node.data + " | ");
				queue.remove();
				
				//Test to see if left of the node is null
				//If false, adds the left to the queue
				if (node.left != null) {
					queue.add(node.left);
				}
				//Same for right node
				else if (node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}
	}
```

### [HW4](https://github.com/hollyjrobertson/COMP311/tree/master/hw4 "HW4")
  #### Problem 1:
  Use the Visitor pattern to create the framework for Lab 1 and include Unit Testing for each class  
  
  #### Problem 2:  
  Starting with the BinaryExpression learning activity solution from this week, write a new class PostfixVisitor that visits an expression tree and returns the    
  expression in postfix notation, with each part of the expression separated by spaces.  For example, if the tree represented the expression 3 + 5, then the postfix 
  result would be “3 5 +”
  ```java
  import java.util.Stack;

public class PostFixOperator extends AbstractVisitor {
	
	Stack<String> stack = new Stack<String>();
	
	@Override
	public void preVisit(BinaryExpression expr) {
		stack.push(expr.getOperation().toString());
	}
	
	
	@Override
	public void visit(ConstantExpression expr) {
		stack.push("" + expr.getValue());
	}
	
	public String getResult() {
		String result = "";
		while(!(stack.isEmpty())) {
			result = result + stack.pop() + " "; 
		}
		return result;
	}
}
```
 ### [HW5](https://github.com/hollyjrobertson/COMP311/blob/master/RobertsonHolly_HW5.pdf "HW5")
  #### Problem 1:
  A k-way heap is like a binary heap except that instead of at most two child nodes, internal nodes 
  may have up to k children. Just like with binary heaps, k-way heaps can be efficiently kept in an array.  
  * Provide two formulas for this mapping along with a written explanation and an example of the  
    mapping. The formulas are: parentOf(j) and ithChildOf(i, j) where j represents a node number   
    and i is a child number within a node {0, 1, 2, … k-1}.  
  * Comment on how this will affect the space and time complexity of the operations.  
  
  ###Problem 2:  
  Draw the binary heap that results from this series of inserts into an initially empty heap:    
  Insert 10, 12, 1, 14, 6, 5, 8, 15.  Show the result of performing two DeleteMin operations on the  
  resulting heap.  Show, separately, the result of each individual insert/delete.
  
  ### [HW6](https://github.com/hollyjrobertson/COMP311/tree/master/hw6/hw6.pdf "HW6")
  #### Problem 1:  
  Consider inserting the keys 71, 23, 73, 99, 44, 79, 89 into a hash table of size N = 10.  
  Show the result of hashing using:  
  * separate chaining 
  * open addressing with linear probing
  
  #### Problem 2:
  Design a data structure that can perform the given operations in the stated worst-case running time:  

	Insert: O(lg n)  
	Maximum: O(1)  
	Minimum: O(1)  
	Extract-max: O(lg n)  
	Extract-min: O(lg n) 
	
   #### Problem 3:
   Write a program that simulates a translation dictionary. 

   ### [HW7](https://github.com/hollyjrobertson/COMP311/tree/master/hw7 "HW7")
  #### Problem 1:
  Diagram and then utilize QuickSort and ShellSort  
  
  ### [HW8](https://github.com/hollyjrobertson/COMP311/tree/master/hw8.pdf "HW8")
  #### Problem 1:
  Diagram and explain an adjacency matrix and it's time complexity, and indirect/direct graphs.  
  ![image](https://user-images.githubusercontent.com/31171295/129286154-df69e4be-66e6-4273-95a7-68cae3301151.png)

  
  
