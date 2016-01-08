package Server;

import java.io.IOException;
import java.net.*;

public class Server {
	DatagramSocket socket;
	DatagramPacket packet;
	byte[] data= new byte[1024];
	int port;
	public Server(){
		
	}
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
	public void Listener(boolean run,String output){
		System.out.println("toggled");
		while(run){
			packet=new DatagramPacket(data,data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				System.out.println("Error: cannot insert packet into datagramSocket(....receiver).");
			}
			output=new String(packet.getData());
			System.out.println("Running: "+output);
		}
	}
}
