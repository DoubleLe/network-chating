package cn.edu.swu.service.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;




import java.net.Socket;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.service.ServerService;


public class RegisterService implements ServerService {
	@Override
	public void service(Request request,Socket socket) {
		
		User user = request.getFromUser();
		
		builderUserId(user);
		
		ServerRecource.addUser(user);
		Response response = new Response();
		response.setUser(user);
		response.setResponseName(request.getServiceName());
		
		System.out.println("RegisterService----------------------------------------------------------------------------------------------");
		System.out.println("ID�š�"+user.getUserId()+"����"+ServerTool.getSocketKey(socket)+":"+request.getFromUser().getUserName()+"������ע�ᣡ");
		System.out.println("----------------------------------------------------------------------------------------------");
		
		response.setMessage("��ϲ��ע��ɹ������ TT 2012 �����ǡ�"+user.getUserId()+"�������μǣ�����");
		try {
			
			ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
			oos.writeObject(response);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void builderUserId(User user){
		int userId = (int)(Math.random()*(99999-10000+1))+10000;
		if(ServerRecource.getUser(String.valueOf(userId))!=null){
			builderUserId(user);
		}else{
			user.setUserId(String.valueOf(userId));
		}
	}
	

}
