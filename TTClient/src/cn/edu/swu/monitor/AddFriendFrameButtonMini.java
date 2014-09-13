package cn.edu.swu.monitor;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import cn.edu.swu.Client.Client;

public class AddFriendFrameButtonMini extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		Client.addFriendFrame.setExtendedState(JFrame.ICONIFIED);
	}
}
