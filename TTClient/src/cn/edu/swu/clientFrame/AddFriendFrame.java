package cn.edu.swu.clientFrame;


import java.awt.Image;
import java.awt.Point;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.swu.monitor.AddFriendFrameButtonMini;
import cn.edu.swu.monitor.AddFriendFrameButtonOff;
import cn.edu.swu.monitor.AddFriendFrameButtonSearchMonitor;
import cn.edu.swu.monitor.AddFriendFrameMouseMonitor;
import cn.edu.swu.monitor.AddFriendFrameMouseMotionMonitor;

public class AddFriendFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8506033187781783028L;
	public static boolean isDragged = false;
	public static Point xFrame =null;
	public static Point yFrame = null;
	public static JTextField jpError;
	public static JTextField userIdAdd;

	public AddFriendFrame (ObjectOutputStream oos){
//		ImageIcon friendsl = new ImageIcon(AddFriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/SearchImag.jpg"));
//		System.getProperty("user.dir")+"/src/cn/edu/swu/picture/Mesg.jpg"
//		System.getProperty("user.dir")+"/src/cn/edu/swu/picture/Xr1.jpg"
		Image mesg = this.getToolkit().getImage(AddFriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Mesg.jpg"));	
		ImageIcon bgImag = new ImageIcon(AddFriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Xr1.jpg"));
		
		this.setIconImage(mesg);
		this.setSize(bgImag.getIconWidth(), bgImag.getIconHeight());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		
		this.addMouseListener(new AddFriendFrameMouseMonitor());
		this.addMouseMotionListener(new AddFriendFrameMouseMotionMonitor());
		
		this.setLayout(null);
		JLabel label0 = new JLabel(bgImag);
		label0.setBounds(0, 0, bgImag.getIconWidth(), bgImag.getIconHeight());
		this.add(label0);
		
		label0.setLayout(null);
		JPanel jp0 = new JPanel();
		jp0.setBounds(0, 0, bgImag.getIconWidth(), bgImag.getIconHeight());
		jp0.setOpaque(false);
		label0.add(jp0);
		
		//System.getProperty("user.dir")+"/src/cn/edu/swu/picture/4.jpg"
		//System.getProperty("user.dir")+"/src/cn/edu/swu/picture/5.jpg"
		//System.getProperty("user.dir")+"/src/cn/edu/swu/picture/SearchImag.jpg"
		ImageIcon buttonOffImag = new ImageIcon(AddFriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/4.jpg"));
		ImageIcon buttonMinImag = new ImageIcon(AddFriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/5.jpg"));
		ImageIcon buttonSearImag = new ImageIcon(AddFriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/SearchImag.jpg"));
		jp0.setLayout(null);
		
		userIdAdd = new JTextField("请输入对方的 ID");
		userIdAdd.setBounds(40, 120, 300, 40);
		jp0.add(userIdAdd);
		
		JButton buttonSearch = new JButton(buttonSearImag);
		buttonSearch.setBounds(380, 120, buttonSearImag.getIconWidth(), buttonSearImag.getIconHeight());
//		buttonSearch.setBorder(null);
		jp0.add(buttonSearch);
		buttonSearch.addActionListener(new AddFriendFrameButtonSearchMonitor(oos));
		
		
		jpError = new JTextField("");
		jpError.setBounds(40, 70, 400, 30);
		jpError.setBorder(null);
		jpError.setEditable(false);
		jpError.setOpaque(false);
		jp0.add(jpError);
		
		
		JButton buttonOff = new JButton(buttonOffImag);
		buttonOff.setBounds(bgImag.getIconWidth()-buttonOffImag.getIconWidth(), 0, buttonOffImag.getIconWidth(), buttonOffImag.getIconHeight());
		buttonOff.setToolTipText("关闭");
		jp0.add(buttonOff);
		buttonOff.setBorder(null);
		buttonOff.addMouseListener(new AddFriendFrameButtonOff());
		
		JButton buttonMin = new JButton(buttonMinImag);
		buttonMin.setBounds(bgImag.getIconWidth()-buttonOffImag.getIconWidth()-buttonMinImag.getIconWidth(), 0, buttonMinImag.getIconWidth(), buttonMinImag.getIconHeight());
		buttonMin.setToolTipText("最小化");
		jp0.add(buttonMin);
		buttonMin.setBorder(null);
		buttonMin.addMouseListener(new AddFriendFrameButtonMini());
	}
}
