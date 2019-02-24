/**
 * If Statement class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class IfStatement extends AbstractStatement
{
    /**
     * Global object for aCondition
     */
    AbstractExpression aCondition;
    /**
     * Global object for aThenBlock
     */
    AbstractStatement aThenBlock;
    /**
     * Abstract Statement for anElseBlock
     */
    AbstractStatement anElseBlock;
    
    /**
     * Constructor
     * @param aCondition AbstractExpression
     * @param aThenBlock AbstractExpression
     */
    public IfStatement(AbstractExpression aCondition,
        AbstractStatement aThenBlock) {
        this.aCondition = aCondition;
        this.aThenBlock = aThenBlock;
    }

    /**
     * Second Constructor
     * @param aCondition AbstractExpression
     * @param aThenBlock AbstractStatement
     * @param anElseBlock AbstractStatement
     */
    public IfStatement(AbstractExpression aCondition,
        AbstractStatement aThenBlock, AbstractStatement anElseBlock) {
        this.aCondition = aCondition;
        this.aThenBlock = aThenBlock;
        this.anElseBlock = anElseBlock;
    }

    /**
     * Else Block method
     * @return AbstractStatement
     */
    public AbstractStatement getElseBlock() {
        return anElseBlock;
    }

    /**
     * Accepts a visitor and traverses
     */
    @Override
    public void accept(Visitor vis) {
        vis.preVisit(this);
        aCondition.accept(vis);
        vis.preThenVisit(this);
        aThenBlock.accept(vis);
        if (getElseBlock() != null) {
            vis.preElseVisit(this);
            anElseBlock.accept(vis);
        }
        vis.postVisit(this);
    }
}
