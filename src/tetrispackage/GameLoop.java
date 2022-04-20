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
        timer.scheduleAtFixedRate(new RepeatedTask(), 1000, 1000);
    }

    static class RepeatedTask extends TimerTask {
        public void run() {
            if(!shape.isStuckDown() && !grid.gridFilledDown(shape))
			{
            	grid.resetPosition(shape);
				shape.down();
				
				grid.refreshPosition(shape);
				gui.refreshGridGui(grid);
				//gui.refreshPiecePosition(grid);
				for(int i=0; i<20; i++)
				{
					for(int j=0; j<10; j++)
					{
						System.out.print(" "+grid.getGrid()[i][j]);
					}
					System.out.println();
				}
				System.out.println("\r\n");
			}
            else
            {
            	grid.removeFullLine();
            	gui.refreshGridGui(grid);
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