import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Constant Expression text
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class ConstantExpressionTest {
    /**
     * Public object of ConstantExpression
     */
    ConstantExpression con; 
    /**
     * Public object of WATextVisitor
     */
    WATextVisitor v;
    
    /**
     * Test that runs before each method/test
     * @throws Exception to throw
     */
    @Before
    public void setUp() throws Exception {
        con = new ConstantExpression(3);
        v = new WATextVisitor();
    }

    /**
     * Test that runs after each method/test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        con = null;
        v = null;
    }

    /**
     * Tests the Constructor
     */
    @Test
    public void testConstantExpression() {
        assertEquals(3, con.val);
    }

    /**
     * Tests the getValue() method
     */
    @Test
    public void testGetValue() {
        assertEquals(3, con.getValue());
    }

    /**
     * Tests the accept() method
     */
    @Test
    public void testAccept() {
        con.accept(v);
        
        assertEquals("(i32.const 3)", v.getString());
    }

}
