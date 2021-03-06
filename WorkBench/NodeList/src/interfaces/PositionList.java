package interfaces;

import java.util.Iterator;
import exceptions.*;

public interface PositionList< E > extends Iterable< E > {
	/**
	 * Returns the number of elements in this list.
	 */
	public int size();
	
	/**
	 * Returns whether the list is empty/
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the first node in the list.
	 */
	public Position< E > first() throws EmptyListException;
	
	/**
	 * Returns the last node in the list.
	 */
	public Position< E > last();
	
	/**
	 * Returns the node after a given node in the list
	 */
	public Position< E > next( Position< E > p ) throws InvalidPositionException, BoundaryViolationException;

	/**
	 * Returns the node before a given node in the list
	 */
	public Position< E > prev( Position< E > p ) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * Inserts an element at the front of the list
	 */
	public void addFirst( E e );

	/**
	 * Inserts an element at the back of the list
	 */
	public void addLast( E e );
	
	/**
	 * Inserts an element after the given node in the list.
	 */
	public void addAfter( Position< E > p, E e ) throws InvalidPositionException;
	
	/**
	 * Inserts an element before the given node in the list.
	 */
	public void addBefore( Position< E > p, E e ) throws InvalidPositionException;
	
	/**
	 * Removes a node from the list, returning the element stored there.
	 */
	public E remove( Position< E > p ) throws InvalidPositionException;
	
	/**
	 * Replaces the element stored at the given node, returning the old element
	 */
	public E set( Position< E > p, E e ) throws InvalidPositionException;
	
	/**
	 * Return an iterator of all elements in the list.
	 */
	@Override
	public Iterator< E > iterator();

	/**
	 * Returns an iterable collection of all the nodes in the list
	 * 
	 * @return
	 * @throws EmptyListException 
	 * @throws BoundaryViolationException 
	 * @throws InvalidPositionException 
	 */
	public Iterable< Position< E > > positions() throws EmptyListException, InvalidPositionException, BoundaryViolationException;
}