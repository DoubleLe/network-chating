package cn.edu.swu.clientFrame;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import cn.edu.swu.monitor.CancelButtonMonitor;
import cn.edu.swu.monitor.OffRegisterDialogButtonMonitor;
import cn.edu.swu.monitor.RegisterDialogMoveMouseMonitor;
import cn.edu.swu.monitor.RegisterDialogMoveMouseMotionMonitor;
import cn.edu.swu.monitor.RegisterFrameRegisterButtonMonitor;

public class RegisterDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private JLabel userNameLabel = new JLabel("昵称");
	private JLabel passwordLabel = new JLabel("密码");
	private JLabel passwordLabel2 = new JLabel("确认密码");
	private JLabel sexLabel = new JLabel("性别");
	
	private JLabel birthDayLabel = new JLabel("生日");
	private JLabel addressLabel = new JLabel("地址");
	
	private JTextField userNameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JPasswordField passwordField2 = new JPasswordField();
	private JTextField sexField = new JTextField();
	private JTextField birthDayField = new JTextField();
	private JTextField addressField = new JTextField();
	private JComboBox<ImageIcon> comBoBox = new JComboBox<ImageIcon>();
//	private JComboBox comBoBox = new JComboBox();
	private JTextArea qianMingText = new JTextArea();
	private JScrollPane qianMingScroll = new JScrollPane(qianMingText);
	
	
	private JButton registerButton = new JButton("确定");
	private JButton cancelButton = new JButton("取消");
	
	private JTextField userNameError = new JTextField();
	private JTextField passwordError = new JTextField();
	private JTextField passwordError2 = new JTextField();
	private JTextField sexError = new JTextField();
	private JTextField birthdayError = new JTextField();
	private JTextField addressError = new JTextField();
	private JLabel selectImageRemind = new JLabel("请选择您自己的头像 (未选择时将以默认图像为用户头像)");
	
	private static final int imageNumber = 10;
	public static boolean isDragged = false;
	public static Point firstFrame =null;
	public static Point secondFrame = null;
	


	public JComboBox<ImageIcon> getComBoBox() {
		return comBoBox;
	}
//	public JComboBox getComBoBox() {
//		return comBoBox;
//	}

	public JTextField getUserNameError() {
		return userNameError;
	}


	public JTextField getPasswordError() {
		return passwordError;
	}


	public JTextField getPasswordError2() {
		return passwordError2;
	}


	public JTextField getSexError() {
		return sexError;
	}


	public JTextField getBirthdayError() {
		return birthdayError;
	}


	public JTextField getAddressError() {
		return addressError;
	}


	public JLabel getUserNameLabel() {
		return userNameLabel;
	}


	public JLabel getPasswordLabel() {
		return passwordLabel;
	}


	public JLabel getPasswordLabel2() {
		return passwordLabel2;
	}


	public JLabel getSexLabel() {
		return sexLabel;
	}


	public JLabel getBirthDayLabel() {
		return birthDayLabel;
	}


	public JLabel getAddressLabel() {
		return addressLabel;
	}


	public JTextField getUserNameField() {
		return userNameField;
	}


	public JPasswordField getPasswordField() {
		return passwordField;
	}


	public JPasswordField getPasswordField2() {
		return passwordField2;
	}


	public JTextField getSexField() {
		return sexField;
	}


	public JTextField getBirthDayField() {
		return birthDayField;
	}


	public JTextField getAddressField() {
		return addressField;
	}


	public RegisterDialog() {
		Image mesg = this.getToolkit().getImage(RegisterDialog.class.getClassLoader().getResource("cn/edu/swu/picture/Mesg.jpg"));
		ImageIcon rigester = new ImageIcon(RegisterDialog.class.getClassLoader().getResource("cn/edu/swu/picture/rigester.jpg"));
		
		this.setSize(rigester.getIconWidth(), rigester.getIconHeight());
		this.setTitle("TT 注册");
		this.setIconImage(mesg);
		this.setModal(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//对话框设置背景颜色
		this.getContentPane().setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setLayout(null);
		
		this.addMouseListener(new RegisterDialogMoveMouseMonitor());
		this.addMouseMotionListener(new RegisterDialogMoveMouseMotionMonitor());
		
		JLabel label0 = new JLabel(rigester);
		label0.setBounds(0, 0, rigester.getIconWidth(), rigester.getIconHeight());
		this.add(label0);
		
		label0.setLayout(null);
		
		JPanel jp1 = new JPanel();
		jp1.setBounds(20, 120, rigester.getIconWidth()-280, rigester.getIconHeight()-150);
		jp1.setOpaque(false);
//		jp1.setBackground(Color.GREEN);
		label0.add(jp1);
		
		ImageIcon imag = new ImageIcon(RegisterDialog.class.getClassLoader().getResource("cn/edu/swu/picture/img/0.jpg"));
		JPanel jpRight = new JPanel();
		jpRight.setBounds(50, 20, imag.getIconWidth(), imag.getIconHeight());
		jpRight.setOpaque(false);
		label0.add(jpRight);
		
		
		JLabel labelQianMing = new JLabel("个性签名:");
		JLabel lab = new JLabel("(未签名时将添加默认签名)");
		lab.setForeground(Color.LIGHT_GRAY);
		lab.setBounds(560, 250, 200, 20);
		labelQianMing.setBounds(500, 250, 60, 20);
		label0.add(lab);
		label0.add(labelQianMing);
		
		qianMingText.setBounds(0, 0, 200, 200);
		qianMingText.setBorder(null);
		qianMingScroll.setBounds(500, 270, 200, 100);
		qianMingScroll.setBorder(null);
		label0.add(qianMingScroll);
		

		
		//提醒用户选择图片
		selectImageRemind.setBounds(50, 120, 350, 20);
		selectImageRemind.setForeground(Color.LIGHT_GRAY);
		label0.add(selectImageRemind);
		
		//为comboBox设置图像
		ImageIcon[] image = new ImageIcon[imageNumber];
		for(int i = 0; i<imageNumber;i++){
			image[i] = new ImageIcon(RegisterDialog.class.getClassLoader().getResource("cn/edu/swu/picture/img/"+i+".jpg"));
			comBoBox.addItem(image[i]);
		}
		jpRight.setLayout(null);
		comBoBox.setBounds(0, 0, 100, imag.getIconHeight());
		comBoBox.setMaximumRowCount(imageNumber);
		jpRight.add(comBoBox);

		ImageIcon registerDialogOff = new ImageIcon(RegisterDialog.class.getClassLoader().getResource("cn/edu/swu/picture/rigestOff1.jpg"));
		JButton offButton = new JButton(registerDialogOff);
		offButton.setBounds(rigester.getIconWidth()-registerDialogOff.getIconWidth(), 0, registerDialogOff.getIconWidth(), registerDialogOff.getIconHeight());
		offButton.setBorder(null);
		label0.add(offButton);
		offButton.addMouseListener(new OffRegisterDialogButtonMonitor());
		
		
		jp1.setLayout(null);
		
		userNameLabel.setBounds(80, 25, 50, 20);
		jp1.add(userNameLabel);
		userNameField.setBounds(130, 22, 200, 25);
		jp1.add(userNameField);
		
		userNameError.setBounds(350, 25, 100, 20);
		userNameError.setEditable(false);
		userNameError.setBorder(null);
		userNameError.setOpaque(false);
		jp1.add(userNameError);
		
		passwordLabel.setBounds(80, 65, 50, 20);
		jp1.add(passwordLabel);
		passwordField.setBounds(130, 62, 200, 25);
		jp1.add(passwordField);
		
		passwordError.setBounds(350, 65, 100, 20);
		passwordError.setEditable(false);
//		passwordError.setBackground(Color.WHITE);
		passwordError.setOpaque(false);
		passwordError.setBorder(null);
		jp1.add(passwordError);
		
		passwordLabel2.setBounds(60, 105, 60, 20);
		jp1.add(passwordLabel2);
		passwordField2.setBounds(130, 102, 200, 25);
		jp1.add(passwordField2);
		
		passwordError2.setBounds(350, 105, 130, 20);
		passwordError2.setEditable(false);
//		passwordError2.setBackground(Color.WHITE);
		passwordError2.setOpaque(false);
		passwordError2.setBorder(null);
		jp1.add(passwordError2);
		
		sexLabel.setBounds(80, 145, 50, 20);
		jp1.add(sexLabel);
		sexField.setBounds(130, 142, 200, 25);
		jp1.add(sexField);
		
		sexError.setBounds(350, 145, 150, 20);
		sexError.setEditable(false);
//		sexError.setBackground(Color.WHITE);
		sexError.setOpaque(false);
		sexError.setBorder(null);
		jp1.add(sexError);
		
		birthDayLabel.setBounds(80, 185, 50, 20);
		jp1.add(birthDayLabel);
		birthDayField.setBounds(130, 182, 200, 25);
		jp1.add(birthDayField);
		
		birthdayError.setBounds(350, 185, 100, 20);
		birthdayError.setEditable(false);
//		birthdayError.setBackground(Color.WHITE);
		birthdayError.setOpaque(false);
		birthdayError.setBorder(null);
		jp1.add(birthdayError);
		
		addressLabel.setBounds(80, 225, 50, 20);
		jp1.add(addressLabel);
		addressField.setBounds(130, 222, 200, 25);
		jp1.add(addressField);
		
		addressError.setBounds(350, 225, 100, 20);
		addressError.setEditable(false);
//		addressError.setBackground(Color.WHITE);
		addressError.setOpaque(false);
		addressError.setBorder(null);
		jp1.add(addressError);
		
		registerButton.addActionListener(new RegisterFrameRegisterButtonMonitor());
		registerButton.setBounds(60, 270, 70, 25);
		jp1.add(registerButton);
		
		cancelButton.addActionListener(new CancelButtonMonitor());
		cancelButton.setBounds(280, 270, 70, 25);
		jp1.add(cancelButton);
	}
	
	public JTextArea getQianMingText() {
		return qianMingText;
	}


//	public static void main(String[] args) {
//		new RegisterDialog().setVisible(true);
//	}

}
