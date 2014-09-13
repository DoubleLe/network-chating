package cn.edu.swu.thread;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.edu.swu.modle.MyIcon;
import cn.edu.swu.modle.Request;

public class RemoterHelpAcceptHandleThread implements Runnable{
	private boolean isLoop;
	private Robot robot;
	private Rectangle screenRect;
	private Request request;
	private ObjectOutputStream oos;
	
	public RemoterHelpAcceptHandleThread(boolean isLoop,Robot robot,Rectangle screenRect,Request request,ObjectOutputStream oos){
		this.isLoop = isLoop;
		this.robot = robot;
		this.screenRect = screenRect;
		this.request = request;
		this.oos = oos;
	}
	
	@Override
	public void run() {
		while(!isLoop){
//			i++;
//			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
//			System.out.println(i);
			
			BufferedImage image = robot.createScreenCapture(screenRect);
			MyIcon myIcon = new MyIcon(image);
			request.setIcon(myIcon);
			try {
				oos.writeObject(request);
				oos.flush();
				Thread.sleep(20);
				oos.reset();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
