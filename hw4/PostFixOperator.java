import java.util.Stack;

public class PostFixOperator extends AbstractVisitor {
	
	Stack<String> stack = new Stack<String>();
	
	@Override
	public void preVisit(BinaryExpression expr) {
		stack.push(expr.getOperation().toString());
	}
	
	
	@Override
	public void visit(ConstantExpression expr) {
		stack.push("" + expr.getValue());
	}
	
	public String getResult() {
		String result = "";
		while(!(stack.isEmpty())) {
			result = result + stack.pop() + " "; 
		}
		return result;
	}
}
