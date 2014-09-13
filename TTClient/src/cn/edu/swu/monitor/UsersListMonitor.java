package cn.edu.swu.monitor;

import java.awt.event.MouseAdapter;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;


public class UsersListMonitor extends MouseAdapter{
	private User user;
	private ObjectOutputStream oos;
	int i=0;
	private User otherUser;
	public UsersListMonitor(User user,User otherUser, ObjectOutputStream oos){
		this.user = user;
		this.otherUser = otherUser;
		this.oos = oos;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){

			int yesNo = JOptionPane.showConfirmDialog(null, "是否添加选中的用户为好友","",JOptionPane.YES_NO_OPTION);
			
			
			if(yesNo==0){
				Request request = new Request();
				request.setFromUser(user);
				
				request.setToUser(otherUser);
				request.setFromUser(FriendFrame.loginUser);
				request.setServiceName(ClientResource.ADDFRIEND);
				try {
					oos.writeObject(request);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		System.out.println("退出mouseClicked");
	}

}
