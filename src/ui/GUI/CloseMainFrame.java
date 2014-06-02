package ui.GUI;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseMainFrame extends WindowAdapter {
	public void windowClosing(final WindowEvent e) {
		final Window closingWindow = e.getWindow();
		closingWindow.setVisible(false);
		closingWindow.dispose();
		System.exit(0);
	}
}
