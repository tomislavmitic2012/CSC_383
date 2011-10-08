import java.util.Scanner;
import java.io.PrintStream;

public class TwoTypePairDemo {
	private static final Scanner keyboard = new Scanner( System.in );
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		TwoTypePair< String, Integer > rating = new TwoTypePair< String, Integer >( "The Car Guys", 8 );
		
		TwoTypePairDemo.output.println( "Our current rating for " + rating.getFirst() + "\n"
				+ "is " + rating.getSecond() );
		
		TwoTypePairDemo.output.println( "How would you rate them?" );
		int score = TwoTypePairDemo.keyboard.nextInt();
		rating.setSecond( score );
		
		TwoTypePairDemo.output.println( "Our new rating for " + rating.getFirst() + "\n"
				+ "is " + rating.getSecond() );
	}
}