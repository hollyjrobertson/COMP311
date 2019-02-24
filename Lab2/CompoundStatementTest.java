import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Test class for Compound Statement
 * @author Holly Robertson
 * @version 1.0
 */
public class CompoundStatementTest
{
    /**
     * Global object of CompoundStatement
     */
    CompoundStatement comp;
    /**
     * Global object of AssignStatement
     */
    AssignStatement assign;
    /**
     * Global object for JavaVisitor
     */
    JavaVisitor javav = new JavaVisitor();
    
    /**
     * Runs before each test/method
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        comp = new CompoundStatement();
        VariableExpression var = new VariableExpression(0);
        ConstantExpression con = new ConstantExpression(3);
        BinaryExpression b = new BinaryExpression(var, Operator.ADD, con);
        assign = new AssignStatement(var, b);
    }

    /**
     * Runs after each test/method
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        comp = null;
    }

    /**
     * Test null statement
     */
    @Test
    public void testNullAddStatement() {
        comp.addStatement(null);
        
        assertEquals(null, comp.list.get(0));
    }
    
    /**
     * Test the JavaVisitor
     */
    @Test
    public void testJavaVisitor() {
        String answer = "a = (a+3);\n"
                + "b = 7;\n";
        assign.accept(javav);
        
        comp.addStatement(new AssignStatement(
                new VariableExpression(1), new ConstantExpression(7)));
        comp.accept(javav);
        
        assertEquals(answer, javav.getString());
    }

}
