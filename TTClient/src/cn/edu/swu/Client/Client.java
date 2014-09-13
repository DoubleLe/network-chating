package cn.edu.swu.Client;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import cn.edu.swu.clientFrame.AddFriendFrame;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.clientFrame.LoginFrame;
import cn.edu.swu.clientFrame.MessageFrame;
import cn.edu.swu.clientFrame.RegisterDialog;
import cn.edu.swu.clientFrame.UsersDialog;

public class Client {
	public static LoginFrame loginFrame;
	public static RegisterDialog registerFrame;
	public static FriendFrame friendsFrame;
	public static AddFriendFrame addFriendFrame;
	public static UsersDialog usersDialog;
	public static Map<String, MessageFrame> MESSAGE_FRAME_MAP = new HashMap<String, MessageFrame>();
	public static Map<String, String> MESSAGE_MAP = new HashMap<String, String>();
	public static int AddFriendFrameCount = 0;
	public static int UsersDiaLogCount = 0;
	public static int friendListCount = 0;
	public static int userPanelCount = 0;
	public static JPanel[] friendListpanelBackgrund = new JPanel[100];
	public static final Map<String, JPanel> friendListPanelMap = new HashMap<String, JPanel>();
	
	
	public static void main(String[] args) {
		loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}
	
	static{
		for(int i = 0;i<100;i++){
			Client.friendListpanelBackgrund[i] = new JPanel();
		}
	}
}
