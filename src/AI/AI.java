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
		System.out.print("HELL SEGER");
		return bestMove;
	}

	private int minimax(Board b, int depth, boolean isMax) {
		b.display();
		System.out.print("depth: "+depth);
		System.out.println(isMax);
		if (depth == 0 || b.gameOver()) {
			return b.getRealChipCount(aiColor) - b.getRealChipCount(playerColor);
		}

		if (isMax) {

	//		System.out.println("Max, depth is " + depth);
			int bestValue = Integer.MIN_VALUE;


			for (Move move : b.validMove(aiColor)) {
				System.out.print(b.validMove(aiColor));
				Board nb = b.copyBoard();
				//Board newboard = nb;
				System.out.println("Ai color: "+ aiColor);
				nb.display();

				//System.out.println("\n \n");
				nb.placeChip(aiColor, move);
				nb.replaceChip(move, aiColor);
				int v = minimax(nb, depth - 1, false);
				//System.out.print("newboard bräda");
				//newboard.display();
				if (v > bestValue) {
					bestValue = v;
					if (depth == limit) {
						bestMove = move;
					}
				}
			}
		}
		if (!isMax) {
		//	System.out.println("Min, depth is " + depth);
			int bestValue = Integer.MAX_VALUE;

			System.out.print(b.validMove(playerColor));
			for (Move move : b.validMove(playerColor)) {
				
				Board nb = b.copyBoard();
				//Board newboard = nb;
				System.out.println("player color: "+ playerColor);
				nb.display();

				System.out.println("\n \n");
				nb.placeChip(playerColor, move);
				nb.replaceChip(move, playerColor);
				int v = minimax(nb, depth - 1, true);
				//System.out.print("newboard bräda");
				//newboard.display();
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
