package ui.GUI;

import java.awt.*;

public class MainFrame extends Frame {
	//public static final Color buttonColor = new Color(255, 0, 0);
	/**
	 * Constructor<MainFrame>
	 */
	public MainFrame(final String title, final String iconImageFile, int width, int height) {
		super(title);
		
		// Mac zeigt keine FensterIcons an
		if (iconImageFile != "") {
			final Image icon = this.getToolkit().getImage(iconImageFile);
			this.setIconImage(icon);
		}
		this.setSize(width, height);
		this.setVisible(true);
	}
	
	public void initialize() {
		this.setLayout(new BorderLayout());
		//this.setBackground(new Color(170, 170, 170));
		
		
		
		final Panel bottomPanel = new Panel();
		bottomPanel.setLayout(new GridLayout(1, 4));
		
		// check
		Button check = new Button("CHECK");
		bottomPanel.add(check);
		
		// fold
		Button fold = new Button("FOLD");
		bottomPanel.add(fold);
		
		// call
		Button call = new Button("CALL");
		bottomPanel.add(call);
		
		// raise
		Button raise = new Button("RAISE");
		bottomPanel.add(raise);
		
		// grid ins southpanel des layouts legen
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		// bottom
		Canvas chat = new Canvas(/*"CHAT"*/);
		chat.setName("CHAT");
		chat.setBounds(12, 14, 19, 19);
		chat.setBackground(new Color(255, 0, 0));
		this.add(chat, BorderLayout.WEST);
		
		
		// east
		final Panel eastPanel = new Panel();
		eastPanel.setLayout(new GridLayout(2, 1));
		
		Button playerStates = new Button("Information about the players at the table");
		eastPanel.add(playerStates);
		
		final Panel helpPanel = new Panel();
		helpPanel.setLayout(new GridLayout(1, 2));
		
		Button rules = new Button("RULES");
		helpPanel.add(rules);
		
		Button help = new Button("HELP");
		helpPanel.add(help);
		
		eastPanel.add(helpPanel);
		
		this.add(eastPanel, BorderLayout.EAST);
		
		
		
		
		this.addWindowListener(new CloseMainFrame());
	}
}
