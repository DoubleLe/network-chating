package cn.edu.swu.monitor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;

public class LoginFrameButtonOffMonitor extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		Client.loginFrame.dispose();
		System.exit(0);
	}
}
