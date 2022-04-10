package tetrispackage;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TetrisGame extends JFrame{
	
	private Levels level;
	
	public void afficherFenetre() {
		JFrame window = new JFrame();
		window.setSize(600,800);
		window.setVisible(true);
		Container c = this.getContentPane();
	}
	
	public static void main(String[] args) {
		Grid grid = new Grid();
		for(int i=0; i<10; i++) {
			for(int j=0; j<20; j++) {
				System.out.println(grid.getGrid()[i][j]);
			}
		}
		TetrisGame monJeu = new TetrisGame();
		monJeu.afficherFenetre();
	}
	
}
