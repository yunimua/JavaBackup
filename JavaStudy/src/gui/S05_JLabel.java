package gui;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.quiz.maple.*;

public class S05_JLabel extends StudyFrame {
	
	/*
		# JLabel
		  - 텍스트를 적는 용도로 사용되는 컴포넌트
	*/
	private ArrayList<JLabel> image;
	int cnt; //순서대로 출력하기 위해 int(숫자)배열
	
	public S05_JLabel() {
		super();
		Icon[] icons = { // 아이콘을 배열에 넣기
				new ImageIcon("./image/p1.jpg"),
				new ImageIcon("./image/p2.jpg"),
				new ImageIcon("./image/p3.jpg")
		};
		
		JButton btn = new JButton();
		//JLabel label = new JLabel(new ImageIcon("./image/pg.png");
		JLabel label = new JLabel(icons[cnt]); // 라벨에 아이콘 배열을 넣는다
		
		btn.setText("Button");
		label.setText("Label");// 글자 출력
		
		add(btn, "South");
		add(label, "Center");
		
		// 연습문제 : 버튼을 누르면 다른 그림으로 바뀌도록 만들어보세요. (그림은 계속 순환되어야 함)
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setIcon(icons[++cnt % icons.length]); // 순차적으로 반복출력되게 아이콘 배열을 1개씩 더하고 배열 총 숫자로 %한다..
			}
		});
	}

	public static void main(String[] args) {
		S05_JLabel frame = new S05_JLabel();
		frame.setDefaultOptions();
	}
	
}
