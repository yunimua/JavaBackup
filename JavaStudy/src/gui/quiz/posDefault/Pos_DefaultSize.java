package gui.quiz.posDefault;

import java.awt.*;

import javax.swing.*;

import gui.quiz.maple.*;

public class Pos_DefaultSize extends JFrame {
	
	public void setDefaultSize() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ������ �ݱ�� ���� ����
		setLocation(new Point(100,100)); // ������ ��� ��ġ ����
		setSize(new Dimension(900,900)); // ������ ũ�⼳��
		setVisible(true); // ������ ��� �������� ��¼���(true:���̰�, false:�Ⱥ��̰�)
	}
}
