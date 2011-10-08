package circularly_linked_list;

import node.Node;

/**
 * Circularly linked list with nodes of type Node storing strings.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class CircleList {
	private CircleList self = this;
	
	protected Node cursor;		// the current cursor
	protected int size;			// the number of nodes in the list
	
	/**
	 * Constructor that create an empty list
	 */
	public CircleList() {
		self.cursor = null;
		self.size = 0;
	}
	
	/**
	 * Returns the current size
	 */
	public int size() {
		return self.size;
	}
	
	/**
	 * Returns the cursor
	 */
	public Node getCursor() {
		return self.cursor;
	}
	
	/**
	 * Moves the cursor forward
	 */
	public void advance() {
		self.cursor = self.cursor.getNext();
	}
	
	/**
	 * Adds a node after the cursor
	 */
	public void add( Node newNode ) {
		if ( self.cursor == null ) {	// list is empty
			newNode.setNext( newNode );
			self.cursor = newNode;
		} else {
			newNode.setNext( cursor.getNext() );
			cursor.setNext( newNode );
		}
		self.size++;
	}
	
	/**
	 * Removes the node after the cursor
	 */
	public Node remove() {
		Node oldNode = self.cursor.getNext();	// the node being removed
		
		if ( oldNode == self.cursor ) {
			self.cursor = null;				// list is becoming empty
		} else {
			self.cursor.setNext( oldNode.getNext() );		// link out the old node
			oldNode.setNext( null );
		}
		size--;
		return oldNode;
	}
	
	/**
	 * Returns a string representation of the list, starting from the cursor
	 */
	@Override
	public String toString() {
		if ( self.cursor == null ) {
			return "[ ]";
		}
		String s = "[ ... " + self.cursor.getElement();
		Node oldCursor = self.cursor;
		for( self.advance(); oldCursor != self.cursor; self.advance() ) {
			s += ", " + cursor.getElement();
		}
		return s + " ... ]";
	}
}
