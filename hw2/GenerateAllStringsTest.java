package hw2;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class GenerateAllStringsTest {
	
	GenerateAllStrings theString;
	
	 /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
	@Before
	public void setUp()
	{
		theString = new GenerateAllStrings();
	}
	
    /**
     * Tears down the test fixture. 
     * (Called after every test case method.)
     */
    @After
    public void tearDown() 
    {
    	theString = null;
    }
    
	/**
	 * Testing that exception will be thrown when base < 2
	 */
	@Test
	public void testGenerateAllStringsBaseFail()
	{
		int base = 1;
		int length = 3;
		
		try {
			theString.generateAllStrings(length, base);
		}
		catch (ArithmeticException anArithmeticException) {
			assertEquals("Base is less than 2", anArithmeticException.getMessage());
		}

	}
	
	/**
	 * Testing that exception will be thrown when length is 1 
	 */
	@Test
	public void testGenerateAllStringsLengthFail1()
	{
		int base = 3;
		int length = 1;
		
		try {
			theString.generateAllStrings(length, base);
		}
		catch (ArithmeticException anArithmeticException) {
			assertEquals("Length is less than 1", anArithmeticException.getMessage());
		}

	}

	/**
	 * Testing that exception will be thrown when length < 1 
	 */
	@Test
	public void testGenerateAllStringsLengthFail0()
	{
		int base = 3;
		int length = 0;
		
		try {
			theString.generateAllStrings(length, base);
		}
		catch (ArithmeticException anArithmeticException) {
			assertEquals("Length is less than 1", anArithmeticException.getMessage());
		}

	}
	
	/**
	 * Tests the main generateAllStrings method
	 */
	@Test
	public void testGenerateAllStrings()
	{
		int base = 2;
		int length = 2;
		String answer = "[00, 01, 10, 11]";
		String listAnswer = theString.generateAllStrings(length, base).toString();
	
		assertEquals(answer, listAnswer);
	}
	
	/**
	 * Tests the main generateAllStrings method
	 */
	@Test
	public void testGenerateAllStrings1()
	{
		int base = 2;
		int length = 3;
		String answer = "[000, 001, 010, 011, 100, 101, 110, 111]";
		String listAnswer = theString.generateAllStrings(length, base).toString();
		
		assertEquals(answer, listAnswer);
	}
	
	/**
	 * Tests the main generateAllStrings method
	 */
	@Test
	public void testGenerateAllStrings2()
	{
		int base = 4;
		int length = 2;
		String answer = "[00, 01, 02, 03, 10, 11, 12, 13, 20, 21, 22, 23, 30, 31, 32, 33]";
		String listAnswer = theString.generateAllStrings(length, base).toString();
		
		assertEquals(answer, listAnswer);
	}
	
	/**
	 * Test if length is less than 1, than return list
	 */
	@Test
	public void testGenerateAllStringsHelperLength()
	{
		int base = 2;
		int length = 1;
		String answer = "[0, 1]";
		LinkedList<String> testList = new LinkedList<>();
		
		String listAnswer = theString.generateAllStringsHelper(testList, 
				"", length, base).toString();
		
		assertEquals(answer, listAnswer);
	}
	
	/**
	 * Tests the generateAllStringsHelper method
	 */
	@Test
	public void testGenerateAllStringsHelper()
	{
		int base = 2;
		int length = 2;
		String answer = "[00, 01, 10, 11]";
		LinkedList<String> testList = new LinkedList<>();
		
		String listAnswer = theString.generateAllStringsHelper(testList,
				"", length, base).toString();
		
		assertEquals(answer, listAnswer);
	}

}
