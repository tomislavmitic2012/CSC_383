package node;

/**
 * Node of a double linked list of strings.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class DNode {
	private DNode self = this;
	
	protected String element;	// String element stored by a node
	protected DNode next,		// Pointer to next node
					prev;		// Pointer to previous node
	
	/**
	 * Constructor that create a node with given fields
	 */
	public DNode( String e, DNode p, DNode n ) {
		self.setElement( e );
		self.setPrev( p );
		self.setNext( n );
	}
	
	/**
	 * Returns the element of this node
	 */
	public String getElement() {
		return self.element;
	}
	
	/**
	 * Returns the previous node of this node
	 */
	public DNode getPrev() {
		return self.prev;
	}
	
	/**
	 * Returns the next node of this node
	 */
	public DNode getNext() {
		return self.next;
	}
	
	/**
	 * Sets the element of this node
	 * 
	 * @param newElem
	 */
	public void setElement( String newElem ) {
		self.element = newElem;
	}
	
	/**
	 * Sets the previous node of this node.
	 * 
	 * @param newPrev
	 */
	public void setPrev( DNode newPrev ) {
		self.prev = newPrev;
	}
	
	public void setNext( DNode newNext ) {
		self.next = newNext;
	}
}