package favorite_list_mtf;

import node_position_list.NodePositionList;
import interfaces.Position;
import interfaces.PositionList;
import exceptions.BoundaryViolationException;
import exceptions.EmptyListException;
import exceptions.InvalidPositionException;
import favorite_list.FavoriteList;

public class FavoriteListMTF< E > extends FavoriteList< E > {
	private FavoriteListMTF< E > self = this;
	
	/**
	 * Default constructor
	 */
	public FavoriteListMTF() {}
	
	@Override
	protected void moveUp( Position< Entry< E > > pos ) throws InvalidPositionException {
		self.flist.addFirst( self.flist.remove( pos ) );
	}
	
	/**
	 * Returns the k most accessed elements, for a given k
	 */
	@Override
	public Iterable< E > top( int k ) {
		if ( k < 0 || k > self.size() ) {
			throw new IllegalArgumentException( "FavoriteListMTF Line 26: Invalid argument!");
		}
		PositionList< E > T = new NodePositionList< E >();										// top-k list
		if ( !self.isEmpty() ) {
			// copy entries into temporary list C
			PositionList< Entry< E > > C = new NodePositionList< Entry< E > >();
			for ( Entry< E > e : self.flist ) {
				C.addLast( e );
			}
			// find the top k elements, one at a time
			for( int i = 0; i < k; i++ ) {
				Position< Entry< E > > maxPos = null;				// position of top entry
				int maxCount = -1;
				try {
					for ( Position< Entry< E > > p : C.positions() ) {
						// examine all entries of C
						int c = self.count( p );
						if ( c> maxCount ) {						// found an entry with higher access count
							maxCount = c;
							maxPos = p;
						}
					}
					T.addLast( self.value( maxPos ) );
					C.remove( maxPos );
				} catch (EmptyListException e1) {
					e1.printStackTrace();
				} catch (InvalidPositionException e1) {
					e1.printStackTrace();
				} catch (BoundaryViolationException e1) {
					e1.printStackTrace();
				}
			}
		}
		return T;
	}
}