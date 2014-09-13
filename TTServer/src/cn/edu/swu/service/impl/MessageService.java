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


public class MessageService implements ServerService {

	@Override
	public void service(Request request, Socket socket) {
		User onlineUser = new User();
		Socket sot = null;
		
		onlineUser = ServerRecource.getOnlineMap().get(request.getToUser().getUserId());
		
		if(onlineUser!=null){
			
			sot = ServerRecource.getOnlineSocketMap().get(onlineUser.getUserId());
			
			Response resp = new Response();
			
			resp.setUser(onlineUser);
			resp.setToUser(request.getFromUser());
			resp.setResponseName(request.getServiceName());
			resp.setMessage(request.getMessage());
			resp.setResponseCode(Response.FRIEND_ONLINE);
			
			
			ObjectOutputStream oot = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(sot));
			
			try {
				oot.writeObject(resp);
				oot.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			Response response = new Response();
			
			response.setMessage("好友"+" "+request.getToUser().getUserId()+":"+request.getToUser().getUserName()+" 处于离线状态，无法接受你发送的消息！！");
			response.setResponseCode(Response.FRIEND_OFFLINE);
			response.setResponseName(request.getServiceName());
			
			ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
			
			try {
				oos.writeObject(response);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
