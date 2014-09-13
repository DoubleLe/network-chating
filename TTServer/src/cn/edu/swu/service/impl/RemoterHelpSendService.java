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

public class RemoterHelpSendService implements ServerService {

	@Override
	public void service(Request request, Socket socket) {
		User fromUser = request.getToUser();
		User toUser = request.getFromUser();
		
		Response response = new Response();
		response.setUser(fromUser);
		response.setToUser(toUser);
		response.setIcon(request.getIcon());
		response.setResponseName("RemoterHelpReceive");
		
		User onlineUser = new User();
		Socket sot = null;
		
		onlineUser = ServerRecource.getOnlineMap().get(request.getToUser().getUserId());
		if(onlineUser!=null){
			sot = ServerRecource.getOnlineSocketMap().get(onlineUser.getUserId());
			
			ObjectOutputStream oot = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(sot));
		
			try {
				oot.writeObject(response);
				oot.flush();
				oot.reset();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
