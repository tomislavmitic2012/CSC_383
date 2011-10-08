import java.io.PrintStream;
import java.util.Arrays;
import reverse.ArrayReverse;

/** 
 * Tester routine for reversing arrays
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Test {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		Integer[] a = { 4, 8, 15, 16, 23, 42 };							// autoboxing allows this
		String[] s = { "Jack", "Kate", "Hurley", "Jin", "Boone" };
		
		Test.output.println( "a = " + Arrays.toString( a ) );
		Test.output.println( "s = " + Arrays.toString( s ) );
		Test.output.println( "Reversing..." );
		
		ArrayReverse.reverse( a );
		ArrayReverse.reverse( s );
		
		Test.output.println( "a = " + Arrays.toString( a ) );
		Test.output.println( "s = " + Arrays.toString( s ) );
	}
}