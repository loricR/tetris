package tetrispackage;

public class OPiece extends Shape {

    public OPiece() {
    	super();
    	fillPiece();
    	setSpawnCoord();
    	this.color = 3;
    }
    
    public void fillPiece() {
    	int[][][] tmp = {{{0,0}, {1,0}, //The first coordinates are the reference for rotation
						 {0,1}, {1,1}},
			
						{{0,0}, {1,0},
						{0,1}, {1,1}},
					
						{{0,0}, {1,0},
						{0,1}, {1,1}},
			
					    {{0,0}, {1,0}, 
					    {0,1}, {1,1}}};
				
    	this.piece = tmp;  
    }	
    
    public void setSpawnCoord() {
    	int[][] tmp = {{4,0},{5,0},
    				   {4,1},{5,1}};
    	for(int i=0; i<4; i++) {
    		this.coord[i] = tmp[i];
    	}
    }
}
