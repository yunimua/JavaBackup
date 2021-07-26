package gui.quiz;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.mycomponent.*;
import gui.quiz.maple.*;

public class MapleStroy extends JFrame {

	/*
		������! ��ư�� ������ �ɼ��� �������� 3�� �����Ǵ� ���α׷��� ��������.
		
		�� ����  +1 ~ +7
		���� ���� +1 ~ +7
		��ø ���� +1 ~ +7
		��� ���� +1 ~ +7
		���ݷ� ���� +1 ~ +3
	*/
	private ArrayList<RandomButton> ranBtns;
	
	public MapleStroy() {
		super("��ǳ �̾߱�");
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
		
		for (RandomButton ranbtn : btn.getRanBtns()) { // ��ư�� �ϳ��� ������
			add(ranbtn);
			System.out.println(ranbtn);
		}
		add(btn); // �����ӿ� ��ư�� �߰�

		setLocation(900,300); // ����� ȭ����� ������(�˾�) ��� ��ġ
		setSize(350,250); // ������(�˾�) ũ�⼳��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
	}

	public static void main(String[] args) {
		new MapleStroy();
	}
}





