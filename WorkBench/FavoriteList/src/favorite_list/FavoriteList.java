package favorite_list;

import exceptions.BoundaryViolationException;
import exceptions.EmptyListException;
import exceptions.InvalidPositionException;
import node_position_list.NodePositionList;
import interfaces.*;

/**
 * List of favorite elements with their access counts.
 */
public class FavoriteList< E > {
	private FavoriteList< E > self = this;
	
	protected PositionList< Entry< E > > flist;
	
	/**
	 * Constructor
	 */
	public FavoriteList() {
		self.flist = new NodePositionList< Entry< E > >();
	}
	
	/**
	 * Returns the number of elements in the list
	 */
	public int size() {
		return self.flist.size();
	}
	
	/**
	 * Returns whether the list is empty
	 */
	public boolean isEmpty() {
		return self.flist.isEmpty();
	}
	
	/**
	 * Removes a given element, provided it is in the list
	 * @throws InvalidPositionException 
	 * @throws BoundaryViolationException 
	 * @throws EmptyListException 
	 */
	public void remove( E obj ) throws InvalidPositionException, EmptyListException, BoundaryViolationException {
		Position< Entry< E> > p = self.find( obj );
		if ( p != null ) {
			self.flist.remove( p );
		}
	}
	
	/**
	 * Increments the access count for the given element and inserts it if it is not already present
	 * @throws BoundaryViolationException 
	 * @throws InvalidPositionException 
	 * @throws EmptyListException 
	 */
	public void access( E obj ) throws EmptyListException, InvalidPositionException, BoundaryViolationException {
		Position< Entry< E> > p = self.find( obj );
		if ( p != null ) {
			p.element().incrementCount();
		} else {
			self.flist.addLast( new Entry< E >( obj ) );
			p = self.flist.last();
		}
		self.moveUp( p );
	}
	
	/**
	 * Finds the position of a given element, or returns null
	 * @throws BoundaryViolationException 
	 * @throws InvalidPositionException 
	 * @throws EmptyListException 
	 */
	protected Position< Entry< E > > find( E obj ) throws EmptyListException, InvalidPositionException, BoundaryViolationException {
		for ( Position< Entry< E> > p : self.flist.positions() ) {
			if ( self.value( p ).equals( obj) ) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Moves up an entry to its correct position in the list
	 * @throws InvalidPositionException 
	 * @throws BoundaryViolationException 
	 * @throws EmptyListException 
	 */
	protected void moveUp( Position< Entry< E > > cur ) 
		throws InvalidPositionException, BoundaryViolationException, EmptyListException {
		Entry< E > e = cur.element();
		int c = self.count( cur );
		while( cur != self.flist.first() ) {
			Position< Entry< E > > prev = self.flist.prev( cur );				// previous position
			if ( c <= self.count( prev ) ) break;								// entry is at correct position
			self.flist.set( cur, prev.element() );								// move down previous entry
			cur = prev;
		}
		self.flist.set( cur, e );
	}
	
	/**
	 * Returns the k most accessed elements, for a given k
	 */
	public Iterable< E > top( int k ) {
		if ( k < 0 || k > self.size() ) {
			throw new IllegalArgumentException( "FavoriteList Line 104: Invalid argument" );
		}
		PositionList< E > T = new NodePositionList< E >();						// top-k list
		int i = 0;																// counter of the entries added to the list
		for ( Entry< E > e : self.flist ) {
			if (i++ >= k ) {
				break;															// all the k entries haven been added
			}
			T.addLast( e.value() );
		}
		return T;
	}
	
	/**
	 * String representation of the favorite list. 
	 */
	@Override
	public String toString() {
		return self.flist.toString();
	}
	
	/**
	 * Helper method that extracts the value of the entry at the given position
	 * @throws InvalidPositionException 
	 */
	protected E value( Position< Entry< E > > p ) throws InvalidPositionException {
		return  ( p.element() ).value();
	}
	
	protected int count( Position< Entry< E > > p ) throws InvalidPositionException {
		return ( p.element() ).count();
	}
	
	/**
	 * Inner class storing elements and their access counts
	 */
	protected static class Entry< E > {
		private Entry< E > self = this;
		
		private E value;								// element
		private int count;								// access count
		
		/**
		 * Constructor
		 */
		Entry( E v ) {
			self.count = 1;
			self.value = v;
		}
		
		/**
		 * Returns the element
		 */
		public E value() {
			return self.value;
		}
		
		/**
		 * Returns the access count
		 */
		public int count() {
			return self.count;
		}
		
		/**
		 * Increments the access count
		 */
		public int incrementCount() {
			return ++self.count;
		}
		
		/**
		 * String representation of the entry as [ count, value ]
		 */
		@Override
		public String toString() {
			return "[ " + self.count + ", " + self.value + " ]";
		}
	}
}