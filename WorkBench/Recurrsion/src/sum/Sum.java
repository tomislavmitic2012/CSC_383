package sum;

import java.io.PrintStream;

public class Sum {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static int sum( int[] A, int n ) {
		if ( n == 1 ) return A[ 0 ];
		return A[ n - 1 ] + sum( A, n - 1 );
	}
	
	public static int sumIter( int[] A, int n ) {
		int result = 0;
		
		for ( int i = 0; i < n; i++ ) {
			result += A[ i ];
		}
		return result;
	}
	
	public static int sumBinary( int[] A, int i, int j ) {
		if ( i > j ) return 0;
		else if ( i == j ) return A[ i ];
		
		int mid = ( i + j ) / 2;
		
		return Sum.sumBinary( A, i, mid ) + Sum.sumBinary( A, mid + 1, j );
	}
	
	public static int sumBinary( int[] A ) {
		return Sum.sumBinary( A, 0, A.length - 1 );
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		Sum.output.println( "Sum A[]: " + Sum.sum( A, A.length ) );
		Sum.output.println( "Sum A[]: " + Sum.sumIter( A, A.length ) );
		Sum.output.println( "Sum A[]: " + Sum.sumBinary( A ) );
	}

}
