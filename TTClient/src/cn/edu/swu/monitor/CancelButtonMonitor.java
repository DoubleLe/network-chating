package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.swu.Client.Client;

public class CancelButtonMonitor implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Client.registerFrame.dispose();
	}

}
