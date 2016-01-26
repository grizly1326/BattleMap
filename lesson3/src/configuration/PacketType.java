package configuration;

import java.util.ArrayList;

public class PacketType {
	public static ArrayList<String> serverRequest=new ArrayList<String>();
	public static String getString(int index){
		return serverRequest.get(index);
	}
	public static void preFill(){			//add at the end of the function.
		serverRequest.add("Request");
		serverRequest.add("Message");
	}
}
