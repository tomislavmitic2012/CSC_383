package Fragment1_2;

import java.io.PrintStream;

public class Base {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		boolean flag = true;
		char ch = 'A';
		byte b = 12;
		short s = 24;
		int i = 257;
		long l = 890L;	// note the use of "L" here
		float f = 3.1415F;	// not the use of "F" here
		double d = 2.18128;
		output.println( "flag = " + flag );		// the "+" is string concatenation
		output.println( "ch = " + ch );
		output.println( "b = " + b );
		output.println( "s = " + s );
		output.println( "i = " + i );
		output.println( "l = " + l );
		output.println( "f = " + f );
		output.println( "d = " + d );
	}
}
