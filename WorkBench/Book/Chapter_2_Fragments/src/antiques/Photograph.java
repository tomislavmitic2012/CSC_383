package antiques;

/**
 * Class for photographs that can be sold.
 * 
 * @author Tomislav S. Mitic
 *
 */
public class Photograph implements Sellable {
	private Photograph self = this;
	
	private String descript;	// description of this photo
	private int price;			// the price we are setting
	private boolean color;		// true is photo is in color
	
	public Photograph( String desc, int p, boolean c ) {
		self.descript = desc;
		self.price = p;
		self.color = c;
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
	
	public boolean isColor() {
		return self.color;
	}
}
