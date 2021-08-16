package gui;

import javax.swing.*;

public class S01_JavaSwing {
	/*
		# Java Swing
		  - javax.swing ��Ű���� ����ִ� Ŭ������� Windows GUI ���α׷��� ���� �� �ִ�
		  
		# Container
		  - ���� ������Ʈ���� ��ġ�� �� �ִ� ��
		  - JFrame, JPanel, JDialog ... ��
		  - �����̳ʸ��� ���̾ƿ��� ������ �� �ִ�
		  
		# Component
		  - �����̳� ���� ��ġ�� �� �ִ� ��ǰ
		  - ��ư, ǥ, �����̴�, �޴� ... ��
	*/
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		// �� ������Ʈ �ν��Ͻ� ���� �����ϴ� ������� �ش� ������Ʈ�� �ڼ��� ������ �� �ִ�
		JButton btn1 = new JButton("This is Button");
		btn1.setLocation(10,10);
		btn1.setSize(100, 120);
		
		JButton btn2 = new JButton("Button 2");
		btn2.setLocation(120,10);
		btn2.setSize(100, 120);
				
		// �������� ����� ������ ���� ���𰡸� ���̸鼭 ���α׷��� ����� ����̴�.
		frame.add(btn1);
		frame.add(btn2);
		frame.add(new JButton("button 3") {
			{
				setLocation(230, 10);
				setSize(100, 120);
			}
		});
		
		frame.add(new JButton("button 4") {
			{
				setLocation(70, 150);
				setSize(200, 50);
			}
		});
		
		// ���̾ƿ� ����
		frame.setLayout(null); //+ �⺻���� �����Ǿ� �ִ� ���̾ƿ��� ���� ������ ����� : setLayout(null)
		
		// X��ư ������ ���� ������ ���� (0 = DO_NOTHING_ON_CLOSE = �ƹ��͵� �����ʴ´�)
		// frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //+ X��ư�� ������ �����
		
		// ������ ũ�� ����
		frame.setSize(360,250);
		
		// ������ ��� �������� ���̰��Ѵ�. (ȭ�鿡 �׸��� ȿ���� �ִ�)
		frame.setVisible(true); //+ �������� �δ°� ����. �մܿ� �����ϸ� �ڿ� ������ ���� �ݿ����� ���� �� �ִ�
		
	}
}
