package node;

import exceptions.InvalidPositionException;
import interfaces.Position;

/**
 * Node of a double linked list of strings.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class DNode< E > implements Position< E > {
	private DNode< E > self = this;
	
	protected E element;		// Element stored by a node
	protected DNode< E > next,		// Pointer to next node
					prev;		// Pointer to previous node
	
	/**
	 * Constructor that create a node with given fields
	 */
	public DNode( DNode< E > newPrev, DNode< E > newNext, E e ) {
		self.setPrev( newPrev );
		self.setNext( newNext );
		self.setElement( e );
	}
	
	/**
	 * Returns the element of this node
	 */
	@Override
	public E element() throws InvalidPositionException {
		if ( (self.prev == null ) && ( self.next == null ) ) {
			throw new InvalidPositionException( "DNode Line 33: Position is not in a list!" );
		}
		return self.element;
	}
	
	/**
	 * Returns the previous node of this node
	 */
	public DNode< E > getPrev() {
		return self.prev;
	}
	
	/**
	 * Returns the next node of this node
	 */
	public DNode< E > getNext() {
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
	public void setPrev( DNode< E > newPrev ) {
		self.prev = newPrev;
	}
	
	public void setNext( DNode< E > newNext ) {
		self.next = newNext;
	}
}