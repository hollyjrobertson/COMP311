/**
 * JavaVisitor class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class JavaVisitor implements Visitor
{
    /**
     * Visit ConstantExpression method
     * @param expr ConstantExpression
     */
    @Override
    public void visit(ConstantExpression expr) {
    }

    /**
     * Visit Variable Expression method
     * @param expr VariableExpression
     */
    @Override
    public void visit(VariableExpression expr) {
    }

    /**
     * PreVisit BinaryExpression method
     * @param expr BinaryExpression
     */
    @Override
    public void preVisit(BinaryExpression expr) {
    }

    /**
     * Visit BinaryExpression method
     * @param expr BinaryExpression
     */
    @Override
    public void visit(BinaryExpression expr) {
    }

    /**
     * PostVisit BinaryExpression method
     * @param expr BinaryExpression
     */
    @Override
    public void postVisit(BinaryExpression expr) {
    }

    /**
     * PreVisit AssignStatement method
     * @param stmt AssignStatement
     */
    @Override
    public void preVisit(AssignStatement stmt) {
    }

    /**
     * PostVisit AssignStatement method
     * @param stmt AssignStatement
     */
    @Override
    public void postVisit(AssignStatement stmt) {
    }

    /**
     * PreVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void preVisit(DoWhileStatement stmt) {
    }

    /**
     * PreVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void postBodyVisit(DoWhileStatement stmt) {
    }

    /**
     * PostVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void postVisit(DoWhileStatement stmt) {
    }

    /**
     * PreVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preVisit(IfStatement stmt) {
    }

    /**
     * PreThenVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preThenVisit(IfStatement stmt) {
    }

    /**
     * PreElseVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preElseVisit(IfStatement stmt) {
    }

    /**
     * PostVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void postVisit(IfStatement stmt) {
    }

    /**
     * Returns the string
     * @return string
     */
    public String getString()
    {
        return null;
    }
}
