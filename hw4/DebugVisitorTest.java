import junit.framework.TestCase;

public class DebugVisitorTest extends TestCase {

	BinaryExpression expr;
	ConstantExpression con;
	DebugVisitor v;
	
	protected void setUp() throws Exception {
		expr = new AddExpression(
				new ConstantExpression(3), new ConstantExpression(5));
		con = new ConstantExpression(5);
		v = new DebugVisitor();
		
	}

	protected void tearDown() throws Exception {
		expr = null;
	}

	public void testGetResult() {
		expr.accept(v);
		String visit = 
				"preVisit AddExpression\n"
				+ "visit ConstantExpression 3\n"
				+ "visit AddExpression\n"
				+ "visit ConstantExpression 5\n"
				+ "postVisit AddExpression\n";
		
		assertEquals(visit, v.getResult());
	}
	
	public void testPreVisit() {
		expr.accept(v);
		String visit = "preVisit AddExpression";
		String lines[] = v.getResult().split("\\r?\\n");
		
		assertEquals(lines[0], visit);
	}

	public void testVisitBinaryExpression() {
		expr.accept(v);
		String visit = "visit AddExpression";
		String lines[] = v.getResult().split("\\r?\\n");
		
		assertEquals(lines[2], visit);
	}

	public void testPostVisit() {
		expr.accept(v);
		String visit = "postVisit AddExpression";
		String lines[] = v.getResult().split("\\r?\\n");
		
		assertEquals(lines[4], visit);
	}

	public void testVisitConstantExpression() {
		con.accept(v);
		String visit = "visit ConstantExpression 5";
		String lines[] = v.getResult().split("\\r?\\n");
		
		assertEquals(lines[0], visit);
	}
}
