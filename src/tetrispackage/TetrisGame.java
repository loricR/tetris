package tetrispackage;
import java.util.*;
//import java.awt.*;
import javax.swing.*;

public class TetrisGame extends JFrame{
	
	private Levels level;
		
	public static void main(String[] args) {
		
		
		Grid grid = new Grid();
		
		Shape shape = new ZPiece();
		System.out.println(shape.piece);
		for (int i = 0;i < shape.piece.length; i++) {
	         for (int j = 0;j < shape.piece[i].length;j++) {
	            //grid.getGrid()[i][j] = i + j;
	            System.out.print(shape.piece[i][j] + " ");
	         }
	         System.out.println();
	      }
		grid.spawnPiece(shape);
		for (int i = 0;i < grid.getGrid().length; i++) {
	         for (int j = 0;j < grid.getGrid()[i].length;j++) {
	            //grid.getGrid()[i][j] = i + j;
	            System.out.print(grid.getGrid()[i][j] + " ");
	         }
	         System.out.println();
	      }
		
		
		
		//Tests pour l'affichage graphique :
		Window graph = new Window();
		
		
		
		}
	
}
