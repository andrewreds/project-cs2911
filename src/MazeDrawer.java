import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class MazeDrawer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1678219167801561043L;

	public MazeDrawer (Maze newMaze) {
		currentMaze = newMaze;
	}
	
	public void setMaze (Maze newMaze) {
		currentMaze = newMaze;
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(200,200);
    }
	
	public void paintComponent(Graphics grap) {
		//TODO:... print out the maze to the screan
	}

	private Maze currentMaze;
}
