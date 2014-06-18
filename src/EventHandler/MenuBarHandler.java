package EventHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import forPockerFoc.ExitAskWindow;
import forPockerFoc.SelectionWindow;

public class MenuBarHandler implements ActionListener {
	
	private final JFrame myFrame;

	public MenuBarHandler(final JFrame mainWindow) {
		this.myFrame = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "logOut"){
			myFrame.dispose();
			new SelectionWindow();
			
		}
		else if(e.getActionCommand() == "exit"){
			new ExitAskWindow();
			if(ExitAskWindow.isClose()){
				System.exit(0);
			}
			
		}
		else if(e.getActionCommand() == "rules"){
			System.out.println("rules");
		}
		else if(e.getActionCommand() == "hands"){
			System.out.println("hands");
		}

	}

}
