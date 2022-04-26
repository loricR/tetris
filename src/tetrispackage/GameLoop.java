package tetrispackage;

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
	private static boolean pause;
	private static int lineLevelUp;
	
    public GameLoop() {
    	gameOver = false;
    	grid = new Grid();
		gui = new Gui();
		nextPiece = new ArrayList<Shape>();
		time = 0;
		seconds = 0;
		minutes = 0;
		
		this.level = BEGINNER;
		this.lineLevelUp = 10;
		gui.setVisible(true);
		gui.requestFocus();
		
		gui.refreshScore(grid.getScore(), grid.getHighScore());
		
		//Play button listener 
		gui.playButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  gui.playButton.setEnabled(false);
			  gui.beginnerLevel.setEnabled(false);
			  gui.easyLevel.setEnabled(false);
			  gui.normalLevel.setEnabled(false);
			  gui.hardLevel.setEnabled(false);
			  gui.legendLevel.setEnabled(false);
			  Play();
		  }
		});
		
		//Pause button listener 
				gui.pauseButton.addActionListener(new ActionListener()
				{
				  public void actionPerformed(ActionEvent e)
				  {
					  if (pause==true)
					  {
						  gui.pauseButton.setText("Pause");
					  }
					  else
					  {
						  gui.pauseButton.setText("Resume");
					  }
					  pause = !pause;
				  }
				});
		
		//Level selection listeners
		gui.beginnerLevel.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  level = BEGINNER;
			  gui.easyLevel.setSelected(false);
			  gui.normalLevel.setSelected(false);
			  gui.hardLevel.setSelected(false);
			  gui.legendLevel.setSelected(false);
		  }
		});
		gui.easyLevel.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  level = EASY;
			  gui.beginnerLevel.setSelected(false);
			  gui.normalLevel.setSelected(false);
			  gui.hardLevel.setSelected(false);
			  gui.legendLevel.setSelected(false);
		  }
		});
		gui.normalLevel.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  level = NORMAL;
			  gui.easyLevel.setSelected(false);
			  gui.beginnerLevel.setSelected(false);
			  gui.hardLevel.setSelected(false);
			  gui.legendLevel.setSelected(false);
		  }
		});
		gui.hardLevel.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  level = HARD;
			  gui.easyLevel.setSelected(false);
			  gui.normalLevel.setSelected(false);
			  gui.beginnerLevel.setSelected(false);
			  gui.legendLevel.setSelected(false);
		  }
		});
		gui.legendLevel.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  level = LEGEND;
			  gui.easyLevel.setSelected(false);
			  gui.normalLevel.setSelected(false);
			  gui.hardLevel.setSelected(false);
			  gui.beginnerLevel.setSelected(false);
		  }
		});
		
    } // ------------- end of the constructor ------------------------------
    
    public void Play() {
    	gui.displayGame();
    	ResetGame();
    	gui.refreshLevel(11-level);
    	gui.pauseButton.setEnabled(true);
    	gui.requestFocus();
    	
    	nextPiece.add(randomPiece());
		nextPiece.add(randomPiece());
		nextPiece.add(randomPiece());
		shape = randomPiece();
		
		grid.spawnPiece(shape);
		gui.refreshNextPiece(nextPiece);
		
		hardDropped = false;
		count = 0;
    	
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new RepeatedTask(), 500, 100);
    }
    
    
    public void ResetGame() {
    	grid.resetGrid();
    	gui.refreshGridGui(grid);
    	gameOver = false;
    	nextPiece.clear();
    	this.time = 0;
    	this.seconds = 0;
    	this.minutes = 0;
    	gui.refreshTime(this.minutes, this.seconds);
    }
    
    

    static class RepeatedTask extends TimerTask {
        public void run() {
        	if (!pause)
        	{
        		count ++;
            	time+=1;
            	minutes = time/600;
            	seconds = (float)(time%600)/10;
            	//System.out.println("temps : "+minutes+" : "+seconds);
            	gui.refreshTime(minutes, seconds);
            	gui.refreshScore(grid.getScore(), grid.getHighScore());
            	
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
		            	gui.refreshLine(grid.getRemovedLines());
		            	gui.refreshGridGui(grid);
		            	System.out.println("score : "+grid.getScore());
						shape = nextPiece.get(0);
						nextPiece.remove(0);
						nextPiece.add(randomPiece());
		            	gui.refreshNextPiece(nextPiece);
		            	
		            	if(grid.getLastRemovedLines() >= 0 && grid.getRemovedLines() >= lineLevelUp && level > 1)
			            {
			            		level--;
			            		lineLevelUp += 10;
			            		gui.refreshLevel(11-level);
			            }

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
								gui.displayGameOver("You have tied the high score !");
								System.out.println("You have tied the high score !");
							}
							else if(highScored == 1)
							{
								gui.displayGameOver("You have the new high score ! \r\nThe previous high score was : "+grid.getHighScore()+"\r\nYour score is : "+grid.getScore());
								System.out.println("You have the new high score ! The previous high score was : "+grid.getHighScore());
							}
							else
							{
								gui.displayGameOver("");
							}
							
							//gui.playButton.setText("Replay");
							gui.playButton.setEnabled(true);
							gui.pauseButton.setEnabled(false);
							/*gui.beginnerLevel.setEnabled(true);
							gui.easyLevel.setEnabled(true);
							gui.normalLevel.setEnabled(true);
							gui.hardLevel.setEnabled(true);
							gui.legendLevel.setEnabled(true);*/
						}
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
    	/*int r = new Random().nextInt(7);
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
    	}*/
    	return new IPiece();
    }
}