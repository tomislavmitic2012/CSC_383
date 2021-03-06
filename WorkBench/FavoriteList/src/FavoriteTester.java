import java.io.*;
import javax.swing.*;
import exceptions.BoundaryViolationException;
import exceptions.EmptyListException;
import exceptions.InvalidPositionException;
import favorite_list.FavoriteList;
import favorite_list_mtf.FavoriteListMTF;
import java.awt.*;
import java.net.*;
import java.util.Random;

//TODO: fix this shiznit that broke right now

/**
 * Example program for the FavoriteList and FavoriteListMTF classes
 * 
 * @author Tomislav S. Mitic
 *
 */
public class FavoriteTester {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		String[] urlArray = {
				"http://wiley.com",
				"http://datastructures.net",
				"http://algorithmdesign.net",
				"http://www.brown.edu",
				"http://uci.edu"
		};
		
		FavoriteList< String > L1 = new FavoriteList< String >();
		FavoriteListMTF< String > L2 = new FavoriteListMTF< String >();
		int n = 20;															// number of access operations
		// Simulation scenario: access n times a random URL
		Random rand = new Random();
		for ( int k = 0; k < n; k++ ) {
			FavoriteTester.output.println( "--------------------" );
			int i = rand.nextInt( urlArray.length );						// random index
			String url = urlArray[ i ];										// random url
			FavoriteTester.output.println( "Accessing: " + url );
			try {
				L1.access( url );
				FavoriteTester.output.println( "L1 = " + L1 );
				L2.access( url );
				FavoriteTester.output.println( "L2 = " + L2 );
			} catch (EmptyListException e) {
				e.printStackTrace();
			} catch (InvalidPositionException e) {
				e.printStackTrace();
			} catch (BoundaryViolationException e) {
				e.printStackTrace();
			}
		}
		int t = L1.size() / 2;
		FavoriteTester.output.println( "--------------------" );
		FavoriteTester.output.println( "Top " + t + " in L1 = " + L1.top( t ) );
		FavoriteTester.output.println( "Top " + t + " in L2 = " + L2.top( t ) );
		
		// Pop up a browser window displaying the most popular URL in L1
		try {
			String popular = L1.top( 1 ).iterator().next();				// most popular URL in L1
			JEditorPane jep = new JEditorPane( popular );
			jep.setEditable( false );
			JFrame frame = new JFrame( popular );
			frame.getContentPane().add( new JScrollPane( jep ), BorderLayout.CENTER );
			frame.setSize( 640, 480 );
			frame.setVisible( true );
		} catch ( IOException e ) {}									// ignore I/O exceptions
	}
}