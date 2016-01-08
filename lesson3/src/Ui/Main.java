package Ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		//events
		
		//JFrame
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Components
		JButton server= new JButton();
		server.setBounds(150, 400, 150, 50);
		server.setText("StartServer");
		frame.add(server);
		
		//Listeners
		server.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
