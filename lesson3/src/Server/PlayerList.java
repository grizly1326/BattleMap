package Server;

import java.net.InetAddress;
import java.util.ArrayList;

public class PlayerList {
	ArrayList<Player>a= new ArrayList<Player>();
	public void add(Player player){
		a.add(player);
	}
	public void delete(int index){
		a.remove(index);
	}
	public int numberOfPlayers(){
		return a.size();
	}

}
