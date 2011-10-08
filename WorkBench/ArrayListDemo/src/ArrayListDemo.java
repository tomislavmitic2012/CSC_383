import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;

public class ArrayListDemo {
	private static final PrintStream output = new PrintStream( System.out );
	private static final Scanner keyboard = new Scanner( System.in );
	
	public static void main( String[] args ) {
		ArrayList< String > toDoList = new ArrayList< String >( 20 );
		boolean done = false;
		String next = null, answer;
		
		ArrayListDemo.output.println( "Enter entries, when prompted. " );
		
		while ( !done ) {
			ArrayListDemo.output.println( "Input an entry:" );
			next = ArrayListDemo.keyboard.nextLine();
			toDoList.add( next );
			
			ArrayListDemo.output.println( "More items for the list?" );
			answer = ArrayListDemo.keyboard.nextLine();
			if( !( answer.equalsIgnoreCase( "yes" ) ) ) {
				done = true;
			}
		}
		
		for( String entry : toDoList ) {
			ArrayListDemo.output.println( entry );
		}
	}
}
