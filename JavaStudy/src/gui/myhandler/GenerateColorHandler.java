package gui.myhandler;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class GenerateColorHandler implements ActionListener { // 인터페이스를 구현한..

	ArrayList<JButton> btns;
	
	public GenerateColorHandler(ArrayList<? extends JButton> btns) {
		this.btns = (ArrayList<JButton>) btns; 
	}
	
	private void generateColor() {
		for (JButton btn : btns) {
			btn.setBackground(new Color((int)(Math.random() * 0xFFFFFF)));
			btn.imageUpdate(null, 0, 0, 0, 0, 0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		generateColor(); // 버튼을 클릭할때(액션) 마다 색상이 바뀌도록 설정
	}
}
