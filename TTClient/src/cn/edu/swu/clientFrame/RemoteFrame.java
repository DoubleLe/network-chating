package cn.edu.swu.clientFrame;

import java.awt.Graphics;

import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import cn.edu.swu.modle.User;
import cn.edu.swu.monitor.RemoteKeyMonitor;
import cn.edu.swu.monitor.RemoteMouseMonitor;

public class RemoteFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private static RemoteFrame remoteFrame;
	
	private RemoteFrame(User myselfUser, User friendUser, ObjectOutputStream oos){
		//鼠标监听
		RemoteMouseMonitor rrm = new RemoteMouseMonitor(myselfUser, friendUser, oos);
		//鼠标事件监听
		this.addMouseListener(rrm);
		//鼠标移动监听
		this.addMouseMotionListener(rrm);
		
		//键盘事件监听
		this.addKeyListener(new RemoteKeyMonitor(myselfUser, friendUser, oos, remoteFrame));
		this.setAlwaysOnTop(true);
		this.setFocusable(true);
	}
	
	public synchronized static RemoteFrame getInstance(ImageIcon icon, User myselfUser, User FriendUser, ObjectOutputStream oos){
		if(remoteFrame==null){
			remoteFrame = new RemoteFrame(myselfUser, FriendUser, oos);
		}
		if(!remoteFrame.isUndecorated()){
			remoteFrame.setUndecorated(true);
		}
		remoteFrame.icon = icon;
		remoteFrame.setSize(remoteFrame.icon.getIconWidth(), remoteFrame.icon.getIconHeight());
		return remoteFrame;
	}
	
	public synchronized static void resert(){
		remoteFrame = null;
	}

	@Override
	public void paint(Graphics arg0) {
		arg0.drawImage(remoteFrame.icon.getImage(), 0, 0, remoteFrame.icon.getIconWidth(), remoteFrame.icon.getIconHeight(), 0, 0, remoteFrame.icon.getIconWidth(), remoteFrame.icon.getIconHeight(), remoteFrame);
	}
	

}
