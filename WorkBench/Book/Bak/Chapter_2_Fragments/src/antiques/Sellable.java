package antiques;

/**
 * Interface for objects that can be sold.
 * 
 * @author Tomislav S. Mitic
 *
 */
public interface Sellable {
	/**
	 * description of the object
	 */
	public String description();
	
	/**
	 * list price in cents
	 */
	public int listPrice();
	
	/**
	 * lowest price in cents we will accept
	 */
	public int lowestPrice();
}
