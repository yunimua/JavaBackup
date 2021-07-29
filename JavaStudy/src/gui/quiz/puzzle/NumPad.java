package gui.quiz.puzzle;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.imageio.*;
import javax.swing.*;

public class NumPad extends JButton implements ActionListener {
	
	List<JButton> numPads;
	
	int index;
	int left;
	int right;
	int top;
	int bottom;

	
	public NumPad(int index, int gameSize, List<JButton> numPads) throws IOException { 
		this.numPads = numPads;
		this.index  = index;
		this.top 	= index - gameSize >= 0 ? index - gameSize : -1; // 0보다는 커야한다, -1은 유효하지 않은 값을 표시하기위함
		this.bottom = index + gameSize < gameSize * gameSize ? index + gameSize : -1;
		this.left 	= index % gameSize != 0 ? index - 1 : -1; // 0,4,8,12는 좌가(왼쪽) 없다. 인덱스가 11일때 게임사이즈4로 나머지를 구하면 0이되지않는다
		this.right	= index % gameSize != gameSize - 1  ? index + 1 : -1; // 인덱스 4일때 나머지가 4-1(3)이되어 같지 않을 경우 경우 +1을 한다. 
		
		if (index == gameSize * gameSize - 1) {
			setText("");
		}else {
			setText("" + (index + 1));
		}

		setFont(new Font("Snap ITC", Font.ITALIC|Font.BOLD, 11));
//		setForeground(new Color(0x8181F7));
//		setBackground(new Color(0xE3CEF6));
		addActionListener(this);
		
		// gameSize가 4일때, 인덱스가 4면 -4가 0이되고, 8이면 4가된다..
		/*
			 0   1   2   3
			 4   5   6   7
			 8   9  10  11
			12  13  14  15 
		*/
	}

	private boolean isBlank(int index) {
		return numPads.get(index).getText().equals("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (top != -1 && isBlank(top)) {
			numPads.get(top).setText(this.getText());
			this.setText("");
		}else if (bottom != -1 && isBlank(bottom)) {
			numPads.get(bottom).setText(this.getText());
			this.setText("");
		}else if (left != -1 && isBlank(left)) {
			numPads.get(left).setText(this.getText());
			this.setText("");
		}else if (right != -1 && isBlank(right)) {
			numPads.get(right).setText(this.getText());
			this.setText("");
		}

		if (numPads.get(numPads.size() - 1).getText().equals("")) {
			boolean win = true;
			
			for (int i = 1, size = numPads.size(); i < size; ++i) {
				if (!numPads.get(i - 1).getText().equals("" + i)) {
					win = false;
					break;
				}
			}
			System.out.println("win : " + win);
		}
	}
}
