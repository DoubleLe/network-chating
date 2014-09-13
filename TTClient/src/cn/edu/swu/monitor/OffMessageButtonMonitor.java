package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import cn.edu.swu.Client.Client;
import cn.edu.swu.modle.User;

public class OffMessageButtonMonitor implements ActionListener{

	private User toUser;
	public OffMessageButtonMonitor(User toUser){
		this.toUser = toUser;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).dispose();
		Client.MESSAGE_FRAME_MAP.remove(toUser.getUserId());
	}	
}
