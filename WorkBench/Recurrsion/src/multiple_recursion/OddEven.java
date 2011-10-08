package multiple_recursion;

import java.io.PrintStream;

public class OddEven {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static boolean odd( int n ) {
		if ( n == 0 ) return false;
		return OddEven.even( n - 1 );
	}
	
	public static boolean even( int n ) {
		if ( n == 0 ) return true;
		return OddEven.odd( n - 1 );
	}
	
	public static void main( String[] args ) {
		OddEven.output.println( "555 is odd: " + OddEven.odd( 555 ) );
		OddEven.output.println( "552 is even: " + OddEven.even( 552 ) );
		OddEven.output.println( "553 is even: " + OddEven.even( 553 ) );
	}
}
