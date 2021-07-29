package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.myhandler.*;

public class S04_ActionListener extends JFrame {
	
	public S04_ActionListener() {
		super();
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		JLabel label = new JLabel("I am Label");
		
		btns.add(new JButton());
		btns.add(new JButton());
		btns.add(new JButton());
		btns.add(new gui.mycomponent.MyButton()); //+ 버튼 컨테이너를 추가

		btns.get(0).setText("one");
		btns.get(0).setFont(new Font("궁서체", Font.PLAIN, 25));
		
		btns.get(1).setText("Two");
		btns.get(2).setText("Three");

		
		add(btns.get(0), "Center");
		add(btns.get(1), "East");
		add(btns.get(2), "West");
		add(btns.get(3), "South");
		add(label); // 라벨을 프레임에 더하면 텍스트가 노출된다
		
		// ActionListener를 상속받은 MyButtonEventHandler2를 가져다 써도됨
		// btns.get(0).addActionListener(new MyButtonEventHandler2());
		
		// ActionListener를 바로 상속받아 사용할 수 있음
		// ActionListener를 추가한 컴포넌트는 무언가 이벤트가 발생할 때 마다 actionPerformed 메서드를 호출한다
		btns.get(0).addActionListener(new ActionListener() {
			// btns.get(0) 을 누르면 아래의 텍스트로 바뀜
			@Override
			public void actionPerformed(ActionEvent e) {
				btns.get(1).setText("바꿔버림"); // 버튼 0번을 눌렀을 때 1번의 글자를 바꿔버림
				label.setText("ABC"); // 라벨은 액션리스터를 사용할 수 없기 때문에 변경되지 않는다.
			}
		});

		int count = 0;
		btns.get(1).addMouseWheelListener(new MouseWheelListener() {// MouseWheelListener 인스턴스 생성
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				btns.get(1).setText("" + count);// 변수의 생명주기때문에?
			}
		});
		
		setLocation(900, 200); //+ 현재 모니터에서 출력되는 위치를 설정
		setSize(300, 250); // 출력되는 팝업의 크기를 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 팝업 닫힐때 종료
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S04_ActionListener();
	}
}
