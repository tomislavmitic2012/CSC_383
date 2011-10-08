package progression_biginteger;

import java.math.BigInteger;

/**
 * Geometric Progression
 * 
 * @author Tomislav S. Mitic
 * 
 */
public class GeomProgression extends Progression{
	private GeomProgression self = this;
	
	/**
	 * Base.
	 */
	protected BigInteger base;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting base 2.
	 */
	public GeomProgression() {
		this( new BigInteger( "2" ) );
	}
	
	/**
	 * Parametric constructor providing the base.
	 * 
	 * @param b base of the progression
	 */
	public GeomProgression( BigInteger b ) {
		self.base = b;
		self.first = BigInteger.ONE;
		self.cur = self.first;
	}
	
	/**
	 * Advances the progression by multiplying the base with the current value
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected BigInteger nextValue() {
		self.cur = self.cur.multiply( self.base );
		return self.cur;
	}
	
	// Inherits methods firstValue() and printProgression( int )
}