package Client;

import java.io.IOException;
import java.net.*;

import configuration.Config;

public class Client {
	DatagramPacket packet;
	DatagramSocket socket;
	String address;
	int port;
	byte[] data;
	public void newClient(int port, String adresa){
		address=adresa;
		this.port=port;
		try {
			socket= new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Cannot create Client datagramSocket, please try again.");
		}
	}
	public void send(String s){
		data=s.getBytes();
		System.out.println(data.toString());
		try {
			packet= new DatagramPacket(data, data.length, InetAddress.getByName(address), port);
		} catch (UnknownHostException e1) {
			System.out.println("ERROR: cannot create a packet.");
		}	
		try {
			socket.send(packet);
		} catch (IOException e) {
			System.out.println("ERROR: cannot send a message.");
		}
	}
	public void close(){
		socket.close();
	}
}
