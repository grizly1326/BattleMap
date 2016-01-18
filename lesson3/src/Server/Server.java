package Server;

import java.io.IOException;
import java.net.*;

import configuration.Config;

public class Server {
	DatagramSocket socket;
	DatagramPacket packet;
	byte[] data= new byte[1024];
	int port;
	public void create(int port){
		try {
			this.port=port;
			socket= new DatagramSocket(this.port);
		}catch (SocketException e) {
			e.printStackTrace();
			System.out.println("Error: cannot create DatagramSocket.");
		}
	}
	public void Stop(){
		socket.close();
	}
	public void Listener(String output){
		try {
			socket.setSoTimeout(Config.ServerSleep);						//socket timeout after some time, if not it would be stuck.
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		while(Config.ServerStatus){
			packet=new DatagramPacket(data,data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				System.out.println("Error: cannot insert packet into datagramSocket(....receiver). Or timed out.");
			}
			output=new String(packet.getData());
		}
	}
}
