package node_stack;

import java.io.PrintStream;
import Exceptions.EmptyStackException;
import node.Node;
import interfaces.Stack;

public class NodeStack< E > implements Stack< E > {
	private static final PrintStream output = new PrintStream( System.out );
	private NodeStack< E > self = this;
	
	protected Node< E > top;								// reference to the head node
	protected int size;										// number of elements in the stack
	
	public NodeStack() {									// constructs an empty stack
		self.top = null;
		self.size = 0;
	}
	
	public int size() {
		return self.size;
	}
	
	public boolean isEmpty() {
		if ( self.top == null ) {
			return true;
		}
		return false;
	}
	
	public void push( E elem ) {
		Node< E > v = new Node< E >( elem, self.top );			// create and link-in a new node
		self.top = v;
		self.size++;
	}
	
	public E top() throws EmptyStackException {
		if ( self.isEmpty() ) throw new EmptyStackException( "NodeStack Line 38: Stack is empty.");
		return self.top.getElement();
	}
	
	public E pop() throws EmptyStackException {
		if ( self.isEmpty() ) throw new EmptyStackException( "NodeStack Line 43: Stack is empty.");
		E temp = self.top.getElement();
		self.top = self.top.getNext();							// link-out the former top node
		self.size--;
		return temp;
	}
	
	@Override
	public String toString() {
		String s;
		String[] arr = new String[ self.size ];
		s = "[ ";
		Node< E > temp = self.top;
		if ( self.size() > 0 ) {
			arr[ 0 ] = "" + temp.getElement();
		}
		if ( self.size() > 1 ) {
			for( int i = 1, max = self.size() - 1; i <= max; i++ ) {
				temp = temp.getNext();
				arr[ i ]= temp.getElement() + ", ";
			}
		}
		for( int i = arr.length - 1; i >= 0; i-- ) {
			s += arr[ i ];
		}
		return s + " ]";
	}
	
	/**
	 * Prints status information about a recent operation and the stack.
	 */
	public void status( String op, Object element ) {
		NodeStack.output.print( "------> " + op);				// print this operation
		NodeStack.output.println( ", returns " + element );	// what was returned
		NodeStack.output.print( "result: size = " + self.size() + ", isEmpty = " + self.isEmpty() );
		NodeStack.output.println( ", stack: " + self );		// contents of the stack
	}
}