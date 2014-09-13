package cn.edu.swu.service;

import java.net.Socket;


import cn.edu.swu.modle.Request;

public interface ServerService {
	public void service(Request request,Socket socket);
}
