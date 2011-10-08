package Progression;

/**
 * Fibonacci progression
 * 
 * @author Tomislav S. Mitic
 *
 */
public class FibonacciProgression extends Progression {
	private FibonacciProgression self = this;
	
	/**
	 * Previous value
	 */
	long prev;
	
	// Inherits variables first and cur.
	
	/**
	 * Default constructor setting 0 and 1 as the first two values.
	 */
	public FibonacciProgression() {
		this( 0, 1 );
	}
	
	/**
	 * Parametric constructor providing the first and second values.
	 * 
	 * @param value1 first value
	 * @param value2 second value
	 */
	public FibonacciProgression( long value1, long value2 ) {
		self.first = value1;
		self.prev = value2 - value1;	// fictitious value preceding the first
	}
	
	/**
	 * Advances the progression by adding the previous value to the current value
	 * 
	 * @return next value of the progression
	 */
	@Override
	protected long nextValue() {
		long temp = self.prev;
		self.prev = self.cur;
		self.cur += temp;
		return self.cur;
	}
	
	// Inherits methods firstValue() and printProgression( int ).
}
