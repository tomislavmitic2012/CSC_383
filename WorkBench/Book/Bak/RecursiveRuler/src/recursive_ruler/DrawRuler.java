package recursive_ruler;

import java.io.PrintStream;

public class DrawRuler {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void drawOneTick( int tickLength ) {	// draw a tick with no label
		DrawRuler.drawOneTick( tickLength, -1 );
	}
	
	public static void drawOneTick( int tickLength, int tickLabel ) {	// draw one tick
		for ( int i = 0; i < tickLength; i++ ) {
			DrawRuler.output.print( "-" );
		}
		if ( tickLabel >= 0 ) {
			DrawRuler.output.print( " " + tickLabel );
		}
		
		DrawRuler.output.print( "\n" );
	}
	
	public static void drawTicks( int tickLength ) {		// draw ticks of given length
		if ( tickLength > 0) {								// stop when length drops to 0
			DrawRuler.drawTicks( tickLength - 1 );			// recursively draw left ticks
			DrawRuler.drawOneTick( tickLength );			// draw center tick
			DrawRuler.drawTicks( tickLength - 1 );			// recursively draw right ticks
		}
	}
	
	public static void drawRuler( int nInches, int majorLength ) {		// draw ruler
		DrawRuler.drawOneTick( majorLength, 0 );									// draws tick 0 and its label
		for( int i = 1; i <= nInches; i++ ) {
			DrawRuler.drawTicks( majorLength -1 );						// draw ticks for this inch
			DrawRuler.drawOneTick( majorLength, i );					// draw tick i and its label
		}
	}
	
	public static void main( String[] args ) {
		DrawRuler.drawRuler( 2, 5);
	}
}
