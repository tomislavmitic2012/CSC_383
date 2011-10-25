package array_test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		int[] num = new int[ 10 ];
		Random rand = new Random();		// a pseudo-random number generator
		rand.setSeed( System.currentTimeMillis() );		// use current time as a seed
		// fill the num array with pseudo-random numbers from 0 to 99, inclusive
		for( int i = 0, max = num.length; i < max; i++ ) {
			num[ i ] = rand.nextInt( 100 );		// the next pseudo-random number
		}
		int[] old = ( int[] ) num.clone();		// cloning the num array
		output.println( "arrays equal before sort: " + Arrays.equals( old,  num ) );
		Arrays.sort( num );		// sorting the num array (old is unchanged_
		output.println( "arrays equal after sort: " + Arrays.equals( old,  num ) );
		output.println( "old = " + Arrays.toString( old ) );
		output.println( "new = " + Arrays.toString( num ) );
	}
}
