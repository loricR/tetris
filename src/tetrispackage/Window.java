package tetrispackage;

import java.util.*;
import javax.swing.*;

public class Window extends JFrame {
	
	private int height;
	private int width;
	private JPanel pan = new JPanel();
	private JButton b1 = new JButton("test");
	
	public Window() {
		this.setTitle("Tetrisssssssss");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,800);
		pan.add(b1);
		this.setContentPane(pan);
		this.setVisible(true);
	}

	
	
	
	
}
