package cn.edu.swu.handle.impl;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import cn.edu.swu.clientFrame.FriendFrame;
import cn.edu.swu.clientFrame.UsersDialog;
import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;


public class AddFriendHandle implements ResponseHandle {
	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		JOptionPane.showMessageDialog(null, response.getMessage());
		
		System.out.println("AddFriendHandlePPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		System.out.println("服务器端传过来的好友列表："+response.getFriendList());
		System.out.println("服务器传过来的查询列表"+response.getUserList());
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		
		FriendFrame.friendFrameFlush(response, FriendFrame.jp21, oos);
		UsersDialog.usersDialogFlush(response, oos);
	}
		
}
