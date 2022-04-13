package tetrispackage;
import javax.swing.*;

import tetrispackage.Window;

import java.awt.*;


public class GraphicGrid extends JPanel {
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(50, 35, 150, 150);  
		}

	public void showGrid()
	{
		JPanel panel = new GraphicGrid();
		JFrame window = new Window();
		
		window.getContentPane().add(panel);
		window.setVisible(true);
	}
	
}
