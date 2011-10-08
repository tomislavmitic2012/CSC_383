/**
 * Class for sorting an ArrayList of Strings lexicographically
 * (approximately alphabetically)
 * 
 * @author Tomislav S. Mitic
 *
 */
public class GenericSelectionSort {
	/**
	 * Precondition: Every indexed variable of a has a value.
	 * Action: Sorts a so that a[ 0 ] <= a[ 1 ] <= ... <= a[ a.length - 1 ].
	 */
	@SuppressWarnings("rawtypes")
	public static < E extends Comparable > void sort( E[] a ) {
		int indexOfNextSmallest;
		for( int index = 0, max = a.length - 1; index < max; index++ ) {
			// Place the correct value in position index:
			indexOfNextSmallest = GenericSelectionSort.indexOfSmallest( index, a );
			GenericSelectionSort.interchange( index, indexOfNextSmallest, a );
			// a[ 0 ] <= a[ 1 ] <= ... <= a[ index ]
			// are sorted. The rest of the
			// elements are in the remaining positions.
		}
	}
	
	/**
	 * Precondition: i and j are legal indices for the array a.
	 * Postcondition: The values of a[ i ] and
	 * a[ j ] have been interchanged.
	 */
	private static < E > void interchange( int i, int j, E[] a ) {
		E temp = a[ i ];
		a[ i ] =  a[ j ];
		a[ j ] = temp;
	}
	
	/**
	 * Returns the index of the smallest value among
	 * a[ StartIndex ], a[ StartIndex + 1 ], ..., a[ a.length - 1 ]
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static < E extends Comparable > int indexOfSmallest( int startIndex, E[] a ) {
		E min = a[ startIndex ];
		int indexOfMin = startIndex;
		for( int index = startIndex + 1, max = a.length; index < max; index++ ) {
			if( ( a[ index ] ).compareTo( min ) < 0 ) {
				min = a[ index ];
				indexOfMin = index;
				// min is smallest of a[ startIndex ] through a[ index ]
			}
		}
		return indexOfMin;
	}
}