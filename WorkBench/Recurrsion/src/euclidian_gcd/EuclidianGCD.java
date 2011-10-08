package euclidian_gcd;

import java.io.PrintStream;

public class EuclidianGCD {
	public static final PrintStream output = new PrintStream( System.out );
	
	/**
	 * Euclid's greatest common divisor algorithm.
	 * Find the largest number that evenly divides into both n and d.
	 * require: n >= 0, d >= 0.
	 * fastest if n >= d.
	 */
	public static int gcd( int n, int d ) {
		if ( d == 0 ) return n;
		int r = n % d;
		return ( r == 0 ) ? d : gcd( d, r );
	}
	
	public static void main( String[] args ) {
		EuclidianGCD.output.println( "GCD of 555 & 42 is: " + EuclidianGCD.gcd( 555, 42 ) );
	}
}
