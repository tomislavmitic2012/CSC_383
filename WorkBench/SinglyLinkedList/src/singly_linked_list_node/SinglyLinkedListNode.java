package singly_linked_list_node;

public class SinglyLinkedListNode {
	private SinglyLinkedListNode self = this;
	
	private int value;
	private SinglyLinkedListNode next;
	
	public SinglyLinkedListNode( int newValue ) {
		self.setValue( newValue );
		self.setNext( null );
	}
	
	public void setValue( int newValue ) {
		self.value = newValue;
	}
	
	public void setNext( SinglyLinkedListNode newNext ) {
		self.next = newNext;
	}
	
	public int getValue() {
		return self.value;
	}
	
	public SinglyLinkedListNode getNext() {
		return self.next;
	}
}
