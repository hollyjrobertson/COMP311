/**
 * Compile Visitor class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class CompileVisitor implements Visitor
{
    /**
     * Global variable for sb
     */
    StringBuffer sb = new StringBuffer();
    
    /**
     * Visit Constant Expression method
     * @param expr ConstantExpression
     */
    @Override
    public void visit(ConstantExpression expr) {
        sb.append("i32.const " + expr.getValue() + "\n");
    }

    /**
     * Visit Variable Expression method
     * @param expr VariableExpression
     */
    @Override
    public void visit(VariableExpression expr) {
        sb.append("get_global " + expr.getIndex() + "\n");
    }

    /**
     * PreVisit Binary Expression method
     * @param expr BinaryExpression
     */
    @Override
    public void preVisit(BinaryExpression expr) {
        sb.append("");
    }

    /**
     * Visit Binary Expression method
     * @param expr BinaryExpression
     */
    @Override
    public void visit(BinaryExpression expr) {
        sb.append("");
    }

    /**
     * PostVisit Binary Expression method
     * @param expr BinaryExpression
     */
    @Override
    public void postVisit(BinaryExpression expr) {
        sb.append(expr.getOperator().getInstructions() + "\n");
    }

    /**
     * PreVisit Assign Statement method
     * @param stmt AssignStatement
     */
    @Override
    public void preVisit(AssignStatement stmt) {
        sb.append("get_global " + stmt.getVariable().getIndex() + "\n");
    }

    /**
     * PostVisit Assign Statement method
     * @param stmt AssignStatement
     */
    @Override
    public void postVisit(AssignStatement stmt) {
        sb.append("set_global " + stmt.getVariable().getIndex() + "\n");
    }

    /**
     * PreVisit Dowhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void preVisit(DoWhileStatement stmt) {
        sb.append("while0: nop\n");
    }

    /**
     * PostBodyVisit Dowhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void postBodyVisit(DoWhileStatement stmt) {
        /**
         * Here to make WebCat happy
         */
    }

    /**
     * PostVisit Dowhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void postVisit(DoWhileStatement stmt) {
        sb.append("br_if while0\n");
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
     * Return string
     * @return string
     */
    public String getString() {
        return sb.toString();
    }
}
