package gui.mycomponent;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyButton extends JButton {
	
	int value;

	public MyButton() {
		super();
		
		setText("힘" + value);
		setBackground(new Color(0x9F81F7)); // 배경색 지정가능
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ActionEvent e : 이벤트 발생시 ActionEvent 인스턴스에 해당 이벤트 정보가 (e를 통해 )넘어온다
				System.out.println("정보1: " + e.getID());
				System.out.println("정보2: " + e.getModifiers());
				System.out.println("정보3: " + e.getWhen()); // 정보3: 1627036715525, 두 버튼중 어떤걸 먼저 눌렀는가를 체크가능함?
				System.out.println("정보4: " + e.getActionCommand()); // 정보4: 0
				System.out.println("정보5: " + e.getSource()); // 정보5: gui.mycomponent.MyButton[,446,0,40x463,alignmentX=0.0.......
				
				((MyButton) e.getSource()).setText("힘" + ++value); //+ getActionCommand() : 카운트가 1씩 증가한다
			}
			
		});
	}
}
