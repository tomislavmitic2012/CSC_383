package Progression;

import java.io.PrintStream;

/**
 * 
 * @author Tomislav S. Mitic
 *
 * A class for numeric progressions
 */
public class Progression {
	private static final PrintStream output = new PrintStream( System.out );
	private Progression self = this;
	
	/** 
	 * First value of the progression
	 */
	protected long first;
	
	/**
	 * Current value of the progression
	 */
	protected long cur;
	
	/**
	 * Default constructor.
	 */
	public Progression() {
		self.cur = self.first = 0;
	}
	
	/**
	 * Resets the progression to the first value
	 * 
	 * @return first value
	 */
	protected long firstValue() {
		self.cur = self.first;
		return self.cur;
	}
	
	/**
	 * Advances the progression to the next value
	 * 
	 * @return next value of the progression
	 */
	protected long nextValue() {
		return ++cur;	// default next value
	}
	
	/**
	 * Prints the first n values of the progression
	 * 
	 * @param n number of values to print
	 */
	public void printProgression( int n ) {
		Progression.output.print( self.firstValue() );
		for ( int i = 2; i <= n; i++ ) {
			Progression.output.print( " " + self.nextValue() );
		}
		Progression.output.println();	// end the line
	}
}