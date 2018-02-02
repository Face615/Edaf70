package model;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Board b = new Board();
		
		b.display();
	System.out.println(	b.validMove(0));
		b.display();
		b.placeChip(1, 1, 2);
		b.display();
		
	}
}
