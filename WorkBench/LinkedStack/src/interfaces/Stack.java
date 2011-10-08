package interfaces;

import Exceptions.EmptyStackException;

public interface Stack< E > {
	public int size();
	public boolean isEmpty();
	public void push( E element );
	public E top() throws EmptyStackException;
	public E pop() throws EmptyStackException;
}