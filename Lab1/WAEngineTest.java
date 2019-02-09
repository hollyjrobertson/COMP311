import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.*;

/**
 * Test class for WAEngine
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class WAEngineTest {
    /***
     * Object from WAEngine
     */
    WAEngine e;
    
    /**
     * Global variable globals
     */
    int[] globals;
    
    /**
     * Sets up the test fixture
     * (Called before every test case method.)
     */
    @Before
    public void setUp() throws Exception {
        globals = new int[2];
    }
    
    /**
     * Tears down the test fixture
     * (Called after every test case method.)
     */
    @After
    public void tearDown() throws Exception {
        globals = null;
    }
    
    /**
     * Test method for set_global
     */
    @Test
    public void testSet() {
        e = new WAEngine(new Scanner(
                "i32.const 42\n"
                + "set_global 0\n"
                ), globals);

        e.run();

        assertEquals(42, globals[0]);

    }
    
    /**
     * Test method for multiple variables
     */
    @Test
    public void testTwoGlobal() {
        e = new WAEngine(new Scanner(
               "i32.const 12\n"
                + "i32.const 23\n"
                + "set_global 0\n"
                + "set_global 1\n"
                ), globals);

        e.run();

        assertEquals(23, globals[0]);
        assertEquals(12, globals[1]);
        
    }
    
    /**
     * Test method for get_global
     */
    @Test
    public void testGetGlobal() {
        e = new WAEngine(new Scanner(
                "i32.const 42\n"
                + "set_global 0\n"
                + "get_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(42, globals[0]);
    }
    
    /**
     * Test method for add
     */
    @Test
    public void testAdd() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 23\n"
                + "i32.add\n"
                + "set_global 0\n"
                + "get_global 0\n"
                ), globals);
        
        e.run();
       
        assertEquals(35, globals[0]);
    }
    
    /** 
     * Test method for subtraction
     */
    @Test
    public void testSub() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 23\n"
                + "i32.sub\n"
                + "set_global 0\n"
                + "get_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(11, globals[0]);
    }
    
    /**
     * Test method for multiplication
     */
    @Test
    public void testMul() {
        e = new WAEngine(new Scanner(
                "i32.const 2\n"
                + "i32.const 3\n"
                + "i32.mul\n"
                + "set_global 0\n"
                + "get_global 0\n"
                ), globals);
     
        e.run();
        
        assertEquals(6, globals[0]);
    }
    
    /**
     * Test method for division
     */
    @Test
    public void testDiv() {
        e = new WAEngine(new Scanner(
                "i32.const 3\n"
                + "i32.const 12\n"
                + "i32.div\n"
                + "set_global 0\n"
                + "get_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(4, globals[0]);
    }
    
    /**
     * Test method for equals that's true
     */
    @Test
    public void testEqTrue() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 12\n"
                + "i32.eq\n"
                + "set_global 0\n"
                ), globals);
     
        
        e.run();
        
        assertEquals(1, globals[0]);
    }
    
    /**
     * Test method for equals that's false
     */
    @Test
    public void testEqFalse() {
        e = new WAEngine(new Scanner(
                "i32.const 13\n"
                + "i32.const 12\n"
                + "i32.eq\n"
                + "set_global 0\n"
                ), globals);
     
        
        e.run();
        
        assertEquals(0, globals[0]);
    }
    
    /**
     * Test method for not equals that's true
     */
    @Test
    public void testNeTrue() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 13\n"
                + "i32.ne\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(1, globals[0]);
    }
    
    /**
     * Test method for not equals that's false
     */
    @Test
    public void testNeFalse() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 12\n"
                + "i32.ne\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(0, globals[0]);
    }
    
    /**
     * Test method for greater than that's true
     */
    @Test
    public void testGtTrue() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 13\n"
                + "i32.gt\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(1, globals[0]);
    }
    
    /**
     * Test method for greater than that's false
     */
    @Test
    public void testGtFalse() {
        e = new WAEngine(new Scanner(
                "i32.const 13\n"
                + "i32.const 12\n"
                + "i32.gt\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(0, globals[0]);
    }
    
    /**
     * Test method for greater than or equal that's true
     */
    @Test
    public void testGteTrue() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 12\n"
                + "i32.gte\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(1, globals[0]);
    }
    
    /**
     * Test method for greater than or equal that's false
     */
    @Test 
    public void testGteFalse() {
        e = new WAEngine(new Scanner(
                "i32.const 13\n"
                + "i32.const 2\n"
                + "i32.gte\n"
                + "set_global 0\n"
                ), globals);
    }
    
    /**
     * Test method for less than that's true
     */
    @Test
    public void testLtTrue() {
        e = new WAEngine(new Scanner(
                "i32.const 13\n"
                + "i32.const 12\n"
                + "i32.lt\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(1, globals[0]);
    }
    
    /**
     * Test method for less than that's false
     */
    @Test 
    public void testLtFalse() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 13\n"
                + "i32.lt\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(0, globals[0]);
    }
    
    /**
     * Test method for less than or equal that's true
     */
    @Test
    public void testLteTrue() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 12\n"
                + "i32.lte\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(1, globals[0]);
    }
    
    /** 
     * Test method for less than or equal that's false
     */
    @Test
    public void testLteFalse() {
        e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 13\n"
                + "i32.lte\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(0, globals[0]);
    }
}
