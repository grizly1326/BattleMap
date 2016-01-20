package UiComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Ui.Settings;

public class MenuBar {
	public static void ManuBar(JFrame frame){
		//COMPONENTS
		JMenuBar menuBar= new JMenuBar();
		menuBar.setVisible(true);
		JButton setting= new JButton("Settings");
		menuBar.add(setting);
		frame.setJMenuBar(menuBar);
		
		//LISTENERS
		setting.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Settings(),"Settings").start();
				System.out.println("clicked");
				
			}
			
		});
	}

}
