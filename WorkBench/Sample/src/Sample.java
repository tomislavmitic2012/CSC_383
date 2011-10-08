public class Sample< T > {
	private Sample< T > self = this;
	
	private T data;
	
	public void setData( T newData ) {
		self.data = newData;
	}
	
	public T getData() {
		return self.data;
	}
}