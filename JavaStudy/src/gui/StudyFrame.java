package gui;

import java.awt.*;

import javax.swing.*;

public class StudyFrame extends JFrame {

	public void setDefaultOptions() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ������ �ݱ�� ���� ����
		setLocation(new Point(900,100)); // ������ ��� ��ġ ����
		setSize(new Dimension(500,500)); // ������ ũ�⼳��
		setVisible(true); // ������ ��� �������� ��¼���(true:���̰�, false:�Ⱥ��̰�)
	}
}
