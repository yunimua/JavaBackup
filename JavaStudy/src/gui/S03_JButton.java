package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class S03_JButton extends JFrame {
	
	public S03_JButton() {
		super("How to make JButton");
		
		super.setTitle("Change Title"); // 타이틀 이름이 변경된다
		
		setLayout(new BorderLayout());											
		
		JButton[] btns = new JButton[5];
		String[] directions = {"East", "West", "South", "North", "Center"}; //동서남북 중앙!
		
		for (int i = 0, len = btns.length; i < len; ++i) {
			btns[i] = new JButton("Button" + i);
			add(btns[i], directions[i]);
		}
		
		// 1. 버튼의 배경색을 바꿀 수도 있다
		btns[2].setBackground(new Color(0x9F81F7));
				
		// 2. 버튼의 글꼴을 바꿀 수도 있다
		btns[1].setFont(new Font("Mistral", Font.BOLD, 20));
		
		// 3. 버튼에는 이벤트도 추가할 수 있다. (버튼을 눌렀을 때 액션이 나오도록 설정..)
		btns[0].addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int random = (int)(Math.random() * 10 + 2);
				for (int i = 1; i < random; ++i) {
					System.err.print("왜 눌러?");
				}
				System.err.println();
			}
		});
		
		// 4. 버튼 비활성화
		btns[4].setEnabled(false);

				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(900, 300);
		setSize(300, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S03_JButton();
	}

}
