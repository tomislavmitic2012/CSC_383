/**
 * A class used for sorting elements within an Array.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Sort< T > {
	private static int switchSize = 10;

	/**
	 * Recursive heapify
	 * 
	 * @param <T>
	 * @param a
	 * @param pos
	 * @param size
	 */
	private static < T extends Comparable<? super T > > void heapify( T[] a, int pos, int size ) {
		if ( pos > size ) return;
		int left = ( pos + 1 ) * 2 - 1;
		int right = ( pos + 1 ) * 2;
		int maxidx = pos;
		
		if ( right < size ) {
			if ( a[ right ].compareTo( a[ left ] ) > 0 ) maxidx = right;
			else maxidx = left;
		} else if ( left < size ) maxidx = left;
		
		// so far, maxidx is pointing at the larger child
		if ( a[ pos ].compareTo( a[ maxidx ] ) < 0 ) {		// compare the parent with the larger child
			T tmp = a[ maxidx ];
			a[ maxidx ] = a[ pos ];
			a[ pos ] = tmp;
			Sort.heapify( a, maxidx, size );
		}
	}
	
	/**
	 * Heap Sort
	 * 
	 * @param <T>
	 * @param a
	 */
	public static < T extends  Comparable<? super T > > void heapSort( T[] a ) {
		int size = a.length;
		
		for ( int i = size / 2; i >= 0; i-- ) {
			Sort.heapify( a, i, size );
		}
		
		for ( int i = size - 1; i > 0; i-- ) {
			T tmp = a[ 0 ];
			a[ 0 ] = a[ i ];
			a[ i ] = tmp;
			Sort.heapify( a, 0, i );
		}
	}
	
	public static < T extends Comparable<? super T > > void insertionSort( T[] a ) {
		int n = a.length;
		
		for( int i = 1; i < n; i++ ) {		// index from the second character in a
			T cur = a[ i ];					// the current character to be inserted
			int j = i - 1;					// start comparing with cell left of i
			while( ( j >= 0 ) && ( a[ j ].compareTo( cur ) > 0) ) {	// while a[ j ] is out of order with cur
				a[ j + 1 ] = a[ j-- ];		// move a[ j ] right and decrement j
			}
			a[ j + 1 ] = cur;				// this is the proper place for cur
		}
	}
	
	/**
	 * Selection Sort - More efficient - Move every value only once
	 * 
	 * @param <T>
	 * @param a
	 */
	public static < T extends Comparable<? super T > > void selectionSort( T[] a ) {
		for ( int i = 0, max = a.length - 1; i < max; i++ ) {
			int minIndex = i;			// Index of smallest remaining value.
			for ( int j = i + 1, max2 = a.length; j < max2; j++ ) {
				if ( a[ minIndex ].compareTo( a[ j ] ) > 0 ) {
					minIndex = j;		// Remember index of new minimum
				}
			}
			if ( minIndex != i ) {
				// Exclude current with smallest remaining
				T temp = a[ i ];
				a[ i ] = a[ minIndex ];
				a[ minIndex ] = temp;
			}
		}
	}
	
	/**
	 * Bubble Sort -- Sort only necessary range
	 * 
	 * @param <T>
	 * @param a
	 */
	public static < T extends Comparable<? super T > > void bubbleSort( T[] a ) {
		int newLowest = 0;					// index of first comparison
		int newHighest = a.length - 1;		// index of last comparison
		while ( newLowest < newHighest ) {
			int highest = newHighest;
			int lowest = newLowest;
			newLowest = a.length;			// start higher that any legal index
			for ( int i = lowest; i < highest; i++ ) {
				if ( a[ i ].compareTo( a[ i + 1 ] ) > 0 ) {
					T temp = a[ i ];
					a[ i ] = a[ i + 1 ];
					a[ i + 1 ] = temp;
					
					if ( i < newLowest ) {
						newLowest = i - 1;
						if ( newLowest < 0 ) { newLowest = 0; }
					} else if ( i > newHighest ) {
						newHighest = i + 1;
					}
				}
			}
		}
	}
}