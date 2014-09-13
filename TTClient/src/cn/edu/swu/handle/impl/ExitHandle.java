package cn.edu.swu.handle.impl;

import java.io.IOException;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;


public class ExitHandle implements ResponseHandle {

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		System.out.println("####################################################");
		System.out.println("退出的用户"+response.getUser().getUserId());
		System.out.println("####################################################");
		try {
//			JOptionPane.showMessageDialog(null, response.getMessage());
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
