import java.io.PrintStream;

public class ArrayCopy {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = new int[ 10 ];
		int[] c = new int[ 5 ];
		int[] d = new int[ 10 ];
		
		b = a.clone();
		c = a;
		System.arraycopy( a, 0, d, 0, 10 );
		
		a[ 0 ] = 100;
		
		for( int e : a ) {
			ArrayCopy.output.print( e + " " );
		}
		ArrayCopy.output.println( "\n" );
		
		for( int e : b ) {
			ArrayCopy.output.print( e + " " );
		}
		ArrayCopy.output.println( "\n" );
		
		for( int e : c ) {
			ArrayCopy.output.print( e + " " );
		}
		ArrayCopy.output.println( "\n" );
		
		for( int e : d ) {
			ArrayCopy.output.print( e + " " );
		}
		ArrayCopy.output.println( "\n" );
	}
}