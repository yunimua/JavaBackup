package gui.quiz.GridPuzzle;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import gui.quiz.*;

public class ImageNumPadAction implements ActionListener{

	int left;
	int right;
	int top;
	int bottom;
	
	NumPad numpad;
	List<JButton> numpads;
	
	
	public ImageNumPadAction(NumPad numpad) {
		this.numpad = numpad;
		this.numpads = numpad.numPads;
				
		int index = numpad.index;
		int gameSize = numpad.gameSize;
		
		this.top 	= index - gameSize >= 0 ? index - gameSize : -1; 
		this.bottom = index + gameSize < gameSize * gameSize ? index + gameSize : -1;
		this.left 	= index % gameSize != 0 ? index - 1 : -1;
		this.right	= index % gameSize != gameSize - 1  ? index + 1 : -1;
	}
	
	private boolean isBlank(int index) {
		return numpads.get(index).getIcon() == null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (top != -1 && isBlank(top)) {
			numpads.get(top).setIcon(numpad.getIcon());
			numpad.setIcon(null);
			
			numpads.get(top).setText("");
			numpad.setText("E");
			
		}else if (bottom != -1 && isBlank(bottom)) {
			numpads.get(bottom).setIcon(numpad.getIcon());
			numpad.setIcon(null);
			
			numpads.get(bottom).setText("");
			numpad.setText("E");
			
		}else if (left != -1 && isBlank(left)) {
			numpads.get(left).setIcon(numpad.getIcon());
			numpad.setIcon(null);
			
			numpads.get(left).setText("");
			numpad.setText("E");
			
		}else if (right != -1 && isBlank(right)) {
			numpads.get(right).setIcon(numpad.getIcon());
			numpad.setIcon(null);
			
			numpads.get(right).setText("");
			numpad.setText("E");
		}
	}
}
