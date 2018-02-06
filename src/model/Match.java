package model;

import java.util.Scanner;

import AI.AI;

public class Match {
	private Scanner reader;
	
	private int tempRow;
	private int tempCol;

	
	public Match() {
		reader =  new Scanner(System.in);
	}
	public void startMatch() {
		int color = 0;

		AI ai = new AI(5);

		Game g = new Game(0);
		g.display();
		while (tempRow != -1) {
		getUserMove();
		System.out.println("Usermove:("+tempRow+","+tempCol+")");
		
		g.placeChip(g.getTurn(), new Move(tempRow, tempCol));
		g.display();
		}
	
		

	}
	
	private void getUserMove() {
	

			System.out.print("Input row:");
			tempRow = reader.nextInt();

			System.out.println("Input coloumn");
			tempCol = reader.nextInt();

		
	
	}
}
