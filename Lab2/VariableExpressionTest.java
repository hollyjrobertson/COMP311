import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Test class for VariableExpressions
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class VariableExpressionTest {

    /**
     * Global object for VariableExpression
     */
    VariableExpression var;
    /**
     * Global object for WATextVisitor
     */
    WATextVisitor v;
    
    /**
     * Runs before every test/method
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        var = new VariableExpression(0);
        v = new WATextVisitor();
    }

    /**
     * Runs after every test/method
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        var = null;
        v = null;
    }

    /**
     * Tests the constructor
     */
    @Test
    public void testVariableExpression() {
        var = new VariableExpression(2);
        assertEquals(2, var.getIndex());
    }
    
    /**
     * Tests the getIndex() method
     */
    @Test
    public void testGetIndex() {
        assertEquals(0, var.getIndex());
    }
    
    /**
     * Tests the getName() method
     */
    @Test
    public void testGetName() {
        assertEquals('a', var.getName());
    }

    /**
     * Tests the accept() method
     */
    @Test
    public void testAccept() {
        var.accept(v);
        String result = "get_global " + var.getIndex();
        
        assertEquals(result, v.getString());
    }
}
