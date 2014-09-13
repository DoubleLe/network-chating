package cn.edu.swu.handle.impl;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;


import cn.edu.swu.clientFrame.AddFriendFrame;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;

public class SearchFriendHandle implements ResponseHandle {

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		if(response.getResponseCode()==Response.THE_FRIEND_YES){
			int yesNo = JOptionPane.showConfirmDialog(null, "�Ƿ����ѡ�е��û�Ϊ����","",JOptionPane.YES_NO_OPTION);
			
			if(yesNo==0){
				Request request = new Request();
				
				request.setToUser(response.getToUser());
				request.setFromUser(FriendFrame.loginUser);
				request.setServiceName(ClientResource.ADDFRIEND);
				
				System.out.println("SearchFriendHandleLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
				System.out.println("�û��� "+request.getFromUser()+" �������������Ӹú��� "+request.getToUser()+" ������");
				System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
				
				try {
					oos.writeObject(request);
					oos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			
			AddFriendFrame.jpError.setForeground(Color.RED);
			AddFriendFrame.jpError.setText(response.getMessage());
			
		}
	}

}
