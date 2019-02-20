public class DivideExpression extends BinaryExpression
{
    public DivideExpression(Expression left, Expression right)
    {
        super(left, right);
    }
    
    /**
     * @see Expression#getOperation()
     */
    public Operation getOperation()
    {
        return ConcreteOperation.DIVIDE;
    }

	@Override
	public int compute() {
		// TODO Auto-generated method stub
		return 0;
	}
}
