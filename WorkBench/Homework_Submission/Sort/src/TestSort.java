import java.io.PrintStream;
import java.util.*;

/**
 * A driver program for testing the Sort class.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class TestSort {
	public static final PrintStream output = new PrintStream( System.out );
	public static final int SIZE = 10000;
	
	public static < T extends Comparable<? super T > > void sorted( T[] a, String methodUsed, String Type ) {
		for ( int i = 1, max = a.length; i < max; i++ ) {
			if ( a[ i - 1 ].compareTo( a[ i ] ) > 0 ) {
				TestSort.output.println( "\tType of list: " + Type );
				TestSort.output.println( "\tMethod Used: " + methodUsed );
				break;
			}
		}
	}
	
	public static < T > void print( T[] a ) {
		int k = 0;
		for ( T e : a ) {
			TestSort.output.print( e + " ; " );
			k++;
			if ( k % 8 == 0) TestSort.output.println();
		}
		TestSort.output.println();
		TestSort.output.println();
	}
	
	public static void main( String[] args ) {
		int size = TestSort.SIZE;
		long start = 0, end = 0;
		int type = 0;

		if ( args.length > 0 ) size = Integer.parseInt( args[ 0 ] );
		if ( args.length > 1 ) type = Integer.parseInt( args[ 1 ] );
		
		Integer[] a = new Integer[ size ];
		Random rand = new Random();

		if ( type == 0 ) {			// Random order
			for ( int i = 0; i < size; i++ ) {
				a[ i ] = rand.nextInt( 5 * size );
 			}
		} else if ( type == 1 ) {	// already sorted in ascending order
			for ( int i = 0; i < size; i++ ) {
				a[ i ] = i;
			}
		} else if ( type == 2 ) {	// already sorted in descending order
			for ( int i = 0; i < size; i++ ) {
				a[ i ] = size - i;
			}
		} else {					// all the data are the same
			for ( int i = 0; i < size; i++ ) {
				a[ i] = 1;
			}
		}

		Integer[] b = new Integer[ size ];

		String[] Type = {
			" in Random order",
			" in ascending order",
			" in descending order",
			" all the same"
		};
		TestSort.output.printf("\n\nFor data set of size = %d with data %10s\n\n", size, Type[ type ] );

		////////////////////	Heap Sort		////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.heapSort( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Heap Sort", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Heap Sort", ( end - start ) );

		////////////////////	Quick Sort		////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.quickSort( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Quick Sort", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Quick Sort", ( end - start ) );
		
		////////////////////	Quick Sort 2	////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.quickSort2( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Quick Sort 2", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Quick Sort 2", ( end - start ) );

		////////////////////	Quick Sort 3	////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.quickSort3( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Quick Sort 3", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Quick Sort 3", ( end - start ) );
		
		////////////////////	Quick Sort 4	////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.quickSort4( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Quick Sort 4", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Quick Sort 4", ( end - start ) );

		////////////////////	Use of Merge Sort	////////////////////
		System.arraycopy( a, 0, b, 0, size );
		Integer[] c = new Integer[ size ];
		start = System.currentTimeMillis();
		Sort.mergeSort( b, c );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Merge Sort", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Merge Sort", ( end - start ) );

		////////////////////	Use of Merge Sort with Cutoff	////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.mergeSort( b, c, 20 );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Merge Sort with a Cutoff", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Merge Sort 2", ( end - start ) );

		////////////////////	Use of Arrays.sort()	////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Arrays.sort( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Array.sort", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "Arrays.sort", ( end - start ) );

		if ( size > 20000 ) return;		// if the size is too large, skip insertion sort, selection sort, and bubble sort

		////////////////////	Insertion Sort		////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.insertionSort( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Insertion Sort", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "insertionSort", ( end - start ) );
		
		////////////////////	Selection Sort		////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.selectionSort( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Selection Sort", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "selectionSort", ( end - start ) );
		
		////////////////////	Bubble Sort		////////////////////
		System.arraycopy( a, 0, b, 0, size );
		start = System.currentTimeMillis();
		Sort.bubbleSort( b );
		end = System.currentTimeMillis();
		TestSort.< Integer >sorted( b, "Bubble Sort", Type[ type ] );
		TestSort.output.printf("\t%-15s takes %10d ms\n\n", "bubbleSort", ( end - start ) );
	}
}