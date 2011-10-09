package exceptions;

@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception {
	public BoundaryViolationException( String error ) {
		super( error );
	}
}