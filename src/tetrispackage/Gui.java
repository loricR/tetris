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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
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

public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel infoPanel, gamePanel;
	private JPanel[][] gridGui;
	
	public JButton playButton;
	public JRadioButton beginnerLevel;
	public JRadioButton easyLevel;
	public JRadioButton normalLevel;
	public JRadioButton hardLevel;
	public JRadioButton legendLevel;
	
	private JLabel score, highScore, chrono, line;
	private JLabel tScore, tHighScore, tChrono, tLine;
	
	private JPanel menuPanel;
	
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
		contentPane.setLayout(null);
		
		gamePanel = new JPanel();
		gamePanel.setBackground(Color.WHITE);
		
		menuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		menuPanel.setBounds(50, 60, 500, 650);
		contentPane.add(menuPanel);
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		infoPanel.setBounds(400, 129, 100, 200);
		contentPane.add(infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		
		//Play Button
		playButton = new JButton("PLAY !");
		playButton.setBounds(450, 150, 80, 20);
		menuPanel.add(playButton);
		
		//Level selection
		beginnerLevel = new JRadioButton("Beginner");
		beginnerLevel.setBounds(450, 180, 80, 20);
		menuPanel.add(beginnerLevel);
		beginnerLevel.setSelected(true);
		easyLevel = new JRadioButton("Easy");
		easyLevel.setBounds(450, 200, 80, 20);
		menuPanel.add(easyLevel);
		normalLevel = new JRadioButton("Normal");
		normalLevel.setBounds(450, 220, 80, 20);
		menuPanel.add(normalLevel);
		hardLevel = new JRadioButton("Hard");
		hardLevel.setBounds(450, 240, 80, 20);
		menuPanel.add(hardLevel);
		legendLevel = new JRadioButton("Legend");
		legendLevel.setBounds(450, 260, 80, 20);
		menuPanel.add(legendLevel);
		//contentPane.add(gamePanel, BorderLayout.CENTER);
		
		// Displaying
		tChrono = new JLabel("Time");
		chrono = new JLabel("0:0");
		tChrono.setLabelFor(chrono);
		infoPanel.add(tChrono);
		infoPanel.add(chrono);
		tScore = new JLabel("Score");
		score = new JLabel("0");
		tScore.setLabelFor(score);
		infoPanel.add(tScore);
		infoPanel.add(score);
		tLine = new JLabel("Lines");
		line = new JLabel("0");
		tLine.setLabelFor(line);
		infoPanel.add(tLine);
		infoPanel.add(line);
		tHighScore = new JLabel("High score");
		highScore = new JLabel("0");
		tHighScore.setLabelFor(highScore);
		infoPanel.add(tHighScore);
		infoPanel.add(highScore);
		
		
		
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
	
	public void refreshLine(int line) {
		this.line.setText(String.valueOf(line));
	}
	
	public void displayMenu() {
		contentPane.remove(gamePanel);
		contentPane.remove(infoPanel);
		contentPane.add(menuPanel);
		this.repaint();
	}
	
	public void displayGame() {
		contentPane.remove(menuPanel);
		contentPane.add(gamePanel);
		contentPane.add(infoPanel);
		infoPanel.add(playButton);
		playButton.setText("Replay");
		playButton.setEnabled(false);
		this.repaint();
	}

}
