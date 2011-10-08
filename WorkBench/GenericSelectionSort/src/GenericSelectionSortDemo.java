import java.io.PrintStream;

public class GenericSelectionSortDemo {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		Integer[] b = { 7, 5, 11, 2, 16, 4, 18, 12, 30 };
		
		GenericSelectionSortDemo.output.println( "Array values before sorting:" );
		for( int e : b ) {
			GenericSelectionSortDemo.output.print( e + " " );
		}
		GenericSelectionSortDemo.output.println();
		
		GenericSelectionSort.< Integer >sort( b );
		GenericSelectionSortDemo.output.println( "Array values after sorting:" );
		for( int e : b ) {
			GenericSelectionSortDemo.output.print( e + " " );
		}
		GenericSelectionSortDemo.output.println();
		
		String[] a = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December" };
		
		GenericSelectionSortDemo.output.println( "Array values before sorting:" );
		for( String e : a ) {
			GenericSelectionSortDemo.output.print( e + " " );
		}
		GenericSelectionSortDemo.output.println();
		
		GenericSelectionSort.< String >sort( a );
		GenericSelectionSortDemo.output.println( "Array values after sorting:" );
		for( String e : a ) {
			GenericSelectionSortDemo.output.print( e + " " );
		}
		GenericSelectionSortDemo.output.println();
	}
}