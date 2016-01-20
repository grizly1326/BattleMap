package Threads;

import configuration.Config;
import Server.Server;

public class ServerT implements Runnable {
	Server a= new Server();
	
	public ServerT(int port){
		a.create(port);
	}
	public void run(){
			System.out.println("Socket opend.");
			a.Listener();
			a.Stop();
			System.out.println("Socket closed.");
	}
}
