import java.util.Random;
import java.util.Stack;

public class Maze {
	/**
	 * 
	 */

	public Maze(long seed,int width, int height) {
		this.width = ++width;
		this.height = ++height;
		
		map = new Cell [width][height];
		
		//create the array
		for (int x=0; x<width;x++) {
			for (int y=0; y<height; y++) {
				map [x][y] = new Cell();
				map [x][y].setState (Cell.UN_TOUCHED);
			}
		}
		
		//TODO: add walls here
		
		//dig put the maze
		//this algrothim should work, I will test it when a wall&cell&drawMaze are actualy implemented :)
		int order[] = {0,1,2,3};
		Random rand =  new Random (seed);
		
		Stack<Cell> stk = new Stack<Cell> ();
		stk.push(map[0][0]);
		
		while (!stk.isEmpty()){
			Cell current = stk.pop();
			
			current.setState(Cell.TOUCHED);
			
			randomise (rand, order);
			
			boolean found = false;
			int dir = 0;
			while (dir<4 && !found) {
				Cell nextCell = current.getCellInDir (order[dir]);
				if (nextCell!=null && nextCell.isState(Cell.UN_TOUCHED)) {
					//found our next victim
					found = true;
					stk.push (current);
					stk.push (nextCell);
					current.hideWall (nextCell);
				}
			}
		}
	}
	
	
	private void randomise(Random rand, int[] order) {
		for (int i=0; i<10; i++) {
			//find two random locations
			int a = rand.nextInt(order.length-1);
			int b = rand.nextInt(order.length-1);
			
			// swap them
			int temp = order[a];
			order[a] = order[b];
			order[b] = temp;
		}
	}


	public Cell [] [] getCells () {
		return map;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private Cell [] [] map;
	private int width = 0;
	private int height = 0;
}
