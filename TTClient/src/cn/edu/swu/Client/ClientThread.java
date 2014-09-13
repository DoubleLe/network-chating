package cn.edu.swu.Client;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Response;



public class ClientThread implements Runnable {
	private ObjectInputStream ois;
	private Socket socket;
	private ObjectOutputStream oos;
	
	
	
	public ObjectInputStream getOis() {
		return ois;
	}
	public ObjectOutputStream getOos() {
		return oos;
	}
	public ClientThread(Socket socket){
		try {
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.socket = socket;
		
	}
	@Override
	public void run() {
		try {
			while(!socket.isClosed()){
				
				Response response = (Response)ois.readObject();
				System.out.println(response);
				System.out.println(response.getResponseName());
				String className = ClientResource.getClassName(response.getResponseName()); 
				ResponseHandle handle = (ResponseHandle)Class.forName(className).newInstance();
				handle.handle(response,ois,oos);
//				oos.reset();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
