package cn.edu.swu.service.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.service.ServerService;


public class ExitService implements ServerService {

	@Override
	public void service(Request request, Socket socket) {
		try {
			
			ServerRecource.getOnlineMap().remove(request.getFromUser().getUserId());
			ServerRecource.getOnlineSocketMap().remove(request.getFromUser().getUserId());
			User onlineUser = new User();
			List<User> friendLists = ServerRecource.getFriendList().get(request.getFromUser().getUserId());
			Socket sot = null;
			for(User fri : friendLists){
				
				onlineUser = ServerRecource.getOnlineMap().get(fri.getUserId());
				
				if(onlineUser!=null){
					sot = ServerRecource.getOnlineSocketMap().get(onlineUser.getUserId());
					Response resp = new Response();
					
					resp.setUser(onlineUser);
					resp.setResponseName("Online");
					
					ObjectOutputStream oot = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(sot));
					try {
						oot.reset();
						oot.writeObject(resp);
						oot.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
			Response response = new Response();
			response.setUser(request.getFromUser());
			response.setResponseName(request.getServiceName());
			response.setMessage("ÄúÒÑÑ¡ÔñÍË³ö TT 2012 !");
			oos.reset();
			oos.writeObject(response);
			
			oos.flush();
			
			Thread.sleep(1000);
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
