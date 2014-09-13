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

public class RemoterHelpOperateService implements ServerService {

	@Override
	public void service(Request request, Socket socket) {
		Response response = new Response();
		response.setOperate(request.getOperate());
		response.setUser(request.getToUser());
		response.setToUser(request.getFromUser());
		response.setResponseName(request.getServiceName());
		
		User onlineUser = new User();
		Socket sot = null;
		
		onlineUser = ServerRecource.getOnlineMap().get(request.getToUser().getUserId());
		if(onlineUser!=null){
			sot = ServerRecource.getOnlineSocketMap().get(onlineUser.getUserId());
			System.out.println("RemoterHelpOperateService>>>..."+response.getOperate().getOpition());
			ObjectOutputStream oot = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(sot));
			try {
				oot.writeObject(response);
				oot.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

}
