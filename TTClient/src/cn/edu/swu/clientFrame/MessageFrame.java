package cn.edu.swu.clientFrame;

import java.awt.Color;

import java.awt.Point;



import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import cn.edu.swu.modle.User;
import cn.edu.swu.monitor.MessageFrameMoveMouseMonitor;
import cn.edu.swu.monitor.MessageFrameMoveMouseMotionMonitor;
import cn.edu.swu.monitor.MessageWindowMonitor;
import cn.edu.swu.monitor.MinMessageButtonMonitor;
import cn.edu.swu.monitor.OffMessageButtonMonitor;
import cn.edu.swu.monitor.RemoterHelpButtonMonitor;
import cn.edu.swu.monitor.SendMessageButtonMonitor;


public class MessageFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextArea viewTop = new JTextArea();
	private JScrollPane viewscollTop = new JScrollPane(viewTop);
	
	private JTextArea send = new JTextArea();
	private JScrollPane sendscoll = new JScrollPane(send);
//	private String[] words = new String[]{"·ң֪�������վü�����","���ϱ����£�ӹ������֮","���в���ϸ�������񲻴�С��","��ҹ�����Һ�ɫ���۾�����ȴ����Ѱ�ҹ���","��̰Ȫ����ˬ�����������̻�","���ɴ�������������õĹ¶�","���Ѱ����ո��գ����仨���긴��","ĺ�������٣����ڰٻ�֪","������־����أ�ѧ�������Ĳ���","�˽�����׷��ܣ����ɹ���ѧ����"};
	
	
	
	private boolean isDragged = false;
	private Point firstFrame =null;
	private Point secondFrame = null; 
	
	

	public boolean isDragged() {
		return isDragged;
	}



	public void setDragged(boolean isDragged) {
		this.isDragged = isDragged;
	}



	public Point getFirstFrame() {
		return firstFrame;
	}



	public void setFirstFrame(Point firstFrame) {
		this.firstFrame = firstFrame;
	}



	public Point getSecondFrame() {
		return secondFrame;
	}



	public void setSecondFrame(Point secondFrame) {
		this.secondFrame = secondFrame;
	}



	public JTextArea getViewTop() {
		return viewTop;
	}



	public void setViewTop(JTextArea viewTop) {
		this.viewTop = viewTop;
	}



	public JTextArea getSend() {
		return send;
	}



	public void setSend(JTextArea send) {
		this.send = send;
	}



	public MessageFrame(User fromUser,ObjectOutputStream oos, User toUser){
		
		this.addWindowListener(new MessageWindowMonitor(toUser));
		
		Image mesg = this.getToolkit().getImage(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Mesg.jpg"));
		this.setTitle("TT 2012");
		this.setIconImage(mesg);
		this.setSize(536, 503);//this.setSize(540, 530);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);				//����λ��
		this.setResizable(false);		
		this.setLayout(null);
		this.setUndecorated(true);//ȥ���߿�͹رհ�ť
		
		this.addMouseListener(new MessageFrameMoveMouseMonitor(toUser));
		this.addMouseMotionListener(new MessageFrameMoveMouseMotionMonitor(toUser));
		
		JPanel jp0 = new JPanel();
		jp0.setBounds(0, 0, 540, 530);
		jp0.setBackground(new Color(144, 164, 184));
		this.add(jp0);
		
		jp0.setLayout(null);
		
		ImageIcon imgiconTopb = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Topb.jpg"));
		JLabel labelTopb = new JLabel(imgiconTopb);
		labelTopb.setBounds(0, 0, imgiconTopb.getIconWidth(), imgiconTopb.getIconHeight());
		jp0.add(labelTopb);
		
		ImageIcon messageOffImag = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/MessageOff.jpg"));
		JButton offButton = new JButton(messageOffImag);
		offButton.setBounds(imgiconTopb.getIconWidth()-messageOffImag.getIconWidth(), 0, messageOffImag.getIconWidth(), messageOffImag.getIconHeight());
		offButton.setBorder(null);
		offButton.setToolTipText("�ر�");
		labelTopb.add(offButton);
		offButton.addActionListener(new OffMessageButtonMonitor(toUser));
		
		ImageIcon messageMinImag = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/MessageMin.jpg"));
		JButton minButton = new JButton(messageMinImag);
		minButton.setBounds(imgiconTopb.getIconWidth()-messageOffImag.getIconWidth()-messageMinImag.getIconWidth(), 0, messageMinImag.getIconWidth(), messageMinImag.getIconHeight());
		minButton.setBorder(null);
		minButton.setToolTipText("��С��");
		labelTopb.add(minButton);
		minButton.addActionListener(new MinMessageButtonMonitor(toUser));
		
		JPanel jp1Top = new JPanel();
		jp1Top.setBounds(0, 0, 540, 90);
		jp1Top.setOpaque(false);
		labelTopb.add(jp1Top);

		jp1Top.setLayout(null);
		
//		ImageIcon headImage = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/img/"+getRandom()+".jpg"));
		
		ImageIcon headImage = toUser.getImageIcon();
		JLabel labelTopLeft = new JLabel(headImage);
		labelTopLeft.setBounds(5, 5, 80, 80);
		jp1Top.add(labelTopLeft);
		
		
		
		
		JLabel labelUserName = new JLabel(toUser.getUserName()+" ("+toUser.getUserId()+")");
		labelUserName.setBounds(100, 10, 160, 20);
		jp1Top.add(labelUserName);
		
		JLabel labelUserWords = new JLabel(toUser.getWordsQianMing());//words[getRandom()]
		labelUserWords.setBounds(100, 30, 300, 20);
		jp1Top.add(labelUserWords);
		
		ImageIcon remoterHelpImage = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/RemoterHelp.jpg"));
		JButton remoterHelpButton = new JButton(remoterHelpImage);
		remoterHelpButton.setBounds(410, 38, remoterHelpImage.getIconWidth(), remoterHelpImage.getIconHeight());
		remoterHelpButton.setBorder(null);
		jp1Top.add(remoterHelpButton);
		remoterHelpButton.addActionListener(new RemoterHelpButtonMonitor(fromUser, toUser, oos));
		

		JPanel jp1Center = new JPanel();
		jp1Center.setBounds(5, 95, 390, 250);
		jp1Center.setOpaque(false);
		jp0.add(jp1Center);
		
		jp1Center.setLayout(null);
		
		viewTop.setBorder(null);
		viewTop.setEditable(false);
		viewTop.setText("��̸���������Ż��н���Ϣ��İ���绰����ʹ��������");
		viewscollTop.setBounds(0, 0, 390, 250);
		viewscollTop.setBorder(null);
		viewscollTop.setAutoscrolls(true);
		jp1Center.add(viewscollTop);
		
		ImageIcon imgicon = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/r.jpg"));
		JLabel labelCenterRight = new JLabel(imgicon);
		labelCenterRight.setBounds(400, 90, imgicon.getIconWidth(), imgicon.getIconHeight());
		labelCenterRight.setOpaque(false);
		jp0.add(labelCenterRight);
		
		ImageIcon imgiconTop = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/Gilr.gif"));
		JLabel labelCenterRightTop = new JLabel(imgiconTop);
		labelCenterRightTop.setBounds(0, 0, imgiconTop.getIconWidth(), imgiconTop.getIconHeight());
		labelCenterRight.add(labelCenterRightTop);
		
		ImageIcon imgiconUnder = new ImageIcon(MessageFrame.class.getClassLoader().getResource("cn/edu/swu/picture/x.gif"));
		JLabel labelCenterRightUnder = new JLabel(imgiconUnder);
		labelCenterRightUnder.setBounds(0, imgiconTop.getIconHeight(), imgiconUnder.getIconWidth(), imgiconUnder.getIconHeight());
		labelCenterRight.add(labelCenterRightUnder);
		
		
		
		JPanel jp1Under = new JPanel();
		jp1Under.setBounds(5, 360, 390, 120);
		jp0.add(jp1Under);
		
		jp1Under.setLayout(null);
		sendscoll.setBounds(0, 0, 390, 120);
		sendscoll.setAutoscrolls(true);
		jp1Under.add(sendscoll);
		
		
		JButton buttonSend = new JButton("����(S)");
		buttonSend.setMnemonic(KeyEvent.VK_S);				//���ö�Ӧ��ĸ���»��ߣ�Ϊ��ť������ݼ�
		buttonSend.setBounds(20, 350, 80, 35);
		labelCenterRight.add(buttonSend);
		buttonSend.addActionListener(new SendMessageButtonMonitor(fromUser, oos, toUser));
		
		JButton buttonOff = new JButton("�ر�(C)");
		buttonOff.setMnemonic(KeyEvent.VK_C);				//���ö�Ӧ��ĸ���»��ߣ�Ϊ��ť������ݼ�
		buttonOff.setBounds(20, 280, 80, 35);
		labelCenterRight.add(buttonOff);
		buttonOff.addActionListener(new OffMessageButtonMonitor(toUser));
	}
	
//	public int getRandom(){
//		return (int)((Math.random()*(9-0+1))+0);
//	}
}
