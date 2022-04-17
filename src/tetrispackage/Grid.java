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
    		grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = 1;
    	}
    }
    
    public void refreshPosition(Shape shape) {
    	curPiece = shape;
    	for(int i=0; i<4; i++) {
    		grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = 0; //On efface l'ancienne position de la piece
    	}
    	curPiece.down();
    	curPiece.moveLeft();
    	//curPiece.rotate();
    	for(int i=0; i<4; i++) {
        	grid[curPiece.getCoordY(i)][curPiece.getCoordX(i)] = 1; //On remplace la piece aux nouvelles coordonnées
    	}
    	
    }
}
