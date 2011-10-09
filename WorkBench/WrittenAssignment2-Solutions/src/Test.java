import java.io.PrintStream;
import linked_list.List;
import helpers.*;

public class Test {
	public static PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		int[] A = { 1, 2, 35, 4, 31, 22, 23 };
		
		for ( int e : A )
			Test.output.print( e + " " );
		
		long time1 = System.nanoTime();
		Test.output.println("\nmax = " + Helpers.max( A, A.length ) );
		long time2 = System.nanoTime();
		Test.output.println("Amount of time max ran: " + ( time2 - time1 ) );
		
		List list = List.build( A );
		list.print();
		
		list.reverse();
		list.print();
		
		list.reverse2();
		list.print();
		
		Test.output.println( "The size of the list = " + List.count( list ) );
		
		Test.output.println("1234 = " + Helpers.convert( "1234" ) );
		
		int[] R = new int[ 2 ];
		
		Helpers.maxmin( A, A.length, R );
		Test.output.printf( "Max = %d and Min = %d\n", R[ 0 ], R[ 1 ] );
		
		int[] RR = new int[ 2 ];
		
		Helpers.maxmin2( A, RR );
		Test.output.printf( "Max = %d and Min = %d\n", RR[ 0 ], RR[ 1 ] );
		
		String s = "pots&pans";
		Test.output.printf( "THe reverse string of %s is %s\n\n", s, Helpers.reverse( s ) );
	}
}