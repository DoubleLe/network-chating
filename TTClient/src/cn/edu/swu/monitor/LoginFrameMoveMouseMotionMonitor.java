package cn.edu.swu.monitor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.LoginFrame;

public class LoginFrameMoveMouseMotionMonitor extends MouseMotionAdapter{
	@Override
	public void mouseDragged(MouseEvent e) {
		if(LoginFrame.isDragged){
			LoginFrame.secondFrame = new Point(Client.loginFrame.getLocation().x+e.getX()-LoginFrame.firstFrame.x,
					Client.loginFrame.getLocation().y + e.getY() - LoginFrame.firstFrame.y);
			
			Client.loginFrame.setLocation(LoginFrame.secondFrame);
		}
	}
}
