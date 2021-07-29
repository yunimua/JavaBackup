package gui.quiz.GridPuzzle;

import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

public class NumPad extends JButton implements ActionListener {
	
	List<JButton> numPads;
	BufferedImage image;
	int index;
	int gameSize;
	
	int left;
	int right;
	int top;
	int bottom;
	
	
	public NumPad(int index, int gameSize, List<JButton> numPads, BufferedImage image) { 
		this.gameSize = gameSize;
		this.image  = image;
		this.numPads = numPads;
		this.index  = index;
		this.top 	= index - gameSize >= 0 ? index - gameSize : -1; 
		this.bottom = index + gameSize < gameSize * gameSize ? index + gameSize : -1;
		this.left 	= index % gameSize != 0 ? index - 1 : -1;
		this.right	= index % gameSize != gameSize - 1  ? index + 1 : -1;
		
		if (index == gameSize * gameSize - 1) {
			setText("E");
		}else {
			setIcon(new ImageIcon(getNumpadImage()));
		}
		
		setFont(new Font("Snap ITC", Font.ITALIC|Font.BOLD, 55));
		// addActionListener(this); // 액션리스너를 포함해둔 상태에서는 this를 사용
		addActionListener(new ImageNumPadAction(this));

	}
	private BufferedImage getNumpadImage() {
		int x = index % gameSize;
		int y = index / gameSize;
		int width = 700 / gameSize;
		int height = width;
		return image.getSubimage(x * width, y * height, width, height);
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
