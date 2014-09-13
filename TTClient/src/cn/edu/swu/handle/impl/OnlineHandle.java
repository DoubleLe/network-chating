package cn.edu.swu.handle.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.informationData.ClientResource;
import cn.edu.swu.modle.Request;
import cn.edu.swu.modle.Response;

public class OnlineHandle implements ResponseHandle{

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		System.out.println("在OnlineHandle中的回应的用户ID"+response.getUser().getUserId());
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Request request = new Request();
		request.setFromUser(response.getUser());
		
		request.setServiceName(ClientResource.FRIENDLIST);
		
		try {
			oos.writeObject(request);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
