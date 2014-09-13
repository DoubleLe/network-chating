package cn.edu.swu.modle;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class User implements Serializable {
	private static final long serialVersionUID = -4613772539959481937L;
	
	private String userId;
	private String userName;
	private String password;
	private String sex;
	private String birthDay;
	private String email;
	private String phone;
	private String address;
	private String ip;
	private int port;
	private ImageIcon imageIcon;
	private String wordsQianMing;
	
	public String getWordsQianMing() {
		return wordsQianMing;
	}

	public void setWordsQianMing(String wordsQianMing) {
		this.wordsQianMing = wordsQianMing;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	public User(){
		
	}
	
	public User(ArrayList<User> array, int i){
		this.userId = array.get(i).getUserId();
		this.userName = array.get(i).getUserName();
		this.password = array.get(i).getPassword();
		this.sex = array.get(i).getSex();
		this.birthDay = array.get(i).getBirthDay();
		this.address = array.get(i).getAddress();
		this.ip = array.get(i).getIp();
		this.port = array.get(i).getPort();
		this.imageIcon = array.get(i).getImageIcon();
		this.wordsQianMing = array.get(i).getWordsQianMing();
	}
	
	public User(User user, Request request){
		this.imageIcon = user.getImageIcon();
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.sex = user.getSex();
		this.birthDay = user.getBirthDay();
		this.address = user.getAddress();
		this.wordsQianMing = user.getWordsQianMing();
		this.ip = request.getFromUser().getIp();
		this.port = request.getFromUser().getPort();
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return this.userId+"    "+this.userName+"       "+this.sex+"    "+(this.ip!=null ? "‘⁄œﬂ" : "¿Îœﬂ");
	}
	
	
}
