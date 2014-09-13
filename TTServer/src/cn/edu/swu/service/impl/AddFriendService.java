package cn.edu.swu.service.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.service.ServerService;


public class AddFriendService implements ServerService {

	@SuppressWarnings("unchecked")
	@Override
	public void service(Request request, Socket socket) {
		
		ServerRecource.addFriend(request.getFromUser().getUserId(), request.getToUser());
//		ServerRecource.getUsers().remove(request.getToUser().getUserId());
		
		Response response = new Response();
		
		response.setMessage("添加成功，你和"+request.getToUser().getUserName()+"已经成为好友");
		
		System.out.println("AddFriendServiceUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.out.println(request.getFromUser().getUserName()+"成功添加"+request.getToUser().getUserName()+"为好友");
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		
		response.setResponseName(request.getServiceName());
		response.setUser(request.getFromUser());//AddFriend
		
		ArrayList<User> ast = (ArrayList<User>) ServerRecource.getFriendList().get(request.getFromUser().getUserId());
		
		response.setFriendList((List<User>)ast.clone());
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
		User onlineUser = new User();
		Socket sot = null;
		List<User> friendLists = ServerRecource.getFriendList().get(request.getFromUser().getUserId());
		for(User fri : friendLists){
			onlineUser = ServerRecource.getOnlineMap().get(fri.getUserId());
			if(onlineUser!=null){
				
				sot = ServerRecource.getOnlineSocketMap().get(onlineUser.getUserId());
				
				System.out.println("LoginService++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				for(String s : ServerRecource.getOnlineSocketMap().keySet()){
					System.out.println("当前用户 "+request.getFromUser().getUserName()+" 登录时有在线好友时："+request.getFromUser().getUserId()+s+":"+ServerRecource.getOnlineSocketMap().get(s));
				}
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
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
//HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
		response.setUserList(userList);
		
		System.out.println("AddFriendServiceUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.out.println("服务器回应查询列表："+response.getUserList());
		System.out.println("服务器回应的好友列表为："+response.getFriendList());
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		
		ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
		try {
			oos.writeObject(response);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
