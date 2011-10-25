package antiques;

/**
 * Class for objects that can be sold, packed and shipped
 * 
 * @author Tomislav S. Mitic
 *
 */
public class BoxedItem implements Sellable, Transportable {
	private BoxedItem self = this;
	
	private String descript;	// description of this item
	private int price;			// list price in cents
	private int weight;			// weight in grams
	private boolean haz;		// true if object is hazardous
	private int height = 0;		// box height in centimeters
	private int width = 0;		// box width in centimeters
	private int depth = 0;		// box depth in centimeters
	
	/**
	 * Constructor
	 */
	public BoxedItem( String desc, int p, int w, boolean h ) {
		self.descript = desc;
		self.price = p;
		self.weight = w;
		self.haz = h;
	}
	
	public String description() {
		return self.descript;
	}
	
	public int listPrice() {
		return self.price;
	}
	
	public int lowestPrice() {
		return self.price / 2;
	}
	
	public int weight() {
		return self.weight;
	}
	
	public boolean isHazardous() {
		return self.haz;
	}
	
	public int insuredValue() {
		return self.price * 2;
	}
	
	public void setBox( int h, int w, int d ) {
		self.height = h;
		self.width = w;
		self.depth = d;
	}
}
