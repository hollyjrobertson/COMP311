import java.util.*;

/**
 * Get Set Operation Class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class GetSetOperation implements Operation {
     /**
     * Get / Set enum types
     * 
     * @author Holly Robertson
     */
    public enum Type {
        /** Get */
        Get,
        /** Set */
        Set
    }
    
    private Type type;
    
    /**
     * Constructor method that sets type for object
     * @param type either Get or Set
     */
    public GetSetOperation(Type type) {
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
    public int execute(int programCounter, Stack<Integer> stack, int[] globals)
    {
        switch (type) {
            case Get:
                stack.push(globals[stack.pop()]);
                break;
            case Set:
                globals[stack.pop()] = stack.pop(); //push(index), push value
                break;
        }
        
        return programCounter + 1;
    }

}

