/**
 * If Statement class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class IfStatement extends AbstractStatement
{
    /**
     * Constructor
     * @param aCondition AbstractExpression
     * @param aThenBlock AbstractExpression
     */
    public IfStatement(AbstractExpression aCondition,
        AbstractStatement aThenBlock) {
    }

    /**
     * Second Constructor
     * @param aCondition AbstractExpression
     * @param aThenBlock AbstractStatement
     * @param anElseBlock AbstractStatement
     */
    public IfStatement(AbstractExpression aCondition,
        AbstractStatement aThenBlock, AbstractStatement anElseBlock) {
    }

    /**
     * Else Block method
     * @return AbstractStatement
     */
    public AbstractStatement getElseBlock() {
        return null;
    }

    /**
     * Accepts a visitor and traverses
     */
    @Override
    public void accept(Visitor vis) {
    }
}
