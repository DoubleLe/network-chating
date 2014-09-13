package cn.edu.swu.monitor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.AddFriendFrame;

public class AddFriendFrameMouseMonitor extends MouseAdapter{

	@Override
	public void mouseReleased(MouseEvent e) {
		AddFriendFrame.isDragged = false;
		Client.addFriendFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		AddFriendFrame.yFrame = new Point(e.getX(), e.getY());
		AddFriendFrame.isDragged = true;
		Client.addFriendFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
}
