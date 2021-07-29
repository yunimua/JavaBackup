package gui.quiz.puzzle;

import java.awt.*;

import javax.swing.*;

public class PuzzleTile extends JPanel {
	
	private String tileNumber;

	public PuzzleTile(int number) {
		super();
		if (number == 0) {
			this.setBackground(Color.white);
		}else {
			this.setBackground(Color.darkGray);
		}
		this.tileNumber = "" + number;
	}
	
	public String getNumber() {
		return this.tileNumber;
	}
	
	public void setNumber(String s){
		this.tileNumber = s;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // ��׶���� �׷��̸� ����, �θ����� ����������
		g.setColor(Color.white); // ���ڰ� ǥ�õǴ� �÷��� ȭ��Ʈ
		Font myFont = new Font("Arial", Font.BOLD, 30); // ����ü, ���ڵβ���, 30����ũ��
		g.setFont(myFont); // set the font of the string on the tile.
		FontMetrics a = g.getFontMetrics();
		int heigh = a.getHeight();
		int wid = a.stringWidth(tileNumber);
		g.drawString(tileNumber,(getWidth()-wid)/2,(getHeight()/2+heigh/2)); // set the string in the center of the tile.
		this.setBorder(BorderFactory.createLineBorder(Color.white)); // set the border.
	}
}
