package linked_list;

import java.io.PrintStream;
import node.Node;

public class List {
	private static PrintStream output = new PrintStream( System.out );
	
	private List self = this;
	
	public Node head;
	public int size;
	
	public List() {
		self.head = null;
		self.size = 0;
	}
	
	public List( Node N ) {
		self.size = 1;
		self.head = new Node( N );
	}
	
	public List( List other ) {
		if ( other == null ) {
			self.head = null;
			self.size = 0;
		} else {
			self.size = other.size;
			self.head = Node.copy( other.head );
		}
	}
	
	public static List build( int[] A ) {
		if ( A.length == 0 ) return null;
		
		int n = A.length - 1;
		Node tmp = new Node( A[ n ] );
		List list = new List( tmp );
		for ( int i = n - 1; i >= 0; i-- ) {
			tmp = new Node( A[ i ] );
			list.addFront( tmp );
		}
		
		list.size = n + 1;
		return list;
	}
	
	public void addFront( Node N ) {
		if ( N == null ) return;
		
		Node temp = new Node( N.data );
		temp.next = head;
		head = temp;
	}
	
	public void print() {
		Node tmp = head;
		
		while ( tmp != null ) {
			List.output.print( tmp.data + " " );
			tmp = tmp.next;
		}
		List.output.println( "\n" );
	}
	
	public void reverse() {
		self.head = self.reverse( head );
	}
	
	public Node reverse( Node N ) {
		if ( N == null || N.next == null ) return N;
		Node tmp = self.reverse( N.next );
		Node last = tmp;
		
		while ( last.next != null ) last = last.next;
		
		last.next = new Node( N.data );
		
		return tmp;
	}
	
	public void reverse2() {
		self.head = self.reverse( head );
	}
	
	public Node reverse2( Node N ) {
		if ( N == null || N.next == null ) return N;
	
		Node pre = null;
		Node cur = N;
		Node next = N.next;
		
		while( next != null ) {
			cur.next = pre;
			pre = cur;
			cur = next;
			next = next.next;
		}
		cur.next = pre;
		
		N = cur;
		return cur;
	}
	
	public static int count( Node N ) {
		if ( N == null ) return 0;
		return 1 + count( N.next );
	}
	
	public static int count( List list ) {
		if ( list == null ) return 0;
		return count( list.head );
	}
}