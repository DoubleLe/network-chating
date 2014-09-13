package cn.edu.swu.handle.impl;


import java.awt.AWTException;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.thread.RemoterHelpAcceptHandleThread;

public class RemoterHelpAcceptHandle implements ResponseHandle{

	public static boolean isLoop;

	public void setLoop(boolean isLoop) {
		RemoterHelpAcceptHandle.isLoop = isLoop;
	}
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		User toUser = response.getToUser();
		
		Request request = new Request();
		request.setToUser(toUser);
		request.setFromUser(FriendFrame.loginUser);
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		request.setServiceName(ClientResource.REMOTER_HELP_SEND);
		
		Robot robot;
		try {
			robot = new Robot();
			Rectangle screenRect = new Rectangle(toolKit.getScreenSize());
			
			RemoterHelpAcceptHandleThread rht = new RemoterHelpAcceptHandleThread(RemoterHelpAcceptHandle.isLoop, robot, screenRect,request,oos);
			Thread t = new Thread(rht);
			t.start();
			
			
		} catch (AWTException e) {
			e.printStackTrace();
		} 
	}
}
