import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for JavaVisitor.
 *
 * @author Tim
 * @version 1.0
 */
public class JavaVisitorTest extends AbstractVisitorTest
{
    /** Test simple expressions. */
    @Test
    public void testSimpleExpressions()
    {
        //  The expressions we're testing are defined in AbstractVisitorTest
        JavaVisitor v = new JavaVisitor();
        constEx.accept(v);
        assertEquals("Hint: JavaVisitor failed for const expression",
            "5", v.getString());

        v = new JavaVisitor();
        varEx.accept(v);
        assertEquals("Hint: JavaVisitor failed for variable expression",
            "a", v.getString());

        v = new JavaVisitor();
        simpleBinaryEx.accept(v);
        assertEquals("Hint: JavaVisitor failed for simple binary expression",
            "(a+5)", v.getString());
    }
}
