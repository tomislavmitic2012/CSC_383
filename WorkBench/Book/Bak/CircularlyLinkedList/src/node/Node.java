package node;

/**
 * Node of a singly linked list of strings.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Node {
	private Node self = this;
	
	private String element;			// we assume elements are character strings
	private Node next;
	
	/**
	 * Creates a node with the given element and next node.
	 */
	public Node( String s, Node n ) {
		self.setElement( s );
		self.setNext( n );
	}
	
	/**
	 * Returns the element of this node.
	 * 
	 * @return element
	 */
	public String getElement() {
		return self.element;
	}
	
	/**
	 * Returns the next node of this node.
	 * 
	 * @return next
	 */
	public Node getNext() {
		return self.next;
	}
	
	// Modifier methods:
	
	/**
	 * Sets the element of this node.
	 * 
	 * @param newElem
	 */
	public void setElement( String newElem ) {
		self.element = newElem;
	}
	
	/**
	 * Sets the next node of this node.
	 * 
	 * @param newNext
	 */
	public void setNext( Node newNext ) {
		self.next = newNext;
	}
}
