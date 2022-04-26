package tetrispackage;

import java.awt.BorderLayout;
import javax.swing.JLabel;
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
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComponent.*;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel[][] gridGui;
	
	public JButton playButton;
	public JButton pauseButton;
	public JRadioButton beginnerLevel;
	public JRadioButton easyLevel;
	public JRadioButton normalLevel;
	public JRadioButton hardLevel;
	public JRadioButton legendLevel;
	
	private JLabel score;
	private JLabel highScore;
	private JLabel chrono;

	
	// ---------------------------------------------------------------------------------------------
	public Gui() {
		this.setTitle("TETRIS");
		this.setSize(600,800);
		this.setLocationRelativeTo(null); //Center the frame
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		//Play & Pause Buttons
		playButton = new JButton("PLAY !");
		playButton.setBounds(450, 150, 80, 20);
		contentPane.add(playButton);
		pauseButton = new JButton("Pause");
		pauseButton.setBounds(450, 300, 80, 20);
		pauseButton.setEnabled(false);
		contentPane.add(pauseButton);
		
		
		//Level selection
		beginnerLevel = new JRadioButton("Beginner");
		beginnerLevel.setBounds(450, 180, 80, 20);
		contentPane.add(beginnerLevel);
		beginnerLevel.setSelected(true);
		easyLevel = new JRadioButton("Easy");
		easyLevel.setBounds(450, 200, 80, 20);
		contentPane.add(easyLevel);
		normalLevel = new JRadioButton("Normal");
		normalLevel.setBounds(450, 220, 80, 20);
		contentPane.add(normalLevel);
		hardLevel = new JRadioButton("Hard");
		hardLevel.setBounds(450, 240, 80, 20);
		contentPane.add(hardLevel);
		legendLevel = new JRadioButton("Legend");
		legendLevel.setBounds(450, 260, 80, 20);
		contentPane.add(legendLevel);
		
		// Displaying
		score = new JLabel("Score : 0");
		score.setBounds(400, 50, 100, 30);
		contentPane.add(score);
		highScore = new JLabel("High score : 0");
		highScore.setBounds(400, 70, 100, 30);
		contentPane.add(highScore);
		chrono = new JLabel("Chrono : 0:0");
		chrono.setBounds(400, 90, 100, 30);
		contentPane.add(chrono);
		
		
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
		panel.setBounds(50, 50, 325, 650);
	} // ---------------------------------------------------------------------------------------------
	
	
	public void refreshPiecePosition(Grid grid) {
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
			switch(grid.getCurPiece().getColor())
			{
			case 1:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.BLUE);
				break;
			case 2:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.ORANGE);
				break;
			case 3:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.YELLOW);
				break;
			case 4:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.GREEN);
				break;
			case 5:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.RED);
				break;
			case 6:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.PINK);
				break;
			case 7:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.CYAN);
				break;
			default:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.WHITE);
				break;
			}
		}
	}  // ---------------------------------------------------------------------------------------------
	
	
	public void refreshGridGui(Grid grid) {
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<10; j++)
			{
				switch(grid.getGrid()[i][j])
				{
				case 0:
					gridGui[i][j].setBackground(Color.WHITE);
					break;
				case 1:
					gridGui[i][j].setBackground(Color.BLUE);
					break;
				case 2:
					gridGui[i][j].setBackground(Color.ORANGE);
					break;
				case 3:
					gridGui[i][j].setBackground(Color.YELLOW);
					break;
				case 4:
					gridGui[i][j].setBackground(Color.GREEN);
					break;
				case 5:
					gridGui[i][j].setBackground(Color.RED);
					break;
				case 6:
					gridGui[i][j].setBackground(Color.PINK);
					break;
				case 7:
					gridGui[i][j].setBackground(Color.CYAN);
					break;
				default:
					gridGui[i][j].setBackground(Color.WHITE);
					break;
				}	
			}
		}
			
	} // ---------------------------------------------------------------------------------------------
	
	
	public void refreshScore(int refScore, int refHighScore) {
		this.score.setText("Score : " + String.valueOf(refScore));
		this.highScore.setText("High score : " + String.valueOf(refHighScore));
	}// ---------------------------------------------------------------------------------------------
	
	public void refreshTime(int minutes, float seconds) {
		this.chrono.setText("Chrono : " + String.valueOf(minutes) + ":" + String.valueOf(seconds));
	}// ---------------------------------------------------------------------------------------------
	

}
