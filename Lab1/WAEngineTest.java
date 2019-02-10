import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;

/**
 * Main Test method for class
 * @author Holly Robertson
 * @version 1.0
 */
public class WAEngineTest {

    /**
     * Test class for WAEngine
     * 
     * @author Holly Robertson
     * @version 1.0
     */
    @Test
    public void testConst() {
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
                "i32.const 42\n"
                + "set_global 0\n"
                ), globals);

        e.run();

        assertEquals(42, globals[0]);

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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
                "i32.const 13\n"
                + "i32.const 2\n"
                + "i32.gte\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(0, globals[0]);
    }
    
    /**
     * Test method for less than that's true
     */
    @Test
    public void testLtTrue() {
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
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
        int [] globals = new int[2];
        WAEngine e = new WAEngine(new Scanner(
                "i32.const 12\n"
                + "i32.const 13\n"
                + "i32.lte\n"
                + "set_global 0\n"
                ), globals);
        
        e.run();
        
        assertEquals(0, globals[0]);
    }
}
