package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.AddFriendFrame;

public class ButtonAddFriendMonitor implements ActionListener{

	ObjectOutputStream oos;
	public ButtonAddFriendMonitor(ObjectOutputStream oos){
		this.oos = oos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("ButtonAddFriendMonitorTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		System.out.println("������Ӱ�ť");
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		
		Client.AddFriendFrameCount += 1;
		if(1==Client.AddFriendFrameCount){
			
			Client.addFriendFrame = new AddFriendFrame(oos);
			
			Client.addFriendFrame.setVisible(true);
			
			System.out.println("ButtonAddFriendMonitor-><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.println("��Ӧ������Ӱ�ť�¼���������ѯ��Ӻ��Ѵ��ڣ�");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
	}
	
}
