package cn.edu.swu.handle.impl;

import java.awt.Color;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;


import cn.edu.swu.Client.Client;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.clientFrame.MessageFrame;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;

public class MessageHandle implements ResponseHandle {

//	private SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	
	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		
		if(response.getResponseCode()==Response.FRIEND_ONLINE){
			
			System.out.println("MessageHandleXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println("���ܵ����Է������ĺ��ѵ�̸����Ϣ����"+response.getMessage());
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			
			System.out.println("�Ѿ����ڵĴ��ڣ�"+Client.MESSAGE_FRAME_MAP);
			System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
			
			MessageFrame mf = Client.MESSAGE_FRAME_MAP.get(response.getToUser().getUserId());
			
			System.out.println("��Ϣ���ڴ��ڷ�"+mf+"response.getToUser():"+response.getToUser().getUserId());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			if(mf!=null){
				
				System.out.println("MessageHandleoooooooooooooooooooooooooooooooooooooooooooooo");
				System.out.println("���ڴ��ڣ���������");
				System.out.println("0000000000000000000000000000000000000000");
				
//				Date date = new Date();
//				mf.getViewTop().append("\n "+response.getToUser().getUserName()+"  "+fd.format(date)+"\n\n");
				mf.getViewTop().append(response.getMessage());
			}else{
				Client.friendListPanelMap.get(response.getToUser().getUserId()).setBackground(Color.ORANGE);
				FriendFrame.jp21.repaint();
				
				String mes = Client.MESSAGE_MAP.get(response.getToUser().getUserId());
				if(mes!=null){
					mes = mes + response.getMessage() +"\n";
					Client.MESSAGE_MAP.put(response.getToUser().getUserId(), mes);
				}else{
					mes = response.getMessage() +"\n";
					Client.MESSAGE_MAP.put(response.getToUser().getUserId(), mes);
				}
			}
			
		}else{
			JOptionPane.showMessageDialog(null, response.getMessage());
		}
	}

}
