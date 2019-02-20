import java.util.Stack;

/**
 * This class will compute the result of an expression.
 * 
 * @author TKington
 * @version Feb 3, 2007
 */
public class ComputeVisitor extends AbstractVisitor
{
    //  Override and implement necessary methods here.  Note that you
    //  may not need to override all of the methods in the AbstractVisitor class.
    Stack<Integer> s = new Stack<Integer>();
    
    @Override
    public void visit(ConstantExpression expr) {
    	s.push(expr.getValue());
    }
    
    public Integer getResult() {
        return s.pop();
    }
}
