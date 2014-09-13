package cn.edu.swu.clientFrame;


import java.awt.Image;
import java.awt.Point;




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.edu.swu.monitor.LoginButtonMonitor;
import cn.edu.swu.monitor.LoginFrameButtonMiniMonitor;
import cn.edu.swu.monitor.LoginFrameButtonOffMonitor;
import cn.edu.swu.monitor.LoginFrameMoveMouseMonitor;
import cn.edu.swu.monitor.LoginFrameMoveMouseMotionMonitor;
import cn.edu.swu.monitor.registerButtonMonitor;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField idField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JButton loginButton = new JButton("登录");
	private JButton registerButton = new JButton("注册");
	private JLabel userIdLabel = new JLabel("帐号");
	private JLabel passwordLabel = new JLabel("密码");
	public static boolean isDragged = false;
	public static Point firstFrame =null;
	public static Point secondFrame = null;
	
	
	
	public JTextField getIdField() {
		return idField;
	}



	public JPasswordField getPasswordField() {
		return passwordField;
	}



	public LoginFrame(){
		
//		ImageIcon offImag = new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/aa.jpg"));
//		System.getProperty("user.dir")+"/src/cn/edu/swu/picture/Mesg.jpg"
//		System.getProperty("user.dir")+"/src/cn/edu/swu/picture/Framebg.jpg"
		Image mesg = this.getToolkit().getImage(LoginFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Mesg.jpg"));
		ImageIcon Frameimg = new ImageIcon(LoginFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Framebg.jpg"));
		this.setTitle("TT 2012");
		this.setIconImage(mesg);
		//窗口大小,有背景图片决定
		this.setSize(Frameimg.getIconWidth(), Frameimg.getIconHeight());	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		//窗口位置，在中央显示
		this.setLocationRelativeTo(null);	
		//禁止最大化窗口
		this.setResizable(false);
		this.setUndecorated(true);
		
		JLabel label0 = new JLabel(Frameimg);
		label0.setBounds(0, 0, Frameimg.getIconWidth(), Frameimg.getIconHeight());
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(label0, Integer.MIN_VALUE);
		
		this.addMouseListener(new LoginFrameMoveMouseMonitor());
		this.addMouseMotionListener(new LoginFrameMoveMouseMotionMonitor());
		label0.setLayout(null);
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		System.getProperty("user.dir")+"/src/cn/edu/swu/picture/aa.jpg"
//		System.getProperty("user.dir")+"/src/cn/edu/swu/picture/bb.jpg"
		ImageIcon buttonOffImag = new ImageIcon(LoginFrame.class.getClassLoader().getResource("cn/edu/swu/picture/aa.jpg"));
		ImageIcon buttonMinImag = new ImageIcon(LoginFrame.class.getClassLoader().getResource("cn/edu/swu/picture/bb.jpg"));
		
		JButton buttonOff = new JButton(buttonOffImag);
		buttonOff.setBounds(Frameimg.getIconWidth()-buttonOffImag.getIconWidth(), 0, buttonOffImag.getIconWidth(), buttonOffImag.getIconHeight());
		buttonOff.setToolTipText("关闭");
		label0.add(buttonOff);
		buttonOff.setBorder(null);
		buttonOff.addMouseListener(new LoginFrameButtonOffMonitor());
		
		JButton buttonMin = new JButton(buttonMinImag);
		buttonMin.setBounds(Frameimg.getIconWidth()-buttonOffImag.getIconWidth()-buttonMinImag.getIconWidth(), 0, buttonMinImag.getIconWidth(), buttonMinImag.getIconHeight());
		buttonMin.setToolTipText("最小化");
		label0.add(buttonMin);
		buttonMin.setBorder(null);
		buttonMin.addMouseListener(new LoginFrameButtonMiniMonitor());
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		userIdLabel.setBounds(80, 110, 30, 30);
		label0.add(userIdLabel);
		idField.setBounds(120, 110, 182, 30);
		label0.add(idField);
		passwordLabel.setBounds(80, 155, 30, 30);
		label0.add(passwordLabel);
		passwordField.setBounds(120, 155, 182, 30);
		label0.add(passwordField);

		LoginButtonMonitor buttonListener1= new LoginButtonMonitor();
		loginButton.addActionListener(buttonListener1);
		loginButton.setBounds(90, 230, 60, 30);
		label0.add(loginButton);
		
		registerButtonMonitor buttonListener2 = new registerButtonMonitor();
		registerButton.addActionListener(buttonListener2);
		registerButton.setBounds(260, 230, 60, 30);
		label0.add(registerButton);
		
	}
}
