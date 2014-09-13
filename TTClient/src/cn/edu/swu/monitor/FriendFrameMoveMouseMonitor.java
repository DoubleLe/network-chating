package cn.edu.swu.monitor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.FriendFrame;

public class FriendFrameMoveMouseMonitor extends MouseAdapter{
	@Override
	public void mouseReleased(MouseEvent e) {
		FriendFrame.isDragged = false;
		Client.friendsFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		FriendFrame.firstFrame = new Point(e.getX(), e.getY());
		FriendFrame.isDragged = true;
		Client.friendsFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
