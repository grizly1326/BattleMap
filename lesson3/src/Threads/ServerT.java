package Threads;

import Server.Server;

public class ServerT implements Runnable {
	Server a;
	boolean toggle=false;
	public ServerT(boolean toggle){
		this.toggle= toggle;
		Thread t= new Thread(this);
		t.start();
	}
	public void run(){
		while(toggle){
			a= new Server();
			a.create(8888);
			a.Listener(true,null);
		}
	}
}
