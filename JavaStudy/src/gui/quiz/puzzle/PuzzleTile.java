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
		super.paintComponent(g); // 백그라운드는 그레이를 유지, 부모한테 물려받은것
		g.setColor(Color.white); // 숫자가 표시되는 컬러는 화이트
		Font myFont = new Font("Arial", Font.BOLD, 30); // 글자체, 글자두껍게, 30글자크기
		g.setFont(myFont); // set the font of the string on the tile.
		FontMetrics a = g.getFontMetrics();
		int heigh = a.getHeight();
		int wid = a.stringWidth(tileNumber);
		g.drawString(tileNumber,(getWidth()-wid)/2,(getHeight()/2+heigh/2)); // set the string in the center of the tile.
		this.setBorder(BorderFactory.createLineBorder(Color.white)); // set the border.
	}
}
