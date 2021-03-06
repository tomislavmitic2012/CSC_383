import java.io.PrintStream;
import java.util.Stack;

/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Class1' is
 * created in the main() method.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class PostfixToInfix {
	private static final PrintStream output = new PrintStream( System.out );
	
	/**
	 * The main entry point for the application.
	 * 
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	public static void main( String[] args ) {
		Stack< String > s = new Stack< String >();
		
		try {
			for( int i = 0, max = args.length; i < max; i++ ) {
				if ( args[ i ].equals( "+" ) ) {
					String a = s.pop(),
						   b = s.pop();
					s.push( b + "+" + a );
				} else if ( args[ i ].equals( "-" ) ) {
					String a = s.pop(),
					   b = s.pop();
					s.push( b + "-" + a );
				} else if ( args[ i ].equals( "*" ) ) {
					String a = s.pop(),
					   b = s.pop();
					s.push( b + "*" + a );					
				} else if ( args[ i ].equals( "/" ) ) {
					String a = s.pop(),
					   	   b = s.pop();
					s.push( b + "/" + a );					
				} else if ( args[ i ].equals( "^" ) ) {
					String a = s.pop(),
					   b = s.pop();
					s.push( b + "^" + a );					
				} else {
					s.push( args[i] );
				}
			}
			
			PostfixToInfix.output.println( s.pop() );
		} catch( Exception se ) {
			se.printStackTrace();
		}
	}
}