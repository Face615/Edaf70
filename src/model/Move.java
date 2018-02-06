package model;

/**
 * Created by aeap and jgeorge on 14/05/14.
 */

public class Move {

	int row, col; // i, position on i axis & j position on j axis

	/**
	 * Class constructor. Position we want to look at, to create the directions
	 * on i and j axis
	 */
	public Move(int i, int j) {
		this.row = i;
		this.col = j;
	}

	/**
	 * Gets the location of the position we want to look at on the i axis
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets the location of the position we want to look at on the j axis
	 */
	public int getCol() {
		return col;
	}
	public String toString() {
		return "["+this.row+","+this.col+"]";
	}
	
	@Override
	public boolean equals(Object other){
	    if (other == null) {
	    	 return false;
	    }
	  
	    else if ((other instanceof Move)) {
	    	if(this.col == (((Move) other).getCol())&& this.row== (((Move) other).getRow())) {
	    		return true;
	    	}
	    }
	  
		return false;
	  
	}
}
