public class TwoTypePair< T1, T2 > {
	private TwoTypePair< T1, T2 > self = this;
	
	private T1 first;
	private T2 second;
	
	public TwoTypePair() {
		self.first = null;
		self.second = null;
	}
	
	public TwoTypePair( T1 firstItem, T2 secondItem ) {
		self.first = firstItem;
		self.second = secondItem;
	}
	
	public void setFirst( T1 newFirst ) {
		self.first = newFirst;
	}
	
	public void setSecond( T2 newSecond ) {
		self.second = newSecond;
	}
	
	public T1 getFirst() {
		return self.first;
	}
	
	public T2 getSecond() {
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
			TwoTypePair< T1, T2 > otherPair = ( TwoTypePair< T1, T2 > )otherObject;
			return ( self.first.equals( otherPair.first ) 
					&& self.second.equals( otherPair.second ) );
		}
	}
}