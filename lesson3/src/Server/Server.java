package Server;

import java.io.Closeable;
import java.net.*;

public class Server {
	DatagramSocket socket;
	int port;
	InetAddress address;
	public void Server(int port,String adresa){
		try {
			this.port=port;
			address.getByName(adresa);
			socket= new DatagramSocket(this.port,this.address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Error: cannot get address.");
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("Error: cannot create DatagramSocket.");
		}
	}
	public void Stop(){
		socket.close();
	}
}
