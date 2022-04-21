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
				    	if(tetris.getGrid().canRotate(tetris.getShape()))
				    	{
				    		tetris.getGrid().resetPosition(tetris.getShape());
					    	tetris.getShape().rotate();
					    	tetris.getGrid().refreshPosition(tetris.getShape());
					    	tetris.getGui().refreshGridGui(tetris.getGrid());
				    	}
				    	break;
				    case KeyEvent.VK_DOWN:
				    	if(!tetris.getShape().isStuckDown() && !tetris.getGrid().gridFilledDown(tetris.getShape()))
				    	{
				    		tetris.getGrid().resetPosition(tetris.getShape());
							tetris.getShape().down();
							tetris.getGrid().refreshPosition(tetris.getShape());
							tetris.getGui().refreshGridGui(tetris.getGrid());
				    	}
				    	break;
				    case KeyEvent.VK_RIGHT:
				    	if(!tetris.getShape().isStuckRight() && !tetris.getGrid().gridFilledRight(tetris.getShape()))
				    	{
				    		tetris.getGrid().resetPosition(tetris.getShape());
					    	tetris.getShape().moveRight();
					    	tetris.getGrid().refreshPosition(tetris.getShape());
					    	tetris.getGui().refreshGridGui(tetris.getGrid());
				    	}
				    	break;
				    case KeyEvent.VK_LEFT:
				    	if(!tetris.getShape().isStuckLeft() && !tetris.getGrid().gridFilledLeft(tetris.getShape()))
				    	{
				    		tetris.getGrid().resetPosition(tetris.getShape());
					    	tetris.getShape().moveLeft();
					    	tetris.getGrid().refreshPosition(tetris.getShape());
					    	tetris.getGui().refreshGridGui(tetris.getGrid());
				    	}
				    	break;
				    }
				  }
				});

	}
}
