package exceptions;

@SuppressWarnings("serial")
public class FullQueueException extends Exception {
	public FullQueueException( String errorMessage ) {
		super( errorMessage );
	}
}