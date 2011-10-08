package term;

/**
 * Polynomial Term class
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Term implements Comparable< Term > {
	private Term self = this;
	
	protected long coef;
	protected long exp;
	protected char variable = 'x';
	
	public Term() {
		self.coef = 1;
		self.exp = 0;
	}
	
	public Term( long exponent, long coefficient ) {
		self.setCoefficient( coefficient );
		self.setExponent( exponent );
	}
	
	public Term( long exponent, long coefficient, char var ) {
		self.setCoefficient( coefficient );
		self.setExponent( exponent );
		self.setVariable( var );
	}
	
	public void setCoefficient( long coefficient ) {
		self.coef = coefficient;
	}
	
	public long getCoefficient() {
		return self.coef;
	}
	
	public void setExponent( long exponent ) {
		self.exp = exponent;
	}
	
	public long getExponent() {
		return self.exp;
	}
	
	public void setVariable( char var ) {
		self.variable = var;
	}
	
	public char getVariable() {
		return self.variable;
	}
	
	public boolean equal( Term other ) {
		if( other == null ) return false;
		if( self.getExponent() != other.getExponent() ||
				self.getCoefficient() != other.getCoefficient() ) return false;
		return true;
	}
	
	@Override
	public String toString() {
		if( self.getCoefficient() == 0 ) return "0";
		
		String sign = ( self.getCoefficient() > 0 ) ? " + " : " - ";
		String ex = ( self.getExponent() == 1 ) ? " " : ( "" + self.getExponent() );
		String co = ( Math.abs( self.getCoefficient() ) == 1 ) ? "" : ( "" + Math.abs( self.getCoefficient() ) );
		
		if( self.getExponent() == 0 ) {
			if( Math.abs( self.getCoefficient() ) == 1 ) return sign + Math.abs( self.getCoefficient() );
			else return sign + co;
		} else if ( self.getExponent() == 1 ) {
			if( Math.abs( self.getCoefficient() ) == 1 ) return sign + self.getVariable();
			else return sign + co + self.getVariable();
		} else {
			return sign + co + self.getVariable() + "^" + ex;
		}
	}
	
	public int compareTo( Term other ) {
		if ( self.getExponent() > other.getExponent() ) return 1;
		else if ( self.getExponent() < other.getExponent() ) return -1;
		else return 0;
	}
}