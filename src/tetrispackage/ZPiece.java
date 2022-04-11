package tetrispackage;
import java.util.*;

public class ZPiece extends Shape {

    public ZPiece() {
    	super();
    	fillPiece();
    }
    
    public void fillPiece() {
    	int[][] tmp = {{0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {0,1,1,0}, 
    				   {0,0,1,1}};
    	this.piece = tmp;
    	
    }	

}
