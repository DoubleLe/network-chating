package cn.edu.swu.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;
import cn.edu.swu.modle.Request;
import cn.edu.swu.service.ServerService;


public class ServerThread implements Runnable {
	private Socket socket;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			while(!socket.isClosed()){
				ObjectInputStream ois = ServerRecource.getObjectInputStream(ServerTool.getSocketKey(socket));
				Request request = (Request)ois.readObject();
				
				System.out.println("ServerThread##################################################################################");
				System.out.println(request.getFromUser().getUserName()+ServerTool.getSocketKey(socket)+"��������������"+request.getServiceName()+"�ķ���");
				System.out.println("##################################################################################");
				
				String className = ServerRecource.getClassName(request.getServiceName());
				ServerService service = (ServerService)Class.forName(className).newInstance();
				
				System.out.println("ServerThreadRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRrr");
				System.out.println("ServerService service = (ServerService)Class.forName(className).newInstance()����ͨ��");
				System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRrr");
				
				service.service(request, socket);
				
				System.out.println("ServerThreadRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRrr");
				System.out.println("service.service(request, socket)����ͨ��");
				System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRrr");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
//			System.out.println("ServerThread##################################################################################");
//			System.out.println(ServerTool.getSocketKey(socket)+"�������˳�����������������");
//			System.out.println("##################################################################################");
			
			String key = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
			ServerRecource.removeObjectStream(key);
			
//			System.out.println("ServerThread##################################################################################");
//			System.out.println(ServerTool.getSocketKey(socket)+"�����ӹرգ��Ƴ��������ϵ���ص���Դ");
//			System.out.println("##################################################################################");
		}
	}

}
