package simple_input_output;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Console;
import java.util.Scanner;

public class InputExample2 {	
	public static void main( String[] args ) throws IOException {
		Console c = System.console();
		if ( c == null ) return;	// no console
		PrintWriter output = c.writer();
		Scanner input = new Scanner( c.reader() );
		
		output.print( "Enter your age in years: " );
		c.flush();
		double age = input.nextDouble();
		output.print( "Enter your maximum heart rate: " );
		c.flush();
		double rate = input.nextDouble();
		double fb = ( rate - age ) * 0.65;
		output.printf( "%s %.2f.", 
				"Your target fat burning heart rate is ", fb );
	}
}
