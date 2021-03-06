package array_stack;

import java.io.PrintStream;
import Exceptions.EmptyStackException;
import Exceptions.FullStackException;
import interfaces.Stack;

/**
 * Implementation of the stack ADT using a fixed length array. An
 * exception is thrown if a push  operation is attempted when the size
 * of the stack is is equal to the length of the array. This class 
 * includes the main methods of the built-in class java.util.Stack.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class ArrayStack< E > implements Stack< E > {
	private ArrayStack< E > self = this;
	
	public static final PrintStream output = new PrintStream( System.out );
	
	protected int capacity;								// the actual capacity of the stack array
	public static final int CAPACITY = 1000;			// default array capacity
	protected E S[];									// Generic array used to implement the stack
	protected int top = -1;								// index for the top of the stack
	
	public ArrayStack() {
		this(ArrayStack.CAPACITY);						// default capacity
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack( int cap ) {
		self.capacity = cap;
		self.S = ( E[] ) new Object[ self.capacity ];		// compiler may give warning but this is okay
	}
	
	public int size() {
		return ( self.top + 1 );
	}
	
	public boolean isEmpty() {
		return ( self.top < 0 );
	}
	
	public void push( E element ) throws FullStackException {
		if ( self.size() == capacity ) {
			throw new FullStackException( "ArrayStack Line 38: Stack is full." );
		}
		self.S[ ++self.top ] = element;
	}
	
	public E top() throws EmptyStackException {
		if ( self.isEmpty() ) {
			throw new EmptyStackException( "ArrayStack Line 50: Stack is empty." );
		}
		return self.S[ self.top ];
	}
	
	public E pop() throws EmptyStackException {
		E element;
		if ( self.isEmpty() ) {
			throw new EmptyStackException( "ArrayStack Line 58: Stack is empty." );
		}
		element = self.S[ self.top ];
		self.S[ self.top-- ] = null;						// dereference S[top] for garbage collection
		return element;
	}
	
	@Override
	public String toString() {
		String s;
		s = "[ ";
		if ( self.size() > 0 ) {
			s += self.S[ 0 ];
		}
		if ( self.size() > 1 ) {
			for( int i = 1, max = self.size() - 1; i <= max; i++ ) {
				s += ", " + self.S[ i ];
			}
		}
		return s + " ]";
	}
	
	/**
	 * Prints status information about a recent operation and the stack.
	 */
	public void status( String op, Object element ) {
		ArrayStack.output.print( "------> " + op);				// print this operation
		ArrayStack.output.println( ", returns " + element );	// what was returned
		ArrayStack.output.print( "result: size = " + self.size() + ", isEmpty = " + self.isEmpty() );
		ArrayStack.output.println( ", stack: " + self );		// contents of the stack
	}
}