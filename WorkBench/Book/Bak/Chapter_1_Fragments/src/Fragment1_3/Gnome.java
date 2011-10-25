package Fragment1_3;

public class Gnome {
	private Gnome self = this;
	
	// Instance variables:
	public String name;
	public int age;
	public Gnome gnomeBuddy;
	private boolean magical = false;
	protected double height = 2.6;
	public static final int MAX_HEIGHT = 3;	// maximum height
	
	// Constructors
	Gnome( String nm, int ag, Gnome bud, double hgt ) {	// fully parameterized
		self.name = nm;
		self.age = ag;
		self.gnomeBuddy = bud;
		self.height = hgt;
	}
	
	Gnome() {	// Default constructor
		self.name = "Rumple";
		self.age = 204;
		self.gnomeBuddy = null;
		self.height = 2.1;
	}
	
	public static void makeKing( Gnome h ) {
		h.name = "King " + h.getRealName();
		h.magical = true;	// Only the Gnome class can reference this field.
	}
	
	public void makeMeKing() {
		self.name = "King " + getRealName();
		self.magical = true;
	}
	
	public boolean isMagical() {
		return self.magical;
	}
	
	public void setHeight( int newHeight ) {
		self.height = newHeight;
	}
	
	public String getName() {
		return "I won't tell!";
	}
	
	public String getRealName() {
		return name;
	}
	
	public void renameGnome( String s ) {
		self.name = s;
	}
}
