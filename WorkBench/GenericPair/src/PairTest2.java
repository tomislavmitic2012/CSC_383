import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PairTest2 {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		GregorianCalendar[] birthdays = {
				new GregorianCalendar( 1906, Calendar.DECEMBER, 9 ),		// G. Hopper
				new GregorianCalendar( 1815, Calendar.DECEMBER, 10 ),		// A. Lovelace
				new GregorianCalendar( 1903, Calendar.DECEMBER, 3 ),		// J. von Neumann
				new GregorianCalendar( 1910, Calendar.JUNE, 22 )			// G. Hopper
		};
		Pair< GregorianCalendar > mm = ArrayAlg2.< GregorianCalendar >minmax( birthdays );
		PairTest2.output.println( "min = " + mm.getFirst().getTime() );
		PairTest2.output.println( "max = " + mm.getSecond().getTime() );
		
		String[] names = { "John", "Q.", "Public" };
		String middle = ArrayAlg2.<String>getMiddle( names );
		PairTest2.output.println( "Middle name = " + middle);
		
		Integer[] nums = { 100, 2, 45, 50000 };
		Integer min = ArrayAlg2.< Integer >min( nums );
		PairTest2.output.println( "Smallest Integer = " + min );
	}
}

class ArrayAlg2 {
	/**
	 * Gets the minimum and maximum of an array of strings
	 * @param an array of strings
	 * @return a pair with the min and max value, or null if a is null or empty
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static < T extends Comparable > Pair< T > minmax( T[] a ) {
		if ( a == null || a.length == 0 ) {
			return null;
		}
		T min = a[ 0 ];
		T max = a[ 0 ];
		for( int i = 1, maximum = a.length; i < maximum; i++ ) {
			if ( min.compareTo( a[ i ] ) > 0 ) {
				min = a[ i ];
			}
			
			if ( max.compareTo( a[ i ] ) < 0 ) {
				max = a[ i ];
			}
		}
		return new Pair< T >( min, max );
	}
	
	public static < T > T getMiddle( T[] a ) {
		return a[ a.length / 2 ];
	}
	
	public static < T extends Comparable< T > > T min( T[] a ) {
		if ( a == null || a.length == 0 ) {
			return null;
		}
		T smallest = a[ 0 ];
		for( int i = 1, max = a.length; i < max; i++ ) {
			if ( smallest.compareTo( a[ i ] ) > 0 ) {
				smallest = a[ i ];
			}
		}
		return smallest;
	}
}