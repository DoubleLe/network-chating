package cn.edu.swu.informationData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClientResource {
	public static final String LOGIN = "Login";
	public static final String REGISTER = "Register";
	public static final String EXIT = "Exit";
	public static final String USERS = "Users";
	public static final String ADDFRIEND= "AddFriend";
	public static final String FRIENDLIST= "FriendList";
	public static final String MESSAGE= "Message";
	public static final String SEARCHFRIEND = "SearchFriend";
	public static final String REMOTER_HELP_REQUEST = "RemoterHelpRequest";
	public static final String REMOTER_HELP_REFUSE = "RemoterHelpRefuse";
	public static final String REMOTER_HELP_ACCEPT = "RemoterHelpAccept";
	public static final String REMOTER_HELP_SEND = "RemoterHelpSend";
	public static final String REMOTER_HELP_OPERATE = "RemoterHelpOperate";
	
	
	
	private static final Properties PROPERTIES = new Properties();
	
	
	
	
	
	
	static{
		InputStream in = null;
		try {
			in = new FileInputStream(System.getProperty("user.dir")+"/src/cn/edu/swu/informationData/Handle.properties");
			PROPERTIES.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if(in!=null){
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public static String getClassName(String responseName){
		return PROPERTIES.getProperty(responseName);
	}
}
