package gui.quiz.posDefault;

import java.awt.*;

import javax.swing.*;

import gui.quiz.maple.*;

public class Pos_DefaultSize extends JFrame {
	
	public void setDefaultSize() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 프레임 닫기시 종료 설정
		setLocation(new Point(100,100)); // 프레임 출력 위치 설정
		setSize(new Dimension(900,900)); // 프레임 크기설정
		setVisible(true); // 설정된 대로 프레임을 출력설정(true:보이게, false:안보이게)
	}
}
