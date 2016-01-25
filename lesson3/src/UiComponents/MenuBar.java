package UiComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Ui.Settings;

public class MenuBar {
	public static void Bar(JFrame frame, Thread a){
		//COMPONENTS
		JMenuBar menuBar= new JMenuBar();
		menuBar.setVisible(true);
		JButton setting= new JButton("Settings");
		JButton list= new JButton("List");
		if(Thread.currentThread().getName().equals("main"))menuBar.add(setting);			//decideing where are you located, and showing components.
		menuBar.add(list);
		frame.setJMenuBar(menuBar);
		
		//LISTENERS
		setting.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Settings(),"Settings").start();
				
			}
			
		});
	}

}
