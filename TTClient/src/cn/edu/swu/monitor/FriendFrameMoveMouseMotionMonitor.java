package cn.edu.swu.monitor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.FriendFrame;

public class FriendFrameMoveMouseMotionMonitor extends MouseMotionAdapter{
	@Override
	public void mouseDragged(MouseEvent e) {
		if(FriendFrame.isDragged){
			FriendFrame.secondFrame = new Point(Client.friendsFrame.getLocation().x+e.getX()-FriendFrame.firstFrame.x,
					Client.friendsFrame.getLocation().y + e.getY() - FriendFrame.firstFrame.y);
			
			Client.friendsFrame.setLocation(FriendFrame.secondFrame);
		}
	}
}
