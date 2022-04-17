package tetrispackage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.TimeUnit;

//import java.awt.*;
import javax.swing.*;

public class TetrisGame extends JFrame{
	
	private Levels level;
		
	public static void main(String[] args) {
	
		GameLoop tetris = new GameLoop();
		
			tetris.getGui().addKeyListener(new KeyAdapter() {
				  public void keyPressed(KeyEvent e) {
				    int keyCode = e.getKeyCode();
				    switch(keyCode)
				    {
				    case KeyEvent.VK_UP:
				    	tetris.getGrid().resetPosition(tetris.getShape());
				    	tetris.getShape().rotate();
				    	tetris.getGrid().refreshPosition(tetris.getShape());
				    	tetris.getGui().refreshGridGui(tetris.getGrid());
				    	break;
				    case KeyEvent.VK_DOWN:
				    	tetris.getGrid().resetPosition(tetris.getShape());
						tetris.getShape().down();
						tetris.getGrid().refreshPosition(tetris.getShape());
						tetris.getGui().refreshGridGui(tetris.getGrid());
				    	break;
				    case KeyEvent.VK_RIGHT:
				    	tetris.getGrid().resetPosition(tetris.getShape());
				    	tetris.getShape().moveRight();
				    	tetris.getGrid().refreshPosition(tetris.getShape());
				    	tetris.getGui().refreshGridGui(tetris.getGrid());
				    	break;
				    case KeyEvent.VK_LEFT:
				    	tetris.getGrid().resetPosition(tetris.getShape());
				    	tetris.getShape().moveLeft();
				    	tetris.getGrid().refreshPosition(tetris.getShape());
				    	tetris.getGui().refreshGridGui(tetris.getGrid());
				    	break;
				    }
				  }
				});

	}
}
