package html;

import java.io.*;
import java.util.Scanner;
import net.datastructures.*;

/**
 * Simplified test of matching tags in an HTML document
 * 
 * @author Tomislav S. Mitic
 *
 */
public class HTML {
	private static final PrintStream output = new PrintStream( System.out );
	
	/**
	 * Strip the first and last characters off a <tag> string.
	 */
	public static String stripEnds( String t ) {
		if ( t.length() <= 2 ) return null;			// this is a degenerate tag
		return t.substring( 1, t.length() - 1 );
	}
	
	/**
	 * Test if a stripped tag string is empty or a true opening tag.
	 */
	public static boolean isOpeningTag( String tag ) {
		return ( tag.length() == 0 ) || ( tag.charAt( 0 ) != '/' );
	}
	
	/**
	 * Test if stripped tag1 matches closing tag2 (first character is '/').
	 */
	public static boolean areMatching( String tag1, String tag2 ) {
		return tag1.equals( tag2.substring( 1 ) );
	}
	
	/**
	 * Test if every opening tag has a matching closing tag
	 */
	public static boolean isHTMLMatched( String[] tag ) {
		Stack< String > S = new NodeStack< String >();		// Stack for matching tags
		
		for ( int i = 0; ( i < tag.length ) && ( tag[ i ] != null ); i++ ) {
			if ( HTML.isOpeningTag( tag[ i ] ) ) {
				S.push( tag[ i] );
			} else {
				if ( S.isEmpty() ) {
					return false;							// nothing to match
				}
				if ( !HTML.areMatching( S.pop(), tag[ i ] ) ) {
					return false;							// wrong match						
				}
			}
		}
		if ( S.isEmpty() ) return true;						// we matched everything
		return false;										// we have same tags that never were matched
	}
	
	public final static int CAPACITY = 1000;				// Tag array size
	
	/**
	 * Parse an HTML document into an array of html tags
	 */
	public static String[] parseHTML( Scanner s ) {
		String[] tag = new String[ HTML.CAPACITY ];			// the tag array initially all null
		int count = 0;										// tag counter
		String token;
		while( s.hasNextLine() ) {
			while( ( token = s.findInLine( "<[^>]*>" ) ) != null ) { 		// find the next tag
				tag[ count++ ] = HTML.stripEnds( token );	// strip the ends off this tag
			}
			s.nextLine();									// go to the next line
		}
		return tag;
	}
	
	public static void main( String[] args ) throws IOException {		// tester
		if ( HTML.isHTMLMatched( HTML.parseHTML( new Scanner( System.in ) )) ) {
			HTML.output.println( "The input file is a matched HTML document." );
		} else {
			HTML.output.println( "The input file is not a matched HTML document." );
		}
	}
}