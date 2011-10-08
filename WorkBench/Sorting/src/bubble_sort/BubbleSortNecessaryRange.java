package bubble_sort;

import java.io.PrintStream;

/**
 * Bubble Sort: Sort only necessary range
 * 
 * @author Tomislav S. Mitic
 */
public class BubbleSortNecessaryRange {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void bubbleSort( int[] x ) {
		int newLowest = 0,						// index of first comparison
			newHighest = x.length - 1;			// index of last comparison

		while( newLowest < newHighest ) {
			int highest = newHighest,
				lowest = newLowest;
			newLowest = x.length;				// start higher than any legal index
			
			for( int i = lowest; i < highest; i++ ) {
				if( x[ i ] > x[ i + 1 ] ) {		// exchange elements
					int temp = x[ i ];
					x[ i ] = x[ i + 1 ];
					x[ i + 1 ] = temp;
				
					if( i < newLowest ) {
						newLowest = i - 1;
						if( newLowest < 0 ) { newLowest = 0; }
					} else if ( i > newHighest ) {
						newHighest = i + 1;
					}
				}
			}
		}
	}
	
	public static void main( String[] args ) {
		int[] A = {45, 1, 23, 455, 980, 99, 120, 88, 92, 12 };
		
		BubbleSortNecessaryRange.output.print( "Unsorted array A: " );
		for( int datum : A ) {
			BubbleSortNecessaryRange.output.print( datum + " " );
		}
		BubbleSortNecessaryRange.output.println();
		
		BubbleSortNecessaryRange.bubbleSort( A );
		
		BubbleSortNecessaryRange.output.print( "Sorted array A: " );
		for( int datum : A ) {
			BubbleSortNecessaryRange.output.print( datum + " " );
		}
		BubbleSortNecessaryRange.output.println();
	}	
}