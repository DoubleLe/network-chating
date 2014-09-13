package cn.edu.swu.handle.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;

public class RemoterHelpRequestHandle implements ResponseHandle {

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		User youFriendUser = response.getToUser();
		int option = JOptionPane.showConfirmDialog(null, "您的好友【"+youFriendUser.getUserName()+" ("+youFriendUser.getUserId()+") 】，正在向您请求远程协助", "是否同意", JOptionPane.YES_NO_OPTION);
		
		Request request = new Request();
		request.setFromUser(FriendFrame.loginUser);
		request.setToUser(youFriendUser);
		
		if(0==option){
			request.setServiceName(ClientResource.REMOTER_HELP_ACCEPT);
		}else{
			request.setServiceName(ClientResource.REMOTER_HELP_REFUSE);
		}
		
		try {
			oos.writeObject(request);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
