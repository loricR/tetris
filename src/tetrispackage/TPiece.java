package tetrispackage;

public class TPiece extends Shape {

    public TPiece() {
    	super();
    	fillPiece();
    	setSpawnCoord();
    	this.color = 6;
    }
    
    public void fillPiece() {
    	int[][][] tmp = {{{0,0}, //The first coordinates are the reference for rotation
    			   {-1,0}, {0,-1}, {1,0}},
    			
    						{{0,0}, 
    						 {0,-1}, {1,0},
    						 {0,1}},
    			   
			    	{{0,0}, {-1,0}, {1,0},
			    			 {0,1}},
			    	
			    			{{0,0}, 
			    	  {-1,0}, {0,-1},
			    			 {0,1}}};
    	this.piece = tmp;
    }	
    
    public void setSpawnCoord() {
    	int[][] tmp = {		 {4,1}, //The first coordinates are the reference for rotation
				   {3,1},{4,0},{5,1}};
    	for(int i=0; i<4; i++) {
    		this.coord[i] = tmp[i];
    	}
    }
}
