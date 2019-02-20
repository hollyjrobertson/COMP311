
public class ConstantExpression extends Expression
{
    Integer value;
    
    public ConstantExpression(Integer value) {
        this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }
    
    @Override
    public String render() {
    	return this.value.toString();
    }
    
    public int compute() {
    	return value.intValue();
    }
    
    public void accept(AbstractVisitor visitor)
    {
        visitor.visit(this);
    }
}
