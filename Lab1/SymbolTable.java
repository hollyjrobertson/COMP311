import java.util.*;

/**
 * Class that sets and gets labels
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class SymbolTable {
    
    /**
     * Public List of labels
     */
    List<SymbolEntry> label = new ArrayList<SymbolEntry>();
    
    /**
     * Method that adds a value to the array list
     * @param name of the label
     * @param value of the line number
     */
    public void setValue(String name, int value) {
        if (this.getValue(name) != null) {
            this.getEntry(name).setValue(value);
        }
        else {
            label.add(new SymbolEntry(name, value));
        }
    }

    /**
     * Get the index of the label
     * @param name to return
     * @return the next line number
     */
    public Integer getValue(String name) {
        for (SymbolEntry s : label) {
            if (s.getLabel().equals(name)) {
                return s.getLine();
            }
        }
        return null;
    }
    
    /**
     * Method to help check if a value already exists 
     * and then can overwrite in setValue()
     * @param name of the label
     * @return a SymbolEntry object or null if not there
     */
    public SymbolEntry getEntry(String name) {
        for (SymbolEntry sym : label) {
            if (sym.getLabel().equals(name)) {
                return sym;
            }
        }
        return null;
    }

    /**
     * Private class of SymbolEntry
     * @author Holly Robertson
     */
    private static class SymbolEntry {
        
        /**
         * Global (in a private class) of the line/label
         */
        String line;
        /**
         * Global (in a private class) of the line number
         */
        int lineNum;
        
        /**
         * Constructor method
         * @param line of code
         * @param lineNum of code
         */
        public SymbolEntry(String line, int lineNum) {
            this.line = line;
            this.lineNum = lineNum;
        }
        
        /**
         * Sets the value of line numbers
         * @param lineNumber of code
         */
        public void setValue(int lineNumber) {
            this.lineNum = lineNumber;
        }
        
        /**
         * Sets line label
         * @param theLine label
         */
        @SuppressWarnings("unused")
        public void setLine(String theLine) {
            this.line = theLine;
        }
        /**
         * Returns Line number
         * @return line number of label
         */
        public int getLine() {
            return lineNum;
        }
        
        /**
         * Returns label 
         * @return label of code
         */
        public String getLabel() {
            return line;
        }
    }
}

