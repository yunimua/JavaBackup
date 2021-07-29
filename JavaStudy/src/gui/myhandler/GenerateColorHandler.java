package gui.myhandler;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class GenerateColorHandler implements ActionListener { // �������̽��� ������..

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
		generateColor(); // ��ư�� Ŭ���Ҷ�(�׼�) ���� ������ �ٲ�� ����
	}
}
