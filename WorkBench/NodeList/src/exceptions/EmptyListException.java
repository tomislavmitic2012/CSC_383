package exceptions;

@SuppressWarnings("serial")
public class EmptyListException extends Exception {
	public EmptyListException( String error ) {
		super( error );
	}
}