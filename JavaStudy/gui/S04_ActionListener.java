package gui;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class S04_ActionListener extends JFrame{
	
	public S04_ActionListener() {
		super();
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		btns.add(new JButton());
		btns.add(new gui.mycomponent.MyButton());
		btns.add(new gui.mycomponent.MyButton());
		btns.add(new gui.mycomponent.MyButton()); //+ ��ư �����̳ʸ� �߰�?
		
		btns.get(0).setText("one");
		btns.get(0).setFont(new Font("�ü�ü", Font.PLAIN, 25));
		
		btns.get(1).setText("Two");
		btns.get(2).setText("Three");

		add(btns.get(0), "Center");
		add(btns.get(1), "East");
		add(btns.get(2), "West");
		add(btns.get(3), "South");
		
		setLocation(900, 200); //+ ���� ����Ϳ��� ��µǴ� ��ġ�� ����
		setSize(300, 250); // ��µǴ� �˾��� ũ�⸦ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �˾� ������ ����
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S04_ActionListener();
	}
}
