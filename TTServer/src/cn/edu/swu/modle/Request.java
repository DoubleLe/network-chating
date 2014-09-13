package cn.edu.swu.modle;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = -5143513902359989976L;
	private User fromUser;
	private User toUser;
	private String serviceName;
	private String message;
	private MyIcon icon;
	private Operate operate;
	
	
	public Operate getOperate() {
		return operate;
	}
	public void setOperate(Operate operate) {
		this.operate = operate;
	}
	public MyIcon getIcon() {
		return icon;
	}
	public void setIcon(MyIcon icon) {
		this.icon = icon;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	

}
