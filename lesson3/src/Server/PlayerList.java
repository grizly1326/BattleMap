package Server;

import java.net.InetAddress;
import java.util.ArrayList;

public class PlayerList {
	static ArrayList<Player>a= new ArrayList<Player>();
	public static void add(Player player){
		a.add(player);
	}
	public static void delete(int index){
		a.remove(index);
	}
	public static String findByIndex(int index){
		return a.get(index).getName();
	}
	public static boolean findByString(String name){
		for(Player names:a){
			if(names.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	public static boolean findByAddress(InetAddress address){
		for(Player names:a){
			if(names.getAddress().equals(address)){
				return true;
			}
		}
		return false;
	}
	public static int numberOfPlayers(){
		return a.size();
	}

}
