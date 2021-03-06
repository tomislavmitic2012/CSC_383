package array_index_list;

import interfaces.IndexList;

/**
 * Realization of an indexed list by means of an array, which is doubled
 * when the size of the indexed list exceeds the capacity of the array.
 * 
 * @author Tomislav S. Mitic
 *
 * @param <E>
 */
public class ArrayIndexList< E > implements IndexList< E > {
	private ArrayIndexList< E > self = this;
	
	private E[] A;						// array storing the elements of the indexed list
	private int capacity = 16;			// initial length of array A
	private int size = 0;				// number of elements stored in the indexed list
	
	/**
	 * Creates the indexed list with initial capacity 16.
	 */
	@SuppressWarnings("unchecked")
	public ArrayIndexList() {
		self.A = ( E[] ) new Object[ self.capacity ];					// compiler may warn but this is okay
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int r, E e) throws IndexOutOfBoundsException {
		self.checkIndex(r, self.size() + 1 );
		if (self.size == self.capacity ) {								// an overflow
			self.capacity *= 2;
			E[] B = ( E[] ) new Object[ self.capacity ];
			for ( int i = 0; i < size; i++ ) {
				B[ i ] = self.A[ i ];
			}
			self.A = B;
		}
		for ( int i = self.size - 1; i >= r; i-- ) {					// shift elements up
			self.A[ i + 1 ] = self.A[ i ];
		}
		self.A[ r ] = e;
		self.size++;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove( int r ) throws IndexOutOfBoundsException {
		self.checkIndex( r, self.size() );
		E temp = self.A[ r ];
		for ( int i = r, max = self.size -1; i < max; i++ ) {
			self.A[ i ] = self.A[ i + 1 ];
		}
		self.size--;
		return temp;
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void checkIndex(int r, int s ) {
		// TODO implement checkIndex
	}
}