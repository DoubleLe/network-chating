package cn.edu.swu.monitor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;
import cn.edu.swu.modle.User;

public class MessageFrameMoveMouseMonitor extends MouseAdapter{
	private User toUser;
	
	public MessageFrameMoveMouseMonitor(User toUser){
		this.toUser = toUser;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setDragged(false);
		Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setFirstFrame(new Point(e.getX(), e.getY()));
		Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setDragged(true);
		
		Client.MESSAGE_FRAME_MAP.get(toUser.getUserId()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
