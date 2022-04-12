package tetrispackage;
import java.util.*;

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
    public boolean isFilled() {
		return false;
    }
    
    public void spawnPiece(Shape shape) {
    	curPiece = shape;
    	
    	for(int i=0; i<2; i++) 
    	{
    		for(int j=0; j<4; j++)
    		{
    			grid[i][j+3] = curPiece.piece[i+2][j]; //On met les deux lignes du bas dans la grille
    		}
    	}
    }
    
    public void refreshPosition(Shape shape) {
    	curPiece = shape;
    	for(int i=0; i<4; i++) {
    		grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = 0; //On efface l'ancienne position de la piece
    	}
    	curPiece.down();
    	curPiece.moveLeft();
    	for(int i=0; i<4; i++) {
        	grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = 1; //On remplace la piece aux nouvelles coordonnées
    	}
    	
    }
}
