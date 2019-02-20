/**
 * Abstract visitor class
 *
 * @author TKington
 * @version Feb 3, 2007
 */
public abstract class AbstractVisitor implements Visitor
{
    public void preVisit(BinaryExpression expr) {}
    public void visit(BinaryExpression expr) {}
    public void postVisit(BinaryExpression expr) {}
    public void visit(ConstantExpression expr) {}
}
