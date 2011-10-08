package singly_linked_list;

import java.io.PrintStream;
import singly_linked_list_node.SinglyLinkedListNode;

public class SinglyLinkedList< T > {
	private static final PrintStream output = new PrintStream( System.out );
	private SinglyLinkedList< T > self = this;
	
	private SinglyLinkedListNode< T > head;
	private SinglyLinkedListNode< T > tail;
	
	public boolean isEmpty() {
		return (self.head == null );
	}
	
	public SinglyLinkedList() {
		self.head = null;
		self.tail = null;
	}
	
	public void traverse() {
		SinglyLinkedListNode< T > current = self.head;
		
		while( current != null ) {
			output.println( current.getValue() );
			current = current.getNext();
		}
		output.println( "Done!\n\n" );
	}
	
	public void addLast( SinglyLinkedListNode< T > newNode ) {
		if ( newNode == null ) {
			return;
		} else {
			newNode.setNext( null );
			if ( self.head == null ) {
				// list was initially empty
				self.head = newNode;
				self.tail = newNode;
			} else {
				// the general case
				self.tail.setNext( newNode );
				self.tail = newNode;
			}
		}
	}
	
	public void addFirst( SinglyLinkedListNode< T > newNode ) {
		if ( newNode == null ) {
			return;
		} else {
			if ( self.head == null ) {
				// list initially empty
				newNode.setNext( null );
				self.head = newNode;
				self.tail = newNode;
			} else {
				// general case
				newNode.setNext( self.head );
				self.head = newNode;
			}
		}
	}

	public void insertAfter( SinglyLinkedListNode< T > previous, SinglyLinkedListNode< T > newNode ) {
		if ( newNode == null ) {
			return;
		} else {
			if ( previous == null ) {
				// list initially empty
				self.addFirst( newNode );
			} else if ( previous == self.tail ) {
				// inserting at the end of the list
				self.addLast( newNode );
			} else {
				// general case
				SinglyLinkedListNode< T > next = previous.getNext();
				previous.setNext( newNode );
				newNode.setNext( next );
			}
		}
	}
	
	public void removeFirst() {
		if ( self.head == null ) {
			return;
		} else {
			if ( self.head == self.tail ) {
				self.head = null;
				self.tail = null;
			} else {
				self.head.setNext( self.head.getNext() );
			}
		}
	}
	
	public void removeLast() {
		if ( self.tail == null ) {
			return;
		} else {
			if ( self.head == self.tail ) {
				self.head = null;
				self.tail = null;
			} else {
				SinglyLinkedListNode< T > previousToTail = self.head;
				while( previousToTail.getNext() != self.tail ) {			/* This takes a lot of computation, if a lot of nodes in  the list? */
					previousToTail = previousToTail.getNext();
				}
				self.tail = previousToTail;
				self.tail.setNext( null );
			}
		}
	}
	
	public void removeNext( SinglyLinkedListNode< T > previous ) {
		if ( previous == null ) {
			self.removeFirst();
		} else if ( previous.getNext() == tail ) {
			// previous is 2nd to last element, you are removing the tail
			self.tail = previous;
			self.tail.setNext( null );
		} else if ( previous == self.tail ) {
			// there is no next to remove in this case
			return;
		} else {
			// the general case set previous to the node after the next node
			previous.setNext( previous.getNext().getNext() );
		}
	}
}