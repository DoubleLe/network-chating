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
		System.out.println("��ʱ"+request.getFromUser().getUserId()+":"+request.getFromUser().getUserName()+"�ĺ����б�Ϊ��");
		System.out.println(ServerRecource.getFriendList().get(request.getFromUser().getUserId()));
		System.out.println("��ʱ������ĺ����˺�IDΪ ��"+request.getToUser());
		System.out.println("***************************************************************************");
		
			for(User l : ServerRecource.getFriendList().get(fromUser.getUserId())){
				if(request.getToUser().getUserId().equals(l.getUserId())){
					response.setResponseCode(Response.THE_FRIEND_HAS_EXIST);
					response.setMessage(l.getUserName()+"("+l.getUserId()+")"+"�Ѿ������ĺ��ѣ������ظ���ӡ�");
					count = 1;
					
					System.out.println("���û�ID ("+request.getToUser().getUserId()+") �Ѿ�����ĺ����б��д���");
					
					break;
				}
			}
				
			if(count!=1){
				for(Map.Entry<String, User> entry:map.entrySet()){
					
					if(request.getToUser().getUserId().equals(entry.getKey())){
						response.setResponseCode(Response.THE_FRIEND_YES);
						response.setToUser(entry.getValue());
						count = 2;
						
						System.out.println("�ɹ����ҵ���ID ("+request.getToUser().getUserId()+") ���û�");
						
						break;
					}
				}
				
				if(count!=2){
					response.setResponseCode(Response.THE_FRIEND_NOT_FOUND);
					response.setMessage("û���ҵ������������û�����˺Ų����ڣ�");
					
					System.out.println("��ID ("+request.getToUser().getUserId()+") �û������ڣ�");
				}
			}
			
			response.setResponseName(request.getServiceName());
			
			ObjectOutputStream oos = ServerRecource.getObjectOutputStream(ServerTool.getSocketKey(socket));
			
			System.out.println("��ͻ���"+request.getFromUser()+"���Ͳ�ѯ�����"+response.getMessage());
			
			try {
				oos.writeObject(response);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
