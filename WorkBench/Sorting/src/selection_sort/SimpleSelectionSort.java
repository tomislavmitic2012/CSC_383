package selection_sort;

import java.io.PrintStream;

/**
 * Bubble Sort: Simple selection sort
 * 
 * @author Tomislav S. Mitic
 */
public class SimpleSelectionSort {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void selectionSort( int[] x ) {
		for( int i = 0; i < x.length -1; i++ ) {
			for( int j = i + 1; j < x.length; j++ ) {
				if( x[ i ] > x[ j ] ) {
					// Exchange elements
					int temp = x[ i];
					x[ i ] = x[ j];
					x[ j ] = temp;
				}
			}
		}
	}
	
	public static void main( String[] args ) {
		int[] A = {45, 1, 23, 455, 980, 99, 120, 88, 92, 12 };
		
		SimpleSelectionSort.output.print( "Unsorted array A: " );
		for( int datum : A ) {
			SimpleSelectionSort.output.print( datum + " " );
		}
		SimpleSelectionSort.output.println();
		
		SimpleSelectionSort.selectionSort( A );
		
		SimpleSelectionSort.output.print( "Sorted array A: " );
		for( int datum : A ) {
			SimpleSelectionSort.output.print( datum + " " );
		}
		SimpleSelectionSort.output.println();
	}
}