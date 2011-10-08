package Progression;

/**
 * Arithmetic progression.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class ArithProgression extends Progression {
	private ArithProgression self = this;
	
	/**
	 * Increment
	 */
	protected long inc;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting a unit increment.
	 */
	public ArithProgression() {
		this( 1 );
	}
	
	/**
	 * Parametric constructor providing the increment
	 */
	public ArithProgression( long increment ) {
		self.inc = increment;
	}
	
	/**
	 * Advances the progression by adding the increment to the current value.
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected long nextValue() {
		self.cur += self.inc;
		return self.cur;
	}
	
	// Inherits methods firstValue() and printProgression( int )
}