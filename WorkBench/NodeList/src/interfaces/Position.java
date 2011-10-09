package interfaces;

import exceptions.InvalidPositionException;

public interface Position< E > {
	/**
	 * Return the element stored at this position.
	 */
	E element() throws InvalidPositionException;
}