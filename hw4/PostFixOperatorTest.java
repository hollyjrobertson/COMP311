import junit.framework.TestCase;

public class PostFixOperatorTest extends TestCase {

	BinaryExpression expr;
	ConstantExpression con;
	PostFixOperator v;
	
	protected void setUp() throws Exception {
		expr = new AddExpression(
				new ConstantExpression(5), new ConstantExpression(3));
		v = new PostFixOperator();	
	}

	protected void tearDown() throws Exception {
		expr = null;
	}

	public void testPreVisit() {
		expr.accept(v);
		String lines[] = v.getResult().split(" ");
		
		assertEquals("+", lines[2]);
	}

	public void testVisitConstantExpression() {
		expr.accept(v);
		String lines[] = v.getResult().split(" ");
		
		assertEquals("3", lines[0]);
	}

	public void testGetResult() {
		String answer = "3 5 + ";
		expr.accept(v);

		assertEquals(answer, v.getResult());
	}
}
