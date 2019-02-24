/**
 * Assign Statement class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class AssignStatement extends AbstractStatement
{
    /**
     * Global object for aVar
     */
    VariableExpression aVar;
    /**
     * Global object for aValue
     */
    AbstractExpression aValue;
    
    /**
     * Constructor
     * @param aVar variable expression
     * @param aValue abstract expression
     */
    public AssignStatement(VariableExpression aVar, AbstractExpression aValue) {
        this.aVar = aVar;
        this.aValue = aValue;
    }

    /**
     * GetVariable() method
     * @return aVar expression
     */
    public VariableExpression getVariable() {
        return aVar;
    }

    /**
     * Accepts visitor to traverse
     * @param vis - Visitor to traverse
     */
    @Override
    public void accept(Visitor vis) {
        if (vis instanceof WATextVisitor) {
            vis.preVisit(this);
            aValue.accept(vis);
            vis.postVisit(this);
        } 
        else if (vis instanceof JavaVisitor) {
            vis.preVisit(this); 
            aValue.accept(vis);
            vis.postVisit(this);
        } 
        else {
            aValue.accept(vis);
            vis.postVisit(this);
        }
    }
}
