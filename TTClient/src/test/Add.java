package test;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Add {
	public Add(){
		
		JLabel[] jp22 = new JLabel[4];
		JPanel jp21 = new JPanel(new GridLayout(5, 1, 2, 2));
//	jp21.setLayout(new GridLayout(5, 1, 2, 2));
//	jp21.setLayout(null);
		System.out.println(")))))))))))))))))))))))))))");
		
		for(int i = 0;i<jp22.length;i++){
			jp22[i] = new JLabel("ºÃÓÑ"+(i+1), new ImageIcon(FriendFrame.class.getClassLoader().getResource("cn/edu/swu/picture/img/"+i+".jpg")), JLabel.LEFT);
			jp21.add(jp22[i]);
		}
		
		FriendFrame.scoll = new JScrollPane(jp21);
	}
	
	public static void main(String[] args) {
		FriendFrame ff = new FriendFrame();
		ff.setVisible(true);
		
//		new Add();
	}
}
