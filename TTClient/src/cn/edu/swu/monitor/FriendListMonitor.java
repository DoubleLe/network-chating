package cn.edu.swu.monitor;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.clientFrame.MessageFrame;
import cn.edu.swu.modle.User;

public class FriendListMonitor extends MouseAdapter{
	private SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	private User fromUser;
	private ObjectOutputStream oos;
	private User friendUser;
	
	public FriendListMonitor(User fromUser,User friendUser, ObjectOutputStream oos){
		this.fromUser = fromUser;
		this.oos = oos;
		this.friendUser = friendUser;
		System.out.println("FriendListMonitor÷–friendUser"+friendUser);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(2==arg0.getClickCount()){
			
			if(Client.MESSAGE_FRAME_MAP.get(friendUser.getUserId())==null){
				Date date = new Date();
				
				MessageFrame messageFrame = new MessageFrame(this.fromUser, this.oos, friendUser);
				
				
				Client.MESSAGE_FRAME_MAP.put(friendUser.getUserId(), messageFrame);
				
				messageFrame.setVisible(true);
				
				MessageFrame mf = Client.MESSAGE_FRAME_MAP.get(friendUser.getUserId());
				
				if(Client.MESSAGE_MAP.get(friendUser.getUserId())!=null){
					Client.friendListPanelMap.get(friendUser.getUserId()).setBackground(Color.WHITE);
					FriendFrame.jp21.repaint();
					
					mf.getViewTop().append("\n "+friendUser.getUserName()+"  "+fd.format(date)+"\n\n");
					mf.getViewTop().append(Client.MESSAGE_MAP.get(friendUser.getUserId()));
				}
				
			}
		}
	}
	
}
