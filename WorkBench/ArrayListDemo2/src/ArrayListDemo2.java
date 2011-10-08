import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;

public class ArrayListDemo2 {
	private static final PrintStream output = new PrintStream( System.out );
	private static final Scanner keyboard = new Scanner( System.in );
	
	public static void main( String[] args ) {
		ArrayList< Integer > toDoList = new ArrayList< Integer >( 20 );
		boolean done = false;
		String next = null, answer;
		
		ArrayListDemo2.output.println( "Enter entries, when prompted. " );
		
		while ( !done ) {
			ArrayListDemo2.output.println( "Input an entry:" );
			next = ArrayListDemo2.keyboard.nextLine();
			toDoList.add( Integer.parseInt( next ) );
			
			ArrayListDemo2.output.println( "More items for the list?" );
			answer = ArrayListDemo2.keyboard.nextLine();
			if( !( answer.equalsIgnoreCase( "yes" ) ) ) {
				done = true;
			}
		}
		
		ArrayListDemo2.output.println( "The list contains:" );
		for( int entry : toDoList ) {
			ArrayListDemo2.output.println( entry );
		}
	}
}
