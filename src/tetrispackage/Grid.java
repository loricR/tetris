package tetrispackage;
import java.util.*;

public class Grid {
    public int[][] grid;

    public Grid() {
    	grid = new int[10][20];
    }

    public Grid(int x, int y) {
    }
    
    public int[][] getGrid() {
    	return this.grid;
    }
    public boolean isFilled() {
		return false;
    }
}
