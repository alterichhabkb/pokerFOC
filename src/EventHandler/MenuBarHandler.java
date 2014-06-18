package EventHandler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import forPockerFoc.ExitAskWindow;
import forPockerFoc.SelectionWindow;

public class MenuBarHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "logOut"){
			@SuppressWarnings("unused")//because it is a Window
			SelectionWindow sw = new SelectionWindow();
			
		}
		else if(e.getActionCommand() == "exit"){
			@SuppressWarnings("unused")//because it is a Window
			ExitAskWindow eaw = new ExitAskWindow();
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
