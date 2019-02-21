/**
 * Compound Statement class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class CompoundStatement extends AbstractStatement
{
    /**
     * Constructor 
     * @param stmt of Abstract Statement
     */
    public void addStatement(AbstractStatement stmt) {
    }

    /**
     * Takes a visitor and traverse
     */
    @Override
    public void accept(Visitor v)
    {
    }
}
