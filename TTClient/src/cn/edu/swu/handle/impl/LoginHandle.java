package cn.edu.swu.handle.impl;

import java.io.IOException;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;

public class LoginHandle implements ResponseHandle {

	@Override
	public void handle(Response response,ObjectInputStream ois,ObjectOutputStream oos) {
		int responseCode = response.getResponseCode();
		if(responseCode == Response.LOGIN_SUCCESS){
			JOptionPane.showMessageDialog(null, response.getMessage());
			Client.friendsFrame = new FriendFrame(ois, oos, response);
			Client.loginFrame.dispose();
			Client.friendsFrame.setVisible(true);
		}else{
			try {
				ois.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, response.getMessage());
			
		}

	}

}
