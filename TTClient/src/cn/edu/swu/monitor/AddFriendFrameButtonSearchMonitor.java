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
		System.out.println("点击查询按钮！");
		System.out.println("///////////////////////////////////////////////////////");
		
		String toUserId = AddFriendFrame.userIdAdd.getText();
		
		if(toUserId.equals(FriendFrame.loginUser.getUserId())){
			
			AddFriendFrame.jpError.setForeground(Color.RED);
			AddFriendFrame.jpError.setText("不能将自己加为好友！");
			
			System.out.println("AddFriendFrameButtonSearchMonitor]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("添加的好友为自己，操作错误提示！");
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
			System.out.println("正在向服务器端发送所查好友的ID"+toUser.getUserId());
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
