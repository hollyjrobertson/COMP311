/**
 * Binary Expression class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class ConstantExpression extends AbstractExpression {
    
    /**
     * Public value of integer
     */
    int val; 
       
    /**
     * Constructor
     * @param val of ConstantExpression
     */
    public ConstantExpression(int val) {
        this.val = val;
    }

    /**
     * Returns the value of the integer
     * @return val of integer
     */
    public int getValue() {
        return val;
    }

    /**
     * Accepts a visitor to traverse 
     * ConstantExpression
     * @param v of visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
