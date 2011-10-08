package progression_biginteger;

import java.math.BigInteger;

/**
 * Fibonacci progression
 * 
 * @author Tomislav S. Mitic
 * Assignment #1 Part #1
 * Due Date: 9/24/2011
 *
 *
 */
public class FibonacciProgression extends Progression {
	private FibonacciProgression self = this;
	
	/**
	 * Previous value
	 */
	BigInteger prev;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting 0 and 1 as the first two values.
	 */
	public FibonacciProgression() {
		this( BigInteger.ZERO, BigInteger.ONE );
	}
	
	/**
	 * Parametric constructor providing the first and second values.
	 * 
	 * @param value1 first value
	 * @param value2 second value
	 */
	public FibonacciProgression( BigInteger value1, BigInteger value2 ) {
		self.first = value1;
		self.prev = value2.subtract( value1 );	// fictitious value preceding the first
	}
	
	/**
	 * Advances the progression by adding the previous value to the current value
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected BigInteger nextValue() {
		BigInteger temp = self.prev;
		self.prev = self.cur;
		self.cur = self.cur.add( temp );
		return self.cur;
	}
	
	// Inherits methods firstValue() and printProgression( int ).
}
