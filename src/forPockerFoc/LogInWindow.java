package forPockerFoc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class LogInWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3289588213035025693L;
	
	// Content
	private JLabel playerNameLabel;
	private JTextField playerNameField;
	private JLabel placeHolder;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton logInButton;
	
	//Label
	private JPanel picPanel;
	private JPanel contentPanel;
	
	// Font
	private Font myFont;
	
	public LogInWindow(){
		super("FOC Poker Log In");
		//init Content
		myFont = new Font("Arial", Font.BOLD, 12);
		playerNameLabel = new JLabel("Playername :");
		playerNameLabel.setFont(myFont);
		playerNameLabel.setForeground(Color.WHITE);
		playerNameField = new JTextField();
		placeHolder = new JLabel();
		placeHolder.setBackground(Color.BLACK);
		placeHolder.setPreferredSize(new Dimension(300,20));
		placeHolder.setOpaque(false);
		passwordLabel = new JLabel("Password :");
		passwordLabel.setFont(myFont);
		passwordLabel.setForeground(Color.WHITE);
		passwordField = new JPasswordField();
		logInButton = new JButton("Log In");
		logInButton.addActionListener(new ButtonListener());
		
		//init Panels
		picPanel = new JPanel();
		picPanel.setBackground(Color.BLACK);
		picPanel.repaint();
		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(6,1));
		contentPanel.setBackground(Color.BLACK);
		contentPanel.add(playerNameLabel);
		contentPanel.add(playerNameField);
		contentPanel.add(placeHolder);
		contentPanel.add(passwordLabel);
		contentPanel.add(passwordField);
		contentPanel.add(logInButton);
		
		init(true);
	}
	
	public void init(boolean windowVisible){
		this.setLayout(new GridLayout(2,1));
		//this.setBackground(Color.BLACK);
		this.setSize(300, 400);
		this.add(picPanel);
		this.add(contentPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(windowVisible);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		final Toolkit tK = this.getToolkit();
		try {
			//Image bild = tK.getImage("/Users/fabianRedecker/Dropbox/Studium FR & CS/Prog2 Projekt/Projektdateien/workspace fabian/Grafics/Image/selectionPic.jpg");
			Image bild = tK.getImage(this.getClass().getResource("/Images/login135x147White.png"));
			g.drawImage(bild,80,60, this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Image Not Found", "Picture ERROR",JOptionPane.WARNING_MESSAGE);
		}	
	}
	
	// ActionListener for logInButton
			class ButtonListener implements ActionListener{
				//Attribute which was signed in from Costumer get by playerNameField & passwordField
				private String playerName;
				private String playerPassword;
				private String PLAYERLIST;
				private boolean playerListFound = false;
				private boolean playerInputOk = false;
				
				//get entered Playername & Password
				@SuppressWarnings("deprecation")
				public void getPlayerData(){
					//counter for playername & password has run
					int controlCounter = 0;
					
					//try get Playername
					try {
						if(! (playerNameField.getText().equals(""))){
							playerName = playerNameField.getText();
							controlCounter++;
						}	
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error in Field Playername", "Input ERROR",JOptionPane.WARNING_MESSAGE);
					}
					
					//try get Player.Password
					try {
						if(! (passwordField.getText().equals(""))){
							playerPassword = passwordField.getText();
							controlCounter++;
						}	
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error in Field Password", "Input ERROR",JOptionPane.WARNING_MESSAGE);
					}
					
					if(controlCounter ==2){
						playerInputOk = true;
					}
				}
				
				
				//get Playerlist.txt
				public void getPlayerList(){
					//init PLAYERLIST by get Playerlist.txt
					try {
						PLAYERLIST = ("/Users/fabianRedecker/Dropbox/Studium FR & CS/Prog2 Projekt/Projektdateien/workspace fabian/Grafics/TestArea/PlayerList.txt");
						playerListFound = true;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "PlayerList Not Found", "List ERROR",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
				// check if name and password is in the Playerlist
				public void checkPlayerData(){
					
					int check = 0;
					try{
						BufferedReader br = new BufferedReader(new FileReader(PLAYERLIST));
		 
		                String sZeile;
		                while ((sZeile = br.readLine()) != null) {
		                    if(sZeile.contains(playerName) && sZeile.contains(playerPassword)){
								new SuccessWindow("Success", "Log in was successful", "OK");
		                    	init(false);
		                    	check++;
		                    	//TODO close window start Game
		                    }
		                    
		                }
		                if(check == 0){
	                    	JOptionPane.showMessageDialog(null, "Log in was not successful please try again!", "Log In ERROR",JOptionPane.WARNING_MESSAGE);
	                    }    
		                br.close();
		            }
		            catch(IOException e1){
		            	JOptionPane.showMessageDialog(null, "Fail while checkPlayerData", "Read Data ERROR",JOptionPane.WARNING_MESSAGE);
		                e1.printStackTrace();
		            }
				}
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					getPlayerData();
					getPlayerList();
					if(playerListFound && playerInputOk){
						checkPlayerData();
					}
				}
			}

}
