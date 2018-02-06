package model;
import java.util.ArrayList;

public class Game {
	
	private final int BLACK =1;
	private final int WHITE=0;
	private Board board;
	private int turn;
	private int humanColor;
	private int aiColor;
	private int chosenColor;
	public int getPlayerColor() {
		return humanColor;
	}

	public int getAiColor() {
		return aiColor;
	}

	public Game(int color) {
		chosenColor = color;
		if(chosenColor==BLACK) {
			humanColor = BLACK;
			aiColor = WHITE;
		}else {
			humanColor = WHITE;
			aiColor = BLACK;
		}
		board = new Board();
		turn = humanColor;
				
	
	}
	
	public ArrayList <Move> getLegalMoves(int color){
		return board.validMove(color);
	}
	
	public Game placeChip(int playerColor, Move move ) {
		if(getLegalMoves(playerColor).contains(move)) {

			board.placeChip(playerColor, move.getRow(), move.getCol());
			board.replaceChip(move, playerColor);
			switchTurns();
		}
		else {
			System.out.println( "("+move.getRow()+","+move.getCol()+") is an illegal move for player "+getTurn());
		}

		return this;
	}
	
	public boolean gameOver() {
		return board.gameOver();
	}
	
	
	public int getPlayerScore() {
		return board.getRealChipCount(humanColor);
	}
	
	
	public int getAiScore() {
		return board.getRealChipCount(aiColor);
	}
	
	public void display() {
		board.display();
		showWhosTurn();
		
	}
	
	private void switchTurns() {
		if (turn==humanColor) {
			turn = aiColor;
		}
		else {
			turn= humanColor;
		}
	}
	
	public int getTurn() {
		return turn;
	}
	
	// ÄNDRA DETTA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public Game copyThisGame() {
		Game g = new Game(chosenColor);
		g.setBoard(this.board);
		
		return g;
	
	}	
	
	private void showWhosTurn() {
		if (turn==humanColor) {
			System.out.println("Humans turn");
		}
		else {
			System.out.println("AI turn");
		}
	}
	
	private void setBoard(Board  b) {
		this.board=b;
	}
	

}
