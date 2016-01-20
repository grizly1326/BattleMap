package Server;

import java.net.InetAddress;

public class Player {
	String name;
	InetAddress address;
	int port;
	public Player(String name, InetAddress address, int port){
		this.name=name;
		this.address=address;
	}
	public void rename(String n){
		name=n;
	}
	public void changeAddress(InetAddress a){
		address=a;
	}

}
