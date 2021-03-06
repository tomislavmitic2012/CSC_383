import java.io.PrintStream;
import poly_list.Polynomial;
import term.Term;

/**
 * Polynomial Test program.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class TestPoly {
	public static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		long[] a1 = { 3,1, 2,-1, 1,1, 0,-1 };
		long[] b1 = { 3,-1, 2,1, 1,-1, 0,1 };
		long[] c1 = { 2,1, 0,-1 };
		
		Polynomial poly1 = new Polynomial( a1 );
		Polynomial poly2 = new Polynomial( b1 );
		Polynomial poly3 = new Polynomial( c1 );
		
		// Output Some polynomials you just created
		TestPoly.output.println( "poly 1:" + poly1 );
		TestPoly.output.println( "poly 2:" + poly2 );
		TestPoly.output.println( "poly 3:" + poly3 );
		TestPoly.output.println();
		
		Polynomial poly4 = Polynomial.add( poly1, poly2 );
		Polynomial poly5 = Polynomial.add( poly1, poly3 );
		
		// Output polynomial after addition
		TestPoly.output.println( "poly4: poly1 + poly2 =" + poly4 );
		TestPoly.output.println( "poly5: poly1 + poly 3 =" + poly5 );
		TestPoly.output.println();
		
		poly4 = Polynomial.negate( poly5 );
		
		// Output the negated polynomial
		TestPoly.output.println( "poly5 negated: -poly5  =" + poly4 );
		TestPoly.output.println();
		
		Polynomial poly6 = Polynomial.subtract( poly1, poly5 );
		
		// Output polynomial after subtraction
		TestPoly.output.println( "poly6: poly1 - poly5 =" + poly6 );
		TestPoly.output.println();
		
		Polynomial poly7 = Polynomial.derivative( poly6 );
		
		// Output the derivative
		TestPoly.output.println( "derivative of poly6: poly7 =" + poly7 );
		TestPoly.output.println();
		
		Polynomial poly8 = Polynomial.multiply( poly3, poly3 );
		Polynomial poly9 = Polynomial.multiply( poly1, poly2 );
		
		// Output the multiplications of polynomials
		TestPoly.output.println( "poly3 * poly3 =" + poly8 );
		TestPoly.output.println( "poly9: poly1 * poly2 =" + poly9 );
		TestPoly.output.println( "poly1 * poly3 =" + Polynomial.multiply( poly1, poly3 ) );
		TestPoly.output.println( "poly3 * poly1 =" + Polynomial.multiply( poly3, poly1 ) );
		TestPoly.output.println( "2 * poly1 =" + Polynomial.multiply( poly1, 2) );
		TestPoly.output.println( "poly1 * x^2 =" + Polynomial.multiply( poly1, new Term( 2, 1 ) ) );
		TestPoly.output.println();
		
		Polynomial quotient = Polynomial.divide( poly9, poly3 );
		Polynomial remainder = Polynomial.mod( poly9, poly3 );
		
		// Output division operations
		TestPoly.output.println( "Quotient of poly9 / poly3 =" + quotient );
		TestPoly.output.println( "Remainder of poly9 / poly3 =" + remainder );
		TestPoly.output.println( "Quotient of poly9 / poly1 =" + Polynomial.divide( poly9, poly1 ) );
		TestPoly.output.println();
		
		// Output for testing if polynomials are equal
		TestPoly.output.print( poly1 + " and " + quotient );
		if ( poly1.equal( quotient ) ) {
			TestPoly.output.println( " are the same!" );
		} else {
			TestPoly.output.println( " are not the same!" );
		}
		TestPoly.output.print( Polynomial.multiply( poly1, poly3 ) + " and " + Polynomial.multiply( poly3, poly1 ) );
		if ( Polynomial.multiply( poly1, poly3 ).equal( Polynomial.multiply( poly3, poly1 ) ) ) {
			TestPoly.output.println( " are the same!" );
		} else {
			TestPoly.output.println( " are not the same!" );
		}
		TestPoly.output.println();
		
		// Output for the evaluation of a polynomial
		TestPoly.output.println( "poly9 evaulated: poly9(1) = " + poly9.eval(1) );
		TestPoly.output.println( "poly9 evaluated: poly9(2) = " + poly9.eval(2) );
	}
}