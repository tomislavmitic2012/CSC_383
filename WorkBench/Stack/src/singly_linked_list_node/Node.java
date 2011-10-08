package singly_linked_list_node;

public class Node< T > {
	private Node< T > self = this;
	
	private T value;
	private Node< T > next;
	
	public Node() {
		self.setValue( null );
		self.setNext( null );
	}
	
	public Node( T value ) {
		self.setValue( value );
		self.setNext( null );
	}
	
	public void setValue( T newValue ) {
		self.value = newValue;
	}
	
	public void setNext( Node< T > nextNode ) {
		self.next = nextNode;
	}
	
	public T getValue() {
		return self.value;
	}
	
	public Node< T > getNext() {
		return self.next;
	}
}
