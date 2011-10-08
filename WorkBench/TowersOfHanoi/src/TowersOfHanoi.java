import java.io.PrintStream;
import java.util.Scanner;

public class TowersOfHanoi {
	private static final Scanner keyboard = new Scanner( System.in );
	private static final PrintStream output = new PrintStream( System.out );
	
	public static int moveTower( int n, char source, char dest, char temp ) {
		TowersOfHanoi.output.println( "moveTower: " + n + " items from " + source + " to " + dest );
		
		if ( n == 1 ) {
			TowersOfHanoi.output.println( "Move 1 from " + source + " to " + dest );
			return 1;
		} else {
			int num_moves;
			// move n - 1 items from x to z
			num_moves = TowersOfHanoi.moveTower( n - 1, source, temp, dest );
			TowersOfHanoi.output.println( "Move " + n + " from " + source + " to " + dest );
			num_moves++;
			// move n - 1 items from z to y
			num_moves += moveTower( n - 1, temp, dest, source );
			return num_moves;
		}
	}
	
	public static void main( String[] args ) {
		int n;
		TowersOfHanoi.output.print( "How many in the tower? " );
		n = TowersOfHanoi.keyboard.nextInt();
		n = TowersOfHanoi.moveTower( n, 'x', 'y', 'z' );
		TowersOfHanoi.output.println( "It took " + n + " moves " );
	}
}
