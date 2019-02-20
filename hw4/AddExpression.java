
public class AddExpression extends BinaryExpression
{   
    public AddExpression(Expression left, Expression right)
    {
        super(left, right);
    }
    
    /**
     * @see BinaryExpression#getOperation()
     */
    public Operation getOperation()
    {
        return ConcreteOperation.ADD;
    }


}
