package tetrispackage;
import java.util.*;

public class TPiece extends Shape {

    public TPiece() {
    	super();
    	fillPiece();
    }
    
    public void fillPiece() {
    	int[][] tmp = {{0,0,0,0}, {0,0,0,0}, {0,1,0,0}, {1,1,1,0}};
    	this.piece = tmp;
    	
    }	
}
