package singly_linked_list;

import singly_linked_list_node.SinglyLinkedListNode;

public class SinglyLinkedList {
	private SinglyLinkedList self = this;
	
	private SinglyLinkedListNode head;
	private SinglyLinkedListNode tail;
	
	public SinglyLinkedList() {
		self.head = null;
		self.tail = null;
	}
	
	public int traverse() {
		int sum = 0;
		SinglyLinkedListNode current = head;
		
		while( current != null ) {
			sum += current.getValue();
			current = current.getNext();
		}
		return sum;
	}
	
	public void addLast( SinglyLinkedListNode newNode ) {
		if ( newNode == null ) {
			return;
		} else {
			newNode.setNext( null );
			
			if ( self.head == null ) {
				self.head = newNode;
				self.tail = newNode;
			} else {
				self.tail.setNext( newNode );
				self.tail = newNode;
			}
		}
	}
	
	public void addFirst( SinglyLinkedListNode newNode ) {
		if ( newNode == null ) {
			return;
		} else {
			if ( self.head == null ) {
				newNode.setNext( null );
				self.head = newNode;
				self.tail = newNode;
			} else {
				newNode.setNext( self.head );
				self.head = newNode;
			}
		}
	}
	
	public void insertAfter( SinglyLinkedListNode previous, 
			SinglyLinkedListNode newNode ) {
		if ( newNode == null ) {
			return;
		} else {
			if ( previous == null ) {
				self.addFirst( newNode );
			} else if ( previous == self.tail ) {
				self.addLast( newNode );
			} else {
				SinglyLinkedListNode next = previous.getNext();
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
			SinglyLinkedListNode previousToTail = self.head;
			while( previousToTail.getNext() != self.tail ) {
				previousToTail = previousToTail.getNext();
			}
			self.tail = previousToTail;
			self.tail.setNext( null );
		}
	}
	
	public void removeNext( SinglyLinkedListNode previous ) {
		if ( previous == null ) {
			self.removeFirst();
		} else if ( previous.getNext() == self.tail ) {
			// previous is 2nd to last
			self.tail = previous;
			self.tail.setNext( null );
		} else if ( previous == self.tail ) {
			return;
		} else {
			// General case
			previous.setNext( previous.getNext().getNext() );
		}
	}
}