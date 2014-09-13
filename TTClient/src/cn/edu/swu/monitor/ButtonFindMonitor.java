package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.Client.Client;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;

public class ButtonFindMonitor implements ActionListener{
	private User user;
	private ObjectOutputStream oos;
	public ButtonFindMonitor(User user,ObjectOutputStream oos){
		this.user = user;
		this.oos = oos;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Client.UsersDiaLogCount += 1;
		if(1==Client.UsersDiaLogCount){
			
			Request request = new Request();
			request.setFromUser(user);
			request.setServiceName(ClientResource.USERS);
			try {
				oos.writeObject(request);
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
