package progression_biginteger;

import java.io.PrintStream;
import java.math.BigInteger;

/**
 * 
 * @author Tomislav S. Mitic
 * Assignment #1 Part #1
 * Due Date: 9/24/2011
 *
 * A class for numeric progressions
 */
public class Progression {
	private static final PrintStream output = new PrintStream( System.out );
	private Progression self = this;
	
	/** 
	 * First value of the progression
	 */
	protected BigInteger first;
	
	/**
	 * Current value of the progression
	 */
	protected BigInteger cur;
	
	/**
	 * Default constructor.
	 */
	public Progression() {
		self.cur = self.first = BigInteger.ZERO;
	}
	
	/**
	 * Resets the progression to the first value
	 * 
	 * @return first value
	 */
	protected BigInteger firstValue() {
		self.cur = self.first;
		return self.cur;
	}
	
	/**
	 * Advances the progression to the next value
	 * 
	 * @return next value of the progression
	 */
	protected BigInteger nextValue() {
		self.cur = self.cur.add( BigInteger.ONE );	// default next value
		return self.cur;
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
		Progression.output.println();	// ends the line
	}
}