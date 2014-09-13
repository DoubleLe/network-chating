package cn.edu.swu.clientFrame;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Image;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import cn.edu.swu.Client.Client;
import cn.edu.swu.modle.Response;
import cn.edu.swu.monitor.UsersDialogButtonOffMonitor;
import cn.edu.swu.monitor.UsersDialogMoveMouseMonitor;
import cn.edu.swu.monitor.UsersDialogMoveMouseMotionMonitor;
import cn.edu.swu.monitor.UsersListMonitor;


public class UsersDialog extends JFrame{
	private static final long serialVersionUID = 1L;
	public static JPanel userPanel = new JPanel(); 
	public static JScrollPane jsp = new JScrollPane(userPanel);
	private ObjectOutputStream ooss;
	
	public static boolean isDragged = false;
	public static Point firstFrame =null;
	public static Point secondFrame = null;
	
//	@SuppressWarnings("unchecked")
	public UsersDialog(ObjectOutputStream oos,Response response){
		Image mesg = this.getToolkit().getImage(UsersDialog.class.getClassLoader().getResource("cn/edu/swu/picture/Mesg.jpg"));
		ImageIcon findimag = new ImageIcon(UsersDialog.class.getClassLoader().getResource("cn/edu/swu/picture/Fondimag.jpg"));
		ImageIcon usersDialogOff = new ImageIcon(UsersDialog.class.getClassLoader().getResource("cn/edu/swu/picture/UserFrameOff.jpg"));

		this.ooss = oos;
		
		this.setResizable(false);
		
		this.setIconImage(mesg);
		this.setTitle("查找联系人");
		this.setSize(findimag.getIconWidth(), findimag.getIconHeight()+5);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		
		
		this.addMouseListener(new UsersDialogMoveMouseMonitor());
		this.addMouseMotionListener(new UsersDialogMoveMouseMotionMonitor());
	
		
		JLabel label0 = new JLabel(findimag);
		label0.setBounds(0, 0, findimag.getIconWidth(), findimag.getIconHeight());
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(label0, Integer.MIN_VALUE);
		
		JLabel labelTitle = new JLabel("查找联系人");
		labelTitle.setBounds(0, 0, 100, 20);
		label0.add(labelTitle);
		
		JButton offFrameButton = new JButton(usersDialogOff);
		offFrameButton.setBounds(findimag.getIconWidth()-usersDialogOff.getIconWidth(), 0, usersDialogOff.getIconWidth(), usersDialogOff.getIconHeight());
		offFrameButton.setBorder(null);
		offFrameButton.setToolTipText("关闭");
		label0.add(offFrameButton);
		offFrameButton.addMouseListener(new UsersDialogButtonOffMonitor());
		JLabel lable1 = new JLabel();
		lable1.setBounds(10, 50, findimag.getIconWidth()-20, findimag.getIconHeight()-60);
		this.getLayeredPane().setLayout(null);
		label0.add(lable1);
		
		jsp.setOpaque(false);
		jsp.setBounds(0, 0, findimag.getIconWidth()-20, findimag.getIconHeight()-30);
		lable1.add(jsp);
		
		int x = 100;
		int y = 40;
		this.setLocation(x, y);
		
		
		UsersDialog.usersDialogFlush(response, ooss);
	}
	
	public static void usersDialogFlush(Response response, ObjectOutputStream oos){
		ImageIcon findimag = new ImageIcon(UsersDialog.class.getClassLoader().getResource("cn/edu/swu/picture/Fondimag.jpg"));
		
		int count = 0;
		count = response.getUserList().size();
		JLabel[] jp22 = new JLabel[count];
		
		
		if(count>=4){
			UsersDialog.userPanel.setPreferredSize(new Dimension(0, count*90));
		}
		UsersDialog.userPanel.setLayout(null);
		
		UsersDialog.userPanel.setBounds(0, 0, findimag.getIconWidth()-20, count*90);
		
		int i = 0;
		
		for(int j = 0;j<Client.userPanelCount;j++){
			userPanel.remove(0);//每删除一个，下一个就会变为第0个
		}
		
		
		for(i = 0;i<count;i++){
			
			
			jp22[i] = new JLabel(response.getUserList().get(i).toString(), response.getUserList().get(i).getImageIcon(), JLabel.LEFT);
			jp22[i].setBounds(0, 90*i, findimag.getIconWidth()-20, response.getUserList().get(i).getImageIcon().getIconHeight());
			
			jp22[i].addMouseListener(new UsersListMonitor(response.getUser(), response.getUserList().get(i), oos));
			userPanel.add(jp22[i]);
		}
		Client.userPanelCount = i;
		UsersDialog.userPanel.repaint();
	}
}
