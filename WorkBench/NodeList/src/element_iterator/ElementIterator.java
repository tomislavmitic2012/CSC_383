package element_iterator;

import interfaces.Position;
import interfaces.PositionList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import exceptions.BoundaryViolationException;
import exceptions.EmptyListException;
import exceptions.InvalidPositionException;

public class ElementIterator< E > implements Iterator< E > {
	private ElementIterator< E > self = this;
	
	protected PositionList< E > list;							// the underlying list
	protected Position< E > cursor;								// the next position
	
	/**
	 * Creates an element iterator over the given list.
	 * @throws EmptyListException 
	 */
	public ElementIterator( PositionList< E > L ) throws EmptyListException {
		self.list = L;
		self.cursor = ( self.list.isEmpty() ) ? null : self.list.first();
	}
	
	@Override
	public boolean hasNext() {
		return ( self.cursor != null );
	}

	@Override
	public E next() throws NoSuchElementException {
		if ( self.cursor == null ) {
			throw new NoSuchElementException( "ElementIterator Line 33: No next element" );
		}
		try {
			E toReturn = cursor.element();
			self.cursor = ( self.cursor == list.last() ) ? null : list.next( self.cursor );
			return toReturn;
		} catch ( InvalidPositionException e ) {
			e.printStackTrace();
		} catch ( BoundaryViolationException e ) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove() {
		try {
			self.list.remove( self.cursor );
		} catch ( InvalidPositionException e ) {
			e.printStackTrace();
		}
	}
}
