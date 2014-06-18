package forPockerFoc;
import EventHandler.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;


public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8131808332147849819L;
	//MenuBar
	private JMenuBar menuList;
	//Options
	private JMenu options;
	private JMenuItem logOut;
	private JMenuItem exit;
	//Help
	private JMenu help;
	private JMenuItem rules;
	private JMenuItem hands;
	
	
	
	
	//BorderColors
	private Border blackline  = BorderFactory.createLineBorder(Color.black);
	
	// Images
	private Image mainImage;
	
	//Timer
	private Countdown countdown = new Countdown(120);
	
	//Buttons
	private JTextField timer;
	private final JButton checkButton = new JButton("Check");
	private final JButton callButton = new JButton("Call");
	private final JButton betButton = new JButton("Bet");
	private final JButton raiseButton = new JButton("Raise");
	private final JButton foldButton = new JButton("Fold");
	
	//Other Players at Table max 5
	private final JLabel otherPlayersLabel = new JLabel("Players at Table");
	private JLabel ownPlayerInfo;
	public static JLabel otherPlayer01 = new JLabel();
	public static JLabel otherPlayer02 = new JLabel();
	public static JLabel otherPlayer03 = new JLabel();
	public static JLabel otherPlayer04 = new JLabel();
	public static JLabel otherPlayer05 = new JLabel();
	
	//Panels
	private JPanel buttonPanel;
	private JPanel mainField;
	private JPanel otherPlayersAtTable;
	
	
	
	//TODO abkl��ren wie sichdie PlayerData geholt werden sollen....String und Array in den Kostruktor??
	public MainWindow(){
		super("FOC Poker");
		//get Timer from Class Countdown
		timer = countdown.getTimerIcon();
		
		this.initMenuBar();
		this.initOtherPlayersAtTable();
		this.initButtonPanel();
		this.initMainfield();
		this.init(true);
		
		
		this.setOwnPlayerInfo("my Self" + " " + 250292);
		MainWindow.setOtherPlayer01("Player01" + " " + 1000);
		MainWindow.setOtherPlayer02("Player02" + " " + 1000);
		MainWindow.setOtherPlayer03("Player03" + " " + 1000);
		MainWindow.setOtherPlayer04("Player04" + " " + 1000);
		MainWindow.setOtherPlayer05("Player05" + " " + 1000);
		
	}
	
	
	//Window Attribut
	public void init(boolean windowVisible){
		this.setLayout(new BorderLayout());
		this.add(menuList, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(mainField, BorderLayout.CENTER);
		this.add(otherPlayersAtTable, BorderLayout.EAST);
		this.setSize(1050, 700);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);	
		this.setVisible(windowVisible);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initMenuBar(){
		//MenuBar
		menuList = new JMenuBar();
		//options
		options = new JMenu("Options");
		logOut = new JMenuItem("Log out");
		logOut.setActionCommand("logOut");
		logOut.addActionListener(new MenuBarHandler(this));
		exit = new JMenuItem("Exit");
		exit.setActionCommand("exit");
		exit.addActionListener(new MenuBarHandler(this));
		options.add(logOut);
		options.add(exit);
		//Help
		help = new JMenu("Help");
		rules = new JMenuItem("Game Rules");
		rules.setActionCommand("rules");
		rules.addActionListener(new MenuBarHandler(this));
		hands = new JMenuItem("Hands");
		hands.setActionCommand("hands");
		hands.addActionListener(new MenuBarHandler(this));
		help.add(rules);
		help.add(hands);
		//add to MenuBar
		menuList.add(options);
		menuList.add(help);
	}
		
	private void initOtherPlayersAtTable(){
		ownPlayerInfo = new JLabel();
		otherPlayersAtTable = new JPanel();
		otherPlayersAtTable.setLayout(new GridLayout(7,1));
		otherPlayersAtTable.setBackground(Color.DARK_GRAY);
		otherPlayersAtTable.setSize(400,700);
		//Set Color for otherPlayers Label
		otherPlayersLabel.setForeground(Color.WHITE);
		ownPlayerInfo.setForeground(Color.WHITE);
		otherPlayer01.setForeground(Color.WHITE);
		otherPlayer02.setForeground(Color.WHITE);
		otherPlayer03.setForeground(Color.WHITE);
		otherPlayer04.setForeground(Color.WHITE);
		otherPlayer05.setForeground(Color.WHITE);
		otherPlayersLabel.setFont(new Font("sansserif ", Font.BOLD, 18));
		//Add otherPlayerComponents to otherPlayerInfo(JPanel)
		otherPlayersAtTable.setBorder(blackline);
		otherPlayersAtTable.add(otherPlayersLabel);
		otherPlayersAtTable.add(ownPlayerInfo);
		otherPlayersAtTable.add(otherPlayer01);
		otherPlayersAtTable.add(otherPlayer02);
		otherPlayersAtTable.add(otherPlayer03);
		otherPlayersAtTable.add(otherPlayer04);
		otherPlayersAtTable.add(otherPlayer05);
		
	}
	
	
	private void initMainfield(){
		mainField = new JPanel();
		mainField.setSize(200, 700);
		mainField.setLayout(new FlowLayout());
		mainField.setBackground(Color.DARK_GRAY);
		mainField.setMinimumSize(new Dimension(768, 492));
		mainField.repaint();
	}
	
	private void initButtonPanel(){
		//init ButtonPanel
		//TODO handle Button Size
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setBorder(blackline);
		buttonPanel.setMinimumSize(new Dimension(50, 30));
		checkButton.setMinimumSize(new Dimension(50, 30));
		callButton.setMinimumSize(new Dimension(50, 30));
		betButton.setMinimumSize(new Dimension(50, 30));
		raiseButton.setMinimumSize(new Dimension(50, 30));
		foldButton.setMinimumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		//set ActionCommand for Buttons
		checkButton.setActionCommand("checkButton");
		callButton.setActionCommand("callButton");
		betButton.setActionCommand("betButton");
		raiseButton.setActionCommand("raiseButton");
		foldButton.setActionCommand("foldButton");
		//add ActionListener fpr Button(PlayerActivityHander=>EventHandler)
		checkButton.addActionListener(new PlayerActivityHandler());
		callButton.addActionListener(new PlayerActivityHandler());
		betButton.addActionListener(new PlayerActivityHandler());
		raiseButton.addActionListener(new PlayerActivityHandler());
		foldButton.addActionListener(new PlayerActivityHandler());
		buttonPanel.add(timer);
		buttonPanel.add(checkButton);
		buttonPanel.add(callButton);
		buttonPanel.add(betButton);
		buttonPanel.add(raiseButton);
		buttonPanel.add(foldButton);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		final Toolkit tK = this.getToolkit();
		try {
			mainImage = tK.getImage("/Users/fabianRedecker/Dropbox/Studium FR & CS/Prog2 Projekt/Projektdateien/workspace fabian/Grafics/Image/table_v2.png");
			g.drawImage(mainImage,60,100, this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Image Not Found", "Picture ERROR",JOptionPane.WARNING_MESSAGE);
		}	
	}
	
	//getter + setter fpr own Player information (Jlabel)
	public String getOwnPlayerInfo(){
		String ownPlayer = ownPlayerInfo.getText();
		return ownPlayer;
	}
	
	public void setOwnPlayerInfo(String text){
		ownPlayerInfo.setText(text);
	}
	
	//getter + setter for public static JLabel otherPlayer 01 -05 
	public static String getOtherPlayer01(){
		String otherPlayer01text = otherPlayer01.getText();
		return otherPlayer01text;
	}
	
	public static void setOtherPlayer01(String text){
		otherPlayer01.setText(text);
	}
	
	public static String getOtherPlayer02(){
		String otherPlayer02text = otherPlayer02.getText();
		return otherPlayer02text;
	}
	
	public static void setOtherPlayer02(String text){
		otherPlayer02.setText(text);
	}
	
	public static String getOtherPlayer03(){
		String otherPlayer03text = otherPlayer03.getText();
		return otherPlayer03text;
	}
	
	public static void setOtherPlayer03(String text){
		otherPlayer03.setText(text);
	}
	
	public static String getOtherPlayer04(){
		String otherPlayer04text = otherPlayer04.getText();
		return otherPlayer04text;
	}
	
	public static void setOtherPlayer04(String text){
		otherPlayer04.setText(text);
	}
	
	public static String getOtherPlayer05(){
		String otherPlayer05text = otherPlayer05.getText();
		return otherPlayer05text;
	}
	
	public static void setOtherPlayer05(String text){
		otherPlayer05.setText(text);
	}
	
	public static void main(String[] args) {
		new MainWindow();

	}

}
