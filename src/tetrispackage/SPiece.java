package tetrispackage;
import java.util.*;

public class SPiece extends Shape {

    public SPiece() {
    	super();
    	fillPiece();
    }
    
    public void fillPiece() {
    	int[][] tmp = {{0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {0,1,1,0}, 
    				   {1,1,0,0}};
    	this.piece = tmp;
    	
    }	

}
