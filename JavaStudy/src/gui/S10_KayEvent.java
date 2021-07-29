package gui;

import java.awt.event.*;

import javax.swing.*;

public class S10_KayEvent extends StudyFrame {
	
	public S10_KayEvent() {
		super();
		
		JLabel status = new JLabel("stable");
		
		JTextArea ta = new JTextArea("�⺻��");
		ta.setBounds(20,20,220,220);
		
		/*
			keyTyped�δ� Ű������ � Ű�� ���ȴ��� �� �� ����. (VK_DEFINED)
			� Ű�� ���ȴ��� �˱� ���ؼ��� keyPressed �̺�Ʈ�� �̿��ؾ� �Ѵ�.
			
			��� keyTyped�� � ���� �ԷµǾ����� �� �� �ִ�.
		*/
		ta.addKeyListener(new KeyAdapter() { // �Ѱ����� ���������� Adapter�� ����Ѵ�
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyChar() + " Value Typed"); // a Value Typed
			}
			@Override
			public void keyPressed(KeyEvent e) {
				status.setText(e.getKeyCode() + " Key Pressed"); // ��ܹٿ� 65 Key Pressed�� ǥ�õ�
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
		// Ű���尡 ������ �� �߻��ϴ� �̺�Ʈ�� ������Ʈ�� �߰��� �� �ִ�
		S10_KayEvent frame = new S10_KayEvent();
		frame.setDefaultOptions();
	}
}
