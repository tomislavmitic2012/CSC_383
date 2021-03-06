package poly_list;

import java.util.Iterator;
import java.util.LinkedList;
import term.Term;
import compare.Compare;
import java.util.Collections;

/**
 * The polynomial class.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Polynomial {
	private Polynomial self = this;
	
	protected LinkedList< Term > poly;
	
	public Polynomial() {
		self.poly = new LinkedList< Term >();
	}
	
	public Polynomial( long[] array ) {
		if ( ( array.length % 2 ) == 0 ) {
			self.poly = new LinkedList< Term >();
			
			for ( int i = 1, max = array.length; i < max ; i += 2 ) {
				Term polyTerm = new Term( array[ i - 1 ], array[ i ] );
				self.poly.add( polyTerm );
			}
			
			Collections.sort( self.poly, new Compare() );
		} else {
			self.poly = null;
		}
	}
	
	public Polynomial( long exponent, long coefficient ) {
		self.poly = new LinkedList< Term >();
		self.poly.add( new Term( exponent, coefficient ) );
	}
	
	public Polynomial( Polynomial other ) {
		self.poly = other.getPolynomial();
	}
	
	public Polynomial( Term term ) {
		self.poly = new LinkedList< Term >();
		self.poly.add( term );
	}
	
	public LinkedList< Term > getPolynomial() {
		return self.poly;
	}
	
	private String buildPoly() {
		String output = new String( "" );

		for ( Iterator< Term > i = self.getPolynomial().iterator(); i.hasNext(); ) {
			String term = i.next().toString();
			if ( !term.equals( "0" ) ) {
				output += term;
			}
		}
		
		return output;
	}
	
	public boolean isZero() {
		String output = self.buildPoly();
		
		if ( output.equals( "") ) return true;
		return false;
	}
	
	public boolean equal( Polynomial other ) {
		if ( self.getPolynomial().size() == other.getPolynomial().size() ) {
			for( Iterator< Term > p1 = self.getPolynomial().iterator(),
					p2 = other.getPolynomial().iterator(); p1.hasNext() && p2.hasNext(); ) {
				Term term1 = p1.next(),
					 term2 = p2.next();
				
				if ( !term1.equal( term2 ) ) { return false; }
			}
			return true;
		}
		return false;
	}
	
	public long eval( long value ) {
		long result = 0;
		
		for( int i = self.getPolynomial().size() -1; i >= 0; i-- ) {
			result = result * value + self.getPolynomial().get( i ).getCoefficient();
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		if ( self.isZero() ) return " 0";
		
		String output = self.buildPoly();
		String firstSign = output.substring( 0, 3 );
		if ( firstSign.equalsIgnoreCase( " + ") ) return output.substring( 2 );
		return output;
	}
	
	/* 
	 * Static methods used for algebraic manipulations of the polynomials
	 */
	public static Polynomial add( Polynomial p1, Polynomial p2 ) {
		Polynomial newPoly = new Polynomial();
		boolean isOnlyTerm = false;
		
		for ( Iterator< Term > i = p1.getPolynomial().iterator(); i.hasNext(); ) {
			Term term1 = i.next();
			
			for ( Iterator< Term > j = p2.getPolynomial().iterator(); j.hasNext(); ) {
				Term term2 = j.next();
				if ( term1.getExponent() == term2.getExponent() && term1.getVariable() == term2.getVariable() &&
						term1.getVariable() == term2.getVariable() ) {
					long coefficient = term1.getCoefficient() + term2.getCoefficient();
					if ( coefficient != 0 ) {
						newPoly.getPolynomial().add( new Term( term1.getExponent(), coefficient, term1.getVariable() ) );
					}
					isOnlyTerm = false;
					break;
				} else if ( term1.getExponent() != term2.getExponent() || term1.getVariable() != term2.getVariable() ||
						term1.getVariable() != term2.getVariable() ) {
					isOnlyTerm = true;
				}
			}
			
			if ( isOnlyTerm ) {
				if ( term1.getCoefficient() != 0 ) {
					newPoly.getPolynomial().add( new Term( term1.getExponent(), term1.getCoefficient(), term1.getVariable() ) );
				}
				isOnlyTerm = false;
			}
		}
		return newPoly;
	}
	
	public static Polynomial subtract( Polynomial p1, Polynomial p2 ) {		
		return Polynomial.add( p1, Polynomial.negate( p2 ) );
	}
	
	public static Polynomial negate( Polynomial poly ) {
		Polynomial newPoly = new Polynomial();
		
		for ( Iterator< Term > i = poly.getPolynomial().iterator(); i.hasNext(); ) {
			Term term = i.next();
			newPoly.getPolynomial().add( new Term( term.getExponent(), - term.getCoefficient(), term.getVariable() ) );
		}
		
		return newPoly;
	}
	
	public static Polynomial derivative( Polynomial poly ) {
		Polynomial newPoly = new Polynomial();
		
		for ( Iterator< Term > i = poly.getPolynomial().iterator(); i.hasNext(); ) {
			Term term = i.next();
			
			if ( term.getExponent() == 0 ) { // the derivative of a constant is zero
				continue;
			}
			
			newPoly.getPolynomial().add( new Term( term.getExponent() - 1, term.getCoefficient() * term.getExponent(), term.getVariable() ) );
		}
		
		return newPoly;
	}
	
	public static Polynomial multiply( Polynomial p1, Polynomial p2 ) {
		Polynomial newPoly = new Polynomial();
		
		for ( int i = 0, maxPoly1 = p1.getPolynomial().size(); i < maxPoly1; i++ ) {
			Term term1 = p1.getPolynomial().get( i );
			
			for ( int j = 0, maxPoly2 = p2.getPolynomial().size(); j < maxPoly2; j++ ) {
				Term term2 = p2.getPolynomial().get( j );
				newPoly.getPolynomial().add( new Term( term1.getExponent() + term2.getExponent(),
						term1.getCoefficient() * term2.getCoefficient(), term1.getVariable() ) );
			}
		}
		
		Collections.sort( newPoly.getPolynomial(), new Compare() );
		
		Term previous = newPoly.getPolynomial().getFirst(),						// Seed previous with the first term in the list
			 current;
		for ( int i = 1, max = newPoly.getPolynomial().size(); i < max; ++i ) {
			current = newPoly.getPolynomial().get( i );
				
			if ( current.getExponent() == previous.getExponent() &&
					current.getVariable() == previous.getVariable() ) {
				int prevIndex = newPoly.getPolynomial().indexOf( previous );
				previous.setCoefficient( previous.getCoefficient() + current.getCoefficient() );
				newPoly.getPolynomial().set( prevIndex, previous );
				previous = newPoly.getPolynomial().get( prevIndex );
				newPoly.getPolynomial().remove( current );
				max = newPoly.getPolynomial().size();
				i = prevIndex;
			} else {
				previous = current;
			}
		}
		
		return newPoly;
	}
	
	public static Polynomial multiply( Polynomial p1, Term term ) {
		Polynomial poly = new Polynomial( term );
		return Polynomial.multiply( p1, poly );
	}
	
	public static Polynomial multiply( Polynomial p1, long constant ) {
		Polynomial newPoly = new Polynomial();
		
		for ( int i = 0, maxPoly1 = p1.getPolynomial().size(); i < maxPoly1; i++ ) {
			Term term1 = p1.getPolynomial().get( i );
			
			newPoly.getPolynomial().add( new Term( term1.getExponent(),
					term1.getCoefficient() * constant, term1.getVariable() ) );
		}
		
		Collections.sort( newPoly.getPolynomial(), new Compare() );
		
		return newPoly;
	}
	
	public static Polynomial divide( Polynomial p1, Polynomial p2 ) {
		if ( Math.abs( p2.getPolynomial().getFirst().getCoefficient() ) != 1 ) { return null; }
		
		Polynomial newPoly = new Polynomial(),
				   numerator = p1, 
				   remainder;
		boolean continueDivision = true;
		
		while ( continueDivision ) {
			Term numeratorFirstTerm = numerator.getPolynomial().getFirst(), 
				 denominatorFirstTerm = p2.getPolynomial().getFirst(),
				 quotientPart = new Term( Math.abs( denominatorFirstTerm.getExponent() - numeratorFirstTerm.getExponent() ),
						 denominatorFirstTerm.getCoefficient() * numeratorFirstTerm.getCoefficient(), numeratorFirstTerm.getVariable() );

			newPoly.getPolynomial().add( quotientPart );				// store the quotient part since it is what will be returned 
			remainder = Polynomial.multiply( p2, quotientPart);			// Calculate the remainder
			numerator = Polynomial.subtract( numerator, remainder );
			
			if ( quotientPart.getExponent() == 0 ) {
				continueDivision = false;
			}
		}
		
		Collections.sort( newPoly.getPolynomial(), new Compare() );
		
		return newPoly;
	}
	
	public static Polynomial mod( Polynomial p1, Polynomial p2 ) {
		Polynomial numerator = p1, 
				   remainder = new Polynomial();
		boolean continueDivision = true;
		
		while ( continueDivision ) {
			Term numeratorFirstTerm = numerator.getPolynomial().getFirst(), 
				 denominatorFirstTerm = p2.getPolynomial().getFirst(),
				 quotientPart = new Term( Math.abs( denominatorFirstTerm.getExponent() - numeratorFirstTerm.getExponent() ),
						 denominatorFirstTerm.getCoefficient() * numeratorFirstTerm.getCoefficient(), numeratorFirstTerm.getVariable() );

			remainder = Polynomial.multiply( p2, quotientPart);			// Calculate the remainder
			numerator = Polynomial.subtract( numerator, remainder );
			
			if ( quotientPart.getExponent() == 0 ) {
				continueDivision = false;
			}
		}
		
		Collections.sort( numerator.getPolynomial(), new Compare() );
		
		return numerator;
	}
}