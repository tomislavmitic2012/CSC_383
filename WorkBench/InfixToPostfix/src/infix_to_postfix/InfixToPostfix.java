package infix_to_postfix;

import java.util.Stack;
import java.util.StringTokenizer;
import java.io.PrintStream;

public class InfixToPostfix {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void infixToPostfix( StringTokenizer E ) {
		// assume that E is the infix arithmetic expression and that
		// stack will hold operators and is initially empty
		Stack< String > stack = new Stack< String >();
		stack.push( "@" );										// initializes stack with bottom marker
		
		while( true ) {
			String token = E.nextToken();
			
			if( token.equalsIgnoreCase( ";" ) ) {											// end of expression
				while( stack.peek() != "@" ) {								// flush stack
					String datum = stack.pop();
					if ( datum.equalsIgnoreCase( "-un" ) || datum.equalsIgnoreCase( "-bi"  ) ) {
						datum = datum.substring( datum.indexOf( '-' ), datum.indexOf( '-' ) + 1 );
					}
					InfixToPostfix.output.print( datum );
				}
				stack.pop();												// empty stack
				InfixToPostfix.output.println();
				return;
			} else if( !token.equalsIgnoreCase( "(" ) && !token.equalsIgnoreCase( "=" ) && !token.equalsIgnoreCase( "^" ) &&		// the sequence of operands is identical
					!token.equalsIgnoreCase( "-un" ) && !token.equalsIgnoreCase( "*" ) && !token.equalsIgnoreCase( "/" ) &&			// in both infix and postfix
					!token.equalsIgnoreCase( "+" ) && !token.equalsIgnoreCase( "-bi" ) && !token.equalsIgnoreCase( ")" ) ) {
				InfixToPostfix.output.print( token );
			} else if( token.equalsIgnoreCase( ")" ) ) {										// look for a matching "("
				while( !stack.peek().equalsIgnoreCase( "(" ) ) {
					String datum = stack.pop();
					if ( datum.equalsIgnoreCase( "-un" ) || datum.equalsIgnoreCase( "-bi"  ) ) {
						datum = datum.substring( datum.indexOf( '-' ), datum.indexOf( '-' ) + 1 );
					}
					InfixToPostfix.output.print( datum );
				}
				stack.pop();
			} else {														// token is an operator
				while( InfixToPostfix.ISP( stack.peek() ) >= InfixToPostfix.ICP( token ) ) {
					String datum = stack.pop();
					if ( datum.equalsIgnoreCase( "-un" ) || datum.equalsIgnoreCase( "-bi"  ) ) {
						datum = datum.substring( datum.indexOf( '-' ), datum.indexOf( '-' ) + 1 );
					}
					InfixToPostfix.output.print( datum );
				}
				stack.push( token );
			}
		}
	}
	
	private static int ISP( String datum ) {
		if( datum.equalsIgnoreCase( "@" ) ) return -2;
		else if ( datum.equalsIgnoreCase( "=" ) ) return -1;
		else if ( datum.equalsIgnoreCase( "^" ) ) return 3;
		else if ( datum.equalsIgnoreCase( "-un" ) ) return 3;
		else if ( datum.equalsIgnoreCase( "*" ) || datum.equalsIgnoreCase( "/" ) ) return 2;
		else if ( datum.equalsIgnoreCase( "+" ) || datum.equalsIgnoreCase( "-bi" ) ) return 1;
		else return 0;
	}
	
	private static int ICP( String datum ) {
		if( datum.equalsIgnoreCase( "@" ) ) return -2;
		else if ( datum.equalsIgnoreCase( "=" ) ) return -1;
		else if ( datum.equalsIgnoreCase( "^" ) ) return 4;
		else if ( datum.equalsIgnoreCase( "-un" ) ) return 4;
		else if ( datum.equalsIgnoreCase( "*" ) || datum.equalsIgnoreCase( "/" ) ) return 2;
		else if ( datum.equalsIgnoreCase( "+" ) || datum.equalsIgnoreCase( "-bi" ) ) return 1;
		else return 5;
	}
	
	public static void main( String[] args ) {
		StringTokenizer expression1 = new StringTokenizer( "2 * 3 + 4 ;", " " );
		StringTokenizer expression2 = new StringTokenizer( "a * ( b / c + d ) ;", " " );
		StringTokenizer expression3 = new StringTokenizer( "a -bi ( b / ( c -bi d ) * e + f ) ^ g ;", " " );
		StringTokenizer expression4 = new StringTokenizer( "( a -bi b * c ) / ( d * e ^ f * g + h ) ;", " " );
		StringTokenizer expression5 = new StringTokenizer( "( a + b ) * c ^ ( a -bi b ) / ( a + b * c ) ;", " " );
		StringTokenizer expression6 = new StringTokenizer( "a ^ b / c ^ d * ( a -bi b ) ^ c ;", " " );
		StringTokenizer expression7 = new StringTokenizer( "( a * b -bi c / d + e ) + ( a -bi b -bi c -bi d * d ) / ( a + b * c ) ;", " " );
		StringTokenizer expression8 = new StringTokenizer( "( a + b ) * c ^ ( a -bi b ) ^ ( a + b * c ) ;", " " );
		InfixToPostfix.infixToPostfix( expression1 );
		InfixToPostfix.infixToPostfix( expression2 );
		InfixToPostfix.infixToPostfix( expression3 );
		InfixToPostfix.infixToPostfix( expression4 );
		InfixToPostfix.infixToPostfix( expression5 );
		InfixToPostfix.infixToPostfix( expression6 );
		InfixToPostfix.infixToPostfix( expression7 );
		InfixToPostfix.infixToPostfix( expression8 );
	}
}
