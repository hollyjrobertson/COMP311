/**
 * Binary Expression class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class BinaryExpression extends AbstractExpression {
    /**
     * Public AbstractExpression left node
     */
    AbstractExpression left;
    /**
     * Public AbstractExpression right node
     */
    AbstractExpression right;
    /**
     * Public Operation symbol
     */
    Operator op;

    /**
     * Public constructor
     * 
     * @param left  AbstractExpression node
     * @param op    Operation symbol
     * @param right AbstractExpression node
     */
    public BinaryExpression(AbstractExpression left,
            Operator op, AbstractExpression right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    /**
     * Returns the operator of the Binary Expression
     * 
     * @return op - operation
     */
    public Operator getOperator() {
        return op;
    }

    /**
     * Accepts the visitor to traverse tree
     * 
     * @param v - visitor
     */
    @Override
    public void accept(Visitor v) {
        if (v instanceof WATextVisitor) {
            v.preVisit(this);
            v.visit(this);
            left.accept(v);
            right.accept(v);
            v.postVisit(this);
        } 
        else if (v instanceof JavaVisitor) {
            v.preVisit(this);
            left.accept(v);
            v.visit(this);
            right.accept(v);
            v.postVisit(this);
        } 
        else {
            v.preVisit(this);
            left.accept(v);
            right.accept(v);
            v.visit(this);
            v.postVisit(this);
        }
    }
}
