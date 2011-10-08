package simple_input_output;

import java.io.PrintStream;
import java.io.IOException;
import java.util.Scanner;

public class InputExample {
	private static final PrintStream output = new PrintStream( System.out );
	private static final Scanner input = new Scanner( System.in );
	
	public static void main( String[] args ) throws IOException {
		output.print( "Enter your age in years: " );
		double age = input.nextDouble();
		output.print( "Enter your maximum heart rate: " );
		double rate = input.nextDouble();
		double fb = ( rate - age ) * 0.65;
		output.printf( "%s %.2f.", 
				"Your target fat burning heart rate is ", fb );
	}
}
