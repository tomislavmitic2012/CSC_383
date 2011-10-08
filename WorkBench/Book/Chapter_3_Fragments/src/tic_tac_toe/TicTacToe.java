package tic_tac_toe;

import java.io.PrintStream;

/**
 * Simulation of a Tic-Tac-Toe game (does not do strategy).
 * @author tmitic
 *
 */
public class TicTacToe {
	public static final PrintStream output = new PrintStream( System.out );
	private TicTacToe self = this;
	
	protected static final int X = 1, O = -1;			// players
	protected static final int EMPTY = 0;				// empty cell
	protected int[][] board = new int[ 3 ][ 3 ];		// game board
	protected int player;
		
	/**
	 * Constructor
	 */
	public TicTacToe() {
		clearBoard();
	}

	/**
	 * Clears the board
	 */
	public void clearBoard() {
		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 0; j < 3; j++ ) {
				self.board[ i ][ j ] = TicTacToe.EMPTY;		// every cell should be empty
			}
		}
		self.player = TicTacToe.X;							// the first player is 'X'
	}
		
	/**
	 * Puts an X or O mark at position i, j
	 */
	public void putMark( int i, int j ) throws IllegalArgumentException {
		if ( ( i < 0 ) || ( i > 2 ) || ( j < 0 ) || ( j > 2 ) ) {
			throw new IllegalArgumentException( "Invalid board position" );
		}
	
		if ( self.board[ i ][ j ] != TicTacToe.EMPTY ) {
			throw new IllegalArgumentException( "Board position occupied" );
		}
		
		self.board[ i ][ j ] = self.player;						// place the mark for the current player
		self.player = - self.player;							// switch players (uses fact that O = -X)
	}
	
	/**
	 * Checks whether the board configuration is a win for the given player
	 */
	public boolean isWin( int mark ) {
		return ( ( self.board[ 0 ][ 0 ] + self.board[ 0 ][ 1 ] + self.board[ 0 ][ 2 ] == mark * 3 ) ||		// row 0
				 ( self.board[ 1 ][ 0 ] + self.board[ 1 ][ 1 ] + self.board[ 1 ][ 2 ] == mark * 3 ) ||		// row 1
				 ( self.board[ 2 ][ 0 ] + self.board[ 2 ][ 1 ] + self.board[ 2 ][ 2 ] == mark * 3 ) ||		// row 2
				 ( self.board[ 0 ][ 0 ] + self.board[ 1 ][ 0 ] + self.board[ 2 ][ 0 ] == mark * 3 ) ||		// column 0
				 ( self.board[ 0 ][ 1 ] + self.board[ 1 ][ 1 ] + self.board[ 2 ][ 1 ] == mark * 3 ) ||		// column 1
				 ( self.board[ 0 ][ 2 ] + self.board[ 1 ][ 2 ] + self.board[ 2 ][ 2 ] == mark * 3 ) ||		// column 2
				 ( self.board[ 0 ][ 0 ] + self.board[ 1 ][ 1 ] + self.board[ 2 ][ 2 ] == mark * 3 ) ||		// diagonal
				 ( self.board[ 2 ][ 0 ] + self.board[ 1 ][ 1 ] + self.board[ 0 ][ 2 ] == mark * 3 ) );		// diagonal				 
	}
	
	/**
	 * Returns the winning player or 0 to indicate a tie
	 */
	public int winner() {
		if ( self.isWin( TicTacToe.X ) ) {
			return ( TicTacToe.X );
		} else if ( self.isWin( TicTacToe.O ) ) {
			return ( TicTacToe.O );
		} else {
			return ( 0 );
		}
	}
	
	/**
	 * Returns a simple character string showing the current board
	 */
	@Override
	public String toString() {
		String s = "";
		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 0; j < 3; j++ ) {
				switch ( self.board[ i ][ j ] ) {
				case TicTacToe.X: s += "X"; break;
				case TicTacToe.O: s += "O"; break;
				case TicTacToe.EMPTY: s += " "; break;
				}
				if ( j < 2 ) {
					s += "|";										// column boundary
				}
			}
			if ( i < 2 ) {
				s += "\n-----\n";									// row boundary
			}
		}
		return s;
	}
	
	/**
	 * Test run of a simple game
	 */
	public static void main( String[] args ) {
		TicTacToe game = new TicTacToe();
		
		/* X moves: */				/* O moves: */
		game.putMark( 1, 1 );		game.putMark( 0, 2 );
		game.putMark( 2, 2 );		game.putMark( 0, 0 );
		game.putMark( 0, 1 );		game.putMark( 2, 1 );
		game.putMark( 1, 2 );		game.putMark( 1, 0 );
		game.putMark( 2, 0 );
		
		TicTacToe.output.println( game.toString() );
		int winningPlayer = game.winner();
		if ( winningPlayer != 0 ) {
			TicTacToe.output.println( winningPlayer + " wins" );
		} else {
			TicTacToe.output.println( "Tie" );
		}
	}
}