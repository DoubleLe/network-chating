package cn.edu.swu.handle.impl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.clientFrame.RemoteFrame;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;

public class RemoterHelpReceiveHandle implements ResponseHandle {

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		RemoteFrame reFrame = RemoteFrame.getInstance(response.getIcon(), FriendFrame.loginUser, response.getToUser(), oos);
		if(!reFrame.isVisible()){
			reFrame.setVisible(true);
		}
		reFrame.repaint();
		
	}
	
}
