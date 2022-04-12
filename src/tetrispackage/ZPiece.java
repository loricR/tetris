package tetrispackage;
import java.util.*;

public class ZPiece extends Shape {

    public ZPiece() {
    	super();
    	fillPiece();
    	setSpawnCoord();
    }
    
    public void fillPiece() {
    	int[][] tmp = {{0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {0,1,1,0}, 
    				   {0,0,1,1}};
    	this.piece = tmp;
    	
    }
    
    public void setSpawnCoord() {
    	int[][] tmp = {{4,0},
    				   {5,0},
    				   {5,1},
    				   {6,1}};
    	for(int i=0; i<4; i++) {
    		this.coord[i] = tmp[i];
    	}
    }

}
