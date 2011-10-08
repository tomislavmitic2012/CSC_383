package compare;

import java.util.Comparator;
import term.Term;

/**
 * Used to sort a polynomial by decreasing exponent.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Compare implements Comparator<Term> {
	public int compare( Term arg1, Term arg2 ) {
		if ( arg1.compareTo( arg2 ) == 1 ) {
			return -1;
		} else if ( arg1.compareTo( arg2 ) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
}