package test_progression_biginteger;

import progression_biginteger.*;

import java.io.PrintStream;
import java.math.BigInteger;

/**
 * Test program for the progression classes
 * 
 * @author Tomislav S. Mitic
 * Assignment #1 Part #5
 * Due Date: 9/24/2011
 *
 */
public class TestProgression {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		Progression prog;
		
		// test ArithProgression
		output.println( "Arithmetic progression with default increment:" );
		prog = new ArithProgression();
		prog.printProgression( 10 );
		
		output.println( "Arithmetic progression with increment 5: " );
		prog = new ArithProgression( new BigInteger( "5" ) );
		prog.printProgression( 10 );
		output.println();
		
		// test GeoProgression
		output.println( "Geometirc progression with default base:" );
		prog = new GeomProgression();
		prog.printProgression( 10 );
		
		output.println( "Geometirc progression with base 3:" );
		prog = new GeomProgression( new BigInteger( "3" ) );
		prog.printProgression( 10 );
		output.println();
		
		// test FibonacciProgression
		output.println( "Fibonacci progression with default start values:" );
		prog = new FibonacciProgression();
		prog.printProgression( 10 );
		
		output.println( "Fibonacci progression with start values 4 and 6:" );
		prog = new FibonacciProgression( new BigInteger( "4" ), new BigInteger( "6" ) );
		prog.printProgression( 10 );
		output.println();
		
		// test C2_5Progression
		output.println( "C2_5Progression progression with default start values:" );
		prog = new C2_5Progression();
		prog.printProgression( 10 );
		
		output.println( "C2_5Progression progression with start values 4 and 300:" );
		prog = new C2_5Progression( new BigInteger( "4" ), new BigInteger( "300" ) );
		prog.printProgression( 10 );
		output.println();
		
		// test C2_6Progression
		output.println( "C2_6Progression progression with default start value:" );
		prog = new C2_6Progression();
		prog.printProgression( 10 );
		
		output.println( "C2_6Progression progression with start value 4294967296:" );
		prog = new C2_6Progression( new BigInteger( "4294967296" ) );
		prog.printProgression( 10 );
		output.println();
		
		// test PrimeProgression
		output.println( "PrimeProgression progression with default start value:" );
		prog = new PrimeProgression();
		prog.printProgression( 10 );
		
		output.println( "PrimeProgression progression with start value 73:" );
		prog = new PrimeProgression( new BigInteger( "73" ) );
		prog.printProgression( 10 );
		
		output.println( "PrimeProgression progression with start value 100:" );
		prog = new PrimeProgression( new BigInteger( "100" ) );
		prog.printProgression( 10 );
		output.println();
	}
}
