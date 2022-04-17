package tetrispackage;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class GameLoop {
	private static Grid grid;
	private static Gui gui;
	private static Shape shape;
	
    public GameLoop() {
    	grid = new Grid();
		gui = new Gui();
		gui.setVisible(true);
		
		shape = randomPiece();
		grid.spawnPiece(shape);
    	
        Timer timer = new Timer();
        //System.out.println("Stop Watch Started.");
        timer.scheduleAtFixedRate(new RepeatedTask(), 1000, 1000);
    }

    static class RepeatedTask extends TimerTask {
        public void run() {
            //System.out.println("Running!");
            if(!shape.isStuckDown())
			{
            	grid.resetPosition(shape);
				shape.down();
				grid.refreshPosition(shape);
				gui.refreshGridGui(grid);
			}
            else
            {
				shape = randomPiece();
            }
            
        }
    }
    
    public Grid getGrid() {
    	return grid;
    }
    
    public Gui getGui() {
    	return gui;
    }
    
    public Shape getShape() {
    	return shape;
    }
    
    public static Shape randomPiece() {
    	int r = new Random().nextInt(7);
    	switch(r)
    	{
    	case 0:
    		return new IPiece();
    	case 1:
    		return new JPiece();
    	case 2:
    		return new LPiece();
    	case 3:
    		return new OPiece();
    	case 4:
    		return new SPiece();
    	case 5:
    		return new ZPiece();
    	case 6:
    		return new TPiece();
    	default:
    		return null;
    	}
    }
}