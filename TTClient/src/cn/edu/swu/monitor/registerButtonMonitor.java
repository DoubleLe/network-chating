package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.RegisterDialog;

public class registerButtonMonitor implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Client.registerFrame = new RegisterDialog();
		Client.registerFrame.setVisible(true);
	}

}
