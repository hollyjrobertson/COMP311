import java.util.*;

/**
 * Program that parses and sets operation based on each line
 * 
 * @author Holly Robertson
 * @version 1.0
 */
public class ParseProgram {
    private int counter;
    private int[] globals;
    private List<String> program;
    private Stack<Integer> stack = new Stack<>();

    /**
     * Constructor method
     * 
     * @param str     of code
     * @param globals that keep track
     */
    public ParseProgram(Scanner str, int[] globals) {
        this.counter = 0;
        this.globals = globals;
        this.program = parseProgram(str);
    }

    /**
     * Program that parses the and adds each line to ArrayList
     * 
     * @param str of code
     * @return an ArrayList of each line at each index
     */
    private List<String> parseProgram(Scanner str) {
        List<String> prog = new ArrayList<>();

        while (str.hasNextLine()) {
            prog.add(str.nextLine());
        }
        return prog;
    }

    /**
     * Executable method that parses and sets the operation class for each line
     * 
     * @return the counter
     */
    public int[] execute() {
        while (counter < program.size()) {
            String currentLine = program.get(counter);

            if (currentLine.contains("i32.const")) {
                String value = currentLine.split(" ")[1];
                Integer intValue = Integer.parseInt(value);
                stack.push(intValue);

                counter++;
            }

            if (currentLine.contains("set_global")) {
                String value = currentLine.split(" ")[1];
                Integer intValue = Integer.parseInt(value);
                stack.push(intValue);

                GetSetOperation setGlobal = 
                    new GetSetOperation(GetSetOperation.Type.Set);

                counter = setGlobal.execute(counter, stack, globals);
            }

            if (currentLine.contains("get_global")) {
                String value = currentLine.split(" ")[1];
                Integer intValue = Integer.parseInt(value);
                stack.push(intValue);

                GetSetOperation getGlobal = 
                        new GetSetOperation(GetSetOperation.Type.Get);

                counter = getGlobal.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.add")) {
                BinaryOperation add = 
                        new BinaryOperation(BinaryOperation.Type.Add);
                
                counter = add.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.sub")) {
                BinaryOperation sub = 
                    new BinaryOperation(BinaryOperation.Type.Sub);
    
                counter = sub.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.mul")) {
                BinaryOperation mul = 
                    new BinaryOperation(BinaryOperation.Type.Mul);
         
                counter = mul.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.div")) {
                BinaryOperation div =
                    new BinaryOperation(BinaryOperation.Type.Div);
                
                counter = div.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.eq") &&
                    (!currentLine.contains("i32.eqz"))) {
                BinaryOperation eq = 
                    new BinaryOperation(BinaryOperation.Type.Eq);
                
                counter = eq.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.ne")) {
                BinaryOperation ne = 
                    new BinaryOperation(BinaryOperation.Type.Ne);
                
                counter = ne.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.gte")) {
                BinaryOperation gte = 
                        new BinaryOperation(BinaryOperation.Type.Gte);
                
                counter = gte.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.gt") &&
                    (!currentLine.contains("i32.gte"))) {
                BinaryOperation gt = 
                    new BinaryOperation(BinaryOperation.Type.Gt);
               
                counter = gt.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("i32.lt") && 
                    (!currentLine.contains("i32.lte"))) {
                BinaryOperation lt = 
                        new BinaryOperation(BinaryOperation.Type.Lt);
                
                counter = lt.execute(counter, stack, globals);
            }
        }
        return globals;
    }
}
