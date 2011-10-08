package bubble_sort;

import java.io.PrintStream;

/**
 * Bubble Sort: stop when no exchanges, shorter range each time
 * 
 * @author Tomislav S. Mitic
 */
public class BubbleSortNoExchangesShorterRange {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void bubbleSort( int[] x ) {
		int n = x.length;
		boolean doMore = true;
		
		while( doMore ) {
			doMore = false;								// assume this is last pass over array
			n--;
			
			for( int i = 0; i < n; i++ ) {
				if ( x[ i ] > x[ i + 1 ] ) {
					// exchange elements
					int temp = x[ i ];
					x[ i ] = x[ i + 1 ];
					x[ i + 1 ] = temp;
					doMore = true;						// after an exchange, must look again
				}
			}
		}
	}
	
	public static void main( String[] args ) {
		int[] A = {45, 1, 23, 455, 980, 99, 120, 88, 92, 12 };
		
		BubbleSortNoExchangesShorterRange.output.print( "Unsorted array A: " );
		for( int datum : A ) {
			BubbleSortNoExchangesShorterRange.output.print( datum + " " );
		}
		BubbleSortNoExchangesShorterRange.output.println();
		
		BubbleSortNoExchangesShorterRange.bubbleSort( A );
		
		BubbleSortNoExchangesShorterRange.output.print( "Sorted array A: " );
		for( int datum : A ) {
			BubbleSortNoExchangesShorterRange.output.print( datum + " " );
		}
		BubbleSortNoExchangesShorterRange.output.println();
	}
}
