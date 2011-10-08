package progression_biginteger;

import java.math.BigInteger;

/**
 * Prime progression
 * 
 * @author Tomislav S. Mitic
 * Assignment #1 Part #4
 * Due Date: 9/24/2011
 *
 */
public class PrimeProgression extends Progression {
	private PrimeProgression self = this;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting the default initial value of 2.
	 */
	public PrimeProgression() {
		this( new BigInteger( "2" ) );
	}
	
	/**
	 * Parametric constructor providing an initial value
	 */
	public PrimeProgression( BigInteger value1 ) {
		self.first = value1;
		self.cur = value1.nextProbablePrime();
	}
	
	/**
	 * Advances the progression by adding the increment to the current value.
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected BigInteger nextValue() {
		BigInteger temp = self.cur;
		self.cur = temp.nextProbablePrime();
		return self.cur;
	}

	// Inherits methods firstValue() and printProgression( int )
}
