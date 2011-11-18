import java.io.PrintStream;
import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

/**
 * class BinaryTree< T extends Comparable<? super T> >
 * 
 * @author Tomislav S. Mitic
 *
 */
public class BinaryTree< T extends Comparable<? super T> > {
	private static final PrintStream output = new PrintStream( System.out );
	private BinaryTree< T > self = this;
	
	protected TreeNode< T > root;

	public TreeNode< T > get_root() {
		return self.root;
	}
	
	/**
	 * Default constructor
	 */
	public BinaryTree() {
		self.root = null;
	}

	/**
	 * Constructor that creates a single node tree
	 * 
	 * @param node
	 */
	public BinaryTree( TreeNode< T > node ) {
		self.root = new TreeNode< T >( node );
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param other
	 */
	public BinaryTree( BinaryTree< T > other ) {
		self.root = self.copy( other.get_root() );
	}
	
	private TreeNode< T > copy( TreeNode< T > other ) {
		if ( other == null ) return other;
		else {
			TreeNode< T > temp = new TreeNode< T >();
			temp.set_val( other.get_val() );
			temp.set_Left( self.copy( other.get_left() ) );
			temp.set_right( self.copy( other.get_right() ) );
			return temp;
		}
	}
	
	/**
	 * This constructor takes an array of nodes as a parameter, and builds a balanced binary tree,
	 * using the middle element as the root, every node to the left of the middle element goes to
	 * the left sub tree, every node to the right of the middle element, goes to
	 * the right subtree, recursively.
	 * 
	 * @param nodes
	 */
	public BinaryTree( T[] nodes ) {
		self.root = self.build( nodes );
	}
	
	/**
	 * Auxiliary methods
	 */
	TreeNode< T > build( T[] nodes ) {
		return self.build(nodes, 0, nodes.length - 1 );
	}
	
	TreeNode< T > build( T[] nodes, int l, int r ) {
		if ( l == r ) { return new TreeNode< T >( nodes[ l ] ); }
		else if ( l > r ) { return null; }
		else {
			int m = ( l + r ) / 2;
			TreeNode< T > root = new TreeNode< T >( nodes[ m ] );
			root.set_Left( self.build( nodes, l, m - 1 ) );
			root.set_right( self.build( nodes, m + 1, r ) );
			return root;
		}
	}
	
	/**
	 * This constructor takes preorder and inorder traversal sequences of the nodes,
	 * and builds the binary tree.
	 * 
	 * @param pre
	 * @param in
	 */
	public BinaryTree( T[] pre, T[] in ) {
		self.root = self.rebuild( pre, in );
	}

	/**
	 * Helper function that actually rebuilds the tree recursively
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	TreeNode< T > rebuild( T[] pre, T[] in ) {
		return self.rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1 );
	}
	
	TreeNode< T > rebuild( T[] pre, int pre_i, int pre_j, T[] in, int in_i, int in_j ) {
		TreeNode< T > node = null;
		T[] leftPreOrder, rightPreOrder, leftInOrder,
			rightInOrder;
		int inorderPos, preorderPos;
		
		if ( pre.length != 0 && in.length != 0 ) {
			// Assign the first element of preorder traversal as root
			node = new TreeNode< T >();
			node.set_val( ( T )pre[ 0 ]);
			
			// Based upon the current node data separate the traversals into peftPreOrder, rightPreOrder,
			// leftInOrder, rightInOrder arrays
			inorderPos = index( pre[ 0 ], in, 0, in_j );
			leftInOrder = Arrays.copyOfRange( in, in_i, inorderPos );
			rightInOrder = Arrays.copyOfRange( in, inorderPos + 1, in_j + 1 );
			
			preorderPos = leftInOrder.length;
			leftPreOrder = Arrays.copyOfRange( pre, pre_i + 1, preorderPos + 1 );
			rightPreOrder = Arrays.copyOfRange( pre, preorderPos + 1, pre_j + 1 );
			
			node.set_Left( self.rebuild( leftPreOrder, leftInOrder) );
			node.set_right( self.rebuild( rightPreOrder, rightInOrder ) );
		}
		
		return node;
	}
	
	/**
	 * Helper function, return -1 if not found, otherwise the position of x in the list
	 * 
	 * @param myObject
	 * @param myArray
	 * @return index of object in array else -1
	 */
	private int index( T x, T[] myArray, int i, int j ) {
		for ( int index = i, max = j; i <= max; index++ ) {
			if ( myArray[ index ].compareTo( x ) == 0 ) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 * size() returns the total number of nodes in the tree
	 * 
	 * @return size of the tree
	 */
	public int size() {
		return self.size( root );
	}
	
	private int size( TreeNode< T > x ) {
		if ( x == null ) return 0;
		else { return ( self.size( x.get_left() ) + 1 + self.size( x.get_right() ) ); } 
	}
	
	/**
	 * height() returns the height of the tree
	 * 
	 * @return height of the tree
	 */
	public int height() {
		return height( root );
	}
	
	private int height( TreeNode< T > x ) {
		if ( x == null ) return 0;
		else {
			int lHeight = self.height( x.get_left() ),
				rHeight = self.height( x.get_right() );
			
			// use the larger + 1
			return ( Math.max( lHeight, rHeight ) + 1 );
		}
	}
	
	/**
	 * Recursive inorder traversal
	 */
	public void inorder() {
		self.inorder( self.root );
	}
	
	private void inorder( TreeNode< T > r) {
		if ( r == null ) return;
		self.inorder( r.get_left() );
		BinaryTree.output.println( r.get_val() );
		self.inorder( r.get_right() );
	}
	
	public void inorder1() {
		self.inorder1( self.root, null, 0 );
	}
	
	void inorder1( TreeNode< T > r, TreeNode< T > papa, int level ) {
		if ( r == null ) return;
		self.inorder1( r.get_left(), r, level + 1);
		BinaryTree.output.println("Level#:\t" + level + " " + r.get_val() + 
				"\t:, parent: " + ( papa != null ? papa.get_val() : null ) + "\t, left: " + 
				( r.get_left() != null ? r.get_left().get_val() : null) +  "\t, right: " + 
				( r.get_right() != null ? r.get_right().get_val() : null ) );
		self.inorder1(r.get_right(), r, level + 1 );
	}
	
	public void inorder2() {
		self.inorder2( root );
	}
	
	private void inorder2( TreeNode< T > r ) {
		if ( r == null ) return;
		
		TreeNode< T > cur = r;
		TreeNode< T > prev = null;
		
		Stack < TreeNode< T > > stk = new Stack< TreeNode< T > >();
		
		// incoming node is root
		while (!stk.isEmpty() || cur != null ) {
			if ( cur != null ) {
				stk.push( cur );
				prev = cur;
				cur = prev.get_left();
			} else {
				cur = stk.pop();
				BinaryTree.output.println( cur.get_val() );
				prev = cur;
				cur = prev.get_right();
			}
		}
	}
	
	/**
	 * Recursive preorder traversal
	 */
	public void preorder() {
		self.preorder( self.root );
	}
	
	private void preorder( TreeNode< T > r ) {
		if ( r == null ) return;
		BinaryTree.output.println( r.get_val() );
		self.preorder( r.get_left() );
		self.preorder( r.get_right() );
	}
	
	public void preorder2() {
		self.preorder2( self.root );
	}
	
	private void preorder2( TreeNode< T > r ) {
		if ( r == null ) return;
		
		TreeNode< T > cur = r;
		TreeNode< T > prev = null;
		
		Stack < TreeNode< T > > stk = new Stack< TreeNode< T > >();
		
		stk.push( cur );
		while ( !stk.isEmpty() ) {
			prev = stk.pop();
			TreeNode< T > right = prev.get_right();
			if ( right != null ) {
				stk.push( right );
			}
			TreeNode< T > left = prev.get_left();
			if ( left != null ) {
				stk.push( left );
			}
			BinaryTree.output.println( prev.get_val() );
		}
	}
	
	/**
	 * Recursive postorder traversal
	 */
	public void postorder() {
		self.postorder( root );
	}
	
	private void postorder( TreeNode< T > r ) {
		if ( r == null ) return;
		self.postorder( r.get_left() );
		self.postorder( r.get_right() );
		BinaryTree.output.println( r.get_val() );
	}
	
	/**
	 * Recursive postorder traversal, also display the level number of each node
	 * 
	 * @param n
	 */
	public void postorder( int n ) {
		postorder( self.root, n );
	}
	
	private void postorder( TreeNode< T > r, int n ) {
		if ( r == null ) return;
		self.postorder( r.get_left(), n + 1 );
		self.postorder( r.get_right(), n + 1 );
		BinaryTree.output.println( r.get_val() + "\tLevel: " + n );
	}
	
	/**
	 * non-recursive postorder traversal, stack is used
	 */
	public void postorder2() {
		self.postorder2( self.root );
	}
	
	private void postorder2( TreeNode< T > r ) {
		if ( r == null ) return;
		
		TreeNode< T > node = r;
		Stack< TreeNode< T > > stk = new Stack< TreeNode< T > >();

		while ( node != null || !stk.isEmpty() ) {
			if ( node == null ) {
				while ( !stk.isEmpty() && node == stk.peek().get_right() ) {
					node = stk.pop();
					BinaryTree.output.println( node.get_val() );
				}
				node = stk.isEmpty() ? null : stk.peek().get_right();
			}
			if ( node != null ) {
				stk.push( node );
				node = node.get_left();
			}
		}
	}
	
	/**
	 * Print the tree by the level, using queue
	 */
	public void bylevel() {
		self.bylevel( self.root );
	}
	
	void bylevel( TreeNode< T > r ) {
		if ( r == null ) return;
		
		Queue< TreeNode< T > > que = new LinkedList< TreeNode< T > >();
		
		que.offer( root );
		while( !que.isEmpty() ) {
			TreeNode< T > node = que.poll();
			BinaryTree.output.println( node.get_val() );
			if ( node.get_left() != null ) {
				que.offer( node.get_left() );
			}
			if ( node.get_right() != null ) {
				que.offer( node.get_right() );
			}
		}
	}
	
	/**
	 * Print the tree by level with the level number
	 */
	public void bylevel2() {
		self.bylevel2( self.root );
	}
	
	void bylevel2( TreeNode< T > r ) {
		if ( r == null ) return;
		int nLevel = 0, numNodes = 1;
		
		Queue< Temp< T > > que = new LinkedList< Temp< T > >();
		
		que.offer( new Temp< T >( root, nLevel++ ) );
		for( int i = 0; !que.isEmpty(); i++ ) {
			if ( numNodes == 0 ) {
				numNodes = i * 2;
				nLevel++;
			}
			int level = que.peek().get_n();
			TreeNode< T > node = que.poll().get_node();
			numNodes--;
			BinaryTree.output.println( "Level\t" + level + "\t: " + node.get_val() );
			if ( node.get_left() != null ) {
				que.offer( new Temp< T >( node.get_left(), nLevel ) );
			}
			if ( node.get_right() != null ) {
				que.offer( new Temp< T >( node.get_right(), nLevel ) );
			}
		}
	}
	
	/**
	 * Print the tree recursively, both the level number and the parent node will also be displayed
	 */
	public void bylevel3() {
		self.bylevel3( self.root );
	}
	
	void bylevel3( TreeNode< T > r ) {
		if ( r == null ) return;
		int nLevel = 0, numNodes = 1;
		
		Queue< Temp2< T > > que = new LinkedList< Temp2< T > >();
		
		que.offer( new Temp2< T >( root, null, nLevel++ ) );
		for( int i = 0; !que.isEmpty(); i++ ) {
			if ( numNodes == 0 ) {
				numNodes = i * 2;
				nLevel++;
			}
			int level = que.peek().get_n();
			TreeNode< T > node = que.peek().get_node1();
			TreeNode< T > parent = que.poll().get_node2();
			numNodes--;
			BinaryTree.output.println( "Level\t" + level + "\t: " + node.get_val() + "\tparent :\t" + (parent != null ? parent : "root has no parent!" ) );
			if ( node.get_left() != null ) {
				que.offer( new Temp2< T >( node.get_left(), node, nLevel ) );
			}
			if ( node.get_right() != null ) {
				que.offer( new Temp2< T >( node.get_right(), node,nLevel ) );
			}
		}
	}
	
	/**
	 * Changes the tree into its mirror image.
	 *
 	 *		So the tree... 
     * 			4 
     *		   / \ 
     *	  	  2   5 
     *		 / \ 
     *		1   3
	 *
 	 *		is changed to... 
     *		  4 
     *		 / \ 
     *		5   2 
     *		   / \ 
     *		  3   1
	 *
 	 *	Uses a recursive helper that recurs over the tree, 
 	 *	swapping the left/right pointers. 
	 */
	public BinaryTree< T > mirror() {
		self.mirror( self.get_root() );
		return self;
	}
	
	private void mirror( TreeNode< T > node ) {
		if ( node != null ) {
			// do the sub trees
			self.mirror( node.get_left() );
			self.mirror( node.get_right() );
			
			// swap the left/right pointers
			TreeNode< T > temp = node.get_left();
			node.set_Left( node.get_right() );
			node.set_right( temp );
		}
	}
}