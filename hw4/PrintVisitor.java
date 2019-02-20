/**
 * This class builds a String representation of an Expression.
 * 
 * @author TKington
 * @version Feb 3, 2007
 */
public class PrintVisitor extends AbstractVisitor
{
    //  Override and implement necessary methods here.  Note that you
    //  may not need to override all of the methods in the AbstractVisitor class.
    private StringBuffer sb = new StringBuffer();
    
    @Override
	public void preVisit(BinaryExpression expr) {
		sb.append("(");
	}
	
    @Override
	public void visit(BinaryExpression expr) {
		sb.append(expr.getOperation());
	}
	
    @Override
	public void postVisit(BinaryExpression expr) {
		sb.append(")");
	}
    
    public void visit(ConstantExpression expr) {
    	sb.append(expr.getValue());
    }
	
    public String getResult() {
        return sb.toString();
    }
}
