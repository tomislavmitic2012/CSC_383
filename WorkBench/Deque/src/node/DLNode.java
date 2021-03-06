package node;

/**
 * Node of a double linked list of strings.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class DLNode< E > {
	private DLNode< E > self = this;
	
	protected E element;	// String element stored by a node
	protected DLNode< E > next,		// Pointer to next node
					 prev;		// Pointer to previous node
	
	public DLNode() {
		this( null, null, null );
	}
	
	/**
	 * Constructor that create a node with given fields
	 */
	public DLNode( E e, DLNode< E > p, DLNode< E > n ) {
		self.setElement( e );
		self.setPrev( p );
		self.setNext( n );
	}
	
	/**
	 * Returns the element of this node
	 */
	public E getElement() {
		return self.element;
	}
	
	/**
	 * Returns the previous node of this node
	 */
	public DLNode< E > getPrev() {
		return self.prev;
	}
	
	/**
	 * Returns the next node of this node
	 */
	public DLNode< E > getNext() {
		return self.next;
	}
	
	/**
	 * Sets the element of this node
	 * 
	 * @param newElem
	 */
	public void setElement( E newElem ) {
		self.element = newElem;
	}
	
	/**
	 * Sets the previous node of this node.
	 * 
	 * @param newPrev
	 */
	public void setPrev( DLNode< E > newPrev ) {
		self.prev = newPrev;
	}
	
	public void setNext( DLNode< E > newNext ) {
		self.next = newNext;
	}
}