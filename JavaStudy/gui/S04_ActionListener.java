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
		btns.add(new gui.mycomponent.MyButton()); //+ 버튼 컨테이너를 추가?
		
		btns.get(0).setText("one");
		btns.get(0).setFont(new Font("궁서체", Font.PLAIN, 25));
		
		btns.get(1).setText("Two");
		btns.get(2).setText("Three");

		add(btns.get(0), "Center");
		add(btns.get(1), "East");
		add(btns.get(2), "West");
		add(btns.get(3), "South");
		
		setLocation(900, 200); //+ 현재 모니터에서 출력되는 위치를 설정
		setSize(300, 250); // 출력되는 팝업의 크기를 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 팝업 닫힐때 종료
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S04_ActionListener();
	}
}
