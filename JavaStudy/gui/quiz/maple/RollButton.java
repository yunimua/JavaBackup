package gui.quiz.maple;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RollButton extends JButton{
	
	private ArrayList<RandomButton> ranBtns;

	public RollButton() {
		ranBtns = new ArrayList<>();
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
