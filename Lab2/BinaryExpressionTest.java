import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinaryExpression
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class BinaryExpressionTest {

    /**
     * Global object for BinaryExpression
     */
    BinaryExpression b;
    /**
     * Global object for WATextVisitor
     */
    WATextVisitor v;
    /**
     * First Global object for ConstantExpression
     */
    ConstantExpression con0;
    /**
     * Second Global object for ConstantExpression
     */
    ConstantExpression con1;
    /**
     * Global object for VariableExpression
     */
    VariableExpression var; 
    
    /**
     * Runs before every test/method
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        con0 = new ConstantExpression(3);
        con1 = new ConstantExpression(5);
        var = new VariableExpression(0);
        v = new WATextVisitor();
    }

    /**
     * Runs after every test/method
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Tests the for Addition
     */
    @Test
    public void testBinaryExpressionAdd() {
        String answer = "(i32.add (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.ADD, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Subtraction
     */
    @Test
    public void testBinaryExpressionSub() {
        String answer = "(i32.sub (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.SUB, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Multiplication
     */
    @Test
    public void testBinaryExpressionMult() {
        String answer = "(i32.mul (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.MULT, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Division
     */
    @Test
    public void testBinaryExpressionDiv() {
        String answer = "(i32.div (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.DIV, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Equal
     */
    @Test
    public void testBinaryExpressionEq() {
        String answer = "(i32.eq (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.EQ, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Not Equal
     */
    @Test
    public void testBinaryExpressionNe() {
        String answer = "(i32.ne (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.NEQ, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Less Than
     */
    @Test
    public void testBinaryExpressionLt() {
        String answer = "(i32.lt (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.LT, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Less Than or Equal
     */
    @Test
    public void testBinaryExpressionLte() {
        String answer = "(i32.lte (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.LTE, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Greater Than 
     */
    @Test
    public void testBinaryExpressionGt() {
        String answer = "(i32.gt (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.GT, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the for Greater Than or Equal
     */
    @Test
    public void testBinaryExpressionGte() {
        String answer = "(i32.gte (get_global 0)"
                + " (i32.const 5))";
        b = new BinaryExpression(var, Operator.GTE, con1);
        b.accept(v);
        
        assertEquals(answer, v.getString());
    }
    
    /**
     * Tests the getOperator() method
     */
    @Test
    public void testGetOperator() {
        b = new BinaryExpression(var, Operator.ADD, con0);
        assertEquals(Operator.ADD, b.getOperator());
    }
}
