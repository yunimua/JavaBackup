package gui;

import java.awt.*;

import javax.swing.*;

public class StudyFrame extends JFrame {

	public void setDefaultOptions() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 프레임 닫기시 종료 설정
		setLocation(new Point(900,100)); // 프레임 출력 위치 설정
		setSize(new Dimension(500,500)); // 프레임 크기설정
		setVisible(true); // 설정된 대로 프레임을 출력설정(true:보이게, false:안보이게)
	}
}
