package tetrispackage;
import java.util.*;

public class Grid {
    private int[][] grid;

    public Grid() {
    	this.grid = new int[20][10];
    }

    public Grid(int x, int y) {
    }
    
    public int[][] getGrid() {
    	return this.grid;
    }
    public boolean isFilled() {
		return false;
    }
    
    public void spawnPiece(Shape shape) {
    	for(int i=0; i<2; i++) 
    	{
    		for(int j=0; j<4; j++)
    		{
    			grid[i][j+3] = shape.piece[i+2][j]; //On met les deux lignes du bas dans la grille
    		}
    	}
    	shape.setPositionX(5);
    	shape.setPositionY(2);
    }
    
    public void refreshPosition(Shape shape) {
    	
    }
}
