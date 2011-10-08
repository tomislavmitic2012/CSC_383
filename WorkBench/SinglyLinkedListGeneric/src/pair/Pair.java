package pair;

public class Pair< T, S > {
	private Pair< T, S > self = this;
	
	private T first;
	private S second;
	
	public Pair( T a, S b ) {		// Constructor.
		self.setPair( a, b );
	}
	
	public T getFirst() {
		return self.first;
	}
	
	public S getSecond() {
		return self.second;
	}
	
	private void setPair( T value1, S value2 ) {
		self.setFirst( value1 );
		self.setSecond( value2 );
	}
	
	public void setFirst( T value ) {
		self.first = value;
	}
	
	public void setSecond( S value ) {
		self.second = value;
	}
	
	@Override
	public String toString() {
		String str = "";
		str = self.first + " : " + self.second;
		return str;
	}
}