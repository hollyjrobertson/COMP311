/**
 * Visitable interface
 * 
 * @author TKington
 * @version Feb 3, 2007
 */
public interface Visitable
{
    /**
     * Accepts a AbstractVisitor.
     * 
     * @param visitor
     */
    void accept(AbstractVisitor visitor);
}
