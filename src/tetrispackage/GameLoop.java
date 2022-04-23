package tetrispackage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent.*;
import java.awt.event.*;


public class GameLoop implements Levels {
	private static Grid grid;
	private static Gui gui;
	private static Shape shape;
	private static boolean gameOver;
	private static boolean hardDropped;
	private static ArrayList<Shape> nextPiece;
	private static int count;
	private static int level;
	private static float seconds;
	private static int minutes;
	private static int time;
	
    public GameLoop() {
    	gameOver = false;
    	grid = new Grid();
		gui = new Gui();
		nextPiece = new ArrayList<Shape>();
		seconds = 0;
		minutes = 0;
		
		gui.setVisible(true);
		gui.requestFocus();
		
		gui.playButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  gui.playButton.setEnabled(false);
			  Play();
		  }
		});
		
    }
    
    public void Play() {
    	nextPiece.add(randomPiece());
		nextPiece.add(randomPiece());
		nextPiece.add(randomPiece());
		shape = randomPiece();
		
		grid.spawnPiece(shape);
		
		hardDropped = false;
		count = 0;
		level = BEGINNER;
    	
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new RepeatedTask(), 500, 100);
    }
    
    
    
    
    
    
    
    

    static class RepeatedTask extends TimerTask {
        public void run() {
        	count ++;
        	time+=1;
        	minutes = time/600;
        	seconds = (float)(time%600)/10;
        	//System.out.println("temps : "+minutes+" : "+seconds);
        	
        	if(count >= level)
        	{
        		count = 0;
	            if(!shape.isStuckDown() && !grid.gridFilledDown(shape))
				{
	            	grid.resetPosition(shape);
					shape.down();
					
					grid.refreshPosition(shape);
					gui.refreshGridGui(grid);
					gui.requestFocus();
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
	            	System.out.println("score : "+grid.getScore());
					shape = nextPiece.get(0);
					nextPiece.remove(0);
					nextPiece.add(randomPiece());
					if(grid.canSpawn(shape))
					{
						grid.spawnPiece(shape);
						hardDropped = false;
					}
					else
					{
						this.cancel();
						gameOver = true;
						int highScored = grid.saveHighScore();
						if(highScored == 0)
						{
							System.out.println("You have tied the high score !");
						}
						else if(highScored == 1)
						{
							System.out.println("You have the new high score ! The previous high score was : "+grid.getHighScore());
						}
						
						System.out.println("Game Over ! ");
					}
	            }
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
    
    public boolean gameOver() {
    	return gameOver;
    }
    
    public void setHardDropped(boolean drop) {
    	hardDropped = drop;
    }
    
    public boolean getHardDropped() {
    	return hardDropped;
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