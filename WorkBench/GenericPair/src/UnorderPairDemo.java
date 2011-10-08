import java.io.PrintStream;

public class UnorderPairDemo {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		UnorderedPair< String > p1 = new UnorderedPair< String >( "peanuts", "beer" );
		UnorderedPair< String > p2 = new UnorderedPair< String >( "beer", "peanuts" );
		
		if ( p1.equals( p2 ) ) {
			UnorderPairDemo.output.println( p1.getFirst() + " and " + p1.getSecond() + " is the same as " + 
					p2.getFirst() + " and " + p2.getSecond() );
		}
	}
}
