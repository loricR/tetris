package tetrispackage;
import java.util.*;
import java.awt.Color;

public class Grid {
    private int[][] grid;
    private Shape curPiece;

    public Grid() {
    	this.grid = new int[20][10];
    }

    public Grid(int x, int y) {
    }
    
    public int[][] getGrid() {
    	return this.grid;
    }
    
    public Shape getCurPiece() {
    	return this.curPiece;
    }
    
    public boolean isFilled() {
		return false;
    }
    
    public void spawnPiece(Shape shape) {
    	curPiece = shape;
    	
    	for(int i=0; i<4; i++)
    	{
    		grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = curPiece.getColor();
    	}
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
    	
    	for(int i=19; i>0; i--)
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
    		else
    		{
    			for(int k=0; k<10; k++)
    			{
    				
    			}
    		}
    	}
    }
}
