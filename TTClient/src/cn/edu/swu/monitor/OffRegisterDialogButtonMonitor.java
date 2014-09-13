package cn.edu.swu.monitor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.edu.swu.Client.Client;

public class OffRegisterDialogButtonMonitor extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		Client.registerFrame.dispose();
	}
}
