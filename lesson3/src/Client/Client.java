package Client;

import java.io.IOException;
import java.net.*;

import configuration.Config;
import configuration.PacketType;

public class Client {
	DatagramPacket packet;
	DatagramSocket socket;
	byte[] data;
	public void newClient(){
		try {
			socket= new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Cannot create Client datagramSocket, please try again.");
		}
	}
	private void send(String s, String address, int port){
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
	public void findServer(String address, int port){
		this.send(PacketType.getString(0)+"//"+Config.securityString,address,port);
	}
	public void sendMessage(String string,String address, int port){
		this.send(PacketType.getString(1)+"//"+Config.nameOfPlayer+"//"+string, address, port);
	}
}
