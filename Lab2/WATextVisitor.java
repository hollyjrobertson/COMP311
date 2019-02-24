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
     * Global variable for doWhile indentation 
     */
    int whileIdent = 0;
    /**
     * Global variable for if indentation
     */
    int ifIdent = 0;
    
    /**
     * Visit ConstantExpression method
     * @param expr ConstantExpression
     */
    @Override
    public void visit(ConstantExpression expr) {
        checkForParenthesis();
        sb.append("(i32.const " + expr.getValue() + ")");
    }

    /**
     * Visit Variable Expression method
     * @param expr VariableExpression
     */
    @Override
    public void visit(VariableExpression expr) {
        checkForParenthesis();
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
        sb.append("(set_global " + stmt.getVariable().getIndex() + " ");
    }

    /**
     * PostVisit AssignStatement method
     *  @param stmt AssignStatement
     */
    @Override
    public void postVisit(AssignStatement stmt) {
        sb.append(")\n");
    }

    /**
     * PreVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void preVisit(DoWhileStatement stmt) {
        sb.append("(loop\n");
        whileIdent += 2;
        
        for (int i = 0; i < whileIdent; i++) {
            sb.append(" ");
        }
    }

    /**
     * PreVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void postBodyVisit(DoWhileStatement stmt) {
        sb.append("(br_if ");
        whileIdent -= 2;
    }

    /**
     * PostVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void postVisit(DoWhileStatement stmt) {
        sb.append("))\n");
    }

    /**
     * PreVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preVisit(IfStatement stmt) {
        sb.append("(if ");
        ifIdent += 2;
    }

    /**
     * PreThenVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preThenVisit(IfStatement stmt) {
        sb.append("\n");
        spacing();
        sb.append("(then\n");
        ifIdent += 2;
        spacing();
        ifIdent -= 2;
    }

    /**
     * PreElseVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preElseVisit(IfStatement stmt) {
        spacing();
        sb.append(")\n");
        spacing();
        sb.append("(else\n");
        ifIdent += 2;
        spacing();
        ifIdent -= 2;
    }

    /**
     * PostVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void postVisit(IfStatement stmt) {

        spacing();
        sb.append(")\n");
        ifIdent = 0;
        spacing();
        sb.append(")\n");
    }

    /**
     * Helper method that checks for a parenthesis
     */
    public void checkForParenthesis() {
        if (sb.lastIndexOf(")") == sb.length() - 1
                && (sb.lastIndexOf(")") > 0)) {
            sb.append(" ");
        }
    }
    
    /**
     * Helper method for spacing
     */
    public void spacing() {
        for (int i = 0; i < ifIdent; i++) {
            sb.append(" ");
        }
    }
    /**
     * Returns the string builder
     * @return sb.toString() - 
     */
    public String getString() {
        return sb.toString();
    }
}
