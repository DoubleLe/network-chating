package cn.edu.swu.modle;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {
	private static final long serialVersionUID = 5259845138958199263L;
	public static final int LOGIN_SUCCESS = 1001;
	public static final int LOGIN_PASSWORD_ERROR = 1002;
	public static final int LOGIN_ACCOUNT_NOT = 1003;
	public static final int FRIEND_ONLINE = 1004;
	public static final int FRIEND_OFFLINE = 1005;
	public static final int THE_FRIEND_NOT_FOUND = 1006;
	public static final int THE_FRIEND_YES = 1007;
	public static final int THE_FRIEND_HAS_EXIST = 1008;

	

	private int responseCode;
	private String responseName;
	private String message;
	private User user;
	private User toUser;
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

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	private List<User> userList;
	private List<User> friendList;
	
	
	
	
	public List<User> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<User> friendList) {
		this.friendList = friendList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getResponseName() {
		return responseName;
	}

	public void setResponseName(String responseName) {
		this.responseName = responseName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
}
