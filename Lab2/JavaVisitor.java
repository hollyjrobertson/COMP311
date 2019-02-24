/**
 * JavaVisitor class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class JavaVisitor implements Visitor
{
    /**
     * Global variable for StringBuffer
     */
    StringBuffer sb = new StringBuffer();
    /**
     * Global variable for dowhile indentation 
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
        sb.append(expr.getValue());
    }

    /**
     * Visit Variable Expression method
     * @param expr VariableExpression
     */
    @Override
    public void visit(VariableExpression expr) {
        sb.append(expr.getName());
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
        sb.append(expr.getOperator());
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
     * @param stmt AssignStatement
     */
    @Override
    public void preVisit(AssignStatement stmt) {
        sb.append(stmt.getVariable().getName() + " = ");
    }

    /**
     * PostVisit AssignStatement method
     * @param stmt AssignStatement
     */
    @Override
    public void postVisit(AssignStatement stmt) {
        sb.append(";\n");
    }

    /**
     * PreVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void preVisit(DoWhileStatement stmt) {
        sb.append("do\n{\n");
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
        sb.append("} while ");
        whileIdent -= 2;
    }

    /**
     * PostVisit DoWhile method
     * @param stmt DoWhileStatement
     */
    @Override
    public void postVisit(DoWhileStatement stmt) {
        sb.append(";\n");
    }

    /**
     * PreVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preVisit(IfStatement stmt) {
        sb.append("if ");
    }

    /**
     * PreThenVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preThenVisit(IfStatement stmt) {
        sb.append("\n{\n");
        ifIdent += 2;
        
        for (int i = 0; i < ifIdent; i++) {
            sb.append(" ");
        }
    }

    /**
     * PreElseVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void preElseVisit(IfStatement stmt) {
        sb.append("}\nelse\n{\n");
        for (int i = 0; i < ifIdent; i++) {
            sb.append(" ");
        }
        
    }

    /**
     * PostVisit If method
     * @param stmt IfStatement
     */
    @Override
    public void postVisit(IfStatement stmt) {
        sb.append("}\n");
        ifIdent = 0;
    }

    /**
     * Returns the string
     * @return string
     */
    public String getString()
    {
        return sb.toString();
    }
}
