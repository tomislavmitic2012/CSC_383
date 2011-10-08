public class Pair< T > {
	private Pair< T > self = this;
	
	private T first;
	private T second;
	
	public Pair() {
		self.first = null;
		self.second = null;
	}
	
	public Pair( T firstItem, T secondItem ) {
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
			Pair< T > otherPair = ( Pair< T > )otherObject;
			return ( self.first.equals( otherPair.first ) 
					&& self.second.equals( otherPair.second ) );
		}
	}
}
