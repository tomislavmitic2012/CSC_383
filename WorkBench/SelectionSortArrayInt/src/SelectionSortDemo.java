import java.io.PrintStream;

public class SelectionSortDemo {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		int[] b = { 7, 5, 11, 2, 16, 4, 18, 12, 30 };
		
		SelectionSortDemo.output.println( "Array values before sorting:" );
		for( int e : b ) {
			SelectionSortDemo.output.print( e + " " );
		}
		SelectionSortDemo.output.println();
		
		SelectionSort.sort( b );
		SelectionSortDemo.output.println( "Array values after sorting:" );
		for( int e : b ) {
			SelectionSortDemo.output.print( e + " " );
		}
		SelectionSortDemo.output.println();
	}
}
