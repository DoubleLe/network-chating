package cn.edu.swu.monitor;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import cn.edu.swu.Client.Client;
import cn.edu.swu.modle.User;



public class MessageWindowMonitor extends WindowAdapter{
	private User toUser;
	public MessageWindowMonitor(User toUser){
		this.toUser = toUser;
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		Client.MESSAGE_FRAME_MAP.remove(toUser.getUserId());
	}
	
}
