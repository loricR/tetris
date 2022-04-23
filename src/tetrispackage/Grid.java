package tetrispackage;
import java.util.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Grid {
    private int[][] grid;
    private Shape curPiece;
    private int removedLines;
    private int lastLines;
    private int score;
    private File file;
    private int highScore;

    public Grid() {
    	this.grid = new int[20][10];
    	this.removedLines = 0;
    	this.lastLines = 0;
    	this.score = 0;
    	this.highScore = getSavedHighScore();
    }

    public Grid(int x, int y) {
    }
    
    public int[][] getGrid() {
    	return this.grid;
    }
    
    public Shape getCurPiece() {
    	return this.curPiece;
    }
    
    public int getRemovedLines() {
    	return this.removedLines;
    }
    
    public int getScore() {
    	return this.score;
    }
    
    public int saveHighScore() {
    	if(score > highScore)
    	{
    		file = new File("highScore.txt");
        	
        	try {
        		BufferedWriter output = new BufferedWriter(new FileWriter(file, false));
        		output.append(""+score);
        		output.close();
        		} catch (IOException ex1) {
        	        System.err.println("ERROR writing score to file: "+ex1);
        	    }
        	return 1;
    	}
    	else if(score == highScore)
    	{
    		return 0;
    	}
    	else
    	{
    		return -1;
    	}
    }
    
    public int getHighScore() {
    	return this.highScore;
    }
    
    public int getSavedHighScore() {
    	int fileScore = 0;
    	String fileName = "highScore.txt";
		if(!new File(fileName).exists())
		{
			try {
				new File(fileName).createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	file = new File(fileName);
    	
    	try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            if(line != null)
            {
            	try {
                    fileScore = Integer.parseInt(line.trim());   // parse as an int
                } catch (NumberFormatException e1) {
                    // ignore if score is invalid
                }
            }
            reader.close();
        } catch (IOException ex) {
            System.err.println("ERROR reading scores from file");
        }
    	
    	return fileScore;
    }
    
    public void spawnPiece(Shape shape) {
    	curPiece = shape;
    	
    	for(int i=0; i<4; i++)
    	{
    		grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = curPiece.getColor();
    	}
    }
    
    public boolean canSpawn(Shape shape) {
    	curPiece = shape;
    	
    	for(int i=0; i<4; i++)
    	{
	    	if(grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] != 0)
	    	{
	    		return false;
	    	}
    	}
    	return true;
    }
    
    public void resetPosition(Shape shape) {
    	curPiece = shape;
    	for(int i=0; i<4; i++) 
    	{
    		grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = 0; //On efface l'ancienne position de la piece
    	}
    }
    
    public void refreshPosition(Shape shape) {
    	curPiece = shape;
    	for(int i=0; i<4; i++) 
    	{
        	grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = curPiece.getColor(); //On remplace la piece aux nouvelles coordonnées
    	}
    	
    }
    
    public boolean gridFilledDown(Shape shape) {
    	curPiece = shape;
    	boolean result = false;
    	
    	for(int i=0; i<4; i++)
    	{
    		if((curPiece.getCoordY(i)+1) < 20)
    		{
    			if(grid[curPiece.getCoordY(i)+1][curPiece.getCoordX(i)] != 0)
    			{	
    				boolean otherPiece = true;
    				for(int j=0; j<4; j++)
    				{
    					if(((curPiece.getCoordY(i)+1) == curPiece.getCoordY(j)) && (curPiece.getCoordX(i) == curPiece.getCoordX(j)))
    					{
    						otherPiece &= false;
    					}
    				}
    				result |= otherPiece;
    				if(result)
    				{
    					return result;
    				}
    			}
    		}
    		else
    		{
    			return true;
    		}
    	}
		return result;
    }
    
    public boolean gridFilledRight(Shape shape) {
    	curPiece = shape;
    	boolean result = false;
    	
    	for(int i=0; i<4; i++)
    	{
    		if((curPiece.getCoordX(i)+1) < 10)
    		{
    			if(grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)+1] != 0)
    			{	
    				boolean otherPiece = true;
    				for(int j=0; j<4; j++)
    				{
    					if((curPiece.getCoordY(i) == curPiece.getCoordY(j)) && ((curPiece.getCoordX(i)+1) == curPiece.getCoordX(j)))
    					{
    						otherPiece &= false;
    					}
    				}
    				result |= otherPiece;
    				if(result)
    				{
    					return result;
    				}
    			}
    		}
    		else
    		{
    			return true;
    		}
    	}
		return result;
    }
    
    public boolean gridFilledLeft(Shape shape) {
    	curPiece = shape;
    	boolean result = false;
    	
    	for(int i=0; i<4; i++)
    	{
    		if((curPiece.getCoordX(i)-1) >= 0)
    		{
    			if(grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)-1] != 0)
    			{	
    				boolean otherPiece = true;
    				for(int j=0; j<4; j++)
    				{
    					if((curPiece.getCoordY(i) == curPiece.getCoordY(j)) && ((curPiece.getCoordX(i)-1) == curPiece.getCoordX(j)))
    					{
    						otherPiece &= false;
    					}
    				}
    				result |= otherPiece;
    				if(result)
    				{
    					return result;
    				}
    			}
    		}
    		else
    		{
    			return true;
    		}
    	}
		return result;
    }
    
    public boolean isLineFull(int index) {
    	for(int j=0; j<10; j++)
    	{
    		if(grid[index][j] == 0)
			{
				return false;
			}
    	}
    	return true;
    }
    
    public void removeFullLine() {
    	int indice = 19;
    	
    	for(int i=19; i>=0; i--)
    	{
    		if(!isLineFull(i))
    		{
    			if(indice != i)
    			{
    				for(int k=0; k<10; k++)
        			{
        				grid[indice][k] = grid[i][k];
        			}
    			}
    			indice--;
    		}
    	}
    	for(int i=indice; i>=0; i--)
    	{
    		for(int k=0; k<10; k++)
			{
				grid[i][k] = 0;
			}
    	}
    	
    	switch(indice)
    	{
    	case 0:
    		this.score += 100;
    		break;
    	case 1:
    		this.score += 200;
    		break;
    	case 2:
    		this.score += 300;
    		break;
    	case 3:
    		if(this.lastLines == 3)
    		{
    			this.score += 1200;
    		}
    		else
    		{
    			this.score += 800;
    		}
    		break;
    	default:
    		break;
    	}
    	
    	this.removedLines += indice;
    	if(indice >= 0)
    	{
    		this.lastLines = indice;
    	}
    }
    
    public boolean canRotate(Shape shape) {
    	curPiece = shape;
    	
    	int x0 = curPiece.getCoordX(0);
    	int y0 = curPiece.getCoordY(0);
    	boolean result = true;
    	int oldRotation = curPiece.getRotation();
    	int newRotation = 0;

    	newRotation = oldRotation + 1;
    	if(newRotation >= 4)
    	{
    		newRotation = 0;
    	}
    
    	for(int k=0; k<4; k++)
		{
    		if(((x0 + curPiece.getPiece()[newRotation][k][0]) >= 10) || ((x0 + curPiece.getPiece()[newRotation][k][0]) < 0) || 
    			((y0 + curPiece.getPiece()[newRotation][k][1]) >= 20) || ((y0 + curPiece.getPiece()[newRotation][k][1]) < 0))
    		{
    			result = false;
    		}
    		else
    		{
    			for(int i=0; i<4; i++)
    	    	{
	    			if(grid[(y0 + curPiece.getPiece()[newRotation][k][1])][(x0 + curPiece.getPiece()[newRotation][k][0])] != 0)
	    			{	
	    				boolean otherPiece = true;
	    				for(int j=0; j<4; j++)
	    				{
	    					if(((y0 + curPiece.getPiece()[newRotation][k][1]) == curPiece.getCoordY(j)) &&
	    						((x0 + curPiece.getPiece()[newRotation][k][0]) == curPiece.getCoordX(j)))
	    					{
	    						otherPiece &= false;
	    					}
	    				}
	    				result = !otherPiece;
	    				if(!result)
	    				{
	    					return result;
	    				}
	    			}
    	    	}
    		}
		}
    	return result;
    }
}
