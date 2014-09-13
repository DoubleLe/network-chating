package cn.edu.swu.monitor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.UsersDialog;

public class UsersDialogMoveMouseMonitor extends MouseAdapter{
	@Override
	public void mouseReleased(MouseEvent e) {
		UsersDialog.isDragged = false;
		Client.usersDialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		UsersDialog.firstFrame = new Point(e.getX(), e.getY());
		UsersDialog.isDragged = true;
		Client.usersDialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
