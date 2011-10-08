package bubble_sort;

import java.io.PrintStream;

/**
 * Bubble Sort: fixed number of passes
 * 
 * @author Tomislav S. Mitic
 *
 */
public class BubbleSortFixedNumber {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void bubbleSort( int[] x ) {
		int n = x.length;
		
		for( int pass = 1; pass < n; pass++ ) {	// count how many times
			// This next loop becomes shorter and shorter
			for( int i = 0; i < n - pass; i++ ) {
				// exchange elements
				int temp = x[ i ];
				x[ i ] = x[ i + 1 ];
				x[ i + 1 ] = temp;
			}
		}
	}
	
	public static void main( String[] args ) {
		int[] A = {45, 1, 23, 455, 980, 99, 120, 88, 92, 12 };
		
		BubbleSortFixedNumber.output.print( "Unsorted array A: " );
		for( int datum : A ) {
			BubbleSortFixedNumber.output.print( datum + " " );
		}
		BubbleSortFixedNumber.output.println();
		
		BubbleSortFixedNumber.bubbleSort( A );
		
		BubbleSortFixedNumber.output.print( "Sorted array A: " );
		for( int datum : A ) {
			BubbleSortFixedNumber.output.print( datum + " " );
		}
		BubbleSortFixedNumber.output.println();
	}
}
