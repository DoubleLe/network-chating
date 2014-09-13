package cn.edu.swu.handle.impl;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.clientFrame.UsersDialog;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;

public class FriendListHandle implements ResponseHandle {

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		
		System.out.println("FriendListHandle&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(response.getUser().getUserName()+": 客户端response中的FriendList："+response.getFriendList());
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		FriendFrame.friendFrameFlush(response, FriendFrame.jp21, oos);
		UsersDialog.usersDialogFlush(response, oos);
	}

}
