package cn.edu.swu.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.MessageFrame;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;

public class SendMessageButtonMonitor implements ActionListener {
	private SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	private User fromUser;
	private User toUser;
	private ObjectOutputStream oos;
	public SendMessageButtonMonitor(User fromUser,ObjectOutputStream oos, User toUser){
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.oos = oos;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("SendMessageButtonMonitorMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		System.out.println("向服务器发送谈话消息！！");
		System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		
		Date date = new Date();
		
		MessageFrame mf = Client.MESSAGE_FRAME_MAP.get(toUser.getUserId());

		mf.getViewTop().append("\n "+fromUser.getUserName()+"  "+fd.format(date)+"\n\n");
		mf.getViewTop().append(mf.getSend().getText()+"\n");
		
		Request request = new Request();
		
		request.setMessage("\n "+fromUser.getUserName()+"  "+fd.format(date)+"\n\n"+mf.getSend().getText()+"\n");
		request.setFromUser(this.fromUser);
		request.setToUser(this.toUser);
		request.setServiceName(ClientResource.MESSAGE);
		
		mf.getSend().setText("");
		
		try {
			oos.writeObject(request);
			oos.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
