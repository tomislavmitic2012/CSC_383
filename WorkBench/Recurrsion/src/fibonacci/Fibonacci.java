package fibonacci;

import java.io.PrintStream;

public class Fibonacci {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static long fibonacci( int n ) {
		if ( n == 0 || n == 1 ) return n;
		return Fibonacci.fibonacci( n - 1 ) + Fibonacci.fibonacci( n - 2 ); 
	}
	
	public static long fibonacciLinearRecur( int n, long f1, long f2) {
		if ( n == 0 ) return f1;
		if ( n == 1 ) return f2;
		
		return Fibonacci.fibonacciLinearRecur( n - 1, f2, f1 + f2);
	}
	
	public static long fibonacciLinearRecur( int n ) {
		return Fibonacci.fibonacciLinearRecur( n, 0, 1 );
	}
	
	public static long fibonacciIterative( int n ) {
		long f1 = 0, f2 = 1, f3 = 0;
		if ( n == 0 || n == 1 ) return n;
		
		for( int i = 2; i <= n; i++ ) {
			f3 = f2 + f1;
			f1 = f2;
			f2 = f3;
		}
		return f3;
	}
	
	public static void main( String[] args ) {
		Fibonacci.output.println( "Binary Recursion Fibonacci, n = 42: " + Fibonacci.fibonacci( 42 ) );
		Fibonacci.output.println( "Linear Recursion Fibonacci, n = 42: " + Fibonacci.fibonacciLinearRecur( 42 ) );
		Fibonacci.output.println( "Iterative Fibonacci, n = 42: " + Fibonacci.fibonacciIterative( 42 ) );
	}
}