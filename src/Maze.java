import java.awt.Color;
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
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
	
	public void paintComponent(Graphics grap) {
		Graphics2D g = (Graphics2D) grap;
		g.drawLine(0, 0, getWidth(), getHeight());
		g.drawLine(getWidth(), 0, 0, getHeight());
		
	}
}
