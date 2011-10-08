package bubble_sort;

import java.io.PrintStream;

/**
 * Bubble Sort: stop when no exchanges
 * 
 * @author Tomislav S. Mitic
 */
public class BubbleSortNoExchanges {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void bubbleSort( int[] x ) {
		int n = x.length;
		boolean doMore = true;
		
		while( doMore ) {
			doMore = false;								// assume this is last pass over array
			
			for( int i = 0; i < n - 1; i++ ) {
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
		
		BubbleSortNoExchanges.output.print( "Unsorted array A: " );
		for( int datum : A ) {
			BubbleSortNoExchanges.output.print( datum + " " );
		}
		BubbleSortNoExchanges.output.println();
		
		BubbleSortNoExchanges.bubbleSort( A );
		
		BubbleSortNoExchanges.output.print( "Sorted array A: " );
		for( int datum : A ) {
			BubbleSortNoExchanges.output.print( datum + " " );
		}
		BubbleSortNoExchanges.output.println();
	}
}
