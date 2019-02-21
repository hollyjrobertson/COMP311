/**
 * DoWhileStatement
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class DoWhileStatement extends AbstractStatement
{
    /**
     * Constrcutor
     * @param aBody AbstractExpression
     * @param aCondition AbstractExpression
     */
    public DoWhileStatement(AbstractStatement aBody,
            AbstractExpression aCondition) {
    }

    /**
     * Accepts a visitor and traverses
     */
    @Override
    public void accept(Visitor vis) {
    }
}
