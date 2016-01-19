package Client;

import java.net.*;

public class Client {
	DatagramPacket packet;
	DatagramSocket socket;
	InetAddress address;
	byte[] data;
	int port;
	public void newClient(int port, String adresa){
		try {
			address.getByName(adresa);
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
	public void send(String s){
		data=;
		//packet.setData(d, offset, length);
		socket.send(packet);
	}
}
