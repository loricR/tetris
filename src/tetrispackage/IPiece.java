package tetrispackage;
import java.util.*;

public class IPiece extends Shape {
    
    public IPiece() {
    	super();
    	fillPiece();
    	setSpawnCoord();
    }

    public void fillPiece() {
    	int[][][] tmp = {{{0,0}, {-1,0}, {1,0}, {2,0}}, //The first coordinates are the reference for rotation
						  
						{{0,0}, {0,-1}, {0,1}, {0,2}},
						
						{{0,0}, {-1,0}, {1,0}, {2,0}},
			
					    {{0,0}, {0,-1}, {0,1}, {0,2}}};
    	this.piece = tmp; 
    }	
    
    public void setSpawnCoord() {
    	int[][] tmp = {{4,1},{3,1},{5,1},{6,1}};
    	for(int i=0; i<4; i++) {
    		this.coord[i] = tmp[i];
    	}
    }
}
