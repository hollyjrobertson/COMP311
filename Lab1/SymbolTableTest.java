import static org.junit.Assert.*;
import org.junit.*;


/**
 * Test class
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class SymbolTableTest {

    /**
     * Public object of SymbolTable
     */
    SymbolTable symbol = new SymbolTable();
    

    /**
     * Test setValue method in main class
     */
    @Test
    public void testSetValue() {
        String label = "dest:";
        int line = 0;
        
        symbol.setValue(label, line);
        int answer = symbol.getValue(label);
        
        assertEquals(line, answer);
    }
    
    /**
     * Test setValue for empty 
     */
    @Test
    public void testSetValueEmpty() {
        int line = 0;
        
        symbol.setValue("", line);
        int answer = symbol.getValue("");
        
        assertEquals(0, answer);
    }
    
    /**
     * Test setValue for empty 
     */
    @Test
    public void testSetValue2() {
        String label = "loop";
        int line = 0;
        
        symbol.setValue(label, line);
        symbol.setValue("dest", line);
        
        int answer = symbol.getValue("dest");
        
        assertEquals(0, answer);
    }
    
    /**
     * Test getEntry method that equals
     */
    @Test
    public void testGetEntry() {
        String label = "loop";
        SymbolTable sym2 = new SymbolTable();
        
        symbol.getEntry(label);
        sym2.getEntry(label);
        
        assertEquals(symbol.getClass(), sym2.getClass());
    }
    
    /**
     * Test getValue method in main class for null
     */
    @Test
    public void testGetValueNull() {
        String label = "dest:";
        int line = 0;
        
        symbol.setValue(label, line);
        
        assertEquals(null, symbol.getValue("null"));
    }
}
