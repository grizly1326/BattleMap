package Client;

import java.net.*;

public class Client {
	DatagramPacket packet;
	DatagramSocket socket;
	InetAddress address;
	int port;
	public void newClient(int port, String adresa){
		try {
			address.getAllByName(adresa);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Cannot get this address. please try again.");
		}
		try {
			socket= new DatagramSocket(this.port, address);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Cannot create datagramSocket, please try again.");
		}
	}
}
