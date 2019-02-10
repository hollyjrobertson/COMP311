import java.util.Scanner;

/**
 * Main Class that runs the program
 * @author Holly Robertson
 * @version 1.0
 */
public class WAEngine {
    
    private ParseProgram parseProgram;
    
    /**
     * Constructor method for WAEngine
     * @param program to parse
     * @param globals to keep track 
     */
    public WAEngine(Scanner program, int [] globals) {
        this.parseProgram = new ParseProgram(program, globals);
        this.run();
    }

    /**
     * Executable method that runs the code and sets value
     */
    public void run() {
        parseProgram.run();
    }
}
