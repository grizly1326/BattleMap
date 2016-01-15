package Threads;

import Server.Server;

public class ServerT implements Runnable {
	public ServerT(){
	}
	public void run(){
		while(true){
			Server a= new Server();
			a.create(8888);
			a.Listener(true,null);
		}
	}
}
