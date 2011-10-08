package factorial;

import java.io.PrintStream;

public class Factorial {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static long factorial( int n ) {
		if ( n == 0 ) return 1;
		return n * factorial( n - 1 );
	}
	
	public static long factorialIter( int n ) {
		long result = 1;
		
		for ( int i = 1; i <= n; i++ ) {
			result = result * i;
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factorial.output.println( "4! = " + Factorial.factorial( 4 ) );
		Factorial.output.println( "4! = " + Factorial.factorialIter( 4 ) );
	}

}
