package progression_biginteger;

import java.math.BigInteger;

/**
 * Absolute value of the difference between the previous two values.
 * 
 * @author Tomislav S. Mitic
 * Assignment #1 Part #2
 * Due Date: 9/24/2011
 *
 */
public class C2_5Progression extends Progression {
	private C2_5Progression self = this;
	
	/**
	 * Previous value
	 */
	BigInteger prev;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting first two numbers of the progression (2, 200).
	 */
	public C2_5Progression() {
		this( new BigInteger( "2" ), new BigInteger( "200" ) );
	}
	
	/**
	 * Parametric constructor providing the initial two values
	 */
	public C2_5Progression( BigInteger value1, BigInteger value2  ) {
		self.first = value1;
		self.prev = value2.add( value1 );
	}
	
	/**
	 * Advances the progression by finding the absolute value of the
	 * difference between the previous two values.
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected BigInteger nextValue() {
		BigInteger temp = self.prev;
		self.prev = self.cur;
		self.cur = ( self.cur.subtract( temp ) ).abs();
		return self.cur;
	}

	// Inherits methods firstValue() and printProgression( int )
}