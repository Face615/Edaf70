package model;
import AI.AI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AI ai = new AI(5);
		
		Game g = new Game(0);
		g.display();
	System.out.println(	g.getAiScore());
//		int i = ai.minimax(g, 5, true);
//		
//		System.out.println(i);
	}

}
