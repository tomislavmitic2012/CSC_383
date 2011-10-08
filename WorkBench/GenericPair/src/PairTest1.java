import java.io.PrintStream;

public class PairTest1 {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		String[] words = { "Mary", "had", "a", "little", "lamb" };
		Pair< String > mm = ArrayAlg.minmax( words );
		output.println( "min = " + mm.getFirst() );
		output.println( "max = " + mm.getSecond() );
		
		String[] names = { "John", "Q.", "Public" };
		String middle = ArrayAlg.<String>getMiddle( names );
		output.println( "Middle name = " + middle);
		
		Integer[] nums = { 100, 2, 45, 50000 };
		Integer min = ArrayAlg.< Integer >min( nums );
		output.println( "Smallest Integer = " + min );
	}
}

class ArrayAlg {
	/**
	 * Gets the minimum and maximum of an array of strings
	 * @param an array of strings
	 * @return a pair with the min and max value, or null if a is null or empty
	 */
	public static Pair< String > minmax( String[] a ) {
		if ( a == null || a.length == 0 ) {
			return null;
		}
		String min = a[ 0 ];
		String max = a[ 0 ];
		for( int i = 1, maximum = a.length; i < maximum; i++ ) {
			if ( min.compareTo( a[ i ] ) > 0 ) {
				min = a[ i ];
			}
			
			if ( max.compareTo( a[ i ] ) < 0 ) {
				max = a[ i ];
			}
		}
		return new Pair< String >( min, max );
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