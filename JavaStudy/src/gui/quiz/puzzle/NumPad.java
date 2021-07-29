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
		this.top 	= index - gameSize >= 0 ? index - gameSize : -1; // 0���ٴ� Ŀ���Ѵ�, -1�� ��ȿ���� ���� ���� ǥ���ϱ�����
		this.bottom = index + gameSize < gameSize * gameSize ? index + gameSize : -1;
		this.left 	= index % gameSize != 0 ? index - 1 : -1; // 0,4,8,12�� �°�(����) ����. �ε����� 11�϶� ���ӻ�����4�� �������� ���ϸ� 0�̵����ʴ´�
		this.right	= index % gameSize != gameSize - 1  ? index + 1 : -1; // �ε��� 4�϶� �������� 4-1(3)�̵Ǿ� ���� ���� ��� ��� +1�� �Ѵ�. 
		
		if (index == gameSize * gameSize - 1) {
			setText("");
		}else {
			setText("" + (index + 1));
		}

		setFont(new Font("Snap ITC", Font.ITALIC|Font.BOLD, 11));
//		setForeground(new Color(0x8181F7));
//		setBackground(new Color(0xE3CEF6));
		addActionListener(this);
		
		// gameSize�� 4�϶�, �ε����� 4�� -4�� 0�̵ǰ�, 8�̸� 4���ȴ�..
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
