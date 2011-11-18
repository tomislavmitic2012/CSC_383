import java.io.PrintStream;

/**
 * Test driver for Binary Tree class
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Test {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static < T extends Comparable<? super T > > void process( BinaryTree< T > tree ) {
		Test.output.println( "The height of the tree = " + tree.height() );
		Test.output.println( "The size of the tree = " + tree.size() );
		
		Test.output.println( "\nTree : inorder :\n" );
		tree.inorder();
		
		Test.output.println( "\nTree : inorder1 :\n" );
		tree.inorder1();
		
		Test.output.println( "\nTree : inorder2:\n" );
		tree.inorder2();
		
		Test.output.println( "\nTree : preorder :\n" );
		tree.preorder();
		
		Test.output.println( "\nTree : preorder2 :\n" );
		tree.preorder2();
		
		Test.output.println( "\nTree : postorder :\n" );
		tree.postorder();
		
		Test.output.println( "\nTree : postorder2 :\n" );
		tree.postorder2();
		
		Test.output.println( "\nTree : postorder3 :\n" );
		tree.postorder( 0 );
		
		Test.output.println( "\nTree : by Level order :\n" );
		tree.bylevel();
		
		Test.output.println( "\nTree : by Level order version 2 :\n" );
		tree.bylevel2();
		
		Test.output.println( "\nTree : by Level order version 3 :\n" );
		tree.bylevel3();
	}
	
	public static void main( String[] args ) {
		String[] nodes = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
				"Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		BinaryTree< String > tree = new BinaryTree< String >( nodes );
		Test.process( tree );
		Test.output.println("---------------------------------------------------");
		
		Test.output.println( "Test Copy Constructor and mirror for first tree: ");
		Test.process( ( new BinaryTree< String >( tree ) ).mirror() );
		
		Test.output.println("---------------------------------------------------");
		
		String[] pre = { "Jun", "Mar", "Jan", "Feb", "Apr", "May", "Sep", "Jul",
				"Aug", "Nov", "Oct", "Dec" };
		BinaryTree< String > tree2 = new BinaryTree< String >( pre, nodes );
		Test.process( tree2 );
		Test.output.println("---------------------------------------------------");
		
		Test.output.println( "Test Copy Constructor and mirror for second tree: ");
		Test.process( ( new BinaryTree< String >( tree2 ) ).mirror() );
		
		Test.output.println("---------------------------------------------------");
		
		Integer[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
		BinaryTree< Integer > tree3 = new BinaryTree< Integer >( num );
		Test.process( tree3 );
		Test.output.println("---------------------------------------------------");
		
		Test.output.println( "Test Copy Constructor and mirror for third tree: ");
		Test.process( ( new BinaryTree< Integer >( tree3 ) ).mirror() );
		
		Test.output.println("---------------------------------------------------");
	}
}