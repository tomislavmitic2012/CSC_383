package reverse;

import java.util.Stack;

public class ArrayReverse {
	public static < E > void reverse( E[] a ) {
		Stack< E > S = new Stack< E >();
		for( int i = 0, max = a.length; i < max; i++ ) {
			S.push( a[ i ] );
		}
		for( int i = 0, max = a.length; i < max; i++ ) {
			a[ i ] = S.pop();
		}
	}
}