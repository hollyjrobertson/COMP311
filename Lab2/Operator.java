/**
 * Represents an operator in a binary expression.
 *
 * @author Tim
 * @version 1.0
 */
public final class Operator
{
    /** Add. */
    public static final Operator ADD = new Operator("+", "i32.add");
    /** Subtract. */
    public static final Operator SUB = new Operator("-", "i32.sub");
    /** Multiply. */
    public static final Operator MULT = new Operator("*", "i32.mul");
    /** Divide. */
    public static final Operator DIV = new Operator("/", "i32.div");
    /** Equals. */
    public static final Operator EQ = new Operator("==", "i32.eq");
    /** Not equal. */
    public static final Operator NEQ = new Operator("!=", "i32.ne");
    /** Less than. */
    public static final Operator LT = new Operator("<", "i32.lt");
    /** Less than or equal to. */
    public static final Operator LTE = new Operator("<=", "i32.lte");
    /** Greater than. */
    public static final Operator GT = new Operator(">", "i32.gt");
    /** Greater than or equal to. */
    public static final Operator GTE = new Operator(">=", "i32.gte");

    private String oper;
    private String instructions;

    /**
     * Creates an operator.
     *
     * @param op the operator
     * @param inst the opcodes to execute this operator
     */
    private Operator(String op, String inst)
    {
        oper = op;
        instructions = inst;
    }

    /**
     * Returns the operator as a String.
     *
     * @see java.lang.Object#toString()
     * @return the operator
     */
    @Override
    public String toString()
    {
        return oper;
    }

    /**
     * Returns the opcodes to execute this operator.
     *
     * @return the opcodes to execute this operator
     */
    public String getInstructions()
    {
        return instructions;
    }
}
