import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Array;

import javax.swing.*;

public class Maze extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5386529132944306261L;

	public Maze() {
		//setBorder(BorderFactory.createLineBorder(Color.black));
		resizeMaze (10,10);
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(width*20+boarder*2,height*20+boarder*2);
    }
	
	public void paintComponent(Graphics grap) {
		Graphics2D g = (Graphics2D) grap;
		
		int wStep = (getWidth()-boarder*2) / width;
		int hStep = (getHeight()-boarder*2) / height;
		
		for (int i = 0; i <= width; i++) {
			for (int j = 0; j < height; j++) {
				if (verticalWalls[i][j]){
					g.drawLine(i*wStep+boarder,j*hStep+boarder,
							i*wStep+boarder,(j+1)*hStep+boarder);
				}
				if (horizontalWalls[j][i]){
					g.drawLine(j*wStep+boarder, i*hStep+boarder,
							(j+1)*wStep+boarder, i*hStep+boarder);
				}
			}
		}
		
		//g.drawLine(0, 0, getWidth(), getHeight());
		//g.drawLine(getWidth(), 0, 0, getHeight());
		
	}
	
	public void resizeMaze (int x, int y) {
		//reset the current arrays
		verticalWalls = new boolean [x+1][y];
		horizontalWalls = new boolean [x][y+1];
		
		width = x;
		height = y;
		
		for (int i = 0;i <= x; i++) {
			for (int j = 0; j < y; j++) {
				verticalWalls[i][j] = false;
				horizontalWalls[j][i] = false;
				if (i == 0||i == x) {
					verticalWalls[i][j] = true;
				}
				if (i == 0||i == y) {
					horizontalWalls[j][i] = true;
				}
			}
		}
		
	}
	
	private int width;
	private int height;
	
	private int boarder = 10;
	
	private boolean [] [] verticalWalls;
	private boolean [] [] horizontalWalls;
}
