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

	private int minimax(Board b, int depth, boolean isMax) {
	//	b.display();
		System.out.println(isMax);
		if (depth == 0 || b.gameOver()) {
			return b.getRealChipCount(aiColor) - b.getRealChipCount(playerColor);
		}

		if (isMax) {

			System.out.println("Max, depth is " + depth);
			int bestValue = Integer.MIN_VALUE;
//			for (Move move : b.validMove(aiColor)) {
				
				Move move = b.validMove(aiColor).get(0);
				Board newboard = b.copyBoard();
				System.out.println("Ai color: "+ aiColor);
				newboard.placeChip(aiColor, move);
				newboard.replaceChip(move, aiColor);
				int v = minimax(newboard, depth - 1, false);
				if (v > bestValue) {
					bestValue = v;
					if (depth == limit) {
						bestMove = move;

					}
				}
//			}
		}
		if (!isMax) {
			System.out.println("Min, depth is " + depth);
			int bestValue = Integer.MAX_VALUE;
			for (Move move : b.validMove(playerColor)) {
				Board newboard = b.copyBoard();
				System.out.println("player color: "+ playerColor);
				newboard.placeChip(playerColor, move);
				newboard.replaceChip(move, playerColor);
				int v = minimax(newboard, depth - 1, true);
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
