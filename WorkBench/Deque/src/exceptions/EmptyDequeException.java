package exceptions;

@SuppressWarnings("serial")
public class EmptyDequeException extends Exception {
	public EmptyDequeException( String errorMessage ) {
		super( errorMessage );
	}
}