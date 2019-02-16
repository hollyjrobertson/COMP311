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
    private SymbolTable label = new SymbolTable();

        /**
         * Constructor method
         * Calls the parseProgram to initiate parsing
         * @param str of code to parse
         * @param globals that keep track of the assigned variables
         */
    public ParseProgram(Scanner str, int[] globals) {
        this.counter = 0;
        this.globals = globals;
        this.program = parseProgram(str);
    }

        /**
         * Program that parses the and adds each line to ArrayList
         * Checks to see if there is a label
         * If there is a label - adds it to SymbolTable
         * @param str of code to parse
         * @return an ArrayList of each line at each index
         */
    private List<String> parseProgram(Scanner str) {
        List<String> prog = new ArrayList<>();
        
        int pc = 0;
        while (str.hasNextLine()) {
            String current = str.nextLine();
            if (current.split(" ")[0].contains(":")) {
                label.setValue(current.substring(0, current.indexOf(":")), pc);
                prog.add(current.substring(current.indexOf(":") + 2));
            }
            else {
                prog.add(current);
            }
 
            pc++;
        }
        return prog;
    }
    
        /**
         * Executable method that parses and sets the operation
         * class for each line
         * @return the counter - line # of code
         */
    public int[] run() {
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

                setGlobal.execute(counter, stack, globals);
                counter++;
            }

            if (currentLine.contains("get_global")) {
                String value = currentLine.split(" ")[1];
                Integer intValue = Integer.parseInt(value);
                stack.push(intValue);

                GetSetOperation getGlobal = 
                            new GetSetOperation(GetSetOperation.Type.Get);

                getGlobal.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.add")) {
                BinaryOperation add = 
                            new BinaryOperation(BinaryOperation.Type.Add);
                    
                add.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.sub")) {
                BinaryOperation sub = 
                        new BinaryOperation(BinaryOperation.Type.Sub);
        
                sub.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.mul")) {
                BinaryOperation mul = 
                        new BinaryOperation(BinaryOperation.Type.Mul);
             
                mul.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.div")) {
                BinaryOperation div =
                        new BinaryOperation(BinaryOperation.Type.Div);
                    
                div.execute(counter, stack, globals);
                counter++;
            }
            if (currentLine.contains("i32.eqz")) {
                BinaryOperation eqz = 
                        new BinaryOperation(BinaryOperation.Type.Eqz);
                
                eqz.execute(counter, stack, globals);
                counter++;
            }
            
            if (currentLine.contains("i32.eq") &&
                        (!currentLine.contains("i32.eqz"))) {
                BinaryOperation eq = 
                        new BinaryOperation(BinaryOperation.Type.Eq);
                    
                eq.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.ne")) {
                BinaryOperation ne = 
                        new BinaryOperation(BinaryOperation.Type.Ne);
                    
                ne.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.gte")) {
                BinaryOperation gte = 
                            new BinaryOperation(BinaryOperation.Type.Gte);
                    
                gte.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.gt") &&
                (!currentLine.contains("i32.gte"))) {
                BinaryOperation gt = 
                        new BinaryOperation(BinaryOperation.Type.Gt);
                   
                gt.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.lte")) {
                BinaryOperation lte = 
                            new BinaryOperation(BinaryOperation.Type.Lte);
                    
                lte.execute(counter, stack, globals);
                counter++;
            }
                
            if (currentLine.contains("i32.lt") && 
                (!currentLine.contains("i32.lte"))) {
                BinaryOperation lt = 
                            new BinaryOperation(BinaryOperation.Type.Lt);
                    
                lt.execute(counter, stack, globals);
                counter++;
            }
 
            if (currentLine.contains("br") && 
                (!currentLine.contains("br_if"))) {
                BreakOperation br = 
                        new BreakOperation(currentLine.split(" ")[1]
                                .replace(":", ""), label);
           
                counter = br.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("br_if")) {
                BreakIfOperation brif = 
                        new BreakIfOperation(currentLine.split(" ")[1]
                                .replace(":", ""), label);
                
                counter = brif.execute(counter, stack, globals);
            }
            
            if (currentLine.contains("nop")) {
                counter++;
            }
        }
        return globals;
    }
}

