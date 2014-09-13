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


public class FriendListService implements ServerService {

	@SuppressWarnings("unchecked")
	@Override
	public void service(Request request, Socket socket) {
		
		System.out.println("FriendListService$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(request.getFromUser().getUserId()+request.getFromUser().getUserName()+"申请更新好友列表！");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		
		Response response = new Response();
		
		Map<String,User> map = ServerRecource.getUsers();
		
		User fromUser = request.getFromUser();
		List<User> userList = new ArrayList<User>();
		int count = 0;
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
					userList.add(entry.getValue());					
				}
			}
		}
		response.setUserList(userList);
		response.setResponseName(request.getServiceName());
		response.setUser(fromUser);
		
		ArrayList<User> arr = (ArrayList<User>) ServerRecource.getFriendList().get(request.getFromUser().getUserId());

		ArrayList<User> copyArr = new ArrayList<User>();
		User onlineUser = new User();
		
		
		for(int i = 0;i<arr.size();i++){
			onlineUser = ServerRecource.getOnlineMap().get(arr.get(i).getUserId());
			
			if(onlineUser!=null){
				arr.get(i).setIp(onlineUser.getIp());
				arr.get(i).setPort(onlineUser.getPort());
			
			}else{
				arr.get(i).setIp(null);
				arr.get(i).setPort(0);
			}
			User copyUser = new User(arr, i);
			
			copyArr.add(copyUser);
		}
		
		response.setFriendList((ArrayList<User>)copyArr.clone());
		
		try {
			
			
			ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
			
//			oos.reset();
			
			
			
			oos.writeObject(response);
			oos.flush();
			
			System.out.println("FriendListService$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println(request.getFromUser().getUserId()+request.getFromUser().getUserName()+"好友列表已传想该客户端！");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
