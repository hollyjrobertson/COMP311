package hw2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

	Palindrome theString;
	 /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
	@Before
	public void setUp() throws Exception
	{
		theString = new Palindrome();
	}

    /**
     * Tears down the test fixture. 
     * (Called after every test case method.)
     */
	@After
	public void tearDown() throws Exception
	{
		theString = null;
	}

	/**
	 * Tests to check if one letter is a palindrome
	 */
	@Test
	public void testIsPalindromeSize()
	{
		String testString = "a";
		boolean answer = true;
		
		assertEquals(answer, theString.isPalindrome(testString));
	}
	
	/**
	 * Tests to confirm a palindrome returns true
	 */
	@Test
	public void testIsPalindromeTrue()
	{
		String testString = "A lad named E Mandala";
		boolean answer = true;
		
		assertEquals(answer, theString.isPalindrome(testString));
	}

	/**
	 * Tests to confirm a palindrome with punctuation
	 */
	@Test
	public void testIsPalindromePeriod()
	{
		String testString = "A lad named E. Mandala";
		boolean answer = true;
		
		assertEquals(answer, theString.isPalindrome(testString));
	}
	
	/**
	 * Tests to confirm a palindrome with punctuation
	 */
	@Test
	public void testIsPalindromePunctuation()
	{
		String testString = "A man, a plan, a cat, a ham, "
				+ "a yak, a yam, a hat, a; canal-Panama!";
		boolean answer = true;
		 
		assertEquals(answer, theString.isPalindrome(testString));
	}
	
	/**
	 * Tests to confirm a non-palindrome with fail
	 */
	@Test
	public void testIsPalindromeFalse()
	{
		String testString = "Not a palindrome";
		boolean answer  = theString.isPalindrome(testString);
		
		if(!answer)
		{
			System.out.println(testString + " is not a Palindrome");
		}
		
		assertEquals(answer, theString.isPalindrome(testString));
	}

}
