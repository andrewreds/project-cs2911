import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class MainWindow {
	public MainWindow () {
		JButton generateButton = new JButton ("Generate");
		JButton sovleButton = new JButton ("Solve");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(generateButton);
		buttonPanel.add(sovleButton);
		Maze maze = new Maze ();
		
		
		JFrame frame = new JFrame("The Ultimate maze game...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(maze, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
}
