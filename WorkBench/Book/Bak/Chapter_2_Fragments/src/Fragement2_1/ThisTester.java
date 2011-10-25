package Fragement2_1;

import java.io.PrintStream;

public class ThisTester {
	private static final PrintStream output = new PrintStream( System.out );
	private ThisTester self = this;
	
	public int dog = 2;	// instance variable
	
	public void clobber() {
		int dog = 5;	// a different dog!
		output.println( "The dog local variable = " + dog );
		output.println( "The dog field = " + self.dog );
	}
	
	public static void main( String[] args ) {
		ThisTester t = new ThisTester();
		t.clobber();
	}
}
