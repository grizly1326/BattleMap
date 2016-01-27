package Ui;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import configuration.Config;
import UiComponents.MenuBar;

public class Settings implements Runnable{
	public void run() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
		frame.setLayout(null);
		
		//Components
		JLabel nameL=new JLabel();
		nameL.setText("Name: ");
		nameL.setVisible(true);
		nameL.setBounds(10, 50, 50, 50);
		frame.add(nameL);
		
		TextField nameSet= new TextField();
		nameSet.setText(Config.nameOfPlayer);
		nameSet.setVisible(true);
		nameSet.setBounds(100, 50, 75, 25);
		frame.add(nameSet);
		
		JButton save= new JButton();
		save.setText("Save");
		save.setBounds(frame.getWidth()/2-75, frame.getHeight()-100, 100, 25);
		save.setVisible(true);
		frame.add(save);
		
		MenuBar.Bar(frame,Thread.currentThread());
		
		//Listeners
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Config.nameOfPlayer=nameSet.getText();
				
			}
			
		});
	}

}
