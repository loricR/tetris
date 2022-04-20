package tetrispackage;
import java.util.*;
import java.awt.Color;

public class SPiece extends Shape {

    public SPiece() {
    	super();
    	fillPiece();
    	setSpawnCoord();
    	this.color = 4;
    }
    
    public void fillPiece() {
    	int[][][] tmp = {{{0,0}, {-1,0}, //The first coordinates are the reference for rotation
								 {1,-1}, {0,-1}},
					
								{{0,0}, 
					    {0,-1}, {1,0},
						 {1,1}},
					
						{{0,0}, {-1,0},
							    {1,-1}, {0,-1}},
					
								{{0,0}, 
						  {0,-1}, {1,0},
						  {1,1}}};
		this.piece = tmp;   
    }	
    
    public void setSpawnCoord() {
    	int[][] tmp = {{4,1},{5,0},
    				   		 {4,0},{3,1}};
    	for(int i=0; i<4; i++) {
    		this.coord[i] = tmp[i];
    	}
    }

}
