import java.io.PrintStream;
import pair.Pair;
import queue.Queue;;

public class Test {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Integer[] days = { 31,28,31,30,31,30,31,31,30,31,30,31 };
		
		Queue< Integer > queue1 = new Queue< Integer >();
		Queue< Double > queue2 = new Queue< Double >();
		Queue< String > queue3 = new Queue< String >();
		Queue < Pair< String, Integer > > queue4 = new Queue< Pair< String, Integer > >();
		Pair< String, Integer > temp;
		
		for( int i = 0; i < 10; i++ ) {
			queue1.enqueue( i );
		}
		
		while( !queue1.isEmpty() ) {
			Test.output.print( queue1.dequeue() + " " );
		}
		Test.output.println();
		
		for( int i = 0; i < 10; i++ ) {
			queue2.enqueue( ( double ) i / ( i + 1 ) );
		}
		
		while( !queue2.isEmpty() ) {
			Test.output.printf( "%5.4f ", queue2.dequeue() );
		}
		Test.output.println();
		
		for( int i = 0; i < 12; i++ ) {
			queue3.enqueue( months[ i ] );
		}
		
		while( !queue3.isEmpty() ) {
			Test.output.printf( "%s ", queue3.dequeue() );
		}
		Test.output.println();
		
		for( int i = 0; i < 12; i++ ) {
			queue4.enqueue( new Pair< String, Integer>( months[ i ], days[ i ] ) );
		}
		
		while( !queue4.isEmpty() ) {
			temp = queue4.dequeue();
			Test.output.printf( "%s: %2d, ", temp.getFirst(), temp.getSecond() );
		}
		Test.output.println();
		
		// Is this correct?
		@SuppressWarnings("unchecked")
		Pair< String, Integer >[] pairArr = new Pair[ 12 ];
		for( int i = 0; i < 12; i++ ) {
			pairArr[ i ] = new Pair< String, Integer>( months[ i ], days[ i ] );
		}
		Test.output.println( "How many occurances of Apr: 30: " + 
				Queue.< Pair< String, Integer > >countOccurences( 
						pairArr, new Pair< String, Integer >( "Apr", 30 ) ) );
		
		for( int i = 0; i < 12; i++ ) {
			queue4.enqueue( new Pair< String, Integer>( months[ i ], days[ i ] ) );
		}
		Test.output.println( "How many occurances of Apr: 30: " + 
				Queue.< Pair< String, Integer > >countOccurences( 
						queue4, new Pair< String, Integer >( "Apr", 30 ) ) );
	}
}