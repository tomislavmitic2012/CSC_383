package node;

public class Node {
	private Node self = this;
	
	public int data;
	public Node next;
	
	public Node( int d ) {
		self.data = d;
		self.next = null;
	}
	
	public Node( int d, Node N ) {
		self.data = d;
		self.next = N;
	}
	
	public Node() {
		self.data = 0;
		self.next = null;
	}
	
	public Node( Node other ) {
		self.data = other.data;
		self.next = copy( other.next );
	}
	
	public static Node copy( Node other ) {
		if ( other == null ) return null;
		Node tmp = new Node( other.data );
		other.next = copy( other.next );
		return tmp;
	}
}