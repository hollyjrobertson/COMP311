/**
 * WATextVisitor class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class WATextVisitor implements Visitor
{
    /** 
     * Global Variable for StringBuffer
     */
    StringBuffer sb = new StringBuffer();
    
    /**
     * Visit ConstantExpression method
     * @param expr ConstantExpression
     */
    @Override
    public void visit(ConstantExpression expr) {
        sb.append(" (i32.const " + expr.getValue() + ")");
    }

    /**
     * Visit Variable Expression method
     * @param expr VariableExpression
     */
    @Override
    public void visit(VariableExpression expr) {
        sb.append("(get_global " + expr.getIndex() + ")");
    }

    /**
     * PreVisit BinaryExpression method
     * @param expr BinaryExpression
     */
    @Override
    public void preVisit(BinaryExpression expr) {
        sb.append("(");
    }

    /**
     * Visit BinaryExpression method
     * @param expr BinaryExpression
     */
    @Override
    public void visit(BinaryExpression expr) {
        sb.append(expr.getOperator().getInstructions() + " ");
    }

    /**
     * PostVisit BinaryExpression method
     * @param expr BinaryExpression
     */
    @Override
    public void postVisit(BinaryExpression expr) {
        sb.append(")");
    }

    /**
     * PreVisit AssignStatement method
     *  @param stmt AssignStatement
     */
    @Override
    public void preVisit(AssignStatement stmt) {
    }

    /**
     * PostVisit AssignStatement method
     *  @param stmt AssignStatement
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
     * Returns the string builder
     * @return sb.toString() - 
     */
    public String getString() {
        return sb.toString();
    }
}
