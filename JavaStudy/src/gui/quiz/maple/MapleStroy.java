package gui.quiz.maple;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.mycomponent.*;

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
		
		/*
			강사님 풀이
		RollButton btn = new RollButton();
		add("rollBtn", rollBtn);
		
		add("stat1", rollBtn.getRanBtns().get(0));
		add("stat1", rollBtn.getRanBtns().get(1));
		add("stat1", rollBtn.getRanBtns().get(2));
		
		*/
		
		RollButton btn = new RollButton();
		
		for (RandomButton ranbtn : btn.getRanBtns()) { // 버튼을 하나씩 꺼낸다
			add(ranbtn);
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
/*
	소영님 풀이..
	
	public class MapleStory extends JFrame {

	int money = 0;

	public MapleStory() {
		// TODO Auto-generated constructor stub
		super("Maple Story");
		setLayout(new BorderLayout(50, 50));
		
		ArrayList<JButton> btns = new ArrayList<>();
		btns.add(new JButton());
		btns.add(new JButton());
		btns.add(new JButton());
		btns.add(new JButton());

		
		int[] option = new int[3];
		int[] randoms = new int[3];
		String[] options = {"strength", "intelligence", "agility", "luck", "damage"};
		
		btns.get(3).setText("Rolling");
		btns.get(3).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				money += 3000;
				btns.get(3).setText("Rolling spent: " + money);
				for(int i = 0; i < 3; i++) {
					option[i] = (int)(Math.random() * 5); // 옵션 5가지에서 랜덤
					if(option[i] != 4) { // 4보다 크지 않으면 7, 4와 같으면 3..
						randoms[i] = (int)(Math.random() * 7 + 1);
					} else {
						randoms[i] = (int)(Math.random() * 3 + 1);
					}
					btns.get(i).setText(options[option[i]] + " +" + randoms[i]);
				}
			}
		});
		
		add(btns.get(0), "West");
		add(btns.get(1), "Center");
		add(btns.get(2), "East");
		add(btns.get(3), "South");
		setLocation(2020, 100);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MapleStory();
	}
}

*/



