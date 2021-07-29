package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

import gui.mypanel.*;

public class S08_CardLayout extends StudyFrame {

	// 컴퓨터 카드뽑기와 같은 레이아웃.. (3개짜리면, 패널을 3개 붙여서 쓴다)
	public S08_CardLayout() {
		super();
		
		// CardLayout : 컴포넌트를 카드처럼 넘기면서 사용하는 레이아웃
		JPanel card_panel = new JPanel(new CardLayout(10,10)); // 패널에 레이아웃으로 카드 레이아웃을 넣어놨다
		
		ArrayList<ImageIcon> icons = new ArrayList<>();
		ArrayList<ImageIcon> icons3 = new ArrayList<>();
		
		BufferedImage image;
		try {
			image = ImageIO.read(new File("./image/cats/cat9.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			image = null;
		}
		
		// 이미지 크기조정 : 1개의 이미지를 3가지로 추가함
		icons.add(new ImageIcon(image.getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
		icons.add(new ImageIcon(image.getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
		icons.add(new ImageIcon(image.getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
		
		// 다 다른 이미지 5장을 추가함
		icons3.add(new ImageIcon("./image/cats/cat8.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat6.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat5.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat4.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat3.jpg"));
		
		JPanel panel1 = new ImagePanel(icons);
		JPanel panel2 = new JPanel();
		JPanel panel3 = new ImagePanel(icons3);
		JButton south_btn = new JButton("next card!");
		
		// 카드 레이아웃을 사용할 때는 name이 유용하게 사용된다.
		card_panel.add("card1", panel1);
		card_panel.add("card2", panel2);
		card_panel.add("card3", panel3);
		
		add(card_panel, "Center");
		add(south_btn, "South");
		
		/*
			CardLayout.naxt() 		: 다음 카드 보기
			CardLayout.previous() 	: 이전 카드 보기
			CardLayout.first() 		: 맨 처음 카드 보기
		*/
		
		south_btn.addActionListener(new ActionListener() { // south_btn버튼에 액션리스너를 설정한다
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 해당 패널 또는 프레임에 정의된 레이아웃을 꺼내서 사용할 수도 있다. (패널에 국한되지않음)
				CardLayout card_layout = ((CardLayout)card_panel.getLayout()); // ((CardLayout)card_panel.getLayout()): 다운캐스팅
				
				card_layout.next(card_panel); // card_layout의 부모는 card_panel
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		S08_CardLayout frame = new S08_CardLayout();
		frame.setDefaultOptions();
	}
}
