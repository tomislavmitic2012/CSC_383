import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;

public class GolfScores {
	public static final PrintStream output = new PrintStream( System.out );
	public static final Scanner keyboard = new Scanner( System.in );
	
	/**
	 * Shows differences between each of a list of golf scores and their average
	 */
	public static void main( String[] args ) {
		ArrayList< Double > score = new ArrayList< Double >();
		
		GolfScores.output.println( "This program reads golf scores and shows" );
		GolfScores.output.println( "how much each differs from the average. ");
		
		GolfScores.output.println( "Enter golf scores: " );
		GolfScores.fillArrayList( score );
		GolfScores.showDifference( score );
	}
	
	/**
	 * Reads values into the array a.
	 */
	public static void fillArrayList( ArrayList< Double > a ) {
		GolfScores.output.println( "Enter a list of nonnegative numbers." );
		GolfScores.output.println( "Mark the end of the list with a negative number." );
		
		double next;
		
		next = GolfScores.keyboard.nextDouble();
		while( next >= 0 ) {
			a.add( next );									// b/c of automatic boxing, we can treat values of type double
			next = GolfScores.keyboard.nextDouble();		// as if their type were Double.
		}
	}
	
	/**
	 * Returns the average of numbers in a.
	 */
	public static double computeAverage( ArrayList< Double > a ) {
		double total = 0;
		for( Double element : a ) {
			total = total + element;
		}
		
		int numberOfScores = a.size();
		if( numberOfScores > 0 ) {
			return ( total / numberOfScores );
		} else {
			GolfScores.output.println( "Error: Trying to average 0 numbers." );
			GolfScores.output.println( "computeAverage returns 0." );
			return 0;
		}
	}
	
	/**
	 * Gives screen output showing how much each of the elements in a differ
	 * from their average.
	 */
	public static void showDifference( ArrayList< Double > a ) {
		double average = GolfScores.computeAverage( a );
		GolfScores.output.println( "Average of the " + a.size()
				+ " scores = " + average );
		GolfScores.output.println( "The scores are: " );
		for( Double element : a ) {
			GolfScores.output.println( element + " differs from average by "
					+ ( element - average ) );
		}
	}
}
