package cn.edu.swu.monitor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.UsersDialog;

public class UsersDialogMoveMouseMotionMonitor  extends MouseMotionAdapter{
	@Override
	public void mouseDragged(MouseEvent e) {
		if(UsersDialog.isDragged){
			UsersDialog.secondFrame = new Point(Client.usersDialog.getLocation().x+e.getX()-UsersDialog.firstFrame.x,
					Client.usersDialog.getLocation().y + e.getY() - UsersDialog.firstFrame.y);
			
			Client.usersDialog.setLocation(UsersDialog.secondFrame);
		}
	}
}
