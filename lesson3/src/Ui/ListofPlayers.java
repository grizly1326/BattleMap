package Ui;

import java.awt.TextField;

import javax.swing.JFrame;

import Server.PlayerList;
import UiComponents.MenuBar;


public class ListofPlayers implements Runnable{
	public void run() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
		frame.setLayout(null);
		
		//Components
		TextField list= new TextField();
		for(int i=0;i<PlayerList.numberOfPlayers();i++){
			list.setText(list.getText()+PlayerList.findByIndex(i)+"\n");
		}
		
		MenuBar.Bar(frame,Thread.currentThread());
		
	}
	
}
