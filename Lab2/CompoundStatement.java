import java.util.ArrayList;

/**
 * Compound Statement class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class CompoundStatement extends AbstractStatement
{
    /**
     * Global object for AbstractStatement
     */
    ArrayList<AbstractStatement> list; 
    /**
     * Constructor 
     * @param stmt of Abstract Statement
     */
    public void addStatement(AbstractStatement stmt) {
        if (list == null) {
            list = new ArrayList<AbstractStatement>(); 
        }
        list.add(stmt);
    }

    /**
     * Takes a visitor and traverse
     * @param v to traverse
     */
    @Override
    public void accept(Visitor v)
    {
        for (AbstractStatement s : list) {
            s.accept(v);
        }
    }
}
