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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComponent.*;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Component;

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
	
	/*private BufferedImage pictureI, pictureJ, pictureL, pictureO, pictureS, pictureZ, pictureT;
	private JLabel[][] picLabel;
	private JLabel emptyLabel, labelI, labelJ, labelL, labelO, labelS, labelZ, labelT;*/

	
	// ---------------------------------------------------------------------------------------------
	public Gui() {
		this.setTitle("TETRIS");
		this.setSize(600,800);
		this.setLocationRelativeTo(null); //Center the frame
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		endPanel = new JPanel();
		//FlowLayout eFlowLayout = (FlowLayout) endPanel.getLayout();
		//eFlowLayout.setAlignment(FlowLayout.CENTER);
		endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
		endPanel.setBounds(300, 60, 200, 80);
		
		panel = new JPanel();
		panel.setBounds(426, 50, 100, 600);
		//panel.setSize(600,800);
		gamePanel = new JPanel();
		gamePanel.setBackground(Color.WHITE);
		
		menuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		menuPanel.setBounds(50, 60, 500, 650);
		contentPane.setLayout(null);
		contentPane.add(menuPanel);
		//contentPane.add(panel);
		//contentPane.add(gamePanel);
		
		
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
		
		//contentPane.add(nextPiecesPanel);
		
		tGameOver = new JLabel("GAME OVER !!");
		gameOver = new JTextArea();
		gameOver.setEnabled(false);
		gameOver.setLineWrap(true);
		//gameOver.setBackground(Color.WHITE);
		//gameOver.setForeground(Color.BLACK);
		gameOver.setDisabledTextColor(Color.BLACK);
		//tGameOver.setLabelFor(gameOver);
		tGameOver.setBorder(new EmptyBorder(0, 0, 20, 0));
		tGameOver.setFont(new Font("Serif", Font.BOLD, 20));
		tGameOver.setBounds(50,0,200,100);
		gameOver.setBounds(10,80,250,100);
		endPanel.setLayout(null);
		endPanel.add(tGameOver);
		endPanel.add(gameOver);
		//endPanel.setLayout(new FlowLayout());;
		//contentPane.add(endPanel);
		
		
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
		
		
		//contentPane.add(gamePanel, BorderLayout.CENTER);
		
		// Displaying
		tChrono = new JLabel("Time");
		chrono = new JLabel("0:0");
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
		/*picLabel = new JLabel[20][10];
		emptyLabel = new JLabel();
		
		try {
			pictureI = ImageIO.read(new File("picture/pictureI.png"));
			pictureJ = ImageIO.read(new File("picture/pictureJ.png"));
			pictureL = ImageIO.read(new File("picture/pictureL.png"));
			pictureO = ImageIO.read(new File("picture/pictureO.png"));
			pictureS = ImageIO.read(new File("picture/pictureS.png"));
			pictureZ = ImageIO.read(new File("picture/pictureZ.png"));
			pictureT = ImageIO.read(new File("picture/pictureT.png"));
			labelI = new JLabel(new ImageIcon(ImageIO.read(new File("picture/pictureI.png"))));
			labelJ = new JLabel(new ImageIcon(ImageIO.read(new File("picture/pictureJ.png"))));
			labelL = new JLabel(new ImageIcon(ImageIO.read(new File("picture/pictureL.png"))));
			labelO = new JLabel(new ImageIcon(ImageIO.read(new File("picture/pictureO.png"))));
			labelS = new JLabel(new ImageIcon(ImageIO.read(new File("picture/pictureS.png"))));
			labelZ = new JLabel(new ImageIcon(ImageIO.read(new File("picture/pictureZ.png"))));
			labelT = new JLabel(new ImageIcon(ImageIO.read(new File("picture/pictureT.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<10; j++)
			{
				gridGui[i][j] = new JPanel();
				gamePanel.add(gridGui[i][j]);
				gridGui[i][j].setBackground(Color.GRAY);
				//picLabel[i][j] = new JLabel();
				//picLabel[i][j].setPreferredSize(new Dimension(25,25));
				//picLabel[i][j].setLayout(null);
				//gridGui[i][j].add("Center", picLabel[i][j]);
				//gamePanel.add(picLabel[i][j]);
				gridGui[i][j].setPreferredSize(new Dimension(25,25));
			}	
		}
		gamePanel.setLayout(new GridLayout(20, 10,1,1));
		gamePanel.setBounds(50, 50, 325, 650);
		
		
	} // ---------------------------------------------------------------------------------------------
	
	
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
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = labelL;
				break;
			case 2:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.ORANGE);
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = labelJ;
				break;
			case 3:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.YELLOW);
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = labelO;
				break;
			case 4:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.GREEN);
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = labelS;
				break;
			case 5:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.RED);
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = labelZ;
				break;
			case 6:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.PINK);
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = labelT;
				break;
			case 7:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.CYAN);
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = labelI;
				break;
			default:
				gridGui[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)].setBackground(Color.WHITE);
				//picLabel[grid.getCurPiece().getCoordY(i)][grid.getCurPiece().getCoordX(i)] = emptyLabel;
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
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.WHITE);
					//picLabel[i][j] = emptyLabel;
					break;
				case 1:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.BLUE);
					//picLabel[i][j] = labelL;
					//gridGui[i][j].add(picLabel[i][j]);
					break;
				case 2:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.ORANGE);
					//picLabel[i][j] = labelJ;
					//gridGui[i][j].add(picLabel[i][j]);
					break;
				case 3:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.YELLOW);
					//picLabel[i][j] = labelO;
					//gridGui[i][j].add(picLabel[i][j]);
					break;
				case 4:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.GREEN);
					//picLabel[i][j] = labelS;
					//gridGui[i][j].add(picLabel[i][j]);
					break;
				case 5:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.RED);
					//picLabel[i][j] = labelZ;
					//gridGui[i][j].add(picLabel[i][j]);
					break;
				case 6:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.PINK);
					//picLabel[i][j] = labelT;
					//gridGui[i][j].add(picLabel[i][j]);
					break;
				case 7:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.CYAN);
					//picLabel[i][j] = labelI;
					//gridGui[i][j].add(picLabel[i][j]);
					break;
				default:
					//gridGui[i][j].remove(picLabel[i][j]);
					gridGui[i][j].setBackground(Color.WHITE);
					//picLabel[i][j] = emptyLabel;
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
		this.chrono.setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));
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
		
		//this.level.setText(String.valueOf(level));
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
		//contentPane.remove(gamePanel);
		//contentPane.remove(infoPanel);
		//contentPane.remove(nextPiecesPanel);
		contentPane.removeAll();
		contentPane.add(menuPanel);
		this.repaint();
	}
	
	public void displayGame() {
		//contentPane.remove(menuPanel);
		contentPane.removeAll();
		//contentPane.add(infoPanel);
		//contentPane.add(nextPiecesPanel);
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


