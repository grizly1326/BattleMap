package Ui;

import javax.swing.JFrame;

import UiComponents.MenuBar;

public class Settings implements Runnable{

	@Override
	public void run() {
		System.out.println("SETTINGS");
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
		frame.setLayout(null);
		
		MenuBar.ManuBar(frame);
		
	}

}
