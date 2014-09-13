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

public class RemoterHelpRequestService implements ServerService {

	@Override
	public void service(Request request, Socket socket) {
		User mySelfUser = request.getToUser();
		User youSelfUser = request.getFromUser();
		Response response = new Response();
		
		response.setUser(mySelfUser);
		response.setToUser(youSelfUser);
		response.setResponseName(request.getServiceName());
		
		System.out.println("RemoterHelpRequestServiceOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.out.println("mySelfUserµÄIP"+mySelfUser.getIp());
		System.out.println("mySelfUserµÄPort"+mySelfUser.getPort());
		System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		
		User onlineUser = new User();
		Socket sot = null;
		
		onlineUser = ServerRecource.getOnlineMap().get(request.getToUser().getUserId());
		if(onlineUser!=null){
			sot = ServerRecource.getOnlineSocketMap().get(onlineUser.getUserId());
			
			ObjectOutputStream oot = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(sot));
			try {
				oot.writeObject(response);
				oot.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
