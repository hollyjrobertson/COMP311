/**
 * DoWhileStatement
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class DoWhileStatement extends AbstractStatement
{
    /**
     * Global object for AbstractStatement 
     */
    AbstractStatement aBody;
    /**
     * Global object for AbstractExpression
     */
    AbstractExpression aCondition;
    
    /**
     * Constructor
     * @param aBody AbstractExpression
     * @param aCondition AbstractExpression
     */
    public DoWhileStatement(AbstractStatement aBody,
            AbstractExpression aCondition) {
        this.aBody = aBody;
        this.aCondition = aCondition;
    }

    /**
     * Accepts a visitor and traverses
     * @param vis to traverse
     */
    @Override
    public void accept(Visitor vis) {
        vis.preVisit(this);
        aBody.accept(vis);
        vis.postBodyVisit(this);
        aCondition.accept(vis);
        vis.postVisit(this);
 
    }
}
