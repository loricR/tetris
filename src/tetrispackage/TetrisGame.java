package tetrispackage;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.TimeUnit;

//import java.awt.*;
import javax.swing.*;

public class TetrisGame extends JFrame{
	
	private Levels level;
		
	public static void main(String[] args) {
	
		Grid grid = new Grid();
		Gui gui = new Gui();
		gui.setVisible(true);
		
		Shape shape = new IPiece();
		grid.spawnPiece(shape);
		
		while(!shape.isStuckDown()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			grid.refreshPosition(shape);
			gui.refreshGridGui(grid);
			System.out.println();
			System.out.println();
			System.out.println();
			for (int i = 0;i < grid.getGrid().length; i++) {
		         for (int j = 0;j < grid.getGrid()[i].length;j++) {
		            System.out.print(grid.getGrid()[i][j] + " ");
		         }
		         System.out.println();
		      }
			if(shape.isStuckDown())
			{
				shape = new TPiece();
			}
		}
		
	}
	
}
