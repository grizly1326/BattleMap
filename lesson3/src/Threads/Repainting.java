package Threads;

import javax.swing.*;

import configuration.Config;

public class Repainting implements Runnable {
	
	JLabel serverInfo;
	public Repainting(JLabel a){
		serverInfo=a;
	}
	public void run() {
		while(Config.serverStatus){
			serverInfo.setText("Server running: "+Config.serverOutput);
		}
		serverInfo.setText("INFO: ");
	}
}
