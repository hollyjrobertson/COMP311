import junit.framework.TestCase;

/**
 * 
 */

/**
 * Write a description of class PrintVisitorTest here.
 * 
 * @author WhittakT
 * @version Jan 14, 2007
 */
public class VisitorTest extends TestCase
{
    private Expression expr;

    /**
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        // create an expression for ((5+2)*(3-7))
        expr =
            new MultiplyExpression(
                new AddExpression(
                    new ConstantExpression(5),
                    new ConstantExpression(2)),
                new SubtractExpression(
                    new ConstantExpression(3),
                    new ConstantExpression(7)));
    }

    public void testPrintVisitor()
    {
        PrintVisitor visitor = new PrintVisitor();
        expr.accept(visitor);
        assertEquals("((5+2)*(3-7))", visitor.getResult());
    }
    
    public void testComputeVisitor()
    {
        ComputeVisitor visitor = new ComputeVisitor();
        expr.accept(visitor);
        assertEquals(-28, visitor.getResult().intValue());
    }
}
