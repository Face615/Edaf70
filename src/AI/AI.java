package AI;
import model.Game;
public class AI {
	
	private int limit;
	
	public AI(int limit) {
		this.limit=limit;
	}
	
	
	public int maxValue(Game g, int alpha, int beta) {
		
		if(limit ==0) {
		return g.getWhiteScore();
		}
		
		
		return 0;
	}
	
}
