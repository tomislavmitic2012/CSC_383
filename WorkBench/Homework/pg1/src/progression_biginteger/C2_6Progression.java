package progression_biginteger;

import java.math.BigInteger;

/**
 * Floor of the square root of the previous value
 * 
 * @author Tomislav S. Mitic
 * Assignment #1 Part #3
 * Due Date: 9/24/2011
 *
 */
public class C2_6Progression extends Progression {
	private C2_6Progression self = this;
	
	/**
	 * Previous value
	 */
	BigInteger prev;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting first two number of the progression.
	 */
	public C2_6Progression() {
		this( new BigInteger( "65536" ) );
	}
	
	/**
	 * Parametric constructor providing the increment
	 */
	public C2_6Progression( BigInteger value1 ) {
		self.first = value1;
		self.prev = value1;
	}
	
	/**
	 * Advances the progression by adding the increment to the current value.
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected BigInteger nextValue() {
		BigInteger temp = self.cur;
		self.prev = self.cur;
		self.cur = self.sqrt( temp );
		return self.cur;
	}

	/**
	 * Floor of square root function
	 * 
	 * @param n a big integer to find the floor of the square root of
	 * @return the floor of the square root
	 */
	private BigInteger sqrt( BigInteger n ) {
		BigInteger r = BigInteger.ONE;
		for ( ; ( r.multiply( r ) ).compareTo( n ) <= 0; r = r.add( BigInteger.ONE ) ) {}
		
		if ( ( r.multiply( r ) ).compareTo( n ) == 0 ) {
			return r;
		} else {
			return r.subtract( BigInteger.ONE );
		}
	}

	// Inherits methods firstValue() and printProgression( int )
}
