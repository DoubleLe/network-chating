package cn.edu.swu.monitor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import cn.edu.swu.Client.ClientThread;
import cn.edu.swu.Client.Client;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.User;


public class RegisterFrameRegisterButtonMonitor implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			User user = new User();
			
			String sex = Client.registerFrame.getSexField().getText();
			String birth = Client.registerFrame.getBirthDayField().getText();
			String name = Client.registerFrame.getUserNameField().getText();
			String password = new String(Client.registerFrame.getPasswordField().getPassword());
			String password2 = new String(Client.registerFrame.getPasswordField2().getPassword());
			String adress = Client.registerFrame.getAddressField().getText();
			String qianMing = Client.registerFrame.getQianMingText().getText();
			if("".equals(qianMing)){
				qianMing = "大行不顾细谨，大礼不辞小让";
			}
			if("".equals(sex)||"".equals(birth)||"".equals(name)||"".equals(password)||"".equals(password2)||"".equals(adress)||!password.equals(password2)){
				
				if("".equals(name)){
					//设置文本框中字体颜色
					Client.registerFrame.getUserNameError().setForeground(Color.RED);
					Client.registerFrame.getUserNameError().setText("昵称不能为空！");
					Client.registerFrame.repaint();
				}else{
					Client.registerFrame.getUserNameError().setText("");
				}
				
				if("".equals(password)){
					Client.registerFrame.getPasswordError().setForeground(Color.RED);
					Client.registerFrame.getPasswordError().setText("密码不能为空！");
					Client.registerFrame.repaint();
				}else{
					Client.registerFrame.getPasswordError().setText("");
				}
				
				if("".equals(password2)){
					Client.registerFrame.getPasswordError2().setForeground(Color.RED);
					Client.registerFrame.getPasswordError2().setText("确认密码不能为空！");
					Client.registerFrame.repaint();
				}else if(!password.equals(password2)){
					Client.registerFrame.getPasswordError2().setForeground(Color.RED);
					Client.registerFrame.getPasswordError2().setText("两次密码输入不相同！");
					Client.registerFrame.repaint();
				}else{
					Client.registerFrame.getPasswordError2().setText("");
				}
				
				if("".equals(sex)){
					Client.registerFrame.getSexError().setForeground(Color.RED);
					Client.registerFrame.getSexError().setText("性别不能为空！");
					Client.registerFrame.repaint();
				}else if(!("男".equals(sex)) && !("女".equals(sex))){
					Client.registerFrame.getSexError().setForeground(Color.RED);
					Client.registerFrame.getSexError().setText("性别请填 \"男\" 或  \"女\" ");
					Client.registerFrame.repaint();
				}else{
					Client.registerFrame.getSexError().setText("");
				}
				
				if("".equals(birth)){
					Client.registerFrame.getBirthdayError().setForeground(Color.RED);
					Client.registerFrame.getBirthdayError().setText("生日不能为空！");
					Client.registerFrame.repaint();
				}else{
					Client.registerFrame.getBirthdayError().setText("");
				}
				
				if("".equals(adress)){
					Client.registerFrame.getAddressError().setForeground(Color.RED);
					Client.registerFrame.getAddressError().setText("地址不能为空！");
					Client.registerFrame.repaint();
				}else{
					Client.registerFrame.getAddressError().setText("");
				}
			}else{
				Client.registerFrame.getUserNameError().setText("");
				Client.registerFrame.getPasswordError().setText("");
				Client.registerFrame.getPasswordError2().setText("");
				Client.registerFrame.getSexError().setText("");
				Client.registerFrame.getBirthdayError().setText("");
				Client.registerFrame.getAddressError().setText("");
				
				user.setSex(sex);
				user.setBirthDay(birth);
				user.setUserName(name);
				user.setPassword(password);
				user.setAddress(adress);
				user.setWordsQianMing(qianMing);
				user.setImageIcon((ImageIcon)Client.registerFrame.getComBoBox().getSelectedItem());
				
				Request request = new Request();
				request.setFromUser(user);
				request.setServiceName(ClientResource.REGISTER);
				
//				Socket socket = new Socket("172.18.4.130", 56780);//教师机
				Socket socket = new Socket("127.0.0.1", 56780);
				ClientThread ct = new ClientThread(socket);
				ObjectOutputStream oos = ct.getOos();
				oos.writeObject(request);
				oos.flush();
				
				Thread t = new Thread(ct);
				t.start();
				Client.registerFrame.dispose();
			}
			
		} catch (UnknownHostException es) {
			es.printStackTrace();
		} catch (IOException es) {
			es.printStackTrace();
		}
	}

}
