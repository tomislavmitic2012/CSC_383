package test_progression;

import Progression.*;

import java.io.PrintStream;

/**
 * Test program for the progression classes
 * 
 * @author Tomislav S. Mitic
 *
 */
public class TestProgression {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		Progression prog;
		
		// test ArithProgression
		output.println( "Arithmetics progression with default increment:" );
		prog = new ArithProgression();
		prog.printProgression( 10 );
		
		output.println( "Arithmetic progression with increment 5: " );
		prog = new ArithProgression( 5 );
		prog.printProgression( 10 );
		output.println();
		
		// test GeoProgression
		output.println( "Geometirc progression with default base:" );
		prog = new GeomProgression();
		prog.printProgression( 10 );
		
		output.println( "Geometirc progression with base 3:" );
		prog = new GeomProgression( 3 );
		prog.printProgression( 10 );
		output.println();
		
		// test FibonacciProgression
		output.println( "Fibonacci progression with default start values:" );
		prog = new FibonacciProgression();
		prog.printProgression( 10 );
		
		output.println( "Fibonacci progression with start values 4 and 6:" );
		prog = new FibonacciProgression( 4, 6 );
		prog.printProgression( 10 );
		output.println();
	}
}
