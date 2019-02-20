/**
 * 
 */

/**
 * Write a description of class ConcreteOperation here.
 * 
 * @author WhittakT 
 * @version Jan 14, 2007
 */
public class ConcreteOperation implements Operation
{
    private String value;
    
    private ConcreteOperation(String str)
    {
        this.value = str;
    }
    
    public Integer apply(Integer left, Integer right)
    {
        throw new UnsupportedOperationException();
    }
    
    public String toString()
    {
        return this.value;
    }
    
    public static final Operation ADD = new ConcreteOperation("+") {
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() + right.intValue();
        }
    };
    
    public static final Operation SUBTRACT = new ConcreteOperation("-") {
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() - right.intValue();
        }
    };
    
    public static final Operation MULTIPLY = new ConcreteOperation("*") {
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() * right.intValue();
        }
    };
    
    public static final Operation DIVIDE = new ConcreteOperation("/") {
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() / right.intValue();
        }
    };
    
    
}
