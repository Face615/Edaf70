package model;
import java.util.ArrayList;

public class Game {
	
	private final int BLACK =1;
	private final int WHITE=0;
	private Board board;
	
	private int humanColor;
	private int aiColor;
	
	public int getPlayerColor() {
		return humanColor;
	}

	public int getAiColor() {
		return aiColor;
	}

	public Game(int color) {
		if(color==BLACK) {
			humanColor = BLACK;
			aiColor = WHITE;
		}else {
			humanColor = WHITE;
			aiColor = BLACK;
		}
		board = new Board();
				
	
	}
	
	public ArrayList <Move> getLegalMoves(int color){
		return board.validMove(color);
	}
	
	public Game placeChip(int playerColor, Move move ) {
		board.placeChip(playerColor, move.getRow(), move.getCol());
		board.replaceChip(move, playerColor);
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
	}
	
	
	

}
