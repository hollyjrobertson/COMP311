import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for WATextVisitor.
 *
 * @author Tim
 * @version 1.0
 */
public class WATextVisitorTest extends AbstractVisitorTest {
    /** Test simple expressions. */
    @Test
    public void testSimpleExpressions() {
        // The expressions we're testing are defined in AbstractVisitorTest
        WATextVisitor v = new WATextVisitor();
        constEx.accept(v);
        assertEquals("(i32.const 5)", v.getString());

        v = new WATextVisitor();
        varEx.accept(v);
        assertEquals("(get_global 0)", v.getString());

        v = new WATextVisitor();
        simpleBinaryEx.accept(v);
        assertEquals("(i32.add (get_global 0) (i32.const 5))", v.getString());
    }
}
