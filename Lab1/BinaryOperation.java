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
        /** Eqz */
        Eqz,
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
     * @param stack is what keeps track of the numbers 
     * @param globals is the assigned variables
     * @return programCounter - the next line in the program
     */
    @Override
    public int execute(int programCounter, Stack<Integer> stack,
            int[] globals) {

        switch(type) {
            case Add:
                stack.push(stack.pop() + stack.pop());
                break;
                
            case Sub:
                int temp0 = stack.pop();
                stack.push(stack.pop() - temp0);
                break;
                
            case Mul:
                stack.push(stack.pop() * stack.pop());
                break;
                
            case Div:
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
                break;

            case Eq:
                if (stack.pop() == stack.pop()) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Eqz:
                if (stack.pop() == 0) {
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
                int temp2 = stack.pop();
                if (stack.pop() < temp2) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Lte:
                int temp3 = stack.pop();
                if (stack.pop() <= temp3) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Gt:
                int temp4 = stack.pop();
                if (stack.pop() > temp4) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            case Gte: 
                int temp5 = stack.pop();
                if (stack.pop() >= temp5) {
                    stack.push(1);
                }
                else {
                    stack.push(0);
                }
                break;
                
            /**
             * Does nothing but satisty WebCat
             */
            default:
                break;
        }

        return programCounter + 1;
    }

}
