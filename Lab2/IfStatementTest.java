import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Test class for IfStatement
 * @author Holly Robertson
 * @version 1.0
 *
 */
public class IfStatementTest
{
    /**
     * Global Object for IfStatement with 2 parameters
     */
    IfStatement ifState0;
    /** 
     * Global object for IfStatement with 3 parameters
     */
    IfStatement ifState1;
    /**
     * Global object for AssignStatement
     */
    AssignStatement assign;
    /**
     * Global object for BinaryExpression
     */
    BinaryExpression b;
    /**
     * Global object for JavaVisitor
     */
    JavaVisitor javav = new JavaVisitor();
    /**
     * Global object for WaTextVisitor
     */
    WATextVisitor wav = new WATextVisitor();
    /**
     * Global object for CompileVisitor
     */
    CompileVisitor compv = new CompileVisitor();

    /**
     * Runs before every test/method
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        b = new BinaryExpression(
                new VariableExpression(0),
                Operator.LT,
                new ConstantExpression(5));
        assign = new AssignStatement(
                new VariableExpression(0), 
                new BinaryExpression(
                    new VariableExpression(0), 
                    Operator.MULT,
                    new ConstantExpression(3)));
        
        ifState0 = new IfStatement(b, assign);
        ifState1 = new IfStatement(b, assign, assign);
    }

    /**
     * Runs after every test/method
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        b = null;
        assign = null;
        ifState0 = null;
        ifState1 = null;
    }

    /**
     * Test Constructor 1 
     */
    @Test
    public void constructor0() {
        assertEquals(b, ifState0.aCondition);
        assertEquals(assign, ifState0.aThenBlock);
    }

    /**
     * Test Constructor 2
     */
    @Test
    public void constructor1() {
        assertEquals(assign, ifState1.anElseBlock);
    }

    /**
     * Test GetElseBlock
     */
    @Test
    public void testGetElseBlock() {
        assertEquals(assign, ifState1.getElseBlock());
    }

    /**
     * Test JavaVisitor 
     */
    @Test
    public void testJavaVisitor() {
        String answer = "if (a<5)\n"
                + "{\n"
                + "  a = (a*3);\n"
                + "}\n";
        ifState0.accept(javav);
        
        assertEquals(answer, javav.getString());
    }
    
    /**
     * Test JavaVisitor for 2nd constructor 
     */
    @Test
    public void testJavaVisitor1() {
        String answer = "if (a<5)\n"
                + "{\n"
                + "  a = (a*3);\n"
                + "}\n"
                + "else\n"
                + "{\n"
                + "  a = (a*3);\n"
                + "}\n";
        
        ifState1.accept(javav);
        
        assertEquals(answer, javav.getString());
    }
    
    /**
     * Test WaTextVisitor for 1st Constructor
     */
    @Test
    public void testWATextVisitor() {
        String answer = "(if (i32.lt (get_global 0) (i32.const 5))\n" + 
                "  (then\n" + 
                "    (set_global 0 (i32.mul (get_global 0) (i32.const 3)))\n" + 
                "  )\n" + 
                ")\n";
        ifState0.accept(wav);
        
        assertEquals(answer, wav.getString());
    }
    
    /**
     * Test WaTextVisitor for 1st Constructor
     */
    @Test
    public void testWATextVisitor1() {
        String answer = 
                "(if (i32.lt (get_global 0) (i32.const 5))\n"
                + "  (then\n"
                + "    (set_global 0 (i32.mul (get_global 0) (i32.const 3)))\n"
                + "  )\n"
                + "  (else\n"
                + "    (set_global 0 (i32.mul (get_global 0) (i32.const 3)))\n"
                + "  )\n"
                + ")\n";

        ifState1.accept(wav);
        
        assertEquals(answer, wav.getString());
    }

}
