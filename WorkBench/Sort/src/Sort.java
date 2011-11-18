import java.lang.reflect.Array;
import java.util.Stack;

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
	
	/**
	 * Uses heap sort to sort the array and then returns the max 3 elements in the array
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 */
	public static < T extends  Comparable<? super T > > void findMax3( T[] a, T[] b ) {
		Sort.heapSort( a );
		b[ 0 ] = a[ a.length - 1 ];
		b[ 1 ] = a[ a.length - 2 ];
		b[ 2 ] = a[ a.length - 3 ];
	}
	
	public static < T extends Comparable<? super T > > void insertionSort( T[] a ) {
		Sort.insertionSort( a, 0, a.length - 1 );
	}
	
	/**
	 * Insertion Sort method
	 * 
	 * @param <T>
	 * @param a
	 */
	private static < T extends Comparable<? super T > > void insertionSort( T[] a, int low, int high ) {		
		for( int i = low; i <= high; i++ ) {		// index from the second character in a
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
	
	/**
	 * Sorts the elements of an array in nondecreasing order based
	 * on the compareTo function, using the merge sort algorithm.
	 * 
	 * @param <T>
	 * @param a
	 */
	public static < T extends Comparable<? super T > > void mergeSort( T[] a, T[] tmpArray ) {
		Sort.mergeSort( a, tmpArray, 0, a.length - 1 );
	}
	
	/**
	 * Sorts the elements of an array in nondecreasing order based
	 * on the compareTo function, using the merge sort algorithm.
	 * If the elements in the array are less then or equal to cutOff
	 * the function switches to insertion sort
	 * 
	 * @param <T>
	 * @param a
	 * @param tmpArray
	 * @param cutOff
	 */
	public static < T extends Comparable<? super T > > void mergeSort( T[] a, T[] tmpArray, int cutOff ) {
		if ( a.length <= cutOff ) {
			Sort.insertionSort( a );
			return;
		}
		Sort.mergeSort( a, tmpArray, 0, a.length - 1, cutOff );
	}
	
	/**
	 * Private static method that actually does the sorting recursively
	 * 
	 * @param <T>
	 * @param a
	 * @param tmpArray
	 * @param left
	 * @param right
	 */
	private static < T extends Comparable<? super T> >void mergeSort( T[] a, T[] tmpArray, int left, int right ) {
		if ( left < right ) {
			int center = ( left + right ) / 2;
			Sort.mergeSort( a, tmpArray, left, center );
			Sort.mergeSort( a, tmpArray, center + 1, right );
			Sort.merge( a, tmpArray, left, center + 1, right );
		}
	}
	
	private static < T extends Comparable<? super T> >void mergeSort( T[] a, T[] tmpArray, int left, int right, int cutoff ) {
		if ( left < right ) {
			int center = ( left + right ) / 2;
			if ( ( center - left ) <= cutoff ) {
				Sort.insertionSort( a, left, center );
			} else {
				Sort.mergeSort( a, tmpArray, left, center );
			}
			if ( ( right - ( center + 1 ) ) <= cutoff ) {
				Sort.insertionSort( a, center + 1, right );
			} else {
				Sort.mergeSort( a, tmpArray, center + 1, right );
			}
			Sort.merge( a, tmpArray, left, center + 1, right );
		}
	}
	
	/**
	 * Merges an array after it has been split in the merge sort.
	 * 
	 * @param <T>
	 * @param in1
	 * @param in2
	 * @param a
	 */
	private static < T extends Comparable<? super T > > void merge( T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd  ) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		// Main loop
		while ( leftPos <= leftEnd && rightPos <= rightEnd ) {
			if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 ) {
				tmpArray[ tmpPos++ ] = a[ leftPos++ ];
			} else {
				tmpArray[ tmpPos++ ] = a[ rightPos++ ];
			}
		}
		
		// Copy rest of first half
		while ( leftPos <= leftEnd ) {
			tmpArray[ tmpPos++ ] = a[ leftPos++ ];
		}
		
		// Copy rest of right half
		while ( rightPos <= rightEnd ) {
			tmpArray[ tmpPos++ ] = a[ rightPos++ ];
		}
		
		// Copy tmpArray back
		for( int i = 0; i < numElements; i++, rightEnd-- ) {
			a[ rightEnd ] = tmpArray[ rightEnd ];
		}
	}
	
	/**
	 * Standard quick sort
	 * 
	 * @param <T>
	 * @param a
	 */
	public static < T extends Comparable<? super T > > void quickSort( T[] a ) {
		// Before doing quick sort see if the array isn't sorted in ascending or descending
		// order
		if ( Sort.isSorted( a, 0 ) ) return;	// ascending
		if ( Sort.isSorted( a, 1 ) ) return;	// descending
		Sort.quickSort( a, 0, a.length - 1 );
	}
	
	/**
	 * Private static method the implements the recursive standard quick sort
	 * 
	 * @param <T>
	 * @param a
	 * @param start
	 * @param end
	 */
	private static < T extends Comparable<? super T > > void quickSort( T[] a, int low, int high ) {
		int i = low, k = high;
		
		if ( high - low >= 1 ) {				// check to see if there is at least two elements to sort
			T pivot = a[ low ];
			
			while ( k > i ) {
				while ( a[ i ].compareTo( pivot ) <= 0 && i <= high && k > i ) i++;		// from the left, look for the first element greater than the pivot
				while ( a[ k ].compareTo( pivot ) > 0 && k >= low && k >= i ) k--;		// from the right, look for the first element not greater than the pivot
				if ( k > i ) {
					Sort.swapReferences( a, i, k );
				}
			}
			Sort.swapReferences( a, low, k );											// after the indices have crossed, swap the last element in the left partition with the pivot
			Sort.quickSort( a, low, k - 1 );											// quick sort left partition
			Sort.quickSort( a, k + 1, high);											// quick sort right partition
		} else {
			return;																		// array sorted, time to exit
		}
	}
	
	/**
	 * Quick sort, fall back to insertion sort if at cut off
	 *  
	 * @param <T>
	 * @param a
	 */
	public static < T extends Comparable<? super T > > void quickSort2( T[] a ) {
		// Before doing quick sort see if the array isn't sorted in ascending or descending
		// order
		if ( Sort.isSorted( a, 0 ) ) return;	// ascending
		if ( Sort.isSorted( a, 1 ) ) return;	// descending
		Sort.quickSort2( a, 0, a.length - 1 );
	}
	
	/**
	 * Private static method the implements the recursive standard quick sort with fall back to insertion sort
	 * 
	 * @param <T>
	 * @param a
	 * @param start
	 * @param end
	 */
	private static < T extends Comparable<? super T > > void quickSort2( T[] a, int low, int high ) {
		int i = low, k = high;
		
		if ( ( high - low ) > Sort.switchSize ) {										// check to see if there are at least eleven elements to sort
			T pivot = a[ low ];
			
			while ( k > i ) {
				while ( a[ i ].compareTo( pivot ) <= 0 && i <= high && k > i ) i++;		// from the left, look for the first element greater than the pivot
				while ( a[ k ].compareTo( pivot ) > 0 && k >= low && k >= i ) k--;		// from the right, look for the first element not greater than the pivot
				if ( k > i ) {
					Sort.swapReferences( a, i, k );
				}
			}
			Sort.swapReferences( a, low, k );											// after the indices have crossed, swap the last element in the left partition with the pivot
			Sort.quickSort2( a, low, k - 1 );											// quick sort left partition
			Sort.quickSort2( a, k + 1, high);											// quick sort right partition
		} else if ( ( high - low ) <= Sort.switchSize ) { 
			Sort.insertionSort( a, low, high );
		}else {
			return;																		// array sorted, time to exit
		}
	}

	/**
	 * Recursive Quick sort median of three, fall back to insertion sort if at cut off
	 *  
	 * @param <T>
	 * @param a
	 */
	public static < T extends Comparable<? super T > > void quickSort3( T[] a ) {
		Sort.quickSort3( a, 0, a.length - 1 );
	}
	
	/**
	 * Private static method the implements the recursive quick sort median of three
	 * 
	 * @param <T>
	 * @param a
	 * @param start
	 * @param end
	 */
	private static < T extends Comparable<? super T > > void quickSort3( T[] a, int low, int high ) {
		int i = low, k = high - 1;
		
		if ( ( high - low ) > Sort.switchSize ) {										// check to see if there are at least eleven elements to sort
			int middle = ( low + high ) / 2;
			if ( a[ middle ].compareTo( a[ low ] ) < 0 ) Sort.swapReferences( a, low, middle );
			if ( a[ high ].compareTo( a[ low ] ) < 0 ) Sort.swapReferences( a, low, high );
			if ( a[ high ].compareTo( a[ middle ] ) < 0 ) Sort.swapReferences( a, middle, high );
			//Place pivot at position high -1
			Sort.swapReferences( a, middle, high - 1);
			T pivot = a[ high - 1 ];
			
			while ( true ) {
				while( a[ ++i ].compareTo( pivot ) < 0 );
				while( pivot.compareTo( a[ --k ] ) < 0 );
				if ( i >= k ) break;
				Sort.swapReferences( a, i, k );
			}
			// Restore pivot
			Sort.swapReferences( a, i, high - 1 );
			Sort.quickSort3( a, low, i - 1 );			// Sort small elements
			Sort.quickSort3( a, i + 1, high );
		} else if ( ( high - low ) <= Sort.switchSize ) { 
			Sort.insertionSort( a, low, high );
		}else {
			return;																		// array sorted, time to exit
		}
	}
	
	/**
	 * Non-Recursive Quick sort median of three, fall back to insertion sort if at cut off
	 *  
	 * @param <T>
	 * @param a
	 */
	public static < T extends Comparable<? super T > > void quickSort4( T[] a ) {
		Sort.quickSort4( a, 0, a.length - 1 );
	}
	
	/**
	 * Private static method the implements the non-recursive quick sort median of three
	 * 
	 * @param <T>
	 * @param a
	 * @param start
	 * @param end
	 */
	private static < T extends Comparable<? super T > > void quickSort4( T[] a, int low, int high ) {
		Stack< Integer > intStack = new Stack< Integer >();
		
		intStack.push( low );
		intStack.push( high );
		
		while ( !intStack.empty() ) {
			int right = intStack.pop(),
				left = intStack.pop();

			// Partition
			int i = left, k = right - 1;
			int middle = ( left + right ) / 2;
			if ( a[ middle ].compareTo( a[ left ] ) < 0 ) Sort.swapReferences( a, left, middle );
			if ( a[ right ].compareTo( a[ left ] ) < 0 ) Sort.swapReferences( a, left, right );
			if ( a[ right ].compareTo( a[ middle ] ) < 0 ) Sort.swapReferences( a, middle, right );
			//Place pivot at position high -1
			Sort.swapReferences( a, middle, right - 1);
			T pivot = a[ right - 1 ];
				
			while ( true ) {
				while( a[ ++i ].compareTo( pivot ) < 0 );
				while( pivot.compareTo( a[ --k ] ) < 0 );
				if ( i >= k ) break;
				Sort.swapReferences( a, i, k );
			}
				
			// put new subarrays onto stack
			if ( i - left > Sort.switchSize ) {			// left partition
				intStack.push( left );
				intStack.push( i );
			} else Sort.insertionSort( a, left, i );
			
			if ( right - i  > Sort.switchSize ) {		// right partition
				intStack.push( i );
				intStack.push( right );
			} else Sort.insertionSort( a, i, right );
		}
	}
	
	/**
	 * Swap function
	 * 
	 * @param <T>
	 * @param a
	 * @param index1
	 * @param index2
	 */
	private static < T extends Comparable<? super T > > void swapReferences( T[] a, int index1, int index2 ) {
		T tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}
	
	/**
	 * A helper to check to see whether an array has been presorted in ascending or descending order.
	 * 
	 * @param <T>
	 * @param a
	 * @param flag
	 * @return
	 */
	private static < T extends Comparable<? super T > > boolean isSorted( T[] a, int flag ) {
		if ( flag == 0 ) {				// ascending
			for (int i = 1, max = a.length; i < max; i++ ) {
				if ( a[ i - 1 ].compareTo( a[ i ] ) > 0 ) return false;
			}
		} else if ( flag == 1 ) {		// descending
			for (int i = 1, max = a.length; i < max; i++ ) {
				if ( a[ i - 1 ].compareTo( a[ i ] ) < 0 ) return false;
			}
		}
		return true;
	}
}