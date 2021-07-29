package gui.mycomponent;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyButton extends JButton {
	
	int value;

	public MyButton() {
		super();
		
		setText("��" + value);
		setBackground(new Color(0x9F81F7)); // ���� ��������
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ActionEvent e : �̺�Ʈ �߻��� ActionEvent �ν��Ͻ��� �ش� �̺�Ʈ ������ (e�� ���� )�Ѿ�´�
				System.out.println("����1: " + e.getID());
				System.out.println("����2: " + e.getModifiers());
				System.out.println("����3: " + e.getWhen()); // ����3: 1627036715525, �� ��ư�� ��� ���� �����°��� üũ������?
				System.out.println("����4: " + e.getActionCommand()); // ����4: 0
				System.out.println("����5: " + e.getSource()); // ����5: gui.mycomponent.MyButton[,446,0,40x463,alignmentX=0.0.......
				
				((MyButton) e.getSource()).setText("��" + ++value); //+ getActionCommand() : ī��Ʈ�� 1�� �����Ѵ�
			}
			
		});
	}
}
