
/**
 * A cell has up to 4 walls, and each wall has up to 2 cells
 *
 */
public class Cell {

	public Cell () {
		
	}

	public void setState(int newState) {
		state = newState;
		
	}

	public Cell getCellInDir(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isState(int checkState) {
		return state==checkState;
	}

	public void hideWall(Cell nextCell) {
		// TODO Auto-generated method stub
		
	}
	
	private int state = 0;
	public static final int UN_TOUCHED = 1;
	public static final int TOUCHED = 2;
}
