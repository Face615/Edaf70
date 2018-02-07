package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Samuel on 01/04/14. Updated by aeap and jgeorge on 14/05/14.
 */

public class Turn {

	private int value; // the player.

	/**
	 * Class constructor. Creates a turn starting with a random player.
	 */
	public Turn() {
		System.out.print("Wanna be the first to lay a move write 1, want the AI to begin write 0.\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.value=0;
		try{
		this.value = Integer.parseInt(br.readLine());
		}catch(IOException e){}
	}
	


	/**
	 * Class constructor. Creates a turn starting with the selected player.
	 * 
	 * @param int v - adjust the value
	 */
	public Turn(int v) {
		this.value = v;
	}

	/**
	 * Returns the player whose turn it is.
	 * 
	 * @return value of the turn
	 */
	public int getTurn() {
		return this.value;
	}

	/**
	 * Changes the turn to the other player.
	 */
	public void change() {
		this.value = (this.value + 1) % 2;
	}
}
