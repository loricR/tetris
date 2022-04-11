package tetrispackage;
import java.util.*;

public class IPiece extends Shape {
    
    public IPiece() {
    	super();
    	fillPiece();
    }

    public void fillPiece() {
    	int[][] tmp = {{0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {0,0,0,0}, 
    				   {1,1,1,1}};
    	this.piece = tmp;
    	
    }	
}
