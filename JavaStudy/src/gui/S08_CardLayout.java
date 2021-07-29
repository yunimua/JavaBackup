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

	// ��ǻ�� ī��̱�� ���� ���̾ƿ�.. (3��¥����, �г��� 3�� �ٿ��� ����)
	public S08_CardLayout() {
		super();
		
		// CardLayout : ������Ʈ�� ī��ó�� �ѱ�鼭 ����ϴ� ���̾ƿ�
		JPanel card_panel = new JPanel(new CardLayout(10,10)); // �гο� ���̾ƿ����� ī�� ���̾ƿ��� �־����
		
		ArrayList<ImageIcon> icons = new ArrayList<>();
		ArrayList<ImageIcon> icons3 = new ArrayList<>();
		
		BufferedImage image;
		try {
			image = ImageIO.read(new File("./image/cats/cat9.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			image = null;
		}
		
		// �̹��� ũ������ : 1���� �̹����� 3������ �߰���
		icons.add(new ImageIcon(image.getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
		icons.add(new ImageIcon(image.getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
		icons.add(new ImageIcon(image.getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
		
		// �� �ٸ� �̹��� 5���� �߰���
		icons3.add(new ImageIcon("./image/cats/cat8.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat6.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat5.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat4.jpg"));
		icons3.add(new ImageIcon("./image/cats/cat3.jpg"));
		
		JPanel panel1 = new ImagePanel(icons);
		JPanel panel2 = new JPanel();
		JPanel panel3 = new ImagePanel(icons3);
		JButton south_btn = new JButton("next card!");
		
		// ī�� ���̾ƿ��� ����� ���� name�� �����ϰ� ���ȴ�.
		card_panel.add("card1", panel1);
		card_panel.add("card2", panel2);
		card_panel.add("card3", panel3);
		
		add(card_panel, "Center");
		add(south_btn, "South");
		
		/*
			CardLayout.naxt() 		: ���� ī�� ����
			CardLayout.previous() 	: ���� ī�� ����
			CardLayout.first() 		: �� ó�� ī�� ����
		*/
		
		south_btn.addActionListener(new ActionListener() { // south_btn��ư�� �׼Ǹ����ʸ� �����Ѵ�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ش� �г� �Ǵ� �����ӿ� ���ǵ� ���̾ƿ��� ������ ����� ���� �ִ�. (�гο� ���ѵ�������)
				CardLayout card_layout = ((CardLayout)card_panel.getLayout()); // ((CardLayout)card_panel.getLayout()): �ٿ�ĳ����
				
				card_layout.next(card_panel); // card_layout�� �θ�� card_panel
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		S08_CardLayout frame = new S08_CardLayout();
		frame.setDefaultOptions();
	}
}
