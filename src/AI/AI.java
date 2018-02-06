package AI;
import model.Game;
import model.Move;
public class AI {
	
	private int limit;
	private Move bestMove;
	
	
	public AI(int limit) {
		this.limit=limit;
	}
	
	public Move getBestMove() {
		return bestMove;
	}
	
	// Add public method
	public int minimax(Game g, int depth, boolean isMax) {
		
		if(depth <=0) {
		return g.getAiScore()-g.getPlayerScore();
		}
		
		else if(isMax) {
			int maxBestV = Integer.MIN_VALUE;
			for(Move move: g.getLegalMoves(g.getAiColor())) {
			
				g.display();
				int v =minimax(g.placeChip(g.getPlayerColor(), move), depth--, false);
				maxBestV=Integer.max(maxBestV, v);
				if (maxBestV<v&& depth==limit) {
					bestMove=move;
				}
				
								
			}
		
			return maxBestV;
		}else {
			int minBestV = Integer.MAX_VALUE;
			for(Move move: g.getLegalMoves(g.getPlayerColor())) {
				//g.display();
				int v = minimax(g.placeChip(g.getAiColor(), move), depth--, true);
				minBestV=Integer.min(minBestV, v);
				
			}
			return minBestV;
			
		}
		
		

	}
	
}
