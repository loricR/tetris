package tetrispackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel[][] gridGui;
	
	private JButton playButton;
	private JRadioButton beginnerLevel;
	private JRadioButton easyLevel;

	public Gui() {
		this.setTitle("TETRIS");
		this.setSize(600,800);
		this.setLocationRelativeTo(null); //Center the frame
		this.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		playButton = new JButton("PLAY !");
		//contentPane.add(playButton)
		beginnerLevel = new JRadioButton("Beginner");
		//contentPane.add(beginnerLevel);
		easyLevel = new JRadioButton("Easy");
		//contentPane.add(easyLevel);
		
		
		gridGui = new JPanel[20][10];
		
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<10; j++)
			{
				gridGui[i][j] = new JPanel();
				panel.add(gridGui[i][j]);
				gridGui[i][j].setBackground(Color.GRAY);
				gridGui[i][j].setPreferredSize(new Dimension(25,25));
			}	
		}
		panel.setLayout(new GridLayout(20, 10,1,1));
	}
	
	public void refreshGridGui(Grid grid) {
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<10; j++)
			{
				if(grid.getGrid()[i][j] == 0)
				{
					gridGui[i][j].setBackground(Color.WHITE);
				}		
			}
		}
		
		for(int i=0; i<4; i++)
		{
			gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(grid.getCurPiece().getColor());
		}
	}

}
