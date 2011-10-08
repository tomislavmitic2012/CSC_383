import java.io.PrintStream;
import pair.Pair;
import stack.Stack;

public class Test {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Integer[] days = { 31,28,31,30,31,30,31,31,30,31,30,31 };
		
		Stack< Integer > stack1 = new Stack< Integer >();
		Stack< Double > stack2 = new Stack< Double >();
		Stack< String > stack3 = new Stack< String >();
		Stack < Pair< String, Integer > > stack4 = new Stack< Pair< String, Integer > >();
		Pair< String, Integer > temp;
		
		for( int i = 0; i < 10; i++ ) {
			stack1.push( i );
		}
		
		while( !stack1.isEmpty() ) {
			Test.output.print( stack1.pop() + " " );
		}
		Test.output.println();
		
		for( int i = 0; i < 10; i++ ) {
			stack2.push( ( double ) i / ( i + 1 ) );
		}
		
		while( !stack2.isEmpty() ) {
			Test.output.printf( "%5.4f ", stack2.pop() );
		}
		Test.output.println();
		
		for( int i = 0; i < 12; i++ ) {
			stack3.push( months[ i ] );
		}
		
		while( !stack3.isEmpty() ) {
			Test.output.printf( "%s ", stack3.pop() );
		}
		Test.output.println();
		
		for( int i = 0; i < 12; i++ ) {
			stack4.push( new Pair< String, Integer>( months[ i ], days[ i ] ) );
		}
		
		while( !stack4.isEmpty() ) {
			temp = stack4.pop();
			Test.output.printf( "%s: %2d, ", temp.getFirst(), temp.getSecond() );
		}
		Test.output.println();
	}
}