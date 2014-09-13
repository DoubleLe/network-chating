package cn.edu.swu.monitor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import cn.edu.swu.Client.Client;
import cn.edu.swu.modle.User;

public class MessageFrameMoveMouseMotionMonitor extends MouseMotionAdapter{
	
	private User toUser;
	
	public MessageFrameMoveMouseMotionMonitor(User toUser){
		this.toUser = toUser;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).isDragged()){
			Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setSecondFrame(new Point(Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).getLocation().x+e.getX()-Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).getFirstFrame().x,
					Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).getLocation().y + e.getY() - Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).getFirstFrame().y));
			
			Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setLocation(Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).getSecondFrame());
		}
	}
}
