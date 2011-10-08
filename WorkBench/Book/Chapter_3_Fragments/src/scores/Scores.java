package scores;

import game_entry.GameEntry;

public class Scores {
	private Scores self = this;
	
	public static final int maxEntries = 10;	// number of high scores we keep
	protected int numEntries;					// number of actual entries
	protected GameEntry[] entries;				// array of game entries (names & scores)
	
	/**
	 * Default constructor
	 */
	public Scores() {
		self.entries = new GameEntry[ Scores.maxEntries ];
		self.numEntries = 0;
	}
	
	/**
	 * Returns a string representation of the high scores list
	 */
	@Override
	public String toString() {
		String s = "[ ";
		for( int  i = 0; i < self.numEntries; i++ ) {
			if ( i > 0 ) {
				s += ", ";						// separate entries with commas
			}
			s += self.entries[ i ];
		}
		return s + " ]";
	}
	
	// .. methods for updating the set of high scores goes here ...
	
	/**
	 * Attempt to add a new  score to the collection (if it is high enough)
	 */
	public void add( GameEntry e ) {
		int newScore = e.getScore();
		
		// is the entry e really a high score?
		if ( self.numEntries == Scores.maxEntries ) { // array is full
			if ( newScore <= self.entries[ self.numEntries -1 ].getScore() ) {
				return;		// the new entry, e, is not a high score in this case
			} else {	// the array is not full
				self.numEntries++;
				
				// Locate the place that the new (high score) entry e belongs
				int i = self.numEntries - 1;
				for(; ( i >= 1 ) && ( newScore > self.entries[ i - 1 ].getScore() ); i-- ) {
					self.entries[ i ] = entries[ i - 1 ];	// move entry i one to the right
				}
				self.entries[ i ] = e;	// add the new score to entries
			}
		}
	}
	
	/**
	 * Remove and return the high score at index i
	 */
	public GameEntry remove( int i ) throws IndexOutOfBoundsException {
		if( ( i < 0 ) || ( i >= numEntries ) ) {
			throw new IndexOutOfBoundsException( "Invalid index: " + i );
		}
		
		GameEntry temp = self.entries[ i ];		// temporarily save the object to be removed
		for( int j = i; j < self.numEntries - 1; j++ ) {	// count up from i (not down)
			self.entries[ j ] = self.entries[ j + 1 ];		// move one cell to the left
		}
		self.entries[ self.numEntries - 1 ] = null;			// null out the old last score
		self.numEntries--;
		return temp;
	}
}