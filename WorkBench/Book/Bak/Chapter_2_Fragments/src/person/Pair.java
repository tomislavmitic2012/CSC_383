package person;

import java.io.PrintStream;

public class Pair< K, V > {
	private static final PrintStream output = new PrintStream( System.out );
	private Pair< K, V > self = this;
	
	private K key;
	private V value;
	
	public void set( K k, V v ) {
		self.key = k;
		self.value = v;
	}
	
	public K getKey() {
		return self.key;
	}
	
	public V getValue() {
		return self.value;
	}
	
	@Override
	public String toString() {
		return "[" + self.getKey() + ", " + self.getValue() + "]";
	}
	
	/*public static void main( String[] args ) {
		Pair< String, Integer > pair1 = new Pair< String, Integer >();
		pair1.set( new String( "height" ), new Integer( 36 ) );
		output.println( pair1 );
		output.println();
		
		Pair< Student, Double > pair2 = new Pair< Student, Double >();
		pair2.set( new Student( "A5976", "Sue", 19 ), new Double( 9.5 ) );
		output.println( pair2 );
		output.println();
	}*/
	
	public static void main( String[] args ) {
		Pair< String, Integer >[] a = new Pair[10];		// right, but gives a warning
		// Pair< String, Integer >[] b = new Pair< String, Integer >[ 10 ];	// wrong!!
		a[ 0 ] = new Pair< String, Integer >();		// this is completely right
		a[ 0 ].set( "Dog", 10 );	// this and the next statement are right too
		output.println( "First pair is " + a[ 0 ].getKey() + ", " + a[ 0 ].getValue() );
	}
}
