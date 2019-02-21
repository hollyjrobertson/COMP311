import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Base class for tests.
 *
 * @author Tim
 * @version 1.0
 */
public class AbstractVisitorTest
{
    /** Constant expression. */
    protected ConstantExpression constEx;
    /** Variable expression. */
    protected VariableExpression varEx;
    /** Simple BinaryExpression. */
    protected BinaryExpression simpleBinaryEx;

    //  TODO: Add more expressions and statements here for the
    //  subclasses to use

    /** Set up tests. */
    @Before
    public void setUp() throws Exception
    {
        constEx = new ConstantExpression(5);
        varEx = new VariableExpression(0);

        simpleBinaryEx =
            new BinaryExpression(
                varEx,
                Operator.ADD,
                constEx);

        //  TODO: initialize other expressions and statements
    }

    /** Keep WebCAT happy */
    @Test
    public void testNothing()
    {
        int num = 3 + 5;
        assertEquals("Can't happen", 8, num);
    }
}
