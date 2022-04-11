package tetrispackage;
import java.util.*;
import javax.swing.*;

public abstract class Shape {

	protected int[][] piece;
	private int positionX;
	private int positionY;
	
	public abstract void fillPiece();
	
	public Shape() {
		this.piece = new int[4][4];
	}
	
	public int[][] getPiece() {
		return this.piece;
	}
	
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	public void setPositionY(int y) {
		this.positionY = y;
	}
	
    public void rotate() {
    }

    public void move() {
    }
    
    public void down() {
    	position++;
    }
    

}
