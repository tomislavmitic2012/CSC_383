package exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	public InvalidPositionException( String error ) {
		super( error );
	}
}