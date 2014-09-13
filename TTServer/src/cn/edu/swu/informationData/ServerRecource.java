package cn.edu.swu.informationData;

import java.io.FileInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.ImageIcon;
import cn.edu.swu.modle.User;


@SuppressWarnings("unchecked")
public class ServerRecource {
	private static final Properties PROPERTIES = new Properties();
	private static Map<String,User> USER_MAP;
	private static Map<String,List<User>> USER_FRIEND_MAP;
	private static final Map<String, ObjectOutputStream> OOS_MAP = new HashMap<String,ObjectOutputStream>();
	private static final Map<String, ObjectInputStream> OIS_MAP = new HashMap<String,ObjectInputStream>();
	private static final Map<String, User> ONLINE_MAP = new HashMap<String, User>();
	private static final Map<String, Socket> ONLINE_SOCKET_MAP = new HashMap<String, Socket>();
	
	
	public static Map<String, Socket> getOnlineSocketMap() {
		return ONLINE_SOCKET_MAP;
	}

	public static Map<String, User> getOnlineMap() {
		return ONLINE_MAP;
	}

	public static Map<String,User> getUsers(){
		return USER_MAP;
	}
	
	public static Map<String,List<User>> getFriendList(){
		return USER_FRIEND_MAP;
	}
	
	static {
		//将system.out.println()设置为向d:/log.txt中输出
		OutputStream out;
		try {
			out = new FileOutputStream("d:/log.txt", true);
			PrintStream ps = new PrintStream(out);
			System.setOut(ps);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		InputStream in = null;
		ObjectInputStream oisUser = null;
		ObjectInputStream oisFriend = null;
		try {//System.getProperty("user.dir")+ "/src/cn/edu/swu/informationData/ServiceName.properties"
			File fiin = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/ServiceName.properties").toURI());
			in = new FileInputStream(fiin);
			PROPERTIES.load(in);
			
			//System.getProperty("user.dir")+ "/src/cn/edu/swu/informationData/users.data"
			File fioisUser = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/users.data").toURI());
			oisUser = new ObjectInputStream(new FileInputStream(fioisUser));
			USER_MAP = (Map<String,User>)oisUser.readObject();
			
			//System.getProperty("user.dir")+ "/src/cn/edu/swu/informationData/userFriends.data"
			File fioisFriend = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/userFriends.data").toURI());
			oisFriend = new ObjectInputStream(new FileInputStream(fioisFriend));
			USER_FRIEND_MAP = (Map<String,List<User>>)oisFriend.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if(oisUser != null){
					oisUser.close();
				}
				if(oisFriend!=null){
					oisFriend.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getClassName(String serviceName){
		return ServerRecource.PROPERTIES.getProperty(serviceName);
	}
	public static User getUser(String userId){
		return USER_MAP.get(userId);
	}
	public static ObjectInputStream getObjectInputStream(String key){
		return OIS_MAP.get(key);
	}
	public static ObjectOutputStream getObjectOutputStream(String key){
		return OOS_MAP.get(key);
	}
	public static void putObjectStream(Socket socket) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		String key = ServerTool.getSocketKey(socket);
		OIS_MAP.put(key, ois);
		OOS_MAP.put(key, oos);
	}
	public static int getConnectionCount(){
		return OIS_MAP.size();
	}
	public static void removeObjectStream(String key){
		OOS_MAP.remove(key);
		OIS_MAP.remove(key);
	}
	public synchronized static void addUser(User user){
		USER_MAP.put(user.getUserId(), user);
		USER_FRIEND_MAP.put(user.getUserId(), new ArrayList<User>());
		ObjectOutputStream oosUser = null;
		ObjectOutputStream oosFriend = null;
		try {//System.getProperty("user.dir")+"/src/cn/edu/swu/informationData/users.data")
			File filet = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/users.data").toURI());
			oosUser = new ObjectOutputStream(new FileOutputStream(filet));
			oosUser.writeObject(USER_MAP);
			
			//System.getProperty("user.dir")+"/src/cn/edu/swu/informationData/userFriends.data"
			File filef = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/userFriends.data").toURI());
			oosFriend = new ObjectOutputStream(new FileOutputStream(filef));
			oosFriend.writeObject(USER_FRIEND_MAP);
			oosUser.flush();
			oosFriend.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(oosUser != null){
					oosUser.close();
				}
				if(oosFriend!=null){
					oosFriend.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized static void addFriend(String userId,User user){
		List<User> list = USER_FRIEND_MAP.get(userId);
		list.add(user);
		ObjectOutputStream oosFriend = null;
		
		try {//FriendFrame.class.getClassLoader().getResource("cn/edu/swu/informationData/userFriends.data")
			//System.getProperty("user.dir")+"/src/cn/edu/swu/informationData/userFriends.data"
			File file = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/userFriends.data").toURI());
			oosFriend = new ObjectOutputStream(new FileOutputStream(file));
			oosFriend.writeObject(USER_FRIEND_MAP);
			oosFriend.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(oosFriend!=null){
					oosFriend.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void main(String[] args){
		OutputStream out;
		try {//System.getProperty("user.dir")+"/src/cn/edu/swu/informationData/users.data"
			File file = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/users.data").toURI());
			out = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(out);
			Map<String,User> map = new HashMap<String, User>();
			ImageIcon imag = new ImageIcon(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/picture/img/0.jpg"));
			
			User user = new User();
			user.setUserId("10000");
			user.setUserName("小甲鱼");
			user.setSex("男");
			user.setPassword("111");
			user.setImageIcon(imag);
			user.setWordsQianMing("湖水如镜，因风皱面");
			
			map.put(user.getUserId(), user);
			
			User user1 = new User();
			user1.setUserId("11111");
			user1.setUserName("suns");
			user1.setPassword("111");
			user1.setSex("男");
			user1.setImageIcon(imag);
			user1.setWordsQianMing("春江水暖鸭先知");
			
			map.put(user1.getUserId(), user1);
			
			os.writeObject(map);
			os.flush();
			os.close();
			
			//System.getProperty("user.dir")+"/src/cn/edu/swu/informationData/userFriends.data"
			File files = new File(ServerRecource.class.getClassLoader().getResource("cn/edu/swu/informationData/userFriends.data").toURI());
			ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(files));
			
			Map<String,List<User>> map1 = new HashMap<String, List<User>>();
			
			map1.put("10000", new ArrayList<User>());
			map1.put("11111", new ArrayList<User>());
			
			ois.writeObject(map1);
			
			ois.flush();
			
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
