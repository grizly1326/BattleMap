package Ui;

import javax.swing.*;

import Server.Server;
import Threads.ServerT;

import java.awt.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		//Threads
		System.out.println("Number of threads: "+Thread.activeCount());
		//ServerT a= new ServerT();			//uncomment
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
		
		JButton send= new JButton();
		send.setBounds(150, 250, 150, 50);
		send.setVisible(true);
		send.setText("Send a Message");
		frame.add(send);
		
		TextField text= new TextField();
		text.setBounds(100, 200, 300, 50);
		text.setVisible(true);
		text.setText("EnterTextHere");
		frame.add(text);
		
		
		//Listeners
		server.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new ServerT(true);
				System.out.println("MAIN__Still running, Number of threads: "+Thread.activeCount());
				
			}
		});
		send.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}

}
