package forPockerFoc;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import domain.Eingabe;

public class HandsWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7752538228392116434L;
	
	private JScrollPane contentPanel;
	private final JTextArea handsTextArea;
	private final FlowLayout handsWindowLayout;
	private String handsText;
	
	public HandsWindow(){
		
		//get Hands from a .txt
		try {
			handsText = "";
		} catch (Exception e) {
			System.err.println("ERROR! cant get GameRulesText please add correct part!");
			handsText= Eingabe.readString();
		}
		
		//init TextArea withe String HandsText
		handsTextArea = new JTextArea(handsText);
		//init  JScrollPane with textArea(hadnsTextArea) as param
		contentPanel = new JScrollPane(handsTextArea);
		
		
		handsWindowLayout = new FlowLayout();
		handsWindowLayout.setAlignment(FlowLayout.CENTER);
		this.setLayout(handsWindowLayout);
		this.add(contentPanel);
		this.setSize(600, 700);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public static void main(String[] args) {
		new HandsWindow();

	}

}
