package Threads;

import Server.Server;

public class ServerT implements Runnable {
	Server a= new Server();
	
	public ServerT(){
		a.create(8888);
	}
	public void run(){
			System.out.println("Socket opend.");
			a.Listener(null);
			a.Stop();
			System.out.println("Socket closed.");
	}
}
