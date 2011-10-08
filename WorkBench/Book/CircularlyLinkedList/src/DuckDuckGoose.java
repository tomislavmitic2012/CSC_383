import java.io.PrintStream;
import java.util.Random;
import node.Node;
import circularly_linked_list.CircleList;

public class DuckDuckGoose {
	private static final PrintStream output = new PrintStream( System.out );
	
	/**
	 * Simulation of Duck, Duck, Goose with a circularly linked list
	 */
	public static void main( String[] args ) {
		CircleList C = new CircleList();
		int N = 3;										// number of iterations of the game
		Node it;										// the player who is it
		Node goose;										// the goose
		
		Random rand = new Random();
		rand.setSeed( System.currentTimeMillis() );		// use current time as seed
		
		// The players...
		String[] names = { "Bob", "Jen", "Pam", "Tom", "Ron", "Vic", "Sue", "Joe" };
		
		for( int i = 0, max = names.length; i < max; i++ ) {
			C.add( new Node( names[ i ], null ) );
			C.advance();
		}
		
		for( int i = 0; i < N; i++ ) {					// play Duck, Duck, Goose N times
			DuckDuckGoose.output.println( "Playing Duck, Duck, Goose for " + C.toString() );
			it = C.remove();
			DuckDuckGoose.output.println( it.getElement() + " is it." );
			
			while( rand.nextBoolean() || rand.nextBoolean() ) {		// march around circle
				C.advance();							// advance with probability 3/4
				DuckDuckGoose.output.println( C.getCursor().getElement() + " is a duck." );
			}
			
			goose = C.remove();
			DuckDuckGoose.output.println( goose.getElement() + " is the goose!" );
			
			if ( rand.nextBoolean() ) {
				DuckDuckGoose.output.println( "The goose won!" );
				C.add( goose );							// add the goose back in its old place
				C.advance();							// now the cursor is on the goose
				C.add( it );							// The "it" person will be it again in the  next round
			} else {
				DuckDuckGoose.output.println( "The goose lost!" );
				C.add( it );							// add who's "it" back at the goose's place
				C.advance();							// now the cursor is on the "it" person
				C.add( goose );							// The goose will be "it" in the next round
			}
		}
		DuckDuckGoose.output.println( "Final circle is " + C.toString() );
	}
}
