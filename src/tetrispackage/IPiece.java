package tetrispackage;
import java.util.*;

public class IPiece extends Shape {
    
    public IPiece() {
    	super();
    	fillPiece();
    	setSpawnCoord();
    }

    public void fillPiece() {
    	int[][] tmp = {{0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {1,1,1,1}};
    	this.piece = tmp;
    }	
    
    public void setSpawnCoord() {
    	int[][] tmp = {{3,1},
    				   {4,1},
    				   {5,1},
    				   {6,1}};
    	for(int i=0; i<4; i++) {
    		this.coord[i] = tmp[i];
    	}
    }
    
    public void rotate() {
    }
}
