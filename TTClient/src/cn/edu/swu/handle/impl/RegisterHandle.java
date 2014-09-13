package cn.edu.swu.handle.impl;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;


import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Response;


public class RegisterHandle implements ResponseHandle{
	
	@Override
	public void handle(Response response,ObjectInputStream ois,ObjectOutputStream oos) {
		JOptionPane.showMessageDialog(null, response.getMessage());
		try{
			ois.close();
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
