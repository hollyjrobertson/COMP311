/**
 * Interface for objects that can be visited.
 * 
 * @author Tim
 * @version 1.0
 */
public interface Visitable
{
    /**
     * Accepts a Visitor.
     * 
     * @param vis the visitor
     */
    void accept(Visitor vis);
}
