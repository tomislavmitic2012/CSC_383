package stack;

import singly_linked_list_node.Node;

public class Stack< T > {
	private Stack< T > self = this;
	
	private Node< T > top;		// Pointer to the Node that is at the top of
								// the stack. If top == null, then the
								// stack is empty
	
	/**
	 * Add N to the top of the stack.
	 */
	public void push( T N ) {
		Node< T > newTop = new Node< T >();		// A Node to hold the new item.
		newTop.setValue( N );					// Store N in the new node.
		newTop.setNext( self.top );				// The new Node points to the old top
		self.top = newTop;						// The new item is now on top.
	}
	
	/**
	 * Peek at the top item from the stack, but don't return it.
	 * Throws an IllegalStateException if the stack is empty when
	 * this method is called
	 */
	public T peek() {
		if( self.top == null ) {
			throw new IllegalStateException( "Can't peek from an empty stack." );
		}
		return self.top.getValue();
	}
	
	/**
	 * Remove the top item from the stack, and return it.
	 * Throws an IllegalStateException if the stack is empty when
	 * this method is called
	 */
	public T pop() {
		if( self.top == null ) {
			throw new IllegalStateException( "Can't peek from an empty stack." );
		}
		T topItem = self.top.getValue();		// The item that is being popped.
		self.top = self.top.getNext();			// The previous second item is now on top
		return topItem;
	}
	
	/**
	 * Returns true if the stack is empty. Returns false
	 * if there are one or more items on the stack.
	 */
	public boolean isEmpty() {
		return ( self.top == null );
	}
}