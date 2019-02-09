
import java.util.Stack;

/**
 * Represents one statement of the program.
 *
 * @author Tim
 * @version 1.0
 */
public interface Operation
{
    /**
     * Executes the operation.
     *
     * @param programCounter the index of this operation
     * @param stack the current execution stack
     * @param globals the global variables
     * @return the index of the next operation to execute
     */
    int execute(int programCounter, Stack<Integer> stack,
        int[] globals);

}
