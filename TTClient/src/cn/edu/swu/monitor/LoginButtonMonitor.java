package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


import cn.edu.swu.Client.ClientThread;
import cn.edu.swu.Client.Client;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;



public class LoginButtonMonitor implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
//			Socket socket = new Socket("172.18.4.130", 56780);//教师机
			Socket socket = new Socket("127.0.0.1", 56780);
			ClientThread ct = new ClientThread(socket);
			ObjectOutputStream oos = ct.getOos();
			Request request = new Request();
			User user = new User();
			
			user.setIp(socket.getInetAddress().getHostAddress());
			user.setPort(socket.getPort());
			
			System.out.println("LoginButtonMonitor<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.println(socket.getInetAddress().getHostAddress()+": "+socket.getPort());
			System.out.println("请求服务器时的user"+user.getIp()+":"+user.getPort());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			user.setUserId(Client.loginFrame.getIdField().getText());
			user.setPassword(new String(Client.loginFrame.getPasswordField().getPassword()));
			request.setFromUser(user);
			request.setServiceName(ClientResource.LOGIN);
			oos.writeObject(request);
			oos.flush();
			Thread t = new Thread(ct);
			t.start();
		} catch (UnknownHostException ev) {
			ev.printStackTrace();
		} catch (IOException ev) {
			ev.printStackTrace();
		}
		
	}
}
