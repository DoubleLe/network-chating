package cn.edu.swu.monitor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Operate;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;

public class RemoteMouseMonitor implements MouseListener, MouseMotionListener {
	private User myUser;
	private User friendUser;
	private ObjectOutputStream oos;
	
	public RemoteMouseMonitor(User myUser, User friendUser, ObjectOutputStream oos){
		this.myUser = myUser;
		this.friendUser = friendUser;
		this.oos = oos;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		Request request = new Request();
		request.setFromUser(myUser);
		request.setToUser(friendUser);
		request.setServiceName(ClientResource.REMOTER_HELP_OPERATE);
		
		Operate operate = new Operate();
		operate.setX(arg0.getX());
		operate.setY(arg0.getY());
		operate.setOpition(Operate.MOUSEMOVED);
		request.setOperate(operate);
		
		try {
			oos.writeObject(request);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		Request request = new Request();
		request.setFromUser(myUser);
		request.setToUser(friendUser);
		request.setServiceName(ClientResource.REMOTER_HELP_OPERATE);
		
		Operate operate = new Operate();
		operate.setX(arg0.getX());
		operate.setY(arg0.getY());
		operate.setOpition(Operate.MOUSEPRESSED);
		request.setOperate(operate);
		
		try {
			oos.writeObject(request);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Request request = new Request();
		request.setFromUser(myUser);
		request.setToUser(friendUser);
		request.setServiceName(ClientResource.REMOTER_HELP_OPERATE);
		
		Operate operate = new Operate();
		operate.setX(arg0.getX());
		operate.setY(arg0.getY());
		operate.setOpition(Operate.MOUSERELEASED);
		request.setOperate(operate);
		
		try {
			oos.writeObject(request);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
