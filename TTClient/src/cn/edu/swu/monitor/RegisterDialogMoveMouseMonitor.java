package cn.edu.swu.monitor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.RegisterDialog;

public class RegisterDialogMoveMouseMonitor extends MouseAdapter{
	@Override
	public void mouseReleased(MouseEvent e) {
		RegisterDialog.isDragged = false;
		Client.registerFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		RegisterDialog.firstFrame = new Point(e.getX(), e.getY());
		RegisterDialog.isDragged = true;
		Client.registerFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
