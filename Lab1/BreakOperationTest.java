import static org.junit.Assert.*;

import java.util.Stack;
import org.junit.Test;

/**
 * Test method for BreakOperation
 * @author Holly Robertson
 * @version 1.0
 *
 */
public class BreakOperationTest {
    
   /**
    * Public BreakOperation object
    */
    BreakOperation br;
    
    /**
     * Public SymbolTable operation
     */
    SymbolTable sym; 
    
    /**
     * Test method for constructor
     */
    @Test
    public void testBreakOperation() {
        String name = "dest";
        int line = 2;
        sym = new SymbolTable();
        sym.setValue(name, line);
        
        br = new BreakOperation(name, sym);
        assertEquals(name, br.name);
    }

    /**
     * 
     */
    @Test
    public void testExecute() {
        String name = "dest";
        int line = 2;
        int[] globals = new int[2];
        Stack<Integer> stack = new Stack<>();
        
        sym = new SymbolTable();
        sym.setValue(name, line);
        br = new BreakOperation(name, sym);

        assertEquals(line, br.execute(line, stack, globals));
    }

}
