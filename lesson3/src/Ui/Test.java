package Ui;

//importing UI elements
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

//importing grizlys packages
import Client.Client;
import Server.Server;
import Threads.Repainting;
import Threads.ServerT;
import UiComponents.MenuBar;
import configuration.Config;



public class Test {

	public static void main(String[] args) {
		//JFrame
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Components
		
		MenuBar.ManuBar(frame);						//menu bar insertion.
		
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
		
		JLabel info=new JLabel();
		info.setBounds(10, 0, 1000, 50);
		info.setVisible(true);
		info.setText("INFO:"+Config.serverOutput);
		frame.add(info);
		
		//Listeners
		server.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Config.serverOutput);					//delete this after done testing.
				if(Config.serverStatus){									//switching between server open and close.
					server.setText("StartServer");
					Config.serverStatus=false;
					try {
						Thread.sleep(Config.serverSleep+500);				//added a bit of time to exit without error.
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}else{
					server.setText("CloseServer");
					Config.serverStatus=true;
					new Thread(new ServerT(Config.Port),"ServerThread").start();
					new Thread(new Repainting(info),"Repainting").start();
				}
			}
		});
		send.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Client s= new Client();
				s.newClient(Config.Port, "localhost");
				s.send(text.getText());
				s.close();
			}
		});
	}

}
