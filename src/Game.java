import java.util.ArrayList;

public class Game {
	
	private final int BLACK =1;
	private final int WHITE=0;
	private Board board;
	
	public ArrayList <Move> getLegalMoves(int color){
		return board.validMove(color);
	}
	
	
	
	
	
	public int getBLackScore() {
		return board.getChipsCount(BLACK);
	}
	
	
	public int getWhiteScore() {
		return board.getChipsCount(WHITE);
	}
	
	
	
	

}
