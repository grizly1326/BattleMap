package Ui;

import javax.swing.JFrame;
import UiComponents.MenuBar;

public class ListofPlayers implements Runnable{
	public void run() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
		frame.setLayout(null);
		
		MenuBar.Bar(frame,Thread.currentThread());
		
	}
	
}
