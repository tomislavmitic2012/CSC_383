package node;

import exceptions.EmptyDequeException;
import interfaces.Deque;

public class NodeDeque< E > implements Deque< E > {
	private NodeDeque< E > self = this;
	
	protected DLNode< E > header, trailer;		// sentinels
	protected int size;							// number of elements
	
	public NodeDeque() {
		self.header = new DLNode< E >();		// make header point to trailer
		self.trailer = new DLNode< E >();		// make trailer point to header
		self.size = 0;
	}
	
	
	@Override
	public int size() {
		return self.size;
	}

	@Override
	public boolean isEmpty() {
		if ( self.size == 0 ) {
			return true;
		}
		return false;
	}

	@Override
	public E getFirst() throws EmptyDequeException {
		if ( self.isEmpty() ) {
			throw new EmptyDequeException( "NodeDeque Line 35: Deque is empty" );
		}
		return header.getNext().getElement();
	}

	@Override
	public E getLast() throws EmptyDequeException {
		if ( self.isEmpty() ) {
			throw new EmptyDequeException( "NodeDeque Line 44: Deque is empty" );
		}
		return self.trailer.getPrev().getElement();
	}

	@Override
	public void addFirst(E element) {
		DLNode< E > second = header.getNext();
		DLNode< E > first = new DLNode< E >( element, self.header, second );
		second.setPrev( first );
		self.header.setNext( first );
		self.size++;
	}

	@Override
	public void addLast(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E removeFirst() throws EmptyDequeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() throws EmptyDequeException {
		if ( self.isEmpty() ) {
			throw new EmptyDequeException( "NodeDeque Line 72: Deque is empty" );
		}
		DLNode< E > last = self.trailer.getPrev();
		E element = last.getElement();
		DLNode< E > secondtolast = last.getPrev();
		self.trailer.setPrev( secondtolast );
		secondtolast.setNext( self.trailer );
		self.size--;
		return element;
	}
	
}