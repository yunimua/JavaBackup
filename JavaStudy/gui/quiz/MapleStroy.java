package gui.quiz;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.mycomponent.*;
import gui.quiz.maple.*;

public class MapleStroy extends JFrame {

	/*
		굴리기! 버튼을 누르면 옵션이 랜덤으로 3개 결정되는 프로그램을 만들어보세요.
		
		힘 증가  +1 ~ +7
		지능 증가 +1 ~ +7
		민첩 증가 +1 ~ +7
		행운 증가 +1 ~ +7
		공격력 증가 +1 ~ +3
	*/
	private ArrayList<RandomButton> ranBtns;
	
	public MapleStroy() {
		super("단풍 이야기");
		ranBtns = new ArrayList<>();
		setLayout(null); 
		
//		ranBtns.add(new RandomButton() {
//			{
//				setLocation(10,10);
//				setSize(100, 120);
//				setBackground(new Color(0xF5F6CE));
//			}
//		});
//		
//		ranBtns.add(new RandomButton(){
//			{
//				setLocation(120,10);
//				setSize(100, 120);
//				setBackground(new Color(0xF5F6CE));
//			}
//		});
//		
//		ranBtns.add(new RandomButton() {
//			{
//				setLocation(230, 10);
//				setSize(100, 120);
//				setBackground(new Color(0xF5F6CE));
//			}
//		});
//		
//		add(new JButton() {
//			{
//				setText("Option Change");
//				setLocation(70, 150);
//				setSize(200, 50);
//				setBackground(new Color(0xE3CEF6));
//				addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						for (RandomButton btn : ranBtns) {
//							btn.roll();
//						}
//					}
//				});
//			}
//		});
//		
//		add(ranBtns.get(0), "West");
//		add(ranBtns.get(1), "Center");
//		add(ranBtns.get(2), "East");
		
		RollButton btn = new RollButton();
		
		for (RandomButton ranbtn : btn.getRanBtns()) { // 버튼을 하나씩 꺼낸다
			add(ranbtn);
			System.out.println(ranbtn);
		}
		add(btn); // 프레임에 버튼을 추가

		setLocation(900,300); // 모니터 화면상의 프레임(팝업) 출력 위치
		setSize(350,250); // 프레임(팝업) 크기설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
	}

	public static void main(String[] args) {
		new MapleStroy();
	}
}





