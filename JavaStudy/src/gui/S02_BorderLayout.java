package gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class S02_BorderLayout extends JFrame { //+ 프레임을 상속받아 자기 자신이 프레임이된다.
	
	public S02_BorderLayout() { //+ 부모에다가 바로 프레임 설정을 하면, 상속받은 클래스는 이걸 그대로 가져다 쓰게되는 형태
		super();
		
		// 이하 super. 이 모두 생략됨
		setLayout(new BorderLayout(50,15)); //버튼과 버튼사이 >> 50 : 가로, 15: 세로 띄우기
		//+ 버튼 5개 추가
		add(new JButton("Button1"), BorderLayout.NORTH); //북
		add(new JButton("Button2"), BorderLayout.EAST); //동
		add(new JButton("Button3"), BorderLayout.WEST); //서
		add(new JButton("Button4"), BorderLayout.SOUTH); //남
		add(new JButton("Button5"), BorderLayout.CENTER); //중앙
		
		// 생략된 것 : this.setSize(500, 500); // this가 생략됨
		setSize(500, 500);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	/*
		# BorderLayout
		
		  - 동서남북과 가운데로 이루어진 레이아웃
		  - 컴포넌트를 추가할 때 위치를 함께 지정할 수 있다.
	*/
	
	public static void main(String[] args) {
		S02_BorderLayout frame = new S02_BorderLayout();

	}
}
