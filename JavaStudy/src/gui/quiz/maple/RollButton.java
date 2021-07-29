package gui.quiz.maple;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RollButton extends JButton{
	
	private ArrayList<RandomButton> ranBtns;

	public RollButton() {
		ranBtns = new ArrayList<>();
		// RollButton stat1 = new RollButton();
//		
//		stat1.setText("-");
//		stat1.setLocation(10,160);
//		stat1.setSize(200,120);
		ranBtns.add(new RandomButton(){
			{
				setLocation(10,10);
				setSize(100, 120);
				setBackground(new Color(0xF5F6CE));
			}
		});
		ranBtns.add(new RandomButton(){
			{
				setLocation(120,10);
				setSize(100, 120);
				setBackground(new Color(0xF5F6CE));
			}
		});
		ranBtns.add(new RandomButton(){
			{
				setLocation(230, 10);
				setSize(100, 120);
				setBackground(new Color(0xF5F6CE));
			}
		});
		
		setText("Option Change");
		setLocation(70, 150);
		setSize(200, 50);
		setBackground(new Color(0xE3CEF6));
		
		/*
			강사님 풀이
			
		setSize(200, 50);
		setLocation(70, 150);
		setText("Roll!!");

		// 익명의 제보자 소스코드
		ranBtn.get(0).setText("-");
		ranBtn.get(0).setLocation(10,160);
		ranBtn.get(0).setSize(200,120);
		ranBtn.get(1).setText("-");
		ranBtn.get(1).setLocation(220,160);
		ranBtn.get(1).setSize(200,120);
		ranBtn.get(2).setText("-");
		ranBtn.get(2).setLocation(430,160);
		ranBtn.get(2).setSize(200,120);

		*/
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (RandomButton btn : ranBtns) {
					btn.roll();
				}
			}
		});
	}

	public ArrayList<RandomButton> getRanBtns() {
		return ranBtns;
	}
}
