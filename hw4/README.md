
### [HW4](https://github.com/hollyjrobertson/COMP311/tree/master/hw4 "HW4")
  #### Problem 1:
  Use the Visitor pattern to create the framework for Lab 1 and include Unit Testing for each class  
  
  #### Problem 2:  
  Starting with the BinaryExpression learning activity solution from this week, write a new class PostfixVisitor that visits an expression tree and returns the    
  expression in postfix notation, with each part of the expression separated by spaces.  For example, if the tree represented the expression 3 + 5, then the postfix 
  result would be “3 5 +”
  ```java
  import java.util.Stack;

public class PostFixOperator extends AbstractVisitor {
	
	Stack<String> stack = new Stack<String>();
	
	@Override
	public void preVisit(BinaryExpression expr) {
		stack.push(expr.getOperation().toString());
	}
	
	
	@Override
	public void visit(ConstantExpression expr) {
		stack.push("" + expr.getValue());
	}
	
	public String getResult() {
		String result = "";
		while(!(stack.isEmpty())) {
			result = result + stack.pop() + " "; 
		}
		return result;
	}
}
```
