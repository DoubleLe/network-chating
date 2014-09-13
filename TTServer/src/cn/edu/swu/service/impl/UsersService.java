package cn.edu.swu.service.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.service.ServerService;


public class UsersService implements ServerService {

	@Override
	public void service(Request request, Socket socket) {
		
		Map<String,User> map = ServerRecource.getUsers();
		
		User fromUser = request.getFromUser();
		
		List<User> userList = new ArrayList<User>();
		
		User onlineUser = new User();
		int count = 0;
		
		System.out.println("UsersServiceVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		
		for(Map.Entry<String, User> entry:map.entrySet()){
			count = 0;
			if(fromUser.getUserId().equals(entry.getKey())){
				continue;
			}else{
				for(User l : ServerRecource.getFriendList().get(fromUser.getUserId())){
					if(l.getUserId().equals(entry.getKey())){
						count = 1;
					}
				}
				if(0==count){
					
						
						onlineUser = ServerRecource.getOnlineMap().get(entry.getValue().getUserId());
						
						if(onlineUser!=null){
							User us = new User(entry.getValue(),request);
							
							userList.add(us);
						}else{
							
							userList.add(entry.getValue());	
						}
					
					
				}
			}
		}
		System.out.println("≤È—Ø¡–±Ì£∫"+userList);
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		
		Response response = new Response();
		response.setResponseName(request.getServiceName());
		response.setUserList(userList);
		response.setUser(fromUser);
		
		ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
		try {
			oos.writeObject(response);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
