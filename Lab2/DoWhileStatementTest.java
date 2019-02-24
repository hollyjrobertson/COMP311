import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for DoWhileStatement
 * @author Holly Robertson
 * @version 1.0
 */
public class DoWhileStatementTest
{
    /**
     * Global Object for DoWhileStatement
     */
    DoWhileStatement doWhile;
    /**
     * Global object for AssignStatemetn
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
     * Runs before each test/method
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        assign = new AssignStatement(
                    new VariableExpression(0), 
                    new BinaryExpression(
                            new VariableExpression(0),
                            Operator.MULT,
                            new ConstantExpression(3)));
        
        b = new BinaryExpression(
                    new VariableExpression(0),
                    Operator.LT, 
                    new ConstantExpression(5));
        doWhile = new DoWhileStatement(assign, b);
    }

    /**
     * Runs after each test/method
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        assign = null;
        b = null;
        doWhile = null;
    }

    /**
     * Test constructor
     */
    @Test
    public void testDoWhileStatement() {
        assertEquals(assign, doWhile.aBody);
        assertEquals(b, doWhile.aCondition);
    }

    /**
     * Test WaTextVisitor method
     */
    @Test
    public void testAcceptWaTextVisitor() {
        String answer = "(loop\n" + 
                "  (set_global 0 (i32.mul (get_global 0) (i32.const 3)))\n" + 
                "(br_if (i32.lt (get_global 0) (i32.const 5))))\n";
        doWhile.accept(wav);

        assertEquals(answer, wav.getString());
    }
    
    /**
     * Test JavaVisitor method
     */
    @Test
    public void testJavaVisitor() {
        String answer = 
                "do\n" + 
                "{\n" + 
                "  a = (a*3);\n" + 
                "} while (a<5);\n";
        
        doWhile.accept(javav);
        
        assertEquals(answer, javav.getString());
    }
    
    /**
     * Test CompileVisitor
     */
    @Test
    public void testCompileVisitor() {
        String answer = 
                "while0: nop\n" + 
                "get_global 0\n" + 
                "i32.const 3\n" + 
                "i32.mul\n" + 
                "set_global 0\n" + 
                "get_global 0\n" + 
                "i32.const 5\n" + 
                "i32.lt\n" + 
                "br_if while0\n";
        
        doWhile.accept(compv);
        
        assertEquals(answer, compv.getString());
    }

}
