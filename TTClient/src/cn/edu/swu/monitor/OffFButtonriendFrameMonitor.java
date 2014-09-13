package cn.edu.swu.monitor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.Client.Client;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;

public class OffFButtonriendFrameMonitor extends MouseAdapter{
	private ObjectOutputStream oos;
	private User usrM;
	public OffFButtonriendFrameMonitor(ObjectOutputStream oos, User loginUser){
		this.oos = oos;
		this.usrM = loginUser;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Client.friendsFrame.dispose();
		
		Request request = new Request();
		request.setFromUser(usrM);
		request.setServiceName(ClientResource.EXIT);
		try {
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			System.out.println(usrM.getUserId()+usrM.getUserName()+request.getServiceName());
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			oos.writeObject(request);
			oos.flush();
			Thread.sleep(1000);
		} catch (IOException af) {
			af.printStackTrace();
		} catch (InterruptedException af) {
			af.printStackTrace();
		}
		System.exit(0);
	}
}
