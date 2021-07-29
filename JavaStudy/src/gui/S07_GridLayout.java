package gui;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import gui.myhandler.*;

public class S07_GridLayout extends StudyFrame {
	
	public S07_GridLayout() {
		super();
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		// 2개 이상의 레이아웃을 사용하고 싶다면 JPanel을 이용한다
		setLayout(new BorderLayout());
		
		// JPanel은 다른 레이아웃을 설정할 수 있는 새로운 판이다
		JPanel center_panel = new JPanel();
		JButton south_button = new JButton("Generate Color");
		
		add(center_panel, "Center");
		add(south_button, "South");
		
		center_panel.setLayout(new GridLayout(4, 4)); // 패널위에 레이아웃을 올린다 : 4줄 4칸, 1칸이 비는상태
		//setLayout(new GridLayout(5, 3)); //(행, 열) 을 선택(1)
		
		for (int i = 0; i < 15; ++i) {
			JButton btn = new JButton("Button" + i); // 버튼 15개를 만듬
			btns.add(btn); // 버튼을 추가함
			
			//btn.setBackground(new Color((int)(Math.random() * 0xFFFFFF))); // 랜덤한 색상으로 버튼 색상이 지정된다(2)
			center_panel.add(btn); //패널에 버튼을 올림
			//add(btn);(1)
		}
		// generateColor(); //(2)
		// 여기에 이벤트처리를 하는 것은 그리 좋지 않다..
		// 화면을 구성하는 코드와 로직을(동작) 처리하는 코드는 분리하는 것이 좋다
		south_button.addActionListener(new GenerateColorHandler(btns));
		south_button.doClick(); // 버튼을 프로그램적으로 클릭한다. => 버튼을 클릭할때마다 랜덤하게 색상이 변한다, 이걸 주석처리하면 색상없는 상태로 최초 출력
	}
	
//	private void generateColor() { //GenerateColorHandler으로 옴겼다..(2)
//		for (JButton btn : btns) {
//			btn.setBackground(new Color((int)(Math.random() * 0xFFFFFF)));
//		}
//	}

	public static void main(String[] args) {
		S07_GridLayout frame = new S07_GridLayout();
		frame.setDefaultOptions();
	}
}
