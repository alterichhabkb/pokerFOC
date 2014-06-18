package forPockerFoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class SignInWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 32391333288742727L;
	
	//Color for JComponents
	private Color transparent = new Color(0,0,0,0);
	private Font myFont = new Font("Arial", Font.BOLD, 12);
	
	
	//Player Attribute
	private int id = 0;
	private String name;
	private final int chipNumber = 2500;
	private String password;
	
	//Window Attribute
	private JLabel playerNameLabel = new JLabel("Player Name:");
	private JTextField playerNameField = new JTextField();
	private JLabel placeHolder = new JLabel();
	private JLabel passwordLabel = new JLabel("Password:");
	private JPasswordField passwordField = new JPasswordField();
	private JLabel passwordLabelRepeat = new JLabel("Please Repeat Password");
	private JPasswordField passwordFieldRepeat = new JPasswordField();
	private JLabel placeHolder2 = new JLabel();
	private JButton createButton = new JButton("Create new Account");
	
	//Content Panel
	private JPanel content = new JPanel();
	
	//Constructor
	public SignInWindow(){
		super("Sign In, enjoy FOC Poker");
		this.id++;
		this.setJComponentTransparent();
		this.fillPanel();
		createButton.addActionListener(new ButtonListener());
		this.init(true);
	}
	
	// Style and WindowOption
		public void init(boolean windowVisible){
			
			this.add(content);
			this.setSize(300, 400);
			this.setLocationRelativeTo(null);
			this.setVisible(windowVisible);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		//Add JComponents to JPanel(GridLayout)
		private void fillPanel(){
			content.setLayout(new GridLayout(9,1));
			content.setBackground(Color.BLACK);
			content.add(playerNameLabel);
			content.add(playerNameField);
			content.add(placeHolder);
			content.add(passwordLabel);
			content.add(passwordField);
			content.add(passwordLabelRepeat);
			content.add(passwordFieldRepeat);
			content.add(placeHolder2);
			content.add(createButton);	
		}
		
		//Design JComponents
		private void setJComponentTransparent(){
			this.playerNameLabel.setBackground(transparent);
			this.playerNameLabel.setFont(myFont);
			this.playerNameLabel.setForeground(Color.WHITE);
			this.playerNameField.setBackground(Color.WHITE);
			this.placeHolder.setBackground(transparent);
			this.passwordLabel.setBackground(Color.WHITE);
			this.passwordLabel.setFont(myFont);
			this.passwordLabel.setForeground(Color.WHITE);
			this.passwordField.setBackground(Color.WHITE);
			this.passwordLabelRepeat.setBackground(transparent);
			this.passwordLabelRepeat.setFont(myFont);
			this.passwordLabelRepeat.setForeground(Color.WHITE);
			this.passwordFieldRepeat.setBackground(Color.WHITE);
			this.placeHolder2.setBackground(transparent);
		}
		
		// write in a .txt
		public void writeIn(){
			@SuppressWarnings("unused")
			String stringId = null;
			String stringChipNumber = null;
			
			try {
				stringId = String.valueOf(id);
				stringChipNumber = String.valueOf(chipNumber);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "StingId or StringChipNumber was not able to parse", "Parse Error",JOptionPane.WARNING_MESSAGE);
			}
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/fabianRedecker/Dropbox/Studium FR & CS/Prog2 Projekt/Projektdateien/workspace fabian/Grafics/TestArea/PlayerList.txt", true));
				bw.write(name + ";" + stringChipNumber + ";" + password);
				bw.newLine();
				bw.close();
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(null, "Error while Writing to .txt", "Writing Error",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
				@SuppressWarnings("unused")
				SelectionWindow sw = new SelectionWindow();
				e2.printStackTrace();
			}
		
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getPassword() {
			return password;
		}

		
		// ActionListener for createButton
		class ButtonListener implements ActionListener{
			int controlCounter = 0;
			
			@SuppressWarnings("deprecation")
			public void checkPlayerInput(){
				//check if a name was signed in playerNameField
				if(! (playerNameField.getText().equals(""))){
					name = playerNameField.getText();
					controlCounter++;
				}else{
					JOptionPane.showMessageDialog(null, "Input Error in Playername", "Input Error",JOptionPane.WARNING_MESSAGE);
					repaint();	
				}
				
				//Check if password equal with passwordRepeat
				if (! (passwordField.getText().equals(passwordFieldRepeat.getText()))){
					JOptionPane.showMessageDialog(null, "The Passwords do not equals!", "Input Error",JOptionPane.WARNING_MESSAGE);
					controlCounter = -1;
					repaint();	
				}
				
				//Check if a password was signed in passwordField
				if(! (passwordField.getText().equals(""))){
					password = passwordField.getText();
					controlCounter++;
				}else{
					JOptionPane.showMessageDialog(null, "Input Error in Password", "Input Error",JOptionPane.WARNING_MESSAGE);
					controlCounter = -1;
					repaint();		
				}
			}
			
			public boolean playerNamePossible(String playername){
				String file = ("/Users/fabianRedecker/Dropbox/Studium FR & CS/Prog2 Projekt/Projektdateien/workspace fabian/Grafics/TestArea/PlayerList.txt");
				String row;
				String [] split = new String[1];
			    ArrayList<String> playerNameList = new ArrayList<String>();
			    int playerFoundCounter = 0;
				
			    //read in Playerdata an split after Playername
			    try {
					BufferedReader br = new BufferedReader(new FileReader(file));
		
					while ((row = br.readLine()) != null) {
						split = row.split(";"); // Auslesen der Textdatei, Zeilenumbruch erfolgt nach jedem ";"
					    	for (int i = 0; i < split.length; i++) {
					    		playerNameList.add(split[i]);
					    	}
					    }
					    
					// Stream wird geschlossen
					br.close();
				} catch (Exception e) {
					System.err.println("ERROR while reading txtFile");
				}
			    
			    //check if playername(param) ist allready in the list if yes playerFoundCounter++
			    for (int i=0; i< playerNameList.size(); i++){
			    	if(playerNameList.get(i).equals(playername)){
			    		playerFoundCounter++;
			    	}
			    }
				
			    if(playerFoundCounter == 0){
			    	return true;
			    }else{
			    	JOptionPane.showMessageDialog(null, "The Playername is not available", "Playername ERROR",JOptionPane.WARNING_MESSAGE);
			    	repaint();
			    	return false;
			    }	    
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkPlayerInput();
				// if Name and (Password & passwordFieldRepeat) && PlayerName is available was correct signed in Write in a list
				if(controlCounter >= 2 && playerNamePossible(name)){
					writeIn();
					@SuppressWarnings("unused")
					SuccessWindow sw = new SuccessWindow("Success", "You have been registered by FOC Pocker", "OK");
					init(false);
				}	
			}
		}		
}
