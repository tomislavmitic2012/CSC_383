package node_position_list;

import interfaces.Position;
import interfaces.PositionList;
import java.util.Iterator;
import element_iterator.ElementIterator;
import exceptions.BoundaryViolationException;
import exceptions.InvalidPositionException;
import exceptions.EmptyListException;
import node.DNode;

public class NodePositionList< E > implements PositionList< E > {
	private NodePositionList< E > self = this;
	
	protected int numElts;											// Number of elements in the list
	protected DNode< E > header, trailer;							// Special sentinels
	
	/**
	 * Constructor that creates an empty list
	 */
	public NodePositionList() {
		self.numElts = 0;
		self.header = new DNode< E >( null, null, null );			// create header
		self.trailer = new DNode< E >( header, null, null );		// create trailer
		self.header.setNext( self.trailer );						// make header and trailer pont to each other
	}

	/**
	 * Checks if position is valid for this list and converts it to 
	 * DNode if it is valid
	 */
	protected DNode< E > checkPosition( Position< E > p )
		throws InvalidPositionException {
		if ( p == null ) {
			throw new InvalidPositionException( "NodePositionList Line 32: Null position passed to NodeList!" );
		}
		
		if ( p == self.header ) {
			throw new InvalidPositionException( "NodePositionList Line 36: The header node is not a valid position" );
		}
		
		if ( p == self.trailer ) {
			throw new InvalidPositionException( "NodePositionList Line 40: The trailer node is not a valid position" );
		}
		
		try {
			DNode< E > temp = ( DNode< E > ) p;
			if ( ( temp.getPrev() == null ) || ( temp.getNext() == null ) ) {
				throw new InvalidPositionException( "NodePositionList Line 46: Position does not belong to a valid NodeList" );
			}
			return temp;
		} catch ( ClassCastException e  ) {
			throw new InvalidPositionException( "NodePositionList Line 50: Position is of the wrong type for this list" );
		}
	}
	
	/**
	 * Returns the number of elements in the list
	 */
	@Override
	public int size() {
		return self.numElts;
	}

	/**
	 * Returns whether the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return ( self.numElts == 0 );
	}

	/**
	 * Returns the first position in the list
	 */
	@Override
	public Position< E > first() throws EmptyListException {
		if ( self.isEmpty() ) {
			throw new EmptyListException( "NodePositionList Lise 77: List is empty" );
		}
		return header.getNext();
	}

	@Override
	public Position<E> last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException,
			BoundaryViolationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the position before the given one
	 * 
	 * @param p
	 * @return
	 * @throws InvalidPositionException
	 * @throws BoundaryViolationException
	 */
	@Override
	public Position< E > prev(Position< E > p) throws InvalidPositionException,
			BoundaryViolationException {
		DNode< E > v = self.checkPosition( p );
		DNode< E > prev = v.getPrev();
		if ( prev == self.header ) {
			throw new BoundaryViolationException( "NodePositionList Line 109: Cannot advance past the beginning of the list" );
		}
		return prev;
	}

	/**
	 * Insert the given element at the beginning of the list, returning
	 * the new position
	 * 
	 * @param e
	 */
	@Override
	public void addFirst( E element ) {
		self.numElts++;
		DNode< E > newNode = new DNode< E >( self.header, self.header.getNext(), element );
		self.header.getNext().setPrev( newNode );
		self.header.setNext( newNode );
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Insert the given element before the given position
	 * 
	 * @param p
	 * @param e
	 * @throws InvalidPositionException
	 */
	@Override
	public void addBefore(Position< E > p, E element ) throws InvalidPositionException {
		DNode< E > v = self.checkPosition( p );
		self.numElts++;
		DNode< E > newNode = new DNode< E >( v.getPrev(), v, element );
		v.getPrev().setNext( newNode );
		v.setPrev( newNode );
	}

	/**
	 * Remove the given position from the list
	 * 
	 * @param p
	 * @return
	 * @throws InvalidPositionException
	 */
	@Override
	public E remove( Position< E > p ) throws InvalidPositionException {
		DNode< E > v = self.checkPosition( p );
		self.numElts--;
		DNode< E > vPrev = v.getPrev();
		DNode< E > vNext = v.getNext();
		vPrev.setNext( vNext );
		vNext.setPrev( vPrev );
		E vElem = v.element();
		// unlink the position from the list and make it invalid
		v.setNext( null );
		v.setPrev( null );
		return vElem;
	}

	@Override
	public E set(Position< E > p, E element ) throws InvalidPositionException {
		DNode< E > v = self.checkPosition( p );
		E oldElt = v.element();
		v.setElement( element );
		return oldElt;
	}
	
	/**
	 * Returns an iterator of all elements in the list.
	 */
	public Iterator< E > iterator() {
		try {
			return new ElementIterator< E >( self );
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Returns an iterable collection of all the nodes in the list
	 * 
	 * @throws EmptyListException 
	 * @throws BoundaryViolationException 
	 * @throws InvalidPositionException 
	 */
	public Iterable< Position< E > > positions() 
		throws EmptyListException, InvalidPositionException, BoundaryViolationException {	// create a list of positions
		PositionList< Position< E > > P = new NodePositionList< Position< E > >();
		if ( !self.isEmpty() ) {
			Position< E > p = self.first();
			while ( true ) {
				P.addLast( p );																// add position p as the last element of list P
				if ( p == self.last() ) {
					break;
				}
				p = self.next( p );
			}
		}
		return P;																			// return P as our Iterable object
	}
	
	/**
	 * Returns a textual representation of a given node list 
	 */
	@Override
	public String toString() {
		Iterator< E > it = self.iterator();
		String s = "[ ";
		while( it.hasNext() ) {
			s += it.next();						// implicit cast of the next element to String
			if ( it.hasNext() ) {
				s += ", ";
			}
		}
		s += " ]";
		return s;
	}
}