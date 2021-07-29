package gui;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class S09_MenuBar extends StudyFrame {
	
	public S09_MenuBar() { // 메뉴와 메뉴 아이디를 붙일 수 있다
		super();
		int cnt;

		JMenuBar bar = new JMenuBar();
		
		JMenu main = new JMenu("Main Menu");
		JMenu sub = new JMenu("Sub Menu");
		
		JMenuItem main_item1 = new JMenuItem("New");
		JMenuItem main_item2 = new JMenuItem("Load");
		JMenuItem main_item3 = new JMenuItem("Save");
		
		JMenuItem sub_item1 = new JMenuItem("Update");
		JMenuItem sub_item2 = new JMenuItem("Delete");
		
		// 하나씩 넣을 수 있음
		JLabel label = new JLabel();
		add(label);
		
//		main_item1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				label.setIcon(new ImageIcon("./image/coffee/coffee1.jpg"));	
//			}
//		});
		
		//클래스를 만들어서 한번에 정리
		class MenuItemListener implements ActionListener {
			
			String path;
			
			public MenuItemListener(String path) {
				this.path = path;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setIcon(new ImageIcon(path));
			}
		}
		
		sub_item1.addActionListener(new MenuItemListener("./image/coffee/coffee3.jpg"));
		sub_item2.addActionListener(new MenuItemListener("./image/coffee/coffee4.jpg"));
		main_item1.addActionListener(new MenuItemListener("./image/coffee/coffee1.jpg"));
		main_item2.addActionListener(new MenuItemListener("./image/coffee/coffee2.jpg"));
		main_item3.addActionListener(new MenuItemListener("./image/coffee/coffee5.jpg"));

		
		main.add(main_item1);
		main.add(main_item2);
		main.add(main_item3);
		main.add(sub); // 메인 메뉴안에 서브메뉴
		
		sub.add(sub_item1);
		sub.add(sub_item2);
		
		bar.add(main);
		// bar.add(sub); // 따로 메뉴바를 쓸때
		
		setJMenuBar(bar);
	}

	public static void main(String[] args) {
		S09_MenuBar frame = new S09_MenuBar();
		frame.setDefaultOptions();
	}
}
