import node_stack.NodeStack;;

/**
 * Test our program by performing a series of operations on stacks,
 * printing the operations performed, the returned elements and the
 * contents of the stack involved, after each operation.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Test {
	public static void main( String[] args ) {
		Object o;
		NodeStack< Integer > A = new NodeStack< Integer >();
		A.status( "New NodeStack< Integer > A", null );
		try {
			A.push( 7 );
			A.status( "A.push( 7 )", null );
			
			o = A.pop();
			A.status( "A.pop()", o );
			
			A.push( 9 );
			A.status( "A.push( 9 )", null );
			
			o = A.pop();
			A.status( "A.pop()", o );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		NodeStack< String > B = new NodeStack< String >();
		A.status( "New NodeStack< String > B", null );
		
		try {
			B.push( "Bob" );
			B.status( "B.push( \"Bob\" )", null );
			
			B.push( "Alice" );
			B.status( "B.push( \"Alice\" )", null );
			
			o = B.pop();
			B.status( "B.pop()", o );
			
			B.push( "Eve" );
			B.status( "B.push( \"Eve\" )", null );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}