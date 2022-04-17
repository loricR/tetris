package tetrispackage;
import java.awt.Color;
import java.util.*;

public class ZPiece extends Shape {

    public ZPiece() {
    	super();
    	fillPiece();
    	setSpawnCoord();
    	this.color = Color.RED;
    }
    
    public void fillPiece() {
    	int[][][] tmp = {{{0,0}, {0,-1}, //The first coordinates are the reference for rotation
			    				 {-1,-1}, {1,0}},
			
								{{0,0}, 
					     {0,1}, {1,-1},
						 {1,0}},
			   
						{{0,0}, {0,-1},
			    			    {-1,-1}, {1,0}},
		    	
								{{0,0}, 
			    		  {0,1}, {1,-1},
						  {1,0}}};
    	this.piece = tmp;    	
    }
    
    public void setSpawnCoord() {
    	int[][] tmp = {{4,1},{4,0}, //The first coordinates are the reference for rotation
    				   		 {3,0},{5,1}};
    	for(int i=0; i<4; i++) 
    	{
    		this.coord[i] = tmp[i];
    	}
    }

}
