package cn.edu.swu.monitor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.clientFrame.RemoteFrame;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Operate;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;

public class RemoteKeyMonitor implements KeyListener{
	private User myUser;
	private User friendUser;
	private ObjectOutputStream oos;
	private RemoteFrame remoteFrame;
	
	public RemoteKeyMonitor(User myUser, User friendUser, ObjectOutputStream oos,  RemoteFrame remoteFrame){
		this.myUser = myUser;
		this.friendUser = friendUser;
		this.oos = oos;
		this.remoteFrame = remoteFrame;
	}
	
	public RemoteKeyMonitor(){
		System.out.println("����  RemoteKeyMonitor");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		//ֻ��ð����¼�
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//��ð��¼��� keycode
		Request request = new Request();
		Operate operate = new Operate();
		System.out.println("Key:Key:Key:Key"+e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			System.out.println("�˴�����---------------------->keyPressed��ȡKeyCode��"+e.getKeyCode());
			this.remoteFrame.dispose();
		}
		request.setFromUser(myUser);
		request.setToUser(friendUser);
		request.setServiceName(ClientResource.REMOTER_HELP_OPERATE);
		operate.setKeyPressedKeyCode(e.getKeyCode());
		operate.setOpition(Operate.KEYPRESS);
		request.setOperate(operate);
		
		try {
			oos.writeObject(request);
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//����ͷż���keycode
	}

}
