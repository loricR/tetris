package tetrispackage;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;


public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel panel, infoPanel, gamePanel;
	private JPanel[][] gridGui;
	
	private JPanel nextPiecesPanel;
	private JPanel[][] nextPiecesGui;
	
	private JLabel textMenu;
	public JButton playButton;
	public JButton pauseButton;
	public JRadioButton beginnerLevel;
	public JRadioButton easyLevel;
	public JRadioButton normalLevel;
	public JRadioButton hardLevel;
	public JRadioButton legendLevel;
	
	private JLabel score, highScore, chrono, line, level;
	private JLabel tScore, tHighScore, tChrono, tLine, tLevel;
	private JLabel tGameOver; 
	private JTextArea gameOver;
	
	private JPanel menuPanel, endPanel;
	

	public Gui() {
		this.setTitle("TETRIS");
		this.setSize(600,800);
		this.setLocationRelativeTo(null); //Center the frame
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		endPanel = new JPanel();
		endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
		endPanel.setBounds(300, 60, 200, 80);
		
		panel = new JPanel();
		panel.setBounds(426, 50, 100, 600);
		gamePanel = new JPanel();
		gamePanel.setBackground(Color.WHITE);
		
		menuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		menuPanel.setBounds(50, 60, 500, 650);
		contentPane.setLayout(null);
		contentPane.add(menuPanel);
		
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		
		nextPiecesPanel = new JPanel();
		nextPiecesPanel.setBorder(new EmptyBorder(0, 0, 50, 0));
		nextPiecesGui = new JPanel[12][4];
		nextPiecesPanel.setLayout(new GridLayout(12, 4,1,1));
		for(int i=0; i<12; i++)
		{
			for(int j=0; j<4; j++)
			{
				nextPiecesGui[i][j] = new JPanel();
				nextPiecesPanel.add(nextPiecesGui[i][j]);
				nextPiecesGui[i][j].setBackground(Color.GRAY);
				nextPiecesGui[i][j].setPreferredSize(new Dimension(25,30));
			}	
		}
		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(nextPiecesPanel);
		panel.add(infoPanel);
				
		tGameOver = new JLabel("GAME OVER !!");
		gameOver = new JTextArea();
		gameOver.setEnabled(false);
		gameOver.setLineWrap(true);
		gameOver.setDisabledTextColor(Color.BLACK);
		tGameOver.setBorder(new EmptyBorder(0, 0, 20, 0));
		tGameOver.setFont(new Font("Serif", Font.BOLD, 20));
		tGameOver.setBounds(80,0,200,100);
		gameOver.setBounds(10,80,280,100);
		endPanel.setLayout(null);
		endPanel.add(tGameOver);
		endPanel.add(gameOver);		
		
		//Text menu
		textMenu = new JLabel("<html>Please choose a starting level <br> !!! This level will increase during the game !!!</html>");
		textMenu.setHorizontalAlignment(SwingConstants.CENTER);
		textMenu.setBounds(0, -150, 500, 500);
		
		//Play Button
		playButton = new JButton("PLAY !");
		playButton.setBounds(200, 400, 80, 20);
		
		//Level selection
		beginnerLevel = new JRadioButton("Beginner");
		beginnerLevel.setBounds(200, 180, 80, 20);
		beginnerLevel.setSelected(true);
		easyLevel = new JRadioButton("Easy");
		easyLevel.setBounds(200, 210, 80, 20);
		normalLevel = new JRadioButton("Normal");
		normalLevel.setBounds(200, 240, 80, 20);
		hardLevel = new JRadioButton("Hard");
		hardLevel.setBounds(200, 270, 80, 20);
		legendLevel = new JRadioButton("Legend");
		legendLevel.setBounds(200, 300, 80, 20);
		
		menuPanel.setLayout(null);
		menuPanel.add(textMenu);
		menuPanel.add(playButton);
		menuPanel.add(beginnerLevel);
		menuPanel.add(easyLevel);
		menuPanel.add(normalLevel);
		menuPanel.add(hardLevel);
		menuPanel.add(legendLevel);
		
				
		// Displaying
		tChrono = new JLabel("Time");
		chrono = new JLabel("00:00");
		tChrono.setLabelFor(chrono);
		infoPanel.add(tChrono);
		infoPanel.add(chrono);
		infoPanel.add(new JLabel(" "));
		tLevel = new JLabel("Level");
		level = new JLabel("0");
		tLevel.setLabelFor(level);
		infoPanel.add(tLevel);
		infoPanel.add(level);
		infoPanel.add(new JLabel(" "));
		tScore = new JLabel("Score");
		score = new JLabel("0");
		tScore.setLabelFor(score);
		infoPanel.add(tScore);
		infoPanel.add(score);
		infoPanel.add(new JLabel(" "));
		tLine = new JLabel("Lines");
		line = new JLabel("0");
		tLine.setLabelFor(line);
		infoPanel.add(tLine);
		infoPanel.add(line);
		infoPanel.add(new JLabel(" "));
		tHighScore = new JLabel("High score");
		highScore = new JLabel("0");
		tHighScore.setLabelFor(highScore);
		infoPanel.add(tHighScore);
		infoPanel.add(highScore);
		infoPanel.add(new JLabel(" "));
		pauseButton = new JButton("Pause");
		pauseButton.setEnabled(false);
		infoPanel.add(pauseButton);
		
		
		
		gridGui = new JPanel[20][10];
		
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<10; j++)
			{
				gridGui[i][j] = new JPanel();
				gamePanel.add(gridGui[i][j]);
				gridGui[i][j].setBackground(Color.GRAY);
				gridGui[i][j].setPreferredSize(new Dimension(25,25));
			}	
		}
		gamePanel.setLayout(new GridLayout(20, 10,1,1));
		gamePanel.setBounds(50, 50, 325, 650);
		
		
	}
	
	
	public void refreshPiecePosition(Grid grid) {
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<10; j++)
			{		nextPiecesPanel.setBounds(425, 400, 100, 300);
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
	} 
	
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
		this.score.setText(String.valueOf(refScore));
		this.highScore.setText(String.valueOf(refHighScore));
	}// ---------------------------------------------------------------------------------------------
	
	public void refreshTime(int minutes, float seconds) {
		this.chrono.setText(String.format("%02d:%04.1f", minutes, seconds));
	}// ---------------------------------------------------------------------------------------------
	
	public void refreshLevel(int level) {
		switch(level) {
		case 1 :
			this.level.setText(String.valueOf(level) + " (beginner)");
			break;
		case 2 :
			this.level.setText(String.valueOf(level) + " (beginner)");
			break;
		case 3 :
			this.level.setText(String.valueOf(level) + " (easy)");
			break;
		case 4 :
			this.level.setText(String.valueOf(level) + " (easy)");
			break;
		case 5 :
			this.level.setText(String.valueOf(level) + " (normal)");
			break;
		case 6 :
			this.level.setText(String.valueOf(level) + " (normal)");
			break;
		case 7 :
			this.level.setText(String.valueOf(level) + " (normal)");
			break;
		case 8 :
			this.level.setText(String.valueOf(level) + " (hard)");
			break;
		case 9 :
			this.level.setText(String.valueOf(level) + " (hard)");
			break;
		case 10 :
			this.level.setText(String.valueOf(level) + " (legend)");
			break;
		
		}		
	}
	
	public void refreshLine(int line) {
		this.line.setText(String.valueOf(line));
	}
	
	public void refreshNextPiece(ArrayList<Shape> nextPiece) {
		Color color;
		
		for(int i=0; i<12; i++)
		{
			for(int j=0; j<4; j++)
			{
				nextPiecesGui[i][j].setBackground(Color.WHITE);
			}	
		}
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<4; j++)
	    	{
				switch(nextPiece.get(i).getColor())
				{
				case 0:
					color = Color.WHITE;
					break;
				case 1:
					color = Color.BLUE;
					break;
				case 2:
					color = Color.ORANGE;
					break;
				case 3:
					color = Color.YELLOW;
					break;
				case 4:
					color = Color.GREEN;
					break;
				case 5:
					color = Color.RED;
					break;
				case 6:
					color = Color.PINK;
					break;
				case 7:
					color = Color.CYAN;
					break;
				default:
					color = Color.WHITE;
					break;
				}	
	    		nextPiecesGui[(nextPiece.get(i).getCoordY(j)+i*4)+1][nextPiece.get(i).getCoordX(j)-3].setBackground(color);
	    	}
		}
	}
	
	public void displayMenu() {
		contentPane.removeAll();
		contentPane.add(menuPanel);
		this.repaint();
	}
	
	public void displayGame() {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.add(gamePanel);
		infoPanel.add(playButton);
		playButton.setText("Replay");
		playButton.setEnabled(false);
		this.repaint();
	}
	
	public void displayGameOver(String text) {
		contentPane.removeAll();
		endPanel.setBounds(80,100,300,200);
		endPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(endPanel);
		gameOver.setText(text);
		contentPane.add(gamePanel);
		contentPane.add(panel);
		infoPanel.add(playButton);
		playButton.setText("Replay");
		playButton.setEnabled(true);
		this.repaint();
	}
	
	public void pauseGui() {
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<10; j++)
			{		
				gridGui[i][j].setBackground(Color.GRAY);	
			}
		}
	}
	

}