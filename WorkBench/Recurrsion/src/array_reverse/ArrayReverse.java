package array_reverse;

import java.io.PrintStream;

public class ArrayReverse {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void reverse( int[] A, int i, int j ) {
		int temp;
		
		if ( i < j ) {
			temp = A[ i ];
			A[ i ] = A[ j ];
			A[ j ] = temp;
			ArrayReverse.reverse( A, i + 1, j - 1 );
		}
	}
	
	public static void reverse( int[] A ) {
		ArrayReverse.reverse( A, 0, A.length - 1 );
	}
	
	public static void reverseIter( int[] A, int i, int j ) {
		int temp;
		
		while( i < j ) {
			temp = A[ i ];
			A[ i ] = A[ j ];
			A[ j ] = temp;
			i++;
			j--;
		}
	}
	
	public static void main( String[] args ) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
			  B = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		
		ArrayReverse.reverse( A );
		ArrayReverse.reverseIter( B, 0, B.length - 1 );
		
		ArrayReverse.output.print( "Reverse of A: " );
		for( int elem : A ) {
			ArrayReverse.output.print( elem + " ");
		}
		ArrayReverse.output.println();
		
		ArrayReverse.output.print( "Reverse of B: " );
		for( int elem : B ) {
			ArrayReverse.output.print( elem + " ");
		}
		ArrayReverse.output.println();
	}
}