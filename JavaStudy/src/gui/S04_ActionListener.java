package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.myhandler.*;

public class S04_ActionListener extends JFrame {
	
	public S04_ActionListener() {
		super();
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		JLabel label = new JLabel("I am Label");
		
		btns.add(new JButton());
		btns.add(new JButton());
		btns.add(new JButton());
		btns.add(new gui.mycomponent.MyButton()); //+ ��ư �����̳ʸ� �߰�

		btns.get(0).setText("one");
		btns.get(0).setFont(new Font("�ü�ü", Font.PLAIN, 25));
		
		btns.get(1).setText("Two");
		btns.get(2).setText("Three");

		
		add(btns.get(0), "Center");
		add(btns.get(1), "East");
		add(btns.get(2), "West");
		add(btns.get(3), "South");
		add(label); // ���� �����ӿ� ���ϸ� �ؽ�Ʈ�� ����ȴ�
		
		// ActionListener�� ��ӹ��� MyButtonEventHandler2�� ������ �ᵵ��
		// btns.get(0).addActionListener(new MyButtonEventHandler2());
		
		// ActionListener�� �ٷ� ��ӹ޾� ����� �� ����
		// ActionListener�� �߰��� ������Ʈ�� ���� �̺�Ʈ�� �߻��� �� ���� actionPerformed �޼��带 ȣ���Ѵ�
		btns.get(0).addActionListener(new ActionListener() {
			// btns.get(0) �� ������ �Ʒ��� �ؽ�Ʈ�� �ٲ�
			@Override
			public void actionPerformed(ActionEvent e) {
				btns.get(1).setText("�ٲ����"); // ��ư 0���� ������ �� 1���� ���ڸ� �ٲ����
				label.setText("ABC"); // ���� �׼Ǹ����͸� ����� �� ���� ������ ������� �ʴ´�.
			}
		});

		int count = 0;
		btns.get(1).addMouseWheelListener(new MouseWheelListener() {// MouseWheelListener �ν��Ͻ� ����
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				btns.get(1).setText("" + count);// ������ �����ֱ⶧����?
			}
		});
		
		setLocation(900, 200); //+ ���� ����Ϳ��� ��µǴ� ��ġ�� ����
		setSize(300, 250); // ��µǴ� �˾��� ũ�⸦ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �˾� ������ ����
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S04_ActionListener();
	}
}