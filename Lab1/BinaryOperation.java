import java.util.Stack;

/**
 * Binary Operation class 
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class BinaryOperation implements Operation {
    /**
     * Type of operation
     * @author tim
     * @version 1.0
     *
     */
    public enum Type {
        /** Add */
        Add,
        /** Sub */
        Sub,
        /** Mul */
        Mul,
        /** Div */
        Div,
        /** Eq */
        Eq,
        /** Ne */
        Ne,
        /** Lt */
        Lt,
        /** Lte */
        Lte,
        /** Gt */
        Gt,
        /** Gte */
        Gte
    }

    private Type type;

    /**
     * Binary Operation type
     * @param type of Operation
     */
    public BinaryOperation(Type type) {
        this.type = type;
    }

    /**
     * Overrides the execute method from Operation interface
     * @param programCounter of program
     * @param stack the stack
     * @param globals array
     * @returns programCounter - the next line in the program
     */
    @Override
    public int execute(int programCounter, Stack<Integer> stack,
            int[] globals) {

        switch(type) {
            case Add:
                stack.push(stack.pop() + stack.pop());
                break;
                
            case Sub:
                stack.push(stack.pop() - stack.pop());
                break;
                
            case Mul:
                stack.push(stack.pop() * stack.pop());
                break;
                
            case Div:
                stack.push(stack.pop() / stack.pop());
                break;

            case Eq:
                if (stack.pop() == stack.pop()) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Ne:
                if (stack.pop() != stack.pop()) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Lt:
                if (stack.pop() < stack.pop()) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Lte:
                if (stack.pop() <= stack.pop()) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Gt:
                if (stack.pop() > stack.pop()) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Gte: 
                if (stack.pop() >= stack.pop()) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
        }

        return programCounter + 1;
    }

}
