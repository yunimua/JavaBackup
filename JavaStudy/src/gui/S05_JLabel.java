package gui;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.quiz.maple.*;

public class S05_JLabel extends StudyFrame {
	
	/*
		# JLabel
		  - �ؽ�Ʈ�� ���� �뵵�� ���Ǵ� ������Ʈ
	*/
	private ArrayList<JLabel> image;
	int cnt; //������� ����ϱ� ���� int(����)�迭
	
	public S05_JLabel() {
		super();
		Icon[] icons = { // �������� �迭�� �ֱ�
				new ImageIcon("./image/p1.jpg"),
				new ImageIcon("./image/p2.jpg"),
				new ImageIcon("./image/p3.jpg")
		};
		
		JButton btn = new JButton();
		//JLabel label = new JLabel(new ImageIcon("./image/pg.png");
		JLabel label = new JLabel(icons[cnt]); // �󺧿� ������ �迭�� �ִ´�
		
		btn.setText("Button");
		label.setText("Label");// ���� ���
		
		add(btn, "South");
		add(label, "Center");
		
		// �������� : ��ư�� ������ �ٸ� �׸����� �ٲ�� ��������. (�׸��� ��� ��ȯ�Ǿ�� ��)
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setIcon(icons[++cnt % icons.length]); // ���������� �ݺ���µǰ� ������ �迭�� 1���� ���ϰ� �迭 �� ���ڷ� %�Ѵ�..
			}
		});
	}

	public static void main(String[] args) {
		S05_JLabel frame = new S05_JLabel();
		frame.setDefaultOptions();
	}
	
}
