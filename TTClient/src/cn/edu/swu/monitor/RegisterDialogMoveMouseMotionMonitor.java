package cn.edu.swu.monitor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.RegisterDialog;

public class RegisterDialogMoveMouseMotionMonitor extends MouseMotionAdapter{
	@Override
	public void mouseDragged(MouseEvent e) {
		if(RegisterDialog.isDragged){
			RegisterDialog.secondFrame = new Point(Client.registerFrame.getLocation().x+e.getX()-RegisterDialog.firstFrame.x,
					Client.registerFrame.getLocation().y + e.getY() - RegisterDialog.firstFrame.y);
			
			Client.registerFrame.setLocation(RegisterDialog.secondFrame);
		}
	}
}
