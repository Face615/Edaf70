package model;


import java.io.BufferedReader;
import AI.AI;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by pmunoz on 01/04/14. Updated by zwodnik on 09/05/14. Updated by
 * aeap and jgeorge on 14/05/14.
 */

public class Othello {

	private Board board = new Board(); // creates the board
	private Player[] players = new Player[2]; // array of players for two
												// players
	private Turn turn; // creates a turn
	private AI ai;
	private int cnt;
	
	public Othello() {
		this.ai = new AI(3);
	}
	

	/**
	 * Driver method for the program. Starts the game.
	 */
	public static void main(String[] args) throws IOException {
		new Othello().startGame();
	}

	/**
	 * Starts the game and initializes it with: the first player, a chosen turn
	 * and the board.
	 * 
	 * @throws IOException
	 */
	public void startGame() throws IOException /* the game starts */{
		
		System.out.print("Othello AI 2000");
		int who = this.initPlayers(); // initializes the first player
		this.turn = new Turn((who + 1) % 2); // initializes the turn
		
		if(cnt==1){
			ai.setAiColor(1);
		}
		
		for (int i = 0; i < 2; i++) { // prompts both the players for their
										// names
			System.out.print("Player" + (i + 1) + " ");
			players[i].setNames();
		}

		System.out.println(players[0].getName() + " moves"); // indicates who
																// has to play,
																// starting with
																// the player
																// whose turn it
																// is
		this.players[turn.getTurn()].findCanSelect(); // finds the possible
														// moves for the player
														// playing
		board.display(); // displays board

		while (!board.gameOver()) { // when not GameOver, find the possible
									// moves from the player


			int count = 0; // count of possible moves
			for (int j = 0; j < Board.NUM; j++)
				// search the entire board
				for (int i = 0; i < Board.NUM; i++)
					if (board.findLegalMoveNew(new Move(i, j), turn.getTurn()) == true) {
						count++; // add a possible move to the count
					}

			if (count == 0) { // when no possible moves
				turn.change(); // change the turn to the other player
				board.display(); // display the updated board
				count = 0; // reset count to 0
			}

			else {
				int row = 0; // prompts the player for the row
				// wanted
				int col = 0; // pro
			//	System.out.print("vems tur: "+ turn.getTurn() +"\n");
			if(turn.getTurn()==1 || (turn.getTurn()==0 && cnt==1)) {

				row = this.readRow(); // prompts the player for the row
				// wanted
				col = this.readCol(); // prompts the player for the column
				cnt--;
				// wanted
			}else { // AI clause
				Board b = board.copyBoard();
				Move m = ai.minimax(b);
			//	System.out.print("Valbaradrag f�r b.validMove"+ b.validMove(0));
			//	Random r = new Random();
			//	row = r.nextInt(7);
				// wanted
			//	col =r.nextInt(7);
				row = m.getRow();
				col=m.getCol();
				System.out.print("row: "+ row+ "col: "+ col+"\n");
			}
		
				Move move = new Move(row, col); // creates a new move
				if (board.canSelect(move)) { // if move valid
					this.players[turn.getTurn()].placeChip(row, col); // place
																		// the
																		// chip
					turn.change(); // change the turn to the other player
				}

				this.players[turn.getTurn()].findCanSelect(); // find the
																// possible
																// moves at the
																// location
				board.display(); // display updated board with possible moves
				System.out
						.println(players[turn.getTurn()].getName() + " moves"); // indicates
																				// who
																				// has
																				// to
																				// play

			}
		}
	}

	/**
	 * Creates two players.
	 * 
	 * @return 1 if black starts and 0 if white starts
	 */
	private int initPlayers() {
		Turn aux = new Turn(); // temporary turn

		this.players[0] = new Player("name 1", aux.getTurn(), this.board); // player
																			// 1
		aux.change(); // changes to player 2
		this.players[1] = new Player("name 2", aux.getTurn(), this.board); // player
																			// 2

		if (aux.getTurn() == 1) { // if player is player 1 then start with black

			return 1;
		} else {
			cnt=1;
			return 0; // start with white
		}
	}

	/**
	 * Reads the row for the move wanted.
	 * 
	 * @return the value of the row wanted
	 */
	private int readRow() {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // prompts
																					// for
																					// input
																					// of
																					// row
		Integer value = -1;
	boolean incorrectEntry=true;
	while(incorrectEntry) {
		System.out.print("Select a row: "); // Displays a message asking to
		// select a row
			try {
				value = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // reads the value selected
			
			if((value instanceof Integer)&& value>=0&&value<8) {
				incorrectEntry = false;
			}
	}
		return value; // returns the value selected
	}

	/**
	 * Reads the column of the move wanted.
	 * 
	 * @return the value of the column wanted
	 */
	private int readCol() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // prompts
																					// for
																					// input
																					// of
																					// row
		Integer value = -1;
	boolean incorrectEntry=true;
	while(incorrectEntry) {
		System.out.print("Select a Col0: "); // Displays a message asking to
		// select a row
			try {
				value = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // reads the value selected
			
			if((value instanceof Integer)&& value>=0&&value<8) {
				incorrectEntry = false;
			}
	}
		return value; // returns the value selected
	}

	
}
