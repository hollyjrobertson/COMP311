/**
 * Assign Statement class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class AssignStatement extends AbstractStatement
{
    /**
     * Constructor
     * @param aVar variable expression
     * @param aValue abstract expression
     */
    public AssignStatement(VariableExpression aVar, AbstractExpression aValue) {
    }

    /**
     * GetVariable() method
     * @return aVar expression
     */
    public VariableExpression getVariable() {
        return null;
    }

    /**
     * Accepts visitor to traverse
     */
    @Override
    public void accept(Visitor vis) {
    }
}
