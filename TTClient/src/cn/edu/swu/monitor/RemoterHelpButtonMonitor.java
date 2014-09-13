package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;

public class RemoterHelpButtonMonitor implements ActionListener {

	private User mySelfUser;
	private User yourSelfUser;
	private ObjectOutputStream oos;
	
	public RemoterHelpButtonMonitor(User mySelfUser, User yourSelfUser,ObjectOutputStream oos){
		this.mySelfUser = mySelfUser;
		this.yourSelfUser = yourSelfUser;
		this.oos = oos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Request request = new Request();
		
		request.setFromUser(this.mySelfUser);
		request.setToUser(this.yourSelfUser);
		request.setServiceName(ClientResource.REMOTER_HELP_REQUEST);
		
		try {
			oos.writeObject(request);
			oos.flush();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
