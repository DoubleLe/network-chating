package cn.edu.swu.monitor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.LoginFrame;

public class LoginFrameMoveMouseMonitor extends MouseAdapter{
	@Override
	public void mouseReleased(MouseEvent e) {
		LoginFrame.isDragged = false;
		Client.loginFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		LoginFrame.firstFrame = new Point(e.getX(), e.getY());
		LoginFrame.isDragged = true;
		Client.loginFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
