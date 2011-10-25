package antiques;

/**
 * Interface for objects that can be transported
 * 
 * @author Tomislav S. Mitic
 *
 */
public interface Transportable {
	/**
	 * weight in grams
	 */
	public int weight();
	
	/**
	 * whether the object is hazardous
	 */
	public boolean isHazardous();
}
