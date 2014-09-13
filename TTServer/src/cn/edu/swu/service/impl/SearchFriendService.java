package cn.edu.swu.service.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import cn.edu.swu.informationData.ServerRecource;
import cn.edu.swu.informationData.ServerTool;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.service.ServerService;


public class SearchFriendService implements ServerService{

	@Override
	public void service(Request request, Socket socket) {
		
		Map<String,User> map = ServerRecource.getUsers();
		
		User fromUser = request.getFromUser();
		
		Response response = new Response();
		
		int count = 0;
		
		System.out.println("SearchFriendService***************************************************************************");
		System.out.println("此时"+request.getFromUser().getUserId()+":"+request.getFromUser().getUserName()+"的好友列表为：");
		System.out.println(ServerRecource.getFriendList().get(request.getFromUser().getUserId()));
		System.out.println("此时的申请的好友账号ID为 ："+request.getToUser());
		System.out.println("***************************************************************************");
		
			for(User l : ServerRecource.getFriendList().get(fromUser.getUserId())){
				if(request.getToUser().getUserId().equals(l.getUserId())){
					response.setResponseCode(Response.THE_FRIEND_HAS_EXIST);
					response.setMessage(l.getUserName()+"("+l.getUserId()+")"+"已经是您的好友，不能重复添加。");
					count = 1;
					
					System.out.println("此用户ID ("+request.getToUser().getUserId()+") 已经在你的好友列表中存在");
					
					break;
				}
			}
				
			if(count!=1){
				for(Map.Entry<String, User> entry:map.entrySet()){
					
					if(request.getToUser().getUserId().equals(entry.getKey())){
						response.setResponseCode(Response.THE_FRIEND_YES);
						response.setToUser(entry.getValue());
						count = 2;
						
						System.out.println("成功查找到该ID ("+request.getToUser().getUserId()+") 的用户");
						
						break;
					}
				}
				
				if(count!=2){
					response.setResponseCode(Response.THE_FRIEND_NOT_FOUND);
					response.setMessage("没有找到符合条件的用户或此账号不存在！");
					
					System.out.println("该ID ("+request.getToUser().getUserId()+") 用户不存在！");
				}
			}
			
			response.setResponseName(request.getServiceName());
			
			ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
			
			System.out.println("向客户端"+request.getFromUser()+"发送查询结果："+response.getMessage());
			
			try {
				oos.writeObject(response);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
