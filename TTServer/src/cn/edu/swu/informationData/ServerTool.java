package cn.edu.swu.informationData;

import java.net.Socket;

public class ServerTool {
	public static String getSocketKey(Socket socket){
		return socket.getInetAddress().getHostAddress()+":"+socket.getPort();
	}
}
