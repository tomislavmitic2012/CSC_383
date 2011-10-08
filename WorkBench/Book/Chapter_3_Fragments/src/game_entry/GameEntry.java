package game_entry;

public class GameEntry {
	private GameEntry self = this;
	
	protected String name;	// name of the person earning this score
	protected int score;	// the score value
	
	/**
	 * Constructor to create a game entry
	 */
	public GameEntry( String n, int s ) {
		self.name = n;
		self.score = s;
	}
	
	/**
	 * Retrieves the name field
	 */
	public String getName() {
		return self.name;
	}
	
	/**
	 * Retrieves the score field
	 */
	public int getScore() {
		return self.score;
	}
	
	/**
	 * Returns a string representation of this entry
	 */
	@Override
	public String toString() {
		return String.format( "( %s, %s )", self.name, self.score );
	}
}