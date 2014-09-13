package test;


import java.awt.Image;
import java.awt.Point;

import java.awt.Toolkit;

import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cn.edu.swu.modle.User;
import cn.edu.swu.monitor.ButtonFindMonitor;
import cn.edu.swu.monitor.FriendFrameMoveMouseMonitor;
import cn.edu.swu.monitor.FriendFrameMoveMouseMotionMonitor;
import cn.edu.swu.monitor.MinButtonFriendFrameMonitor;


public class FriendFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private ObjectOutputStream oosu;
	public static User loginUser;
	@SuppressWarnings("rawtypes")
	public static JList userList = new JList();
//	public static JPanel jp21 = new JPanel(); 
	public static JScrollPane scoll = new JScrollPane();
	
	public static boolean isDragged = false;
	public static Point firstFrame =null;
	public static Point secondFrame = null;
	
	public FriendFrame(){
//		this.oosu = oos;
//		FriendFrame.loginUser = response.getUser();
		
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
//		JLabel[] jp22 = new JLabel[4];
//		JPanel jp21 = new JPanel(new GridLayout(5, 1, 2, 2));
////		jp21.setLayout(new GridLayout(5, 1, 2, 2));
////		jp21.setLayout(null);
//		
//		
//		for(int i = 0;i<jp22.length;i++){
//			jp22[i] = new JLabel("好友"+(i+1), new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/img/"+i+".jpg")), JLabel.LEFT);
//			jp21.add(jp22[i]);
//		}
//		
//		scoll = new JScrollPane(jp21);
		
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Image mesg = this.getToolkit().getImage(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Mesg.jpg"));		
		ImageIcon friendsl = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/FriendList.jpg"));
		ImageIcon offImag = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Off.jpg"));
		ImageIcon minImag = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Min.jpg"));
		
		this.setTitle("TT 2012");
		this.setIconImage(mesg);
		this.setSize(friendsl.getIconWidth(), friendsl.getIconHeight());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width-400;
		int y = 40;
		this.setLocation(x, y);
		this.setUndecorated(true);
		
		this.addMouseListener(new FriendFrameMoveMouseMonitor());
		this.addMouseMotionListener(new FriendFrameMoveMouseMotionMonitor());
		
		
		JLabel label0 = new JLabel(friendsl);
		label0.setBounds(0, 0, friendsl.getIconWidth(), friendsl.getIconHeight());
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(label0, Integer.MIN_VALUE);
		
		label0.setLayout(null);
		
		JButton offImageButton = new JButton(offImag);
		offImageButton.setBounds(friendsl.getIconWidth()-offImag.getIconWidth(), 0, offImag.getIconWidth(), offImag.getIconHeight());
		offImageButton.setBorder(null);
		label0.add(offImageButton);
//		offImageButton.addMouseListener(new OffFButtonriendFrameMonitor(oos, FriendFrame.loginUser));
		
		JButton minImageButton = new JButton(minImag);
		minImageButton.setBounds(friendsl.getIconWidth()-offImag.getIconWidth()-minImag.getIconWidth(), 0, offImag.getIconWidth(), offImag.getIconHeight());
		minImageButton.setBorder(null);
		label0.add(minImageButton);
		minImageButton.addMouseListener(new MinButtonFriendFrameMonitor());
		
		JPanel topJp = new JPanel();
		topJp.setBounds(0, 0, friendsl.getIconWidth(), 130);
		topJp.setOpaque(false);
		label0.add(topJp);
		
		topJp.setLayout(null);
		JLabel labelTopTop = new JLabel("谈一谈 2012");
		labelTopTop.setBounds(5, 0, friendsl.getIconWidth()/3, 20);
		topJp.add(labelTopTop);
		
		JLabel labelTop = new JLabel("sun (2012)");
		labelTop.setBounds(120, 30, friendsl.getIconWidth()/3, 25);
		topJp.add(labelTop);
		
		JLabel labelTopUnder = new JLabel("好人一生平安");
		labelTopUnder.setBounds(100, 60, 300, 20);
		topJp.add(labelTopUnder);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		ImageIcon headImage = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/img/1.jpg"));
		
		JLabel labelTopLeft = new JLabel(headImage);
		labelTopLeft.setBounds(8, 30, 80, 80);
		topJp.add(labelTopLeft);
		
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		ImageIcon bottommg = new ImageIcon(System.getProperty("user.dir")+"/src/cn/edu/swu/picture/Bottommg.jpg");
		JPanel bottomJp = new JPanel();
		bottomJp.setOpaque(false);
		bottomJp.setBounds(0, friendsl.getIconHeight()-100, bottommg.getIconWidth(), bottommg.getIconHeight());
		label0.add(bottomJp);
		
		JPanel centerJp = new JPanel();
		centerJp.setBounds(0, 130, friendsl.getIconWidth(), friendsl.getIconHeight()-bottommg.getIconHeight()-130);
		centerJp.setOpaque(false);
		label0.add(centerJp);
////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		
//		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		FriendListMonitor ulm = new FriendListMonitor(FriendFrame.loginUser, oos);
//		userList.addMouseListener(ulm);
		centerJp.setLayout(null);
		FriendFrame.scoll.setBounds(4, 0, friendsl.getIconWidth()-8, friendsl.getIconHeight()-bottommg.getIconHeight()-130);
		centerJp.add(FriendFrame.scoll);
//		
////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JLabel labelmg = new JLabel(bottommg);
		labelmg.setBounds(0, 0, bottommg.getIconWidth(), bottommg.getIconHeight());
		bottomJp.add(labelmg);
		
		ImageIcon findmg = new ImageIcon(System.getProperty("user.dir")+"/src/cn/edu/swu/picture/FindFriend.jpg");
		JButton buttonFind = new JButton(findmg);
		buttonFind.setBounds(15, 15, findmg.getIconWidth(), findmg.getIconHeight());
		labelmg.add(buttonFind);
		buttonFind.addActionListener(new ButtonFindMonitor(FriendFrame.loginUser,oosu));
		
		ImageIcon addmg = new ImageIcon(System.getProperty("user.dir")+"/src/cn/edu/swu/picture/AddFriend.jpg");
		JButton buttonAdd = new JButton(addmg);
		buttonAdd.setBounds(200, 15, addmg.getIconWidth(), addmg.getIconHeight());
		labelmg.add(buttonAdd);
//		buttonAdd.addActionListener(new ButtonAddFriendMonitor(oos));
		
		
	}
	
//	public static void main(String[] args) {
//		FriendFrame ff = new FriendFrame();
//		ff.setVisible(true);
//		
//		new Add();
//	}

}