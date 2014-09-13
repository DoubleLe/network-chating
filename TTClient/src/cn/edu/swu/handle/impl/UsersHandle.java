package cn.edu.swu.handle.impl;

import java.io.ObjectInputStream;


import java.io.ObjectOutputStream;


import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.UsersDialog;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;


public class UsersHandle implements ResponseHandle {

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		if(Client.usersDialog!=null){
			Client.usersDialog.setVisible(true);
		}else{
			Client.usersDialog = new UsersDialog(oos, response);
			Client.usersDialog.setVisible(true);
		}
	}
}
