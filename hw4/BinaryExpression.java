
public abstract class BinaryExpression extends Expression
{
    Expression leftChild;
    Expression rightChild;

    public BinaryExpression(Expression left, Expression right) {
        leftChild = left;
        rightChild = right;
    }
    
    @Override
    public String render() {
    	return "(" + leftChild.render() + getOperation() + rightChild.render() + ")";
    }

    public int compute() {
    	Integer leftVal = leftChild.compute();
    	Integer rightVal = rightChild.compute();
    	return getOperation().apply(leftVal, rightVal);
    }
    
    public void accept(AbstractVisitor visitor)
    {
        visitor.preVisit(this);
        leftChild.accept(visitor);
        visitor.visit(this);
        rightChild.accept(visitor);
        visitor.postVisit(this);
    }

    public abstract Operation getOperation();
}
