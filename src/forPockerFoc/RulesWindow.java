package forPockerFoc;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import domain.Eingabe;

public class RulesWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2248538888699109440L;
	
	private JScrollPane contentPanel;
	private final JTextArea gameRules;
	private final FlowLayout rulesWindowLayout;
	private String gameRulesText;
	
	public RulesWindow(){
		
		//get GameRules from a .txt
		try {
			gameRulesText = "";
		} catch (Exception e) {
			System.err.println("ERROR! cant get GameRulesText please add correct part!");
			gameRulesText= Eingabe.readString();
		}
		//init TextArea
		gameRules = new JTextArea(gameRulesText);
		//init  JScrollPane with textArea(gameRules) as param
		contentPanel = new JScrollPane(gameRules);
		
		
		rulesWindowLayout = new FlowLayout();
		rulesWindowLayout.setAlignment(FlowLayout.CENTER);
		this.setLayout(rulesWindowLayout);
		this.add(contentPanel);
		this.setSize(600, 700);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new RulesWindow();
	}

}
