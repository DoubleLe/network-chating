package cn.edu.swu.server;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;

public class Servers {
	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(56780);
			while(true){
				Socket socket = server.accept();
				
				System.out.println("Servers))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
				System.out.println("���յ�������"+ServerTool.getSocketKey(socket)+"������");

				System.out.println("��¼ʱ��socket:"+socket);
				System.out.println("))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
				
				ServerRecource.putObjectStream(socket);
				ServerThread st = new ServerThread(socket);
				Thread t = new Thread(st);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

