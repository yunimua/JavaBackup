package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class S03_JButton extends JFrame {
	
	public S03_JButton() {
		super("How to make JButton");
		
		super.setTitle("Change Title"); // Ÿ��Ʋ �̸��� ����ȴ�
		
		setLayout(new BorderLayout());											
		
		JButton[] btns = new JButton[5];
		String[] directions = {"East", "West", "South", "North", "Center"}; //�������� �߾�!
		
		for (int i = 0, len = btns.length; i < len; ++i) {
			btns[i] = new JButton("Button" + i);
			add(btns[i], directions[i]);
		}
		
		// 1. ��ư�� ������ �ٲ� ���� �ִ�
		btns[2].setBackground(new Color(0x9F81F7));
				
		// 2. ��ư�� �۲��� �ٲ� ���� �ִ�
		btns[1].setFont(new Font("Mistral", Font.BOLD, 20));
		
		// 3. ��ư���� �̺�Ʈ�� �߰��� �� �ִ�. (��ư�� ������ �� �׼��� �������� ����..)
		btns[0].addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int random = (int)(Math.random() * 10 + 2);
				for (int i = 1; i < random; ++i) {
					System.err.print("�� ����?");
				}
				System.err.println();
			}
		});
		
		// 4. ��ư ��Ȱ��ȭ
		btns[4].setEnabled(false);

				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(900, 300);
		setSize(300, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S03_JButton();
	}

}
