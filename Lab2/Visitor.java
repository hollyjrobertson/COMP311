/**
 * Interface for visitors.
 *
 * @author Tim
 * @version 1.0
 */
public interface Visitor
{
    /**
     * Visits a ConstantExpression.
     *
     * @param expr the expression
     */
    void visit(ConstantExpression expr);

    /**
     * Visits a VariableExpression.
     *
     * @param expr the expression
     */
    void visit(VariableExpression expr);

    /**
     * Pre-visits a BinaryExpression.
     *
     * @param expr the expression
     */
    void preVisit(BinaryExpression expr);

    /**
     * Visits a BinaryExpression.
     *
     * @param expr the expression
     */
    void visit(BinaryExpression expr);

    /**
     * Post-visits a BinaryExpression.
     *
     * @param expr the expression
     */
    void postVisit(BinaryExpression expr);

    /**
     * Pre-visits an AssignStatement.
     *
     * @param stmt the statement
     */
    void preVisit(AssignStatement stmt);

    /**
     * Post-visits an AssignStatement.
     *
     * @param stmt the statement
     */
    void postVisit(AssignStatement stmt);

    /**
     * Pre-visits a DoWhileStatement.
     *
     * @param stmt the statement
     */
    void preVisit(DoWhileStatement stmt);

    /**
     * Called after the body is visited, but
     * before the condition for a DoWhileStatement.
     *
     * @param stmt the statement
     */
    void postBodyVisit(DoWhileStatement stmt);

    /**
     * Post-visits a DoWhileStatement.
     *
     * @param stmt the statement
     */
    void postVisit(DoWhileStatement stmt);

    /**
     * Pre-visits an IfStatement.
     *
     * @param stmt the statement
     */
    void preVisit(IfStatement stmt);

    /**
     * Called after the condition is visited, but
     * before the then block for an IfStatement.
     *
     * @param stmt the statement
     */
    void preThenVisit(IfStatement stmt);

    /**
     * Called after the then block is visited, but
     * before the else block for an IfStatement.
     *
     * @param stmt the statement
     */
    void preElseVisit(IfStatement stmt);

    /**
     * Post-visits an IfStatement.
     *
     * @param stmt the statement
     */
    void postVisit(IfStatement stmt);
}
