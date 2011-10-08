import java.util.Scanner;
import java.io.PrintStream;

public class GenericPairDemo {
	private static final Scanner keyboard = new Scanner( System.in );
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		Pair< String > secretPair = new Pair< String >( "Happy", "Day" );
		
		GenericPairDemo.output.println( "Enter two words: ");
		String word1 = GenericPairDemo.keyboard.next();
		String word2 = GenericPairDemo.keyboard.next();
		Pair< String > inputPair = new Pair< String >( word1, word2 );
		
		if ( inputPair.equals( secretPair ) ) {
			GenericPairDemo.output.println( "You guessed the secret words" );
			GenericPairDemo.output.println( "in the correct order!" );
		} else {
			GenericPairDemo.output.println( "You guessed incorrectly" );
			GenericPairDemo.output.println( "You guessed" );
			GenericPairDemo.output.println( inputPair );
			GenericPairDemo.output.println( "The secret words are" );
			GenericPairDemo.output.println( secretPair );
		}
	}
}
