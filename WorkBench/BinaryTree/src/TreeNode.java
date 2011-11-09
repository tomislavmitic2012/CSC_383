/**
 * TreeNode class serves as the Node for the binary tree.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class TreeNode<T extends Comparable<? super T > > {
	private TreeNode< T > self = this;
	
	protected T value;
	protected TreeNode< T > left;
	protected TreeNode< T > right;

	public TreeNode( T val ) {
		self.value = val;
		self.left = null;
		self.right = null;
	}
	
	public TreeNode( TreeNode< T > other ) {
		self.value = other.get_val();
		self.left = other.get_left();
		self.right = other.get_right();
	}
	
	public T get_val() {
		return self.value;
	}
	
	public TreeNode< T > get_left() {
		return self.left;
	}
	
	public TreeNode< T > get_right() {
		return self.right;
	}
	
	public void set_val( T val ) {
		self.value = val;
	}
	
	public void set_Left( TreeNode< T > x ) {
		self.left = x;
	}
	
	public void setLeft( T x ) {
		self.left = new TreeNode< T >( x );;
	}
	
	public void set_right( T x ) {
		self.right = new TreeNode< T >( x );
	}
	
	public void set_right( TreeNode< T > x ) {
		self.right = x;
	}
	
	public TreeNode() {
		self.value = null;
		self.left = null;
		self.right = null;
	}
	
	@Override
	public String toString() {
		
		String tmp = "" + value;
		return tmp;
	}
}

/**
 * Temp is used for stack/queue, it consists of TreeNode and integer
 * 
 * @author Tomislav S. Mitic
 *
 */
class Temp< T extends Comparable<? super T > > {
	private Temp< T > self = this;
	
	TreeNode< T > tnode;
	int n;
	
	public Temp( TreeNode< T > node, int x ) {
		self.tnode = node;
		self.n = x;
	}
	
	public TreeNode< T > get_node() {
		return self.tnode;
	}
	
	public int get_n() {
		return self.n;
	}
	
	public void set_n( int n ) {
		self.n = n;
	}
}

/**
 * Consists of a pair of TreeNodes and an integer
 * 
 * @author Tomislav S. Mitic
 *
 */
class Temp2< T extends Comparable<? super T > > {
	private Temp2< T > self = this;
	TreeNode< T > tnode1, tnode2;
	int n;
	
	public Temp2( TreeNode< T > node1, TreeNode< T > node2, int x ) {
		self.tnode1 = node1;
		self.tnode2 = node2;
		self.n = x;
	}
	
	public TreeNode< T > get_node1() { 
		return self.tnode1;
	}
	
	public TreeNode< T > get_node2() { 
		return self.tnode2;
	}
	
	public int get_n() {
		return self.n;
	}
	
	public void set_n( int n ) {
		self.n = n;
	}
}