@SuppressWarnings("rawtypes")
public class PairBounded< T extends Comparable > {
	private PairBounded< T > self = this;
	
	private T first;
	private T second;
	
	public PairBounded() {
		self.first = null;
		self.second = null;
	}
	
	public PairBounded( T firstItem, T secondItem ) {
		self.first = firstItem;
		self.second = secondItem;
	}
	
	public void setFirst( T newFirst ) {
		self.first = newFirst;
	}
	
	public void setSecond( T newSecond ) {
		self.second = newSecond;
	}
	
	public T getFirst() {
		return self.first;
	}
	
	public T getSecond() {
		return self.second;
	}
	
	@Override
	public String toString() {
		return ( "first: " + self.first.toString() + "\n"
				+ "second: " + self.second.toString() );
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals( Object otherObject ) {
		if ( otherObject == null ) {
			return false;
		} else if (self.getClass() != otherObject.getClass() ) {
			return false;
		} else {
			PairBounded< T > otherPair = ( PairBounded< T > )otherObject;
			return ( self.first.equals( otherPair.first ) 
					&& self.second.equals( otherPair.second ) );
		}
	}
	
	@SuppressWarnings("unchecked")
	public T max() {
		if (self.first.compareTo( self.second ) <= 0 ) {
			return self.first;
		} else {
			return self.second;
		}
	}
}
