package caesar_cipher;

import java.io.PrintStream;

public class Caesar {
	public static final PrintStream output = new PrintStream( System.out );
	private Caesar self = this;
	
	public static final int ALPHASIZE = 26;		// English alphabet (uppercase only)
	public static final char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
		'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	protected char[] encrypt = new char[ ALPHASIZE ];	// Encryption array
	protected char[] decrypt = new char[ ALPHASIZE ];	// Decryption array
	
	/** 
	 * Constructor that initializes the encryption and decryption arrays
	 */
	public Caesar() {
		for (int i = 0; i < Caesar.ALPHASIZE; i++ ) {
			self.encrypt[ i ] = alpha[ ( i + 3 ) % Caesar.ALPHASIZE ];	// rotate alphabet by 3 places
		}
		
		for (int i = 0; i < Caesar.ALPHASIZE; i++ ) {
			self.decrypt[ encrypt[ i ] - 'A' ] = alpha[ i ];
		}
	}
	
	/**
	 * Encryption method
	 */
	public String encrypt( String secret ) {
		char[] mess = secret.toCharArray();		// the message array
		for (int i = 0, max = mess.length; i < max; i++ ) {		// encryption loop
			if ( Character.isUpperCase( mess[ i ] ) ) {			// we have a letter to change
				mess[ i ] = self.encrypt[ mess[ i ] - 'A' ];	// use letter as an index
			}
		}
		return new String( mess );
	}
	
	/**
	 * Decryption method
	 */
	public String decrypt( String secret ) {
		char[] mess = secret.toCharArray();		// the message array
		for (int i = 0, max = mess.length; i < max; i++ ) {		// decryption loop
			if ( Character.isUpperCase( mess[ i ] ) ) {			// we have a letter to change
				mess[ i ] = decrypt[ mess[ i ] - 'A' ];			// use letter as an index			
			}
		}
		return new String( mess );
	}
	
	/**
	 * Simple main method for testing the Caesar cipher
	 */
	public static void main( String[] args ) {
		Caesar cipher = new Caesar();		// Create a Caesar cipher object
		
		Caesar.output.println( "Encryption order = " + new String( cipher.encrypt ) );
		Caesar.output.println( "Decryption order = " + new String( cipher.decrypt ) );
		String secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = cipher.encrypt( secret );
		Caesar.output.println( secret );	// the ciphertext
		secret = cipher.decrypt( secret );
		Caesar.output.println( secret );	// should be plaintext again
	}
}
