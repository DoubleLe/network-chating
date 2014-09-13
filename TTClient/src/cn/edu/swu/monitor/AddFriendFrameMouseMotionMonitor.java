package cn.edu.swu.monitor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.AddFriendFrame;

public class AddFriendFrameMouseMotionMonitor extends MouseMotionAdapter{

	@Override
	public void mouseDragged(MouseEvent e) {
		if(AddFriendFrame.isDragged){
			AddFriendFrame.xFrame = new Point(Client.addFriendFrame.getLocation().x+e.getX()-AddFriendFrame.yFrame.x,
					Client.addFriendFrame.getLocation().y + e.getY() - AddFriendFrame.yFrame.y);
			
			Client.addFriendFrame.setLocation(AddFriendFrame.xFrame);
		}
	}
	
}
