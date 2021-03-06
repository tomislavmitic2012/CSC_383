package array_queue;

import java.io.PrintStream;
import exceptions.EmptyQueueException;
import exceptions.FullQueueException;
import interfaces.Queue;

public class ArrayQueue < E > implements Queue< E > {
	private ArrayQueue< E > self = this;
	
	public static final PrintStream output = new PrintStream( System.out );

	protected int capacity;								// the actual capacity of the stack array
	public static final int CAPACITY = 1000;			// default array capacity
	protected E Q[];									// Generic array used to implement the queue
	protected int front = 0;							// index for the front of the stack
	protected int rear = 0;								// index for the rear of the stack
	
	public ArrayQueue() {
		this( ArrayQueue.CAPACITY );
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue( int cap ) {
		self.capacity = cap;
		self.Q = ( E[] ) new Object[ self.capacity ];		// compiler may give warning but this is okay
	}

	@Override
	public int size() {
		return ( self.capacity - self.front + self.rear );
	}
	
	@Override
	public boolean isEmpty() {
		return ( self.front == self.rear );
	}

	@Override
	public E front() throws EmptyQueueException {
		if ( self.isEmpty() ) {
			throw new EmptyQueueException( "ArrayQueue Line 39: The queue is empty" );
		}
		
		return self.Q[ self.front ];
	}

	@Override
	public void enqueue(E element) throws FullQueueException {
		if ( self.size() == self.capacity -1 ) {
			throw new FullQueueException( "ArrayQueue Line 51: The queue is full" );
		}
		
		self.Q[ self.rear ] = element;
		self.rear = ( self.rear + 1 ) % self.capacity;
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if ( self.isEmpty() ) {
			throw new EmptyQueueException( "ArrayQueue Line 61: The queue is empty" );
		}
		
		E temp = self.Q[ self.front ];
		self.Q[ self.front ] = null;						// prepare array index for garbage collection
		self.front = ( self.front + 1 ) % self.capacity;
		return temp;
	}
}