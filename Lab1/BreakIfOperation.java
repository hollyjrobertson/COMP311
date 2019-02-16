import java.util.Stack;

/**
 * Break If Operation class
 * 
 * @author Holly Robertson
 * @version 1.0
 *
 */
public class BreakIfOperation implements Operation {

    /**
     * String name to search / label
     */
    String name;
    /**
     * Label in the symbol table
     */
    SymbolTable label;
    
    /**
     * Constructor
     * @param name of label to break to
     * @param label in the symbol table
     */
    public BreakIfOperation(String name, SymbolTable label) {
        this.name = name;
        this.label = label;
    }
    
    /**
     * Overrides the execute method from Operation interface
     * @param programCounter of program
     * @param stack is what keeps track of the numbers 
     * @param globals is the assigned variables
     * @return programCounter - the next line in the program
     */
    @Override
    public int execute(int programCounter, 
            Stack<Integer> stack, int[] globals) {
        
        if (stack.pop() == 0) {
            return programCounter + 1;
        }
        
        return label.getValue(name);
    }

}
