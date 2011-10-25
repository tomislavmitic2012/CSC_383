package insertion_sort;

import java.io.PrintStream;
import java.util.Arrays;

public class InsertionSort {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void insertionSort( char[] a ) {
		int n = a.length;
		
		for( int i = 1; i < n; i++ ) {		// index from the second character in a
			char cur = a[ i ];				// the current character to be inserted
			int j = i - 1;					// start comparing with cell left of i
			while( ( j >= 0 ) && ( a[ j ] > cur ) ) {	// while a[ j ] is out of order with cur
				a[ j + 1 ] = a[ j-- ];		// move a[ j ] right and decrement j
			}
			a[ j + 1 ] = cur;				// this is the proper place for cur
		}
	}
	
	public static void main( String[] args ) {
		char[] A = { 'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F' };
		
		output.println( "Unsorted array: " + Arrays.toString( A ) );		
		output.println();
		
		InsertionSort.insertionSort( A );
		
		output.println( "Sorted array: " + Arrays.toString( A ) );
		output.println();
	}
}