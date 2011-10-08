package queue;

import java.util.LinkedList;

public class Queue< T > {
	private Queue< T > self = this;
	
	private LinkedList< T > items = new LinkedList< T >();
	
	public void enqueue( T item ) {
		self.items.addLast( item );
	}
	
	public T dequeue() {
		return self.items.removeFirst();
	}
	
	public boolean isEmpty() {
		return ( self.items.size() == 0 );
	}
	
	public static < T > int countOccurences( T[] list, T itemToCount ) {
		int count = 0;
		if( itemToCount == null ) {
			for( T listItem : list ) {
				if( listItem == null ) {
					count++;
				}
			}
		} else {
			for( T listItem : list ) {
				if( itemToCount.equals( listItem ) ) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static < T > int countOccurences( Queue< T > list, T itemToCount ) {
		int count = 0;
		if( itemToCount == null ) {
			for( T listItem : list.items ) {
				if( listItem == null ) {
					count++;
				}
			}
		} else {
			for( T listItem : list.items ) {
				if( itemToCount.equals( listItem ) ) {
					count++;
				}
			}
		}
		return count;
	}
}