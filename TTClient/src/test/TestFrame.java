package test;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class TestFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TestFrame(){
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.out.println(11111);
				}
				
			}
		});
	} 
	
	public static void main(String[] args) {
		TestFrame tf = new TestFrame();
		tf.setVisible(true);
		
		
	}

}
