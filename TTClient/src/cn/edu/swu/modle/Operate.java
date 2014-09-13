package cn.edu.swu.modle;

import java.io.Serializable;

public class Operate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int opition;
	private int keyPressedKeyCode;
	private int keyReleasedKeyCode;
	
	public static final int MOUSEMOVED = 0;
	public static final int MOUSEPRESSED = 1;
	public static final int MOUSERELEASED = 2;
	public static final int KEYPRESS = 3;
	public static final int KEYRELEASED = 4;
	
	public int getKeyPressedKeyCode() {
		return keyPressedKeyCode;
	}
	public void setKeyPressedKeyCode(int keyPressedKeyCode) {
		this.keyPressedKeyCode = keyPressedKeyCode;
	}
	public int getKeyReleasedKeyCode() {
		return keyReleasedKeyCode;
	}
	public void setKeyReleasedKeyCode(int keyReleasedKeyCode) {
		this.keyReleasedKeyCode = keyReleasedKeyCode;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getOpition() {
		return opition;
	}
	public void setOpition(int opition) {
		this.opition = opition;
	}
	
	
}
