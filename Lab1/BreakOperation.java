import java.util.Stack;

/**
 * Break Operation class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class BreakOperation implements Operation {
    
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
    public BreakOperation(String name, SymbolTable label) {
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

        return label.getValue(name);
    }

}
