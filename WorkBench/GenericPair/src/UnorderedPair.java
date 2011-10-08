public class UnorderedPair< T > extends Pair< T > {
	private UnorderedPair< T > self = this;
	
	public UnorderedPair() {
		self.setFirst( null );
		self.setSecond( null );
	}
	
	public UnorderedPair( T firsItem, T secondItem ) {
		self.setFirst( firsItem );
		self.setSecond( secondItem );
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals( Object otherObject ) {
		if ( otherObject == null ) {
			return false;
		} else if (self.getClass() != otherObject.getClass() ) {
			return false;
		} else {
			UnorderedPair< T > otherPair = ( UnorderedPair< T > )otherObject;
			return ( self.getFirst().equals( otherPair.getFirst() ) 
					&& self.getSecond().equals( otherPair.getSecond() ) ) ||
					( self.getFirst().equals( otherPair.getSecond() ) 
							&& self.getSecond().equals( otherPair.getFirst() ) );
		}
	}
}
