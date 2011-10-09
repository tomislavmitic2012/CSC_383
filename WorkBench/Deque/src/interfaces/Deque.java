package interfaces;

import exceptions.EmptyDequeException;

/**
 *  Interface for a deque: a collection of objects that are inserted
 *  and removed at both ends ; a subset of java.util.LinkedList methods.
 *  
 * @author Tomislav S. Mitic
 *
 * @param <E>
 */

public interface Deque< E > {
	/**
	 * Returns the number of elements in the deque.
	 */
	public int size();
	
	/**
	 * Returns whether the deque is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the first element; an exception is thrown if deque is empty.
	 */
	public E getFirst() throws EmptyDequeException;
	
	/**
	 * Returns the last element; an exception is thrown if the deque is empty.
	 */
	public E getLast() throws EmptyDequeException;
	
	/**
	 * Inserts an element to be the first in the deque
	 */
	public void addFirst( E element );
	
	/**
	 * Inserts an element to be last in the deque
	 */
	public void addLast( E element );
	
	/**
	 * Removes the first element; an exception is thrown if deque is empty.
	 */
	public E removeFirst() throws EmptyDequeException;
	
	/**
	 * Removes the last element; an exception is thrown if deque is empty.
	 */
	public E removeLast() throws EmptyDequeException;
}