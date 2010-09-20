import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class MainWindow {
	public MainWindow () {
		JButton generateButton = new JButton ("Generate");
		JButton sovleButton = new JButton ("Solve");
		JButton sizeButton = new JButton ("Change Size");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(generateButton);
		buttonPanel.add(sovleButton);
		buttonPanel.add(sizeButton);
		
		Maze maze = new Maze(123456,15,10);
		MazeDrawer mazeD = new MazeDrawer (maze);
		
		
		JFrame frame = new JFrame("The Ultimate maze game...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mazeD, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
}
