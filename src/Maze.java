import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Maze extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5386529132944306261L;

	public Maze() {
		resizeMaze (50,25);
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(width*20+boarder*2,height*20+boarder*2);
    }
	
	public void paintComponent(Graphics grap) {
		Graphics2D g = (Graphics2D) grap;
		
		double wStep = (double) ((getWidth()-boarder*2)) / width;
		double hStep = (double) ((getHeight()-boarder*2)) / height;
				
		// TODO: make maze re-center
		//draw walls
		for (int i = 0; i <= width; i++) {
			for (int j = 0; j <= height; j++) {
				if (verticalWalls[i][j]&&j<height){
					g.drawLine((int) (i*wStep+boarder),(int) (j*hStep+boarder),
							(int) (i*wStep+boarder),(int) ((j+1)*hStep+boarder));
				}
				if (horizontalWalls[i][j]&&i<width){
					g.drawLine((int) (i*wStep+boarder), (int) (j*hStep+boarder),
							(int) ((i+1)*wStep+boarder), (int) (j*hStep+boarder));
				}
			}
		}
		
		//draw start and end gates
		g.drawRect((int) (startX*wStep-goalSize+boarder), (int) (startY*hStep-goalSize+boarder),
				goalSize*2, goalSize*2);
		g.drawRect((int) (endX*wStep-goalSize+boarder), (int) (endY*hStep-goalSize+boarder),
				goalSize*2, goalSize*2);
		
	}
	
	public void resizeMaze (int x, int y) {
		//reset the current arrays
		verticalWalls = new boolean [x+1][y+1];
		horizontalWalls = new boolean [x+1][y+1];
		
		width = x;
		height = y;
		
		//create default maze pattern
		for (int i = 0;i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				verticalWalls[i][j] = true;
				horizontalWalls[i][j] = false;
				if ((j == 0&&i%2==0)||(j==(y-1)&&i%2==1)) {
					verticalWalls[i][j] = false;
				}
				if (j == 0||j == y) {
					horizontalWalls[i][j] = true;
				}
			}
		}
		
		startX = 0;
		startY = 0.5;
		endX = x;
		if (x%2==0){
			endY = 0.5;
		} else {
			endY = y-0.5;
		}
		
	}
	
	private int width;
	private int height;
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	
	private int boarder = 5;
	private int goalSize = 4;
	
	//TODO: change to array of cells with a bottom and left wall
	private boolean [] [] verticalWalls;
	private boolean [] [] horizontalWalls;
}
