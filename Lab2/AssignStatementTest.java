import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Class to test AssignmentStatement
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class AssignStatementTest extends AbstractVisitorTest {

    /**
     * Global object for JavaVisitor
     */
    JavaVisitor javav = new JavaVisitor();
    /**
     * Global object for WATextVisitor
     */
    WATextVisitor wav = new WATextVisitor();
    /**
     * Global object for CompileVisitor
     */
    CompileVisitor compv = new CompileVisitor();
    
    /**
     * Test Constructor
     */
    @Test
    public void testAssignStatement() {
        assertEquals(simpleBinaryEx.getClass(), assign.aValue.getClass());
    }

    /**
     * Tests getVariable()
     */
    @Test
    public void testGetVariable() {
        assertEquals(varEx, assign.getVariable());
    }

    /**
     * Test Add method
     */
    @Test
    public void testJavaVisitor() {
        String answer = "a = (a+5);\n";
        
        assign.accept(javav);
        assertEquals(answer, javav.getString());
    }
    
    /**
     * Test for WATextVisitor
     */
    @Test
    public void testWaTextVisitor() {
        String answer = "(set_global 0 "
                + "(i32.add (get_global 0)"
                + " (i32.const 5)))\n";
        
        assign.accept(wav);
        
        assertEquals(answer, wav.getString());
    }
    
    /**
     * Test for CompileVisitor class
     */
    @Test
    public void testCompileVisitor() {
        String answer = "get_global 0\n"
                + "i32.const 5\n"
                + "i32.add\n"
                + "set_global 0\n";
        
        assign.accept(compv);
        
        assertEquals(answer, compv.getString());           
    }
}
