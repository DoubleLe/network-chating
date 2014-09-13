package cn.edu.swu.monitor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.clientFrame.AddFriendFrame;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;


public class AddFriendFrameButtonSearchMonitor implements ActionListener{
	private ObjectOutputStream oos;
	
	public AddFriendFrameButtonSearchMonitor(ObjectOutputStream oos){
		this.oos = oos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("AddFriendFrameButtonSearchMonitor///////////////////////////////////////////////////////");
		System.out.println("�����ѯ��ť��");
		System.out.println("///////////////////////////////////////////////////////");
		
		String toUserId = AddFriendFrame.userIdAdd.getText();
		
		if(toUserId.equals(FriendFrame.loginUser.getUserId())){
			
			AddFriendFrame.jpError.setForeground(Color.RED);
			AddFriendFrame.jpError.setText("���ܽ��Լ���Ϊ���ѣ�");
			
			System.out.println("AddFriendFrameButtonSearchMonitor]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("��ӵĺ���Ϊ�Լ�������������ʾ��");
			System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			
		}else{
			
			AddFriendFrame.jpError.setText("");
			
			Request request = new Request();
			
			User toUser = new User();
			toUser.setUserId(toUserId);
			
			request.setFromUser(FriendFrame.loginUser);
			request.setServiceName(ClientResource.SEARCHFRIEND);
			request.setToUser(toUser);
			
			System.out.println("AddFriendFrameButtonSearchMonitor000000000000000000000000000000000000000000000000000000000000");
			System.out.println("������������˷���������ѵ�ID"+toUser.getUserId());
			System.out.println("000000000000000000000000000000000000000000000000000000000000");
			
			try {
				oos.writeObject(request);
				oos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
