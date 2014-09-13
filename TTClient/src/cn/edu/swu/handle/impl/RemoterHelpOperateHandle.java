package cn.edu.swu.handle.impl;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.edu.swu.handle.ResponseHandle;
import cn.edu.swu.modle.Operate;
import cn.edu.swu.modle.Response;

public class RemoterHelpOperateHandle implements ResponseHandle {

	@Override
	public void handle(Response response, ObjectInputStream ois,
			ObjectOutputStream oos) {
		Operate operate = response.getOperate();
		Robot robot;
		try {
			robot = new Robot();
			if(Operate.MOUSEMOVED==operate.getOpition()){
				robot.mouseMove(operate.getX(), operate.getY());
			}
			if(Operate.MOUSEPRESSED==operate.getOpition()){
				robot.mouseMove(operate.getX(), operate.getY());
				robot.delay(500);
				robot.mousePress(InputEvent.BUTTON1_MASK);
			}
			if(Operate.MOUSERELEASED==operate.getOpition()){
				robot.mouseMove(operate.getX(), operate.getY());
				robot.delay(500);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			if(Operate.KEYPRESS==operate.getOpition()){
				if(KeyEvent.VK_ESCAPE==operate.getKeyPressedKeyCode()){
					RemoterHelpAcceptHandle.isLoop = true;
				}
			}
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
