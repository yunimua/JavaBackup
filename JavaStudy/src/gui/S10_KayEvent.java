package gui;

import java.awt.event.*;

import javax.swing.*;

public class S10_KayEvent extends StudyFrame {
	
	public S10_KayEvent() {
		super();
		
		JLabel status = new JLabel("stable");
		
		JTextArea ta = new JTextArea("기본값");
		ta.setBounds(20,20,220,220);
		
		/*
			keyTyped로는 키보드의 어떤 키가 눌렸는지 알 수 없다. (VK_DEFINED)
			어떤 키가 눌렸는지 알기 위해서는 keyPressed 이벤트를 이용해야 한다.
			
			대신 keyTyped는 어떤 값이 입력되었는지 알 수 있다.
		*/
		ta.addKeyListener(new KeyAdapter() { // 한개씩만 꺼내쓸때는 Adapter를 사용한다
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyChar() + " Value Typed"); // a Value Typed
			}
			@Override
			public void keyPressed(KeyEvent e) {
				status.setText(e.getKeyCode() + " Key Pressed"); // 상단바에 65 Key Pressed가 표시됨
				System.out.println(e.getKeyCode() + " Key Pressed"); // 65 Key Pressed
			}
		});
		
//		ta.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				status.setText("key Typed");
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				status.setText("key Pressed");
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				status.setText("key Released");
//			}
//			
//		});
		
		
		add(ta, "Center");
		add(status, "North");
	}

	public static void main(String[] args) {	
		// 키보드가 눌렸을 때 발생하는 이벤트를 컴포넌트에 추가할 수 있다
		S10_KayEvent frame = new S10_KayEvent();
		frame.setDefaultOptions();
	}
}
