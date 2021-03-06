package d_list;

import node.DLNode;

/**
 * Double linked list with nodes of type DNode storing strings.
 * 
 * - Object class DNode, which store String elements, are used for all the nodes of the list, 
 * 	 including the header and trailer sentinels
 * - We can use class DList for a doubly linked list of String objects only
 * - Methods getFirst and getLast provide direct access to the first and last nodes in the list
 * - Methods getPrev and getNext allow to traverse the list
 * - Methods hasPrev and hasNext detect the boundaries of the list
 * - Methods addFirst and addLast add a new node at the beginning or end of the list.
 * - Methods addBefore and addAfter add a new node before or after an existing node
 * - Having only a single removal method, remove, is not actually a restriction, since we can remove at the beginning
 *   or end of a double linked list L by executing L.remove( L.getFirst() ) or L.remove( L.getLast() ), respectively
 * - Method toString for converting an entire list into a string is useful for testing and debugging purposes
 * 
 * @author Tomislav S. Mitic
 *
 */
public class DList< E > {
	private DList< E > self = this;
	
	protected int size;					// number of elements
	protected DLNode< E > header,		// header sentinel
						  trailer;		// trailer sentinel
	
	/**
	 * Constructor that creates an empty list
	 */
	public DList() {
		self.size = 0;
		self.header = new DLNode< E >();			// create header
		self.trailer = new DLNode< E >( null, header, null );		// create trailer
		self.header.setNext( trailer );								// make header and trailer point to each other
	}
	
	/**
	 * Returns the number of elements in the list
	 */
	public int size() {
		return self.size;
	}
	
	/**
	 * Returns whether the list is empty
	 */
	public boolean isEmpty() {
		return ( self.size == 0 );
	}
	
	/**
	 * Returns the first node in the list
	 */
	public DLNode< E > getFirst() throws IllegalStateException {
		if ( self.isEmpty() ) {
			throw new IllegalStateException( "List is Empty" );
		}
		return self.header.getNext();
	}
	
	/** 
	 * Returns the last node of the list
	 */
	public DLNode< E > getLast() throws IllegalStateException {
		if ( self.isEmpty() ) {
			throw new IllegalStateException( "List is Empty" );
		}
		return self.trailer.getPrev();
	}
	
	/** 
	 * Returns the node before the given node v. An error occurs if v
	 * is the header
	 * 
	 * @param v	the current node we are looking to get the previous node of
	 */
	public DLNode< E > getPrev( DLNode< E > v ) throws IllegalArgumentException {
		if ( v == self.header ) {
			throw new IllegalArgumentException( "Cannot move back past the header of the list" );
		}
		return v.getPrev();
	}
	
	/** 
	 * Returns the node after the given node v. An error occurs if v
	 * is the trailer
	 * 
	 * @param v	the current node we are looking to get the next node of
	 */
	public DLNode< E > getNext( DLNode< E > v ) throws IllegalArgumentException {
		if ( v == self.trailer ) {
			throw new IllegalArgumentException( "Cannot move forward past the trailer of the list" );
		}
		return v.getNext();
	}
	
	/**
	 * Inserts the given node z before the given node v. And error
	 * occurs if v is the header
	 * 
	 * @param v
	 * @param z
	 * @throws IllegalArgumentException
	 */
	public void addBefore( DLNode< E > v, DLNode< E > z ) throws IllegalArgumentException {
		DLNode< E > u = getPrev( v );			// may throw an IllegalArgumentException
		z.setPrev( u );
		z.setNext( v );
		v.setPrev( z );
		u.setNext( z );
		self.size++;
	}
	
	/**
	 * Inserts the given node z after the given node v. And error
	 * occurs if v is the trailer
	 * 
	 * @param v
	 * @param z
	 * @throws IllegalArgumentException
	 */
	public void addAfter( DLNode< E > v, DLNode< E > z ) throws IllegalArgumentException {
		DLNode< E > w = getNext( v );			// may throw an IllegalArgumentException
		z.setPrev( v );
		z.setNext( w );
		w.setPrev( z );
		v.setNext( z );
		self.size++;
	}
	
	/**
	 * Inserts the given node at the head of the list
	 * 
	 * @param v
	 */
	public void addFirst( DLNode< E > v ) {
		self.addAfter( self.header, v );
	}
	
	/**
	 * Inserts the given node at the tail of the list
	 * 
	 * @param v
	 */
	public void addLast( DLNode< E > v ) {
		self.addBefore( self.trailer, v );
	}
	
	/**
	 * Removes the given node v from the list. An error occurs if v is
	 * the header or tailer
	 * 
	 * @param v
	 */
	public void remove( DLNode< E > v ) {
		DLNode< E > u = self.getPrev( v );			// may throw an IllegalArgumentException
		DLNode< E > w = self.getNext( v );			// may throw an IllegalArgumentException
		
		// unlink the node from the list
		w.setPrev( u );
		u.setNext( w );
		v.setPrev( null );
		v.setNext( null );
		self.size--;
	}
	
	/**
	 * Returns whether a given node has a previous node
	 * 
	 * @param v
	 * @return boolean
	 */
	public boolean hasPrev( DLNode< E > v ) {
		return (v != self.header);
	}
	
	/**
	 * Returns whether a given node has a next node
	 * 
	 * @param v
	 * @return boolean
	 */
	public boolean hasNext( DLNode< E > v ) {
		return (v != self.trailer);
	}
	
	/**
	 * Returns a string representation of the list
	 * 
	 * @return s string representation of the list
	 */
	@Override
	public String toString() {
		String s = "[ ";
		DLNode< E > v = self.header.getNext();
		while( v != self.trailer ) {
			s += v.getElement();
			v = v.getNext();
			if ( v != self.trailer ) {
				s += ", ";
			}
		}
		s += " ]";
		return s;
	}
	
	/**
	 * Insertion-sort for a double linked list of class DList.
	 * 
	 * @param L
	 */
	/*public static < E > void Sort( DList< E > L ) {
		if ( L.size() <= 1 ) {		// L is already sorted in this case
			return;
		}
		
		DLNode< E > pivot,				// pivot node
			  		ins,					// insertion point
			  		end = L.getFirst();	// end of run
		
		while( end != L.getLast() ) {
			pivot = end.getNext();	// get the next pivot node
			L.remove( pivot );		// remove it
			ins = end;				// start searching for the end of the sorted run
			
			while( L.hasPrev( ins ) && ins.getElement().compareTo( pivot.getElement() ) > 0 ) {
				ins = ins.getPrev();	// move left
			}
			L.addAfter( ins,  pivot );	// add the pivot back, after insertion point
			if ( ins == end ) {			// we just added pivot after end in this case
				end = end.getNext();	// so increment the end marker
			}
		}
	}*/
}