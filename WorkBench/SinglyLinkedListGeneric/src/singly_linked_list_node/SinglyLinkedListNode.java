package singly_linked_list_node;

public class SinglyLinkedListNode< T > {
	private SinglyLinkedListNode< T > self = this;
	
	private T value;
	private SinglyLinkedListNode< T > next;
	
	public SinglyLinkedListNode( T value ) {
		self.setValue( value );
		self.setNext( null );
	}
	
	public void setValue( T newValue ) {
		self.value = newValue;
	}
	
	public void setNext( SinglyLinkedListNode< T > nextNode ) {
		self.next = nextNode;
	}
	
	public T getValue() {
		return self.value;
	}
	
	public SinglyLinkedListNode< T > getNext() {
		return self.next;
	}
}
