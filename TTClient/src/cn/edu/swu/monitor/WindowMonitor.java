package cn.edu.swu.monitor;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;


public class WindowMonitor extends WindowAdapter {
	private ObjectOutputStream oos;
	private User usrM;
	public WindowMonitor(ObjectOutputStream oos, User loginUser){
		this.oos = oos;
		this.usrM = loginUser;
	}
	
	public void windowClosing(WindowEvent event) {
		Request request = new Request();
		request.setFromUser(usrM);
		request.setServiceName(ClientResource.EXIT);
		try {
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			System.out.println(usrM.getUserId()+usrM.getUserName()+request.getServiceName());
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			oos.writeObject(request);
			oos.flush();
			Thread.sleep(300);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
		
		
		
	}

}
