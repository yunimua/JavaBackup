package gui;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import gui.myhandler.*;

public class S07_GridLayout extends StudyFrame {
	
	public S07_GridLayout() {
		super();
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		// 2�� �̻��� ���̾ƿ��� ����ϰ� �ʹٸ� JPanel�� �̿��Ѵ�
		setLayout(new BorderLayout());
		
		// JPanel�� �ٸ� ���̾ƿ��� ������ �� �ִ� ���ο� ���̴�
		JPanel center_panel = new JPanel();
		JButton south_button = new JButton("Generate Color");
		
		add(center_panel, "Center");
		add(south_button, "South");
		
		center_panel.setLayout(new GridLayout(4, 4)); // �г����� ���̾ƿ��� �ø��� : 4�� 4ĭ, 1ĭ�� ��»���
		//setLayout(new GridLayout(5, 3)); //(��, ��) �� ����(1)
		
		for (int i = 0; i < 15; ++i) {
			JButton btn = new JButton("Button" + i); // ��ư 15���� ����
			btns.add(btn); // ��ư�� �߰���
			
			//btn.setBackground(new Color((int)(Math.random() * 0xFFFFFF))); // ������ �������� ��ư ������ �����ȴ�(2)
			center_panel.add(btn); //�гο� ��ư�� �ø�
			//add(btn);(1)
		}
		// generateColor(); //(2)
		// ���⿡ �̺�Ʈó���� �ϴ� ���� �׸� ���� �ʴ�..
		// ȭ���� �����ϴ� �ڵ�� ������(����) ó���ϴ� �ڵ�� �и��ϴ� ���� ����
		south_button.addActionListener(new GenerateColorHandler(btns));
		south_button.doClick(); // ��ư�� ���α׷������� Ŭ���Ѵ�. => ��ư�� Ŭ���Ҷ����� �����ϰ� ������ ���Ѵ�, �̰� �ּ�ó���ϸ� ������� ���·� ���� ���
	}
	
//	private void generateColor() { //GenerateColorHandler���� �Ȱ��..(2)
//		for (JButton btn : btns) {
//			btn.setBackground(new Color((int)(Math.random() * 0xFFFFFF)));
//		}
//	}

	public static void main(String[] args) {
		S07_GridLayout frame = new S07_GridLayout();
		frame.setDefaultOptions();
	}
}
