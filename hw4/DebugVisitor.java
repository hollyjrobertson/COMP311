
public class DebugVisitor extends AbstractVisitor 
{

	private StringBuffer sb = new StringBuffer();
	
	@Override
	public void preVisit(BinaryExpression expr) {
		sb.append("preVisit " + expr.getClass().getSimpleName() + "\n");
	}
	
	@Override 
	public void visit(BinaryExpression expr) {
		sb.append("visit " + expr.getClass().getSimpleName() + "\n");
		
	}
	
	@Override
	public void postVisit(BinaryExpression expr) {
		sb.append("postVisit " + expr.getClass().getSimpleName() + "\n");
	}
	
	@Override
	public void visit(ConstantExpression expr) {
		sb.append("visit " + 
				expr.getClass().getSimpleName() + " " + expr.getValue() + "\n");
	}
	
	public String getResult() {
		return sb.toString();
	}
}
