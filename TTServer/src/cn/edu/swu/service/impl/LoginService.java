package cn.edu.swu.service.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.service.ServerService;


public class LoginService implements ServerService {

	@Override
	public void service(Request request, Socket socket) {
		
		User serverUser = ServerRecource.getUser(request.getFromUser().getUserId());
		
		Response response = new Response();
		
		response.setResponseName(request.getServiceName());
		
		boolean flag = false;
		if(serverUser!=null){
			if(request.getFromUser().getPassword().equals(serverUser.getPassword())){
				
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<			
				User saveUser = new User(serverUser, request); 
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				ServerRecource.getOnlineMap().put(serverUser.getUserId(), saveUser);
				ServerRecource.getOnlineSocketMap().put(serverUser.getUserId(), socket);
				
				
				response.setMessage("µÇÂ½³É¹¦£¡£¡£¡");
				response.setUser(saveUser);
				response.setResponseCode(Response.LOGIN_SUCCESS);
				flag = true;
	
				User onlineUser = new User();
				Socket sot = null;
				List<User> friendLists = ServerRecource.getFriendList().get(request.getFromUser().getUserId());
				
				for(User fri : friendLists){
					
					onlineUser = ServerRecource.getOnlineMap().get(fri.getUserId());
		
					
					if(onlineUser!=null){
						
						sot = ServerRecource.getOnlineSocketMap().get(onlineUser.getUserId());
						
						
						Response resp = new Response();
						resp.setUser(onlineUser);
						resp.setResponseName("Online");
						
						
						ObjectOutputStream oot = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(sot));
						
						
						try {
							oot.writeObject(resp);
							oot.flush();
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
	
			}else{
				response.setMessage("ÃÜÂë´íÎó£¡£¡£¡");
				response.setResponseCode(Response.LOGIN_PASSWORD_ERROR);
			}
		}else{
			
				response.setMessage("ÕËºÅ²»´æÔÚ£¡£¡£¡");
				response.setResponseCode(Response.LOGIN_ACCOUNT_NOT);				
		}
			
		
			ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
			
			
			try {
				oos.writeObject(response);
				oos.flush();
				
				if(!flag){
					
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
