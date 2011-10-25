package progression_biginteger;

import java.math.BigInteger;

/**
 * Arithmetic progression.
 * 
 * @author Tomislav S. Mitic
 * Assignment #1 Part #1
 * Due Date: 9/24/2011
 *
 */
public class ArithProgression extends Progression {
	private ArithProgression self = this;
	
	/**
	 * Increment
	 */
	protected BigInteger inc;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting a unit increment.
	 */
	public ArithProgression() {
		this( BigInteger.ONE );
	}
	
	/**
	 * Parametric constructor providing the increment
	 */
	public ArithProgression( BigInteger increment ) {
		self.inc = increment;
	}
	
	/**
	 * Advances the progression by adding the increment to the current value.
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected BigInteger nextValue() {
		self.cur = self.cur.add( inc );
		return self.cur;
	}
	
	// Inherits methods firstValue() and printProgression( int )
}