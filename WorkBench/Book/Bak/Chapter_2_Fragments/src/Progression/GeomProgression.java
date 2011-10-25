package Progression;

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
	protected long base;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting base 2.
	 */
	public GeomProgression() {
		this( 2 );
	}
	
	/**
	 * Parametric constructor providing the base.
	 * 
	 * @param b base of the progression
	 */
	public GeomProgression( long b ) {
		self.base = b;
		self.first = 1;
		self.cur = self.first;
	}
	
	/**
	 * Advances the progression by multiplying the base with the current value
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected long nextValue() {
		self.cur *= self.base;
		return self.cur;
	}
	
	// Inherits methods firstValue() and printProgression( int )
}