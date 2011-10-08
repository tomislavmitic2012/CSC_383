import pair.Pair;
import singly_linked_list.SinglyLinkedList;
import singly_linked_list_node.SinglyLinkedListNode;

public class Test {
	@SuppressWarnings("rawtypes")
	public static void main( String[] args ) {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		Integer[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		SinglyLinkedList< Pair > myList = new SinglyLinkedList< Pair >();
		
		for( int i = 0; i < 12; i++ ) {
			Pair< String, Integer > temp = new Pair< String, Integer >( months[ i ], days[ i ] );
			//myList.addFirst( new SinglyLinkedListNode< Pair >( temp ) );
			myList.addLast( new SinglyLinkedListNode< Pair >( temp ) );
		}
		
		myList.traverse();
		
		while( !myList.isEmpty() ) {
			myList.removeLast();
			myList.traverse();
		}
	}
}