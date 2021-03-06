import java.io.PrintStream;
import net.datastructures.*;

public class Josephus {
	public static PrintStream output = new PrintStream( System.out );
	/**
	 * Solution of the Josephus problem using a queue
	 */
	public static < E > E JosephusSolve( Queue < E > Q, int k ) {
		if ( Q.isEmpty() ) return null;
		
		while ( Q.size() > 1 ) {
			Josephus.output.println( " Queue: " + Q + " k = " + k );
			for ( int i = 0; i < k; i++ ) {
				Q.enqueue( Q.dequeue() );								// move the front element to the end
			}
			E e = Q.dequeue();											// remove the front element from the collection
			Josephus.output.println( "   " + e + " is out");
		}
		
		return Q.dequeue();												// the winner
	}
	
	/**
	 * Build a queue from an array of objects
	 */
	public static < E > Queue < E > buildQueue( E a[] ) {
		Queue< E > Q = new NodeQueue< E >();
		for ( int i = 0, max = a.length; i < max; i++ ) {
			Q.enqueue( a[ i ] );
		}
		return Q;
	}
	
	/**
	 * Tester methods
	 */
	public static void main( String[] args ) {
		String[] a1 = { "Alice", "Bob", "Cindy", "Doug", "Ed", "Fred" },
				 a2 = { "Gene", "Hope", "Irene", "Jack", "Kim", "Lance" },
				 a3 = { "Mike", "Roberto" };
		
		Josephus.output.println( "First winner is " + Josephus.JosephusSolve( Josephus.buildQueue( a1 ),  3 ) );
		Josephus.output.println( "Second winner is " + Josephus.JosephusSolve( Josephus.buildQueue( a2 ),  10 ) );
		Josephus.output.println( "Third winner is " + Josephus.JosephusSolve( Josephus.buildQueue( a3 ),  7 ) );
	}
}