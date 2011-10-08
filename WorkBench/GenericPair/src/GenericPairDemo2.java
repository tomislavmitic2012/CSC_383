import java.util.Scanner;
import java.io.PrintStream;

public class GenericPairDemo2 {
	private static final Scanner keyboard = new Scanner( System.in );
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		Pair< Integer > secretPair = new Pair< Integer >( 42, 24 );
		
		GenericPairDemo2.output.println( "Enter two numbers:" );
		int n1 = GenericPairDemo2.keyboard.nextInt();
		int n2 = GenericPairDemo2.keyboard.nextInt();
		Pair< Integer > inputPair = new Pair< Integer >( n1, n2 );
		
		if ( inputPair.equals( secretPair ) ) {
			GenericPairDemo2.output.println( "You guessed the secret numbers" );
			GenericPairDemo2.output.println( "in the correct order!" );
		} else {
			GenericPairDemo2.output.println( "You guessed incorrectly" );
			GenericPairDemo2.output.println( "You guessed" );
			GenericPairDemo2.output.println( inputPair );
			GenericPairDemo2.output.println( "The secret numbers are" );
			GenericPairDemo2.output.println( secretPair );
		}
	}
}
