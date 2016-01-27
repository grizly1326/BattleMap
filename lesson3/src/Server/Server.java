package Server;

import java.io.IOException;
import java.net.*;

import configuration.Config;
import configuration.PacketType;

public class Server {
	DatagramSocket socket;
	DatagramPacket packet;
	byte[] data= new byte[1024];
	public void create(int port){
		try {
			socket= new DatagramSocket(port);
		}catch (SocketException e) {
			e.printStackTrace();
			System.out.println("Error: cannot create Server datagramSocket.");
		}
	}
	public void Stop(){
		socket.close();
	}
	public void Listener(){
		try {
			socket.setSoTimeout(Config.serverSleep);						//socket timeout after some time, if not it would be stuck.
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		while(Config.serverStatus){
			packet=new DatagramPacket(data,data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				System.out.println("Error: cannot insert packet into datagramSocket(....receiver). Or timed out.");
			}
			if(packet.getAddress()!=null){									//checking if there is any message.
				System.out.println("MESSAGE RECEIVED.");
				System.out.println("INFO: "+this.getString(packet)+" IP:"+packet.getAddress());				//delete after testing.
				this.switchPacket(this.getString(packet));							//make switching statement that decides what packet it is.
			}
		}
	}
	private String getString(DatagramPacket packet){
		String a=new String(packet.getData());
		return a.substring(0, packet.getLength());
	}
	private void switchPacket(String string){
		//---------------------------------
		//0--info what kind of packet it is
		//1--name of a player.
		//2--text it self.
		//---------------------------------
		String[] split=string.split("//");
		if(PacketType.getString(0).equals(split[0])){
			if(PlayerList.findByString(split[1])){
				System.out.println("INFO: Already in playerList.");
			}else{PlayerList.add(new Player(split[1], packet.getAddress(),packet.getPort()));}
			System.out.println("ONE: "+PacketType.getString(0));						//delete after testing.
		}
		if(PacketType.getString(1).equals(split[0])){
			Config.serverOutput=split[2];
			System.out.println("ONE: "+PacketType.getString(1));						//delete after testing.
		}
	}
}
