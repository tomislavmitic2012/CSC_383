package Fragment1_4;

import java.io.PrintStream;

public class DayTripper {
	public enum Day { MON, TUES, WED, THU, FRI, SAT, SUN };
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		Day d = Day.MON;
		output.println( "Initially d is " + d );
		d = Day.WED;
		output.println( "Then it is " + d );
		Day t = Day.valueOf( "WED" );
		output.println( "I say d and t are the same: " + ( d == t ));
	}
}
