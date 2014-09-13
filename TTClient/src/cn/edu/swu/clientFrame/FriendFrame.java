package cn.edu.swu.clientFrame;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cn.edu.swu.Client.Client;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;
import cn.edu.swu.modle.User;
import cn.edu.swu.monitor.ButtonAddFriendMonitor;
import cn.edu.swu.monitor.ButtonFindMonitor;
import cn.edu.swu.monitor.FriendFrameMoveMouseMonitor;
import cn.edu.swu.monitor.FriendFrameMoveMouseMotionMonitor;
import cn.edu.swu.monitor.FriendListMonitor;
import cn.edu.swu.monitor.MinButtonFriendFrameMonitor;
import cn.edu.swu.monitor.OffFButtonriendFrameMonitor;


public class FriendFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private ObjectOutputStream oosu;
	public static User loginUser;
	public static JPanel jp21 = new JPanel();
	public static JScrollPane scoll = new JScrollPane(jp21);
	
	public static boolean isDragged = false;
	public static Point firstFrame =null;
	public static Point secondFrame = null;
//	private String[] words = new String[]{"路遥知马力，日久见人心","世上本无事，庸人自扰之","大行不顾细谨，大礼不辞小让","黑夜给了我黑色的眼睛，我却用它寻找光明","酌贪泉而觉爽，处涸辙以犹欢","自由代表的是内心永久的孤独","半醒半醉日复日，花落花开年复年","暮晓春来迟，先于百花知","孩儿立志出乡关，学不成名誓不还","宜将乘勇追穷寇，不可沽名学霸王"};
	
	public FriendFrame(ObjectInputStream ois,ObjectOutputStream oos,Response response){
		this.oosu = oos;
		FriendFrame.loginUser = response.getUser();
		
		Image mesg = this.getToolkit().getImage(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Mesg.jpg"));		
		ImageIcon friendsl = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/FriendList.jpg"));
		ImageIcon offImag = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Off.jpg"));
		ImageIcon minImag = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Min.jpg"));
		
		this.setTitle("谈一谈 2012");
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
		offImageButton.setToolTipText("关闭");
		offImageButton.addMouseListener(new OffFButtonriendFrameMonitor(oos, FriendFrame.loginUser));
		
		JButton minImageButton = new JButton(minImag);
		minImageButton.setBounds(friendsl.getIconWidth()-offImag.getIconWidth()-minImag.getIconWidth(), 0, offImag.getIconWidth(), offImag.getIconHeight());
		minImageButton.setBorder(null);
		label0.add(minImageButton);
		minImageButton.setToolTipText("最小化");
		minImageButton.addMouseListener(new MinButtonFriendFrameMonitor());
		
		JPanel topJp = new JPanel();
		topJp.setBounds(0, 0, friendsl.getIconWidth(), 130);
		topJp.setOpaque(false);
		label0.add(topJp);
		
		topJp.setLayout(null);
		JLabel labelTopTop = new JLabel("谈一谈 2012");
		labelTopTop.setBounds(5, 0, friendsl.getIconWidth()/3, 20);
		topJp.add(labelTopTop);
		
		JLabel labelTop = new JLabel(loginUser.getUserName()+" ("+loginUser.getUserId()+")");
		labelTop.setBounds(120, 30, friendsl.getIconWidth()/3, 25);
		topJp.add(labelTop);
		
		JLabel labelTopUnder = new JLabel(FriendFrame.loginUser.getWordsQianMing());//words[getRandom()]
		labelTopUnder.setToolTipText(FriendFrame.loginUser.getWordsQianMing());
		labelTopUnder.setBounds(100, 60, 300, 20);
		topJp.add(labelTopUnder);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		ImageIcon headImage = FriendFrame.loginUser.getImageIcon();
		JLabel labelTopLeft = new JLabel(headImage);
		labelTopLeft.setBounds(8, 30, 80, 80);
		topJp.add(labelTopLeft);
		
		ImageIcon bottommg = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Bottommg.jpg"));
		JPanel bottomJp = new JPanel();
		bottomJp.setOpaque(false);
		bottomJp.setBounds(0, friendsl.getIconHeight()-100, bottommg.getIconWidth(), bottommg.getIconHeight());
		label0.add(bottomJp);
		
		JPanel centerJp = new JPanel();
		centerJp.setBounds(0, 130, friendsl.getIconWidth(), friendsl.getIconHeight()-bottommg.getIconHeight()-130);
		centerJp.setOpaque(false);
		label0.add(centerJp);
////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		centerJp.setLayout(null);
		FriendFrame.scoll.setBounds(4, 0, friendsl.getIconWidth()-8, friendsl.getIconHeight()-bottommg.getIconHeight()-130);
		FriendFrame.scoll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		FriendFrame.scoll.setAutoscrolls(true);
		centerJp.add(FriendFrame.scoll);
////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JLabel labelmg = new JLabel(bottommg);
		labelmg.setBounds(0, 0, bottommg.getIconWidth(), bottommg.getIconHeight());
		bottomJp.add(labelmg);
		
		ImageIcon findmg = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/FindFriend.jpg"));
		JButton buttonFind = new JButton(findmg);
		buttonFind.setBounds(15, 15, findmg.getIconWidth(), findmg.getIconHeight());
		labelmg.add(buttonFind);
		buttonFind.addActionListener(new ButtonFindMonitor(FriendFrame.loginUser,oosu));
		
		ImageIcon addmg = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/AddFriend.jpg"));
		JButton buttonAdd = new JButton(addmg);
		buttonAdd.setBounds(200, 15, addmg.getIconWidth(), addmg.getIconHeight());
		labelmg.add(buttonAdd);
		buttonAdd.addActionListener(new ButtonAddFriendMonitor(oos));
		System.out.println("FriendFrame---------------------->"+FriendFrame.loginUser.getWordsQianMing());
		
		requestFriendList();
	}
	
	public void requestFriendList(){
		Request request = new Request();
		request.setFromUser(FriendFrame.loginUser);//用户自己
		request.setServiceName(ClientResource.FRIENDLIST);
		try {
			oosu.writeObject(request);
			oosu.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getRandom(){
		return (int)((Math.random()*(9-0+1))+0);
	}
	
	public static void friendFrameFlush(Response response, JPanel jp21, ObjectOutputStream oos){
		ImageIcon friendsl = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/FriendList.jpg"));
		Client.friendListPanelMap.clear();
		
		int count = 0;
		count = response.getFriendList().size();
        	
		JLabel[] jp22 = new JLabel[count];
		JLabel[] jpQianMing = new JLabel[count];
		if(count>=5){
			FriendFrame.jp21.setPreferredSize(new Dimension(0, count*90));
		}
		FriendFrame.jp21.setLayout(null);
		
		FriendFrame.jp21.setBounds(0, 0, friendsl.getIconWidth()-8, count*90);
		if(count>=5){
			FriendFrame.jp21.setBackground(Color.ORANGE);
		}
		
		int i = 0;
		
		for(int j = 0;j<Client.friendListCount;j++){
			Client.friendListpanelBackgrund[j].remove(0);
			FriendFrame.jp21.remove(0);//每删除一个，下一个就会变为第0个
		}
		
		ImageIcon imageIco = new ImageIcon();
		for(i = 0;i<count;i++){
			Client.friendListpanelBackgrund[i].setLayout(null);
			
			System.out.println(response.getFriendList().get(i).getUserName()+": "+response.getFriendList().get(i).getImageIcon().toString().indexOf("."));
			System.out.println(response.getFriendList().get(i).getImageIcon());
			
			if(response.getFriendList().get(i).getIp()!=null){
				imageIco = response.getFriendList().get(i).getImageIcon();
			}else{
				int k = response.getFriendList().get(i).getImageIcon().toString().indexOf(".");
				int imagCount = Integer.parseInt(response.getFriendList().get(i).getImageIcon().toString().substring(k-1, k));
				imageIco = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/imOff/"+imagCount+".jpg"));
			}
			
			System.out.println(imageIco+":"+response.getFriendList().get(i).getIp());
			jpQianMing[i] = new JLabel(response.getFriendList().get(i).getWordsQianMing());
			jp22[i] = new JLabel(response.getFriendList().get(i).toString(), imageIco, JLabel.LEFT);
			
			jp22[i].setToolTipText(response.getFriendList().get(i).getWordsQianMing());
			
			jpQianMing[i].setBounds(imageIco.getIconWidth()+5, imageIco.getIconHeight()/2-3, friendsl.getIconWidth()-8-imageIco.getIconWidth()-5, imageIco.getIconHeight()/2-5);
			jp22[i].add(jpQianMing[i]);
			jp22[i].setBounds(0, 0, friendsl.getIconWidth()-8, response.getFriendList().get(i).getImageIcon().getIconHeight());
			Client.friendListpanelBackgrund[i].setBounds(2, response.getFriendList().get(i).getImageIcon().getIconHeight()*i+2*i, friendsl.getIconWidth()-8, response.getFriendList().get(i).getImageIcon().getIconHeight());
			Client.friendListpanelBackgrund[i].setBackground(Color.WHITE);
			Client.friendListpanelBackgrund[i].add(jp22[i]);
			Client.friendListPanelMap.put(response.getFriendList().get(i).getUserId(), Client.friendListpanelBackgrund[i]);
			
			jp22[i].addMouseListener(new FriendListMonitor(FriendFrame.loginUser, response.getFriendList().get(i), oos));
			Client.friendListpanelBackgrund[i].repaint();
			FriendFrame.jp21.add(Client.friendListpanelBackgrund[i]);
			Client.friendListpanelBackgrund[i].repaint();
			
			
		}
		Client.friendListCount = i;
		FriendFrame.jp21.repaint();
		
	}
}
