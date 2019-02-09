package hw2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodeBreakerTest {

	CodeBreaker theCode;
	
	 /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
	@Before
	public void setUp() throws Exception
	{
		theCode = new CodeBreaker();
	}

	 /**
     * Tears down the test fixture. 
     * (Called after every test case method.)
     */
	@After
	public void tearDown() throws Exception
	{
		theCode = null;
	}

	/**
	 * Test that the original code is the answer
	 */
	@Test
	public void testBreakCodePerfectMatch()
	{
		String code = "11";
		int target = 2;
		String answer = "11";
		
		assertEquals(theCode.breakCode(code, target), answer);
	}
	
	/**
	 * Test that confirms length > 0
	 */
	@Test
	public void testBreakCodeLength()
	{
		String code = "";
		int target = 2;
		String answer = "Value is null or code cannot be broken";
		
		try {
			theCode.breakCode(code, target);
		}
		catch (ArithmeticException exception) {
			assertEquals(answer, exception.getMessage());
		}
	}
	
	/**
	 * Test method for main feature in class
	 */
	@Test
	public void testBreakCode()
	{
		String code = "1(2,34)5(3,2)";
		int target = 11;
		String answer = "1253";
		
		assertEquals(theCode.breakCode(code, target), answer);
	}
	
	/**
	 * Test the current sum is null
	 */
	@Test
	public void testTestCodeNull()
	{
		int answer = 0;
		
		assertEquals(answer, theCode.testCode(null));
	}
	
	/**
	 * Test the current sum is null
	 */
	@Test
	public void testTestCodeSum()
	{
		int answer = 2;
		String sum = "11";
		
		assertEquals(answer, theCode.testCode(sum));
	}
	
}
