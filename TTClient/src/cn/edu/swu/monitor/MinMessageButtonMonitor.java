package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import cn.edu.swu.Client.Client;
import cn.edu.swu.modle.User;

public class MinMessageButtonMonitor implements ActionListener{
	
	private User toUser;
	
	public MinMessageButtonMonitor(User toUser){
		this.toUser = toUser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setExtendedState(JFrame.ICONIFIED);
		
	}

}
