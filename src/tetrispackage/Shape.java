package tetrispackage;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public abstract class Shape {

	protected int[][][] piece;
	protected int[][] coord;
	protected int rotation;
	protected int color;
	
	public abstract void fillPiece();
	public abstract void setSpawnCoord();
	
	public Shape() {
		this.coord = new int[4][2];
		this.rotation = 0;
		this.piece = new int[4][4][2];
	}
	
	public int getColor() {
		return this.color;
	}
	
	public int getRotation() {
		return this.rotation;
	}
	
	public int[][][] getPiece() {
		return this.piece;
	}
	
	public int getCoordX(int index) {
		return this.coord[index][0];
	}
	public int getCoordY(int index) {
		return this.coord[index][1];
	}
	
	public void setCoord(int index, int x, int y) {
		int tmp[] = {x, y};
		this.coord[index] = tmp;
	}

    public void moveRight() {
    	if(!isStuckRight())
		{
	    	for(int i=0; i<4; i++) 
	    	{	
	    		setCoord(i, coord[i][0]+1, coord[i][1]);
	    	}
		}
    }
    
    public void moveLeft() {
    	if(!isStuckLeft())
		{
	    	for(int i=0; i<4; i++) 
	    	{
	    		setCoord(i, coord[i][0]-1, coord[i][1]);
	    	}
		}
    }
    
    public void down() {
    	for(int i=0; i<4; i++) 
    	{
    		setCoord(i, coord[i][0], coord[i][1]+1);	
    	}
    }
    
    public boolean isStuckLeft() {
    	for(int i=0; i<4; i++) 
    	{
	    	if(coord[i][0] <= 0)
			{
				return true;
			}
    	}
    	return false;
    }
    
    public boolean isStuckRight() {
    	for(int i=0; i<4; i++) 
    	{
	    	if(coord[i][0] >= 9)
			{
				return true;
			}
    	}
    	return false;
    }
    
    public boolean isStuckDown() {
    	for(int i=0; i<4; i++) 
    	{
	    	if(coord[i][1] >= 19)
			{
				return true;
			}
    	}
    	return false;
    }
    
    public void rotateClock() {
    	int x0 = this.getCoordX(0);
    	int y0 = this.getCoordY(0);
    	
    	if(this.rotation == 0 || this.rotation == 1 || this.rotation == 2)
    	{
    		this.rotation +=1;
    	}
    	else if(this.rotation == 3)
    	{
    		this.rotation = 0;
    	}
    	
    	for(int i=0; i<4; i++)
		{
    		this.setCoord(i, x0 + piece[rotation][i][0], y0 + piece[rotation][i][1]);
		}
    }
    
    public void rotateAntiClock() {
    	int x0 = this.getCoordX(0);
    	int y0 = this.getCoordY(0);
    	
    	if(this.rotation == 1 || this.rotation == 2 || this.rotation == 3)
    	{
    		this.rotation -=1;
    	}
    	else if(this.rotation == 0)
    	{
    		this.rotation = 3;
    	}
    	
    	for(int i=0; i<4; i++)
		{
    		this.setCoord(i, x0 + piece[rotation][i][0], y0 + piece[rotation][i][1]);
		}
    }
}
