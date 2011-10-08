package node;

public class Node< E > {
	private Node< E > self = this;
	
	// Instance variables:
	private E element;
	private Node< E > next;
	
	/**
	 * Creates a node with null references to its element and next node.
	 */
	public Node() {
		this( null, null );
	}
	
	/**
	 * Creates a node with the given element and next node.
	 */
	public Node( E e, Node< E > n ) {
		self.element = e;
		self.next = n;
	}
	
	// Accessor methods
	public E getElement() {
		return self.element;
	}
	
	public Node< E > getNext() {
		return self.next;
	}
	
	// Modifier methods
	public void setElement( E newElem ) {
		self.element = newElem;
	}
	
	public void setNext( Node< E > newNext ) {
		self.next = newNext;
	}
}
