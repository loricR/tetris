package tetrispackage;
import java.util.*;

public class JPiece extends Shape {

    public JPiece() {
    	super();
    	fillPiece();
    }
    
    public void fillPiece() {
    	int[][] tmp = {{0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {1,0,0,0}, 
    				   {1,1,1,0}};
    	this.piece = tmp;
    	
    }	
}
