package AI;

import java.util.ArrayList;

import model.Board;
import model.Game;
import model.Move;

public class AI {

	private int limit;
	private Move bestMove;
	private int aiColor;

	private Board board;
	private int playerColor = 1 - aiColor;

	public AI(int limit) {
		this.limit = limit;
	}

	// Add public method


	public Move minimax(Board b) {
		
		minimax(b, limit, true);
		return bestMove;
	}
	
	public void setAiColor(int aiColor) {
		this.aiColor = aiColor;
	}

	private int minimax(Board b, int depth, boolean isMax) {
		if (depth == 0 || b.gameOver()) {
			return b.getRealChipCount(aiColor) - b.getRealChipCount(playerColor);
		}

		if (isMax) {

			int bestValue = Integer.MIN_VALUE;
			for (Move move : b.validMove(aiColor)) {
				Board nb = b.copyBoard();
				nb.placeChip(aiColor, move);
				nb.replaceChip(move, aiColor);
				int v = minimax(nb, depth - 1, false);
				if (v > bestValue) {
					bestValue = v;
					if (depth == limit) {
						bestMove = move;
					}
				}
			}
		}
		if (!isMax) {
			int bestValue = Integer.MAX_VALUE;

			for (Move move : b.validMove(playerColor)) {
				
				Board nb = b.copyBoard();

				nb.placeChip(playerColor, move);
				nb.replaceChip(move, playerColor);
				int v = minimax(nb, depth - 1, true);
				if (v < bestValue) {
					bestValue = v;
				}
			}
		}
		return 0;
	}

	public Move getBestMove() {
		return bestMove;
	}

}
