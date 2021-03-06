package helpers;

public class Helpers {
	public static int max( int [] A, int n ) {
		if ( n == 1 ) return A[ 0 ];
		int large = max( A, n - 1 );
		return ( large > A[ n - 1 ] ) ? large : A[ n - 1 ];
	}
	
	public static int convert( String s ) {
		int n = s.length();
		if ( s.length() == 1 ) return ( s.charAt( n - 1 ) - '0' );
		return 10 * Helpers.convert( s.substring( 0, n - 1 ) ) + ( s.charAt( n - 1 ) - '0' );
	}
	
	public static void maxmin( int[] A, int n, int[] result ) {
		result[ 0 ] = A[ n - 1 ];
		result[ 1 ] = A[ n - 1 ];
		
		if ( n == 1 ) return;
		
		int[] tmp = new int[ 2 ];
		
		Helpers.maxmin( A, n - 1, tmp );
		
		result[ 1 ] = ( A[ n - 1 ] < tmp[ 1 ] ) ? A[ n - 1 ] : tmp[ 1 ];
		result[ 0 ] = ( A[ n - 1 ] > tmp[ 0 ] ) ? A[ n - 1 ] : tmp[ 0 ];
	}
	
	public static void maxmin2(int[] A, int[] result ) {
		int i, j;
		
		for ( i = 0, j = A.length - 1; i < j; i++, j--) {
			if ( A[ i ] > A[ j ] ) Helpers.swap( A, i, j );
		}

		// after n/2 comparisons
		// left half of the array  contains the smaller of the two
		// right half contains the larger of the two
		int n = A.length;
		
		int min = A[ 0 ];
		int max = A[ n - 1 ];
		
		for ( i = 1; i < n / 2 + 1; i++ ) {
			if ( A[ i ] < min ) min = A[ i ];
		}
		
		for ( i = n - 2; i >= n / 2; i-- ) {
			if ( A[ i ] > max ) max = A[ i ];
		}
		
		result[ 0 ] = max;
		result[ 1 ] = min;
	}
	
	public static void swap( int[] A, int x, int y ) {
		int z = A[ x ];
		A[ x ] = A[ y ];
		A[ y ] = z;
	}
	
	public static String reverse( String s ) {
		int n = s.length();
		if( n == 0 || n == 1 ) return s;
		char c = s.charAt( 0 );
		return Helpers.reverse( s.substring( 1 ) ) + c;
	}
	
	public static double evalPoly(int[] coefs, int[] pows, double x) {
		  double val = 0;
		  for ( int i = 0, j = 0, maxCoefs = coefs.length, maxPows = pows.length;
			i < maxCoefs && j < maxPows; i++, j++ ) {
		    val +=  coefs[ i ] * Math.pow( x, pows[ j ] );
		  }
		  return val;
	}
	
    public static double evalPoly(int[] coefficients, double x) {
        double accumulator = coefficients[ 0 ];
        for (int i = 1, max = coefficients.length; i < max; i++) {
            accumulator = (accumulator * x) + (double) coefficients[ i ];
        }
        return accumulator;
    }
}