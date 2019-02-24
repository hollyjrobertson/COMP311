/**
 * VariableExpression class
 * 
 * @author Holly Robertson
 * @version 1.0
 *
 */
public class VariableExpression extends AbstractExpression
{
    private int index;

    /**
     * Constructor 
     * @param index of "globals"
     */
    public VariableExpression(int index) {
        this.index = index;
    }

    /**
     * Returns the index passed into the constructor
     * @return index of object
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * Returns the variable name.
     * @return the variable name
     */
    public char getName() {
        return (char)('a' + index);
    }

    /**
     * Accept method that takes visitor
     * @param vis is the passing visitor
     */
    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }

}
