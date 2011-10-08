package interfaces;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

public interface Stack< E > {
	public int size();
	public boolean isEmpty();
	public void push( E element ) throws FullStackException;
	public E top() throws EmptyStackException;
	public E pop() throws EmptyStackException;
}