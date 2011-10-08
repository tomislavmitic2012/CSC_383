import java.util.ArrayList;
import java.io.PrintStream;

public class StringSelectionSortDemo {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		ArrayList< String > b = new ArrayList< String >();
		b.add( "time" );
		b.add( "tide" );
		b.add( "clouds" );
		b.add( "rain" );
		
		StringSelectionSortDemo.output.println( "ArrayList values before sorting:" );
		for( String e : b ) {
			StringSelectionSortDemo.output.print( e + " " );
		}
		StringSelectionSortDemo.output.println();
		
		StringSelectionSort.sort( b );
		StringSelectionSortDemo.output.println( "ArrayList values after sorting:" );
		for( String e : b ) {
			StringSelectionSortDemo.output.print( e + " " );
		}
		StringSelectionSortDemo.output.println();
	}
}
