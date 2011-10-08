import java.util.ArrayList;

/**
 * Class for sorting an ArrayList of Strings lexicographically
 * (approximately alphabetically)
 * 
 * @author Tomislav S. Mitic
 *
 */
public class StringSelectionSort {
	/**
	 * Sorts the ArrayList a so that a.get( 0 ), a.get( 1 ), ...,
	 * a.get( a.size() - 1 ) are in lexicographic order.
	 */
	public static void sort( ArrayList< String > a ) {
		int indexOfNextSmallest;
		for( int index = 0, max = a.size() - 1; index < max; index++ ) {
			// Place the correct value in position index:
			indexOfNextSmallest = StringSelectionSort.indexOfSmallest( index, a );
			StringSelectionSort.interchange( index, indexOfNextSmallest, a );
			// a.get( 0 ), a.get( 1 ), ..., a.get( index )
			// are sorted. The rest of the
			// elements are in the remaining positions.
		}
	}
	
	/**
	 * Precondition: i and j are legal indices for the ArrayList a.
	 * Postcondition: The values of a.get( i ) and
	 * a.get( j ) have been interchanged.
	 */
	private static void interchange( int i, int j, ArrayList< String > a ) {
		String temp = a.get( i );
		a.set( i, a.get( j ) );
		a.set( j, temp );
	}
	
	/**
	 * Returns the index of the lexicographically first value among
	 * a.get( StartIndex ), a.get( StartIndex + 1 ), ..., a.get( a.size() - 1 )
	 */
	private static int indexOfSmallest( int startIndex, ArrayList< String > a ) {
		String min = a.get( startIndex );
		int indexOfMin = startIndex;
		for( int index = startIndex + 1, max = a.size(); index < max; index++ ) {
			if( ( a.get( index ) ).compareTo( min ) < 0 ) {
				min = a.get( index );
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
}